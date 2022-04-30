package cc.banco;

public class testmanual {
    private static BancoMonitor banco = new BancoMonitor();
    private static class Ingresador extends Thread {        
        private String cuenta;
        private int cantidad;
        public Ingresador (String cuenta, int cantidad){ 
            this.cuenta = cuenta;
            this.cantidad = cantidad;
        }
        public void run(){
            banco.ingresar(cuenta, cantidad);
            System.out.println("Haciendo ingreso en " + cuenta + "de cantidad: " + cantidad);
        }
    }
    private static class Transferidor extends Thread {   
        private String cuentaO;
        private String cuentaD;
        private int cantidad; 
        public Transferidor(String cuentaO, String cuentaD, int cantidad){
            this.cuentaO = cuentaO;
            this.cuentaD = cuentaD;
            this.cantidad = cantidad;
        }
        public void run(String cuentaO, String cuentaD, int cantidad){
            banco.transferir(cuentaO, cuentaD, cantidad);
            System.out.println("Haciendo transferencia de " + cuentaO + " a: " + cuentaD + " con valor "+ cantidad);
        }
    }
    private static class Alertador extends Thread {    
        public void run(String cuenta, int cantidad){
            System.out.println("Creando alerta para " + cuenta + " valor: " + cantidad);
            banco.alertar(cuenta, cantidad);
        }
    }
    

     public static final void main(String[] args){
        Ingresador ingr1 = new Ingresador("bbk", 25);
        Ingresador ingr2 = new Ingresador("hacienda", 50);
        Ingresador ingr3 = new Ingresador("hacienda", 50);
        Ingresador ingr4 = new Ingresador("bbk", 50);
        Ingresador ingr5 = new Ingresador("santander", 25);
        Transferidor transf1 = new Transferidor("hacienda","bbk",75);
        Transferidor transf2 = new Transferidor("bbk","santander",75);
        Transferidor transf3 = new Transferidor("santander","hacienda",75);
        Transferidor transf4 = new Transferidor("bbk","hacienda",75);
        ingr1.start();
        transf1.start();
        transf2.start();
        transf3.start();
        transf4.start();
        ingr2.start();
        ingr3.start();
        ingr4.start();
        ingr5.start();
    }
}

