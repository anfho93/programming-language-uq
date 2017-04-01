package com.uniquindio.agenda;

import java.io.Serializable;
import java.util.UUID;

public class Usuario  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3201351991520302434L;
	private String nombre;
	private String id;
	private String numero;
	private String direccion;
	
	
	public Usuario(String nombre,String numero, String direccion) {		
		this.nombre = nombre;
		this.id = UUID.randomUUID().toString();
		this.numero = numero;
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: "+nombre +" - Numero: "+numero +"- Direccion: "+direccion+"" ;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
