package co.uniquindio.mecanica;

import java.util.ArrayList;

public class TallerMecanica {
	private String nombre;
	private ArrayList<Trabajo>trabajos;
	
	public TallerMecanica() {
		nombre = "Anfho Talleres";
		this.setTrabajos(new ArrayList<Trabajo>());
	}
	
	public Trabajo buscarTrabajo(int idTrabajo){
		for (int i = 0; i < trabajos.size(); i++) {
				if(trabajos.get(i).getId() ==  idTrabajo)
				{
					return trabajos.get(i);
				}
		}
		return null;
	}
	
	public Trabajo agregarTrabajo(String nombre, String descripcion, String tipo, String tipoReparacion){
		Trabajo trabajo; 
		if(tipo.equals("Reparacion"))
		{
			if(tipoReparacion.equalsIgnoreCase("mecanica"))
				trabajo =  new Reparacion(nombre, trabajos.size(), Reparacion.MECANICA, descripcion);
			else
				trabajo =  new Reparacion(nombre, trabajos.size(), Reparacion.CHAPA_PINTURA, descripcion);
			
			trabajos.add(trabajo);
		}else	{
			trabajo =  new Revision(nombre,trabajos.size(), descripcion);
			trabajos.add(trabajo);
		}
		return trabajo;
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
	 * @return the trabajos
	 */
	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	/**
	 * @param trabajos the trabajos to set
	 */
	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

}
