/*-
 * main.c
 * Minishell C source
 * Shows how to use "obtain_order" input interface function.
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
 * DO NOT MODIFY ANYTHING OVER THIS LINE
 * THIS FILE IS TO BE MODIFIED
 */

#include <fcntl.h>
#include <limits.h>
#include <signal.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/resource.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>
#include <unistd.h>
#define _GNU_SOURCE
#include <dirent.h>
#include <errno.h>
#include <pwd.h>
#include <sys/types.h>
/* --------------------------------------
        Global variables declarations
   -------------------------------------- */
#define READ_END 0
#define WRITE_END 1
static char CWD[PATH_MAX];
static pid_t PIDSHELL;
int ORIGINAL_FDS[3] = {-1, -1, -1};
/* ------------------------------------------------------------------------------------------
                                    Function declarations
   ------------------------------------------------------------------------------------------ */
extern int obtain_order(); /* See parser.y for description */
void metachars(char **command);
int limitIF(char **commands, int length);
int check_resouce(const char *resource);
int setIF(char **command, int length);
int umaskIF(char **command, int length);
int cdIF(char **command, int length);
bool isInternalFunction(char **command, int length, char **redirects);
int executeInternalFunction(char **mandato, int length, char **redirects);
int redirect_if_needed(char **redirects);
int *printArguments(char ***argvv, int num_command_n, char **redirects, int bg);
void promptPrint();
int redirect(int which, char *filename);
void error(char *errorString);
/* ------------------------------------------------------------------------------------------
                                         Main program
------------------------------------------------------------------------------------------ */
int main(void) {
    char ***argvv = NULL;
    int num_command_n;
    char *redirects[3] = {NULL, NULL, NULL};
    int bg;
    int ret;
    int background_pid = 0;

    signal(SIGINT, SIG_IGN);   // capture ctrl-c and handle
    signal(SIGQUIT, SIG_IGN);  // capture Ctrl+shitft+\ and handle

    setbuf(stdout, NULL); /* Unbuffered */
    setbuf(stdin, NULL);
    PIDSHELL = getpid();
    char pidstring[7];
    sprintf(pidstring, "%d", PIDSHELL);
    setenv("mypid", pidstring, 1);
    setenv("prompt", "msh> ", 1);

    fprintf(stderr, "MINISHELL launched with pid : %d\n", PIDSHELL);

    while (1) {
        promptPrint();
        getcwd(CWD, sizeof(CWD));
        ret = obtain_order(&argvv, redirects, &bg);  // obtiene el número de arguments
        if (ret == 0) {
            fprintf(stderr, "\nExiting minishell on ctrl-D\n");
            break;
        }                                 /* EOF */
        if (ret == -1) continue;          /* Syntax error */
        num_command_n = ret - 1;          /* Line */
        if (num_command_n == 0) continue; /* Empty line */
#if 1
        int N_commands = num_command_n;
        /* in a command how many arguments + command itself
        ex: ls -l -h | grep algo -> argvcarr = [3, 2] */
        int *argvcarr = printArguments(argvv, num_command_n, redirects, bg);
        bool pipe_necessary = NULL;
        char **mandato;
        int last_pipe_fd = 0;
        pipe_necessary = N_commands > 1;
        if (pipe_necessary) {
            ORIGINAL_FDS[0] = dup(STDIN_FILENO);
        }
        for (num_command_n = 0; (mandato = argvv[num_command_n]); num_command_n++) {
            // fprintf(stderr, "num_command_n: %d argvcarr %d ", num_command_n, *argvcarr);
            int n_args = argvcarr[num_command_n] - 1;
            fprintf(stderr, "Procesando mandato numero %d, \"%s\" con %d argumento/s\n", num_command_n, mandato[0], n_args);
            metachars(mandato);
            if (mandato == NULL) {
                if (pipe_necessary)
                    break;
                else
                    continue;  // si es un mandato inexpanisble pasar al siguiente (se habrá mandado error)
            }
            // fprintf(stderr, "pipe? %s\n", pipe_necessary ? "True" : "False");
            int inter_pipe[2];
            bool last_command = num_command_n == N_commands - 1;
            bool internal_function = isInternalFunction(mandato, argvcarr[num_command_n], redirects);
            if (internal_function && last_command && !bg) {
                int which_redirected = redirect_if_needed(redirects);
                if (which_redirected != -1) {
                    // si no hay error al redirigir, se puede ejecutar
                    bool does_redirect = which_redirected != 4;
                    executeInternalFunction(mandato, argvcarr[num_command_n], redirects);
                    if (does_redirect) {
                        // restauran los fds
                        for (int i = 0; i < 3; i++) {
                            if (ORIGINAL_FDS[i] != -1) {
                                dup2(ORIGINAL_FDS[i], i);
                                ORIGINAL_FDS[i] = -1;
                            }
                        }
                    }
                }
            } else {
                pid_t pid;
                if (pipe_necessary && (pipe(inter_pipe) < 0)) error("Error in pipe creation");
                switch (pid = fork()) {
                    case -1:
                        error("fork de mandato");
                        exit(1);
                        break;
                    case 0:
                        // fprintf(stderr, "En proceso hijo: %d \n", getpid());
                        // sleep(10);
                        // fprintf(stderr, "stopped sleeping\n");

                        if (last_command) {
                            if (redirects[1]) {
                                // si es el ultimo comando y hay que redirigir stdout
                                if (redirect(1, redirects[1]) == -1) {
                                    return -1;
                                }
                            }
                        }

                        if (num_command_n == 0) {
                            if (redirects[0]) {
                                // primer comando, mirar si hay que redirigir stdin
                                if (redirect(0, redirects[0]) == -1) {
                                    return -1;
                                }
                            }
                        }

                        if (redirects[2]) {
                            // redirigir error en todos los procesos
                            if (redirect(2, redirects[2]) == -1) {
                                return -1;
                            }
                        }

                        // do not ignore signals if it's not background
                        if (!bg) {
                            signal(SIGINT, SIG_DFL);
                            signal(SIGQUIT, SIG_DFL);
                        }

                        if (pipe_necessary) {
                            /* last_pipe_fd has the fd of the last pipe that we need to read from, we need to set it to the stdin of this child*/
                            if (last_pipe_fd != STDIN_FILENO) {  // if not the first command (we initialized set last_pipe_fd to 0 so we can use it to know if it's the firs comman )
                                if (dup2(last_pipe_fd, STDIN_FILENO) < 0) error("dup 2 last_pipe_fd, STDIN");
                                if (!last_command && (close(last_pipe_fd) < 0)) error("closing last_pipe_fd when not last command");
                            }
                            if (inter_pipe[WRITE_END] != STDOUT_FILENO) {
                                if (!last_command && dup2(inter_pipe[WRITE_END], STDOUT_FILENO) < 0) error("dup 2 pipe[WR], STDOUT");  // stdout -> pipe
                            }
                            if (close(inter_pipe[WRITE_END]) < 0) error("closing pipe on son inter_pipe[WRITE_END]");
                            if (last_pipe_fd != STDIN_FILENO && close(last_pipe_fd) < 0) error("closing last_pipe_fd when != STDIN_FILENO (0)");
                            if (close(inter_pipe[READ_END]) < 0) error("closing pipe on son inter_pipe[READ_END]");
                        }

                        // fprintf(stderr, "--------------------------------------------------------\n\tEND OF CHILD DEBUGGING PART\n--------------------------------------------------------\n");
                        if (internal_function)
                            return executeInternalFunction(mandato, argvcarr[num_command_n], redirects);
                        else {
                            int ret_status = execvp(mandato[0], mandato);
                            if (ret_status != 0) {
                                char *error_message = malloc(sizeof(char) * 50);
                                sprintf(error_message, "'%s' exited, status(%d)", mandato[0], ret_status);
                                error(error_message);
                                free(error_message);
                            }
                            exit(EXIT_FAILURE);
                        }
                        break;
                    default:
                        if (pipe_necessary) {
                            if (close(last_pipe_fd) < 0) error("Closing pipe after fork"); /* close unused read end of the previous pipe */
                            if (!last_command) {
                                last_pipe_fd = dup(inter_pipe[READ_END]);
                            } else {
                                // restore stdin
                                dup2(ORIGINAL_FDS[0], STDIN_FILENO);
                                close(ORIGINAL_FDS[0]);
                            }
                            if (close(inter_pipe[WRITE_END]) < 0) error("closing pipe on father inter_pipe[WRITE_END]");
                            if (close(inter_pipe[READ_END]) < 0) error("closing pipe on father inter_pipe[READ_END]");
                        }
                        if (last_command) {
                            if (!bg) {
                                // waitpid(pid, NULL, 0);
                                int ret_status;
                                // fprintf(stderr, "Waiting on last command\n");
                                while (pid != wait(&ret_status)) {
                                    continue;
                                }
                                char stat_str[4];
                                sprintf(stat_str, "%d", ret_status);
                                setenv("status", stat_str, 1);
                            } else {
                                background_pid = pid;
                                fprintf(stdout, "[%d]\n", pid);
                                char backgr_pid_str[7];
                                sprintf(backgr_pid_str, "%d", background_pid);
                                setenv("bgpid", backgr_pid_str, 1);
                            }
                        }
                        break;
                }
            }
        }
    }
#endif
    return 0;
}
/* ------------------------------------------------------------------------------------------
                                    Function implementations
   ------------------------------------------------------------------------------------------ */
