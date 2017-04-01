package co.uniquindio.banco.excepciones;

@SuppressWarnings("serial")
public class FondosInsuficientesException extends Exception {

	private double cantidad;
	/**
	 * Cantidad necesaria para poder efectuaar el retiro
	 * @param cantidad
	 */
	public FondosInsuficientesException(double cantidad)
	{
		this.cantidad = cantidad;
	}	
	
	public FondosInsuficientesException(String mensaje){
		super(mensaje);
	}	
	
	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
}
