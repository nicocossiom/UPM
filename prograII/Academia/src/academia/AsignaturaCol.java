package academia;

public class AsignaturaCol implements Asignatura {
	private String name;
	private ColTupla<Alumno> students;
	
	//@SuppressWarnings("unchecked")
	public AsignaturaCol(String nombre) {
		name = nombre;
		students = new ColTupla<Alumno>(25);
	}
	
	 public String toString () {
		 return "Asignatura: " + this.name + "\n Alumnos: " + students.toString() + "\n";
	 }
	
	 public String getNombre() {
		   return this.name;
	 }
	 
	 public boolean esIgual (Asignatura a) {
		 return this.name.equals(a.getNombre());
	 }
	
	 public int size() {
		 return students.size();
	 }
	 
	 public Alumno get (int pos) {
		 return students.get(pos);
	 }
	 
	 private int buscarPos(Alumno al) {
		 int result = -1;
		 int i = 0;
		 boolean stop = false;
		 while (i < students.size() && !stop){
			 if(students.get(i).esIgual(al)) {
				 result = i;
				 stop = true;
			 }
			 else {
				 i++;
			 }
		 }
		return result;
	   }
	 
	 public Alumno getNotas (Alumno al) {
		 int position = buscarPos(al);
		 return students.get(position) ;
	 }
	 
	 private int ordenar(Alumno al) {
	     int compared = 0;
		 int i = 0;
		 boolean stop = false;
		 int position = students.size();
		 while(i <students.size() && !stop) {
			 compared = students.get(i).clave().compareTo(al.clave());
			 if(compared > 0) {
				 position = i;
				 stop = true;
			 }
			 i++;
		 }
		 return position;
	 }
	 
	 public void matricularAlumno (Alumno al) {
		 students.add(ordenar(al), al); 
	 }
	 
	 public void desmatricularAlumno (Alumno al) {
		 students.remove(buscarPos(al)); 
	 }
	 
	
	 public void calificarAlumno (Alumno al) {
		 if(buscarPos(al) == -1) {
			 matricularAlumno(al);
		 }
			 int i = 0;
			 boolean stop = false;
			 while (i < students.size() && !stop) {
				 if(students.get(i).esIgual(al)) {
					 getNotas(al).setPrimerParcial(al.getPrimerParcial());
					 getNotas(al).setSegundoParcial(al.getSegundoParcial());
					 stop = true;
				 }
				 else {
					 i++;
				 }
			 } 	
	 }
}