void error(char *errorString) {
    fprintf(stderr, "\033[1;31m");  // red color
    perror(errorString);
    fprintf(stderr, "\033[0m");  // reset
}
int redirect(int which, char *filename) {
    // fprintf(stderr, "REDIRECCIONANDO del proceso %d\n", getpid());
    int redirect_fd;
    if (which == 0) {
        redirect_fd = open(filename, O_RDONLY, 0666);
    } else {
        redirect_fd = open(filename, O_CREAT | O_TRUNC | O_WRONLY, 0666);
    }
    if (redirect_fd == -1) {
        error("error in redirection");
        return -1;
    }
    ORIGINAL_FDS[which] = dup(which);  // save original fds before changing them
    if (dup2(redirect_fd, which) < 0) {
        error("error in dup2 fd redirection for FD");
        return -1;
    }
    if (close(redirect_fd) < 0) {
        error("closing redirected_fd in redirect");
        return -1;
    }
    return 0;
}

void promptPrint() {
    // time_t rawtime;
    // struct tm *timeinfo;
    // time(&rawtime);
    // timeinfo = localtime(&rawtime);
    // fprintf(stderr, "\033[0;34m");  // blue color
    // fprintf(stderr, "\n\uF07C %s   ──   %s", CWD, asctime(timeinfo));
    // fprintf(stderr, "\033[0;32m");  // green color
    // fprintf(stderr, "> ");
    // fprintf(stderr, "\033[0m");  // reset
    fprintf(stderr, "%s", getenv("prompt"));
}

