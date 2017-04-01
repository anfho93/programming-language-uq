package co.uniquindio.pajarera.aves;

import co.uniquindio.pajarera.AveVoladora;

public class Loro extends AveVoladora {

	public Loro(String color, String comida) {
		super(color, comida);		
	}
	
	public String getCall(){
		return "Parloteo";
	}
	
	@Override
	public String toString() {
		
		return "Loro \n Ruido: "+getCall()+"\n"+super.toString();
	}

}
