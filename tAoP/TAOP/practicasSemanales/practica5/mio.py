import math
import sys
from math import sqrt
from typing import List, Tuple, Any
import decimal


def dist(p1: tuple[float, float], p2: tuple[float, float]) -> float:
    return sqrt(abs(p1[0] - p2[0]) ** 2 + abs(p1[1] - p2[1]) ** 2)


def middle(p1: tuple[float, float], p2: tuple[float, float]) -> tuple[float, float]:
    return (p1[0] + p2[0]) / 2, (p1[1] + p2[1]) / 2


def circumcenter(numeros):
    ax, ay, bx, by, cx, cy = numeros
    d = 2 * (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by))
    ux = ((ax * ax + ay * ay) * (by - cy) + (bx * bx + by * by)
          * (cy - ay) + (cx * cx + cy * cy) * (ay - by)) / d
    uy = ((ax * ax + ay * ay) * (cx - bx) + (bx * bx + by * by)
          * (ax - cx) + (cx * cx + cy * cy) * (bx - ax)) / d
    return ux, uy


def round_half_up(n, decimals=0):
    multiplier = 10 ** decimals
    return math.floor(n * multiplier + 0.5) / multiplier


if __name__ == "__main__":
    totalpoints = int(sys.stdin.readline().replace("\n", ""))
    x, y = [], []
    for i in range(0, totalpoints):
        pointstr = sys.stdin.readline().replace("\n", "").split(" ")
        point = (float(pointstr[0]), float(pointstr[1]))
        x.append(point[0])
        y.append(point[1])
        print(x[i], y[i], file=sys.stderr)
        # comprobar si punto es max o min en la x
        if i >= 2:
            if point[0] > xmax[0][0]:
                xmax[0] = point  # max
            if point[0] < xmax[1][0]:
                xmax[1] = point  # min
            # comprobar si punto es max o min en la y
            if point[1] > ymax[0][1]:
                ymax[0] = point  # max
            if point[1] < ymax[1][1]:
                ymax[1] = point  # min
        elif i == 1:
            xmax = [(x[0], y[0]), (x[1], y[1])]
            ymax = [(x[0], y[0]), (x[1], y[1])]
    # Calculate distances between max and min point in each coordinate
    # 2 points -> center of line is middle, rad is distance from middle to any pf given points
    if totalpoints == 2:
        center = middle(xmax[0], xmax[1])
        rad = dist(center, xmax[0])
    # 3 points -> forms triangle whose center is its circumcenter, rad is distance from middle to any of the given points
    elif totalpoints == 3:
        center = circumcenter([x[0], y[0], x[1], y[1], x[2], y[2]])
        rad = dist(center, xmax[0])
    else:
        '''
        if distances between any pair in (max, min) of each coordinate is the same then there's a triangle 
        that defines the minimal circle, if there's not then it is defined by the bigger distance between the (max,min) 
        of the coordinates
        '''
        possibledistances = [
            ("xmax[0],xmax[1]", int(dist(xmax[0], xmax[1])),),
            ("ymax[0],ymax[1]", int(dist(ymax[0], ymax[1])),),
            ("xmax[0],ymax[0]", int(dist(xmax[0], ymax[0])),),
            ("xmax[1],ymax[0]", int(dist(xmax[1], ymax[0])),),
            ("xmax[0],ymax[1]", int(dist(xmax[0], ymax[1])),),
            ("xmax[1],ymax[1]", int(dist(xmax[1], ymax[1])))
        ]
        flipped: dict[int, List[str]] = {}
        val = None
        # create a dictionary where value is a list points whose distance was the key
        for key, value in possibledistances:
            if value not in flipped:
                flipped[value] = [key]
            else:
                flipped[value].append(key)
                val = value
        # triangle case
        if val is not None and len(flipped[val]) > 2:
            sett = set()
            # set will make sure that there's no repeating value
            for points in flipped[val]:
                sett.update(eval(points))
            t = tuple()
            # back to unpacked tuple of elems (x1,y1, x2,y2, x3,y3, ...)
            for elem in sett:
                t += elem

            center = circumcenter(list(t))
            rad = dist(center, (t[0], t[1]))
        # case of max, min for each coordinate
        else:
            radx = dist(xmax[0], xmax[1]) / 2
            rady = dist(ymax[0], ymax[1]) / 2
            # Whichever is greater marks radius
            if radx > rady:
                rad = radx
            else:
                center = middle(ymax[0], ymax[1])
                rad = rady
        center = middle(xmax[0], xmax[1])
    print(
        f'{float(round(decimal.Decimal(str(center[0])), ndigits=2)):.2f} {center[1]:.2f} {rad:.2f}')
