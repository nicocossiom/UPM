package academia;

public class AprobadosXimena {
	
	static ICol<String> todoAprobado (Asignatura asig){
		ICol<String> nombresAprobados = new ColTupla<String>(25);
		int j = 0;
		for(int i = 0; i < asig.size(); i++) {
			double parcial1 = asig.get(i).getPrimerParcial();
			double parcial2 = asig.get(i).getSegundoParcial();
			if(parcial1 >= 5.0 && parcial2 >= 5.0) {
				nombresAprobados.add(j, asig.get(i).clave());
				j++;
			}
		}
		return nombresAprobados;
	}
	

	//  - La lista de declaraciones de todos los alumnos.
	static Alumno uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez, once, doce, trece;
	
	// - Dos asignaturas (una de ellas con 10 alumnos, como mínimo).
	static Asignatura quimica;
	static Asignatura biologia;
	
	//- El procedimiento resetearAlumnos(), que cree todos los alumnos declarados.
	static void resetearAlumnos() {
	   uno = new AlumnoTupla("Lalo","Pas","Costas");//3
	   dos = new AlumnoTupla("Lola","Peris","Cos");//4
	   tres = new AlumnoTupla("Luis","Pirro","Casa");//5
	   cuatro = new AlumnoTupla("RamÛn","Prego","CosÌo"); //6
	   cinco = new AlumnoTupla("Lolo","Prieto","Crastis");//8
	   seis = new AlumnoTupla("Bob","Smith","Jones");//9
	   siete = new AlumnoTupla("Billy","Dennis","Tal"); //1
	   ocho = new AlumnoTupla("Juanito","Lagarto","Tuna"); //2
	   nueve = new AlumnoTupla("Pepe","Prego","Panda");//7
	   diez = new AlumnoTupla("Jose","Villo","Tortosa");//10
	   once = new AlumnoTupla("Sansa","House","Stark");//1
	   doce = new AlumnoTupla("Lily","Margarita","Girasol");//2
	   trece = new AlumnoTupla("Arya","Noname","Girl");//3
	}
	
	//la prueba de resetear alumno comparando los nombres completos
	static boolean prueba1_resetearAlumnos() {
		boolean result = uno.getNombreCompleto().equals("Pas Costas, Lalo") &&
				dos.getNombreCompleto().equals("Peris Cos, Lola") &&
				tres.getNombreCompleto().equals("Pirro Casa, Luis") &&
				cuatro.getNombreCompleto().equals("Prego CosÌo, RamÛn") &&
				cinco.getNombreCompleto().equals("Prieto Crastis, Lolo") &&
				seis.getNombreCompleto().equals("Smith Jones, Bob") &&
				siete.getNombreCompleto().equals("Dennis Tal, Billy") &&
				ocho.getNombreCompleto().equals("Lagarto Tuna, Juanito") &&
				nueve.getNombreCompleto().equals("Prego Panda, Pepe") &&
				diez.getNombreCompleto().equals("Villo Tortosa, Jose") &&
				once.getNombreCompleto().equals("House Stark, Sansa") &&
				doce.getNombreCompleto().equals("Margarita Girasol, Lily") &&
				trece.getNombreCompleto().equals("Noname Girl, Arya");
		return result;
	}
	
	
	 // - El procedimiento resetearAsignaturas(), que matricule a todos los alumnos declarados (cada cual en su asignatura).
	static void resetearAsignatura() {
		resetearAlumnos();
		quimica = new AsignaturaCol("Quimica");
		quimica.matricularAlumno(uno);
		quimica.matricularAlumno(dos);
		quimica.matricularAlumno(tres);
		quimica.matricularAlumno(cuatro);
		quimica.matricularAlumno(cinco);
		quimica.matricularAlumno(seis);
		quimica.matricularAlumno(siete);
		quimica.matricularAlumno(ocho);
		quimica.matricularAlumno(nueve);
		quimica.matricularAlumno(diez);
		
		biologia = new AsignaturaCol("Biologia");
		biologia.matricularAlumno(once);
		biologia.matricularAlumno(doce);
		biologia.matricularAlumno(trece);
		
	}
	
