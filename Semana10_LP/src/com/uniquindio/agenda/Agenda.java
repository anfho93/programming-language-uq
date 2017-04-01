package com.uniquindio.agenda;

import java.io.Serializable;
import java.util.ArrayList;

public class Agenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6914134543893082311L;
	
	private ArrayList<Usuario> usuarios;
	
	public Agenda(){
		usuarios =  new ArrayList<Usuario>();
	}
	
	public Usuario agregarUsuario(String nombre, String telefono, String direccion){
		Usuario  usuario = new Usuario(nombre, telefono, direccion);
		usuarios.add(usuario);
		return usuario;
	}
	
	public boolean eliminarUsuario(String id){
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getId().equals(id))
			{
				usuarios.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the usuarios
	 */
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
		
}
