import sys
import io
import folium  # pip install folium
from PyQt5.QtWidgets import QApplication, QWidget, QHBoxLayout, QVBoxLayout
from PyQt5.QtWebEngineWidgets import QWebEngineView
from PyQt5.uic.properties import QtWidgets
from vincenty import vincenty


class StationManager:
    stations = []
    statmap = {}

    # Lee las estaciones desde archivo
    @staticmethod
    def create():
        datfile = open("lib/datos", "r")
        statlines = datfile.readlines()
        for curline in statlines:
            split = curline.split('+')
            num = split[0]
            name = split[1]
            lat = split[2]
            long = split[3]
            station = Station(int(num), name, float(lat), float(long))
            StationManager.stations.append(station)
            StationManager.statmap[int(num)] = station

class Station:
    # Constructor de la clase estación
    def __init__(self, stnumber, stname, lat, long):
        self.name = stname
        self.number = stnumber
        self.lat = lat
        self.long = long

    def print(self) -> None:
        print(f"{self.name} | {self.number} | [{str(self.lat)}, {str(self.long)}]")

    # Devuelve la distancia en metros con otra estacion
    def calcDistance(self, other):
        here = (self.lat, self.long)
        there = (other.lat, other.long)
        return vincenty(here, there) * 1000.0

    # Devuelve las estaciones adyacentes en una lista
    def calcAdjacents(self):
        list = []

        # Calcula la linea de metro de la estacion actual
        stline = self.number // 100

        # Casos especiales 319 y 321 por falta de 320
        if self.number == 319:
            list.append(StationManager.statmap[318])
            list.append(StationManager.statmap[321])
        elif self.number == 321:
            list.append(StationManager.statmap[319])
            list.append(StationManager.statmap[322])

        # Casos especiales 312 y 314 por falta de 313
        elif self.number == 312:
            list.append(StationManager.statmap[311])
            list.append(StationManager.statmap[314])
        elif self.number == 314:
            list.append(StationManager.statmap[312])
            list.append(StationManager.statmap[315])
            list.append(StationManager.statmap[119])

        # Transbordo verde azul
        elif self.number == 218:
            list.append(StationManager.statmap[315])
            list.append(StationManager.statmap[217])
            list.append(StationManager.statmap[219])
        elif self.number == 315:
            list.append(StationManager.statmap[314])
            list.append(StationManager.statmap[218])
            list.append(StationManager.statmap[316])

        # Transbordo rojo verde
        elif self.number == 119:
            list.append(StationManager.statmap[118])
            list.append(StationManager.statmap[120])
            list.append(StationManager.statmap[314])

        # Transbordo rojo azul
        elif self.number == 217:
            list.append(StationManager.statmap[120])
            list.append(StationManager.statmap[216])
            list.append(StationManager.statmap[218])
        elif self.number == 120:
            list.append(StationManager.statmap[217])
            list.append(StationManager.statmap[119])
            list.append(StationManager.statmap[121])

        # Extremos
        elif self.number % 100 == 27:
            list.append(StationManager.statmap[stline * 100 + 26])
        elif self.number % 100 == 10:
            list.append(StationManager.statmap[stline * 100 + 11])

        # Demas estaciones
        else:
            list.append(StationManager.statmap[self.number + 1])
            list.append(StationManager.statmap[self.number - 1])

        return list


class MyApp(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle('Kiev-Metro Finder')
        self.window_width, self.window_height = 800, 400
        self.setMinimumSize(self.window_width, self.window_height)

        layout = QVBoxLayout()
        self.setLayout(layout)

        mapWidget = folium.Map(location=[50, 30], zoom_start=10, control_scale=True)
        for st in StationManager.stations:
            st.print()
            folium.Marker(location=[st.lat, st.long], fill_color="#e61b1b").add_to(mapWidget)

        # save map data to data object
        data = io.BytesIO()
        mapWidget.save(data, close_file=False)

        webView = QWebEngineView()
        webView.setHtml(data.getvalue().decode())
        layout.addWidget(webView)


# Funcion principal
if __name__ == '__main__':
    import gui

# app = QApplication(sys.argv)
# MainWindow = QtWidgets.QMainWindow()
#
# myApp = MyApp()
# myApp.show()
# try:
# 	sys.exit(app.exec_())
# except SystemExit:
# 	print('Closing Window...')
