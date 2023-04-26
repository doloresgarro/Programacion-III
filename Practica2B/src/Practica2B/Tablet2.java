package Practica2B;
public class Tablet2 extends Mobile {
	private float pulgadas;
	
	public Tablet2(String marca, String sistemaOperativo,  String modelo, double costo, float pulgadas) {
		super(marca, sistemaOperativo, modelo, costo);
		this.pulgadas = pulgadas;
	}
	
	public Tablet2() {
		
	}

	public float getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(float pulgadas) {
		this.pulgadas = pulgadas;
	}
	
	//EQUALS
    public boolean equals (Object o) {
        boolean result = false;
        if ((o != null) && (o instanceof Tablet2)) { // si es instancia de tablet 
            Tablet2 t = (Tablet2) o; // el object lo hace tablet (CASTING --> cambiar el tipo al objeto)
            if ( (super.equals(o)) && (t.getPulgadas() == this.getPulgadas()) ){ // el super es para  que tmb tome lo de mobile
                result = true;
            }
        }
        return result;
    }
    
    public String devolverDatosTablet(){
		String aux; 
	    aux = (super.devolverDatos1() + " pulgadas " + this.getPulgadas() );
	    return aux;
	}
}
