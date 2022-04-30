package colaC;

import Cola.MemoriaExcesiva;

public class ColaCircular<E> implements IColaC<E> {
	
	//Dimension for array of elements
	  private int MAX_ELEMENTOS=11;
	 //Previous index to the first 
	  private int ppo;
	 //Index for last element
	  private int fin;
	  private E[] elements;
	
	  /*Constructor for Cola
		* PRE: n <= MAX_ELEMENTOS
		* POST: Creates an instance of Cola, an array of length=n
		*/
	  @SuppressWarnings("unchecked")
	public ColaCircular(int n) throws MemoriaExcesiva {
		  if (n > MAX_ELEMENTOS)
		       throw new MemoriaExcesiva("Intended size of "+n+ " elements for instance of Cola is too big. Maximum capacity is "+ MAX_ELEMENTOS+ " elements");
		else
		{
			elements=(E[])new Object[n];
			ppo=elements.length-1;
			fin=elements.length-1;
		}
	}

	  private int circler (int ppo) {
		  return ppo=(ppo == elements.length-1)? 0 : ppo+1;
	  }
	  
	  public String toString () {
		String result="("+ ppo+"," +fin+ ", <";
			for(int i=circler(ppo); i<=fin; circler(i)) {
			result=result+", " + elements[i];
			}
		return result + ">)";
	}
	

	public boolean estaVacia() {
		boolean result=false;
		if(fin==ppo) {
			result=true;
		}
		return result;
	}

	public E primero() throws colaC.ColaVacia {
		if (estaVacia()) {
			throw new colaC.ColaVacia("This instance of Cola is empty, please add elements");
		}
		else if (ppo==5) {
			return elements[0]; //If an element is in the 5th position it means that in the circular array it is also the first one
		}
		else {
			return elements[ppo+1]; //We have to take into account the index that was sacrificed between the last and the first
		}
	}

	public void encolar(E elem) throws ColaLlena {
		if(size()==elements.length-1) {
			throw new ColaLlena("Array is full, cannot add more elements");
		}
			else {
				circler(fin); //Finding out last place in cola according to circular nature
				elements[fin]=elem; //Adding element in last place
			}
		}
	
	public void desencolar() {
		if (!estaVacia()) {
			circler(ppo);
		}
		else if (estaVacia()) {
			ppo=elements.length-1;
			fin=elements.length-1;//We need to put the counters back to their normal indexes if it ends up empty after erasing the last element
		}
	}

	public int size() {
		if (!estaVacia()) {
		//The amount of empty spaces (gaps+sacrificed index) left in the array = ppo-fin
		return elements.length-(ppo-fin);//Total number of spaces - number of empty spaces = real size of the array
		}
		else return 0;
	}

}
