package co.uniquindio.graphics2D.interfaz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfazPrincipal extends JFrame {

	private CanvasPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		InterfazPrincipal frame = new InterfazPrincipal();
		frame.setVisible(true);			
	}

	/**
	 * Create the frame.
	 */
	public InterfazPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
	
		contentPane = new CanvasPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		Container frameContainer =  getContentPane();
		frameContainer.setLayout(new BorderLayout());
		frameContainer.add(contentPane, BorderLayout.CENTER);
		//setContentPane(contentPane);
		addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent evt) {
	            switch(evt.getKeyCode()) {
	               case KeyEvent.VK_LEFT:
	            	   if(contentPane.getMiBola().getX()-1 > 0)
	            	   {
	            		   contentPane.getMiBola().setX(contentPane.getMiBola().getX()-1);
	            	   
	            	   }else{
	            		  System.out.println("no move!!"); 
	            	   }
	                  
	            	   contentPane.repaint();
	                  break;
	               case KeyEvent.VK_RIGHT:
	            	   contentPane.getMiBola().setX(contentPane.getMiBola().getX()+10);
	            	   contentPane.repaint();
	                  break;
	            }
	         }});
	}

}
