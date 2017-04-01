package co.uniquindio.ejemprop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class EscribrirPropiedades {

	
	public static void main(String[] args) {

	    Properties propiedades = new Properties();
	    OutputStream salida = null;

	    try {
	        salida = new FileOutputStream("app.properties");

	        // asignamos los valores a las propiedades
	        propiedades.setProperty("ventanaprincipal.color", "red");
	        propiedades.setProperty("ventanaprincipa.name", "Mi ventana");
	        // guardamos el archivo de propiedades en la carpeta de aplicación
	        propiedades.store(salida, null);

	    } catch (IOException io) {
	        io.printStackTrace();
	    } finally {
	        if (salida != null) {
	            try {
	                salida.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	    }
	}
}
