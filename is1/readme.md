[Link Google Docs](https://docs.google.com/document/d/106bLMDqN1KPrlgiZEjGhWJ1xxfNO6nOeXhRHYjSrWlQ/edit)

# Trabajo de IS1

Todo el trabajo se encuentra en el directorio `src`. Hemos decidido empaquetar todo en un archivo ejecutable llamado
`pipelines.sh`. Dentro hay una serie de comprobaciones para ver si están todas las dependencias necesarias y si hay que descargarlas. Hemos hecho esto porque son archivos pesados que no podíamos adjuntar. A continuación listamos lo que hace el script.

## Modo de uso

Ejecutar el archivo `pipelines.sh` si se desea ejecutar todos los pipelines más la instalación de las dependencias necesarias, esto produce los siguiente efectos:

### Pre instalación de herramientas y descarga de los datos necesarios

Se ejecutará la siguiente sentencia:

```bash
CMADRID_OSM=madriles.osm
MADRID_OSM=madrid.osm
SPAIN_OSM=spain-latest.osm.bz2
if [ ! -f osmconvert] || [ ! -f osmfilter ] || [ ! -f $SPAIN_OSM]; 
then
    ./script_instalacion.sh
fi
```

Si no están los datos y herramientas necesarias estas se descargarán y compilarán usando el script `script_instalacion.sh`. Hace lo siguiente

1. Descarga el fichero .osm de España
2. Descarga y compila la herramienta `osmconvert`
3. Descarga y compila la herramienta `osmfilter`  

Todo esto lo pone en el directorio `src` para su uso.

### Pipeline 1

#### Conversión del osm de España al de la Comunidad de Madrid

Para ello se ejecutará el comando

```bash
if [ ! -f "$CMADRID_OSM" ]; then
    bzcat $SPAIN_OSM | ./osmconvert - -B=comunidad_de_madrid.poly -o=$CMADRID_OSM
fi
```

Que usa el archivo comprimido de España y lo convierte usando el la herramiento osmconvert junto con el fichero comunidad_de_madrid.poly para delimitar la región.

#### Ejecución del pipeline 1

El comando a ejecutar es el siguiente

```bash
sqlite3 madrid.db <db1.sql && ./osmfilter $CMADRID_OSM --ignore-dependencies --keep="amenity=cafe or amenity=pub or amenity=bar or amenity=restuarant" | ./osmconvert - --all-to-nodes --csv="@id @lon @lat name opening_hours" --csv-separator=, --csv-headline | grep -Pv "\d{8,10},-\d.\d{7},\d\d.\d{7},," | tail +2 | sqlite3 -separator , madrid.db ".import '|cat -' madrid1"
```

>Creamos la base de datos llamada madrid.db y le damos el archivo sql donde creamos la tabla donde se guardarán los datos  
>`sqlite3 madrid.db < db1.sql`

> Usamos el osfilter sobre el osm de madrid dándole `--ignore-dependencies` para quedarnos solo con los objetos de tipo dato
> y olvidarnos de los de tipo nodo que se quedarian.  Le damos como parámetro `--keep` con los tags que buscamos  
>`./osmfilter $CMADRID_OSM --ignore-dependencies --keep="name!=null and amenity=cafe or amenity=pub or amenity=bar or amenity=restuarant"`

> Esto lo pipeamos a osmconvert con el flag '--all-to-nodes' sirve para pasar los datos a nodos (que son de un tipo distinto a los anteriores),
> le decimos que queremos un csv con '--csv' seguido de las columnas que lo componen (id, lon, lat, name, opening_hours)
> Por defecto se separa cada columna por tabuladores \t, asi que le pasamos la opción de darle que nos lo separe por comas con '-csv-separator=,'  
> `./osmconvert - --all-to-nodes --csv="@id @lon @lat name opening_hours" --csv-separator=, --csv-headline`

> Como el resultado puede llegar a tener entradas que no tienen campo de nombre usamos grep con una expresión regular en formato Perl mediante el
> flag '-P', seguido de la expresión que coge todas las lineas sin nombre, al darle la opcion -v grep coge el resto de cosas que no concuerdan con esto
> que es lo que buscamos  
> `grep -Pv "\d{8,10},-\d.\d{7},\d\d.\d{7},,"`

> Para saltarse la primera línea  
> `tail +2`

> Finalmente pipeamos el reusltado a la bbdd, que es sqlite3 que mediante el flag '-separator ,' le decimos que los campos que va a recibir están separados por comas, le decimos la bbdd que vamos a usar que es el archivo madrid.db, y finalmente le damos el argumento '.import' que es propio de sqlite3 seguido de la subexpresión 'cat -' para que use el stream que se le pasa por el pipe. Esto finalmente inserta los valores en la tabla especificada 'madrid1'.  
`sqlite3 -separator , madrid.db ".import '|cat -' madrid1"`

### Pipeline 2

#### Conversión del osm de la Comunidad de Madrid a la ciudad de madrid

Para ello se ejecutará el comando

```bash
if [ ! -f "$MADRID_OSM" ]; then
    ./osmconvert $CMADRID_OSM -B=ciudad_de_madrid.poly -o=$MADRID_OSM
fi
```

Que usa el archivo comprimido de España y lo convierte usando el la herramiento osmconvert junto con el fichero ciudad_de_madrid.poly para delimitar la región.

#### Ejecución del pipeline 1

```bash
sqlite3 madrid.db <db1.sql && ./osmfilter $CMADRID_OSM --ignore-dependencies --keep="amenity=cafe or amenity=pub or amenity=bar or amenity=restuarant" | ./osmconvert - --all-to-nodes --csv="@id @lon @lat name opening_hours" --csv-separator=, --csv-headline | grep -Pv "\d{8,10},-\d.\d{7},\d\d.\d{7},," | tail +2 | sqlite3 -separator , madrid.db ".import '|cat -' madrid1"
```

El comando es parecido pero en vez de crear la base de datos lo que debemos hacer es darle a sqlite3 el fichero encargado de generar la tabla sobre la base de datos.  
También cambian los tags usados, buscando restaurantes y los distintos tipos de cocina dentro de estos. Además guardamos la web y el teléfono del local si es que lo tiene. Para filtrar los que no tienen nombre cambia un poco la expresión al haber más campos, pero el concepto es el mismo.
Por lo demás el funcionamiento es el mismo.
