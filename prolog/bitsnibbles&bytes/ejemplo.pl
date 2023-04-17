:- module(_, _, [assertions]).

:- doc(title, "An example of documentation and tests").

:- doc(author, "Isabel Garcia, C347963").
:- doc(author, "Manuel Hermenegildo, D165125").

:- doc(module, "This module defines a calculator for Peano numbers.

The numbers accepted by this calculator have to be of the form: 
@includedef{nat/1}

@subsection{Examples of use:}

@begin{enumerate}
@item Adding two numbers:
@begin{verbatim}
?- calculate('+', 0, s(0), X).

X = s(0) ? 
yes
?- 
@end{verbatim}
@item Subtracting two numbers:
@begin{verbatim}
?- calculate('-', s(s(0)), s(0), X).

X = s(0) ? 
yes
?- 
@end{verbatim}
@end{enumerate}

The available operations are:
@includedef{operation/1}

@section{Generating the documentation}

This documentation has been generated automatically by the
@href{http://ciao-lang.org/ciao/build/doc/lpdoc.html/}{@bf{lpdoc}}
tool. 

@begin{itemize}

@item To generate it, after opening the file inside Emacs, select the
  following menu options: 
 
  @tt{LPdoc -> Generate documentation for buffer} 

  (or type @key{C-c} @key{D} @key{B}).  You can also type

  @tt{lpdoc -t html calculator.pl} 

  or 

  @tt{lpdoc -t pdf calculator.pl} 

  at the command line.  

@item For visualizing the output, select: 

  @tt{LPdoc -> View documentation in selected format} 

  (or type @key{C-c} @key{D}  @key{V}), or 

  @tt{lpdoc --view calculator.pl} 

  at the command line.

@end{itemize}

You can select different formats such as @tt{pdf} or @tt{html} at
generation time. For generating @tt{pdf} directly from @tt{lpdoc} you
need to have a TeX/LaTeX distribution such as TeX Live, etc. installed
(depending on the distribution you may need to install @tt{texlive},
@tt{texinfo}, and @tt{imagemagick}). Alternatively, you can also
generate the @tt{html}, open it in a browser, and then save it from
the browser to @tt{pdf} (e.g., by @em{printing} it to a @tt{pdf}
file).

@begin{alert}
This module includes some formatting commands but there are many more in:
@href{http://ciao-lang.org/ciao/build/doc/lpdoc.html/comments.html#stringcommand/1}.
@end{alert}

To document each predicate, specific assertions are used. For example:
@begin{verbatim}
:- pred calculate(Op,A,B,C)
   # \"@var{C} is the result from applying operation 
      @var{Op} to @var{A} and @var{B}.\".
@end{verbatim}

With assertions you can also specify and check types and many other properties. 

For more information consult: @p
@href{http://ciao-lang.org/ciao/build/doc/lpdoc.html/assertions_doc.html}.

A question often asked is how to do accents: in text that is within
strings use @tt{@@'@{...@}} and @tt{@@~@{...@}} for e@~{n}e. E.g.: 

@begin{verbatim}
:- doc(title, ""Programaci@'{o}n L@'{o}gica""). 
@end{verbatim}

In @tt{alumno_prode/4} facts you can use accents, but please remeber
to always put the arguments in single quotes, @tt{'...'}, to make sure
they are constants:

@begin{verbatim}
alumno_prode('Ãlvaro', 'FernÃ¡ndez', 'GÃ³mez', 'Y16M025').
@end{verbatim}


@section{Automatic tests}

This module also includes some assertions that start with @tt{:- test}. For example: 
@begin{verbatim}
:- test calculate(Op,A,B,C) 
      :  (Op = '+', A = 0, B = 0) 
      => (C = 0) + not_fails # ""Base case."".
@end{verbatim}

These assertions define test cases. Given an assertion:

@tt{:- test @em{Head} : @em{Call} => @em{Exit} + @em{Comp}.}

@var{Head} denotes the predicate to which the assertion applies,
@var{Call} describes the values to call the predicate with for the
test, @var{Exit} defines the expected values upon exit @bf{if the
predicate succeeds} and @var{Comp} will be used to define global
properties, for example if the predicate should fail or succeed for
that call:

@begin{itemize}

@item @tt{not_fails}: means that the call to the predicate with the
values in @var{Call} will generate at least one solution.

@item @tt{fails}: means that the call to the predicate with the values
in @var{Call} will fail.

@end{itemize}

@subsection{Including tests in the documentation}

You can have @apl{lpdoc} include the tests in the documentation. For
this, include option @tt{--doc_mainopts=tests} in the @apl{lpdoc}
command. E.g., at the command line:

@tt{lpdoc -t html --doc_mainopts=tests calculator.pl} 

Or, if you are generating the manual from Emacs, switch to
the @tt{*LPdoc*} buffer (you can use the 'Buffers' menu) and 
issue the command:  

@tt{lpdoc ?- doc_cmd('SETTINGS.pl',[name_value(doc_mainopts,tests)],gen(html)).}

@subsection{Launching the tests automatically}

To run the tests, open the @tt{.pl} file inside Emacs and select the
following menu options: @tt{CiaoDbg -> Run tests in current module}
(or type @key{C-c} @key{u}).

Note that when these tests are run the system by default tries to also
find a second solution for each test (i.e., like typing @key{;} in the
top level).

").

:- prop operation(Op) #"@var{Op} is an operation accepted by the calculator. @includedef{operation/1}".
operation('+').
operation('-').

:- test calculate(Op,A,B,C) : (Op = '+', A = 0, B = 0) => (C = 0) + not_fails # "Base case".
:- test calculate(Op,A,B,C) : (Op = '+', A = s(s(0)), B = s(0)) => (C = s(s(s(0)))) + not_fails.
:- test calculate(Op,A,B,C) : (Op = '-', A = 0, B = s(0)) + fails # "The result can only be a negative number.".

:- pred calculate(Op,A,B,C)
   #"@var{C} is the result of applying operation @var{Op} to @var{A} and @var{B}. @includedef{calculate/4}".
calculate('+',A,B,C) :-
    sum(A,B,C).
calculate('-',A,B,C) :-
    sum(B,C,A).

:- pred sum(A,B,C)
   #"@var{C} is the sum of @var{A} and @var{B} in Peano format. @includedef{sum/3}".
sum(0,X,X) :- nat(X).
sum(s(X),Y,s(Z)) :-
    sum(X,Y,Z).

:- prop nat/1 #"Natural number. @includedef{nat/1}".
nat(0).
nat(s(X)) :-
    nat(X).