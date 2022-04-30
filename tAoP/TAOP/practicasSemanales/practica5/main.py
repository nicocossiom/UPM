import math
import sys
from math import sqrt
from random import shuffle, randint
import decimal
from typing import List


class Point:
    def __init__(self, x: float, y: float) -> None:
        self.x = x
        self.y = y


class Circle:
    def __init__(self, center: Point, radius: float) -> None:
        self.center = center
        self.radius = radius


def isInsideCircle(point: Point, circle: Circle) -> bool:
    return dist(circle.center, point) <= circle.radius


def dist(p1: Point, p2: Point) -> float:
    return sqrt((p1.x - p2.x) ** 2 + (p1.y - p2.y) ** 2)


def middle(p1: Point, p2: Point) -> Point:
    return Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)


def circumCircle(a: Point, b: Point, c: Point) -> Circle:
    d = 2 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))
    ux = ((a.x * a.x + a.y * a.y) * (b.y - c.y) + (b.x * b.x + b.y * b.y) * (c.y - a.y) + (c.x * c.x + c.y * c.y) * (
        a.y - b.y)) / d
    uy = ((a.x * a.x + a.y * a.y) * (c.x - b.x) + (b.x * b.x + b.y * b.y) * (a.x - c.x) + (c.x * c.x + c.y * c.y) * (
        b.x - a.x)) / d
    circumcenter = Point(ux, uy)
    return Circle(circumcenter, dist(circumcenter, a))


def circleFrom2Points(a: Point, b: Point) -> Circle:
    center = middle(a, b)
    rad = dist(center, a)
    return Circle(center, rad)


def isValidCircle(circle: Circle, points: List[Point]):
    for point in points:
        if not isInsideCircle(point, circle):
            return False
    return True


def findCircle(boundary):
    leng = len(boundary)
    if not boundary:
        return Circle(Point(0, 0), 0)
    if leng == 1:
        return Circle(boundary[0], 0)
    elif leng == 2:
        return circleFrom2Points(boundary[0], boundary[1])
    else:
        i = 0
        while i < 3:
            j = i + 1
            while j < 3:
                circ = circleFrom2Points(boundary[i], boundary[j])
                if isValidCircle(circ, boundary):
                    return circ
                j += 1
            i += 1
        return circumCircle(boundary[0], boundary[1], boundary[2])


def mec(points, n, boundary):
    if n == 0 or len(boundary) == 3:
        return findCircle(boundary)
    # choose p in P(randomly and uniformly)
    random = randint(0, n-1) if n != 1 else 0
    element = points[random]
    # exchange randomly chosen element with last
    points[random], points[n-1] = points[n-1], points[random]
    # D := welzl(P − {p}, R)
    localCircle = mec(points, n - 1, boundary.copy())
    if isInsideCircle(element, localCircle):
        return localCircle
    # return welzl(P − {p}, R ∪ {p})
    boundary.append(element)
    return mec(points.copy(), n - 1, boundary)


if __name__ == "__main__":
    totalpoints = int(sys.stdin.readline())
    if totalpoints > 999:
        sys.setrecursionlimit(totalpoints+7)
    x, y = [], []
    points = []
    for i in range(0, totalpoints):
        pointstr = sys.stdin.readline().strip().split(" ")
        point = Point(float(pointstr[0]), float(pointstr[1]))
        points.append(point)

    if totalpoints < 4:
        result = findCircle(points)
    else:
        copy_points = points.copy()
        shuffle(copy_points)
        result = mec(copy_points, len(points), [])

    print(f'{float(round(decimal.Decimal(str(result.center.x)), ndigits=2)):.2f} {result.center.y:.2f} {result.radius:.2f}')
