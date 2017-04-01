package co.uniquindio.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.uniquindio.mecanica.Reparacion;
import co.uniquindio.mecanica.Trabajo;
import co.uniquindio.mecanica.interfaces.ITrabajo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BuscarTrabajo extends JFrame implements ActionListener{
	private JTextField idT;
	private JTextField nombreT;
	private JTextField tipoT;
	private JTextField horasT;
	private JTextField costoT;
	private Main interfazPrincipal;
	private JButton btnBuscar ;
	private JButton btnTerminar;
	private Trabajo trabajoEncontrado;
	/**
	 * Launch the application.
	 */
	private JButton menosHoras;
	private JButton masHoras;
	private JButton btnCosto;
	private JLabel lblTipoTrabajo;
	private JTextField TextFieldTipoTrabajo;
	

	/**
	 * Create the frame.
	 */
	public BuscarTrabajo(Main interfazPrincipal) {
		this.interfazPrincipal =  interfazPrincipal;
		setTitle("Buscar trabajo");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Trabajo");
		lblNewLabel.setBounds(51, 37, 103, 15);
		getContentPane().add(lblNewLabel);
		
		idT = new JTextField();
		idT.setBounds(153, 37, 114, 19);
		getContentPane().add(idT);
		idT.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBounds(10, 128, 436, 169);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Nombre");
		lblId.setBounds(13, 28, 55, 15);
		panel.add(lblId);
		
		nombreT = new JTextField();
		nombreT.setBounds(86, 26, 150, 19);
		panel.add(nombreT);
		nombreT.setColumns(10);
		
		JLabel lblTipo = new JLabel("Estado");
		lblTipo.setBounds(16, 52, 49, 15);
		panel.add(lblTipo);
		
		tipoT = new JTextField();
		tipoT.setBounds(86, 50, 150, 19);
		panel.add(tipoT);
		tipoT.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(19, 79, 42, 15);
		panel.add(lblHoras);
		
		horasT = new JTextField();
		horasT.setBounds(86, 77, 150, 19);
		panel.add(horasT);
		horasT.setColumns(10);
		
		menosHoras = new JButton("-1");
		menosHoras.setBounds(284, 65, 47, 25);
		panel.add(menosHoras);
		menosHoras.setName("menosHoras");
		menosHoras.addActionListener(this);;
		masHoras = new JButton("+1");
		masHoras.setBounds(336, 65, 52, 25);
		panel.add(masHoras);
		masHoras.setName("masHoras");
		masHoras.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 0, 0);
		panel.add(lblNewLabel_1);
		
		JLabel lblCostoTotal = new JLabel("Costo Total");
		lblCostoTotal.setBounds(0, 114, 81, 15);
		panel.add(lblCostoTotal);
		
		costoT = new JTextField();
		costoT.setBounds(86, 112, 150, 19);
		panel.add(costoT);
		costoT.setColumns(10);
		
		 btnCosto = new JButton("Agregar Material");
		 btnCosto.setBounds(274, 109, 154, 25);
		 panel.add(btnCosto);
		 btnCosto.setName("btnCosto");
		 btnCosto.addActionListener(this);
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		panel.add(label);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setName("Buscar");
		btnBuscar.setBounds(299, 27, 117, 25);
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		btnTerminar = new JButton("Terminar");
		btnTerminar.setName("Terminar");
		btnTerminar.setBounds(299, 62, 117, 25);
		getContentPane().add(btnTerminar);
		
		lblTipoTrabajo = new JLabel("Tipo Trabajo");
		lblTipoTrabajo.setBounds(51, 72, 103, 15);
		getContentPane().add(lblTipoTrabajo);
		
		TextFieldTipoTrabajo = new JTextField();
		TextFieldTipoTrabajo.setColumns(10);
		TextFieldTipoTrabajo.setBounds(153, 68, 114, 19);
		getContentPane().add(TextFieldTipoTrabajo);
		btnTerminar.addActionListener(this);
		
	}
	public void actualizarCampos(){
		String tipo =  trabajoEncontrado.getClass().getSimpleName();
		TextFieldTipoTrabajo.setText(tipo);
		nombreT.setText(trabajoEncontrado.getNombre());
		if(trabajoEncontrado.isCerrado())
			tipoT.setText("Terminado");
		else tipoT.setText("Activo");
		costoT.setText(""+trabajoEncontrado.getCostoTotal());
		horasT.setText(""+trabajoEncontrado.getHoras());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getName().equals( "Buscar" ))
		{
			try{
				int idTrabajo = Integer.parseInt(idT.getText());
				trabajoEncontrado = interfazPrincipal.getMiTaller().buscarTrabajo(idTrabajo);
				if(trabajoEncontrado != null )
				{
					actualizarCampos();
				}else{
					JOptionPane.showMessageDialog(this, "No tienes trabajos con ese ID");
				}
				
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
			
			
		}else if(((JButton)e.getSource()).getName().equals( "Terminar")){

			try{
				int idTrabajo = Integer.parseInt(idT.getText());
				interfazPrincipal.getMiTaller().buscarTrabajo(idTrabajo).terminarTrabajo();
				actualizarCampos();
				
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}else if(((JButton)e.getSource()).getName().equals( "btnCosto")){
			if(trabajoEncontrado!=null && !trabajoEncontrado.isCerrado() )
			{
				if(trabajoEncontrado.getClass() == Reparacion.class)
				{
					AgregarMaterial frame =  new AgregarMaterial((Reparacion)trabajoEncontrado, this);
					frame.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(this, "El trabajo no es una reparacion");
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Aun no tiene un trabajo encontrado");
			}
			
			
		}else if(((JButton)e.getSource()).getName().equals( "masHoras")){
			if(trabajoEncontrado!=null  && !trabajoEncontrado.isCerrado())
			{				//suma una hora
				trabajoEncontrado.aumentarHoras(1.0);
				actualizarCampos();
			}else{
				JOptionPane.showMessageDialog(null, "El trabajo no existe o esta cerrados");
			}
			
		}else if(((JButton)e.getSource()).getName().equals( "menosHoras")){
			if(trabajoEncontrado!=null && !trabajoEncontrado.isCerrado())
			{
				//suma una hora
				trabajoEncontrado.aumentarHoras(-1.0);
				actualizarCampos();
			}else{
				JOptionPane.showMessageDialog(null, "El trabajo no existe o esta cerrados");
			}
		}
		
		
	}
	
}
