package co.uniquindio.graficos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animador {

	
	private int velocidad, indice;
	private BufferedImage[] imagen;
	private long ultimaVez, timer;
	
	public Animador(int velocidad, BufferedImage[] imagen) {
		super();
		this.velocidad = velocidad;
		this.imagen = imagen;
		indice = 0;
		timer = 0;
		ultimaVez = System.currentTimeMillis();
	}
	
	public void actualizar(){
		timer += System.currentTimeMillis() - ultimaVez;
		if (timer >=velocidad){
			indice++;
			if(indice>=	imagen.length)
				indice =0;
			timer=0;
		}
		ultimaVez = System.currentTimeMillis();
	}
	
	public BufferedImage darFrameActual(){

		return imagen[indice];
		
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
	/**
	 * @return the imagen
	 */
	public BufferedImage[] getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(BufferedImage[] imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}
}
