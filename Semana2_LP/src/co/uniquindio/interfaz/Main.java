package co.uniquindio.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import co.uniquindio.mecanica.TallerMecanica;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener{

	private JFrame frmMiTaller;
	private TallerMecanica miTaller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMiTaller.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		miTaller =  new TallerMecanica();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMiTaller = new JFrame();
		frmMiTaller.setTitle("Mi taller");
		frmMiTaller.setBounds(100, 100, 300, 310);
		frmMiTaller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMiTaller.getContentPane().setLayout(null);
		
		JButton btnRegistrarTrabajo = new JButton("Registrar Trabajo");
		btnRegistrarTrabajo.setBounds(63, 78, 158, 25);
		btnRegistrarTrabajo.setName("btnRegistrarTrabajo");
		frmMiTaller.getContentPane().add(btnRegistrarTrabajo);
		btnRegistrarTrabajo.addActionListener(this);
							
			
		
		JButton btnBuscarTrabajo = new JButton("Buscar Trabajo");
		btnBuscarTrabajo.setName("btnBuscarTrabajo");
		btnBuscarTrabajo.setBounds(63, 132, 158, 25);
		btnBuscarTrabajo.addActionListener(this);
		frmMiTaller.getContentPane().add(btnBuscarTrabajo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(((JButton)e.getSource()).getName().equals("btnRegistrarTrabajo"))
		{
			RegistrarTrabajo frame = new RegistrarTrabajo(this);
			frame.setVisible(true);	
		}else if(((JButton)e.getSource()).getName().equals("btnBuscarTrabajo")){
			BuscarTrabajo frame = new BuscarTrabajo(this);
			frame.setVisible(true);	
		}
		
	}

	/**
	 * @return the miTaller
	 */
	public TallerMecanica getMiTaller() {
		return miTaller;
	}

	/**
	 * @param miTaller the miTaller to set
	 */
	public void setMiTaller(TallerMecanica miTaller) {
		this.miTaller = miTaller;
	}

}
