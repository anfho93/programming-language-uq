package co.uniquindio.ejemprop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

	
	public static void main(String[] args) {
		Properties propiedades = new Properties();
	    InputStream entrada = null;
	    try {
	        entrada = new FileInputStream("app.properties");
	        // cargamos el archivo de propiedades
	        propiedades.load(entrada);
	        // obtenemos las propiedades y las imprimimos	        	        
	        System.out.println(propiedades.getProperty("ventanaprincipal.color"));
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (entrada != null) {
	            try {
	                entrada.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
