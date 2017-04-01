package co.uniquindio.banco.logica;

import javax.swing.JOptionPane;

import co.uniquindio.banco.excepciones.FondosInsuficientesException;

public class Banco {
	
	public static void main(String[] args)  {
		Cuenta miCuenta  =  new Cuenta();
		try {
			miCuenta.retirar(10);
		} catch (FondosInsuficientesException e) {			
			JOptionPane.showMessageDialog(null, "La cuenta requiere de "+e.getCantidad()+" Para poder retirar ese monto");
		}
	}
}
