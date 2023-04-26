package prog3.arbolgeneral;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		
		if (!this.esVacio()) {
			
			if (this.esHoja()) 
				return 0;
			else {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos(); //creo lista de hijos
				ArbolGeneral<T> hijo = null; 
				int maximo = 0;
				int altCalc = 0;
				hijos.comenzar();
				
				while (!hijos.fin()) { //mientras no se termine la lista de hijos
					hijo = hijos.proximo(); //guardo valor actual y avanzo en la lista
					altCalc = hijo.altura(); 
					if (altCalc > maximo)
						maximo = altCalc;
				}
				return 1 + maximo;
			}
		}
		else 
			return 0;
	}

	public boolean include(T dato) {
		if (this != null) {
			if (this.getDato() == dato) 
				return true;
			else {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				ArbolGeneral<T> unHijo = null;
				while (!hijos.fin()) {
					unHijo = hijos.proximo();
					if (unHijo.include(dato)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		
		cola.encolar(this); //encolo raiz
		cola.encolar(null); //encolo null para saber que termino el nivel
		int nivel = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			
			if (aux != null) {
				if (aux.getDato() == dato) 
					return nivel;
				else {
					if (aux.tieneHijos()) {
						ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) 
							cola.encolar(hijos.proximo());
						cola.encolar(null);
					}
				}
			}
			else if(!cola.esVacia()) 
				nivel++;
		}
		return -1;
	}

	
	//no se si anda
	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		
		cola.encolar(this);
		cola.encolar(null);
		int maxCant = 0, cantNodos = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
					
					hijos.comenzar();
					while (!hijos.fin())
						cola.encolar(hijos.proximo());
					cola.encolar(null);
				}
				cantNodos++; //cuento para ver cuantos nodos hay por nivel, el mayor sera el ancho
				if (maxCant < cantNodos)
					maxCant = cantNodos;
			} 
			else if (!cola.esVacia()) 
				cantNodos = 0;
		}
		return maxCant;
	}

	
	
}



