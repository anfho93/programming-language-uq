package co.uniquindio.mecanica;

import java.util.ArrayList;

public class Reparacion extends Trabajo{
	public final static int MECANICA = 0;
	public final static int CHAPA_PINTURA = 1;
	
	private ArrayList<Material> materiales;
	private int tipo;


	public Reparacion(String nombre, int id, int tipo, String descripcion) {
		super(nombre, id, descripcion);
		materiales = new ArrayList<Material>();
		this.tipo =  tipo;
	}
	
	public void addMaterial(Material material){
		materiales.add(material);
	}

	@Override
	public double getCostoTotal() {
		double costoMaterial = 0;
		double multiplicador = 1;
		for (int i = 0; i < materiales.size(); i++) {				
			costoMaterial += materiales.get(i).getPrecio() ;
		}
		if(tipo == CHAPA_PINTURA)
		{
			 multiplicador = 1.1;
		}else if(tipo == MECANICA){
			multiplicador = 1.3;
		}
		
		return super.getCostoTotal() +costoMaterial * multiplicador ;
	}

	
	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
