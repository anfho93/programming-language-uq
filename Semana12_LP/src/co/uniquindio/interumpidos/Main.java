package co.uniquindio.interumpidos;

public class Main {

	public static void main(String[] args) {
		HiloObediente1 hilo1 = new HiloObediente1();
		HiloObediente2 hilo2 =  new HiloObediente2();
		
		Thread t1 = new Thread(hilo1);
		Thread t2 = new Thread(hilo2);
		
		t2.start();
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t2.interrupt();
		
		t1.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Interrumpieron el Hilo Principal");
		}
		t1.interrupt();
		
	}
}
