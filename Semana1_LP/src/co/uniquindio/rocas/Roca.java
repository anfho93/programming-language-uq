package co.uniquindio.rocas;

public class Roca {
	private String clasificacion;
	private double peso;
	
	
	public Roca(String clasificacion){
		super();
		this.clasificacion = clasificacion;
	}

	public Roca(String clasificacion, double peso) {
		super();
		this.clasificacion = clasificacion;
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Clasificacion: "+ clasificacion+"\n"
				+ "Peso: "+peso;
	}


	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


}
