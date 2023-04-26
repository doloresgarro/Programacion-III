package prog3.util;

public class TestBalanceo<T> extends Pila <T>{
	public static void main(String[] args) {
		
		String palabra = "holad(o)lo]res";
		int largo = palabra.length();
		System.out.println("La cadena es " + palabra + " y su largo es " + largo);
		
		System.out.println("La cadena esta balanceada? " + Balanceado(palabra));
	}
	
	public static boolean Balanceado (String cadena) {
		boolean balanc = false;

		Pila<Character> p = new Pila<Character>();
		char c2 = 0; 
		
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			
			if ((c == '(') || (c == '{') || (c == '['))
				p.apilar(c); 
			else 	
				if (((c == ')') || (c == '}') || (c == ']'))) {
					//si esta desbalanceada desapila y no hay nada entnces tira error
					// entonces pregunto si la pila no es vacia 
					if (! p.esVacia()){ //segunda condicion porq sino cuando apilo un car q abre me dice q es balanceada
						c2 = p.desapilar(); //desapilo
						if ( ((c2 == '(') && (c == ')')) || ((c2 == '{') && (c == '}')) || ((c2 == '[') && (c == ']'))) 
							balanc = true;
						else
							balanc = false;
					}
					else 
						balanc = false;
				}
		}
		return balanc;
	}
	

}
