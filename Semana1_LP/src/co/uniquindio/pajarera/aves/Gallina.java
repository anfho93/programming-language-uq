package co.uniquindio.pajarera.aves;

import co.uniquindio.pajarera.AveTerrestre;

public class Gallina extends AveTerrestre {

	public Gallina(String color, String comida) {
		super(color, comida);		
	}
	
	public String getCall(){
		return "Cacareo";
	}
	
	@Override
	public String toString() {		
		return "Gallina \n Ruido: "+getCall()+"\n"+super.toString();
	}

}
