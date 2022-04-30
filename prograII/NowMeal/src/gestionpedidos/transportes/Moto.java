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
public class Moto extends Transporte {

	public static double TARIFA_MIN=10.0;;
	private double eurosPKm;
	public Moto(String codigo, Mapa mapa) {
		super(codigo, mapa);
		eurosPKm=2.0;
		
	}

	@Override
	public double coste(String codPosOrigen, String codPosDestino) {
		return super.getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm +TARIFA_MIN;
	}

	public double getEurosPKm() {
		return eurosPKm;
	}
	public void setEurosPKm(double nuevoseurosPKm) {
		eurosPKm=nuevoseurosPKm;
	}


}
