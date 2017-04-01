package co.uniquindio.aritmetica;

import javax.swing.JOptionPane;

public class Main {

	public static int numerador  = 10;
	public static Integer denominador ;//poner valor de null
	public static float division ;
			
	
	public static void main(String[] args){

		try{
			
			denominador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un denominador"));
			division =  numerador / denominador;
				
			
		}catch (NullPointerException e2) {			
			System.out.println("El valor usado para denominador es 1!!!");
			denominador =1;
		}catch(NumberFormatException e1){
			System.out.println("Ingrese solo numeros, se dividira por 1!!");
			denominador =1;
		}catch (ArithmeticException e3) {
			System.out.println("dividió por cero.");
			denominador =  null;
			return;
		}
		finally {
			try{
				System.out.println("entre al finally");
				System.out.println("El resultado es: "+ division);
			}catch(NullPointerException e4){
				System.out.println("No se puede dividir por cero.");
			}
		}
		
	
		
		
		
		
		
		
		
		
		while(true)
		{
			int arreglo [] = {1,2,3,4,5};
			int posicion = 0 ;
			int a = 5;
			try{
				 
				 
				 posicion  = Integer.parseInt(
								JOptionPane.showInputDialog("Ingresa una posicion del arreglo"));
				 a = 4;
				
			}catch(ArrayIndexOutOfBoundsException e1){
				System.out.println("la posicion no es valida");
			}catch (NumberFormatException e2) {
				System.out.println("Ingrese solo numeros");
			}
			finally {
				System.out.println(arreglo[posicion]);
				System.out.println("a="+a);
			}
					
			
			
		}
		
	}

}
