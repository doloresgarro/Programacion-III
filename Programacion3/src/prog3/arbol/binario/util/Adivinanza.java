package prog3.arbol.binario.util;

import prog3.arbol.ArbolBinario;
import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada; 

public class Adivinanza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArbolBinario <String> a = new ArbolBinario <String>(new String ("Tiene 4 patas?")); 
		
		//creo hijo izq y le agrego sus hijos 
		ArbolBinario <String> hijoIzquierdo = new ArbolBinario <String>(new String ("Se mueve?"));
	   // hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<String> ("Ladra?"));	
	    
		ArbolBinario <String> hijoDerecho = new ArbolBinario <String>(new String ("Tiene alguna pata?"));
	    hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<String> ("Ladra?"));		
		//hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<String> ("Es un perro"));
	
		//lo saque de vale
		ArbolBinario <String> nodoLadra = hijoIzquierdo.getHijoIzquierdo(); //asigno el ladra a un nodo accesible
		nodoLadra.agregarHijoIzquierdo(new ArbolBinario <String> ("ES UN PERRO")); //le creo un hijo izquierdo en la misma linea que lo agrego
		nodoLadra.agregarHijoDerecho(new ArbolBinario <String> ("ES UN GATOO")); 
		//creo hijo der y le agrego sus hijos 
		
		//hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<String> ("Tiene 4 patas?"));
		//hijoDerecho.agregarHijoDerecho(new ArbolBinario<String>"Tiene 4 patas?"));		
		
		//le agrego hijo izq y der a la raiz 
		a.agregarHijoDerecho(hijoDerecho);
		a.agregarHijoIzquierdo(hijoIzquierdo);
		
		System.out.println("Imprime por nivel: ");
		a.recorridoPorNiveles();
		
		
		System.out.println("Imprime secuencia con mas preguntas: ");
		secuenciaConMasPreguntas(a);
		

		System.out.println("El camino  mas largo en el arbol es: " + (secuenciaConMasPreguntas (a)).toString());
		
		System.out.println("El camino  mas largo en el arbol es: " + (secuenciaConMasPreguntas2 (a)).toString());
		
	}


	public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> a) {
		//creo lista que voy a devolver
		ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<String>(); 
		
		//
		ListaGenericaEnlazada<String> izq = new ListaGenericaEnlazada<String>(); 
		ListaGenericaEnlazada<String> der = new ListaGenericaEnlazada<String>(); 
		
		if (a == null)
			return l; 
		else {
			der = secuenciaConMasPreguntas(a.getHijoDerecho());
			izq = secuenciaConMasPreguntas(a.getHijoIzquierdo());
			
			if (der.tamanio() > izq.tamanio()) {
				der.agregarInicio(a.getDato());
				return der;
			}
			else { 
				if (der.tamanio() < izq.tamanio()) {
					izq.agregarInicio(a.getDato());
					return izq;
				}
				else { //si son iguales 
					der.agregarInicio(a.getDato());
					izq.agregarInicio(a.getDato());
					return der; //retorno cualq
				}
			}
			
		}				
	}
		
	
	/*Adivinanza revisado. Escriba un método llamado
secuenciaConMasPreguntasVersion2 (que es una modificación sobre el método
secuenciaConMasPreguntas), donde se asume que SI pueden existir varios
caminos de igual longitud, en ese caso debe devolver todos los caminos.*/

	public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas2(ArbolBinario<String> a) {
		//creo lista que voy a devolver
		ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<String>(); 
		
		//
		ListaGenericaEnlazada<String> izq = new ListaGenericaEnlazada<String>(); 
		ListaGenericaEnlazada<String> der = new ListaGenericaEnlazada<String>(); 
		
		if (a == null)
			return l; 
		else {
			der = secuenciaConMasPreguntas(a.getHijoDerecho());
			izq = secuenciaConMasPreguntas(a.getHijoIzquierdo());
			
			if (der.tamanio() > izq.tamanio()) {
				der.agregarInicio(a.getDato());
				return der;
			}
			else { 
				if (der.tamanio() < izq.tamanio()) {
					izq.agregarInicio(a.getDato());
					return izq;
				}
				else { //si son iguales 
					der.agregarInicio(a.getDato());
					izq.agregarInicio(a.getDato());
					return der; //retorno cualq
				}
			}
			
		}				
	}
	
}
