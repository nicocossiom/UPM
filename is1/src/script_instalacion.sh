#!/bin/bash

# 1) Descarga de spain_latest.osm.bz2

SPAIN_OSM_BZ=spain-latest.osm.bz2
SPAIN_OSM=spain-latest.osm
ZIP_TOOL=bzip2

if [ ! -f "$SPAIN_OSM_BZ" ]; then
    echo "$SPAIN_OSM_BZ no existe, descargando ..."
    wget http://download.geofabrik.de/europe/spain-latest.osm.bz2
fi

# Se ha descargado el fichero, ahora toca comprobar si tenemos las herramientas

OSMFILTER=./osmfilter
OSMCONVERT=./osmconvert
CC=cc
if [ ! -f $OSMFILTER ]; then
    if ! type $CC; then
        echo "$CC no existe, descargando ..."
        sudo apt install gcc
    fi
    echo "$OSMFILTER no existe, descargando ..."
    wget -O - http://m.m.i24.cc/osmfilter.c | cc -x c - -O3 -o osmfilter
fi

# Comprobamos si tenemos osmconvert

if [ ! -f $OSMCONVERT ]; then
    echo "$OSMCONVERT no existe, descargando ..."
    wget -O - http://m.m.i24.cc/osmconvert.c | cc -x c - -lz -O3 -o osmconvert
fi

# Checking for errors
if [[ "$?" -ne 0 ]]; then
    echo 'Ha habido un error.'
    exit $rc
fi

# END
