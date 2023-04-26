package prog3.arbol;

import prog3.listagenerica.*;
import prog3.util.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		 ArbolBinario<T> arbol = null;
		 ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		
		 cola.encolar(this);
		 cola.encolar( null);
		 
		 int nivel= 0;
		 int cant_nodos = 0;
		 boolean lleno = true;
		 
		 while (!cola.esVacia() && lleno) {
			 arbol = cola.desencolar();
			 
			 if (arbol != null) {
				 System. out.print(arbol.getDato());
				 
				 if (!(arbol.tieneHijoIzquierdo()) ) {
					 cola.encolar(arbol.getHijoIzquierdo());
					 cant_nodos++;
				 } 
				 
				 if (!(arbol.tieneHijoDerecho()) ) {
					 cola.encolar(arbol.getHijoDerecho());
					 cant_nodos++;
				 }
			 }
			 else if (!cola.esVacia()) {
				 if (cant_nodos == Math.pow(2, ++nivel)){
					 cola.encolar( null);
					 cant_nodos=0;
					 System. out.println();
				 }
				 else lleno = false;}
		 }
		 return lleno;
		}

	

	 public boolean esCompleto() {
			if (this.esVacio())
				return true;
			
			ArbolBinario<T> arbol = new ArbolBinario<T>();
			ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
			
			cola.encolar(this);
			boolean flag = false;

			while(!cola.esVacia()) {
				arbol = cola.desencolar();

				if (flag && !(arbol.esHoja())) 
					return false;

				if ((arbol.tieneHijoIzquierdo()) && (!arbol.tieneHijoDerecho()))
					return false;

				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.hijoIzquierdo);
				else 
					flag = true;

				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.hijoDerecho);
				else 
					flag = true;
			}
			return true;
		}

	
	// imprime el arbol en preorden
    public void printPreorden() {

        System.out.println(this.getDato());
        if (this.tieneHijoIzquierdo()) 
            this.getHijoIzquierdo().printPreorden();
        
        if (this.tieneHijoDerecho()) 
        	this.getHijoDerecho().printPreorden();
        
    }

	// imprime el arbol en Inorden
	
	public void printInorden() {

        if (this.tieneHijoIzquierdo()) 
            this.getHijoIzquierdo().printInorden();
        
        System.out.println(this.getDato());
        
        if (this.tieneHijoDerecho()) 
            this.getHijoDerecho().printInorden();
    }
	
	// imprime el arbol en postorden
	
	 public void printPostorden() {

	        if (this.tieneHijoIzquierdo()) 
	            this.getHijoIzquierdo().printPostorden();
	        
	        if (this.tieneHijoDerecho()) 
	            this.getHijoDerecho().printPostorden();
	        
	        System.out.println(this.getDato());

	 }


	public void recorridoPorNiveles() {
		ArbolBinario <T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.println(arbol.getDato());
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			}
			else if ( !cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}
	

	
	private void fronteraRecursivo(ListaGenericaEnlazada<T> listaFrontera) {
		if (this.tieneHijoIzquierdo())
			 this.getHijoIzquierdo().fronteraRecursivo(listaFrontera);
		if (this.esHoja())
		    listaFrontera.agregarFinal(this.getDato());
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().fronteraRecursivo(listaFrontera);
		}
	
	public  ListaGenericaEnlazada<T> frontera() {
		ListaGenericaEnlazada<T> listaFrontera= new ListaGenericaEnlazada<T>();
		this.fronteraRecursivo(listaFrontera);
		return listaFrontera;
	}

	public int contarHojas(){
		int hojas = 0;
		
		if (this.esVacio())
			return hojas; 
		
		if (this.hijoIzquierdo != null) 
			hojas += this.getHijoIzquierdo().contarHojas();
		
		if (this.hijoDerecho != null)
			hojas += this.getHijoDerecho().contarHojas();
		
		//si es hoja
		if (this.getDato() != null) {
			if ((this.getHijoDerecho() == null) && (this.getHijoIzquierdo() == null)) {
				hojas++;
			}
		}
		
		/*if (this.esHoja())
			hojas++;*/
		
		return hojas;
	} 

	
	
	

}