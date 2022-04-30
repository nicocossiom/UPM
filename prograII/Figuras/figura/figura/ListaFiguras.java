package figura;
import java.util.Random;
/*
 * Program that cretes 3 circles, 3 dots, 3 rectangles and other undetermined figures, and is able to excecute some functions in relation to it
 * @since 24/4/2020
 * @version 1.0
 * @author Nicolas Cossio Miravalles
 */
public class ListaFiguras {
	//Creating an empty list
	static IFigura[] colFiguras= new IFigura[12];
	
	//Constants for the list 
	static 
	Random numbergenerator=new Random();//Instance of class random that can call a submethod to create random numbers in a given rangeç
	static int n1=numbergenerator.nextInt(10);//Random int value
	static int n2=numbergenerator.nextInt(10);//Random int value
	static int n3=numbergenerator.nextInt(10);//Random int value
	static IPunto p1= new Punto (n1,n3);//Random point
	static IPunto p2= new Punto (n2,n2);//Random point
	static IPunto p3= new Punto (n3,n1);//Random point
	static Circulo c1= new Circulo (p1,n1); static Circulo c2= new Circulo (p2,n3); static Circulo c3= new Circulo (p3,n2);//3 random instances of circles
	static Dot d1= new Dot (p2); static Dot d2= new Dot (p1); static Dot d3= new Dot (p3); //3 random instances of dots
	static Rectangulo r1= new Rectangulo (p2,n3,n1);static Rectangulo r2= new Rectangulo (p1,n1,n3);static Rectangulo r3= new Rectangulo (p3,n2,n1);//3 random instances of rectangles
	static Figura f1= new Figura (p2); static Figura f2= new Figura (p1);static Figura f3= new Figura (p3);//3 random undetermined figures
	
	/*
	 * Creates figures and adds them to a list
	 * PRE: ListaFiguras() has been initialized
	 * POST: Creates 3 random circles, 3 random dots, 3 random rectangles and 3 random figures and adds them to a list
	 */
	public static void crearFiguras()
	{
		colFiguras[0]=c1;
		colFiguras[1]=d1;
		colFiguras[2]=r1;
		colFiguras[3]=f1;
		colFiguras[4]=c2;
		colFiguras[5]=d2;
		colFiguras[6]=r2;
		colFiguras[7]=f2;
		colFiguras[8]=c3;
		colFiguras[9]=d3;
		colFiguras[10]=r3;
		colFiguras[11]=f3;
		}

	private static int classifier (IFigura m)
	{
		int result=0;
		@SuppressWarnings("rawtypes")
		Class mClass = m.getClass();
			  if (mClass.equals(f1.getClass())){
				  result=0;
			  }
			  else if (mClass.equals(d1.getClass())){
				  result=1;
			  }
			  else if (mClass.equals(c1.getClass())){
				  result=2;
			  }
			  else if (mClass.equals(r1.getClass())){
				  result=3;
		  	}
		return result;
		}
	
	/* Cretes a sorted list in which each position has a list of a type of figure
	 * PRE: colFiguras has been created already
	 * POST: result is a colection of colections of the different types of figures that exist 
	 */
	@SuppressWarnings("unchecked")
	public static ICol<IFigura>[] clasificar (IFigura[] colFiguras)
	{
		ICol<IFigura>[] resultado = new ICol[4];
		ICol<IFigura> figuras= new ColTupla <IFigura>(3);
		ICol<IFigura> dots= new ColTupla <IFigura>(3);
		ICol<IFigura> circulos= new ColTupla <IFigura>(3);
		ICol<IFigura> rectangulos= new ColTupla <IFigura>(3);
		int j=0; 
		int k=0; 
		int l=0; 
		int m=0; 
		for(int i=0; i<colFiguras.length; i++) {
			if (classifier(colFiguras[i])==0) {
				figuras.add(j, colFiguras[i]);
				j++;
			}
			else if(classifier(colFiguras[i])==1) {
					dots.add(k,colFiguras[i]);
					k++;
			}
			else if(classifier(colFiguras[i])==2){
				circulos.add(l, colFiguras[i]);
				l++;
			}
			else {
				rectangulos.add(m, colFiguras[i]);
				m++;
			}
		}
		resultado[0]=figuras;
		resultado[1]=dots;
		resultado[2]=circulos;
		resultado[3]=rectangulos;
		return resultado;
	}
	
	/*
	 * Gets the circles from the list and prints them 
	 * PRE: crearFiguras() has been initialized
	 * POST: result is the chain of characters from the circles present in the list
	 */
	  public static String losCirculos (IFigura[] colFiguras)
	  {
		  String result= "";
		  for(int i=0; i<colFiguras.length; i++) {
			  if(classifier(colFiguras[i])==2) {
				  result=result+colFiguras[i].toString() + '\n';
			  }
		  }
		  return result; 
	  }
	  
	  static public String printer1(ICol<IFigura>[] resultado)
	  {
			String result="";
			for(int i=0; i<resultado.length;i++) {
				result=result+ printer2(resultado[i])+'\n'; 
			}
			return " < \n" + result + ">";
		}
	  static public String printer2(ICol<IFigura> m)
	  {
		 String result="";
		 for(int i=0; i<m.size(); i++) {
			result=result+ m.get(i).toString() + " ";
		 }
		 return result; 
	  }
	  public static void main (String[] args) 
	  {
		  crearFiguras();
		  System.out.println("\n losCirculos: \n" + losCirculos(colFiguras));
		  System.out.println("\n clasificar: \n" + printer1(clasificar(colFiguras)));
	  }
	  
}