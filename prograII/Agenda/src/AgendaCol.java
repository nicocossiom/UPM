
public class AgendaCol implements Agenda {
	private CIContactoTupla elementos;
	
	public AgendaCol (int numero) {
		elementos=new CIContactoTupla(numero);
	}
	
	 public String toString() {
		 String result = "";
		 for(int i = 0; i < elementos.size() ; i++) {
			 result = result + elementos.get(i) + '\n';
		 }
		 return result;
	 }
	 
	
	public Contacto buscarNombre(String nombre) {
		int posicion=0;
		for (int i=0; i<elementos.size(); i++) {
			if (elementos.get(i).igualNombre(nombre)) {
				posicion=i;
			}
		}
			return elementos.get(posicion);
		}

	public Contacto buscarNumero(int numero) {
		int posicion=0;
		for (int i=0; i<elementos.size(); i++) {
			if (elementos.get(i).igualTelefono(numero)==true) {
				posicion=i;
			}
			
		}
			return elementos.get(posicion);
	}

	public void poner(Contacto contacto) {
		elementos.add(elementos.size(), contacto);
	}
	
	//Devuelve la posicion del contacto para poder trabajar con el funciones que pidan la posicion y no el contacto en si, si es -1 es que no se ha encontrado el contacto
	private int posicionContacto(Contacto contacto) {
		int posicion=0;
		boolean stop=false;
		 for (int i=0; i<elementos.size() && !stop ; i++) {
			 if (elementos.get(i).equals(contacto)) {
				 posicion=i;
				 stop=true;
			 }
		 }
			 return posicion;
	}
	public void quitar(Contacto contacto) {
		elementos.remove(posicionContacto(contacto));
		}
	
	public void cambiarTelefono(Contacto contacto) {
		int posicion=posicionContacto(contacto);
		if (posicion>=0) {
			elementos.get(posicion).setTelefono(contacto.getTelefono());
		}
	}

	public int cuantosConPrefijo(int prefijo) {
		int contador=0;
		int cuantosnumeros = (int) (Math.log10(prefijo) + 1);
		for (int i = 0; i < elementos.size(); i++){
		int n = elementos.get(i).getTelefono();
		if (n/(int)Math.pow(10,(int) (Math.log10(n)+1)-cuantosnumeros) == prefijo){
		contador = contador + 1;
			}
		}
		return contador;
	}
}
