package co.uniquindio.entidades;

import java.awt.Graphics;

import co.uniquindio.interfaces.Voladora;

public class Bala extends Entidad{

	private int tipo;
	
	public Bala(int x , int y, int tipo) {
		super(x, y);
		this.setTipo(tipo);
	}
	
	
	public void mover(){
		//mueve la bala.
		this.posX -= 1;
		
	}
	
	public void destruir(){
		// destruye la balas
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


	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
