package co.uniquindio.parcial1;

public class Camello implements Montable{

	int peso=2;
	
	public static void main(String[] args){
		new Camello().go(8);
	}

	void go(int velocidad){
		int tazacaminata  =  ++velocidad * peso++;
		System.out.print(tazacaminata +  getPaso());
	}
	
	@Override
	public String getPaso() {
		// TODO Auto-generated method stub
		return " mph, lope";
	}

}
