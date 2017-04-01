package co.uniquindio.hilos;

public class ManejadoHilos {

	
	public static void main(String[] args) {
		MiHilo hilo1 =  new MiHilo("Hilo1 ");
		MiHilo hilo2 =  new MiHilo("Hilo2 ");		
		hilo2.setPriority(10);
		hilo1.start();
		hilo2.start();
	}
}
