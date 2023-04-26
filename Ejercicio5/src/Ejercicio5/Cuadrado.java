package Ejercicio5;


public class Cuadrado extends Rectangulo {
	
	Cuadrado() {
		
	}
	
	Cuadrado(double lado) {
		super(lado, lado);
	}
	
	Cuadrado(double lado,  String color, boolean relleno) {
		super(lado, lado, color, relleno);
	}
	
	public void getLado() {
		super.getAncho();
	}


	public void setLado(double lado) {
		super.setAncho(lado);
		super.setLargo(lado);
	}

	public void setAncho(double ancho) {
		super.setAncho(ancho);
		super.setLargo(ancho);
	}
	
	public void setLargo(double largo) {
		super.setLargo(largo);
		super.setAncho(largo);
	}
	
	public String toString() {
		return ("Color: "+ super.color +". Relleno: "+ super.relleno+ ". Lado" +this.getLado() );
	}

}


