package prog3.arbolgeneral;

import prog3.listagenerica.*;
import prog3.arbolgeneral.*;

public class RedDeAguaPotable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Usted debe implementar un método en la clase RedDeAguaPotable, que reciba una
	“configuración” con la forma de la red de agua potable y n litros que son los que
	ingresan por el caño maestro; el método calcula y devuelve cuál es el mínimo caudal
	que recibe una hoja.*/
		
		//creo raiz
		ArbolGeneral<Double> raiz = new ArbolGeneral<Double>(1000.0); //raiz a la q le voy a ir enlazando nodos
		
		//enlazo hijos de la raiz
		raiz.agregarHijo(new ArbolGeneral<Double>(250.0));
		raiz.agregarHijo(new ArbolGeneral<Double>(250.0));
		raiz.agregarHijo(new ArbolGeneral<Double>(250.0));
		raiz.agregarHijo(new ArbolGeneral<Double>(250.0));
		
		//enlazo hijos de los hijos de la raiz
		raiz.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(83.3));
		raiz.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(83.3));
		raiz.getHijos().elemento(3).agregarHijo(new ArbolGeneral<Double>(83.3));
		//raiz.getHijos().elemento(4).agregarHijo(new ArbolGeneral<Double>(83.3));
	
		preOrden();
		
		double litros = 1000;
		System.out.println("El caudal minimo es: " + minCaudal(raiz, litros));
		//System.out.println("Lista de camino max: ");

		
		
	}
	

	  public static double minCaudal(ArbolGeneral<Double> a, double n) {
		  if (a.esHoja())
		      return n;
		    
		  //lista de hijos
		  ListaGenerica<ArbolGeneral<Double>> l = a.getHijos();
		  double min = Double.MAX_VALUE;
		  
		  double aux = n / l.tamanio(); // divido por el tamaño porq se va a dividir en distintos caños
		  
		  l.comenzar();
		  while(!l.fin()) {
			  double actual = minCaudal(l.proximo(), aux);
			  if (actual < min);
			  	min = actual;
		   }
		  
		   return min;
	  }
	
	  

		private void preOrden(ListaGenerica<Integer> l) {
			l.agregarFinal(.getDato());
			ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
			
			listaHijos.comenzar();
			while (!listaHijos.fin())
				listaHijos.proximo().preOrden(l);
		}
}
