package co.uniquindio.pajarera;

import co.uniquindio.pajarera.aves.Avestruz;
import co.uniquindio.pajarera.aves.Buho;
import co.uniquindio.pajarera.aves.Gallina;
import co.uniquindio.pajarera.aves.Loro;

public class Pajarera {
	
	private Ave[] aves;
	
	public Pajarera() {
		aves = new Ave[5];
		aves[0] = new Gallina("blanco", "bichos");
		aves[1] = new Avestruz("blanco", "bichos");
		aves[2] = new Buho("blanco", "bichos");
		aves[3] = new Loro("blanco", "bichos");
		aves[4] = new Gallina("blanco", "bichos");
	}

	public void getInformacionAves() {
		for (int i = 0; i < aves.length; i++) {
			System.out.println(aves[i].toString());
		}
	}
	
}


