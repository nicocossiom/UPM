#!/bin/bash

FORMATO_MANDATO="Uso: $0 hosts_permitidos permisos directorio_exportado..."
error() {
	echo "$1" >&2
	exit "$2"
}

run_checks() {
	test "$(id -u)" = 0 || error "$0 debe ejecutarse como root" 1
	# check if number of arguments is a multiple of 3
	if [ $# -lt 3 ] || [ $(($# % 3)) -ne 0 ]; then
		error "Numero de argumentos incorrecto $FORMATO_MANDATO" 2
	fi
	# permissions are "rw" or "ro"
	for I in $(seq 2 3 $#); do
		VAL=${!I}
		test "$VAL" = "rw" || test "$VAL" = "ro" || error "Permisos incorrectos \"$VAL\", $FORMATO_MANDATO" 2
	done
	# directories exist
	for I in $(seq 3 3 $#); do
		VAL=${!I}
		test -d "$VAL" || error "Directorio \"$VAL\" no existe" 3
	done

	# check that nfs-server is installed and install it if not (dpkg -l | grep nfs-kernel-server)
	dpkg -l | grep -q 'nfs-kernel-server' || (
		echo "No se encontró nfs-kernel-server" >&2
		echo "Instalando nfs-kernel-server" >&2
		apt-get -y install nfs-kernel-server
	)
}

run_checks "$@"
# loop through arguments by triplets
for ((i = 1; i <= $#; i += 3)); do
	host="${@:$i:1}"
	permission="${@:$i+1:1}"
	directory="${@:$i+2:1}"
	if [ "$host" == "0" ]; then
		host="*"
	fi
	export_line="$directory $host($permission)"
	# directory is not already exported
	grep -Fq "$export_line" /etc/exports || echo "$export_line" >>/etc/exports
	exportfs -ra &>/dev/null
done
# just in case the service is not running
systemctl status nfs-server 2 &>/dev/null
