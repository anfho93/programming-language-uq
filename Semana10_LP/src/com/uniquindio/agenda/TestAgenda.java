package com.uniquindio.agenda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestAgenda {

	
	File archivo = new File("Agenda.bin");
	public static void main(String[] args) {
		TestAgenda aux =  new TestAgenda();		
	}
	
	public TestAgenda(){
		Agenda agenda ;
		try {
			Object obj = leerDatos();
			agenda = (Agenda) obj;
		} catch (FileNotFoundException e) {
			agenda =  new Agenda();
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			agenda =  new Agenda();
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No encontro el obj");
			agenda =  new Agenda();
			//e.printStackTrace();
		}
		ArrayList<Usuario> usuarios =  agenda.getUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i));			
		}
		
		agenda.agregarUsuario("andres", "3014714343", "Calle 4A #21-22");
		agenda.agregarUsuario("andres", "3014714343", "Calle 4A #21-22");
		agenda.agregarUsuario("andres", "3014714343", "Calle 4A #21-22");
		
		try {
			escribirDatos(agenda);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void escribirDatos(Object objeto) throws FileNotFoundException, IOException{
		ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo));
		escritor.writeObject(objeto);
		escritor.flush();
		escritor.close();
		
	}
	
	public Object leerDatos() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream lector =  new ObjectInputStream(new FileInputStream(archivo));
		Object aux = lector.readObject();
		lector.close();
         
		return aux;
	}

}
