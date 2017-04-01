package co.uniquindio.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	/**
	 * Marco de la ventana que contendra el juego
	 */
	private JFrame ventana;
	private String titulo;// titulo de la pantalla
	private int width, height;// en pixeles
	private Canvas miCanvas;// permite ver graficos como un tablero
	
	

	public Display( String titulo, int width, int heigth) {
		super();
		this.titulo = titulo;
		this.width = width;
		this.height = heigth;
		createDisplay();//inicializa los componentes de la ventana
	}
	
	/**
	 * Crea la ventana principal
	 */
	private void createDisplay(){
		ventana = new JFrame(titulo);
		ventana.setSize(width, height);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		miCanvas = new Canvas();
		miCanvas.setPreferredSize(new Dimension(width, height));
		miCanvas.setMaximumSize(new Dimension(width, height));
		miCanvas.setMinimumSize(new Dimension(width, height));
		miCanvas.setFocusable(false);
		ventana.add(miCanvas);
		
		ventana.pack();// hace que la ventana encaje en los componentes internos
	}
	

	/**
	 * @return the ventana
	 */
	public JFrame getVentana() {
		return ventana;
	}

	/**
	 * @param ventana the ventana to set
	 */
	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}

	/**
	 * @return the miCanvas
	 */
	public Canvas getMiCanvas() {
		return miCanvas;
	}

	/**
	 * @param miCanvas the miCanvas to set
	 */
	public void setMiCanvas(Canvas miCanvas) {
		this.miCanvas = miCanvas;
	}
	
	
	
}
