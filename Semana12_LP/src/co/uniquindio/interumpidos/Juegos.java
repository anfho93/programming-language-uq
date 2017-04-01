package co.uniquindio.interumpidos;

public class Juegos {

	int juegos = 1;
	int puntos = 4;

	public static void main(String[] args) {
		Juegos j = new Juegos();
		j.seleccion(0, 0, new int[3],0);
	}


	public void seleccion(int puntaje, int cont, int[] pos, int indice) {
		if (cont == juegos && puntaje == puntos) {
			for (int i = 0; i < pos.length; i++) {
				System.out.print(pos[i] + " ");
			}
			System.out.println();
			return ;
		}  else if (cont == juegos && puntaje != puntos) {
			
			return ;
		}
		
		for (int i = indice; i < 3; i++) {
			pos[i]++;
			if (i == 0 )
				 seleccion(puntaje + 3, cont + 1, pos, 0);				
			else if (i == 1 )
				 seleccion(puntaje + 1, cont + 1, pos,1);
			else seleccion(puntaje , cont+1 , pos, 2);
			pos[i]--;			
		}

	}
}
