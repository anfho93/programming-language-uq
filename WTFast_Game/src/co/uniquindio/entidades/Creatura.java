package co.uniquindio.entidades;

import java.awt.Graphics;

public abstract class Creatura extends Entidad {

	
	protected double vida ;
	public Creatura(int x, int y, double vida) {
		super(x, y);
		this.vida = vida;
	}
	
	

	
}
