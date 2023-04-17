#!/bin/bash
CMADRID_OSM=cmadrid.osm
MADRID_OSM=madrid.osm
SPAIN_OSM=spain-latest.osm.bz2

echo "Empezando pipelines"
# El script de instalación para tener el osm convert, el osmfilter y el osm comprimido de España
if [ ! -f osmconvert ] || [ ! -f osmfilter ] || [ ! -f $SPAIN_OSM ]; then
    echo "Descargando dependencias y datos necesarios"
    ./script_instalacion.sh
fi

# Pipeline 1
# 1: Generamos el osm de la comunidad de madrid usando el osmconvert y dandole poly que limita la comunidad esto genera el archivo madriles.osm
# Esto se podría pipear al siguiente comando pero es un proceso que lleva un rato, así que lo ponemos por separado
echo "Empezando pipeline 1"
if [ ! -f "$CMADRID_OSM" ]; then
    echo "Convirtiendo el osm de España al de la Comunidad de Madrid, esto puede llevar unos minutos..."
    bzcat $SPAIN_OSM | ./osmconvert - -B=comunidad_de_madrid.poly -o=$CMADRID_OSM
    echo "Terminado"
fi

# Paso 2:
# sqlite3 madrid.db < db1.sql
# Creamos la base de datos llamada madrid.db y le damos el archivo sql donde creamos la tabla donde se guardarán los datos
# ./osmfilter $CMADRID_OSM --ignore-dependencies --keep="name!=null and amenity=cafe or amenity=pub or amenity=bar or amenity=restuarant"
# Usamos el osfilter sobre el osm de madrid dándole --ignore-dependencies para quedarnos solo con los objetos de tipo dato
# y olvidarnos de los de tipo nodo que se quedarian.  Le damos como parámetro --keep con los tags que buscamos
# |
# ./osmconvert - --all-to-nodes --csv="@id @lon @lat name opening_hours" --csv-separator=, --csv-headline
# Esto lo pipeamos a osmconvert con el flag '--all-to-nodes' sirve para pasar los datos a nodos (que son de un tipo distinto a los anteriores),
# le decimos que queremos un csv con '--csv' seguido de las columnas que lo componen (id, lon, lat, name, opening_hours)
# Por defecto se separa cada columna por tabuladores \t, asi que le pasamos la opción de darle que nos lo separe por comas con '-csv-separator=,'
# |
# grep -Pv "\d{8,10},-\d.\d{7},\d\d.\d{7},," 
# Como el resultado puede llegar a tener entradas que no tienen campo de nombre usamos grep con una expresión regular en formato Perl mediante el
# flag '-P', seguido de la expresión que coge todas las lineas sin nombre, al darle la opcion -v grep coge el resto de cosas que no concuerdan con esto
# que es lo que buscamos
# |
# tail +2
# Para saltarse la primera linea
# |
# sqlite3 -separator , madrid.db ".import '|cat -' madrid1"
# Finalmente pipeamos el reusltado a la bbdd, que es sqlite3 que mediante el flag '-separator ,' le decimos que los campos que va a recibir están separados
# por comas, le decimos la bbdd que vamos a usar que es el archivo madrid.db, y finalmente le damos el argumento '.import' que es propio de sqlite3
# seguido de la subexpresión 'cat -' para que use el stream que se le pasa por el pipe. Esto finalmente inserta los valores en la tabla especificada 'madrid1'.
echo "Ejecutando pipeline 1"
sqlite3 madrid.db <db1.sql && ./osmfilter $CMADRID_OSM --ignore-dependencies --keep="amenity=cafe or amenity=pub or amenity=bar or amenity=restuarant" | ./osmconvert - --all-to-nodes --csv="@id @lon @lat name opening_hours" --csv-separator=, --csv-headline | grep -Pv "\d{8,10},-\d.\d{7},\d\d.\d{7},," | tail +2 | sqlite3 -separator , madrid.db ".import '|cat -' madrid1"
echo "Éxito, datos insertados en la tabla madrid1 en la base de datos madrid.db en el directorio actual"
# Pipeline 2:
echo "Empezando pipeline 2"
if [ ! -f "$MADRID_OSM" ]; then
    echo "Convirtiendo el osm de la Comunidad de Madrid al de la ciudad de Madrid"
    ./osmconvert $CMADRID_OSM -B=ciudad_de_madrid.poly -o=$MADRID_OSM
fi
echo "Ejecutando pipeline 2"
cat db2.sql | sqlite3 madrid.db && ./osmfilter $MADRID_OSM --ignore-dependencies --keep="amenity=restaurant and cuisine=mexican or cuisine=peruvian or cuisine=italian" | ./osmconvert - --all-to-nodes --csv="@id @lon @lat name opening_hours website phone" --csv-separator=, --csv-headline | grep -Pv "\d{8,10},-\d.\d{7},\d\d.\d{7},(.\S?)," | tail +2 | sqlite3 -separator , madrid.db ".import '|cat -' madrid2"
echo "Éxito, datos insertados en la tabla madrid2 en la base de datos madrid.db en el directorio actual"
