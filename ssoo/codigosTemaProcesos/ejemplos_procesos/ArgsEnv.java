// Ejemplo de acceso a los argumentos y a una variable de entorno
class ArgsEnv {
	static public void main(String [] args){
		for (int i=0; i<args.length; i++)
			System.out.println("args[" + i + "]: " + args[i]);
		String val;
		if ( (val = System.getenv("MIVAR")) != null)
			System.out.println("MIVAR: " + val);
	}
}
