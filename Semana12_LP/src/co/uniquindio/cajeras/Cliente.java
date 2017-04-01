package co.uniquindio.cajeras;

public class Cliente {

	private String nombre;
	private int[] carroCompra;
	
	public Cliente(String nombre, int[] carroCompra) {
		super();
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}
	/**
	 * @return the carroCompra
	 */
	public int[] getCarroCompra() {
		return carroCompra;
	}
	/**
	 * @param carroCompra the carroCompra to set
	 */
	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	// Constructor, getter y setter

}