int *printArguments(char ***argvv, int num_command_n, char **redirects, int bg) {
    /*Hace print de los mandatos con sus atributos en orden y devuelve un puntero a un array de integers:
     * [mandato0: argc propio, mandato1: argc propio]
     */
    // fprintf(stderr, "--------------------------------------------------------\n\tSTART OF DEBUGGING PART\n--------------------------------------------------------\n");
    int *result = malloc(sizeof(int) * num_command_n);  //
    if (!result) return NULL;
    char **argv;
    for (int i = 0; (argv = argvv[i]); i++) {
        // fprintf(stderr, "%d: \n", i);
        int argc;
        for (argc = 0; argv[argc]; argc++) {  // bucle argumentos
            // char *atrs = argv[argc];
            // fprintf(stderr, "\t%d : %s\n", argc, atrs);
        }
        result[i] = argc;
    }
    // if (redirects[0]) fprintf(stderr, "< %s\n", redirects[0]);  /* IN */
    // if (redirects[1]) fprintf(stderr, "> %s\n", redirects[1]);  /* OUT */
    // if (redirects[2]) fprintf(stderr, ">& %s\n", redirects[2]); /* ERR */
    // if (bg) fprintf(stderr, "&\n");
    return result;
}

int redirect_if_needed(char **redirects) {
    // if no redirect is needed then return a number higher than stdin, stderr, stdout, but still not error
    int ret = 4;
    for (int i = 0; i < 3; i++) {
        char *fd;
        switch (i) {
            case 0:
                fd = "STDIN";
                break;
            case 1:
                fd = "STDOUT";
                break;
            case 2:
                fd = "STDERR";
                break;
            default:
                fd = "FD inexistente (>2)";
                break;
        }
        if (redirects[i]) {
            fprintf(stderr, "\t REDIRECCION DE %s\n", fd);
            if (redirect(i, redirects[i]) == -1) {
                fprintf(stderr, "abortando por error en redir \n");
                return -1;
            }
            ret = i;
        }
    }
    return ret;
}

