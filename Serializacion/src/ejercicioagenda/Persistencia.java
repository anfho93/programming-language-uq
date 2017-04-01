
package ejercicioagenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Valentina S
 */
public class Persistencia {
 //aqui metemos metodo de escrbir datos y leer objeto  metodos publicos ruta del archivo ..etc...
    
  public static void escribirObjeto(Agenda miAgenda) throws FileNotFoundException, IOException
  {
    ObjectOutputStream escritor=new ObjectOutputStream(new FileOutputStream("miAgenda.obj"));
    
    escritor.writeObject(miAgenda);
    escritor.close();
  }
  public static Agenda leerObjeto() throws ClassNotFoundException, IOException
  {
    ObjectInputStream lector=new ObjectInputStream(new FileInputStream("miAgenda.obj"));
    Agenda miAgenda= (Agenda)lector.readObject();
    lector.close();
    return miAgenda;
  }
 
}
