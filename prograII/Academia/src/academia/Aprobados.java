package academia;
public class Aprobados {

		/*
		POST: resultado es la colección indexada de los nombres de los alumnos de la asignatura asig que han aprobado los dos parciales.
		*/
		
		
		@SuppressWarnings("rawtypes")
		static ICol<String> todoAprobado (Asignatura asig)
		{
			int contador=0;
			@SuppressWarnings("unchecked")
			ICol<String> aprobados= new ColTupla(20);
			for (int i=0; i<asig.size();i++) {
				if (asig.get(i).getPrimerParcial()>=5 && asig.get(i).getSegundoParcial()>=5)
				{
					aprobados.add(contador, asig.get(i).getNombreCompleto());
					contador++;
				}
			}
			return aprobados;
		}
	
	//Declarando Alumnos
		static Alumno a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
		static Alumno b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
	//Declarando Asignaturas
		static Asignatura lengua, mates;
	static void resetearAlumnos() 
	{
		a1=new AlumnoTupla("Batman", "Bin" , "Superman" );
		a2=new AlumnoTupla("Mac", "Donald " , "Buger" );
		a3=new AlumnoTupla("Martinez", "Ocasio" , "Benito" );
		a4=new AlumnoTupla("Chris", "P" , "Bacon" );
		a5=new AlumnoTupla("Tyrannosaurus", "Rex" , "Mullens" );
		a6=new AlumnoTupla("Filet", "Minyon" , "Roastbeef" );
		a7=new AlumnoTupla("Doctor", "Peter" , "Peter" );
		a8=new AlumnoTupla("Kim", "Jong" , "Un" );
		a9=new AlumnoTupla("Donald", "John" , "Trump" );
		a10=new AlumnoTupla("Pedro", "Sánchez" , "Pérez" );
		
		b1=new AlumnoTupla("Disney", "Landia" , "Rodríguez" );
		b2=new AlumnoTupla("Santiago", "Abascal" , "Conde" );
		b3=new AlumnoTupla("Javier", "Ortega" , "Smith" );
		b4=new AlumnoTupla("Pablo", "Iglesias" , "Turrion" );
		b5=new AlumnoTupla("Nicolas", "Maduro" , "Moros" );
		b6=new AlumnoTupla("Pablo", "Echenique" , "Robba" );
		b7=new AlumnoTupla("Pablo", "Casado" , "Blanco" );
		b8=new AlumnoTupla("Jose", "María" , "Aznar" );
		b9=new AlumnoTupla("Francisco", "Franco" , "Bahamonde" );
		b10=new AlumnoTupla("Irene", "Montero" , "Gil" );
		
	}
	
	static void resetearAsignaturas() 
	{
		resetearAlumnos();
		
		//Inicializacion asignaturas
		lengua=new AsignaturaCol ("lengua");
		mates=new AsignaturaCol ("mates");
		//Matriculaciones mates
		
		mates.matricularAlumno(b1);
		mates.matricularAlumno(b2);
		mates.matricularAlumno(b3);
		mates.matricularAlumno(b4);
		mates.matricularAlumno(b5);
		mates.matricularAlumno(b6);
		mates.matricularAlumno(b7);
		mates.matricularAlumno(b8);
		mates.matricularAlumno(b9);
		mates.matricularAlumno(b10);
		//Matriculaciones lengua
		
		lengua.matricularAlumno(a1);
		lengua.matricularAlumno(a2);
		lengua.matricularAlumno(a3);
		lengua.matricularAlumno(a4);
		lengua.matricularAlumno(a5);
		lengua.matricularAlumno(a6);
		lengua.matricularAlumno(a7);
		lengua.matricularAlumno(a8);
		lengua.matricularAlumno(a9);
		lengua.matricularAlumno(a10);
	}
	
