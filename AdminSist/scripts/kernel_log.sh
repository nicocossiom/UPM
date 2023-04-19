#!/bin/bash

# ejemplo de script de configuración para depurar la fase 5
error() {
	echo "$1" >&2
	exit "$2"
}
test $(id -u) = 0 || error "$0 debe ejecutarse como root" 1

test $# -ne 1 && error "Uso: $0 num_lineas" 2

dmesg 2>/dev/null | tail -"$1"
