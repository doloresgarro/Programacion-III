package grafos.test;

import grafos.Grafo;
import grafos.GrafoImplListAdy;
import grafos.Vertice;
import grafos.VerticeImplListAdy;
import grafos.utiles.Algoritmos;

public class AlgoritmosTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Vertice<String> v1 = new VerticeImplListAdy<String>("A");
		 Vertice<String> v2 = new VerticeImplListAdy<String>("B");
		 Vertice<String> v3 = new VerticeImplListAdy<String>("C");
		 Vertice<String> v4 = new VerticeImplListAdy<String>("D");
		 Vertice<String> v5 = new VerticeImplListAdy<String>("E");
		 
		 
		 Grafo <String> grafo = new GrafoImplListAdy <String>();
		 grafo.agregarVertice(v1);
		 grafo.agregarVertice(v2);
		 grafo.agregarVertice(v3);
		 grafo.agregarVertice(v4);
		 grafo.agregarVertice(v5);
		 
		 
		 grafo.conectar(v1, v2); 
		 grafo.conectar(v1, v3);
		 grafo.conectar(v1, v4); 
		 grafo.conectar(v4, v1); 
		 //grafo.conectar(v3, v1); 
		
		 
		 //AlgoritmosVale algoritmo= new AlgoritmosVale<>();
		 Algoritmos algoritmo = new Algoritmos<>();
		 System.out.println("Es digrafo? " + algoritmo.subgrafoCuadrado(grafo));
		 
		 System.out.println("El grado del grafo es: "+ algoritmo.getGrado(grafo));
		
	}

}
