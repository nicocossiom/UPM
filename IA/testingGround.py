import sys
import io
import folium  # pip install folium
from PyQt5.QtWidgets import QApplication, QWidget, QHBoxLayout, QVBoxLayout
from PyQt5.QtWebEngineWidgets import QWebEngineView
"""
Folium in PyQt5
"""
class MyApp(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle('Kiev-Metro Finder')
        self.window_width, self.window_height = 800, 400
        self.setMinimumSize(self.window_width, self.window_height)

        layout = QVBoxLayout()
        self.setLayout(layout)

        map = folium.Map(location=[50, 30], zoom_start=10, control_scale=True)
        stations = open("lib/datos").readlines()
        points = []
        for line in stations:
            line = line.replace("\n", "").split("+")
            stnumber = line[0]
            stname = line[1]
            lat = float(line[2])
            long = float(line[3])
            points.append([lat, long])
            print(points)
            apit = folium.Marker(location=[lat, long], fill_color="#e61b1b").add_to(map)

        # save map data to data object
        data = io.BytesIO()
        map.save(data, close_file=False)

        webView = QWebEngineView()
        webView.setHtml(data.getvalue().decode())
        layout.addWidget(webView)


if __name__ == '__main__':
    app = QApplication(sys.argv)
    app.setStyleSheet('''
        QWidget {
            font-size: 35px;
        }
    ''')

    myApp = MyApp()
    myApp.show()

    try:
        sys.exit(app.exec_())
    except SystemExit:
        print('Closing Window...')