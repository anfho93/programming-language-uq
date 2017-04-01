package co.uniquindio.rocas;

public abstract class RocaIgnea extends Roca {
	
	public RocaIgnea() {
		super("Roca Ignea");
	}

	public RocaIgnea( double peso) {
		super("Roca Ignea", peso);		
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  super.toString();
	}

}
