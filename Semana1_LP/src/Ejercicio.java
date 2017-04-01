
public class Ejercicio {
	
	public static void main(String[] args) {
		
		int[] numeros = {1,3,3,4,4,4,5};
		int numero = -1;
		int cantidad = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			int comparar = numeros[i];
			int nVeces = 0;
			for (int j = 0; j < numeros.length; j++) {
				if(numeros[j]==comparar)
				{
					nVeces++;
				}
			}
			
			if(nVeces>cantidad)
			{
				cantidad = nVeces;
				numero = numeros[i];
			}
		}
		System.out.println(numero);
	}
}
