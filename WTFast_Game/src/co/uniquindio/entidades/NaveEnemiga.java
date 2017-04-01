/**
 * 
 */
package co.uniquindio.entidades;

import java.awt.Graphics;

import co.uniquindio.graficos.Assets;

/**
 * @author andres
 *
 */
public class NaveEnemiga extends Nave {

	
	private int dificultad;
	private boolean naveViva;
	public boolean espera;
	/**
	 * @param posX
	 * @param posY
	 * @param vida
	 * @param velocidad
	 */
	public NaveEnemiga(int posX, int posY, int vida, int dificultad) {
		super(posX, posY, vida, dificultad);
		this.dificultad = dificultad;
		naveViva = true;
	}

	
	/**
	 * Hace que la nave vuele 
	 */
	@Override
	public void volar() {
		// TODO Auto-generated method stub
		switch (dificultad) {
		case 1:
			//algoritmo rectilineo
			volarRecto();
			break;

		default:
			break;
		}
	}

	private void volarRecto() {
		this.posX = this.posX-(dificultad);		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actualizar() {
		volar();
	}


	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.enemigo, this.getPosX(), this.getPosY(), null);
	}

}
