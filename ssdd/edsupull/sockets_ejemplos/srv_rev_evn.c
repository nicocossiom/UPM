#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/epoll.h>

void revierte(char *b, int t){
    char aux;
    for (int i=0; i<t/2; i++) {
        aux=b[i];
        b[i]=b[t-i-1];
        b[t-i-1]=aux;
    }
}
// en este ejemplo la cabecera es solo un int con la longitud
// pero la tratamos de forma genérica para mostrar una solución más general
struct estado_cliente {
    int fd;
    int tam_cabecera;
    int leido_cabecera;
    int cabecera_completa;
    void *cabecera;
    int tam_cuerpo;
    int leido_cuerpo;
    int cuerpo_completo;
    void *cuerpo;
    int en_escritura;
    int escrito_cuerpo;
    int escritura_completa;
};

int leer(struct estado_cliente *ec) {
    int tam_pedido, tam_leido, tot_leido=0;
    // todavía no se ha leído la cabecera
    if (!ec->cabecera_completa) {
        char *buf = ec->cabecera + ec->leido_cabecera;
        tam_pedido=ec->tam_cabecera-ec->leido_cabecera;
        if ((tam_leido=read(ec->fd, buf, tam_pedido))<0) {
            perror("error leyendo cabecera"); 
            return -1;
        }
	tot_leido+=tam_leido;
        ec->leido_cabecera+=tam_leido;
        if (ec->leido_cabecera==ec->tam_cabecera) {
            ec->cabecera_completa=1;
            ec->cuerpo_completo=0;
            ec->leido_cuerpo=0;
            ec->tam_cuerpo=ntohl(*((int *)ec->cabecera));
            ec->cuerpo=malloc(ec->tam_cuerpo);
        }
    }
    // cabecera completa: a leer el cuerpo
    if (ec->cabecera_completa) {
        char *buf = ec->cuerpo + ec->leido_cuerpo;
        tam_pedido=ec->tam_cuerpo-ec->leido_cuerpo;
        if ((tam_leido=read(ec->fd, buf, tam_pedido))<0) {
            perror("error leyendo cuerpo"); 
            return -1;
        }
	tot_leido+=tam_leido;
        ec->leido_cuerpo+=tam_leido;
        if (ec->leido_cuerpo==ec->tam_cuerpo) {
            ec->cuerpo_completo=1;
        }
    }
    return tot_leido;
}
int escribir_cuerpo(struct estado_cliente *ec) {
    int tam_pedido, tam_escrito;
    char *buf = ec->cuerpo + ec->escrito_cuerpo;
    tam_pedido=ec->tam_cuerpo-ec->escrito_cuerpo;
    if ((tam_escrito=write(ec->fd, buf, tam_pedido))<0) {
        perror("error escribiendo cuerpo"); 
        return -1;
    }
    ec->escrito_cuerpo+=tam_escrito;
    if (ec->escrito_cuerpo==ec->tam_cuerpo) {
        ec->escritura_completa=1;
        ec->en_escritura=0;
        // prepararse para la siguiente petición del mismo cliente
        ec->cuerpo=NULL;
        ec->leido_cabecera=0;
        ec->cabecera_completa=0;
        ec->cuerpo_completo=0;
    }
    return tam_escrito;
}