int executeInternalFunction(char **mandato, int length, char **redirects) {
    /* Si es un commando interno y está en una secuencia devuelve true para que se ejecute más tarde*/
    // TODO : secuencias Internas en subshell
    //  falta por mirar si se ejecuta en background o en secuencia (y no es ultimo) -> fork()
    char *comando = mandato[0];
    if (strcmp(comando, "cd") == 0) {
        return cdIF(mandato, length);
    } else if (strcmp(comando, "umask") == 0) {
        return umaskIF(mandato, length);
    } else if (strcmp(comando, "set") == 0) {
        // set function
        return setIF(mandato, length);
    } else if (strcmp(comando, "limit") == 0) {
        return limitIF(mandato, length);
    }

    // fprintf(stderr, "------------d--------------------------------------------\n\tEND OF DEBUGGING PART\n--------------------------------------------------------\n\n");
    return -1;
}

/* Devuelve true si es un comando interno, false si no*/
bool isInternalFunction(char **command, int length, char **redirects) {
    char *comando = command[0];
    if ((strcmp(comando, "cd") == 0) || (strcmp(comando, "umask") == 0) || (strcmp(comando, "set") == 0) || (strcmp(comando, "limit") == 0)) {
        return true;
    }
    return false;
}

/* ---------------------------------------------------------------------
                            Internal functions
 * --------------------------------------------------------------------*/
int cdIF(char **command, int length) {
    if (length > 2) {
        error("cd [Directorio], recibe como mucho 1 argumento");
    } else {
        char *directorio = (length == 1) ? getenv("HOME") : command[1];
        if (chdir(directorio) != 0) {
            error("\nfallo en cd");
            return -1;
        } else {
            strcpy(CWD, directorio);
        }
    }
    char result[PATH_MAX + 1];
    if (!getcwd(result, PATH_MAX + 1)) {
        error("\n fallo al obtener dir actual en cd");
    }
    printf("%s\n", result);
    return 0;
}
int umaskIF(char **command, int length) {
    if (length > 2) {
        error("umask [valor:hex]\n\tuso:\n\t- umask solo printea la máscara actual \n\t- dado valor en formato octal lo cambia a dicho valor y printea el resultado\n");
        return -1;
    }
    char *value = command[1];
    // print the current mask
    if (!value) {
        mode_t current_mask = umask(0);         // change it to whatever but save the old one on return
        umask(current_mask);                    // change it back
        fprintf(stdout, "%o\n", current_mask);  // print the current mask
    }
    // Change mask value to whatever was inputed
    else {
        char *ptr;
        mode_t mask = (mode_t)strtol(command[1], &ptr, 8);  // convert the given number to octal integer
        if (*ptr != '\0') {
            // given value is not octal
            error("Valor introducido de la máscara es incorrecto, debe estar dado en base octal\n");
            return -1;
        } else {
            umask(mask);
            printf("%o\n", mask);
        }
    }

    return 0;
}
int setIF(char **command, int length) {
    char *var_name = command[1];
    if (length == 1) {
        extern char **environ;  // we can use this to get the environment easily
        for (int i = 0; environ[i]; i++) {
            printf("%s\n", environ[i]);  // print each value with the given format
        }
    } else if (length == 2) {
        printf("%s=%s\n", var_name, getenv(var_name));
    } else {
        int var_values_size = 0;

        for (int i = 1; i < length; i++) {
            var_values_size = var_values_size + strlen(command[i]);
        }
        // for each value except first and last we need to add the ' ' character, hence  (length - 1)
        var_values_size = var_values_size + (length - 3);
        char var_values[var_values_size];
        var_values[0] = '\0';
        strcpy(var_values, command[2]);
        for (int i = 3; i < length; i++) {
            // concatenate
            strcat(var_values, " ");
            strcat(var_values, command[i]);
        }
        if (setenv(var_name, var_values, 1) < 0) {
            error("error en setenv");
            return -1;
        }
    }
    return 0;
}

