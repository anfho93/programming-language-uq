package co.uniquindio.sincronizar;

public class Hilo implements Runnable{

	String nombre;
	 
	public Hilo(String string) {
		this.nombre = string;
		new Thread(this).start();
	}


	@Override
	 public void run() {
		 int i=0;
		while (true) {
			synchronized (this) {
				
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(nombre + "i=="+i);
					++i;
					
				
			}
			
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Hilo[] misHilos =  new Hilo[3];
		
		for (int i = 0; i < misHilos.length; i++) {
			misHilos[i] =  new Hilo("Hilo"+i);
		}
			
		while (true) {
			for (int j = 0; j < misHilos.length; j++) {
				synchronized (misHilos[j]) {
					misHilos[j].notify();
					Thread.sleep(1000l);
				}
			}
			
				
			
			/*
			synchronized (misHilos[0]) {
				misHilos[0].notify();
				Thread.sleep(1000l);
			}
			
			synchronized (misHilos[1]) {
				misHilos[1].notify();
				Thread.sleep(1000l);
			}
			synchronized (misHilos[2]) {
				misHilos[2].notify();
				Thread.sleep(1000l);
			}*/
		}
		
	}
	
	
}
