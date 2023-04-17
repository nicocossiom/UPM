:- doc(title, "Primera práctica (Programación Lógica Pura)").

:- doc(author, "Nicolás Cossío Miravalles, b190082").

:- doc(module, "This module defines a operations for BITS, NIBBLES & BYTES using peano numbers").

:- prop bind/1 #binary digit type. @includedef{bind/1}". 
bind(X):-
    bind(0).
    bind(1).

:- Prop binary_byte/8 #binary byte as a list of 8 binary digits. @includedef{binary_byte/8}". 
binary_byte([bind(B7), bind(B6), bind(B5), bind(B4), bind(B3), bind(B2), bind(B1), bind(B0)]) :-
    bind(B7),
    bind(B6),
    bind(B5),
    bind(B4),
    bind(B3),
    bind(B2),
    bind(B1),
    bind(B0).




:- prop hexd/1 #hex digit (nibble) type. @includedef{hexd/1}".
hexd(0).
hexd(1).
hexd(2).
hexd(3).
hexd(4).
hexd(5).
hexd(6).
hexd(7).
hexd(8).
hexd(9).
hexd(a).
hexd(b).
hexd(c).
hexd(d).
hexd(e).
hexd(f).

:- prop hex_byte/1 #hex byte as a list of 2 hex nibbles. @includedef{hex_byte/1}".
hex_byte([hexd(H1), hexd(H0)]) :-
    hexd(H1),
    hexd(H0).


:- prop byte/1 #byte type either as a binary byte or as a hex byte. @includedef{byte/1}".
% Define a .
byte(BB) :-
    binary_byte(BB).
byte(HB) :-
    hex_byte(HB).



Predicado 1 (1 puntos) byte_list/1: byte_list(L)
Este predicado es cierto si la lista dada en el primer argumento es una lista de
bytes (ya sean binarios o hex). Se asume que el primer elemento de la lista es el
bit más significativo, mientras que el último elemento de la lista sería el bit menos
significativo.

:- prop byte_list/1 #True if list of bytes. @includedef{hex_byte/1}".

byte_list(L):-
    

Predicado 2 (1.5 puntos) byte_conversion/2: byte_conversion(HexByte, BinByte).
Este predicado es cierto si el byte hexadecimal que aparece en el primer argumento tiene como representación binaria el 
byte binario que aparece en el segundo argumento.

:- prop byte_conversion/2 #True if first hexd byte is representation of second binary byte. @includedef{byte_conversion/2}".


Predicado 3 (1 puntos) byte_list_conversion/2: byte_list_conversion(HL, BL).
Este predicado es cierto si la representación binaria de la lista de bytes hexadecimales que aparece en el primer argumento 
es la lista de bytes que aparece en el segundo argumento.

:- prop byte_list_conversion/2 #True if first argument hexd list of bytes is representation of second binary list of bytes. @includedef{byte_list_conversion/2}".

Predicado 4 (1 puntos) get_nth_bit_from_byte/3: get_nth_bit_from_byte(N, B, BN).
Este predicado polimórfico es cierto si BN es el dígito binario (bit) número N (Ojo: n es un número de peano) del byte B 
(ya sea este un byte hexadecimal o binario). Nota: el alumno debe tener en cuenta que el índice del bit menos significativo 
de un byte no es 1, sino 0.

:- prop get_nth_bit_from_byte/3 #True if the first argument (peano number) is the nth bit of the second argument (byte hexd or binary)
    whith value third argument (binary bit). @includedef{get_nth_bit_from_byte/3}".

Predicado 5 (1.5 puntos) byte_list_clsh/2: byte_list_clsh(L, CLShL).
Este predicado polimórfico es cierto si CLShL es el resultado de efectuar un desplazamiento circular hacia la izquierda de la lista 
de bytes representada por L. Este predicado debe funcionar tanto para listas de bytes hexadecimales como binarias, aunque ambos argumentos 
deben estar representados en la misma notación. En los desplazamientos circulares a la izquierda el bit más significativo del byte más 
significativo de la lista L pasa a ser el bit menos significativo del byte menos significativo de la lista CLShL.

:- prop byte_list_clsh/2: #True if the second argument (list of hexd or binary bytes) is the left circular shift representation 
    of the first argument (list of hexd or binary bytes)  Both arguments must use the same representation (hexd or binary byte). @includedef{byte_list_clsh/2}".


Predicado 6 (1.5 puntos) byte_list_crsh/2: byte_list_crsh(L, CRShL).
Este predicado polimórfico es cierto si CRShL es el resultado de efectuar un desplazamiento circular hacia la derecha de la lista de 
bytes representada por L. Este predicado debe funcionar tanto para listas de bytes hexadecimales como binarios, aunque ambos argumentos 
deben estar representados en la misma notación. En los desplazamientos circulares a la derecha el bit menos significativo del byte menos 
significativo de L pasa a ser el bit más significativo del byte mas significativo de la lista CRShL.

:- prop byte_list_crsh/2 #True if the second argument (list of hexd or binary bytes) is the left circular shift representation 
    of the first argument (list of hexd or binary bytes)  Both arguments must use the same representation (hexd or binary byte). @includedef{byte_list_crsh/2}".

Predicado 7 (1 puntos) byte_xor/3: byte_xor(B1, B2, B3).
Este predicado polimórfico es cierto si B3 es el resultado de efectuar la operación
lógica XOR entre los bytes B1 y B2. Este predicado debe funcionar tanto para bytes binarios como hexadecimales, aunque todos los argumentos deben estar representados
en la misma notación.

:- prop byte_xor/3 #True if the third argument (binary or hexd byte) is the result of the XOR operation between the first and 
    second arguments (binary or hex bytes). @includedef{byte_xor/3}".
