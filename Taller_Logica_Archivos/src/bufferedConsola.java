

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.omg.Messaging.SyncScopeHelper;

public class bufferedConsola {

		
	//@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		
		ArrayList<String> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String texto="";
		String caracter ="";
		
		try{
		 do {
				int Instruccion = Integer.parseInt(JOptionPane.showInputDialog(" 1. agregar \n 2. Eliminar \n 3. Mover al inicio \n 4. Mover al final"));
			 
				System.out.println("Ingrese el caracter: ");			 
			 switch (Instruccion)
			 {
		
			 
			case 1:
				 texto = br.readLine();
				 
				 list.add(texto);
				 System.out.println(" Se ha agregado un elemento a la lista ");
				break;

			case 2:
				
				if (list.contains(texto))
				{
					list.remove(texto);
					System.out.println(" se elimino un elemento");
					
				} else{ 
					System.out.println("No se encontr� el elemento");
				}
				
				
				break;
				
			case 3:
				 if (list.contains(texto))
				  list.add(0, texto);
				 System.out.println(" Se movio el elemento al inicio de la lista ");
				break;
				
			case 4:
				if (list.contains(texto))
					list.indexOf(texto);
					System.out.println("Se movio el elemento al final de la lista");
					break;
			default:
				System.out.println("No se ha seleccionado un elemento");

			}
				 
				 
				 
			 		 }while (!texto.equals("0"));
		
		}catch (Exception e){
			System.out.println("Se presento un error");
		}
	}
}