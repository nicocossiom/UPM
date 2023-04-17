:- module(_,_,[assertions,regtypes]).

:- doc(author, "Nicolas Cossio Miravalles, B190082").
:- doc(title, "BITS, NIBBLES & BYTES in Prolog").
author_data('Cossio','Miravalles','Nicolas','B190082').
:- doc(module, "This module defines the structure for bits, nibbles and bytes, as well as  some operations which can be performed with them. Given that in pure Prolog there is no representation for this kind of data we have to implement it ourselves.

@section{Basic structure for bits nibbles and bytes}
@subsection{Bit representation}
A bit is defined as a bind/1:
@begin{verbatim}
bind(0).
bind(1).
@end{verbatim}
@subsection{Bit representation}
A hexadecimal digit is defined as a hexd/1:
@begin{verbatim}
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
@end{verbatim}
@subsection{Byte representation}
A byte can either be a [hexd/1, hexd/1] or a [bind(B7), bind(B6), bind(B5),
             bind(B4), bind(B3), bind(B2), bind(B1), bind(B0)]. So let's define them.
First we create a binary_byte/1:
@begin{verbatim}
binary_byte([bind(B7), bind(B6), bind(B5),
             bind(B4), bind(B3), bind(B2), bind(B1), bind(B0)]) :-
    bind(B7),
    bind(B6),
    bind(B5),
    bind(B4),
    bind(B3),
    bind(B2),
    bind(B1),
    bind(B0).
@end{verbatim}
Then we create a type hex_byte/1:
@begin{verbatim}
hex_byte([hexd(H1), hexd(H0)]) :-
    hexd(H1),
    hexd(H0).
@end{verbatim}

Then we can just say a byte/1 is either a hex_byte or a binary_byte:
@begin{verbatim}
byte(HB) :-
    hex_byte(HB).

byte(BB) :-
    binary_byte(BB).

@end{verbatim}

@section{Predicate 1: byte_list/1}
This predicate is true when the given list is composed of lists of 8 binary digits or 2 hexadecimal digits. They must all have the same representation.
@begin{verbatim}
? - byte_list([
		[bind(0),bind(0),bind(0),bind(0),bind(0),bind(0),bind(0),bind(1)], 
		[bind(0),bind(0),bind(0),bind(0),bind(0),bind(0),bind(0),bind(0)],
		[bind(0),bind(0),bind(0),bind(0),bind(0),bind(1),bind(0),bind(1)],
		[bind(0),bind(0),bind(0),bind(0),bind(0),bind(1),bind(0),bind(0)]]
		).
yes

? - byte_list([[hexd(0),hexd(a)], [hexd(b),hexd(9)], [hexd(1),hexd(f)],
	[hexd(5),hexd(6)], [hexd(7),hexd(8)]]).
   
yes

?- byte_list(X).

X = [] ? ;

X = [[hexd(0),hexd(0)]] ? ;

X = [[hexd(0),hexd(0)],[hexd(0),hexd(0)]] ? ;

X = [[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)]] ? ;

X = [[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)]] ? ;

X = [[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)]] ? ;

X = [[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)],[hexd(0),hexd(0)]] ? 

yes
@end{verbatim}


@section{Predicate 2: byte_conversion/2}
True when the first argument is a list of 2 hexd/1 elements which is the equivalent for the second argument which is list of 8 elements bind/1.
@begin{verbatim}
?- byte_conversion([hexd(0), hexd(0)], [bind(0),bind(0),bind(0),bind(0),bind(0),bind(0),bind(0),bind(0)]).

yes

?- byte_conversion([hexd(f), hexd(f)], X).

X = [bind(1),bind(1),bind(1),bind(1),bind(1),bind(1),bind(1),bind(1)] ? 

yes

?- byte_conversion(X,[bind(1),bind(1),bind(1),bind(1),bind(1),bind(1),bind(1),bind(1)]).

X = [hexd(f),hexd(f)] ? 

yes
@end{verbatim}


@section{Predicate 3: byte_list_conversion/2}
True when the first argument is a list of lists of 2 hexd/1 elements which is the equivalent for the second argument which is list of lists of 8 elements bind/1.
@begin{verbatim}
?- byte_list_conversion([[hexd(3),hexd(5)],[hexd(4),hexd(e)]],BL).

