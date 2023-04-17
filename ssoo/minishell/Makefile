#
# Makefile
# Minishell "make" source
# Regenerate msh recompiling only modified sources.
#
# Copyright (c) 1993,2002,2019, Francisco Rosales <frosal@fi.upm.es>
# Todos los derechos reservados.
#
# Publicado bajo Licencia de Proyecto Educativo Práctico
# <http://laurel.datsi.fi.upm.es/~ssoo/LICENCIA/LPEP>
#
# Queda prohibida la difusión total o parcial por cualquier
# medio del material entregado al alumno para la realización 
# de este proyecto o de cualquier material derivado de este, 
# incluyendo la solución particular que desarrolle el alumno.
#
# DO NOT MODIFY THIS FILE
#

CC	= gcc
CFLAGS	= -Wall -g
YACC	= bison --yacc
YFLAGS	= -d
LEX	= flex
LFLAGS	=

OBJS	= parser.o scanner.o main.o

all: msh

msh: $(OBJS)
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $(OBJS)

clean:
	rm -f *.tab.? *.o *.bak *~ parser.c scanner.c core msh

cleanall: clean
	rm -f :* freefds* nofiles* killmyself* sigdfl*

depend:
	makedepend main.c parser.y scanner.l

# DO NOT DELETE
