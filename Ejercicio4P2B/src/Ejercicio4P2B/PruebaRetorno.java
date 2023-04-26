/*Cree una clase llamada PruebaRetorno con un método llamado procesarArreglo.
Éste método recibe como argumento un arreglo de enteros y debe devolver el
máximo, el mínimo y el promedio del mismo. Proponga 2 implementaciones para la
forma de devolver el resultado de procesarArreglo. Nota: el método no puede
devolver un arreglo.
*/
package Ejercicio4P2B;

public class PruebaRetorno {
	

	public static Datos procesarArreglo(int[] vector) {
		int max = -1, min = 999999,  suma = 0;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] > max)
				max = vector[i];
			if (vector[i] < min)
				min = vector[i];
			suma += vector[i];
		}
		double prom = (double)suma / vector.length;
		Datos obj = new Datos(); //creamos objeto que tenga max, min y prom
		obj.setMax(max);
		obj.setMin(min);
		obj.setPromedio(prom);
		return obj;
	
	}
	
}
	