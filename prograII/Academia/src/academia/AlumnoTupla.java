package academia;

public class AlumnoTupla implements Alumno {

	private String name, firstLastName, secondLastName;
	private double firstParcial, secondParcial;
	
	public AlumnoTupla (String nombre, String apellido1, String apellido2){
		name = nombre;
		firstLastName = apellido1;
		secondLastName = apellido2;
		firstParcial = 0;
		secondParcial = 0;
	}
	
	public String toString() {
		return this.firstLastName + " " + this.secondLastName + ", " + this.name /*+ " Notas: (" + this.firstParcial + ", " + this.secondParcial + ")"*/ ;
	}
	
	public boolean esIgual (Object a){
		AlumnoTupla alumno = (AlumnoTupla) a;
		return this.getNombreCompleto().equals(alumno.getNombreCompleto());
	}
	
	public String getNombreCompleto () {
		return this.firstLastName + " " + this.secondLastName + ", " + this.name ;
	}

	  public double getPrimerParcial () {
		  return this.firstParcial;
		  
	  }

	  public double getSegundoParcial () {
		  return this.secondParcial;
	  }
	  
	  public void setPrimerParcial (double nota1) {
		  this.firstParcial = nota1;
	  }
	  
	  public void setSegundoParcial (double nota2) {
		  this.secondParcial = nota2;
	  }
	  
	  public String clave() {
		  String originalName = this.getNombreCompleto();
		  String changedName = originalName.replace('é', 'e');
		  changedName = changedName.replace('í', 'i');
		  changedName = changedName.replace('ú', 'u');
		  return changedName;
	  }
}


