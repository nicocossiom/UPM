import sys

class Partido:
    def __init__ (self, equipo1, equipo2, hora_inicio, hora_fin): 
        self.equipo1 = equipo1
        self.equipo2 = equipo2
        self.hora_inicio = hora_inicio
        self.hora_fin = hora_fin
    
    def toString(self): 
        return self.equipo1 +" "+ self.equipo2 +" "+ self.hora_inicio +" "+  self.hora_fin + "\n"

def listaPrinter(listaP: list):
    res = ""
    for partido in listaP:
        res = res + partido.toString()
    return res.rstrip()

def conflict_checker(diaP:list, date:str): 
    '''
    This function recieves a list of arrays whose elements define integer ranges,
    it sorts them, finds intersections between contiguous ranges. If found deletes entry 
    from list that coincides
    '''
    i=0
    #sorts [[int_lower_1, int_upper_1],...] by ascending order in terms of int_lower_x, x being the index of any element of the tuple of lists 
    #diaP.sort(key = lambda lower:lower.hora_fin)
    diaP.sort(key = lambda lower:lower.hora_fin)
    while(i < len(diaP)-1):
        if( int(diaP[i].hora_fin) > int(diaP[i+1].hora_inicio) ): 
            del diaP[i+1]
        else : i=i+1
    print( date + " " + str(len(diaP)) + "\n" + listaPrinter(diaP))
    

        
diaP = []
line = sys.stdin.readline()
while line != "000000 0\n":
    spline = line.split()
    if (spline[0].isdigit()):
        if( bool(diaP) is not False):
             conflict_checker(diaP, date)
        date = spline[0]
        num = spline[1]
        diaP = [] #reset list
    else:     
        equipo1 = spline[0]
        equipo2 = spline[1]
        hora_inicio = spline[2]
        hora_fin = spline[3]
        partido = Partido(equipo1, equipo2, hora_inicio, hora_fin)
        diaP.append(partido)   
    line = sys.stdin.readline() #next line
conflict_checker(diaP,date) #for last matchday       
print("000000 0")
sys.exit() 
            
