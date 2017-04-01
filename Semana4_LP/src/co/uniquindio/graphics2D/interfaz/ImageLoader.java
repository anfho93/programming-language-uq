package co.uniquindio.graphics2D.interfaz;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader {

	
	public BufferedImage load(String path){
		try {
			 return ImageIO.read(getClass().getResource(path));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
