package co.uniquindio.parcial1;

public class Cougar extends Felino{
	public Cougar(){
		System.out.println("cougar ");
	}
	
	public static void main(String[] args) {
		new Cougar().go();
	}
	
	void go(){
		type ="c ";
		System.out.println(this.type + super.type);
	}
}

