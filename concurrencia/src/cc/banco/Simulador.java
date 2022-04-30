package cc.banco;

import java.util.Random;
import es.upm.babel.cclib.ConcIO;
import es.upm.babel.cclib.Semaphore;


public class Simulador {

  static final int MAX_CUENTAS = 5;

  public static void main(String[] args) {
    Banco banco;
    String[] cuentas = cuentas();

    // Por defecto el simulador usa la implementacion programado con monitores
    // Para comprobar la implementacion usando CSP cambia las dos lineas abajo.
    //banco = new BancoMonitor();
     banco = new BancoCSP();

    // Crea procesos
    new Cajero(banco).start();
    new Ordenante(banco).start();
    new Ordenante(banco).start();
    new Ordenante(banco).start();
    for (int i=0; i<MAX_CUENTAS; i++)
      new Consultor(banco,cuentas[i]).start();
    for (int i=0; i<MAX_CUENTAS; i++)
      new Avisador(banco,cuentas[i]).start();
  }

  /**
   * Devuele un array con todos los n�meros de cuenta posibles.
   */
  public static String[] cuentas()
  {
    String cs[] = new String[Simulador.MAX_CUENTAS];
    for (int i = 0; i < Simulador.MAX_CUENTAS; i++)
      cs[i] = String.format("%03d", i);
    return cs;
  }
}


/**
 * Las instancias de Generador son capaces de generar n�meros de
 * cuenta y valores para ingresar o transferir as� como enteros entre
 * 0 y un entero m�ximo (Nota: la implementaci�n no es reentrante, lo
 * mejor es que los procesos no compartan el mismo generador).
 */
class Generador {
  private final int MAX_VALOR = 10;
  private Random r = new Random();
  String cuentas[];

  /**
   * Crea un nuevo generador de cuentas y valores.
   */
  public Generador()
  {
    cuentas = Simulador.cuentas();
  }

  /**
   * Devuele un n�mero de cuenta aleatorio.
   */
  public String cuenta()
  {
    int i = r.nextInt(Simulador.MAX_CUENTAS);
    return cuentas[i];
  }

  /**
   * Devuele una valor aleatorio que se puede usar para ingresar o
   * hacer una transferencia.
   */
  public int valor()
  {
    return 1 + r.nextInt(MAX_VALOR);
  }

  /**
   * Devuele un entero positivo entre 1 y max.
   */
  public int positivo(int max)
  {
    return 1 + r.nextInt(max);
  }
}


class Cajero extends Thread {
  private Banco b;
  private Generador g;

  public Cajero(Banco b) {
    this.b = b;
    this.g = new Generador();
  }

  public void run() {
    while (true) {
      String c = g.cuenta();
      int v = g.valor();

      b.ingresar(c, v);
      // Imprimir informaci�n sobre
      // el ingreso realizado
      ConcIO.printfnl(
        "Ingreso en %s: %d",
        c, v);
      try { sleep(g.positivo(10000)); } catch (InterruptedException exc) { }
    }
  }
}

class Ordenante extends Thread {
  private Banco b;
  private Generador g;

  public Ordenante(Banco b) {
    this.b = b;
    this.g = new Generador();
  }

  public void run() {
    String o, d;
    int v;
    while (true) {
      o = g.cuenta();
      d = g.cuenta();
      v = g.valor();

      try { b.transferir(o, d, v);
        // Imprimir informaci�n sobre
        // la transferencia realizada
        ConcIO.printfnl("Transferencia de %s a %s: %d",
                        o, d, v);
      } catch (IllegalArgumentException exc) {
        ConcIO.printfnl("Transferencia de %s a %s: %d lanz� la excepci�n IllegalArgumentException",
                        o, d, v);
      }
      try { sleep(g.positivo(6000)); } catch (InterruptedException exc) { }
    }
  }
}

class Consultor extends Thread {
  private Banco b;
  private String c;
  private Generador g;

  public Consultor(Banco b, String c) {
    this.b = b;
    this.c = c;
    this.g = new Generador();
  }

  public void run() {
    int s;
    while (true) {

      try {
        s = b.disponible(c);
        // Imprime informaci�n sobre
        // el saldo disponible
        ConcIO.printfnl("Saldo en %s: %d",
                        c, s);
      } catch (IllegalArgumentException exc) {
        ConcIO.printfnl("Saldo en %s lanz� la excepci�n IllegalArgumentException",
                        c);
      }

      try { sleep(g.positivo(2000)); } catch (InterruptedException exc) { }
    }
  }
}

class Avisador extends Thread {
  private Banco b;
  private String c;
  private Generador g;

  public Avisador(Banco b, String c) {
    this.b = b;
    this.c = c;
    this.g = new Generador();
  }

  public void run() {
    int m;
    while (true) {
      m = g.valor();

      try {
        ConcIO.printfnl("Estableciendo alerta: %s por debajo de %d",
                        c, m);
        b.alertar(c, m);
        // Comunicar la alerta sobre
        // saldo inferior a m
        ConcIO.printfnl("ALERTA: %s por debajo de %d",
                        c, m);
      } catch (IllegalArgumentException exc) {
        ConcIO.printfnl("ALERTA: %s por debajo de %d lanz� la excepci�n IllegalArgumentException",
                        c, m);
      }

      try { sleep(g.positivo(2000)); } catch (InterruptedException exc) { }
    }
  }
}
