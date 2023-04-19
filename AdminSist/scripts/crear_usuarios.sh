#!/bin/bash
PASSWD_MSG=""
error() {
	echo "$1" >&2
	echo "Valor de retorno: $2" >&2
	exit "$2"
}

run_checks() {
	## TODO quitar esto para el script final
	test "$(id -u)" = 0 || error "$0 debe ejecutarse como superusuario" 1

	# check that there's at least 2 arguments
	test $# -ge 2 || error "Uso: $0 <grupo> <usuario1> <usuario2> <...>" 2

	# check that there is no directory in /srv/$group
	test ! -d /srv/"$1" || error "No debe existir el directorio /srv/$1" 3

	# check that the group doesn't exist
	getent group "$1" >/dev/null && error "Ya existe el grupo $1" 4

	# check that the users don't exist
	for user in "$@"; do
		getent passwd "$user" >/dev/null && error "El usuario $user ya existe" 5
	done
}

create_group_dir_with_permissions() {
	mkdir /srv/"$1"           # create the group dir
	chown "$2":"$1" /srv/"$1" # user 1 is the owner of the group dir
	chgrp "$1" /srv/"$1"      # group
	umask 002                 # set the mask to 002
	sudo sed -i 's/UMASK.*/UMASK 002/' /etc/login.defs
	chmod 2775 -R /srv/"$1" # set the permissions for the group dir
}

create_users() {
	for user in "${@:2}"; do
		useradd -m "$user" -g "$1" -s /bin/bash
	done
}

check_open_ssl_installed() {
	# check that openssl is installed
	if [ "$(which openssl >/dev/null)" ]; then
		echo "No se encontró openssl" >&2
		echo "Instalando openssl" >&2
		apt-get -y install openssl
	fi
}

create_random_users_passwords() {
	check_open_ssl_installed
	for user in "${@:2}"; do
		pass="$user:$(openssl rand -base64 8)"
		# concatenate pass to PASSWD_MSG
		PASSWD_MSG="$PASSWD_MSG""$pass"
		if [ "$user" != "${@: -1}" ]; then
			PASSWD_MSG="$PASSWD_MSG""\n"
		fi
		echo "$pass" | chpasswd
	done
}

# add_users_to_group() {
# 	for user in "${@:2}"; do
# 		usermod -a -G "$1" "$user"
# 	done
# }

main() {
	run_checks "$@"
	groupadd "$1"
	create_users "$@"
	create_group_dir_with_permissions "$@"
	create_random_users_passwords "$@"
	echo -e "$PASSWD_MSG"
}

main "$@"
