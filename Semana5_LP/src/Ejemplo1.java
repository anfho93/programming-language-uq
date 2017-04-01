import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//pruebaFileInput();
			pruebaImagen();
		} catch (FileNotFoundException e) {
			System.out.println("Error al encontrar la imagen");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void pruebaFileInput() throws IOException{
		
			File archivoBin =  new File("binfile");
					
			FileOutputStream escritor = new FileOutputStream(archivoBin);						
			FileInputStream lector =  new FileInputStream(archivoBin);
			
			String nombre = "Andres Herrera\n";
			byte[] b = nombre.getBytes();
			
			escritor.write(b);
			escritor.write(b);
			escritor.write(b);
			char a  = 255; 
			
			//a pesar que retorna un entero cuyo valor es 2 a las 32
			// este metodo lee solo bytes, y solo retorna -1 cuando 
			// ya no hay mas bytes para leer
			int valor=lector.read();
			
            while(valor!=-1){
                System.out.print((char)valor);
                valor=lector.read();
            }
			
		
	}
	
	
	public static void pruebaImagen() throws IOException{
		
			File imagen =  new File("src/indice2.png");
			
			FileInputStream lector =  new FileInputStream(imagen);
			File imagen2 =  new File("src/indice2-copia.png");
			FileOutputStream escritor = new FileOutputStream(imagen2);
			int valor=lector.read();
            while(valor!=-1){
                
            	escritor.write(valor);
                valor=lector.read();
                
            }
            escritor.close();		
	}
	
	
	

}
