package co.uniquindio.rocas;

import java.util.Scanner;

public class MainRocas {

	public static void main(String[] args) {
		String nombreRoca =  "Marmol";
		try {
			System.out.println("Ingrese roca");
			Scanner lector = new Scanner(System.in);
			nombreRoca = lector.nextLine();
			Roca aclass = (Roca)
				    Class.forName("co.uniquindio.rocas."+nombreRoca).newInstance();
			System.out.println(aclass.getClasificacion());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			System.out.println("La roca no existe");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("La roca no existe");
		}
	}

}
