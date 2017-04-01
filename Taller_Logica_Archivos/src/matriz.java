

import java.util.ArrayList;
import java.util.Scanner;




 
public class matriz {

    ArrayList<String> listaDeDatos = new ArrayList<>();

    public void seleccionComandos() {

        try {
            int n = 0;
            boolean salir = true;

            Scanner lectorArchivo = new Scanner(System.in);
            do {
            	System.out.println("ingrese comando : ");

                String comando = lectorArchivo.nextLine();
                String[] aux = comando.split(" ");

                switch (aux[0]) {

                    case "add":

                        listaDeDatos.add(aux[1]);

                        break;

                    case "remove":

                        n = Integer.parseInt(aux[1]);

                        if (n > listaDeDatos.size()) {
                            throw new ArrayIndexOutOfBoundsException("La posici�n no existe en la lista");
                        } else {
                            listaDeDatos.remove(n);
                            System.out.println(n);
                        }

                        break;

                    case "MoveFront":

                        n = Integer.parseInt(aux[1]);

                        if (n > listaDeDatos.size()) {
                            throw new ArrayIndexOutOfBoundsException("La posici�n no existe en la lista");
                        } else {
                            listaDeDatos.add(0, listaDeDatos.get(n));
                            System.out.println(n + 1);
                            System.out.println(n);
                        }
                        break;

                    case "MoveEnd":

                        n = Integer.parseInt(aux[1]);

                        if (n > listaDeDatos.size()) {
                            throw new ArrayIndexOutOfBoundsException("La posici�n no existe en la lista");
                        } else {
                            listaDeDatos.add(listaDeDatos.size(), listaDeDatos.get(n));
                            System.out.println(n);
                            System.out.println(n);
                        }
                        break;

                    default:
                        break;

                }
                System.out.println(listaDeDatos);
            } while (salir != false);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public static void main(String[] args) {
        matriz mimatriz = new matriz();
        mimatriz.seleccionComandos();
    }

}

