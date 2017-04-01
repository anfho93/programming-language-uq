package co.uniquindio.wtfast;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import co.uniquindio.display.Display;
import co.uniquindio.estados.Estado;
import co.uniquindio.estados.EstadoJuego;
import co.uniquindio.graficos.Assets;
import co.uniquindio.graficos.ImageLoader;
import co.uniquindio.graficos.SpriteSheet;

public class Juego implements Runnable{

	//objeto para la interfaz grafica
	private Display display;
	//ancho de la interfaz grafica
	private int width;
	//alto de la interfaz grafica
	private int height;
	//titulo de la ventana o interfaz grafica
	private String titulo;
	//variable para validar que el juego se este ejecutando
	private boolean ejecutando = false;
	//hilo principal de ejecución del juego
	private Thread  hiloPrincipal;
	// Buffer de almacenamiento grafico
	private BufferStrategy bs;
	//Pincel para graficar.
	private Graphics g;
	private int x;
	
	//----- INICIO ESTADOS DEL JUEGO
	private Estado estadoJuego;
	//estado del juego menu, juego, configuraciones, etc
	private static Estado estadoActual = null;
	//----- FIN ESTADO DE JUEGO
	
	
	private ManejadorTeclado manejadorTeclado;
	/**
	 * Contructor de la clase
	 * @param titulo del juego
	 * @param w ancho de la interfaz
	 * @param h alto de la interfaz
	 */
	public Juego(String titulo, int w, int h){
		this.height = h ;
		this.width =  w;		
		this.titulo = titulo;
		manejadorTeclado = new  ManejadorTeclado();
	}
	
	
	/**
	 * Inicializa todos los elementos del juego
	 */
	private void inicializar() {
		//inicializara la intefaz para nuestro juego
		display = new  Display(titulo, width, height);
		
		display.getVentana().addKeyListener(manejadorTeclado );
		//Hace que todas las imagenes y recursos sean cargados una unica vez
		Assets.init();		
		//creamos un estado de juego
		estadoJuego = new EstadoJuego(this);
		//modificamos el estado actual
		Juego.setEstadoActual(estadoJuego);
	}
	
	public synchronized void start(){		
		if(ejecutando) return;
		ejecutando = true;
		hiloPrincipal = new Thread(this);
		hiloPrincipal.start();
	}
	
	public synchronized void stop(){		
		if(!ejecutando)
			return ;
		ejecutando = false;
		try {
			hiloPrincipal.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		//llamamos el metodo de inicializar
		inicializar();
		//vamos a limitar la cantidad de veces que se van a llamar por segundo.
		//variables necesarias para la correcta ejecución
		int fps = 60;
		double vecesporActualizacion = 1000000000/fps;//maximo tiempo permitido para  acutalizar y dibujar y conseguir los fps
		double delta = 0 ;//tiempo que nos falta para llamar el metodo.
		double vecesporActualizacion2 =1000000000/70;
		long ahora ;
		long ultimo = System.nanoTime();
		//cuenta hasta que llegamos a 1 segundo
		long timer = 0;
		//cantidad de veces que dibujamos y actualizamos
		int tick = 0;
		double delta2=0;
		while(ejecutando){
			//-------------FPS---------------------------
			//Manejo del tiempo para ejecucion correcta por Segundo
			ahora = System.nanoTime();			
			delta += (ahora - ultimo)/vecesporActualizacion;
			delta2 += (ahora - ultimo)/(vecesporActualizacion2);
			timer += ahora - ultimo;
			ultimo = ahora;
			//-------------FPS---------------------------			
			if(delta >= 1){
				actualizar();
				//acutaliza variables y demas
				dibujar();// de nuevo dibuja todos los personajes
				delta--;
				tick++;
			}
			if(delta2>=1){

				if(g!=null)
				{
					((EstadoJuego)estadoActual).dibujarFondo(g);
					dibujar();
				delta2--;
				}
			}
			
			// representacion visual de los FPS una vez por segundo
			if(timer>=1000000000){
				//System.out.println("Tiks" + tick);
				tick = 0;
				timer = 0;
			}
		}
		//detenemos el juego cuando se acabe su ejecución
		stop();
	}
	
	
	
	private void actualizar(){
		manejadorTeclado.actualizar();
		if(Juego.getEstadoActual()!=null)
			Juego.getEstadoActual().actualizar();
	}
	
	private void dibujar(){
		// es una manera en que el pc dibuja cosas, y utiliza un buffer para eso
		// es un espacio donde se guardan datos para mostrar y se procesan antes de poderlos visualizar
		bs = display.getMiCanvas().getBufferStrategy();
		if(bs == null){
			display.getMiCanvas().createBufferStrategy(3);
			return ;			
		}		
		//encargado de pintar como un pincel para el JAVA.
		g = bs.getDrawGraphics();
		//limpiamos el tablero o pantalla
		
		g.clearRect(0, 0, width, height);
		g.setColor(Color.cyan);
		g.fillRect(0, 0, width, height);
		//empieza a dibujar		
		if(Juego.getEstadoActual()!=null)
			Juego.getEstadoActual().dibujar(g);
		//finaliza las dibujadas		
		bs.show();
		g.dispose();
	}

	/**
	 * @return the estadoActual
	 */
	public static Estado getEstadoActual() {
		return estadoActual;
	}
	/**
	 * @param estadoActual the estadoActual to set
	 */
	public static void setEstadoActual(Estado estado) {
		estadoActual = estado;
	}


	/**
	 * @return the manejadorTeclado
	 */
	public ManejadorTeclado getManejadorTeclado() {
		return manejadorTeclado;
	}


	/**
	 * @param manejadorTeclado the manejadorTeclado to set
	 */
	public void setManejadorTeclado(ManejadorTeclado manejadorTeclado) {
		this.manejadorTeclado = manejadorTeclado;
	}
	
	
	
	
	
	
}
