package co.uniquindio.hilos;

public class MiHilo extends Thread{
	
	private String nombre;
	public  MiHilo(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public void run() {		
		for (int i = 0; i < 10; i++) {
			System.out.println(nombre +": iteracion"+i);
			try {
				//Hacemos que el hilo se detenga por medio segundo
				//si no hacemos esto no se podria observar el 
				//paralelismo
				this.sleep(500l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