BL = [[bind(0),bind(0),bind(1),bind(1),bind(0),bind(1),bind(0),bind(1)],[bind(0),bind(1),bind(0),bind(0),bind(1),bind(1),bind(1),bind(0)]] ? 

yes

?- byte_list_conversion(X, [[bind(0),bind(0),bind(1),bind(1),bind(0),bind(1),bind(0),bind(1)],[bind(0),bind(1),bind(0),bind(0),bind(1),bind(1),bind(1),bind(0)]]).

X = [[hexd(3),hexd(5)],[hexd(4),hexd(e)]] ? 

yes
@end{verbatim}


@section{Predicate 4: get_nth_bit_from_byte/3}
True when the third argument is the bind/1 element, in the position given by first argument which is in peano number format, starting counting from the least significant bit in the second argument whic is byte/1.
@begin{verbatim}
?- get_nth_bit_from_byte(s(s(s(s(s(0))))),[bind(1),bind(0) ,bind(1),bind(0),bind(1),bind(1),bind(0),bind(0)], B).


B = bind(1) ? 
yes

?- get_nth_bit_from_byte(0,[hexd(0),hexd(1)],B).

B = bind(1) ? 

yes

?- get_nth_bit_from_byte(s(0), [ hexd(0) , hexd(X)] , bind(0)).

X = 0 ? ;

X = 1 ? ;

X = 4 ? ;

X = 5 ? ;

X = 8 ? ;

X = 9 ? ;

X = c ? ;

X = d ? ;

no

@section{Predicate 5: byte_list_crsh/2}
True when the second argument is the left circularly shifted list of lists of byte/1 of the first list of lists of bind/1. All elements must have the same representation
@begin{verbatim}

@end{verbatim}

@section{Predicate 6: byte_list_clsh/2}
True when the second argument is the right circularly shifted list of lists of byte/1 of the first arargument which is also list of lists of bind/1. All elements must have the same representation
@begin{verbatim}

@end{verbatim}

@section{Predicate 7: byte_xor/3}
True when the third argument is the result of the binary XOR operation between the first elemt and second which are bytes/1.
byte_xor(B1,B2,B) :-
@begin{verbatim}

@end{verbatim}
").



% Define a binary digit type.
:- pred bind(X)
   #"Bit representation where @var{X} is either 1 or 0. @includedef{bind/1}".
bind(0).
bind(1).

:- pred binary_byte(B)
   #"Checks whether @var{B} is a list of 8 elements of bind/1. @includedef{binary_byte/1}".
% Define a binary byte as a list of 8 binary digits.
binary_byte([bind(B7), bind(B6), bind(B5),
             bind(B4), bind(B3), bind(B2), bind(B1), bind(B0)]) :-
    bind(B7),
    bind(B6),
    bind(B5),
    bind(B4),
    bind(B3),
    bind(B2),
    bind(B1),
    bind(B0).

:- pred hexd(X)
   #"Hex digit representation where @var{X} is ranges from 0 to 9 or a to f. @includedef{hexd/1}".
% Define a hex digit (nibble) type.
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

:- pred hex_byte(X)
   #"Hexadecimal byte representation where @var{X} is a list containing two elements that are hexd/1. @includedef{hex_byte/1}".
hex_byte([hexd(H1), hexd(H0)]) :-
    hexd(H1),
    hexd(H0).

:- pred byte(X)
   #"Byte representation where @var{X} is either hexd/1 or X is true for binary_byte/1. @includedef{byte/1}".
% Define a byte type either as a binary byte or as a hex byte.
byte(HB) :-
    hex_byte(HB).

byte(BB) :-
    binary_byte(BB).




% Predicado 1
:- pred byte_list(X)
   #"True when @var{X} is a list whose elements are true for byte/1. @includedef{byte_list/1}".
byte_list([]). % base case
byte_list([Lh|Lt]):-
    byte(Lh), % check if head is byte
    byte_list(Lt). % recursive with tail

