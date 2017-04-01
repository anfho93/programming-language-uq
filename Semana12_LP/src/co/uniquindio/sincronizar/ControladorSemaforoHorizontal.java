package co.uniquindio.sincronizar;

public class ControladorSemaforoHorizontal {

	Semaforo[] misSemaforos = new Semaforo[2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorSemaforoHorizontal aux = new ControladorSemaforoHorizontal();
		aux.manejadorSemaforo();
	}

	public synchronized void manejadorSemaforo() {
		// crea el primer semaforo que iniciar automaticamente
		Semaforo hiloSemaforo1 = new Semaforo(true, this);
		// crea el segundo semanforo que esperar a que el primero termine para seguir
		Semaforo hiloSemaforo2 = new Semaforo(false, this);
		misSemaforos[0] = hiloSemaforo1;
		misSemaforos[1] = hiloSemaforo2;
		misSemaforos[0].start();		
		misSemaforos[1].start();
		try {
			//Necesario para evitar el comportamiento erratico inicial
			misSemaforos[1].sleep(1000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void notificar() {

		for (int i = 0; i < misSemaforos.length; i++) {
			{
				//notifica a todos los hilos que se despierten
				// de manera sincronizada por cada hilo
				// es decir si varios hilos intentan notificar, se hace en orden
				synchronized (misSemaforos[i]) {
					misSemaforos[i].notify();
				}
			}
		}
	}

}
