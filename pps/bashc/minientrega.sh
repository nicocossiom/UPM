#! /bin/bash
#Solo aceptamos un argumento 
if  [ $# != 1 ] ; then
    echo "minientrega.sh: Error(EX_USAGE), uso incorrecto del mandato. \"Success\"" >&2
    echo "minientrega.sh+ Número de argumentos incorrecto" >&2
    exit 64
else 
    if [ $1 == "--help" ] || [ $1 == "-h" ]; then
        echo "minientrega.sh: Uso: $0 {nombre_archivo} o -h/--help para la ayuda"
        echo "minientrega.sh: Copia ficheros a entregar de un directorio a otro de entrega"
        exit 0
    fi
fi
#Directorio accesible?
if [ ! -d "$MINIENTREGA_CONF" ]; then   
    echo "minientrega.sh: Error, no se pudo realizar la entrega" >&2
    echo "minientrega.sh+ no es accesible el directorio \"$MINIENTREGA_CONF\"" >&2
    exit 64
fi

if [ ! -f "$MINIENTREGA_CONF/$1" ]; then
    echo "minientrega.sh: Error, no se pudo realizar la entrega" >&2
    echo "minientrega.sh+ no es accesible el fichero \"$1\"" >&2
    exit 66
fi    

#Cogemos las variables de entorno dentro del fichero
source $MINIENTREGA_CONF/$1

for file in $MINIENTREGA_FICHEROS; do
    if [ ! -r "$file" ]; then 
    echo "minientrega.sh: Error, no se pudo realizar la entrega" >&2
    echo "minientrega.sh+ no es accesible el fichero \"$MINIENTREGA_FICHEROS\"" >&2
    exit 66
    fi
done

if [ ! -d  $MINIENTREGA_DESTINO ] || ! mkdir -p "$MINIENTREGA_DESTINO/${USER}" > /dev/null 2>&1 ; then
    echo "minientrega.sh: Error, no se pudo realizar la entrega"
    echo "minientrega.sh+ no se pudo crear el subdirectorio de entrega en \"$MINIENTREGA_DESTINO\""
    exit 73
fi

#Hacemos copia en bulk de los ficheros al destino*USER
cp $MINIENTREGA_FICHEROS "${MINIENTREGA_DESTINO}/${USER}"
exit 0

 

