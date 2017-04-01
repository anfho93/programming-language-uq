package co.uniquindio.entidades;

import java.awt.Graphics;
import java.util.Observable;

import co.uniquindio.graphics2D.interfaz.CanvasPanel;
import co.uniquindio.graphics2D.interfaz.SpriteSheet;

public class GameEntity extends Observable {

	
	private int x;
	private int y;
	private SpriteSheet ss;
	
	public GameEntity(int x, int y, SpriteSheet ss) {
		super();
		this.x = x;
		this.y = y;
		this.ss = ss;
	}

	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(ss.crop(0, 0, 32, 32), 32*CanvasPanel.SCALE, 32*CanvasPanel.SCALE, null);
	}
}
