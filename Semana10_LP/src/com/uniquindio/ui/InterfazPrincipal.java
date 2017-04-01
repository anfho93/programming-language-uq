package com.uniquindio.ui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.uniquindio.agenda.Agenda;
import com.uniquindio.agenda.Usuario;
import com.uniquindio.persistencia.Persistencia;

public class InterfazPrincipal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JList list;
	private Agenda  agenda;

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
		try {
			Object a = Persistencia.leerDatos();
			agenda =  (Agenda) a ;
		} catch (FileNotFoundException e) {
			agenda =  new Agenda();
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			agenda =  new Agenda();
			//e.printStackTrace();
		} catch (IOException e) {
			agenda =  new Agenda();
			//e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			  @Override
              public void windowClosing(WindowEvent we) {
                  try {
					Persistencia.escribirDatos(agenda);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                  System.exit(0);
              }
		});
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 56, 133, 160);
		frame.getContentPane().add(scrollPane);
		
		list = new JList<Usuario>();
		DefaultListModel<Usuario> a = new DefaultListModel<Usuario>();
		for (int i = 0; i < agenda.getUsuarios().size(); i++) {
			a.addElement(agenda.getUsuarios().get(i));
		}
		list.setModel(a);
		scrollPane.setViewportView(list);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(12, 218, 117, 25);
		frame.getContentPane().add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre =  textField.getText();
				String celular =  textField_1.getText();
				String direccion =  textField_2.getText();
				agenda.agregarUsuario(nombre, celular, direccion);				
				DefaultListModel<Usuario> a = new DefaultListModel<Usuario>();
				for (int i = 0; i < agenda.getUsuarios().size(); i++) {
					a.addElement(agenda.getUsuarios().get(i));
				}
				list.setModel(a);
			}
		});
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(141, 218, 117, 25);
		frame.getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario seleccionado =  (Usuario)list.getSelectedValue();
				agenda.eliminarUsuario(seleccionado.getId());
				DefaultListModel<Usuario> a = new DefaultListModel<Usuario>();
				for (int i = 0; i < agenda.getUsuarios().size(); i++) {
					a.addElement(agenda.getUsuarios().get(i));
				}
				list.setModel(a);
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 42, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(96, 40, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(12, 78, 70, 15);
		frame.getContentPane().add(lblCelular);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 76, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 105, 70, 25);
		frame.getContentPane().add(lblDireccion);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 107, 114, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setBounds(275, 25, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
