package prog3.util;

import prog3.listagenerica.ListaGenericaEnlazada;

public class Pila <T> {

	ListaGenericaEnlazada <T> pila;
	
	public Pila() {//???????
		ListaGenericaEnlazada <T> lista = new ListaGenericaEnlazada <T>();
		this.pila = lista;
	}
	
	public void apilar(T elem) {
		this.pila.agregarInicio(elem);
	}
	

	public T desapilar() {
		T aux = this.pila.elemento(0);
		this.pila.eliminarEn(0);
		return aux;
	}
	
	public T tope() {
		return this.pila.elemento(0);
	}
	
	public boolean esVacia() {
		return this.pila.esVacia();
	}
}
