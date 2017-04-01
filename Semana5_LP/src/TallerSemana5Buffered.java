import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TallerSemana5Buffered {

	private static String resultado;
	private static Map<String, Integer> mapa =  new HashMap<String, Integer>();
	private static ArrayList<Palabra> palabras =  new ArrayList<Palabra>();
	
	public static void main(String[] args) throws IOException {
		File archivoTexto =  new File("Himno.txt");
		BufferedReader lectorCaracteres =  new BufferedReader(new InputStreamReader(new FileInputStream(archivoTexto), "UTF-8"));
		
		int caracter = 0;
		String token="";
		
		while((caracter = lectorCaracteres.read())!=-1){
			if((char)caracter!='\0' && (char)caracter!='\n' && (char)caracter != ' ' && (char)caracter!='\t'
					&& !((char)caracter >= 32 && (char)caracter<=47))
			{
				token+=(char)caracter;
			}else{
				almacenarToken(token);
				almacenarToken2(token);
				token="";
			}
			
		}
		
		System.out.println(mapa.toString());
		System.out.println(palabras.toString());
	}
	
	
	private static void almacenarToken2(String token){
		Palabra pal =  new Palabra(token);
		
			for (int i = 0; i < palabras.size(); i++) {
				if(palabras.get(i).compareTo(pal) == 0){
					palabras.get(i).cant++;
					return;
				}
			}
			palabras.add(pal);
		
		
	}	
		private static void almacenarToken(String token) {
			if(mapa.containsKey(token))
			{
				mapa.put(token, mapa.get(token)+1);
			}
			else{
				mapa.put(token, 1);
			}
			
		}
		
	
				
}

class Palabra implements Comparable{
	
	public int cant;
	public String texto; 
	
	public Palabra(String texto) {
		this.texto =  texto;
	}
	
	@Override
	public int compareTo(Object o) {		
		return  texto.compareTo(((Palabra)o).texto);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return texto+"="+cant;
	}
	
	
	
}


