// Implementacion de Banco usando monitores
// Autores: Nicolas Cossio Miravalles (190882) y Telmo Viudez Escobar (190084)

package cc.banco;

import es.upm.babel.cclib.Monitor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BancoMonitor implements Banco {

    // Mapa que almacena el estado del recurso
    private Map<String, Cuenta> bc;
    // Monitor
    private Monitor mutex;
    // Cola de alertas
    private Queue<AlertaSaldo> colaAlertas;
    // Conjunto de cuentas con transferencias desde ella pendientes para el
    // desbloqueo
    private Set<Cuenta> cuentasTransPendiente;

    public BancoMonitor() {
        this.bc = new HashMap<String, Cuenta>();
        this.colaAlertas = new LinkedList<AlertaSaldo>();
        this.mutex = new Monitor();
        cuentasTransPendiente = new HashSet<Cuenta>();
    }

    private class AlertaSaldo {
        // Id de cuenta para la alerta
        public String cuenta;
        // Umbral de alerta
        public Integer minimo;
        // Condicion de alerta
        public Monitor.Cond condAlerta;

        public AlertaSaldo(String acc, int min) {
            minimo = min;
            cuenta = acc;
            condAlerta = mutex.newCond();
        }
    }

    private class Transferencia {
        // Cuenta de destino (la transf se guarda en la cuenta origen)
        public Cuenta cuentaDestino;
        // Cantidad de la transferencia
        public Integer cantidad;
        // Condicion para sincronizacion
        public Monitor.Cond condTrans;

        public Transferencia(Cuenta acc1, Cuenta acc2, int cantidad) {
            cuentaDestino = acc2;
            this.cantidad = cantidad;
            condTrans = mutex.newCond();
        }
    }

    private class Cuenta {
        public Integer saldo;
        // Transferencias desde la cuenta
        public Queue<Transferencia> colaTransf;

        public Cuenta(int v, String id) {
            this.saldo = v;
            colaTransf = new LinkedList<Transferencia>();
        }
    }

    /**
     * Un cajero pide que se ingrese una determinado valor v a una cuenta c. Si la
     * cuenta no existe, se crea.
     * 
     * @param c numero de cuenta
     * @param v valor a ingresar
     */
    public void ingresar(String c, int v) {
        mutex.enter();
        Cuenta acc = bc.get(c);
        if (acc == null) {
            Cuenta newAcc = new Cuenta(v, c);
            bc.put(c, newAcc);
        } else if (acc.saldo == -1) {
            acc.saldo = v;
            // Notificar que existe la cuenta para poder transferir desde ella, o hacia ella
            desbloqTransferencia();
        } else {
            // Cuenta existe
            acc.saldo += v;
            // Desbloquear por si el aumento de saldo hace posible una transf.
            desbloqTransferencia();
        }
        mutex.leave();
    }

    /**
     * Un ordenante pide que se transfiera un determinado valor v desde una cuenta o
     * a otra cuenta d.
     * 
     * @param o numero de cuenta origen
     * @param d numero de cuenta destino
     * @param v valor a transferir
     * @throws IllegalArgumentException si o y d son las mismas cuentas
     *
     */
    public void transferir(String o, String d, int v) {
        mutex.enter();
        if (o.equals(d)) {
            // Comprobar PRE
            mutex.leave();
            throw new IllegalArgumentException("No se puede transferir a la misma cuenta");
        }

        Cuenta cuentaO = bc.get(o);
        Cuenta cuentaD = bc.get(d);
        boolean signal = false;

        // Tratamiento de origen o destino inexistentes
        if (cuentaO == null) {
            // Creamos una cuenta con saldo -1 para almacenar las condiciones
            cuentaO = new Cuenta(-1, o);
            bc.put(o, cuentaO);
        }

        if (cuentaD == null) {
            // Creamos una cuenta con saldo -1 para almacenar las condiciones
            cuentaD = new Cuenta(-1, d);
            bc.put(d, cuentaD);
        }

        Transferencia nuevaTransf = new Transferencia(cuentaO, cuentaD, v);

        // Si hay mas transferencias en cola o no se cumple la CPRE, hay que esperar
        if (cuentaO.colaTransf.size() > 0 || cuentaD.saldo == -1 || cuentaO.saldo < v) {
            // Marcar cuenta origen como pendiente y poner la transferencia en su cola
            cuentasTransPendiente.add(cuentaO);
            cuentaO.colaTransf.add(nuevaTransf);
            // No se puede realizar la transferencia, esperar al desbloqueo
            nuevaTransf.condTrans.await();
        }

        // Se puede transferir dado que se cumple CPRE. Seccion critica:
        cuentaO.saldo = cuentaO.saldo - v;
        cuentaD.saldo = cuentaD.saldo + v;

        // Transferencia realizada. Realizar desbloqueo
        signal = desbloqTransferencia();

        // El saldo ha cambiado, realizar desbloqueo de alertas
        if (!signal) {
            signal = desbloqAlerta();
        }
        mutex.leave();
    }

    // Intenta desbloquear una transferencia de una de las cuentas que tienen transf
    // pendientes
    // Devuelve true si se desbloquea una transferencia, false en caso contrario
    private boolean desbloqTransferencia() {
        boolean signal = false;
        // Extraer una cuenta origen
        for (Cuenta origen : cuentasTransPendiente) {
            // Comprobar CPRE: Existe el origen?
            if (origen != null && origen.saldo != -1) {
                // Comprobar que haya transferencias que desbloquear
                if (!origen.colaTransf.isEmpty()) {
                    Transferencia primeraTransf = origen.colaTransf.peek();
                    // Existe el destino?
                    if (primeraTransf.cuentaDestino != null && primeraTransf.cuentaDestino.saldo != -1) {
                        // Hay suficiente saldo?
                        if (primeraTransf.cantidad <= origen.saldo) {
                            // Se cumplen todas las condiciones, eliminar la transferencia de la cola
                            if (primeraTransf.condTrans.waiting() > 0) {
                                origen.colaTransf.poll();
                                primeraTransf.condTrans.signal();
                                // Si no quedan transferencias en esta cuenta eliminarla del conjunto
                                if (origen.colaTransf.isEmpty()) {
                                    cuentasTransPendiente.remove(origen);
                                }
                                // Salir del bucle y devolver true ya que se ha desbloqueado
                                signal = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return signal;
    }

    /**
     * Un consultor pide el saldo disponible de una cuenta c.
     * 
     * @param c numero de la cuenta
     * @return saldo disponible en la cuenta id
     * @throws IllegalArgumentException si la cuenta c no existe
     */
    public int disponible(String c) {
        mutex.enter();
        Cuenta cuenta = bc.get(c);
        // Comprobar si la cuenta no existe (o es "zombi", con saldo -1), en caso
        // afirmativo salir
        if (cuenta == null || cuenta.saldo == -1) {
            mutex.leave();
            throw new IllegalArgumentException("Cuenta " + c + "no existe");
        }
        // Obtener el saldo
        Integer saldoDisp = cuenta.saldo;
        mutex.leave();
        return saldoDisp;
    }

    /**
     * Un avisador establece una alerta para la cuenta c. La operacion termina
     * cuando el saldo de la cuenta c baja por debajo de m.
     * 
     * @param c numero de la cuenta
     * @param m saldo minimo
     * @throws IllegalArgumentException si la cuenta c no existe
     */
    public void alertar(String c, int m) {
        mutex.enter();
        Cuenta cuenta = bc.get(c);
        if (cuenta == null || cuenta.saldo == -1) {
            mutex.leave();
            throw new IllegalArgumentException("Cuenta " + c + "no existe");
        }
        Integer saldo = cuenta.saldo;

        // Comprobacion de CPRE
        if (saldo >= m) {
            // Alerta debe ser almacenada en cola ya que CPRE no se cumple
            AlertaSaldo al = new AlertaSaldo(c, m);
            colaAlertas.add(al);
            // Esperar al cumplimiento de CPRE
            al.condAlerta.await();
            // Realizar un desbloqueo

        }
        // Desbloqueo de otra alerta si es posible
        desbloqAlerta();
        mutex.leave();
    }

    // Metodo que toma una alerta de la cola de alertas y la desbloquea si se cumple
    // Devuelve true si se consigue desbloquear una alerta, o false en caso
    // contrario
    private boolean desbloqAlerta() {
        boolean signal = false;
        int n = colaAlertas.size();
        for (int i = 0; i < n && !signal; i++) {
            AlertaSaldo al = colaAlertas.peek();
            Integer saldoAl = bc.get(al.cuenta).saldo;
            // Comprobacion de CPRE
            if (saldoAl < al.minimo) {
                // Se elimina la alerta de la cola
                al.condAlerta.signal();
                colaAlertas.poll();
                // Desbloqueado, salida del bucle
                signal = true;
            } else {
                // No se puede desbloquear, reencolar la primera alerta
                colaAlertas.poll();
                colaAlertas.add(al);
            }
        }
        return signal;
    }

}