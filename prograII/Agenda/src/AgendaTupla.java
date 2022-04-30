
public class AgendaTupla implements Agenda {
	// Constructor
	private int longitud;
	private Contacto [] agenda;
	
	public AgendaTupla (int cantidad) {
		agenda= new ContactoTupla [cantidad];
		longitud=0;
	}
	
	public String toString() {
		String result=" ";
		for (int i=0; i<longitud; i++) {
			result= result + agenda[i] + '\n';
		}
		return result;
		}
	
	
	 public void poner(Contacto contacto) {
		 if (longitud < agenda.length) {
		 agenda[longitud]= contacto;
		 longitud++;
		 }	
	 }
	
	 public void quitar (Contacto contacto) {
		  Contacto [] agendamod= new ContactoTupla[longitud--];
		  for (int i=0; i<longitud; i++) {
			  if (cumplesCriterio(contacto, 1, i)) {
				  i++;
			  }
			  else {
				  agendamod[i]=agenda[i];
			  }
		  }
	  }
	//Creamos 3 criterios que nos ayudaran a manejar los contactos segun los atributos del contacto que queramos
	 @SuppressWarnings("unused")
	private int CONTACTO=1;
	 private int NOMBRE=2;
	 private int NUMERO=3;
	
	 /**
	  * POST: El resultado es un boolean. Para ver si un contacto cualquiera y otro en una posicion de la agenda son iguales en funcion a un criterio
	  */
	 private boolean cumplesCriterio (Contacto contacto, int criterio, int posicionagenda) {
		 if (criterio==NOMBRE) {
			 return agenda[posicionagenda].igualNombre(contacto.getNombre());
		 } else if (criterio==NUMERO) {
			 return agenda[posicionagenda].igualTelefono(contacto.getTelefono());
		 }
		 else  //(criterio==CONTACTO) {
			 return agenda[posicionagenda].equals(contacto);
	 }
	 
	 /**
	  * POST: resultado sera la posicion del contacto en el array de la agenda que cumpla el criterio
	  */
	 private int PoscionContacto(Contacto contacto, int Criterio) {
		 boolean stop=false;
		 int i=0;
		 for (i=0; i<longitud && stop==false; i++) {
			 if (cumplesCriterio(contacto, Criterio, i)) {
				 stop=true;
			 }
		 }
		 return (stop)? i: -1;
	 }
	
	 public Contacto buscarNombre (String nombre) {
		 Contacto cbuscado=new ContactoTupla(nombre, 0);
		 int posicion= PoscionContacto(cbuscado, 2);
		 if (posicion>= 0)
			return agenda[posicion];
		else
			return cbuscado; 
	 }
	 
	 public Contacto buscarNumero (int numero) {
		 Contacto cbuscado=new ContactoTupla("", numero);
		 int posicion= PoscionContacto(cbuscado, 3);
		 if (posicion>= 0) {
			 return agenda[posicion];
		 }
		 else {
			 return cbuscado; 
		 }
	 }
	 /*
	  * POST: metodo cambia el telefono del input por el del metodo cuando tienen el mismo nombre
	  */
	 public void cambiarTelefono (Contacto contacto) {
		 int posicion= PoscionContacto(contacto, NOMBRE);
		   agenda[posicion].setTelefono(contacto.getTelefono());
	 }

	 /*
	  * POST: encuentra el numero de contactos con un prefijo determinado
	  */
	public int cuantosConPrefijo(int prefijo) {
		String pretoString= String.valueOf(prefijo);
		int contador=0;
		for (int i=0; i<longitud; i++) {
			if (agenda[i].getNombre().contains(pretoString)==true) {
				contador++;
			}
		}
		return contador;
	}

}

	
	