:- module(_1,_2,[assertions,regtypes,nativeprops]).

:- true pred author_data(_A,_B,_C,_D)
   : ( term(_A), term(_B), term(_C), term(_D) )
   => ( rt0(_A), rt1(_B), rt2(_C), rt3(_D) ).

:- true pred author_data(_A,_B,_C,_D)
   : mshare([[_A],[_A,_B],[_A,_B,_C],[_A,_B,_C,_D],[_A,_B,_D],[_A,_C],[_A,_C,_D],[_A,_D],[_B],[_B,_C],[_B,_C,_D],[_B,_D],[_C],[_C,_D],[_D]])
   => ground([_A,_B,_C,_D]).

author_data('Cossio','Miravalles','Nicolas','B190082').

:- true pred bind(_A)
   : term(_A)
   => rt6(_A).

:- true pred bind(_A)
   : mshare([[_A]])
   => ground([_A]).

bind(0).
bind(1).

:- true pred binary_byte(_A)
   : term(_A)
   => rt7(_A).

:- true pred binary_byte(_A)
   : mshare([[_A]])
   => ground([_A]).

binary_byte([bind(B7),bind(B6),bind(B5),bind(B4),bind(B3),bind(B2),bind(B1),bind(B0)]) :-
    bind(B7),
    bind(B6),
    bind(B5),
    bind(B4),
    bind(B3),
    bind(B2),
    bind(B1),
    bind(B0).

:- true pred hexd(_A)
   : term(_A)
   => rt38(_A).

:- true pred hexd(_A)
   : mshare([[_A]])
   => ground([_A]).

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

:- true pred byte(HB)
   : term(HB)
   => rt40(HB).

:- true pred byte(HB)
   : mshare([[HB]])
   => ground([HB]).

byte(HB) :-
    hex_byte(HB).
byte(BB) :-
    binary_byte(BB).

:- true pred hex_byte(_A)
   : term(_A)
   => rt39(_A).

:- true pred hex_byte(_A)
   : mshare([[_A]])
   => ground([_A]).

hex_byte([hexd(H1),hexd(H0)]) :-
    hexd(H1),
    hexd(H0).

:- true pred byte_list(_A)
   : term(_A)
   => list([rt43,rt43|rt42],_A).

:- true pred byte_list(_A)
   : mshare([[_A]])
   => ground([_A]).

byte_list([]).
byte_list([Lh|Lt]) :-
    byte(Lh),
    byte_list(Lt).

:- true pred nibble_bits(_A,_B)
   : ( term(_A), term(_B) )
   => ( rt128(_A), rt113(_B) ).

:- true pred nibble_bits(_A,_B)
   : mshare([[_A],[_A,_B],[_B]])
   => ground([_A,_B]).

nibble_bits(hexd(0),[bind(0),bind(0),bind(0),bind(0)]).
nibble_bits(hexd(1),[bind(0),bind(0),bind(0),bind(1)]).
nibble_bits(hexd(2),[bind(0),bind(0),bind(1),bind(0)]).
nibble_bits(hexd(3),[bind(0),bind(0),bind(1),bind(1)]).
nibble_bits(hexd(4),[bind(0),bind(1),bind(0),bind(0)]).
nibble_bits(hexd(5),[bind(0),bind(1),bind(0),bind(1)]).
nibble_bits(hexd(6),[bind(0),bind(1),bind(1),bind(0)]).
nibble_bits(hexd(7),[bind(0),bind(1),bind(1),bind(1)]).
nibble_bits(hexd(8),[bind(1),bind(0),bind(0),bind(0)]).
nibble_bits(hexd(9),[bind(1),bind(0),bind(0),bind(1)]).
nibble_bits(hexd(a),[bind(1),bind(0),bind(1),bind(0)]).
nibble_bits(hexd(b),[bind(1),bind(0),bind(1),bind(1)]).
nibble_bits(hexd(c),[bind(1),bind(1),bind(0),bind(0)]).
nibble_bits(hexd(d),[bind(1),bind(1),bind(0),bind(1)]).
nibble_bits(hexd(e),[bind(1),bind(1),bind(1),bind(0)]).
nibble_bits(hexd(f),[bind(1),bind(1),bind(1),bind(1)]).

:- true pred byte_conversion(_A,_B)
   : ( term(_A), term(_B) )
   => ( list(^(hexd(rt38)),_A), rt237(_B) ).

:- true pred byte_conversion(_A,_B)
   : mshare([[_A],[_A,_B],[_B]])
   => ground([_A,_B]).

byte_conversion([],[]).
byte_conversion([hexd(H1)|HRest],[bind(B1),bind(B2),bind(B3),bind(B4)|BRest]) :-
    nibble_bits(hexd(H1),[bind(B1),bind(B2),bind(B3),bind(B4)]),
    byte_conversion(HRest,BRest).

:- true pred byte_list_conversion(_A,_B)
   : ( term(_A), term(_B) )
   => ( list(list(^(hexd(rt38))),_A), list(rt237,_B) ).

