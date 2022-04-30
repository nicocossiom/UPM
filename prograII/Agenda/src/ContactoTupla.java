
public class ContactoTupla implements Contacto {

	//Constructor del tipo contacto
	private int telefono;
	private String nombre;
	
	public ContactoTupla (String nom, int tel) {
		nombre=nom;
		telefono=tel;
	
	}
	//Visualizador del contacto 
	public String toString () {
		return "(" + nombre + ", " + telefono + ")";
	}
	
	 //Operaciones
	
	public String getNombre() {
		return nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public boolean igualNombre(String nomb) {
		return (nombre==nomb);
	}
	public boolean igualTelefono(int num) {
		return (telefono==num);
	}
	@Override 
	public boolean equals (Object cc) {
			 ContactoTupla contacto=(ContactoTupla) (cc);
			 return nombre.equals(contacto.nombre) && (telefono==contacto.telefono);
	 }
	 public void setTelefono (int num) {
		 telefono= num;
	 }
}

