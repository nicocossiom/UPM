<!--
 Copyright (c) 2022 "Nicolas Cossio Miravalles"
 
 This software is released under the MIT License.
 https://opensource.org/licenses/MIT
-->

# Instalación para Windows

## Instalación usando Conda (Anaconda)

> Descargar Anaconda desde la página oficial: <https://www.anaconda.com/products/distribution>

##  Instalación de los paquetes necesarios

> Abrir la consola de comandos y ejecutar los siguientes comandos:

```shell
conda create --name py3106 python=3.10.6
conda actiate py3106
pip install --verbose --config-settings --confirm-license= --no-cache-dir pyqt5 
pip install --verbose --no-cache-dir -r requirements.txt
```

Tarda un rato en instalar. Cuando termine lanzar el programa:

```shell
python athens-metro.py
```
