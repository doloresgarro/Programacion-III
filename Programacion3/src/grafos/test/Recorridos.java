package grafos.test;

import grafos.*;
import prog3.listagenerica.*;
import prog3.util.*;

public class Recorridos <T>{

	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){
		 boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		 ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		
		 for (int i=0; i<=marca.length;i++){
			 if (!marca[i]) 
				 this.dfs(i, grafo, marca, lista); 
		 }
		return lista;	 
	}
	
	
	private void dfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> lista){
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		lista.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v); 
		
		ady.comenzar();
		while(!ady.fin()){
			int j = ady.proximo().verticeDestino().posicion();
			if(!marca[j])
				this.dfs(j, grafo, marca, lista);
		 }
	}
	
	
	public ListaGenerica<Vertice<T>> bfs (Grafo <T> grafo) {
		boolean [] marca = new boolean [grafo.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		
		for (int i = 0; i < marca.length; i++) {
			if (!marca[i])
				this.bfs(i, grafo, marca, lista);
		}
		return lista;
	}
		
	
	private void bfs(int i, Grafo<T> grafo, boolean [] marca, ListaGenerica<Vertice<T>> lista) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
	
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			lista.agregarFinal(v);
			
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista <T> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					Vertice <T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
			
		}
		
	}
}
