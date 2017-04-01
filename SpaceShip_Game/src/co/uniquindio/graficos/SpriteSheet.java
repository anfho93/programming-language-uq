package co.uniquindio.graficos;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	/**
	 * SpriteImagen que contiene las imagenes pequeñas
	 */
	private BufferedImage imagen;
	/**
	 * Constructor de la clase.
	 * @param imagen 
	 */
	public SpriteSheet(BufferedImage imagen) {
		this.imagen = imagen;
	}
	/**
	 * Permite cortar una imagen segun parametros indicados,
	 * Se supone que la imagen es una cuadricula con imagenes
	 * mas pequeñas
	 * @param col columna donde se encuentra la imagen en pixeles
	 * @param row fila donde se encuentra la imagen en pixeles
	 * @param w, ancho de la imagen a cortar en pixeles
	 * @param h, alto de la imagen a cortar en pixeles
	 * @return Imagen recortada.
	 */
	public BufferedImage crop (int col, int row,int w, int h){
		return imagen.getSubimage(col*32, row*32, w, h);
	}

}
