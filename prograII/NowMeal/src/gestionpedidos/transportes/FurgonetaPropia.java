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
public class FurgonetaPropia extends Furgoneta{

	private double velocidadMedia=30;
	private static final double EUROS_P_HORA=40;

	public FurgonetaPropia(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa);
		setTara(tara);
	}

	public double getvelocidadMedia() {
		return velocidadMedia;
	}
	public void setVelocidadMedia(double nuevavelocidadMedia) {
		velocidadMedia=nuevavelocidadMedia;
	}

	public double coste(String codOrigen, String codDestino) {
		double costefinal=0;
		if (getTara()<500) {
			costefinal=this.getMapa().distancia(codOrigen, codDestino)*EUROS_P_HORA/velocidadMedia;
		}
		else {
			costefinal=this.getMapa().distancia(codOrigen, codDestino)*EUROS_P_HORA/velocidadMedia*1.10;
		}
		return costefinal;
	}
}
