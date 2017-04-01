import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOTeclado extends BufferedReader{

	
	private String lineaBuffer;

	public static void main(String[] args) {
		IOTeclado aux =  new IOTeclado();
		
		System.out.println(aux.leerInt());
		System.out.println(aux.leerString());
		System.out.println(aux.lineaBuffer);
	}
	
	public IOTeclado() {
		super(new InputStreamReader(System.in));
		
		lineaBuffer = "";
	}

	public String leerString() {
		String cadena = "";
		try {
			if(lineaBuffer.equals(""))
				cadena = new String(this.readLine());
			else {
				String aux =  lineaBuffer;
				lineaBuffer = "";
				return aux;
						}
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
		return cadena;
	}

	
	
	public  int leerInt() {
		int entero = 0;
		String num="";
		int i=0;
		try {		
				if(lineaBuffer.equals(""))
				{
					lineaBuffer =  this.readLine();
				}
				
				for ( i = 0; i < lineaBuffer.length(); i++) {
					if(lineaBuffer.charAt(i)=='\0' || lineaBuffer.charAt(i)==' ' ||lineaBuffer.charAt(i)=='\n' ){
						if(num.equals(""))
						{
							continue;
						}else{
							break;
						}
						
					}else{
						num+=lineaBuffer.charAt(i);
					}
				}
				
			} catch (NumberFormatException e1) {
				
				System.out.println("Error en el formato del numero, intentelo de nuevo.");
			} catch (IOException e) {
				System.out.println("Error de E/S");
			}
		lineaBuffer = lineaBuffer.substring(i);
		return Integer.valueOf(num).intValue();
	}

}
