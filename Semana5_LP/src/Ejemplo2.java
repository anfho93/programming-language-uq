import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		
		try {
		
			File archivoTexto =  new File("texto.txt");
			BufferedWriter escritorCaracteres =  new BufferedWriter(new FileWriter(archivoTexto));
			BufferedReader lectorCaracteres =  new BufferedReader(new FileReader(archivoTexto));
			
			escritorCaracteres.write("Hola mundo esta es una prueba");
			escritorCaracteres.close();
			
			String linea =  "";
			do{
				linea = lectorCaracteres.readLine();
				
				System.out.println(linea);
			}while(linea!=null);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
}
