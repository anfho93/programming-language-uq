package co.uniquindio.cajeras;

public class Cajera {

	private String nombre;

	// Constructor, getter y setter

	public Cajera(String string) {
		this.nombre =  string;
	}


	public void procesarCompra(Cliente cliente, long timeStamp) {
		//imprime un mensaje inicial
		System.out.println("La cajera " + this.nombre + 
				" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + 
				" EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
				"seg");
		//procesa cada producto del cliente
		for (int i = 0; i < cliente.getCarroCompra().length; i++) { 
				this.procesarProducto(cliente.getCarroCompra()[i]); 
				System.out.println(nombre+"->"+"Procesado el producto " + (i + 1) +  
				" ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
				"seg");
		}
		//imprime un mensaje indicando la finalizacion del proceso de compra
		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " + 
				cliente.getNombre() + " EN EL TIEMPO: " + 
				(System.currentTimeMillis() - timeStamp) / 1000 + "seg");

	}


	private void procesarProducto(int segundos) {
		try {
			
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}