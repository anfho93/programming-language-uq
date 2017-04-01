package co.uniquindio.entidades;

import co.uniquindio.graphics2D.interfaz.SpriteSheet;

public class Player extends GameEntity{
	private int x;
	private int y;
	private int radio;
	
	
	public Player(int x, int y, int radio, SpriteSheet ss) {
		super(x, y , ss);
		this.x = x;
		this.y = y;
		this.radio = radio;
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
	 * @return the radio
	 */
	public int getRadio() {
		return radio;
	}
	/**
	 * @param radio the radio to set
	 */
	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	
}
