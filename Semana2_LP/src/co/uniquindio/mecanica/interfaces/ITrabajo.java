package co.uniquindio.mecanica.interfaces;

public interface ITrabajo {
	
	public double getCostoTotal();
	
	public void terminarTrabajo();
	
	public String getDescripcion();
	
	public void setDescripcion(String descripcion);
	
	public void aumentarHoras(double horas);
	
	public void reducirHoras(double horas);
	
	public double getCostoBase();
	
}
