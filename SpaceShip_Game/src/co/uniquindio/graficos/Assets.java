package co.uniquindio.graficos;

import java.awt.image.BufferedImage;

public class Assets {
	/**
	 * Imagenes estaticas para todo el juego
	 */
	public static BufferedImage jugador, enemigo, fondo;
	public static BufferedImage[] jugador_estatico;
	/**
	 * Tamaño predeterminado de las imagenes en este caso
	 */
	private static final int alto = 32, ancho=32;
	/**
	 * Metodo para inicializar todos los assets del juego
	 */
	public static void init(){
		//aqui se deben cargar todos los assets
		//imagenes, videos, musica, entre otros.
//		SpriteSheet sheet = new  SpriteSheet(ImageLoader.load("/spritesheet.png"));
//		jugador_estatico = new BufferedImage[10];
//		for (int i = 0; i < jugador_estatico.length; i++) {
//			jugador_estatico[i] = sheet.crop(i , 2 , ancho , alto);
//		}		
//		
//		jugador = sheet.crop(0, 0,ancho, alto);
//		enemigo = sheet.crop(0, 0,ancho, alto);
	}

}
