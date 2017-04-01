package co.uniquindio.estados;

import java.awt.Graphics;

import co.uniquindio.wtfast.Juego;

/**
 * 
 * @author andres
 *
 */
public abstract class Estado {
	
	
	protected Juego juego;
	
	public Estado(Juego j){
		this.juego = j;
	}
	public abstract void actualizar();
	
	public abstract void dibujar(Graphics g);
	
}
