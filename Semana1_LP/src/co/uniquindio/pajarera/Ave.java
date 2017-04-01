package co.uniquindio.pajarera;

public class Ave {
	
	private  String color;
	private  String comida;
	private  String movimiento;
	
	
	public Ave(String color, String comida, String movimiento) {
		super();
		this.color = color;
		this.comida = comida;
		this.movimiento = movimiento;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Color: "+color+"\n"+
				"Comida: "+comida+"\n"+
				"Movimiento: "+movimiento+"\n";
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getComida() {
		return comida;
	}
	public void setComida(String comida) {
		this.comida = comida;
	}
	public String getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	
	
	
}
