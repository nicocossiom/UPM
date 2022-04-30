# PRACTICA INTELIGENCIA ARTIFICIAL - GRUPO 53
# MODULO GENERADOR DE DATOS

from geopy.geocoders import Nominatim


class StationManager:
    locator = Nominatim(user_agent="telmove@gmx.com")
    stations = []

    @staticmethod
    def populate():

        # Trunca el fichero de texto
        datfile = open("datos.txt", "w")
        datfile.write("")
        datfile.close()
        # AQUI VAN LOS NOMBRES Y NUMEROS DE LAS ESTACIONES

        # LINEA 1 ROJA (18 estaciones)
        StationManager.stations.append(Station(110, "Akademmistechko"))
        StationManager.stations.append(Station(111, "Zhytomyrska"))

        # LINEA 2 AZUL (18 estaciones)
        StationManager.stations.append(Station(210, "Heroiv Dnipra"))

        # LINEA 3 VERDE (16 estaciones)
        StationManager.stations.append(Station(310, "Syrets"))

        # Escribir en el fichero de texto
        for stat in StationManager.stations:
            stat.writeCoords()

    # Lee las estaciones desde archivo
    @staticmethod
    def read():
        datfile = open("datos.txt", "r")
        statlines = datfile.readlines()
        for curline in statlines:
            split = curline.split('+')
            num = split[0]
            nam = split[1]
            latit = split[2]
            longit = split[3]
            stat = Station(int(num), nam)
            stat.lat = float(latit)
            stat.lon = float(longit)
            StationManager.stations.append(stat)
            StationManager.statmap[num] = stat


class Station:
    # Constructor de la clase estación
    def __init__(self, stnumber, stname):
        self.name = stname
        self.number = stnumber
        self.lat = 0.0
        self.long = 0.0

    # Busca latitud y longitud para cada estacion
    def writeCoords(self):
        datfile = open("datos.txt", "a")
        wrstring = str(self.number) + "+" + self.name
        querytext = self.name + " station, Kyiv"
        curLoc = StationManager.locator.geocode(querytext)
        wrstring = wrstring + "+" + str(curLoc.latitude) + "+" + str(curLoc.longitude) + "\n"
        self.lat = curLoc.latitude
        self.long = curLoc.longitude
        print(wrstring)
        datfile.write(wrstring)
        datfile.close()


# Funcion principal
if __name__ == '__main__':
    print("Generando datos... \n")
    StationManager.populate()
    print("Datos generados correctamente \n")
