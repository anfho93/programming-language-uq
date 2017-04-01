/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Home
 */
public class comandos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
     
         ArrayList<Integer> num=new ArrayList<Integer>(); //arrayList que recibe información de archivo
         String comparar; //String para agregar a array[] para los if de comandos
          InputStreamReader sr=new InputStreamReader(System.in); //se indica que la información se recibira por consola
        BufferedReader br=new BufferedReader(sr); //lector que leera lo que se recibe por consola
        try{ 
        Scanner lector=new Scanner(new File("C:\\prueba.txt")); //ruta de archivo a leer
        for(int i=0;i<20;i++){
            num.add(lector.nextInt()); //se llena el arrayList con los numeros del archivo
          
        }
        int guardar=0;
        while(guardar!=-1){ //cuando se valide que el comando no existe el usuario podra continuar ingresando comandos

         comparar=br.readLine(); //se lee la información digitada por consola
      String[] array=comparar.split(" "); //se separa la información ingresada por consola para validar con los if
      
      if(array[0].equals("add")){ //si se digita add se agregara
          
          System.out.println("entro a agregar");
           guardar=Integer.parseInt(array[1]); //se guarda en una temporal el  numero a ingresar en ultima posición
          num.add(guardar); //se agrega el numero indicado por consola
          System.out.println("ArrayList actual");
          System.out.println(num); //se imprime array de numeros
          
      
      }
  
      else if(array[0].equals("remove")){ //si se digita remove por consola
          System.out.println("entro a remover");
          int remover=Integer.parseInt(array[1]); //se guarda en temporal la posición a eliminar
          num.remove(remover-1); //se resta 1 puesto que para el usuario el array empieza en 1 no en cero 
          System.out.println("ArrayList actual"); 
          System.out.println(num); //se imprime array actual
       
      }
      
      else if(array[0].equals("MoveFront")){ //si se digita MoveFront se movera al inicio
          System.out.println("entro a MoverInicio");
          int moverIni=(Integer.parseInt(array[1])-1); //se guarda en temporal la posición indicada por consola
          int numTemp=num.get(moverIni); //se guarda la posición del temporal en un segundo temporal para mejor manejo
                           
          num.add(0,num.get(moverIni)); //se agrega en posición cero el nunero en posición moverIni
          num.remove(moverIni+1); //se remueve el numero en posición moverIni+1 puesto que las posiciones se moveran en el array
          System.out.println(num); //se imprime array actual
      }
     else if(array[0].equals("MoveEnd")){// si el usuario digita MoveEnd se mueve al final
          System.out.println("entro a MoverFinal"); 
          int moverFin=(Integer.parseInt(array[1])-1);  //se agrega en temporal la posición indicada por consola
          int numTemp=num.get(moverFin); //se guarda en un segundo temporal para menjor manejo
          int tamaño=num.size(); //se obtiene tamaño del array para guardar en ultima posición
          num.add(tamaño,numTemp); //se agrega en la ultima posición el numero en la posición indicada por consola
          num.remove(moverFin); //se remueve en la posición indicada por usuario
       System.out.println("ArrayList actual");
          System.out.println(num); //se imprime array actual
      }
    else{
         System.out.println("El comando enviado no existe, continue ejecutando comandos"); //se valida que el comando existe
         
         }
         
     
     }}catch(FileNotFoundException ex){
     
       throw new FileNotFoundException("La entrada de datos ha sido incorrecta"); // excepción para cuando la ruta del archivo sea incorrecta
       //o para cuando el archivo no existe
   
     }
 
        
    }
    }



