
from __future__ import annotations

from typing import Dict, List, Optional, Tuple

from vincenty import vincenty


class Station:
    """
    Representation of a station
    """

    def __init__(self, stnumber: int, stname: str, lat: float, long: float):
        """
        The function takes in a station number, station name, latitude, and longitude and assigns them to the attributes of
        the class.

        # Python
        def __str__(self):
                return "Station: " + str(self.number) + " " + self.name + " " + str(self.lat) + " " + str(self.long)

        :param stnumber: The station number
        :param stname: The name of the station
        :param lat: latitude
        :param long: longitude
        """
        self.name = stname
        self.number = stnumber
        self.lat = lat
        self.long = long

        # Atributos necesarios para calcular el camino
        self.real_cost = 0.0  # g
        self.estimated_cost = 0.0  # f
        self.predecessor = self

    def __eq__(self, other: Station) -> bool:
        return self.number == other.number

    def __str__(self) -> str:
        return f"{self.number}, {self.name}, [{str(self.lat)}, {str(self.long)}]"

    def __repr__(self) -> str:
        return f"{self.number}, {self.name}, [{str(self.lat)}, {str(self.long)}]"

    def optimal_path(self, other: Station) -> Tuple[List[Station], float]:
        """
        Given two stations, it returns the optimal path between them by doing the A* algorithm
        Parameters
        ----------
        other : Station
            The station to which the optimal path is calculated

        Returns
        -------
        List[Station]
            The optimal path between the two stations
        """
        unknown: List[Station] = [self]
        explored: List[Station] = []
        print(f"Calculating optimal path from {self} to {other}")
        # Initially there's a list with only the origin station with a covered distance of 0
        # and its estimated distance to the destination station
        self.real_cost = 0
        self.estimated_cost = self.calc_distance(other)
        active: Optional[Station] = None
        while True:
            # We choose the station with the lowest estimated cost
            unknown.sort(key=lambda e: e.estimatedCost)
            active = unknown.pop(0)

            # we mark the station as explored
            explored.append(active)

            # We finish when we find the destination station+
            if active.number == other.number:
                break

            # get the adjacent stations to the active station
            adjacents = active.calc_adjacents()
            for succesor in adjacents:
                # Explored stations are ignored
                if succesor in explored:
                    continue
                if succesor in unknown:
                    try:
                        unknown.remove(succesor)
                    except ValueError:
                        print(
                            f"Error: Station {succesor} not found in unknown list, should be there")

                # Provisional distance to the station
                path_cost = active.real_cost + active.calc_distance(succesor)

                # If the real distance to the station 0.0 or is greater than the provisional distance
                #  the station is updated with the shortest path that reaches it
                if succesor.real_cost == 0.0 or path_cost < succesor.real_cost:
                    succesor.real_cost = path_cost
                    succesor.predecessor = active
                    succesor.estimated_cost = succesor.calc_distance(other)

                # Aerial distance from the station to the goal station
                succesor.estimated_cost = succesor.calc_distance(other)
                unknown.append(succesor)
        path = []

        # The goal node contains the computed real distance
        cost = active.real_cost

        # The path of stations is built from the goal to the origin station
        path.append(active)
        while True:
            i = explored.index(active.predecessor)
            active = explored.pop(i)
            path.append(active)

            # If the node has itself as a predecessor we have reached the origin
            if active.predecessor == active:
                break

        # If the path is reversed, the solution path is obtained
        path.reverse()
        return path, cost

    def calc_distance(self, other: Station) -> float:
        """
            It takes two points, converts them to tuples, and then uses the vincenty function from the geopy library to
            calculate the distance between them

            :param other: the other location
            :return: The distance between the two points in meters.
        """
        here = (self.lat, self.long)
        there = (other.lat, other.long)
        return vincenty(here, there) * 1000.0

    def calc_adjacents(self) -> List[Station]:
        """
        It returns a list of stations that are adjacent to the current station
        :return: A list of stations
        """
        adjacents: List[Station] = []

        # Transbordos
        # verde(1)<->azul(3):
        # Monastiraki
        if (self.number == 117):
            adjacents.append(StationManager.statmap[304])
        elif (self.number == 304):
            adjacents.append(StationManager.statmap[117])

        # verde(1)<->rojo(2):
            # Attiki
        elif (self.number == 114):
            adjacents.append(StationManager.statmap[203])
        elif (self.number == 203):
            adjacents.append(StationManager.statmap[114])
            # Omonia
        elif (self.number == 116):
            adjacents.append(StationManager.statmap[206])
        elif (self.number == 206):
            adjacents.append(StationManager.statmap[116])

        # rojo(2)<->azul(3):
            # Syntagma
        elif (self.number == 208):
            adjacents.append(StationManager.statmap[305])
        elif (self.number == 305):
            adjacents.append(StationManager.statmap[208])

        # Extremos
        if (self.number in (124, 214, 320)):
            adjacents.append(StationManager.statmap[self.number - 1])
        elif (self.number in (101, 201, 301)):
            adjacents.append(StationManager.statmap[self.number + 1])

        # Demas estaciones
        else:
            adjacents.append(StationManager.statmap[self.number + 1])
            adjacents.append(StationManager.statmap[self.number - 1])

        return adjacents


class StationManager:
    """
    Keeps a list of all the stations and a map of the stations
    """
    stations: List[Station] = []
    statmap: Dict[int, Station] = {}

    @ staticmethod
    def create(csv_file: str = "./lib/data.csv") -> None:
        """
        It opens a file, reads each line, splits the line into parts, and then creates a new Station object for each 
        line which is then added to the dictionary of stations.

        :param csv_file: str = "data.csv", defaults to data.csv
        :type csv_file: str (optional)
        """
        data_file = open(file=csv_file, mode="r", encoding="utf-8")
        data_file.readline()
        for line in data_file:
            parts = line.strip().split(",")
            StationManager.stations.append(
                Station(int(parts[0]), parts[1], float(parts[2]), float(parts[3])))
        data_file.close()

        for station in StationManager.stations:
            StationManager.statmap[station.number] = station


# Funcion principal
if __name__ == '__main__':
    import gui
    gui.start()
