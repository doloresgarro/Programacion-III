/*Cree una clase llamada TestTablet que contenga el método main. Dentro del
método main cree un arreglo de Tablet de 3 posiciones.*/
package Ejercicio3;
import java.util.Scanner;
public class TestTablet {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in) ;
		
		Tablet vector[] = new Tablet [3]; //declaro arreglo de 3 posiciones
		
/* Cree 3 instancias de Tablet con distintos valores y agreguelos a cada una de
las posiciones del arreglo. */
				
		for (int i = 0; i < 3; i++) {
			System.out.println("Ingrese marca: ");
			String m = s.next();
			
			System.out.println("Ingrese Sistema Operativo: ");
			String so = s.next();
			
			System.out.println("Ingrese modelo: ");
			String modelo = s.next();
			
			System.out.println("Ingrese costo: ");
			double costo = s.nextDouble();
			
			System.out.println("Ingrese pulgadas: ");
			float pulgadas = s.nextFloat();
			
			vector [i] = new Tablet (m, so, modelo, costo, pulgadas); //creamos tres instancias de tablet
			
		}

		
/*Recorra el arreglo usando una estructura de control iterativa for o foreach e
imprima la información de las Tablets, enviando a cada tablet el mensaje
devolverDatos().

*int numeros[] = new int[5];
for(int aux: numeros) {
System.out.println(aux);

}*/
	
	/*
	 for (int i : arreglo) { 
	suma += i; 
}
*/
	
	for (Tablet t: vector) { 
		System.out.println(t.devolverDatos());
		
	}
	
	//ejemplo de ayudante
	System.out.println("Instancias: " + Tablet.cuantasTablets() );
		

	}

}