	static void anotarCalificaciones() 
	{
		mates.get(0).setPrimerParcial(9);mates.get(0).setSegundoParcial(10); 
		mates.get(1).setPrimerParcial(8.0);mates.get(1).setSegundoParcial(6.8); 
		mates.get(2).setPrimerParcial(7.0);mates.get(2).setSegundoParcial(5);	
		mates.get(3).setPrimerParcial(6.0);mates.get(3).setSegundoParcial(6);
		mates.get(4).setPrimerParcial(5.0);mates.get(4).setSegundoParcial(10);	
		mates.get(5).setPrimerParcial(4.0);mates.get(5).setSegundoParcial(7);	
		mates.get(6).setPrimerParcial(3.0);mates.get(6).setSegundoParcial(8);	
		mates.get(7).setPrimerParcial(2);mates.get(7).setSegundoParcial(4);	
		mates.get(8).setPrimerParcial(1);mates.get(8).setSegundoParcial(2);		
		mates.get(9).setPrimerParcial(0);mates.get(9).setSegundoParcial(0);	
		
		lengua.get(0).setPrimerParcial(0);lengua.get(0).setSegundoParcial(0);
		lengua.get(1).setPrimerParcial(1);lengua.get(1).setSegundoParcial(1);
		lengua.get(2).setPrimerParcial(2);lengua.get(2).setSegundoParcial(2);
		lengua.get(3).setPrimerParcial(3);lengua.get(3).setSegundoParcial(3);
		lengua.get(4).setPrimerParcial(4);lengua.get(4).setSegundoParcial(4);
		lengua.get(5).setPrimerParcial(5);lengua.get(5).setSegundoParcial(5);
		lengua.get(6).setPrimerParcial(6);lengua.get(6).setSegundoParcial(6);
		lengua.get(7).setPrimerParcial(7);lengua.get(7).setSegundoParcial(7);
		lengua.get(8).setPrimerParcial(8);lengua.get(8).setSegundoParcial(9);
		lengua.get(9).setPrimerParcial(10);lengua.get(9).setSegundoParcial(10);
	}	
	
	static void calificarAsignaturas() 
	{
		
		//Calificaciones lengua
		lengua.calificarAlumno(a1);
		lengua.calificarAlumno(a2);
		lengua.calificarAlumno(a3);
		lengua.calificarAlumno(a4);
		lengua.calificarAlumno(a5);
		lengua.calificarAlumno(a6);
		lengua.calificarAlumno(a7);
		lengua.calificarAlumno(a8);
		lengua.calificarAlumno(a9);
		lengua.calificarAlumno(a10);
		
		//Calificaciones mates
		mates.calificarAlumno(b1);
		mates.calificarAlumno(b2);
		mates.calificarAlumno(b3);
		mates.calificarAlumno(b4);
		mates.calificarAlumno(b5);
		mates.calificarAlumno(b6);
		mates.calificarAlumno(b7);
		mates.calificarAlumno(b8);
		mates.calificarAlumno(b9);
		mates.calificarAlumno(b10);
	}
	

	@SuppressWarnings({ "rawtypes", "unlikely-arg-type" })
	static ICol<String>  prueba()
	{
		
		@SuppressWarnings("unchecked")
		ICol<String> listaMates= new ColTupla(20);
		@SuppressWarnings("unchecked")
		ICol<String> listaLengua= new ColTupla(20);
		listaMates.add(0, mates.getNotas(b2).getNombreCompleto());
		listaMates.add(1, mates.getNotas(b7).getNombreCompleto());
		listaMates.add(2, mates.getNotas(b6).getNombreCompleto());
		listaMates.add(3, mates.getNotas(b9).getNombreCompleto());
		listaMates.add(4, mates.getNotas(b4).getNombreCompleto());
		
		listaLengua.add(0, lengua.getNotas(a3).getNombreCompleto());
		listaLengua.add(1, lengua.getNotas(a4).getNombreCompleto());
		listaLengua.add(2, lengua.getNotas(a7).getNombreCompleto());
		listaLengua.add(3, lengua.getNotas(a5).getNombreCompleto());
		listaLengua.add(4, lengua.getNotas(a10).getNombreCompleto());
		
		
		System.out.println("Aprobados de lengua: " + todoAprobado(lengua));
		System.out.println('\n' + "Deberían ser: " + listaLengua);
		
		System.out.println('\n' + "Aprobados de mates: " + todoAprobado(mates) + '\n' + "Deberían ser: ");
		return listaMates;
	}

	public static void main(String[] args) {
	
		resetearAsignaturas();
		anotarCalificaciones();
		calificarAsignaturas();
		System.out.println(prueba());
		
	}

}
