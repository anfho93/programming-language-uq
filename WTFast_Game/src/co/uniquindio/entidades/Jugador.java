package co.uniquindio.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import co.uniquindio.graficos.Animador;
import co.uniquindio.graficos.Assets;
import co.uniquindio.wtfast.Juego;

public class Jugador extends Nave {

	private BufferedImage imagen;
	private Animador animacion;
	private Juego juego;
	
	public Jugador(Juego j, int posX, int posY, int vida, int velocidad) {
		super(posX, posY, vida, velocidad);// el jugador no tiene difuicultad
		imagen = Assets.jugador;
		animacion = new Animador(500, Assets.jugador_estatico);
		this.juego = j;
	}
	
	

	@Override
	public void volar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub

	}


	@Override
	public void actualizar() {
		animacion.actualizar();
		// TODO Auto-generated method stub
		if(juego.getManejadorTeclado().arriba){
			posY-=velocidad;
			
		}
		if(juego.getManejadorTeclado().izq){
			posX-=velocidad;
		}
		if(juego.getManejadorTeclado().abajo){
			posY+=velocidad;
		}
		if(juego.getManejadorTeclado().derecha){
			posX+=velocidad;
		}
	}



	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(animacion.darFrameActual(), this.posX, this.posY, null);
		
	}

}
