package co.uniquindio.geometria;

public class Cilindro extends Circulo{
	private double altura;
	
	public Cilindro(double radio, double altura){
		super(radio);
		this.setAltura(altura);
	}
	
	@Override
    public double getArea() {
      return 2*Math.PI*getRadio()*altura + 2*super.getArea();
    }

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getVolumen(){
		return super.getArea()*altura;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cylinder: radius = " + getRadio() + " height = " + altura;   
	}
}
