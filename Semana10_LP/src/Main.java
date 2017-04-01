import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;import java.io.OutputStream;
import java.util.ArrayList;

import org.xml.sax.ext.LexicalHandler;

public class Main {

	
	public ArrayList<Integer> numeros;
	private File archivo = new File("persistencia");
	
	
	public static void main(String[] args) {		
		Main main =  new Main();
	}
	
	public Main(){
		try {
			ejemploDeSerializar();
			ejemploSerializar();
			
			for (int i = 0; i < numeros.size(); i++) {
				System.out.println(numeros.get(i));
			}
		} catch (FileNotFoundException e) {
			numeros =  new ArrayList<Integer>();
			e.printStackTrace();
		} catch(IOException i)
	      {
			 numeros =  new ArrayList<Integer>();
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("La clase buscada no fue encontrada");
	         numeros =  new ArrayList<Integer>();
	         return;
	      }
	}
	
	private void ejemploDeSerializar() throws FileNotFoundException, ClassNotFoundException, IOException {
		numeros =  (ArrayList<Integer>)leerDatos();		
	}

	private void ejemploSerializar() throws FileNotFoundException, IOException {
		//numeros =  new ArrayList<Integer>();
		numeros.add(4);
		numeros.add(3);
		escribirDatos(numeros);
	}

	public void escribirDatos(Object objeto) 
			throws FileNotFoundException,IOException{
		ObjectOutputStream escritor = new ObjectOutputStream(
				new FileOutputStream(archivo));
		escritor.writeObject(objeto);
		escritor.flush();
		escritor.close();
		
	}
	
	public Object leerDatos()
			throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream lector =  
				new ObjectInputStream(new FileInputStream(archivo));
		Object aux = lector.readObject();
		lector.close();
         
		return aux;
	}

}
