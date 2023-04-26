package prog3.util;


import prog3.listagenerica.ListaGenericaEnlazada;

public class ColaGenerica <T> {

	private int cant;
	ListaGenericaEnlazada <T> cola;
//-------------------------------------------------------
	//tenia mal este constructor!!
	public ColaGenerica() {
		ListaGenericaEnlazada <T> lista = new ListaGenericaEnlazada <T>();
		this.cola = lista;
		this.cant=0; //inicializo en 0
	}
	
	public void encolar (T elem) {
		
		this.cola.agregarFinal(elem); //apila por eso arriba se agrega
		this.cant++; // sumo de a 1
	}
	
	public int tamanioCola () {
		return cant;
	}

	public T desencolar () {
		T aux = this.cola.elemento(0); //primer elemento
		this.cola.eliminarEn(0); //elimino el que esta atras
		this.cant--;
		return aux;
	}
//----------------------------------------------
	public T tope () {
		return this.cola.elemento (0);
	}
//----------------------------------------------
	public boolean esVacia() {
		return this.cola.esVacia();
	}
	
	
}