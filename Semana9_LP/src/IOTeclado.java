import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOTeclado extends BufferedReader {

	private String lineaBuffer;

	public static void main(String[] args) throws IOException {
		IOTeclado aux = new IOTeclado();
		System.out.print(aux.leerInt());
		System.out.print(aux.leerString());
		//System.out.println(aux.leerLinea());
		System.out.println(aux.lineaBuffer);
		
	}

	public IOTeclado() {
		super(new InputStreamReader(System.in));
		lineaBuffer = "";
	}

	public String leerString() throws IOException {
		//Cadena donde almacenaremos los valores de la palabra
		String cadena = "";
		//Si no hay nada en le buffer
		if (lineaBuffer.equals("")) {
			//agrego contenido de la linea actual de la consola.
			lineaBuffer =  this.readLine();			
		}
		//contador para cada char de la palabra
		int cont = 0;
		// obtengo el primer caracter
		char car =  lineaBuffer.charAt(cont);
		//mientras no encuentre un caracter que indica que se acabo la palabra
		while(car != ' ' && car != '\0' && car != '\n' && car != '\t' && car != '\r' && cont<lineaBuffer.length()){
			//concatenamos
			cadena+=car;
			cont++;
			car =  lineaBuffer.charAt(cont);	
		}
		//limpiamos la palabra del buffer cortandola
		lineaBuffer =  lineaBuffer.substring(cont);
		//retornamos la palabra
		return cadena;
	}

	public String leerLinea() {
		String cadena = "";
		try {
			// verifico si exite una cadena en el buffer
			if (lineaBuffer.equals(""))
				// Creo un nuevo string con lo leido del teclado
				cadena = new String(this.readLine());
			else {
				// Entra al else si existe texto en el buffer
				String aux = lineaBuffer;
				// limpio el buffer y retorno el valor anterior
				lineaBuffer = "";
				return aux;
			}
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
		return cadena;
	}

	public int leerInt() {
		//usamos un string donde almacenaremos el numer
		String num = "";
		int  i = 0;
		try {
			//si el buffer esta vacio leermos la consola
			if (lineaBuffer.equals("")) {
				lineaBuffer = this.readLine();
			}
			//leemos cada caracter existente en el buffer
			for ( i = 0; i < lineaBuffer.length(); i++) {
				// hasta encontrar uno  de los siguientes caracteries
				if (lineaBuffer.charAt(i) == '\0' || lineaBuffer.charAt(i) == ' ' || lineaBuffer.charAt(i) == '\n') {
					// si encuentro alguno de los caracteres  y no hay numero sigue normal
					if (num.equals("")) {
						continue;
					} else {
						// si no se sale.
						break;
					}
				} else {
					//lee un "numero" y lo concatena
					num += lineaBuffer.charAt(i);
				}
			}
			lineaBuffer = lineaBuffer.substring(i);
			return Integer.valueOf(num).intValue();
		} catch (NumberFormatException e1) {
			// agregamos esta excepcion si lo que se lee no es un numero
			System.out.println("Error en el formato del numero, intentelo de nuevo.");
		} catch (IOException e) {
			//Esta excepcion se usa en caso de que no se pueda leer del teclado
			System.out.println("Error de E/S");
		}
		return 0;
		
		
	}

}
 