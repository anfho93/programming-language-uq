
package ejercicioagenda;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Valentina S
 */    
public class Agenda implements Serializable
{
 
    public ArrayList<Contacto>contactos;
  

    public Agenda() {
        this.contactos = new ArrayList<Contacto>();
    }
   
   public boolean agregarContacto(String nombre,String telefono,String id,String celular)
   {
      boolean existe= true;
        
        for(int i=0;i<contactos.size();i++){
            if(contactos!=null)
            {
                if(contactos.get(i).getTelefono().equals(telefono)|| contactos.get(i).getTelefono().equals(id) 
                        || contactos.get(i).getTelefono().equals(celular))           
                {
                 JOptionPane.showMessageDialog(null, "Ya existe un elemento en la agenda con estos datos");
                 existe = false;
                 break;
                }  
            } 
        } 
        if(existe)
              {
                  Contacto miContacto=new Contacto(nombre,id,telefono,celular);
                  contactos.add(miContacto);
               
                  JOptionPane.showMessageDialog(null, "Se agregó correctamente");
              }
       return false;
   }
   public void eliminarContacto(String id)
   {      
             for(int i=0;i<contactos.size();i++)
             {
              if(contactos.get(i).getId().equals(id))
              {
                 contactos.remove(i);
                 break;
              }
             }
             JOptionPane.showMessageDialog(null,"Elemento eliminado satisfactoriamente"); 
   }
}



