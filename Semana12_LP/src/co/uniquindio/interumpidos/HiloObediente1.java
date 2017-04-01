package co.uniquindio.interumpidos;

public class HiloObediente1 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i);//imprimir en la consola es un metodo sincronizado.
			//Solo un hilo al timepo tiene acceso a la cosola
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// Nos han pedido terminar. Hay que obedecer.
				System.out.println("Detuvieron el hiloObediente1");
				return;
			}
		}
	}

}
