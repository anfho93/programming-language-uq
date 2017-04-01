package com.uniquindio.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {
	
	public final static String  ruta = "persistencia.bin";	
	
	public static void escribirDatos(Object objeto) throws FileNotFoundException, IOException{
		File archivo = new File(ruta);
		ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo));
		escritor.writeObject(objeto);
		escritor.flush();
		escritor.close();		
	}
	
	public static Object leerDatos() throws FileNotFoundException, IOException, ClassNotFoundException{
		File archivo = new File(ruta);
		ObjectInputStream lector =  new ObjectInputStream(new FileInputStream(archivo));
		Object aux = lector.readObject();
		lector.close();
         
		return aux;
	}
}
