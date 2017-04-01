package co.uniquindio.entidades;

import java.awt.Graphics;

import co.uniquindio.wtfast.Juego;

public class Bola extends Entidad {
	private Juego j;
	public Bola(Juego j, int x, int y) {
		super(x, y);
		this.j =j ;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizar() {
		//detectan el teclado
		if(j.getManejadorTeclado().arriba){
			this.posY --;
		}
	}

	@Override
	public void dibujar(Graphics g) {
		g.fillOval(this.posX, this.posY, 30, 30);
	}

}
