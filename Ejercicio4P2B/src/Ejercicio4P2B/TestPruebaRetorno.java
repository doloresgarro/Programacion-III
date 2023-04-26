package Ejercicio4P2B;

public class TestPruebaRetorno {

	public static void main(String[] args) {
		
		int [] vector = {3, 4, 5, 8, 9, 12, 87};
		Datos MaxMinProm = PruebaRetorno.procesarArreglo(vector);
		System.out.println("El maximo es "+ MaxMinProm.getMax());
		System.out.println("El minimo es "+ MaxMinProm.getMin());
		System.out.println("El promedio es "+ MaxMinProm.getPromedio());
	
	}

}
