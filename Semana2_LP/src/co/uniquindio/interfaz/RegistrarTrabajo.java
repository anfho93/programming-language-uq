package co.uniquindio.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.uniquindio.mecanica.Trabajo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Button;

public class RegistrarTrabajo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private Main interfazPrincipal;
	private JTextArea txtarea ;
	private JComboBox<String> comboBox ;
	private JComboBox<String> tipoReparacion; 
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public RegistrarTrabajo(Main interfazPrincipal) {
		this.interfazPrincipal =  interfazPrincipal;
		setTitle("Crear Trabajo");
		
		setBounds(100, 100, 433, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(33, 39, 70, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(167, 39, 114, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(33, 71, 70, 15);
		contentPane.add(lblTipo);
		
		comboBox = new JComboBox();
		comboBox.setBounds(167, 68, 114, 24);
		comboBox.addItem("Reparacion");
		comboBox.addItem("Revisión");
		contentPane.add(comboBox);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(33, 98, 89, 15);
		contentPane.add(lblDescripcion);
		
		txtarea = new JTextArea();
		txtarea.setText("");
		txtarea.setBounds(167, 104, 186, 75);
		contentPane.add(txtarea);
		
		JButton button = new JButton("Registrar");
		button.setBounds(156, 185, 86, 23);
		contentPane.add(button);
		button.setName("button");
		
		tipoReparacion = new JComboBox();
		tipoReparacion.addItem("Mecanica");
		tipoReparacion.addItem("Pintura");
		tipoReparacion.setBounds(308, 66, 89, 24);
		contentPane.add(tipoReparacion);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getName().equals("button" ))
		{
			if(validarCampos())
			{
				String nombre =  textField.getText();
				String descripcion =  txtarea.getText();
				String tipo =  (String)comboBox.getSelectedItem();
				String tipoRep  = (String)tipoReparacion.getSelectedItem();
				Trabajo registrado = interfazPrincipal.getMiTaller().agregarTrabajo(nombre, descripcion, tipo, tipoRep);
				if(registrado ==  null){
					JOptionPane.showMessageDialog(this, "No se pudo registrar el trabajo");
				}else{
					JOptionPane.showMessageDialog(this, "El id del trabajo registrado es "+registrado.getId());
				}
			}
		}
		
	}

	private boolean validarCampos() {
		if(!textField.getText().trim().equals("") &&  !txtarea.getText().trim().equals("")){
			return true;
		}
		return false;
	}
}
