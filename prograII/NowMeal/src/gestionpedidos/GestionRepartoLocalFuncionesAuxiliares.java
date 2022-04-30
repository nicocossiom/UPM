package gestionpedidos;

import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;
import list.IList;
import queues.CircularQueue;
import queues.IQueue;
import queues.exceptions.EmptyQueueException;

public class GestionRepartoLocalFuncionesAuxiliares {
	// CÓDIGO DE APOYO
	public static IList<String> getCodList(IList<?> disponibles) {
		ArrayList<String> salida = new ArrayList<>();
		for(int i=0; i<disponibles.size(); i++)
			salida.add(salida.size(),((Transporte) disponibles.get(i)).getCodigo());
		return salida;
	}

	// CÓDIGO DE APOYO
	public static IList<String[]> getClienteRestauranteList(IQueue<Pedido> pendientes){
		ArrayList<String[]> salida = new ArrayList<>();
		IQueue<Pedido> aux = new CircularQueue<>();
		try {
			while(!pendientes.isEmpty()) {
				Pedido pedido = pendientes.poll();

				salida.add(salida.size(),new String[]{pedido.getCliente().getCodigo(),
						pedido.getRestaurante().getCodigo()});
				aux.add(pedido);
			}
			while (!aux.isEmpty())
				pendientes.add(aux.poll());		
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return salida;
	}

	// CÓDIGO DE APOYO
	public static String myArrayListToString (IList<?> list){
		String salida = "";
		for(int i=0; i<list.size(); i++){
			salida += " " ;
			if (list.get(i) instanceof String[]){
				String[] item = (String[])list.get(i);
				for(int j=0; j<item.length; j++){
					salida += item[j] ;
				}	
			}else if (list.get(i) instanceof String){
				salida += (String)list.get(i);
			}
		}

		return salida;
	}
}
