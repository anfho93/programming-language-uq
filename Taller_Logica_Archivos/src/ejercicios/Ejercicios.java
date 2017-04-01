/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ALEJO
 */
public class Ejercicios {

    public void SumarMatriz() throws FileNotFoundException, IOException {
        BufferedReader lector = new BufferedReader(new FileReader(new File("archivo.txt")));
        String dimensiones = lector.readLine();
        String[] dim = dimensiones.split(" ");
        int x = Integer.parseInt(dim[0]);
        int y = Integer.parseInt(dim[1]);

        int[][] matrizA = new int[x][y];
        int[][] matrizB = new int[x][y];

        for (int i = 0; i < x; i++) {
            String linea = lector.readLine();
            String[] filaArray = linea.split(" ");
            for (int j = 0; j < y; j++) {
                matrizA[i][j] = Integer.parseInt(filaArray[j]);
            }
        }
        lector.readLine();
        for (int i = 0; i < x; i++) {
            String fila = lector.readLine();
            String[] filaArray = fila.split(" ");
            for (int j = 0; j < y; j++) {
                matrizB[i][j] = Integer.parseInt(filaArray[j]);
            }
        }
        int[][] ultima = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
               ultima [i][j]=matrizA[i][j]+matrizB[i][j]; 
            System.out.print(ultima[i][j]+" ");
            }
            System.out.println("");
        }
      

    }

    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException, FileNotFoundException, ExcepcionPersonalizada {
        //Ejercicios ejercicios= new Ejercicios();
         //ejercicios.SumarMatriz();
        Ejercicio2 ejercicio2 = new Ejercicio2();
        ejercicio2.manejoComandos();
    }

}