% Predicado 2
:- pred nibble_bits(X, Y)
   #"True when @var{X} is the hexd/1 representation for @var{Y} which is list of 4 elements bind/1. @includedef{nibble_bits/2}".
% Table of nibble to bits
nibble_bits(hexd(0), [bind(0), bind(0), bind(0), bind(0)]).
nibble_bits(hexd(1), [bind(0), bind(0), bind(0), bind(1)]).
nibble_bits(hexd(2), [bind(0), bind(0), bind(1), bind(0)]).
nibble_bits(hexd(3), [bind(0), bind(0), bind(1), bind(1)]).
nibble_bits(hexd(4), [bind(0), bind(1), bind(0), bind(0)]).
nibble_bits(hexd(5), [bind(0), bind(1), bind(0), bind(1)]).
nibble_bits(hexd(6), [bind(0), bind(1), bind(1), bind(0)]).
nibble_bits(hexd(7), [bind(0), bind(1), bind(1), bind(1)]).
nibble_bits(hexd(8), [bind(1), bind(0), bind(0), bind(0)]).
nibble_bits(hexd(9), [bind(1), bind(0), bind(0), bind(1)]).
nibble_bits(hexd(a), [bind(1), bind(0), bind(1), bind(0)]).
nibble_bits(hexd(b), [bind(1), bind(0), bind(1), bind(1)]).
nibble_bits(hexd(c), [bind(1), bind(1), bind(0), bind(0)]).
nibble_bits(hexd(d), [bind(1), bind(1), bind(0), bind(1)]).
nibble_bits(hexd(e), [bind(1), bind(1), bind(1), bind(0)]).
nibble_bits(hexd(f), [bind(1), bind(1), bind(1), bind(1)]).

:- pred byte_conversion(X, Y)
   #"True when @var{X} is a list of 2 hexd/1 elements and which is the equivalent for @var{Y} which is list of 8 elements bind/1. @includedef{byte_conversion/2}".
byte_conversion([hexd(H1), hexd(H2)],[bind(B1), bind(B2), bind(B3), bind(B4),bind(B5), bind(B6), bind(B7), bind(B8)]) :-
    byte([hexd(H1), hexd(H2)]), % We check it's a byte
    % we convert the first half and the second half
    nibble_bits(hexd(H1),[bind(B1), bind(B2), bind(B3), bind(B4)]),
    nibble_bits(hexd(H2), [bind(B5), bind(B6), bind(B7), bind(B8)]).

% Predicado 3
:- pred byte_list_conversion(X, Y)
   #"True when @var{X} is a list of lists whose elements are  or lists of 2 hexd/1 elements,  @var{Y} is a list of lists whose elements are lists of 8 bind/1 elements which are the equivalent of @var{X} . @includedef{byte_list_conversion/2}".
byte_list_conversion([], []). % base case
byte_list_conversion([FirstList|Rest1], [SecondList|Rest2]) :-
    byte_conversion(FirstList,SecondList), % apply byte_conversion for element
    byte_list_conversion(Rest1, Rest2). % recursive call with next element

% Predicado 4
% Base case is when we have got 8 in peanos in the first arg, we take the head of the list and that is our result
:- pred get_nth_bit_from_byte(N,B,Nth)
   #"True when @var{Nth} is the bind/1, in the position given by @var{N} which is in peano number format, starting counting from the least significant bit in the @var{B} byte/1. @includedef{get_nth_bit_from_byte/3}".
get_nth_bit_from_byte(s(s(s(s(s(s(s(0))))))), [Nth|Tail], Nth).
get_nth_bit_from_byte(N, B, Nth):-
    hex_byte(B), % we check if it's a hex in case we need to convert
    byte_conversion(B, X), % we convert hex to bits
    get_nth_bit_from_byte(N, X, Nth). % recursive call with converted

% case with list of bytes
get_nth_bit_from_byte(N, [Head|Tail], Nth) :-
    get_nth_bit_from_byte(s(N), Tail, Nth). % recursive with succesor of given number

% Predicado 5
:- pred byte_list_clsh(X,Y)
   #"True when @var{X} is the left circularly shifted list of lists of byte/1 of @var{Y}. @includedef{byte_list_clsh/2}".
