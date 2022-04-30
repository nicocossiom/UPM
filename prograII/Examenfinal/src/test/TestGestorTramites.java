package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import admin.GestorTramites;
import admin.Tramite;
import admin.exception.ErrorNoHayTramites;
import admin.TipoTramites;

public class TestGestorTramites extends Tramite{
	


	private GestorTramites gestor;
	private String [] tramitesOrden = {new String(TipoTramites.HACIENDA.name()+3),
									new String(TipoTramites.HACIENDA.name()+5),
									new String(TipoTramites.JUSTICIA.name()+4),
									new String(TipoTramites.TRABAJO.name()+1),
									new String(TipoTramites.SANIDAD.name()+2)};
	private TipoTramites [] tramites= {TipoTramites.TRABAJO,TipoTramites.SANIDAD,
			   TipoTramites.HACIENDA,TipoTramites.JUSTICIA,TipoTramites.HACIENDA};
	
	@Before
	public void setup() {
		//Se crea el gestor
		gestor = new GestorTramites();
		//Se reinicia el contador de trámites
		super.restContadorTramites();
	}
	

	/**
	 * Este test procede a registrar una serie de trámites y controla qeu se actualice el número 
	 * total de elementos esperando y que se retorne el id de registro correcto
	 */
	@Test
	public void testRegistrarTramite() {
		for (int i =0; i < tramites.length;i ++) {
			assertEquals("El número de total esperando no coincide",i,gestor.totalEsperando());
			assertEquals ("El id de registro no es el esperado.",tramites[i].name()+(i+1),
					gestor.registrarTramite(tramites[i]));

		}
		assertEquals("El número de total esperando no coincide",tramites.length,gestor.totalEsperando());
	}

	/**
	 * ESta prueba requiere que funcionen tanto registrarTramite como getNext.
	 * Registra un conjunto de trámites y verifica que estén en el orden correcto.
	 * @throws ErrorNoHayTramites
	 */
	@Test
	public void testRegistrarTramite2() throws ErrorNoHayTramites {
		//Se verifica que se han colocado correctamente para ello se requiere que también funcione getNext
		//Si getNExt no funciona o registrarTramite no funciona la prueba fallará
		for (int i =0; i < tramites.length;i++) {
			assertEquals ("El id de registro no es el esperado.", tramites[i].name()+(i+1),
					gestor.registrarTramite(tramites[i]));
		}
		
		for (int i = 0; i<tramitesOrden.length;i++) {
			Tramite tramite = gestor.getNext();
			assertEquals ("No coincide el sisugiente trámite con el esperado", tramitesOrden[i],tramite.getIdRegistro());
		}
	}
	
	/**
	 * ESta pruuba requiere que funcionen tanto registrarTramite como getNext.
	 * Registra un conjunto de trámites saca alcunos trámites y vuelve a insertar
	 * @throws ErrorNoHayTramites
	 */
	@Test
	public void testRegistrarTramite3() throws ErrorNoHayTramites {
		String [] tramitesOrden = {new String(TipoTramites.HACIENDA.name()+3),
				new String(TipoTramites.HACIENDA.name()+5),
				new String(TipoTramites.JUSTICIA.name()+4),
				new String(TipoTramites.JUSTICIA.name()+6),
				new String(TipoTramites.JUSTICIA.name()+9),
				new String(TipoTramites.TRABAJO.name()+1),
				new String(TipoTramites.TRABAJO.name()+10),
				new String(TipoTramites.SANIDAD.name()+2),
				new String(TipoTramites.SANIDAD.name()+7),
				new String(TipoTramites.SANIDAD.name()+8)
				};
		TipoTramites [] tramites2= {TipoTramites.JUSTICIA,TipoTramites.SANIDAD,
				   TipoTramites.SANIDAD,TipoTramites.JUSTICIA,TipoTramites.TRABAJO};
		//Se verifica que se han colocado correctamente para ello se requiere que también funcione getNext
		//Si getNExt no funciona o registrarTramite no funciona la prueba fallará
		for (int i =0; i < tramites.length;i++) {
			assertEquals ("El id de registro no es el esperado.", tramites[i].name()+(i+1),
					gestor.registrarTramite(tramites[i]));
		}
		
		//Se extraen algunos trámites
		for (int i = 0; i<tramites.length/2;i++) {
			Tramite tramite = gestor.getNext();
			assertEquals ("No coincide el sisugiente trámite con el esperado", tramitesOrden[i],tramite.getIdRegistro());
		}
		
		//Se insertan trámites adicionales
		for (int i =0; i < tramites2.length;i++) {
			String id = gestor.registrarTramite(tramites2[i]); 
			assertEquals ("El id de registro no es el esperado.", tramites2[i].name()+(i+tramites.length+1),
					id);
		}
		
		//Se verifica que todos están en orden
		for (int i = tramites.length/2; i<tramitesOrden.length;i++) {
			Tramite tramite = gestor.getNext();
			assertEquals ("No coincide el sisugiente trámite con el esperado", tramitesOrden[i],tramite.getIdRegistro());
		}
		
	}
	
	
	/**
	 * Preuba getNext cuando no hay trámites debería generar la excepción
	 * @throws ErrorNoHayTramites 
	 */
	@Test (expected = ErrorNoHayTramites.class)
	public void testGetNext() throws ErrorNoHayTramites {
		gestor.getNext();
	}

	
	
	/**
	 * Prueba que no hay  trámites cuando se acaba de crear
	 */
	@Test
	public void testHayTramites() {
		//Inicialmente no hay
		assertTrue ("Al prinicpio no hay trámites!!", !gestor.hayTramites());
	}

	/**
	 * Prueba que hay  trámites cuando se inserta un trámite de máxima prioridad
	 */
	@Test
	public void testHayTramites2() {
		//Si no funciona registrar trámite el siguiente código dará error
		gestor.registrarTramite(tramites[2]);
		assertTrue ("Al insertar un trámite debe haber trámites!!", gestor.hayTramites());
	}
	
	/**
	 * Prueba que hay trámites cuando se inserta un trámite de mínima prioridad
	 */
	@Test
	public void testHayTramites3() {
		//Si no funciona registrar trámite el siguiente código dará error
		gestor.registrarTramite(tramites[0]);
		assertTrue ("Al insertar un trámite debe haber trámites!!", gestor.hayTramites());
	}
	
	/**
	 * Prueba que al sacar los trámites dé la información correcta
	 */
	@Test
	public void testHayTramites4() {
		//Si no funciona registrar y getNext trámite el siguiente código dará error
		gestor.registrarTramite(tramites[0]);
		assertTrue ("Al insertar un trámite debe haber trámites!!", gestor.hayTramites());
		try {
			gestor.getNext();
			assertTrue ("Al extraer el último trámite no debería haber trámites!!", !gestor.hayTramites());
		} catch (ErrorNoHayTramites e) {
			e.printStackTrace();
			fail("Se produjo una excepción no esperada");
		}	
	}
	
	/**
	 * Verfica total esperando cuando se acaba de crear
	 */
	@Test
	public void testTotalEsperando() {
		assertTrue ("Al prinicpio no hay trámites!!", gestor.totalEsperando()==0);
	}
	
	@Test
	public void testTotalEsperando2() {
		//Para que esta prueba funcione debe funcionar el método registro
		for (int i = 0; i < tramites.length;i++) {
			gestor.registrarTramite(tramites[i]);
			assertTrue ("Se han inisertado: "+(i+1)+" trámites pero el número de total espernado es de: "+gestor.totalEsperando(), 
					gestor.totalEsperando()==(i+1));
		}
	}

}
