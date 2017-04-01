package co.uniquindio.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.uniquindio.mecanica.Material;
import co.uniquindio.mecanica.Reparacion;
import co.uniquindio.mecanica.Trabajo;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AgregarMaterial extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JButton btnAgregar;
	private Reparacion trabajoEncontrado;
	private JComboBox<String> comboBox;
	private BuscarTrabajo interfazTrabajo;

	/**
	 * Create the frame.
	 */
	public AgregarMaterial(Reparacion trabajo, BuscarTrabajo frame) {
		this.interfazTrabajo = frame;
		this.trabajoEncontrado =  trabajo;
		setTitle("Agregar materiales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(49, 12, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(49, 39, 70, 15);
		contentPane.add(lblTipo);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(49, 66, 70, 15);
		contentPane.add(lblValor);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setName("btnAgregar");
		btnAgregar.setBounds(123, 107, 117, 25);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(this);
		
		textField = new JTextField();
		textField.setBounds(126, 10, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 64, 114, 19);
		contentPane.add(textField_2);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(123, 34, 117, 24);
		contentPane.add(comboBox);
		comboBox.addItem("Pintura");
		comboBox.addItem("Piezas");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!textField.getText().trim().equalsIgnoreCase("") && 
				!textField_2.getText().trim().equalsIgnoreCase("")){
			try{
			String nombre =  textField.getText();
			int tipo = comboBox.getSelectedIndex();
			
			double precio =  Double.parseDouble(textField_2.getText());
			trabajoEncontrado.addMaterial(new Material(nombre, tipo, precio));
			interfazTrabajo.actualizarCampos();
			}catch(NumberFormatException ex){
				System.out.println(ex.getMessage());
			}
		}
		
		
	}
}
