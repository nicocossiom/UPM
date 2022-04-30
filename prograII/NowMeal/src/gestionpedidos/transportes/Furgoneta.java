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
public abstract class Furgoneta extends Transporte {
	private double tara;
	public Furgoneta(String codigo, Mapa mapa) {
		super(codigo, mapa);
		tara=0;
	}
	public double getTara() {
		return tara;
	}
	public void setTara(double nuevatara) {
		tara=nuevatara;
	}
}