int main(int argc, char *argv[]) {
    int s, s_conec, st;
    unsigned int tam_dir;
    struct sockaddr_in dir, dir_cliente;
    int opcion=1;

    if (argc!=2) {
        fprintf(stderr, "Uso: %s puerto\n", argv[0]);
        return 1;
    }
    if ((s=socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
        perror("error creando socket");
        return 1;
    }
    /* Para reutilizar puerto inmediatamente */
    if (setsockopt(s, SOL_SOCKET, SO_REUSEADDR, &opcion, sizeof(opcion))<0){
        perror("error en setsockopt");
        return 1;
    }
    dir.sin_addr.s_addr=INADDR_ANY;
    dir.sin_port=htons(atoi(argv[1]));
    dir.sin_family=PF_INET;
    if (bind(s, (struct sockaddr *)&dir, sizeof(dir)) < 0) {
        perror("error en bind");
        close(s);
        return 1;
    }
    if (listen(s, 5) < 0) {
        perror("error en listen");
        close(s);
        return 1;
    }
    // nº máx eventos que puede devolver simultáneamente epoll_wait
    int max_eventos=16;
    // para usar en epoll_ctl y como retorno de epoll_wait, respectivamente
    struct epoll_event evento, eventos_activos[max_eventos];
    // para recoger retorno de epoll_wait: cuántos descriptores tienen eventos
    int nfds;
    // crea un descriptor para epoll
    int epollfd = epoll_create1(0);
    if (epollfd == -1) {
        perror("epoll_create1");
        close(s);
        return 1;
    }
    // pide ser informado de la llegada de conexiones
    evento.events = EPOLLIN;
    // data: información asociada a los eventos de este descriptor
    // Cuando se produzca evento sobre este descriptor, se identificará
    // por este valor.
    evento.data.fd = s;
    if (epoll_ctl(epollfd, EPOLL_CTL_ADD, s, &evento) == -1) {
        perror("error epoll socket inicial");
        return 1;
    }
    while(1) {
        // espera llegada de eventos sin usar temporización (-1)
        if ((nfds=epoll_wait(epollfd, eventos_activos, max_eventos, -1))<0){
            perror("error en epoll_wait");
            close(s);
            return 1;
        }
        // tratar eventos recibidos
        for (int n = 0; n < nfds; ++n) {
            // es una petición de conexión
            if (eventos_activos[n].data.fd==s) {
                tam_dir=sizeof(dir_cliente);
                if ((s_conec=accept(s, (struct sockaddr *)&dir_cliente, &tam_dir))<0){
                    perror("error en accept");
                    close(s);
                    return 1;
                }
                fprintf(stderr, "nuevo cliente %d\n", s_conec);
                // pone el socket conectado como no bloqueante
                int flags= fcntl(s_conec, F_GETFL, 0);
                fcntl(s_conec, F_SETFL, flags | O_NONBLOCK);

                // habilita estado asociado a ese cliente
                struct estado_cliente *ec=malloc(sizeof(struct estado_cliente));
                ec->fd=s_conec;
                // la cabecera es solo 1 int pero la tratamos de forma genérica
                ec->tam_cabecera=sizeof(int);
                ec->cabecera=malloc(sizeof(int));
                ec->cuerpo=NULL;
                ec->leido_cabecera=0;
                ec->cabecera_completa=0;
                ec->cuerpo_completo=0;
                ec->en_escritura=0;
                // pide ser informado de la llegada de datos
                evento.events = EPOLLIN;
                // se usa como data un puntero al estado asociado a ese cliente
                evento.data.ptr = ec;
                if (epoll_ctl(epollfd, EPOLL_CTL_ADD, s_conec, &evento) == -1) {
                    perror("error epoll socket conectado");
                    return 1;
                }
           }
           else {
                struct estado_cliente *ec=eventos_activos[n].data.ptr;
		if (!ec->en_escritura) {
                    if ((st=leer(ec))<0) {
                        fprintf(stderr, "error leyendo socket\n");
                        continue;
                    }
                    if (!st) { // nada leído: fin cliente
                        if (epoll_ctl(epollfd, EPOLL_CTL_DEL, ec->fd, NULL) == -1) {
                            perror("error epoll socket conectado");
                            return 1;
                        }
			close(ec->fd);
                        if (ec->cabecera) free(ec->cabecera);
                        if (ec->cuerpo) free(ec->cuerpo);
                        fprintf(stderr, "fin cliente %d\n", ec->fd);
                        free(ec);
                    }
		    else if (ec->cuerpo_completo) {
                        revierte(ec->cuerpo, ec->tam_cuerpo);
                        // pide ser informado de cuando escribir no bloquea
                        evento.events = EPOLLOUT;
                        evento.data.ptr = ec;
                        if (epoll_ctl(epollfd, EPOLL_CTL_MOD, ec->fd, &evento) == -1) {
                            perror("error epoll socket conectado");
                            return 1;
                        }
		        ec->en_escritura=1;
		        ec->escritura_completa=0;
		        ec->escrito_cuerpo=0;
                    }
                }
                // se puede escribir en el socket sin bloqueo
		else  {
                    if ((st=escribir_cuerpo(ec))<0) {
                        fprintf(stderr, "error escribiendo socket\n");
                        continue;
                    }
                    // vuelve a esperar lecturas
                    if (ec->escritura_completa) {
                       evento.events = EPOLLIN;
                       evento.data.ptr = ec;
                       if (epoll_ctl(epollfd, EPOLL_CTL_MOD, ec->fd, &evento) == -1) {
                           perror("error epoll socket conectado");
                           return 1;
                       }
                   }
		}
           }
       }
    }
    close(s);
    return 0;
}
