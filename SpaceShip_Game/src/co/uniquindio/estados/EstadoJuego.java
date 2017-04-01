package co.uniquindio.estados;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


import co.uniquindio.graficos.Assets;
import co.uniquindio.wtfast.Juego;

public class EstadoJuego extends Estado{	
	
	int x =0;
	private int cant = 1;
	private long tiempo = 2000000000l;
	private long tiempoInicial ;
	private long tiempoactual;
	
	
	public  EstadoJuego(Juego j) {
		super(j);
		//inicializacion de variables
		tiempoInicial  = System.nanoTime();
		
	}
	
	@Override
	public void actualizar() {
		
	}

	
	
	@Override
	public void dibujar(Graphics g) {
		dibujarFondo(g);		
		dibujarTriangulos(g, 0, 0, 0, 0);
	}
	
	
	public void dibujarTriangulos(Graphics g, int x1, int x2, int y1, int y2){
		
		int xPunta1 =  (x2 - x1)/2;
		int yPunta1 =  0;
		int xPunta2 = 0;
		int yPunta2 = y2;
		int xPunta3 = x2;
		int yPunta3 = y2;
		g.setColor(Color.black);
		g.drawOval(20, 20, 20, 20);
		
		
	}

	public void dibujarFondo(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000 , 1000);
	}

}
