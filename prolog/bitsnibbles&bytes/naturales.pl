% Numeros naturales
nat(0).
nat(s(X)) :- 
    nat(X).

% Enteros
integer(0).
integer(s(X)) :- nat(X).
integer(-s(X)) :- nat(X).

less_or_equal(0,X) :- nat(X).
less_or_equal(s(X), S(Y)) :- less_or_equal(X,Y).

% suma y resta
plus(0,X,X) :- nat(X).
plus(s(X), Y, s(Z)) :- plus(X,Y,Z).
% X + Y = Z -> (1+X) + Y = (Z+1)
%              s(X)         s(Y)
% si preguntamos plus(12, X, 16) estariamos haciendo una resta -> X es un numero tal que 12+X = 16, es decir 16-4 = X

% multiplicacion y division
times(0,X,0) :- nat(X).
times(1,X,X) :- nat(X).
times(X,Y,Z) :- . 

factorial(0, 1).
% factorial(X, Y) :- times(factorial(s(X),Z),X,Y). maaal no se puede llamar a funciones dentro de otras 
factorial(X, Y) :- factorial(s(X),Z), times(Z,X,Y).
% factorial de X es Y si factorial(X-1)* X = Y 





