#!/bin/bash
export REGISTRY_PORT=52732
export REGISTRY_HOST=localhost
export CHUNKSIZE=16 # pequeño para las pruebas
./ejecuta.sh Test > /tmp/TRAZA
