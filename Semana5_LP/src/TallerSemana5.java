import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TallerSemana5 {

	private static Map<String, Integer> mapa =  new HashMap<String, Integer> ();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File miTexto =  new File("Himno.txt");
		FileInputStream lectorBytes =  new FileInputStream(miTexto);
		
		int byteLeido =  lectorBytes.read();
		String token = "";
		while(byteLeido!=-1){
			byteLeido =  lectorBytes.read();
			char aux =  (char)byteLeido;
			//System.out.println(byteLeido);
			if(aux!='\0' && aux!='\n' && aux != ' ' && aux!='\t' )
			{
				token+=aux;
			}else{
				almacenarToken(token);
				token="";
			}
			
		}
		
		System.out.println(mapa.toString());
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
