/**
 * 
 */
package co.uniquindio.entidades;

import co.uniquindio.interfaces.Voladora;

/**
 * @author andres
 *
 */
public abstract class Nave extends Creatura implements Voladora {

	
	protected int velocidad;//pixeles por segundo
	
	
	/**
	 * 	
	 * @param posX
	 * @param posY
	 * @param vida
	 * @param velocidad
	 */
	public Nave(int posX, int posY, int vida, int velocidad) {
		super(posX, posY, (double)vida);
		
		this.velocidad = velocidad;
	}
	
		
	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**
	 * @return the velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * @param velocidad the velocidad to set
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	
	
	
}
