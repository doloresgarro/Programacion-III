package Practica2B;


public class Mobile {
		private String marca; 
		private String sistemaOperativo;
		private String modelo;
		private double costo;
		
		public Mobile (String marca, String sistemaOperativo,  String modelo, double costo){
		 	this.marca = marca;
		 	this.sistemaOperativo = sistemaOperativo;
		 	this.modelo = modelo;
		 	this.costo = costo;
		}
		
		public Mobile () {
			
		}
		
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getSistemaOperativo() {
			return sistemaOperativo;
		}
		public void setSistemaOperativo(String sistemaOperativo) {
			this.sistemaOperativo = sistemaOperativo;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public double getCosto() {
			return costo;
		}
		public void setCosto(double costo) {
			this.costo = costo;
		}
		public String devolverDatos(){
			String aux; 
		    aux = "Marca: " + marca + ". Sistema operativo: " + sistemaOperativo + ". Modelo: " + modelo + ". Costo: " + costo;
		    return aux;
		}

		
	    public boolean equals (Object o) {
	        boolean result = false;
	        if ((o!=null) && (o instanceof Mobile)) {
	            Mobile m = (Mobile) o; 
	            if ( (m.getMarca() == this.getMarca()) &&  (m.getSistemaOperativo() == this.getSistemaOperativo()) &&
	                    (m.getModelo() == this.getModelo()) && (m.getCosto() == this.getCosto()) ){
	                result = true;
	            } 
	        }
	        return result;
	    }
	    
	    public String devolverDatos1(){
			String aux; 
		    aux = "Marca: " + marca + ". Sistema operativo: " + sistemaOperativo + ". Modelo: " + modelo + ". Costo: " + costo;
		    return aux;
		}

}
