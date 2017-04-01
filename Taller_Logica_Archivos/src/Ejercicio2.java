
//import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentina S
 */
public class Ejercicio2 {

	ArrayList<Integer> contenido;

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		Ejercicio2 ejercicio = new Ejercicio2();
		Integer opcion, num;
		num = 0;
		ejercicio.contenido = new ArrayList();
		try {
			do {
				String comando;
				System.out.println(
						"Por favor introduzca la opcion deseada:\n1 Eliminar \n2 guardar \n3 mover al inicio \n4 mover al final \n5 salir\n6 imprimir arreglo");
				comando = lector.nextLine();

				String[] Lista = comando.split(" ");
				opcion = Integer.parseInt(Lista[0]);
				if (opcion != 5 && opcion != 6) {
					num = Integer.parseInt(Lista[1]);
					System.out.println(num);
				}
				int indiceNumero = -1;
				switch (opcion) {
				case 1:
					try {
						// Eliminar
						indiceNumero = ejercicio.buscar(num);
						ejercicio.contenido.remove(indiceNumero);
					} catch (IOException ex) {
						Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
					}
					break;

				case 2: // Guardar osea agregar.
					// try {
					// agregar
					// indiceNumero=ejercicio.buscar(num);
					// System.out.println(num);
					// if(indiceNumero==-1)
					ejercicio.contenido.add(ejercicio.contenido.size(), num);
					// else
					// System.out.println("Número ya está.");
					// }
					// catch (IOException ex)
					// {
					// 2
					// Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE,
					// null, ex);
					// }
					break;
				case 3: // mover al inicio
					try {

						indiceNumero = ejercicio.buscar(num);
						ejercicio.mover(indiceNumero, "inicio");
					} catch (IOException ex) {
						Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
					}
					break;
				case 4: // mover al final
					try {
						// mover al inicio
						indiceNumero = ejercicio.buscar(num);
						ejercicio.mover(indiceNumero, "final");
					} catch (IOException ex) {
						Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
					}
					break;
				case 5:
					System.out.println("Chao :'(");
					break;
				case 6:
					if (ejercicio.contenido.isEmpty()) {
						System.out.println("No hay nada");
					} else {
						for (Integer contenido1 : ejercicio.contenido) {
							System.out.print(contenido1);
							System.out.print(" ");
						}
						System.out.println("\n");
					}
					break;
				default:
					System.out.println("Opción Equivocada");
					break;
				}
			} while (opcion != 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} // fin main

	int buscar(int numero) throws IOException // retorna el número de la
												// posición.
	{

		try {
			for (int i = 0; i < contenido.size(); i++) {
				if (contenido.get(i) == numero)
					;
				return i;
			}
			return -1;
		} catch (Exception f) {
			System.out.println(f.getMessage() + " error ");
			return -1;
		}

	}// fin función buscar.

	void mover(int indice, String destino) {
		ArrayList<Integer> contenidoTemporal = new ArrayList<Integer>(contenido.size());
		int numeroMover = contenido.get(indice);
		int iInicia, iFinaliza;
		if (destino.equals("inicio")) {
			iInicia = 1;
			iFinaliza = contenido.size();
			contenidoTemporal.add(0, numeroMover);
		} else {
			iInicia = 0;
			iFinaliza = contenido.size() - 1;
			contenidoTemporal.add(iFinaliza, numeroMover);
		}
		for (int i = iInicia; i < iFinaliza; i++) {
			if (i != indice)
				contenidoTemporal.add(i, contenido.get(i));
		}
		contenido = contenidoTemporal;
	}

}
