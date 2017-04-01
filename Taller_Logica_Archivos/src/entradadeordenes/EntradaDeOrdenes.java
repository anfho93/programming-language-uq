package entradadeordenes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alejandra
 */
public class EntradaDeOrdenes {

    private static ArrayList<Integer> array = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        try{
        
        }
        catch(RuntimeException r){
            System.out.println("Error");
        }
        finally{
            String ruta = "src/entradadeordenes/archivo.txt";
           desdeArchivo(ruta);
           desdeConsola();
        imprimirArreglo(); 
        }
        }
        

    public static void desdeArchivo(String ruta) throws IOException, FileNotFoundException {
        FileReader fileReader = new FileReader(new File(ruta));
        BufferedReader br = new BufferedReader(fileReader);
        String linea = "";
        while ((linea = br.readLine()) != null) {
            String[] comando = linea.split(" ");
            switch (comando[0]) {
                case "add":
                    array.add(Integer.parseInt(comando[1]));
                    break;
                case "remove":
                    array.remove(Integer.parseInt(comando[1]));
                    break;
                case "inicio":
                    int temp = array.get(Integer.parseInt(comando[1]));
                    array.remove(Integer.parseInt(comando[1]));
                    array.add(0, temp);
                    break;
                case "final":
                    int aux = array.get(Integer.parseInt(comando[1]));
                    array.remove(Integer.parseInt(comando[1]));
                    array.add(array.size(), aux);
                    break;
            }
            imprimirArreglo();
        }
        br.close();
        fileReader.close();
    }

    public static void desdeConsola()  {
        Scanner s = new Scanner(System.in);
        String linea = s.nextLine();
        while (!linea.equals("salir")) {
            String[] comando = linea.split(" ");
            switch (comando[0]) {
                case "add":
                    array.add(Integer.parseInt(comando[1]));
                    break;
                case "remove":
                    array.remove(Integer.parseInt(comando[1]));
                    break;
                case "inicio":
                    int temp = array.get(Integer.parseInt(comando[1]));
                    array.remove(Integer.parseInt(comando[1]));
                    array.add(0, temp);
                    break;
                case "final":
                    int aux = array.get(Integer.parseInt(comando[1]));
                    array.remove(Integer.parseInt(comando[1]));
                    array.add(array.size(), aux);
                    break;
            }
            linea = s.nextLine();
        }
    }

    public static void imprimirArreglo() {
        for (int i = 0; i < array.size(); i++) {
            System.out.print (array.get(i));
        }
        System.out.println();
    }

}
