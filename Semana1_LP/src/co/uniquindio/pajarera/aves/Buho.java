package co.uniquindio.pajarera.aves;

import co.uniquindio.pajarera.AveVoladora;

public class Buho extends AveVoladora {

	public Buho(String color, String comida) {
		super(color, comida);
		// TODO Auto-generated constructor stub
	}
	public String getCall(){
		return "chuchear";
	}
	@Override
	public String toString() {
		
		return "Buho \n Ruido: "+getCall()+"\n"+super.toString();
	}

}
