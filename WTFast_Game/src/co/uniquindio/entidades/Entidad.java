package co.uniquindio.entidades;

import java.awt.Graphics;

public abstract class Entidad {

	
	protected int posX;
	protected int posY;
	
	public Entidad(int x ,int y){
		this.posX = x;
		this.posY = y;
	}
	
	
	public abstract void actualizar();
	
	public abstract void dibujar(Graphics g);
	
	
}