// comprueba si el recuso dado es correcto devuelve el tipo de limite de recurso acorde, -1 si no existe
int check_resouce(const char *resource) {
    if (strcmp(resource, "nofile") == 0) {
        return RLIMIT_NOFILE;
    }
    if (strcmp(resource, "cpu") == 0) {
        return RLIMIT_CPU;
    }
    if (strcmp(resource, "fsize") == 0) {
        return RLIMIT_FSIZE;
    }
    if (strcmp(resource, "stack") == 0) {
        return RLIMIT_STACK;
    }
    if (strcmp(resource, "core") == 0) {
        return RLIMIT_CORE;
    }
    if (strcmp(resource, "data") == 0) {
        return RLIMIT_DATA;
    }
    error("recurso especificado es invalido");
    return -1;
}

int limitIF(char **commands, int length) {
    struct rlimit var_rlimit;
    int ret_val_rlimit;
    int checked_res;
    long unsigned int desired;
    const char resources[6][7] = {"cpu", "fsize", "data", "stack", "core", "nofile"};

    switch (length) {
        case 1:
            for (int i = 0; i < 6; i++) {
                checked_res = check_resouce(resources[i]);
                if (checked_res == -1) {
                    return -1;
                }
                ret_val_rlimit = getrlimit(checked_res, &var_rlimit);
                if (ret_val_rlimit == -1) {
                    error("limit: error in getrlimit");
                    return -1;
                }

                printf("%s\t%d\n", resources[i], (int)var_rlimit.rlim_cur);
            }
            break;
        case 2:
            // preparacion de la estructura de datos rlimit
            checked_res = check_resouce(commands[1]);
            if (checked_res == -1) {
                return -1;
            }
            ret_val_rlimit = getrlimit(checked_res, &var_rlimit);
            if (ret_val_rlimit == -1) {
                error("limit: error en getrlimit()");
                return -1;
            }

            printf("%s\t%d\n", commands[1], (int)var_rlimit.rlim_cur);
            break;
        case 3:
            // preparacion de la estructura de datos rlimit
            checked_res = check_resouce(commands[1]);
            if (checked_res == -1) {
                return -1;
            }
            desired = atoi(commands[2]);
            // convertir -1 a infinito para la estructura rlimit
            if (desired == -1)
                desired = RLIM_INFINITY;
            var_rlimit.rlim_max = desired;
            var_rlimit.rlim_cur = desired;
            // llamada a setrlimit
            ret_val_rlimit = setrlimit(checked_res, &var_rlimit);
            if (ret_val_rlimit == -1) {
                error("limit: error en setrlimit");
                return -1;
            }
            break;
        default:
            // argumentos incorrectos
            perror("limit: numero incorrecto de argumentos");
            return -1;
    }
    return 0;
}

