#!/bin/bash

FORMATO_MANDATO="Uso: $0 VG num_discos disco... num_LV porcentaje directorio_montaje..."
error() {
	echo "$1" >&2
	exit "$2"
}
run_checks() {
	# comprueba que se ejecute como root
	test $(id -u) = 0 || error "$0 debe ejecutarse como root" 1

	# comprueba la sintaxis del mandato
	test "$2" -gt 0 &>/dev/null && POS=$(($2 + 3)) && test "${!POS}" -gt 0 &>/dev/null &&
		test $# -eq $((3 + $2 + ${!POS} * 2)) &>/dev/null || error "$FORMATO_MANDATO" 2

	# verify percentages are correct: numeric and sum no more than 100
	TOT=0
	POS=$((POS + 1))
	for I in $(seq $POS 2 $#); do
		VAL=${!I}
		test "$VAL" -gt 0 &>/dev/null || error "$FORMATO_MANDATO" 2 # no numérico
		TOT=$((TOT + VAL))
	done
	test $TOT -gt 100 &>/dev/null && error "suma de porcentajes por encima de 100" 3

	# check that disks passed as arguments exist
	DISCOS=$(lsblk -np --output NAME,TYPE)
	for I in "${@:3:$2}"; do
		test "$(echo "$DISCOS" | grep -c "$I")" -eq 1 || error "disco $I no existe" 4
	done

	# check that the directory of mnt does not exist
	for I in "${@:$(($POS + 1))}"; do
		if [ -e "$I" ]; then
			test -d "$I" || error "Directorio \"$I\" no es un directorio" 5
		fi
	done

	# check that lmv2 is installed and install it if not
	dpkg -l | grep -q 'lvm2' || (
		eecho "No se encontró lvm2" >&2
		echo "Instalando lvm2" >&2
		apt-get -y install lvm2
	)

	#check that volume group does not exist return error 7 if true
	test "$(vgdisplay | grep -c "$1")" -eq 0 || error "el grupo de volúmenes $1 ya existe" 7

}

l_vol_create() {
	# crea los LVs
	POS=2
	NUM_LV=0
	for I in $(seq $POS 2 $#); do
		VAL=${!I}
		((I++))
		MNT=${!I}
		lvcreate -l "$VAL%VG" "$VG_NAME" || error "error al crear el LV $MNT" 6
		test -d "$MNT" || mkdir -p "$MNT"
		mkfs.ext4 "/dev/$VG_NAME/lvol$NUM_LV" || error "error al formatear el LV $MNT" 7
		mount "/dev/$VG_NAME/lvol$NUM_LV" "$MNT" || error "error al montar el LV $MNT" 8
		echo "/dev/$VG_NAME/lvol$NUM_LV $MNT ext4 defaults 0 0" >>/etc/fstab
		((NUM_LV++))
	done
}

main() {
	run_checks "$@"
	vgcreate "$1" "${@:3:$2}" || error "error al crear el grupo de volúmenes" 4
	export VG_NAME="$1"
	l_vol_create "${@:3+$2}"
}

main "$@"
