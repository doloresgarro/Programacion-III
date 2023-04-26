/*Las subclases Circulo y Rectangulo deben sobreescribir los métodos abstractos getArea()
y getPerimetro() y proveer implementación propia. También sobreescriben el método
toString().
*/

package Ejercicio5;

public class Circulo extends Figura {
	protected double radio;

	
	// constructores
	Circulo() {
		
	}
	
	Circulo(double radio) {
		this.radio = radio;
	}
	
	Circulo(double radio, String color, boolean relleno) {
		super(color, relleno);
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		String aux;
		aux = (super.toString() + ". Radio " + this.getRadio() + ". Area: " + this.getArea() + ". Perimetro " + this.getPerimetro() );
		return aux;
	}
	
	public double getArea() {
		double numero = 2;
		return ((Math.pow(this.getRadio(), numero)) * 3.14);
	}
	
	public double getPerimetro() {
		return (this.getRadio() * 2 * 3.14);
	}
	
}