int expand_variable(char *possible, char *resulting) {
    int follows_format;
    sscanf(possible, "%*[_a-zA-Z0-9]%n", &follows_format);
    // check that the variable name has this format "%[_a-zA-Z0-9]"
    if (follows_format) {
        char *intermediate = malloc(sizeof(char));
        intermediate[0] = '\0';
        char *var_name = malloc(sizeof(char) * follows_format);
        strncpy(var_name, possible, follows_format);
        var_name[follows_format] = '\0';
        // get the variable value
        char *var_value = getenv(var_name);
        if (var_value == NULL) {
            error("variable no definida");
            return -1;
        } else {
            possible = possible + follows_format;
        }
        // replace the $ with the variable value
        strcat(resulting, var_value);
        free(var_name);
    }
    char *temp = strchr(possible, '$');
    if (temp != 0) {
        int offset = temp - possible;
        strncat(resulting, possible, offset);
        return expand_variable(temp + offset, resulting);
    }
    strcat(resulting, possible);
    return 0;
}

void metachars(char **command) {
    for (int n_arg = 1; command[n_arg]; n_arg++) {
        if (command[n_arg][0] == '~') {
            char *possible_user = command[n_arg] + 1;
            // check if the user matches this sequence "%[_a-zA-Z0-9]"
            if (possible_user[0] == '\0') {
                // no user given, use the current user
                possible_user = getenv("USER");
            }
            int follows_format;
            sscanf(possible_user, "%*[_a-zA-Z0-9]%n", &follows_format);
            // check that the variable name has this format "%[_a-zA-Z0-9]"
            if (follows_format) {
                // get the home directory of the user
                struct passwd *user = getpwnam(possible_user);
                if (user == NULL) {
                    errno = EINVAL;
                    // make a formatted error message
                    char *error_message = malloc(sizeof(char) * (strlen(possible_user) + strlen("No existe el usuario ") + 1));
                    strcpy(error_message, "No existe el usuario: ");
                    strcat(error_message, possible_user);
                    error(error_message);
                    return;
                }
                // get the user's home directory
                char *home_dir = user->pw_dir;
                // replace the ~ with the home directory
                strcpy(command[n_arg], home_dir);
            }
        }
        // check if the command contains a $
        if (strchr(command[n_arg], '$') != NULL) {
            char *possible = strchr(command[n_arg], '$') + 1;
            char *resulting = malloc(sizeof(char));
            resulting[0] = '\0';
            int offset = possible - command[n_arg] - 1;
            // check if possible is further into the string than command[n_arg]
            if (offset != 0) {
                strncat(resulting, command[n_arg], offset);
            }
            if (expand_variable(possible, resulting) != -1)
                command[n_arg] = resulting;
        }
        // check if the whole command contains a ? and save it in a variable, also check if it does not contain a /
        char *question_mark = strchr(command[n_arg], '?');
        if (question_mark != 0 && strchr(command[n_arg], '/') == NULL) {
            // get all the files in the directory and see if they match the string before the question mark

            DIR *dir = opendir(".");
            if (dir == NULL) {
                error("metachars: error en opendir");
                return;
            }
            char *before_question_mark = strndup(command[n_arg], question_mark - command[n_arg]);
            int before_question_mark_size = strlen(before_question_mark);
            // go through all the files in the directory, see if they match before_question_mark
            int n_files = 0;
            struct dirent *file;
            while ((file = readdir(dir)) != NULL) {
                n_files++;
            }
            // create an array of string that reallocates everytime a file is added to it
            char **files = malloc(sizeof(char *) * 2);  // *2 to makes size for first arg
            // add the first command argument to the array
            files[0] = strndup(command[0], strlen(command[0]));
            int i = 1;
            rewinddir(dir);  // reset dir position to the beginning of the directory
            while ((file = readdir(dir)) != NULL) {
                char *possible_match = strdup(file->d_name);
                possible_match[before_question_mark_size] = '\0';
                if (strcmp(possible_match, before_question_mark) == 0) {
                    files[i] = strdup(file->d_name);
                    i++;
                    // make size for one more entry
                    files = realloc(files, (i + 1) * sizeof(char *));
                }
            }
            free(before_question_mark);
            closedir(dir);
            command = files;
        }
    }
    return;
}
