package Ejercicio5;

import java.util.Scanner;



public class TestFigurasGeometricas {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		
		Figura [] vector  = new Figura[3] ; //declaro arreglo de 3 posiciones
		int i;
		
		/*
		 * Circulo i = 1
		 * Rectangulo i = 2
		 * Cuadrado i = 3
		 */

		for (i = 0; i < 3; i++) {
			
			System.out.println("Ingrese figura:  ");
			int fig = in.nextInt();
			
			if (fig == 1) {
				System.out.println("INGRESA IF CIRCULO--------------------------");
				
				System.out.println("Ingrese radio:  ");
				int radio = in.nextInt();
				
				System.out.println("Ingrese color:  ");
				String color = in.next();
				
				System.out.println("Ingrese si tiene relleno o no:  ");
				boolean relleno = in.nextBoolean();
				
				vector [i] = new Circulo (radio, color, relleno); 
			}
			else {
				if (fig == 2) {
					System.out.println("INGRESA IF RECTANGULO--------------------------");
					
					System.out.println("Ingrese base:  ");
					int ancho = in.nextInt();
					
					System.out.println("Ingrese altura:  ");
					int largo = in.nextInt();
					
					System.out.println("Ingrese color:  ");
					String color = in.next();
					
					System.out.println("Ingrese si tiene relleno o no:  ");
					boolean relleno = in.nextBoolean();
					
					vector [i]  = new Rectangulo (ancho, largo, color, relleno);
				}
				else {
					if (fig == 3) {
						System.out.println("INGRESA IF CUADRADO--------------------------");
						
						System.out.println("Ingrese base:  ");
						int ancho = in.nextInt();
						
						System.out.println("Ingrese color:  ");
						String color = in.next();
						
						System.out.println("Ingrese si tiene relleno o no:  ");
						boolean relleno = in.nextBoolean();
						
						vector [i]  = new Cuadrado (ancho, color, relleno);
					}
				}
			}
			
			
		}

       
     
	
        /* Recorro  el vector con foreach: 
            
           for (Figura f : vector) {
			System.out.println( f.toString() );
			} 
       
           tira error porq "f" es de tipo figura y yo estoy queriendo imprimir tres elementos que son figura,
           pero son distintos entre si
         		
		*/
        for (Figura v : vector) {
			System.out.println(v.toString() );
			} 
        in.close();
		
		
	}

}
