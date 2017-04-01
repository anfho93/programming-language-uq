package co.uniquindio.graphics2D.interfaz;
interface Montable {
	String getPaso();
}

public class Camello implements Montable {
	int peso = 2;
	public static void main(String[] args) {
		new Camello().go(8);
	}
void go(int velocidad) {
	++velocidad;
	peso++;
	int tazacaminata = velocidad * peso;
	System.out.print( tazacaminata + getPaso());
}
public String getPaso() {
	return " mph, lope";
}
}