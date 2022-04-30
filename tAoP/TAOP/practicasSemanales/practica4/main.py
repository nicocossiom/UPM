import sys
from typing import List


def navLinkedMaxSubSum(i, lista, result):
    prev, origin = lista[i]
    if i == 32:
        pass
    if origin == -1:
        result[prev] = "F"
        return result
    if origin == i or i == len(lista):
        result[origin] = "F"
    navLinkedMaxSubSum(prev, lista, result)
    return result


def assureTime(speeds, lista):
    suma = 0
    for i in range(len(speeds)):
        if speeds[i] == "F":
            suma += lista[i]
        else:
            suma += lista[i]*2
    return suma


def maxSpeedSum(lista: List[int]):
    size = len(lista)
    if size == 0:
        return
    if size == 1:
        return lista[0]
    maxsum: List[int] = [None] * size
    linkedMaxSubSum = [None] * size
    maxsum[0] = lista[0]
    linkedMaxSubSum[0] = 0, -1
    if lista[0] > lista[1]:
        maxsum[1] = lista[0]
        linkedMaxSubSum[1] = 0, -1
    else:
        maxsum[1] = lista[1]
        linkedMaxSubSum[1] = 1, -1
    for index in range(2, size):
        a = maxsum[index - 1]
        b = maxsum[index - 2] + lista[index]
        if a > b:
            maxsum[index] = a
            linkedMaxSubSum[index] = index - 1, -2
        else:
            maxsum[index] = b
            linkedMaxSubSum[index] = index - 2, index
    peorSuma = sum(lista) * 2
    result = navLinkedMaxSubSum(size - 1, linkedMaxSubSum, ["H"] * size)
    return peorSuma - maxsum[size - 1], result


def solution(entrada):
    casos = "\n".join(entrada.splitlines()).split("\n\n")
    for caso in casos:
        primera = caso.replace("\n", " ", 1).split(
            " ", 2)  # separa los primeros numeros del resto
        A, B = int(primera[0]), int(primera[1])
        if A == 0 and B == 0:
            exit()
        # cogemos de la primera a la última fila
        lineas = primera[2].split("\n")
        obs = {}
        for i in range(A):
            obs[i] = lineas[i].split(" ")

        j, path, indexpath = 0, [], []
        while j < B:
            i, col = 0, []
            while i < A:
                col.append(int(obs[i][j]))
                i += 1
            smallest = min(col)
            indexpath.append(col.index(smallest))
            path.append(smallest)
            j += 1
        sumTotal, speeds = maxSpeedSum(path)
        endString = str(sumTotal) + "\n"
        for index in indexpath:
            endString += f"     {index}"
        endString += "\n"
        for speed in speeds:
            endString += f"     {speed}"
        print(endString+"\n")


entrada = sys.stdin.read()
print(entrada)
solution(entrada)
