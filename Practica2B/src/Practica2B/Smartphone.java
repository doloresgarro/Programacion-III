package Practica2B;

public class Smartphone extends Mobile {
	private int numero;
	
	public Smartphone(String marca, String sistemaOperativo,  String modelo, double costo, int numero) {
		super(marca, sistemaOperativo, modelo, costo);
		this.numero = numero; 
	}
	
	public Smartphone() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public boolean equals (Object o) {
	        boolean result = false;
	        if ((o != null) && (o instanceof Smartphone)) { // si es instancia de tablet 
	        	Smartphone s = (Smartphone) o; // el object lo hace tablet (CASTING --> cambiar el tipo al objeto)
	            if ( (super.equals(s)) && (s.getNumero() == this.getNumero()) ){ // el super es para  que tmb tome lo de mobile
	                result = true;
	            }
	        }
	        return result;
	    }
	
	public String devolverDatosSmarphone(){
			String aux; 
		    aux = ( (super.devolverDatos1()) + " numero " + this.getNumero() );
		    return aux;
		}
}
