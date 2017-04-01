package co.uniquindio.sincronizar;

public class Semaforo extends Thread {
	
	//Constantes para el manejo del Semaforo
	public final static int ROJO = -1;
	public final static int AMARILLO = 0;
	public final static int VERDE = 1;
	//indica que si el semaforo esta activo o no
	public boolean activo = false;
	// variable para almacenar el estado
	public int state = -1;
	// Controlador de los semaforos necesario para notificar
	private ControladorSemaforoHorizontal controlador;

	public Semaforo(boolean activo, ControladorSemaforoHorizontal comp) {
		this.activo = activo;
		this.controlador = comp;
	}

	@Override
	public void run() {

		try {
			manejador();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Metodo con la lógica de un Semaforo.
	 * 
	 * @throws InterruptedException
	 */
	public  void manejador() throws InterruptedException {
		// el proceso que realiza un Semaforo se realiza siempre
		while (true) {
			switch (state) {
			case Semaforo.ROJO:
				System.out.println(this.getName() + ":Rojo");
				controlador.notificar();
				synchronized (this) {
					if (!activo) {
						wait();
						activo = true;
					}
				}
				this.state = Semaforo.AMARILLO;
				Thread.sleep(1000l);
				break;
			case Semaforo.AMARILLO:				
					System.out.println(this.getName() + ": Amarillo");
					Thread.sleep(1000l);
					this.state = Semaforo.VERDE;				
				break;
			case Semaforo.VERDE:
				
					System.out.println(this.getName() + ": Verde");
					Thread.sleep(6000);
					this.state = Semaforo.ROJO;
					activo = false;

				
				break;
			}
		}

	}
}
