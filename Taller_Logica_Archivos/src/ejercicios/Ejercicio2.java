/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ALEJO
 */
public class Ejercicio2 extends BufferedReader {

    String buffer;

    public Ejercicio2() {
        super(new InputStreamReader(System.in));
        buffer = "";
    }

    public void manejoComandos() throws IOException, FileNotFoundException, ExcepcionPersonalizada {
        BufferedReader lector = new BufferedReader(new FileReader(new File("archivo2.txt")));
        ArrayList<String> numeros = new ArrayList<String>();

        String temp = lector.readLine();
        String[] num = temp.split(" ");

        for (int i = 0; i < num.length; i++) {
            numeros.add(num[i]);
        }
        System.out.print(numeros + "\n");

        if (buffer.equals("")) {
            buffer = this.readLine();
        }
        String[] comandos = buffer.split(" ");



        if (comandos[0].equals("add") && isNumeric(comandos[1])) {

            numeros.add(comandos[1]);
            System.out.print(numeros + "\n");

        
        }

        else if (comandos[0].equals("remove") && isNumeric(comandos[1])) {

            numeros.remove(comandos[1]);
            System.out.print(numeros + "\n");

        
        }
        
        else if (comandos[0].equals("moveFront") && isNumeric(comandos[1])) {

            numeros.add(0,comandos[1]);
            System.out.print(numeros + "\n");

       
        }
        
        else if (comandos[0].equals("moveEnd") && isNumeric(comandos[1])) {

            numeros.add(numeros.size()-1,comandos[1]);
            System.out.print(numeros + "\n");

        } else {
            throw new ExcepcionPersonalizada("Comando no admitido, intente de nuevo");
        }
        




    }

    public static boolean isNumeric(String s) {
        try {
            int y = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException err) {
            return false;
        }
    }
}
