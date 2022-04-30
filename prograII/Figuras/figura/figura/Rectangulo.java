/**
 * 
 */
package figura;

/**
 * @author nicol
 * @since 4/19/2020
 * @version 1.0
 * Implementation of a Figura<-- Rectangle
 * An instance of Rectangle is an element of a reticule ZxZ, in this case a figure with  properties:
 * 1. Position is given by the circumcenter (since it is an int, it is not an exact value for the centre)
 * 2. 4 sides, two by two in parallel, each making Pi/2 of angle with their contiguous. 
 * 3. One pair of the sides has to be smaller/bigger than the other.
 */
public class Rectangulo extends Figura {

	private int ancho;
	private int alto;
	public Rectangulo(IPunto pos, int gran, int peq) {
		super(pos);
		ancho=gran;
		alto=peq;
	}
	
	@Override
	public String toString()
	{
		return "Rectangulo(" + super.toString() + ", " + ancho + ", " + alto + ")";
	}
	
	public int getAltura()
	{
		return this.alto;
	}
	
	public int getAnchura()
	{
		return this.ancho;
	}
	
	public boolean equals(Object f)
	{
		if (f instanceof Rectangulo) {
			Rectangulo r= (Rectangulo) f;
			return (super.equals(f)
					&& (ancho==r.ancho)
					&& (alto==r.alto));
		}
		else{return false;}
	}
	/* 
	 * POST: result is the area of the rectangle
	 */
	public int area() {
		return getAltura() * getAnchura();
	}
	
	/*
	 * POST: result is the perimeter of the rectangle 
	 */
	public int perimetro() {
		return getAltura()*2+getAnchura()*2;
	}
}
