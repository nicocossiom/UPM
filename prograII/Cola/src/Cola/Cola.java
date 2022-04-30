package Cola;

public class Cola<E> implements ICola<E> {

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
	public Cola(int n) throws MemoriaExcesiva {
		if (n > MAX_ELEMENTOS)
		       throw new MemoriaExcesiva("Intended size of "+n+ " elements for instance of Cola is too big. Maximum capacity is "+ MAX_ELEMENTOS+ " elements");
		else
		{
			elements=(E[])new Object[n];
			ppo=-1;
		    fin=-1;
		}
	}
	
	@Override
	public boolean estaVacia() {
		boolean result=false;
		if(ppo==fin) {
			result=true;
		}
		return result;
	}
	
	private void resetCounters() {
		ppo=-1;
		fin=-1;
	}
	public String toString() {
		String result="<";
		if (fin>-1) { 
		for(int i=ppo+1; i<fin; i++) {
			 result=result+ elements[i]+", ";
			}
		result=result+elements[fin];
		}
		return "(Size:" + size()+ ", Array: " + result +">)";
	}
	
	@Override
	public E primero() throws ColaVacia {
		if (estaVacia()) {
			throw new ColaVacia("This instance of Cola is empty, please add elements");
		}
		else {
			return elements[ppo+1];
		}
	}

	@Override
	public void encolar(E elem) throws ArrayIndexOutOfBoundsException {
		if(size()>elements.length-1)
			throw new ArrayIndexOutOfBoundsException("Array is full, cannot add more elements");
		else {
			fin++;
			elements[fin]=elem;
			
		}
	}

	@Override
	public void desencolar() throws ColaVacia {
		if (estaVacia()) {
			resetCounters();
			throw new ColaVacia("The array is empty, cannot subtract elements");
	}
		else {
			ppo++;
			elements[ppo]=null;
			
		}
	}

	@Override
	public int size() {
		return fin-ppo;
	}
}