:- true pred byte_list_conversion(_A,_B)
   : mshare([[_A],[_A,_B],[_B]])
   => ground([_A,_B]).

byte_list_conversion([],[]).
byte_list_conversion([FirstList|Rest1],[SecondList|Rest2]) :-
    byte_conversion(FirstList,SecondList),
    byte_list_conversion(Rest1,Rest2).

:- true pred my_reverse_accumulate(_A,Ys,_B)
   : ( term(_A), term(Ys), term(_B) )
   => ( list(_A), term(Ys), term(_B) ).

:- true pred my_reverse_accumulate(_A,Ys,_B)
   : mshare([[_A],[_A,Ys],[_A,Ys,_B],[_A,_B],[Ys],[Ys,_B],[_B]])
   => mshare([[_A,Ys,_B],[_A,_B],[Ys,_B]]).

my_reverse_accumulate([],Ys,Ys).
my_reverse_accumulate([X|Xs],Acc,Ys) :-
    my_reverse_accumulate(Xs,[X|Acc],Ys).

:- true pred my_reverse_accumulate(Xs,Ys)
   : ( term(Xs), term(Ys) )
   => ( list(Xs), list(Ys) ).

:- true pred my_reverse_accumulate(Xs,Ys)
   : mshare([[Xs],[Xs,Ys],[Ys]])
   => mshare([[Xs,Ys]]).

my_reverse_accumulate(Xs,Ys) :-
    my_reverse_accumulate(Xs,[],Ys).

:- true pred get_nth_bit_from_byte(N,B,Nth)
   : ( term(N), term(B), term(Nth) )
   => ( rt317(N), list(B), term(Nth) ).

:- true pred get_nth_bit_from_byte(N,B,Nth)
   : mshare([[N],[N,B],[N,B,Nth],[N,Nth],[B],[B,Nth],[Nth]])
   => ( mshare([[B],[B,Nth]]),
        ground([N]) ).

get_nth_bit_from_byte(s(N),B,Nth) :-
    hex_byte(B),
    byte_conversion(B,X),
    get_nth_bit_from_byte(s(N),X,Nth).
get_nth_bit_from_byte(N,B,Nth) :-
    my_reverse_accumulate(B,X),
    get_nth_bit(N,X,Nth).

:- true pred get_nth_bit(_A,_B,Nth)
   : ( term(_A), term(_B), term(Nth) )
   => ( rt317(_A), list_functor(_B), term(Nth) ).

:- true pred get_nth_bit(_A,_B,Nth)
   : mshare([[_A],[_A,_B],[_A,_B,Nth],[_A,Nth],[_B],[_B,Nth],[Nth]])
   => ( mshare([[_B],[_B,Nth]]),
        ground([_A]) ).

get_nth_bit(0,[Nth|_1],Nth).
get_nth_bit(s(N),[_1|Rest],Nth) :-
    get_nth_bit(N,Rest,Nth).


:- regtype rt0/1.
rt0('Cossio').

:- regtype rt1/1.
rt1('Miravalles').

:- regtype rt2/1.
rt2('Nicolas').

:- regtype rt3/1.
rt3('B190082').

:- regtype rt7/1.
rt7([bind(A),bind(B),bind(C),bind(D),bind(E),bind(F),bind(G),bind(H)]) :-
    rt6(A),
    rt6(B),
    rt6(C),
    rt6(D),
    rt6(E),
    rt6(F),
    rt6(G),
    rt6(H).

:- regtype rt6/1.
rt6(0).
rt6(1).

:- regtype rt43/1.
rt43(bind(A)) :-
    rt6(A).
rt43(hexd(A)) :-
    rt38(A).

:- regtype rt42/1.
rt42([]).
rt42([bind(A),bind(B),bind(C),bind(D),bind(E),bind(F)]) :-
    rt6(A),
    rt6(B),
    rt6(C),
    rt6(D),
    rt6(E),
    rt6(F).

:- regtype rt40/1.
rt40([A,B|C]) :-
    rt43(A),
    rt43(B),
    rt42(C).

:- regtype rt237/1.
rt237([]).
rt237([bind(A),bind(B),bind(C),bind(D)|E]) :-
    rt6(A),
    rt6(B),
    rt6(C),
    rt6(D),
    rt237(E).

:- regtype rt317/1.
rt317(0).
rt317(s(A)) :-
    rt317(A).

:- regtype rt39/1.
rt39([hexd(A),hexd(B)]) :-
    rt38(A),
    rt38(B).

:- regtype rt38/1.
rt38(0).
rt38(1).
rt38(2).
rt38(3).
rt38(4).
rt38(5).
rt38(6).
rt38(7).
rt38(8).
rt38(9).
rt38(a).
rt38(b).
rt38(c).
rt38(d).
rt38(e).
rt38(f).

:- regtype rt128/1.
rt128(hexd(A)) :-
    rt38(A).

:- regtype rt113/1.
rt113([bind(A),bind(B),bind(C),bind(D)]) :-
    rt6(A),
    rt6(B),
    rt6(C),
    rt6(D).

