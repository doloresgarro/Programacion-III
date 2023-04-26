package Ejercicio5;

public class Rectangulo extends Figura {
	protected double ancho;
	protected double largo;
	
	Rectangulo () {
		
	}
	
	Rectangulo(double ancho, double largo) {
		this.ancho = ancho;
		this.largo = largo;
	}
	
	Rectangulo(double ancho, double largo, String color, boolean relleno) {
		super(color, relleno);
		this.ancho = ancho;
		this.largo = largo; 
	}
	
	
	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}
	
	public String toString() {
		return ( super.toString() + ". Ancho " + this.getAncho() + ". Largo " + this.getLargo() + ". Area: " + this.getArea() + ". Perimetro " + this.getPerimetro() );
	}

	

	public double getArea() {
		return (this.getAncho() * this.getLargo()); // b * a
	}
	
	public double getPerimetro() {
		return (2 *(this.getAncho() + this.getLargo() ));
	}
}
