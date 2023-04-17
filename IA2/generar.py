# PRACTICA INTELIGENCIA ARTIFICIAL - GRUPO 53
# MODULO GENERADOR DE DATOS


class StationManager:
    stations = []

    @staticmethod
    def populate():

        # AQUI VAN LOS NOMBRES Y NUMEROS DE LAS ESTACIONES

        # LINEA 1 VERDE (24 estaciones)
        StationManager.stations.append(
            Station("Kifissia", 38.07385643019323, 23.808318614589922))
        StationManager.stations.append(
            Station("KAT", 38.0659336486569, 23.804010383001437))
        StationManager.stations.append(
            Station("Maroussi", 38.05659093938642, 23.805099963644096))
        StationManager.stations.append(
            Station("Nerantziotissa", 38.04480183493548, 23.79288259327658))
        StationManager.stations.append(
            Station("Irini", 38.0437671018159, 23.782684585819393))
        StationManager.stations.append(
            Station("Iraklio", 38.04650076083769, 23.76594969974314))
        StationManager.stations.append(
            Station("Nea Ionia", 38.04171917039145, 23.75520649167225))
        StationManager.stations.append(
            Station("Pefkakia", 38.03721224557235, 23.75018240932879))
        StationManager.stations.append(
            Station("Perissos", 38.03284461477259, 23.74480393111615))
        StationManager.stations.append(
            Station("Ano Patissia", 38.023747284475206, 23.73593361136169))
        StationManager.stations.append(
            Station("Aguios Eleftherios", 38.02009325536962, 23.731837212275494))
        StationManager.stations.append(
            Station("Kato Patissia", 38.01172647396838, 23.728782497037674))
        StationManager.stations.append(
            Station("Aghnos Nikolaos", 38.00708306424697, 23.727713337189968))
        StationManager.stations.append(
            Station("Attiki", 37.999452425129576, 23.72326099162105))
        StationManager.stations.append(
            Station("Victoria", 37.99306005735071, 23.730384744410507))
        StationManager.stations.append(
            Station("Omonia", 37.98414489917227, 23.728701201319836))
        StationManager.stations.append(
            Station("Monastiraki", 37.97611704022396, 23.725654127271522))
        StationManager.stations.append(
            Station("Tihissio", 37.97666541917069, 23.720700892863686))
        StationManager.stations.append(
            Station("Petralona", 37.968581898373486, 23.709250016710154))
        StationManager.stations.append(
            Station("Tavros", 37.962450113301585, 23.703378485980778))
        StationManager.stations.append(
            Station("Kallithea", 37.96034390796487, 23.69731216518474))
        StationManager.stations.append(
            Station("Moschato", 37.955012305727024, 23.679641918709134))
        StationManager.stations.append(
            Station("Faliro", 37.94494044568158, 23.665227450050075))
        StationManager.stations.append(
            Station("Piraeus", 37.948067478108996, 23.64320225319989))

        # LINEA 2 ROJA (14 estaciones)
        StationManager.stations.append(
            Station("Aghios Antonios", 38.00667455022093, 23.699472488771793))
        StationManager.stations.append(
            Station("Sepolia", 38.002720255839336, 23.713516903092273))
        StationManager.stations.append(
            Station("Attiki", 38.00037162103943, 23.721918201256614))
        StationManager.stations.append(
            Station("Larissa Station", 37.99215535853332, 23.72087559565062))
        StationManager.stations.append(
            Station("Metaxourgeio", 37.98757114895516, 23.721204839526195))
        StationManager.stations.append(
            Station("Omonia", 37.98454829460307, 23.728555935841044))
        StationManager.stations.append(
            Station("Panepistimio", 37.98096405786368, 23.732964122793707))
        StationManager.stations.append(
            Station("Syntagma", 37.97518502170901, 23.735469828985803))
        StationManager.stations.append(
            Station("Akropoli", 37.968991751292855, 23.729614459597105))
        StationManager.stations.append(
            Station("Syngrou-Fix", 37.964422115900796, 23.726537327130277))
        StationManager.stations.append(
            Station("Neos Kosmos", 37.957785365962614, 23.728451463613457))
        StationManager.stations.append(
            Station("Aghios Ioannis", 37.95677318816276, 23.73463724681745))
        StationManager.stations.append(
            Station("Dafni", 37.9493416275026, 23.737255861724822))
        StationManager.stations.append(
            Station("Aghios Dimitrios", 37.940685887537796, 23.7406894075894))

        # LINEA 3 AZUL (20 estaciones)
        StationManager.stations.append(
            Station("Egaleo", 37.992166443989625, 23.681972846777327))
        StationManager.stations.append(
            Station("Eleonas", 37.98796601720846, 23.694188982530385))
        StationManager.stations.append(
            Station("Kerameikos", 37.978748311385814, 23.71145266522074))
        StationManager.stations.append(
            Station("Monastiraki", 37.97716950270181, 23.724541079859396))
        StationManager.stations.append(
            Station("Syntagma", 37.9758840169342, 23.735334289525667))
        StationManager.stations.append(
            Station("Evangelismos", 37.976611334033976, 23.747307669957003))
        StationManager.stations.append(
            Station("Megaro Moussikis", 37.97960509842984, 23.752951038176672))
        StationManager.stations.append(
            Station("Ambelokipi", 37.987452578861216, 23.75702799592749))
        StationManager.stations.append(
            Station("Panormou", 37.993422190367646, 23.763379466621775))
        StationManager.stations.append(
            Station("Katehaki", 37.99324518845619, 23.776106736324994))
        StationManager.stations.append(
            Station("Ethniki Amyna", 38.00026156652406, 23.785879968077538))
        StationManager.stations.append(
            Station("Holargos", 38.00462076606339, 23.79479927093233))
        StationManager.stations.append(
            Station("Nomismatokopio", 38.0095219216595, 23.80574471536028))
        StationManager.stations.append(
            Station("Aghia Paraskevi", 38.017543594966604, 23.812353777975726))
        StationManager.stations.append(
            Station("Halandri", 38.02188578869339, 23.821259425868547))
        StationManager.stations.append(
            Station("Doukissis Plakentias", 38.02490104959176, 23.834400998070933))
        StationManager.stations.append(
            Station("Pallini", 38.006179152910896, 23.869534708049365))
        StationManager.stations.append(
            Station("Paiania-Kantza", 37.983899644112654, 23.869916555059998))
        StationManager.stations.append(
            Station("Koropi", 37.91315512898767, 23.89587290080042))
        StationManager.stations.append(
            Station("Airport", 37.937029981817396, 23.94482145571541))

        # Escribir en el fichero de texto
        StationManager.write_coords()

    @staticmethod
    def write_coords():
        f = open("./lib/data.csv", "w")
        f.write("station number, station name, station latitude, station longitude\n")
        for stat in StationManager.stations:
            f.write(str(stat.number) + "," + str(stat.name) + "," +
                    str(stat.lat) + "," + str(stat.lon) + "\n")


class Station:
    # Constructor de la clase estación
    station_counter = 1
    line_counter = 1

    def __init__(self, st_name: str, lat: float, lon: float):
        self.number = ""
        if (Station.line_counter == 1):
            self.number = "1"
            if (Station.station_counter > 24):
                Station.line_counter = 2
                Station.station_counter = 1

        if (Station.line_counter == 2):
            self.number = "2"
            if (Station.station_counter > 14):
                Station.station_counter = 1
                Station.line_counter = 3

        if (Station.line_counter == 3):
            self.number = "3"

        if (Station.station_counter <= 9):
            self.number += "0"
        self.number += str(Station.station_counter)
        self.name = st_name
        self.lat = lat
        self.lon = lon
        Station.station_counter += 1


# Funcion principal
if __name__ == '__main__':
    print("Generando datos... \n")
    StationManager.populate()
    print("Datos generados correctamente \n")
