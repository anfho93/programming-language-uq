package co.uniquindio.geometria;

public class Circulo {
	
	private double radio;
	private String color;
	
	public Circulo(double radio){
		this.radio = radio;		
	}
	
	public Circulo(){		
	}
	
	protected double getArea(){
		return radio*radio*Math.PI;
	}
	
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
