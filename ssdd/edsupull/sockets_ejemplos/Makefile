CFLAGS=-Wall
LDLIBS=-lpthread

PROGRS=conecta acepta emisor receptor emisor_nb envio_multiple_2send envio_multiple_2send_more envio_multiple_error envio_multiple_copia envio_multiple_writev receptor_completo_readn receptor_completo_waitall receptor_completo_fread envio_tam_variable_writev receptor_tam_variable srv_web_read_send srv_web_mmap_writev srv_web_sendfile cln_rev srv_rev_sec srv_rev_prc srv_rev_thr srv_rev_evn receptor_dgram emisor_dgram 

all:  $(PROGRS)

clean:
	rm -f $(PROGRS)
