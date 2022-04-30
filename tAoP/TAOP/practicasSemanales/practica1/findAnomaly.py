list = [2,4,3,7,8,100,99,207,5]
def isAbnormal(lista:list, i:int) -> int:
    elem = list[i]
    next = list[i+1]
    if(elem<=next): isAbnormal(lista,i+1)
    if(elem>next): return elem

print(isAbnormal(list, 0))