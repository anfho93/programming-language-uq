package co.uniquindio.estados;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import co.uniquindio.entidades.Bola;
import co.uniquindio.entidades.Jugador;
import co.uniquindio.entidades.NaveEnemiga;
import co.uniquindio.graficos.Assets;
import co.uniquindio.wtfast.Juego;

public class EstadoJuego extends Estado{	
	
	int x =0;
	private Bola miBola;
	private Jugador miJugador;
	private int cant = 1;
	private long tiempo = 2000000000l;
	private long tiempoInicial ;
	private long tiempoactual;
	private ArrayList<NaveEnemiga> naves;
	
	public  EstadoJuego(Juego j) {
		super(j);
		//inicializacion de variables
		tiempoInicial  = System.nanoTime();
		miJugador = new Jugador(j, 0, 0, 100, 4);
		naves = new ArrayList<>();
		miBola = new  Bola(j, 20, 20);
	}
	
	@Override
	public void actualizar() {
		 	  	
		//calcula el tiempo 
		tiempoactual = System.nanoTime();
		if(tiempoactual-tiempoInicial>=tiempo)
		{
			lanzarEnemigos();
			tiempoInicial = tiempoactual;
		}
		miJugador.actualizar();
		for (int i = 0; i < naves.size(); i++) {		
				naves.get(i).actualizar();			
		}
		miBola.actualizar();
		
		
	}

	private void lanzarEnemigos() {
		NaveEnemiga n = new NaveEnemiga(360, 0, 100, 1);	
		naves.add(n);		
	}
	
	@Override
	public void dibujar(Graphics g) {
		
		//hacemos que el "pincel" graphics dibuje al jugador
		miJugador.dibujar(g);		
		for (int i = 0; i < naves.size(); i++) {			
			naves.get(i).dibujar(g);
		}	
		miBola.dibujar(g);
	}
	/**
	 * @return the miJugador
	 */
	public Jugador getMiJugador() {
		return miJugador;
	}
	/**
	 * @param miJugador the miJugador to set
	 */
	public void setMiJugador(Jugador miJugador) {
		this.miJugador = miJugador;
	}

	public void dibujarFondo(Graphics g) {
		System.out.println("entro");
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect(0, 0, 1000 , 1000);
	}

}
