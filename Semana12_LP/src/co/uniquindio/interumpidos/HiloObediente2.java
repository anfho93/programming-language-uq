package co.uniquindio.interumpidos;

public class HiloObediente2 implements Runnable{

	@Override
	public void run() {
		
		for (int i = 0; i < 10000000; i++) {
			System.out.println(i);
			
			if(Thread.interrupted())
			{	//Nos han pedido terminar la ejecución.
				System.out.println("Detuvieron el hiloObediente2");
				break; //o return como deseen.
			}
			
		}
		
	}
	
	
	public void metodo(String nombreParam)
	{		
		//..........
		synchronized (this) {
			//Codigo importante, que puede tener problemas
			//en la concurrencia.s
		}
		//..........
	}

}
