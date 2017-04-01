package co.uniquindio.geometria;

public class Prueba {

	public static void main(String[] args) {

		Circulo miCirculo = new Circulo(2.0);
		System.out.println("Area del circulo"+ miCirculo.getArea());
		Cilindro miCilindro = new Cilindro(2.0, 5.0);
		System.out.println("Area del cilindro: "+miCilindro.getArea());
		System.out.println("Volumen del cilindro " + miCilindro.getVolumen());
		System.out.println("Altura del cilindro " + miCilindro.getAltura());
		

	}

}
