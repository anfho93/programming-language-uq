package co.uniquindio.propiedades;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InterfazPrincipal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JList list ;
	private Properties propiedades ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal window = new InterfazPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazPrincipal() {
		initialize();
		propiedades =  new Properties();
		cargarPropiedades();
	}

	private void cargarPropiedades() {
		
	    InputStream entrada = null;
	    try {
	    	//creamos el flujo de datos para leer las propiedades
	    	entrada = new FileInputStream("app.properties");
	        //cargamos las propiedades
	        propiedades.load(entrada);
	        //obtenemos todos los valores de las propiedades dentro del archivo
	        Enumeration<Object> valores = propiedades.elements();
	        //obtenemos todos las llaves de las propiedades dentro del archivo
	        Enumeration<Object> prop = propiedades.keys();//similar a un arraylist
	        DefaultListModel<String> aux =  new DefaultListModel<String>();
	        
	        while(valores.hasMoreElements()){	        	
	        	String a = (prop.nextElement().toString() +":"+valores.nextElement().toString());
	        	aux.addElement(a);	        	
	        }
	        //cambiamos los datos del JList
	    	list.setModel(aux);
	        
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (entrada != null) {
	            try {
	                entrada.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
		
	}

	protected void agregarPropiedad() {
		String llave = textField.getText();
		String  valor = textField_1.getText();
		if(!llave.equals("") && !valor.equals("")){
			
		    OutputStream salida = null;
		    try {
		    	  salida = new FileOutputStream("app.properties");
		    	//creamos el flujo de datos para leer las propiedades
		        //cargamos las propiedades
		        propiedades.put(llave, valor);
		        propiedades.store(salida, null);
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    } finally {
		        if (salida != null) {
		            try {
		                salida.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		}else{
			System.out.println("verifique los espacios");
		}
	}
	
	protected void eliminarElemento() {	
		String elem = (String)list.getSelectedValue();
		String []vlas =  elem.split(":");		
		
	    OutputStream salida = null;
	    try {
	    	//creamos el flujo de datos para leer las propiedades
	        salida = new FileOutputStream("app.properties");
	        //cargamos las propiedades
	        propiedades.remove(vlas[0]);
	        propiedades.store(salida, null);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (salida != null) {
	            try {
	                salida.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }		
	}

	protected void cambiarPropiedad() {
		String llave = textField.getText();
		String  valor = textField_1.getText();
		
	    OutputStream salida = null;
	    try {
	    	  salida = new FileOutputStream("app.properties");
	    	if(propiedades.containsKey(llave))
	    	{
	    		propiedades.setProperty(llave, valor);
	    	}else{
	    		System.out.println("No tiene la llave");
	    	}
	    	//creamos el flujo de datos para leer las propiedades
	      
	        //cargamos las propiedades
	        propiedades.store(salida, null);
	        
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (salida != null) {
	            try {
	                salida.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
	}
	
	protected void actualizar() {
		// TODO Auto-generated method stub
		cargarPropiedades();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(265, 72, 173, 188);
		frame.getContentPane().add(scrollPane);
		
		 list = new JList<String>();
		scrollPane.setViewportView(list);
		
		JLabel lblListaPropiedades = new JLabel("Lista Propiedades");
		lblListaPropiedades.setBounds(265, 45, 135, 15);
		frame.getContentPane().add(lblListaPropiedades);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(84, 144, 117, 25);
		frame.getContentPane().add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPropiedad();
				actualizar();
			}

			
		});
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(84, 181, 117, 25);
		frame.getContentPane().add(btnCambiar);
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPropiedad();
				actualizar();
			}
		});
		
		JButton button = new JButton("Eliminar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarElemento();
				actualizar();
			}
		});
		button.setBounds(84, 218, 117, 25);
		frame.getContentPane().add(button);
		
		JLabel lblLlave = new JLabel("Llave");
		lblLlave.setBounds(27, 12, 70, 15);
		frame.getContentPane().add(lblLlave);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(27, 59, 70, 15);
		frame.getContentPane().add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(27, 26, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(27, 72, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}

	

	
}
