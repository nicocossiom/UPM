

def isLimit(pos: int, size: int) -> int:
    '''
    Returns -1 is left element of pos is limit or +1 if right elem of pos is
    limit
    '''
    if size == 3:
        return 3
    if pos-1 == 0:
        return -1
    if pos+1 == size-1:
        return 1
    return 0


def recursiveSolution(max: int, min: int, to):
    '''
    Returns index at which element is not smaller than neighbours
    max: defines the upper limit of the divided list
    min: defines the lower limit of the divided list
    to: is the list whose peak we want to find
    '''
    center = int((max + min)/2)
    limits = isLimit(center, to.size())
    leftElem = to.get(center-1)
    rightElem = to.get(center+1)
    middleElem = to.get(center)
    leftBigger = middleElem < leftElem
    rightBigger = middleElem < rightElem
    if not leftBigger and not rightBigger:
        return center
    elif limits in {-1, 3} and leftBigger:
        return center-1
    elif limits in {1, 3} and rightBigger:
        return center+1
    else:
        if leftBigger:
            res = recursiveSolution(center-1, min, to)
        elif rightBigger:
            res = recursiveSolution(max, center+1, to)
    return res


def findProblematicTemperature(to) -> int:
    '''
    Returns index at which element is not smaller than neighbours
    '''
    if to.size() == 2:
        izq = to.get(0)
        der = to.get(1)
        return izq if izq >= der else der
    if to.size() == 1:
        return 0
    # if to.size() == 0: return -1
    return recursiveSolution(to.size()-1, 0, to)
