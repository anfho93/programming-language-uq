package co.uniquindio.graphics2D.interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import co.uniquindio.entidades.Enemy;
import co.uniquindio.entidades.Player;

public class CanvasPanel extends JPanel implements Observer{

	public final static int ANCHO=500;
	public final static int ALTO=500;
	public final static Color CANVAS_BACKGROUND = Color.GRAY;
	private  Player miBola;
	private Enemy[] automaticas;
	private BufferedImage spriteSheet;
	public final static int SCALE  = 2;
	
	/**
	 * Create the panel.
	 */
	
	public void init(){
		ImageLoader loader = new ImageLoader();
		setSpriteSheet(loader.load("/spritesheet.png"));
		SpriteSheet ss = new  SpriteSheet(spriteSheet);
		miBola = new Player(CanvasPanel.ANCHO/2, CanvasPanel.ALTO/2, 40, ss);
	}
	
	
	public CanvasPanel() {
		init();		
		automaticas =  new Enemy[5];
		for (int i = 0; i < automaticas.length; i++) {
			//automaticas[i] = new Enemy(CanvasPanel.ANCHO-50, (int)(CanvasPanel.ANCHO*((double)((1+i)*10)/100.0)), 5, this);			
		}
		//moverEnemigos();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		setBackground(CANVAS_BACKGROUND);
        g.setColor(Color.red);
        
        miBola.render(g);
        
        //g.fillOval(miBola.getX(), miBola.getY(), miBola.getRadio(), miBola.getRadio()); 
        for (int i = 0; i < automaticas.length; i++) {
			//g.fillOval(automaticas[i].getX(), automaticas[i].getY(), automaticas[i].getR(), automaticas[i].getR());
		}
        
	}
	
	
	public void moverEnemigos(){
		Thread[] Hilos = new Thread[automaticas.length];
		for (int i = 0; i < Hilos.length; i++) {
			Hilos[i]  = new Thread(automaticas[i]);
			Hilos[i].start();
		}		
	}

	
	@Override
	public void update(Observable o, Object arg) {
		//System.out.println(((Enemy)o).getX()); 
		repaint();
	}
	/**
	 * @return the spriteSheet
	 */
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}
	/**
	 * @param spriteSheet the spriteSheet to set
	 */
	public void setSpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}


	/**
	 * @return the miBola
	 */
	public Player getMiBola() {
		return miBola;
	}


	/**
	 * @param miBola the miBola to set
	 */
	public void setMiBola(Player miBola) {
		this.miBola = miBola;
	}

}
