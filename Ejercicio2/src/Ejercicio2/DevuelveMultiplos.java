/*Lectura por teclado: Agregue al programa del ejercicio 2 la posibilidad de probar
con distintos valores de n ingresándolos por teclado, mediante el uso de las clases
Scanner y System. La clase Scanner permite leer de forma sencilla valores de
entrada.
*/ 

package Ejercicio2;
import java.util.Scanner;
public class DevuelveMultiplos {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in) ;
		
		System.out.println("Ingrese numero: ");
		int n = s.nextInt();
		int[] arreglo = Multiplos.getMultiplos(n);
	
		for (int i = 1; i < n; i++) {
			System.out.println(arreglo[i]);
		}
		
	}
	
	
}
