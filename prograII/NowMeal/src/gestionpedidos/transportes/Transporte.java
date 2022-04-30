package gestionpedidos.transportes;
import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2;
@Programacion2 (
	nombreAutor1 = "Nicolas",
	apellidoAutor1 = "Cossio Miravalles",
	emailUPMAutor1 = "n.cossio@alumnos.upm.es",
	nombreAutor2 = "Antonio",
	apellidoAutor2 = "Amo Cuellar",
	emailUPMAutor2 = "antonio.amo.cuellar@alumnos.upm.es"
)
public abstract class Transporte {
	@SuppressWarnings("unused")
	private Mapa mapa;
	private String codigo="";
	public Transporte(String mycodigo, Mapa mymapa) {
		mapa=mymapa;
		codigo=mycodigo;
	}

	public double coste(String codPosDestino) {//relega a las funciones segun el tipo de transporte
		return this.coste(codigo, codPosDestino);
	}

	public abstract double coste(String cosPosOrigen, String codPosDestino);

	public String getCodigo(){
		return codigo;
	}
	public void setCodigo(String cod){
		codigo=cod;
	}
	protected Mapa getMapa() {
		return mapa;
	}
}
