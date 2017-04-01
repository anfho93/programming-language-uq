package co.uniquindio.banco.logica;

import java.util.UUID;

import co.uniquindio.banco.excepciones.FondosInsuficientesException;

public class Cuenta {

	private double saldo;
	private String id;
	
	
	public Cuenta() {
		this.saldo = 0;
		this.id = UUID.randomUUID().toString();
	}
	/**
	 * 
	 * @param deposito
	 * @return
	 */
	public double depositar(double deposito){
		saldo += deposito;
		return saldo;
	}
	/**
	 * 
	 * @param retiro
	 * @return
	 * @throws Exception
	 */
	public double retirar(double retiro) throws FondosInsuficientesException
	{
		if(saldo<retiro)
		{
			/* 
			 * alternativa #1
			 * throw new FondosInsuficientesException("La cuenta con el ID: "+this.id+" no posee fondos suficientes" );
			 */
			// alternativa #2 enviamos la cantidad necesaria para poder retirar
			throw new FondosInsuficientesException(retiro-saldo);
		}else{
			saldo -= retiro;
			return saldo;
		}
	
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
