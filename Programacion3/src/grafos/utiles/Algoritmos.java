package grafos.utiles;

import grafos.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.ColaGenerica;

public class Algoritmos <T> {
	
	
/*	subgrafoCuadrado(Grafo<T> grafo): boolean // Retorna true si un dígrafo(dirigido) contiene un
	subgrafo cuadrado, false en caso contrario. 
	Un subgrafo cuadrado es un ciclo simple de longitud 4.*/
	
	
	//POR QUE NO ME CUENTA EN CANT????????????????????????????????????

	public boolean subgrafoCuadrado(Grafo<T> grafo) {
		//ListaGenerica<T> camino = new ListaGenericaEnlazada<T>();
		boolean digrafo = false;
		if (grafo != null && !grafo.esVacio()) { 
			System.out.println("entraaaaaaaaaaaa");
			ListaGenerica<Vertice<T>> listaVertices = grafo.listaDeVertices();	
			boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
					
			
			ListaGenerica<T> caminoActual = new ListaGenericaEnlazada<T>();
			listaVertices.comenzar();		
			while (!listaVertices.fin() && !digrafo) { //mientras no termine la lista de vértices
				Vertice<T> v = listaVertices.proximo();
				Vertice<T> vInicial = v; //este quiero q me lo guarde siempre para saber si vuelve al mismo lugar
				int cant = 0;
				dfs(grafo, v, vInicial, marca, digrafo, cant);
			}
		}
		return digrafo;	
	}
	
	//Vertice<String> vInicial, boolean [] marca, ListaGenerica<String> caminoActual, ListaGenerica<String> camino, String ciudad2) {
	
	private void dfs(Grafo <T> grafo, Vertice<T> v, Vertice<T> vInicial,  boolean [] marca, boolean digrafo, int cant) {
		//System.out.println("Entraaaaaaaaaaaaaaa");
		marca[v.posicion()] = true; // marco como visitado ese vértice
		//caminoActual.agregarFinal(v.dato()); // guardo el vértice actual
		
		if (v.dato().equals(vInicial.dato()) && cant == 4) {  // si el dato actual es igual al mismo que estoy, y los visitados son 4 entonces es un digrafo cuadrado
			System.out.println("Volvi al mismo vertice y pase x cuatro vértices");
			digrafo = true;
			//clonarLista(caminoActual, camino); //aca habia un this
		}
		
		ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v); //lista de adyacentes
		adyacentes.comenzar(); 
		while (!adyacentes.fin() && !digrafo){
			//Vertice <T> vAux = listaDeAdyacentes.proximo().verticeDestino(); //vertice siguiente al actual
			
			Vertice<T> vAux = adyacentes.proximo().verticeDestino();
			int i = vAux.posicion();														
			if (!marca[i]) {
				System.out.println(cant);
				dfs(grafo, vAux,  vInicial, marca, digrafo, cant++);
				
			}
		}
		marca[v.posicion()] = false;
		//caminoActual.eliminarEn(caminoActual.tamanio() - 1); //borro despues de recorrer todos los adyacentes
}
	
	/*
	 getGrado(Grafo<T> grafo) : int 
	Retorna el grado del digrafo pasado como parámetro.
	El grado de un digrafo es el de su vértice de grado máximo. 
	El grado de un vértice en un grafo	dirigido es la suma del número de aristas que salen de él (grado de salida)
	y el número de aristas que entran en él (grado de entrada).
	 */
	
	
	
	public int getGrado (Grafo <T> grafo) {
		boolean [] marca = new boolean [grafo.listaDeVertices().tamanio()];
		int grado = 0;
		int max = -1;
		for (int i = 0; i < marca.length; i++) {
			if (!marca[i]) {
				grado = this.bfs(i, grafo, marca);
				if (grado > max)
					max = grado;
			}
		}
		return max;
	}
		
	
	private int bfs(int i, Grafo<T> grafo, boolean [] marca) {
		ListaGenerica<Arista<T>> adyacentes = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		int[] cantA = new int[grafo.listaDeVertices().tamanio()]; //vector para sumar la cantidad de aristas adyacentes que tiene cada nodo
		
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar();

			
			
			adyacentes = grafo.listaDeAdyacentes(v);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista <T> arista = adyacentes.proximo();
				cantA[v.posicion()] ++; //cada vez q entra es por un adyacente al vertice
				
				int j = arista.verticeDestino().posicion();
				cantA[j]++; // este es para los que apuntan al vértice actual
				if (!marca[j]) {
					Vertice <T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
		//busco el máximo de cant de aristas --> grado
		int max = -1;
		for (int j = 0; j < cantA.length; j++) { 
			if (cantA[i] > max)
				max = cantA[i];
		}		
		
		return max;
		
	}

	

	
	
	
	
	
	
	
	
	
	
/*--------------------------------------------------------------------------------------------------------------------*/	
	private void clonarLista(ListaGenerica<T> l, ListaGenerica<T> camino) {
		camino.comenzar();
		while (!camino.esVacia()) //primero lo vacio y luego copio
			camino.eliminarEn(0);
		l.comenzar();
		camino.comenzar();
		while (!l.fin()) {
			camino.agregarFinal(l.proximo());
		}
	}
	

}

