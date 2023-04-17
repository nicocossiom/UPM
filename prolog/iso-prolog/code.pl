:- module(_,_,[classic,assertions,regtypes]).
%:- module(modulename,exports,[iso]).
:- use_module(library(lists)).
:- use_module(library(aggregates)).
:- use_module(library(between)).


author_data('Cossio','Miravalles','Nicolas','B190082').
:- doc(author, "Nicolas Cossio Miravalles, B190082").

:- doc(title, "Marias y Ara@~{n}as en ISO-Prolog").
:- doc(module,

       "Este m@'{o}dulo define operaciones con 'Marias y Ara@~{n}as'

@section{Parte 1 (5 puntos). Particiones M-arias de un n@'{u}mero:}
Una partici@'{o}n de un n@'{u}mero entero positivo N se define como un conjunto de n@'{u}meros
enteros positivos que suman N, escritos en orden descendente. Por ejemplo, para el
n@'{u}mero 10 tenemos:
@begin{verbatim}10 = 4+3+2+1@end{verbatim}
Una partici@'{o}n es M-aria si cada termino de dicha partici@'{o}n es una potencia de M.
Por ejemplo, las particiones 3-arias de 9 son:
@begin{verbatim}
9
3+3+3
3+3+1+1+1
3+1+1+1+1+1+1
1+1+1+1+1+1+1+1+1
@end{verbatim}

El objetivo de esta parte es escribir un predicado maria/3 tal que el tercer argumento es el n@'{u}mero de particiones M-arias del segundo argumento siendo M el primer
argumento. Por ejemplo, @tt{?- maria(3,9,M).} debe devolver M=5 .
Para ello, se han escrito los siguientes predicados:
o
@subsection{Predicado 1.1 pots(M,N,Ps):}
Devuelve en @var{Ps} una lista con las potencias de @var{M} que son menores o iguales que @var{N}, en orden descendente.  @var{M} y @var{N} son enteros.

@includedef{pots/3}

Dado que todo n@'{u}mero tiene como potencia el 1, hemos empezado la lista en dicho n@'{u}mero, que pasamos a una funci@'{o}n auxiliar @tt{pots_helper/5}:
@includedef{pots_helper/5}
La funci@'{o}n hace lo siguiente:

Devuelve en @var{Res} una lista con las potencias de @var{M} que son menores o iguales que @var{Max}, en orden descendente.  @var{M}es la base de las potencias y @var{Max} es el numeero que marca el m@'{a}ximo a la que estas pueden llegar, ambos son enteros.

@var{ExpLastPower} es el la @'{u}ltima potencia calculada. La forma de resolver este enunciado ha sido mediante programacion dinamica, guardando el resultado en la lista y dandolo como parametro en la llamada recursiva, lo que permite poder reusarlo para calcular la siguiente potencia, multiplicando nada m@'{a}s que por la base @var{M}. Esto se hace hasta mirando en cada llamada si la siguiente potencia que se va a calcular es superior al @var{Max}, cuando esto ocurre se hace un corte que pone @var{Powers}, que es la lista que se lleva en cada llamada, a @var{Res}, que es el resultado final.

Ejemplos de uso:
@begin{verbatim}
?- pots (3,9,Ps).
Ps = [9,3,1] ? ;
no
?- pots (5 ,123 , Ps).
Ps = [25,5,1] ? ;
no
@end{verbatim}

@subsection{Predicado 1.2 mpart(M,N,P):}
La soluci@'{o}n que he planteado utiliza una funci@'{o}n auxiliar @tt{mpart_backtrack(Powers, Counter, Solution)}:

@includedef{mpart_backtrack/3}

Esta sentencia/s se encarga de insertar las potencias @var{Powers} dadas por @tt{pots}, tantas veces como haga falta en funci@'{o}n de un contador @var{Counter}, que ha sido inicializado al n@'{u}mero que se quiere particionar{N}, este contador se va decrementando en funci@'{o}n de la potencia (la cabeza de @var{Powers}) que se inserta. La gracia de la implementaci@'{o}n es la llamada recursiva que pasa la cola de la soluci@'{o}n como la siguiente soluci@'{o}n a hacer, manteniendo la lista de potencias en la llamada.

Esto por supuesto no daria todas las soluciones, es por esto que hace falta una cl@'{a}usula que nos permita hacer backtracking, para calcular esos casos intermedios en el arbol de soluciones. El backtracking ocurre en la esta cl@'{a}usula, donde se hace la llamada recursiva que da el resto de soluciones intermedias, dando esta vez la lista de potencias recortada, ya que la cabeza (potencia actual) ya se ha usado y no se puede/debe a@~{n}adir m@'{a}s a la lista.

Se llega al caso base cuando la lista de sumandos de potencias esta vacia y el contador es 0, indicando que se ha llegado a una soluci@'{o}n.

Dados M y N, que son enteros, devuelve en P todas las particiones M-arias de N, representadas como
listas de enteros. Las soluciones deben ir ordenadas con las listas m@'{a}s cortas primero.


@includedef{mpart/3}

@begin{verbatim} ? -mpart (3 ,9 , P).  P= [9] ? ; P= [3 ,3 ,3] ? ; P=
[3 ,3 ,1 ,1 ,1] ? ; P= [3 ,1 ,1 ,1 ,1 ,1 ,1] ? ; P= [1 ,1 ,1 ,1 ,1 ,1
,1 ,1 ,1] ? ; no

?- mpart(5, 123, X).

X = [25,25,25,25,5,5,5,5,1,1,1] ? ;

X = [25,25,25,25,5,5,5,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,25,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,25,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,25,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,5,5,5,5,5,5,5,5,5,1,1,1] ? ;

X = [25,25,25,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;;

X = [25,25,25,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,25,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,25,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,11,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ? ;

X = [25,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1] ?

.......

no
@end{verbatim}


@subsection{Predicado 1.3 maria(M, N, NPartes):}
La soluci@'{o}n que he planteado es muy simple. Se usa la funci@'{o}n findall para agregar todos los resultados dados al llamar a la funci@'{o}n @tt{mparts(M,N,X)}, esto devuelve en X una lista de listas con todos los resultados agregados. Despues se llama a la funci@'{o}n @tt{length(X, NPartes)} del paquete aggregates para calcular facilmente cuantas soluciones se tiene que es la soluci@'{o}n de la partici@'{o}n M-aria de N. 

@includedef{maria/3}

@begin{verbatim}
? -maria (3 ,9 , M).
M=5.

? -maria (3 ,47 , M).
M=63.

? -maria (5 ,123 , M).
M=75.

? -maria (7 ,4321).
M=144236.

?- maria(3, 1000, X).
X = 1295579 ?

?- maria(3, 1000, X).
X = 1295579 ?
@end{verbatim}


@section{Parte 2 (3.5 puntos). Ara@~{n}as de expansi@'{o}n de un grafo:}

Una ara@~{n}a de expansi@'{o}n de un grafo es un subgrafo que contiene todos los v@'{e}rtices de este menos, con grado m@'{a}ximo 3.
No todos los grafos contienen una ara@~{n}a de expansi@'{o}n. A continuaci@'{o}n se describe un predicado @tt{aranya/0} que tenga @'{e}xito @'{u}nicamente una vez si el grafo proporcionado contiene una ara@~{n}a de expansi@'{o}n. 

El grafo se representa como una lista de estructurasarista/2que tienen como
argumentos los nodos que forman dicha arista. Estas estructuras se guardar@'{a}n como
hechos llamando al predicado @{guardar_grafo/1}.

En este problema se asumir@'{a} que los grafos de entrada son conexos y no dirigidos,
por lo que para representar la conexi@'{o}n entre dos v@'{e}rtices a y b, incluiremos en la base
de hechos el hecho arista(a,b) o el hecho arista(b,a), pero no ambos.


@subsection{Predicado 2.1 guardar_grafo(G):}
La soluci@'{o}n planteada consiste en borrar cualquier sentencia de la base de hechos que siga el predicado @tt{arista/2}.
Para ello se usa la funci@'{o}n @tt{dropall(X,arista(_,_)}. Despu@'{e}s se pasa a una funci@'{o}n auxiliar que coge de la cabeza de la lista
la arista a insertar en la base de hechos y la aserta mediante @tt{assert(X)}. Para que esto funcione claro hemos tenido que definir
antes el predicado @tt{arista/2} como din@'{a}mico. Finalmente se hace una llamada recursiva a la funci@'{o}n auxiliar con la cola de la
lista de aristas. El caso base es cuando se llega a una lista vacia.

@includedef{guardar_grafo/1}

@includedef{clean_edges/0}


@includedef{save_graph/1}


@begin{verbatim}
?- guardar_grafo([arista(a,e), arista(b,e),
arista(e,f), arista(f,d), arista(f,c)]).
   
yes
?- 

X = a,
Y = e ? ;

X = b,
Y = e ? ;

X = e,
Y = f ? ;

X = f,
Y = d ? ;

X = f,
Y = c ? ;

no
?- guardar_grafo([arista(1,2), arista(2,3),
arista(4,5), arista(6,7), arista(8,9)]).
   
yes
?- arista(X, Y).

X = 1,
Y = 2 ? ;

X = 2,
Y = 3 ? ;

X = 4,
Y = 5 ? ;

'X = 6,
Y = 7 ? ;

X = 8,
Y = 9 ? ;

no
@end{verbatim}

@section{Tests:}
Se han planteado una serie de tests automaticos, que son los siguientes, y dan estos resultados.

:- test pots(M, N, Ps) : ( M = 3, N = 9 ) => ( Ps = [9,3,1] ) + not_fails # 'Pots(3,9,X)->[9,3,1]'.

:- test pots(M, N, Ps) : ( M = 5, N = 123 ) => ( Ps = [25,5,1] ) + not_fails # 'Pots(5,123,X)->[25,5,1]'.

:- test mpart(2,2,NP) => (NP = [2]; NP = [1,1]) + (try_sols(10),not_fails).

:- test mpart(3,9,NP) => (NP = [9]; NP = [3,3,3]; NP=[3,3,1,1,1]; NP = [3,1,1,1,1,1,1]) + (try_sols(4),not_fails) # 'mpart(3,9,X)-> [9]; [3,3,3]; [3,3,1,1,1]; [3,1,1,1,1,1,1]'.

:- test mpart(5,50,NP) => (NP = [25, 25]; NP = [25,5,5,5,5,5]; NP= [25,5,5,5,5,1,1,1,1,1]; NP =  [25,5,5,5,1,1,1,1,1,1,1,1,1,1] ) + (try_sols(4),not_fails) # 'mpart(5,50,X)-> [25, 25]; [25,5,5,5,5,5]; [25,5,5,5,5,1,1,1,1,1]; [25,5,5,5,1,1,1,1,1,1,1,1,1,1]'.

:- test pots(M, N, Ps) : ( M = 3, N = 9 ) => ( Ps = [9,3,1] ) + not_fails # 'Pots(3,9,X)->[9,3,1]'.

:- test pots(M, N, Ps) : ( M = 5, N = 123 ) => ( Ps = [25,5,1] ) + not_fails # 'Pots(5,123,X)->[25,5,1]'.

:- test maria(M, N, NParts) : ( M = 3, N = 9 ) => ( NParts = 5 ) + not_fails # 'maria(3,9,X)->5'.

:- test maria(M, N, NParts) : ( M = 3, N = 47 ) => ( NParts = 63 ) + not_fails # 'maria(3,47,X)->63'.

:- test maria(M, N, NParts) : ( M = 5, N = 123 ) => ( NParts = 75 ) + not_fails # 'maria(5,123,X)->75'.

test_guardar_grafo_1 :-
    guardar_grafo([arista(1, 2), arista(2, 3)]),
    arista(1, 2),
    arista(2, 3).

test_guardar_grafo_2 :-
    guardar_grafo([arista(5, 2), arista(7, 3)]),
    arista(1, 2),
    arista(2, 3).

test_guardar_grafo_3 :-
    test_guardar_grafo_1,
    guardar_grafo([arista(5, 2), arista(7, 3)]),
    arista(5, 2),
    arista(7, 3).

:- test test_guardar_grafo_1 + not_fails # 'guardar_grafo([arista(1, 2), arista(2, 3)]) -> no debe fallar, se comprueba si las aristas existen'.

:- test test_guardar_grafo_2 + fails # 'guardar_grafo([arista(5, 2), arista(7, 3)]) -> debe fallar, se comprueba si las aristas anteriores existen'.

:- test test_guardar_grafo_3 + not_fails # 'guardar_grafo([arista(1, 2), arista(2, 3)]), guardar_grafo([arista(5, 2), arista(7, 3)]) ->no debe fallar, se comprueba si las ultimas aristas metidas existen'.


PASSED: (lns 329-330) pots/3 'Pots(3,9,X)->[9,3,1]'.

PASSED: (lns 331-331) pots/3 'Pots(5,123,X)->[25,5,1]'.

PASSED: (lns 354-356) mpart/3.

PASSED: (lns 356-357) mpart/3 'mpart(3,9,X)-> [9]; [3,3,3]; [3,3,1,1,1]; [3,1,1,1,1,1,1]'.

PASSED: (lns 357-358) mpart/3 'mpart(5,50,X)-> [25, 25]; [25,5,5,5,5,5]; [25,5,5,5,5,1,1,1,1,1]; [25,5,5,5,1,1,1,1,1,1,1,1,1,1]'.

PASSED: (lns 370-371) maria/3 'maria(3,9,X)->5'.

PASSED: (lns 372-372) maria/3 'maria(3,47,X)->63'.

PASSED: (lns 373-373) maria/3 'maria(5,123,X)->75'.

PASSED: (lns 412-413) test_guardar_grafo_1/0 'guardar_grafo([arista(1, 2), arista(2, 3)]) -> no debe fallar, se comprueba si las aristas existen'.

PASSED: (lns 414-415) test_guardar_grafo_2/0 'guardar_grafo([arista(5, 2), arista(7, 3)]) -> debe fallar, se comprueba si las aristas anteriores existen'.

PASSED: (lns 416-417) test_guardar_grafo_3/0 'guardar_grafo([arista(1, 2), arista(2, 3)]), guardar_grafo([arista(5, 2), arista(7, 3)]) ->no debe fallar, se comprueba si las ultimas aristas metidas existen'.
}

Note: {Total:
Passed: 11 (100.00%) Failed: 0 (0.00%) Precond Failed: 0 (0.00%) Aborted: 0 (0.00%) Timeouts: 0 (0.00%) Total: 11 Run-Time Errors: 0
}

@begin{alert}
No he hecho el enunciado 2.2 por falta de tiempo. 
@end{alert}

").



% TODO arreglar que devuelve todas las iteraciones de la soluci@'{o}n
:- pred pots_helper(M, LastPower, Max, Powers, Res)
   #"Devuelve en @var{Res} una lista con las potencias de @var{M} que son menores o iguales que @var{Max}, en orden descendente.  @var{M} y @var{Max} son enteros. @var{ExpLastPower} es el la @'{u}ltima potencia calculada. La forma de resolver este enunciado ha sido mediante programacion dinamica, guardando el resultado en la lista y dandolo como parametro en la llamada recursiva, lo que permite poder reusarlo para calcular la siguiente potencia, multiplicando nada m@'{a}s que por la base @var{M}.  @var{Powers} es la lista que se lleva en cada llamada y @var{Res} es el resultado final @includedef{pot/5}".
pots_helper(M, LastPower, Max, Powers, Powers) :-
    LastPower*M > Max, !.
    
pots_helper(M, LastPower, Max, Powers, Res) :-
    NewPower is LastPower * M,
    pots_helper(M, NewPower, Max, [NewPower|Powers], Res). 

:- pred pots(M,N,Ps)
   #"Devuelve en @var{Ps} una lista con las potencias de @var{M} que son menores o iguales que @var{N}, en orden descendente.  @var{M} y @var{N} son enteros, @includedef{pots/3}".
pots(1, _, [1]) :- !.

pots(M, N, Ps) :-
    pots_helper(M, 1, N, [1], Ps).

:- test pots(M, N, Ps) : ( M = 3, N = 9 ) => ( Ps = [9,3,1] ) + not_fails # "Pots(3,9,X)->[9,3,1]".
:- test pots(M, N, Ps) : ( M = 5, N = 123 ) => ( Ps = [25,5,1] ) + not_fails # "Pots(5,123,X)->[25,5,1]".

:- pred mpart(M,N,P)
   #"Dados @var{M} y @var{N}, que son enteros, devuelve en @var{P} todas las particiones M-arias de @var{N}, representadas como listas de enteros. Las soluciones van ordenadas con las listas m@'{a}s cortas primero. @includedef{mpart/3}".

mpart(M, N, P) :-
    pots(M, N, Powers),
    mpart_backtrack(Powers, N, P).


:- pred mpart_backtrack(Powers, N, P)
   #"@includedef{mpart_backtrack/3}".

mpart_backtrack(_, 0, []).

mpart_backtrack([FirstPower|RestPowers], Counter, [FirstPower|PRest]) :-
    Counter > 0,
    NewCounter is Counter - FirstPower,
    mpart_backtrack([FirstPower|RestPowers], NewCounter, PRest).

mpart_backtrack([_|RestPowers], Counter, P) :-
    Counter > 0,
    mpart_backtrack(RestPowers, Counter, P).


:- test mpart(2,2,NP) => (NP = [2]; NP = [1,1]) + (try_sols(10),not_fails). 
:- test mpart(3,9,NP) => (NP = [9]; NP = [3,3,3]; NP=[3,3,1,1,1]; NP = [3,1,1,1,1,1,1]) + (try_sols(4),not_fails) # "mpart(3,9,X)-> [9]; [3,3,3]; [3,3,1,1,1]; [3,1,1,1,1,1,1]". 
:- test mpart(5,50,NP) => (NP = [25, 25]; NP = [25,5,5,5,5,5]; NP= [25,5,5,5,5,1,1,1,1,1]; NP =  [25,5,5,5,1,1,1,1,1,1,1,1,1,1] ) + (try_sols(4),not_fails) # "mpart(5,50,X)-> [25, 25]; [25,5,5,5,5,5]; [25,5,5,5,5,1,1,1,1,1]; [25,5,5,5,1,1,1,1,1,1,1,1,1,1]".


:- pred maria(M, N, NParts)
   # "@includedef{maria/3}".

maria(M, N, NParts) :-
    findall(Partition , mpart(M, N, Partition), X),
    length(X, NParts).

:- pred maria(M, N, NParts)
   # "@includedef{maria/3}".

:- test maria(M, N, NParts) : ( M = 3, N = 9 ) => ( NParts = 5 ) + not_fails # "maria(3,9,X)->5".
:- test maria(M, N, NParts) : ( M = 3, N = 47 ) => ( NParts = 63 ) + not_fails # "maria(3,47,X)->63".
:- test maria(M, N, NParts) : ( M = 5, N = 123 ) => ( NParts = 75 ) + not_fails # "maria(5,123,X)->75".

:- dynamic arista/2.


:- pred guardar_grafo(G)
   # "Guarda en la base de hechos el grafo @var{G} representado en una lista de arista/2. @{guardar_grafo/´¨1}".
guardar_grafo(G) :-
    clean_edges,
    save_graph(G).

:- pred clean_edges
   # "Elimina de la base de hechos el grafo @'{u}ltimo guardado, representado en una lista de arista/2. @{clean_edges/´¨0}".
clean_edges :-
    retractall(arista(_,_)).

:- pred save_graph(G)
   # "Funci@'{o}n auxiliar de guardar_grafo/1, se encarga de guardar la arista que encabeza la lista G, llamandose recursivamente hasta que se queda sin aristas que guardar. @{save_graph/´¨1}".
save_graph([]).

save_graph([Edge|ResEdges]) :-
    assert(Edge),
    save_graph(ResEdges).

test_guardar_grafo_1 :-
    guardar_grafo([arista(1, 2), arista(2, 3)]),
    arista(1, 2),
    arista(2, 3).

test_guardar_grafo_2 :-
    guardar_grafo([arista(5, 2), arista(7, 3)]),
    arista(1, 2),
    arista(2, 3).

test_guardar_grafo_3 :-
    test_guardar_grafo_1,
    guardar_grafo([arista(5, 2), arista(7, 3)]),
    arista(5, 2),
    arista(7, 3).

:- test test_guardar_grafo_1 + not_fails # "guardar_grafo([arista(1, 2), arista(2, 3)]) -> no debe fallar, se comprueba si las aristas existen".

:- test test_guardar_grafo_2 + fails # "guardar_grafo([arista(5, 2), arista(7, 3)]) -> debe fallar, se comprueba si las aristas anteriores existen".

:- test test_guardar_grafo_3 + not_fails # "guardar_grafo([arista(1, 2), arista(2, 3)]), guardar_grafo([arista(5, 2), arista(7, 3)]) ->no debe fallar, se comprueba si las ultimas aristas metidas existen".
