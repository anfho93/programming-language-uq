package co.uniquindio.entidades;

import java.util.Observable;

import co.uniquindio.graphics2D.interfaz.CanvasPanel;
import co.uniquindio.graphics2D.interfaz.SpriteSheet;

public class Enemy extends GameEntity implements Runnable{

	private int x;// los enemigos inician al final de la pantalla
	private int y ;
	private int r;
	private int algoritmo;
	private boolean alive;

	public Enemy(int i, int j, int k, SpriteSheet ss ) {
		super(j, k, ss);
		this.x = i;
		this.y = j;
		this.r  = k;
		alive = true;
		
	}

	@Override
	public void run() {
		
		while(alive){
			try {
			//ejecuta un algoritmo de movimiento
				this.rectilineo();
				//System.out.println("hola");
				Thread.sleep(20);
			      setChanged();
				this.notifyObservers();
			
				//clearChanged();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void rectilineo(){
		this.x =  x - 1;// se mueve de izquierda a derecha
		if(x <= -r/2)
		{
			alive = false;
		}
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	

}
