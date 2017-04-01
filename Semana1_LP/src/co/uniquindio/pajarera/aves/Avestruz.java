package co.uniquindio.pajarera.aves;

import co.uniquindio.pajarera.AveTerrestre;

public class Avestruz extends AveTerrestre {

	public Avestruz(String color, String comida) {
		super(color, comida);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {		
		return "Buho \n Ruido: "+getCall()+"\n"+super.toString();
	}
	
	public String getCall(){
		return "chuchear";
	}
}
