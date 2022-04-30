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
public class FurgonetaSubcontratada extends Furgoneta{
	private double eurosPKm=1;

	public FurgonetaSubcontratada(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa);
		setTara(tara);
	}

	public double getEurosPKm() {
		return this.eurosPKm;
	}

	public void setEurosPKm(double nuevoeurosPKm) {
		this.eurosPKm = nuevoeurosPKm;
	}

	public double coste(String codOrigen, String codDestino) {
		double costefinal=0;
		if (getTara()<1000) {
			costefinal=super.getMapa().distancia(codOrigen, codDestino)*eurosPKm;
		}
		else if (getTara()>1000) {
			costefinal=super.getMapa().distancia(codOrigen, codDestino)*eurosPKm*1.10;
		}
		return costefinal;
	}
}
