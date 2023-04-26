/*Nota: En este ejercicio, Figura está definida como una clase abstracta, la cual contiene:
● Dos variables de instancia privadas : color (String) y relleno (boolean).
● Getter y setter para todas las variables de instancia y el método toString().
● Dos métodos abstractos getArea() y getPerimetro(). */

package Ejercicio5;

public abstract class Figura {
	protected String color;
	protected boolean relleno;
	
	Figura() {
		
	}
	
	Figura(String color, boolean relleno) {
		this.color = color;
		this.relleno = relleno;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isRelleno() {
		return relleno;
	}
	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}
	
	public String toString(){
		String aux; 
	    aux = "Color: " + color + ". Relleno: " + relleno;
	    return aux;
	}
	
	//metodos abstractos
	
	public abstract double getArea();
	
	public abstract double getPerimetro();
	
	
}
