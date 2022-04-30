package academia;

public class AlumnoTupla implements Alumno {

	private double Parcial1;
	private double Parcial2;
	private String Apellido1=" ";
	private String Apellido2=" ";
	private String Nombre=" ";
	
	public AlumnoTupla(String a, String ap1, String ap2) {
		Nombre=a;
		Apellido1=ap1;
		Apellido2=ap2;
		
	}
	
	public String toString () {
		return Apellido1 + " " +Apellido2 + ", " + Nombre  ;
	}
	
	public boolean equals (Object a) {
		AlumnoTupla alumno = (AlumnoTupla)a;
		return this.getNombreCompleto().equals(alumno.getNombreCompleto());
	}
	
	public String getNombreCompleto() {
		return Apellido1 + " " +Apellido2 + ", " + Nombre;
	}

	
	public double getPrimerParcial() {
		return Parcial1;
	}


	public double getSegundoParcial() {
		return Parcial2;
	}

	
	public void setPrimerParcial(double nota1) {
		Parcial1=nota1;
	}

	
	public void setSegundoParcial(double nota2) {
		Parcial2=nota2;

	}

	
	public String clave() {
		String originalName=this.getNombreCompleto();
		String changedName=originalName.replace('é','e');
		changedName=changedName.replace('í','i');
		changedName=changedName.replace('ó','n');
		return changedName;
	}

}
