# Instrucciones para ejecutar
## Aclaraciones 
Hemos realizado la parte del proyecto básico y el obligatoria. Cuando ejecute el programa se le preguntará qué opción quiere correr.

## Archivos necesarios
Clone el respositorio usando: \
`git clone ssh://git@middleware.fi.upm.es:1022/21_22_grupo10/PracticaJMS.git`\
Dirijase al directorio descargado y siga los siguientes pasos:\
Exporte la variable de entorno IMQ_JAVAHOME apuntando a la raiz de instalación de su JDK\
Corra este comando:
`./PracticaJMS/lib/bin/imqbrokerd -tty`
Abra otra terminal y corra el siguiente comando desde la carpeta donde ha descargado el proyecto:
`./PracticaJMS/src/makefile run_s run_r`\

## Explicación de los componentes
Los componentes java de la practica son: Banco, Server, TPV, y Transacción. La componente Banco representa la entidad global que se encarga de iniciar los Server (Threads), Server representan los servidores de cada región.
TPV es la componente que representa los Terminales de Pago encargados de leer y enviar las transacciones. Transaccion es la clase que representa una transaccioón, creada a partir de cada línea de los ficheros .txt
## Contenido del directorio raiz 
![Directorio raiz "src"](/lib/directorio.png)