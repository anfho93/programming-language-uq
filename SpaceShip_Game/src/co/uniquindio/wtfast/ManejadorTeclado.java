package co.uniquindio.wtfast;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ManejadorTeclado  implements KeyListener{

	private boolean[] teclas;
	public boolean arriba=false, abajo=false, izq=false, derecha=false;
	public ManejadorTeclado() {
	teclas = new boolean[256];
	}
	
	
	public void actualizar(){
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		izq = teclas[KeyEvent.VK_A];
		derecha = teclas[KeyEvent.VK_D];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		teclas[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		teclas[e.getKeyCode()] = false;

	}

}
