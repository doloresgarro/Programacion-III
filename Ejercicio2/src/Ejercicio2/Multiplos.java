/*Escriba un método de clase llamado getMultiplos que dado un número
entero n como parámetro, devuelve un arreglo de n posiciones cuyo
contenido son los primeros n primeros múltiplos mayores a 1.
Ejemplo:
getMultiplos(5) devuelve [5; 10; 15; 20; 25];
getMultiplos(4) devuelve [4; 8; 12; 16];*/

package Ejercicio2;
public class Multiplos {
	
	
	public static int[] getMultiplos(int n) {
		int arreglo [] = new int [n]; //creo arreglo y reservo espacio en memoria
		int i;
		for (i = 0; i < n; i++)  
			arreglo [i] = i * n;  
		return arreglo;
	}

}