% case for hex_bytes
byte_list_clsh([First|ByteList], Res) :-
    hex_byte(First),
    byte_list_conversion([First|ByteList], X), % convert to bits
    clsh(X, X2), % list shifter
    byte_list_conversion(Res, X2). % convert back for result

% case for bits 
byte_list_clsh([First|ByteList],Res):-
    binary_byte(First), 
    clsh([First|ByteList],Res).% list shifter
:- pred clsh(X,Y)
   #" @includedef{clsh/2}".
clsh(ByteList, Res) :-
    my_flattener(ByteList, Flattened), % convert list of lists to single list
    rotate_left(Flattened, Rotated), % circular shift to the left
    my_flattener(Res,Rotated). % unflatten the list into bytes

:- pred my_append(X,Y,Z)
   #"True when @var{Z} is the list composed by @var{Y} whose last element is @var{X}. @includedef{my_append/2}".
my_append([],X,X). % base case when the given list to append is empty
my_append([H|T],X,[H|S]) :-
    my_append(T,X,S). % new item to append is tail of first list and result must be the tail of second list
:- pred my_flattener(X,Y)
   #"True when @var{Y} is the list composed by all elements inside the lists of lists which composes @var{Y}. @includedef{my_append/2}".
my_flattener([],[]). % base case when both lists are empty
my_flattener([[X1,X2,X3,X4,X5,X6,X7,X8]|X],[X1,X2,X3,X4,X5,X6,X7,X8|Y]) :-
    my_flattener(X,Y).
:- pred rotate_left(X,Y)
   #"True when @var{Y} is the leftly circularly shifted list @var{X}. @includedef{rotate_left/2}".
rotate_left([Head|Tail] , Rotated ) :-  
  my_append(Tail,[Head],Rotated).  % append head to tail to rotate

% Predicado 6

% The idea is the same except that we call the shifter with arguments reversed
:- pred byte_list_crsh(X,Y)
   #"True when @var{X} is the right circularly shifted list of lists of byte/1 of @var{Y}. @includedef{byte_list_crsh/2}".
byte_list_crsh([First|ByteList], Res) :-
    hex_byte(First),
    byte_list_conversion([First|ByteList], X),
    crsh(X, X2),
    byte_list_conversion(Res, X2).

byte_list_crsh([First|ByteList],Res):-
    binary_byte(First),
    crsh([First|ByteList],Res).
:- pred crsh(X,Y)
   #" @includedef{crsh/2}".
crsh(ByteList, Res) :-
    my_flattener(ByteList, Flattened),
    rotate_left(Rotated, Flattened), % reversed arguments
    my_flattener(Res,Rotated).



% Predicado 7
% XOR table
:- pred conversor_xor(X, Y, Z)
   #"True when @var{Z} is the result of the binary XOR operation between @var{X} and @var{Y} which are bind/1. @includedef{conversor_xor/3}".
conversor_xor(bind(0), bind(0), bind(0)).
conversor_xor(bind(0), bind(1), bind(1)).
conversor_xor(bind(1), bind(0), bind(1)).
conversor_xor(bind(1), bind(1), bind(0)).

:- pred byte_xor(X, Y, Z)
   #"True when @var{Z} is the result of the binary XOR operation between @var{X} and @var{Y} which are bytes/1. @includedef{byte_xor/3}".
% Bin bytes case
byte_xor(B1, B2, B) :-
    binary_byte(B1),
    binary_byte(B2),
    bin_xor(B1, B2, B).  % general case

% Hex bytes case
byte_xor(B1, B2, H) :-
    hex_byte(B1),
    hex_byte(B2),
     % convert to bin byte for general case
    byte_conversion(B1, X1), 
    byte_conversion(B2, X2),
    bin_xor(X1, X2, B3), % general case
    byte_conversion(H,B3). % convert back for result

:- pred bin_xor(X, Y, Z)
   #" @includedef{byte_xor/3}".
bin_xor([],[],[]). % base case
% general case
bin_xor([Bit1|RestBits1], [Bit2|RestBits2], [Result | RestResut]) :-
    conversor_xor(Bit1, Bit2, Result), % xor operation
    bin_xor(RestBits1, RestBits2, RestResut). % recursive with next bit









