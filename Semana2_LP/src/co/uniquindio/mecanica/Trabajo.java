package co.uniquindio.mecanica;

import co.uniquindio.mecanica.interfaces.ITrabajo;

public abstract class Trabajo implements ITrabajo {
	protected String nombre;	
	protected String descripcion;
	protected int id;
	protected double horas;
	protected boolean cerrado;

	public Trabajo(String nombre, int id, String descripcion) {
		this.nombre = nombre;
		this.descripcion =  descripcion;
		this.id = id;
		this.horas = 0;
		this.cerrado = false;
	}
	
	public int getId(){
		return id;
	}

	@Override
	public double getCostoTotal() {
		// TODO Auto-generated method stub
		return horas * 20;
	}

	@Override
	public void terminarTrabajo() {
		this.cerrado = true;

	}

	@Override
	public String getDescripcion() {

		return this.descripcion;
	}



	@Override
	public void setDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		this.descripcion =  descripcion;
	}

	@Override
	public void aumentarHoras(double horas) {
		this.horas +=  horas;

	}

	@Override
	public void reducirHoras(double horas) {
		this.horas -=  horas;

	}

	@Override
	public double getCostoBase() {
		
		return this.horas*30;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
