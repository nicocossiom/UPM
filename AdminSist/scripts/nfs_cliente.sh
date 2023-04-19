#!/bin/bash

FORMATO_MANDATO="Uso: $0 servidor directorio_importado directorio_montaje..."
error() {
	echo "$1" >&2
	exit "$2"
}
run_checks() {
	test $(id -u) = 0 || error "$0 debe ejecutarse como root" 1
	# check if number of arguments is a multiple of 3
	if [ $# -lt 3 ] || [ $(($# % 3)) -ne 0 ]; then
		error "Numero de argumentos incorrecto $FORMATO_MANDATO" 2
	fi

	# check that the directories don't exist, if they do make sure theyre not files and are directories
	for I in $(seq 3 3 $#); do
		VAL=${!I}
		if [ -e "$VAL" ]; then
			test -d "$VAL" || error "Directorio \"$VAL\" no es un directorio" 3
		fi
	done

	# check that nfs-common is installed and install it if not
	dpkg -l | grep -q 'nfs-common' || (
		echo "No se encontró nfs-common" >&2
		echo "Instalando nfs-common" >&2
		apt-get -y install nfs-common
	)
}

run_checks "$@"
# loop through arguments by triplets
for ((i = 1; i <= $#; i += 3)); do
	servidor="${@:$i:1}"
	directorio_importado="${@:$i+1:1}"
	directorio_montaje="${@:$i+2:1}"
	mkdir -p "$directorio_montaje"
	mount -t nfs "$servidor:$directorio_importado" "$directorio_montaje"
	echo "$servidor:$directorio_importado $directorio_montaje nfs defaults 0 0" >>/etc/fstab
done
