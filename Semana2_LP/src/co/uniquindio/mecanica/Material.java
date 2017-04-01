/**
 * 
 */
package co.uniquindio.mecanica;

/**
 * @author andres
 *
 */
public class Material {
	
	private String nombre;
	private int tipo;
	private double precio;
	public final static int PINTURA=0;
	public final static int PIEZAS=1;
	
	
	/**
	 * @param nombre
	 * @param tipo
	 * @param precio
	 */
	public Material(String nombre, int tipo, double precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
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
	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	


}
