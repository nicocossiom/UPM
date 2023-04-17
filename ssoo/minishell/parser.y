%{
/*-
 * parser.y
 * Minishell "yacc" source
 * Describes valid input grammar
 * Exports "obtain_order" input interface function.
 *
 * Copyright (c) 1993-2002-2019, Francisco Rosales <frosal@fi.upm.es>
 * Todos los derechos reservados.
 *
 * Publicado bajo Licencia de Proyecto Educativo Práctico
 * <http://laurel.datsi.fi.upm.es/~ssoo/LICENCIA/LPEP>
 *
 * Queda prohibida la difusión total o parcial por cualquier
 * medio del material entregado al alumno para la realización 
 * de este proyecto o de cualquier material derivado de este, 
 * incluyendo la solución particular que desarrolle el alumno.
 *
 * DO NOT MODIFY THIS FILE
 */

#include <stddef.h>			/* NULL */
#include <stdlib.h>			/* malloc */
#include <string.h>			/* strlen */
#include <unistd.h>			/* write */

extern int yyparse(void);
extern int yylex(void);

void yyerror(char *s)
{
	write(2,s,strlen(s));
	write(2,"\n",1);
}

int yywrap(void)
{
	return 1;
}

static char *** argvv;
static int argvc;
static int argc;
static char * filev[3];
static int bg;

static void freevv(char ***ppp);
static void pipeline(void);
static void command(char *arg);
%}

%start minish
%token TXT
%right '|'
%union { char * txt; }
%type <txt> TXT

%%
minish	:			{ return(0); }
	| line end		{ return(argvc+1); }
	| error end		{ yyerrok; return(-1); }
	;

line	:
	| pipel redir backg
	;

pipel	: comma			{ pipeline(); }
	| pipel '|' comma	{ pipeline(); }
	;

comma	: TXT			{ command($1); }
	| comma TXT		{ command($2); }
	;

redir	:
	| '<' TXT redir		{ if(filev[0]) YYERROR; filev[0] = $2; }
	| '>' TXT redir		{ if(filev[1]) YYERROR; filev[1] = $2; }
	| '>' '&' TXT redir	{ if(filev[2]) YYERROR; filev[2] = $3; }
	;

backg	:
	| '&'			{ bg = 1; }
	;

end	: '\n'
	;
%%

#define zfree(p) { if(p) { free(p); p = NULL; } }
#define zfreevv(ppp) { if(ppp) { freevv(ppp); ppp = NULL; } }

static void freevv(char ***ppp)
{
	char **pp;
	for (; ppp && *ppp; ppp++)
		for (pp = *ppp; pp && *pp; pp++)
			zfree(*pp);
}

static void pipeline(void)
{
	argvc++;
}

#define argv argvv[argvc]

static void command(char *arg)
{
	if (!argvv) {
		argvc = 0;
		argvv = calloc(1, sizeof(char **));
	}
	if (!argv) {
		argvv = realloc(argvv, (argvc + 2) * sizeof(char **));
		argvv[argvc + 1] = NULL;
		argc = 0;
		argv = calloc(1, sizeof(char *));
	}
	argv = realloc(argv, (argc + 2) * sizeof(char *));
	argv[argc++] = arg;
	argv[argc] = NULL;
}

/* 
 * Input interface function
 * Returns:
 *   -1, at syntax error
 *    0, at end of file on input
 *   >0, number of commands in the pipeline + 1
 */
int obtain_order(char ****argvvp, char *filep[3], int *bgp)
/* argvvp is reference of a NULL terminated array of argvs */
/* filep is reference to an array of 3 char* */
/* bgp is reference to an integer */
{
	int ret;

	zfreevv(argvv);
	argvc = 0;
	zfree(filev[0]);
	zfree(filev[1]);
	zfree(filev[2]);
	bg = 0;

	ret = yyparse();

	*argvvp = argvv;
	filep[0] = filev[0];
	filep[1] = filev[1];
	filep[2] = filev[2];
	*bgp = bg;

	return ret;
}
