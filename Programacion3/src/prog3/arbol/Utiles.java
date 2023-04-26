package prog3.arbol;

import prog3.util.*;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Utiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creo el arbol
		ArbolBinario <Integer> a = new ArbolBinario <Integer>(new Integer (10)); 
	
		
		//creo hijo izq y le agrego sus hijos 
		ArbolBinario <Integer> hijoIzquierdo = new ArbolBinario <Integer>(new Integer (6));
	    hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(8));		
	
		//creo hijo der y le agrego sus hijos 
		ArbolBinario <Integer> hijoDerecho = new ArbolBinario <Integer>(new Integer (15));
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(20));
		//hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		//hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(1));		
		
		//le agrego hijo izq y der a la raiz 
		a.agregarHijoDerecho(hijoDerecho);
		a.agregarHijoIzquierdo(hijoIzquierdo);
		
		System.out.println("Imprime por nivel: ");
		a.recorridoPorNiveles(); 
		
	
		
		System.out.println("Imprime por pre orden: ");
		a.printPreorden();
		
		
		System.out.println();
		System.out.println("La suma de mayor valor recorriendo el árbol desde la raíz hacia las hojas: " + sumaMaximaVertical(a));
		

		System.out.println("---------------------");
		
		System.out.println("La suma de mayor valor recorriendo por niveles: " + sumaMaximaHorizontal(a));
		
		System.out.println("---------------------");
		
		System.out.println("Trayectoria pesada: " + TrayectoriaPesada(a));
		
		
		
		System.out.println("CONTAR HOJASSSSSSSSSSS: " + a.contarHojas());
		
	}
/*En la clase Utiles del paquete prog3.arbol.binario.util
	implemente el método trayectoriaPesada(ab: Arbol Binario) : Lista que retorna
	el valor de la trayectoria pesada de cada una de las hojas del árbol binario ab
	Se define el valor de la trayectoria pesada de una hoja de un árbol binario como
	la suma del contenido de todos los nodos desde la raíz a la hoja multiplicada por el
	nivel en el que se encuentra. Ejemplo:
	● Trayectoria Pesada hoja 4 es 7*0 + 1*1 + 4*2 = 9
	● Trayectoria Pesada hoja 2 es 7*0 + 3*1 + 2*2 = 7
	● Trayectoria Pesada hoja 1 es 7*0 + 3*1 + 1*2 = 5*/
	
/*	private static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> arbol) {
		//int h = 0; // nivel
		ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
		
		if (arbol == null)
			return null; //la retorno vacia 
		else {
			
			//utilizo la cola, si e hay un null se termina el nivel
				
			
			int resultadoI = 0;
			int resultadoD = 0;
			int nivel = 0; //arranca en el nivel 0
			ArbolBinario<Integer> a = null; //creo arbol p copiarle los datos 
			
			//creo la cola de tipo arbol
			ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
			cola.encolar(arbol); //encolo raiz 
			cola.encolar(null); // encolo null para saber que termino el nivel
			
			while (!cola.esVacia()) {     		 
				a = cola.desencolar(); 
				if (a != null) { // si no termina el nivel multiplico el dato por el nivel
					resultadoI =+ (a.getDato() * nivel);
					resultadoD += (a.getDato()* nivel);
					
					System.out.println(a.getDato()); 
					
					if (a.tieneHijoIzquierdo()) {
						cola.encolar(a.getHijoIzquierdo());
						
					}
					if (a.tieneHijoDerecho()) {
						cola.encolar(a.getHijoDerecho());
						
					}
				}
				else if ( !cola.esVacia()) { 
					System.out.println();
					nivel ++; // cambio de nivel
					l.agregarFinal(resultadoD);
					l.agregarFinal(resultadoI);
					cola.encolar(null); 
				}
			}
		
		
		return l;
		}
	}*/


	private static ListaGenericaEnlazada<Integer> TrayectoriaPesada (ArbolBinario <Integer> arbol) {
			
	 int suma = 0;
	 int nivel = 0; 
	 ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();		
	 
	 return TrayectoriaPesadaRecursivo (arbol, nivel, suma, l);
	}

	private static ListaGenericaEnlazada<Integer> TrayectoriaPesadaRecursivo(ArbolBinario<Integer> arbol, int nivel, int suma, ListaGenericaEnlazada<Integer> l) {
		
	
		
		if (arbol == null) { 
	      return l;
	    }
	    //si el arbol no esta vacio
	    else {
	    	if (arbol.esHoja()) {
	    		suma += arbol.getDato() * nivel; 
	    		l.agregarFinal(suma);
	    	}
	    	else {
	    		suma += arbol.getDato() * nivel;
	    		nivel ++; 
	    		TrayectoriaPesadaRecursivo(arbol.getHijoIzquierdo(), nivel, suma, l);
	    		TrayectoriaPesadaRecursivo(arbol.getHijoDerecho(), nivel, suma, l);
	    		
	    		
	    	}
	      
	    }
		return l;
	  }
	
	
	
	/* Se quiere saber cuál es la suma de mayor valor, recorriendo
el árbol desde la raíz hacia las hojas.
En el árbol binario del ejemplo, los valores
resultantes de la suma son:
● 7 + 1 + 4 = 12
● 7 + 3 + 2 = 12
● 7 + 3 + 1= 11
Por tanto, el valor resultante del método deberia ser 12*/

	private static int sumaMaximaVertical (ArbolBinario <Integer> arbol) {
			
	return sumaMaximaVerticalRecursivo (arbol);
	}

	private static int sumaMaximaVerticalRecursivo(ArbolBinario<Integer> arbol) {
	    if (arbol == null) { 
	      return 0;
	    }
	    //si el arbol no esta vacio
	    else {
	      //creo variable q sume lo de la izq
	      int sumaIzq = sumaMaximaVerticalRecursivo(arbol.getHijoIzquierdo());
	      //creo variable q sume lo de la der
	      int sumaDer = sumaMaximaVerticalRecursivo(arbol.getHijoDerecho());
	      
	      //comparo 
	      if (sumaDer > sumaIzq)
	        return sumaDer + arbol.getDato();
	      else 
	        return sumaIzq +arbol.getDato();
	    }
	  }
	


private static int sumaMaximaHorizontal(ArbolBinario<Integer> arbol) {
	int sumaMax = 0;
	int suma = 0;
	
	ArbolBinario<Integer> a = null; //creo arbol p copiarle los datos 
	
	//creo la cola de tipo arbol
	ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
	cola.encolar(arbol); //encolo raiz 
	cola.encolar(null); // encolo null para saber que termino el nivel
	
	while (!cola.esVacia()) {     // 1 		
		a = cola.desencolar(); 
		if (a != null) { // si no termina el nivel sumo
			suma += a.getDato();
			System.out.println(a.getDato()); 
			
			if (a.tieneHijoIzquierdo())
				cola.encolar(a.getHijoIzquierdo());
			if (a.tieneHijoDerecho())
				cola.encolar(a.getHijoDerecho());
			
		}
		else if ( !cola.esVacia()) { 
			System.out.println();
			if (suma > sumaMax) {
				sumaMax = suma;}
			cola.encolar(null); 
			suma = 0; // se inicializa para el prox nivel
		}
	}
	if (suma > sumaMax) {
		sumaMax = suma;}
	
	return sumaMax;
}		


}
	