	//la prueba de resetear asignatura comparando las alumnos en las posiciones de cada asignatura con el alumno que deberia de estar ahi siguiendo el orden lexicografico.
	static boolean prueba2_resetearAsignatura() {
		resetearAsignatura();
		boolean result = quimica.get(0).esIgual(siete) &&
				quimica.get(1).esIgual(ocho) &&
				quimica.get(2).esIgual(uno) &&
				quimica.get(3).esIgual(dos) &&
				quimica.get(4).esIgual(tres) &&
				quimica.get(5).esIgual(cuatro) &&
				quimica.get(6).esIgual(nueve) &&
				quimica.get(7).esIgual(cinco) &&
				quimica.get(8).esIgual(seis) &&
				quimica.get(9).esIgual(diez) &&
				biologia.get(0).esIgual(once) &&
				biologia.get(1).esIgual(doce) &&
				biologia.get(2).esIgual(trece);
		return result;
	}
	
	// - Un procedimiento anotarCalificaciones(), que otorgue calificaciones variadas a todos los alumnos.
	static void anotarCalificaciones() {
		uno.setPrimerParcial(5.0);
		uno.setSegundoParcial(6.0);
		dos.setPrimerParcial(5.3);
		dos.setSegundoParcial(7.8);
		tres.setPrimerParcial(6.5);
		tres.setSegundoParcial(8.2);
		cuatro.setPrimerParcial(9.0);
		cuatro.setSegundoParcial(8.6);
		cinco.setPrimerParcial(6.8);
		cinco.setSegundoParcial(2.3);
		seis.setPrimerParcial(4.3);
		seis.setSegundoParcial(5.0);
		siete.setPrimerParcial(3.5);
		siete.setSegundoParcial(4.7);
		ocho.setPrimerParcial(8.9);
		ocho.setSegundoParcial(6.5);
		nueve.setPrimerParcial(5.6);
		nueve.setSegundoParcial(9.3);
		diez.setPrimerParcial(4.5);
		diez.setSegundoParcial(7.8);
		once.setPrimerParcial(7.6);
		once.setSegundoParcial(5.8);
		doce.setPrimerParcial(5.0);
		doce.setSegundoParcial(3.4);
	    trece.setPrimerParcial(6.6);
		trece.setSegundoParcial(6.0);
		
	}
	
	//  - Un procedimiento calificarAsignaturas(), que califique a los alumnos de cada asignatura.
	static void calificarAsignaturas() {
		quimica.calificarAlumno(uno);
		quimica.calificarAlumno(dos);
		quimica.calificarAlumno(tres);
		quimica.calificarAlumno(cuatro);
		quimica.calificarAlumno(cinco);
		quimica.calificarAlumno(seis);
		quimica.calificarAlumno(siete);
		quimica.calificarAlumno(ocho);
		quimica.calificarAlumno(nueve);
		quimica.calificarAlumno(diez);
		biologia.calificarAlumno(once);
		biologia.calificarAlumno(doce);
		biologia.calificarAlumno(trece);
	}
	
	public static void main (String args[]) {
		resetearAsignatura();
		anotarCalificaciones();
		calificarAsignaturas();
		System.out.println("Nombres de Estudiantes Aprobados de Quimica: \n" + todoAprobado(quimica));
		System.out.println("\n");
		System.out.println("Nombres de Estudiantes Aprobados de Biologia: \n" + todoAprobado(biologia));
		System.out.println("\n");
		System.out.println("prueba1 resetearAlumnos = " + prueba1_resetearAlumnos());
		System.out.println("prueba2 resetearAsignatura = " + prueba2_resetearAsignatura());
		
		
		
	}

}
