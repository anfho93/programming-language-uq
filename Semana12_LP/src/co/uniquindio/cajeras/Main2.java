package co.uniquindio.cajeras;

public class Main2 {

	public static void main(String[] args) {
		
		Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
				Cajera cajera1 = new Cajera("Cajera 1");
				long initialTime = System.currentTimeMillis();
				cajera1.procesarCompra(cliente1, initialTime);
			}
		});
		
		Thread hilo2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });				
				Cajera cajera2 = new Cajera("Cajera 2");

				long initialTime = System.currentTimeMillis();
				cajera2.procesarCompra(cliente2, initialTime);
			}
		});
		
		hilo.setPriority(10);
		hilo2.setPriority(5);
		hilo.start();
		hilo2.start();
	}
}
