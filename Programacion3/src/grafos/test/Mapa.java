package grafos.test;

import grafos.*;

import prog3.listagenerica.*;

public class Mapa <T>{
	private Grafo <String> mapaCiudades;
	
	public Mapa (Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	public Mapa() {

	}
	

	/*El método devolverCamino (String ciudad1, String ciudad2): ListaGenerica<String>
	// Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
	que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).*/
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		
		
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		
		if (this.mapaCiudades != null && !this.mapaCiudades.esVacio()) { 
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();			
			
			//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
			Vertice<String> vInicial = null; 
			listaVertices.comenzar();		
			while (!listaVertices.fin() && vInicial == null) { //mientras no termine la lista de vértices y no encuentre c1 
				Vertice<String> v = listaVertices.proximo();
				if (v.dato().equals(ciudad1)) {
					vInicial = v;
				}
			}
			// si encontre la c1 entonces recorro hasta encontrar c2 
			if (vInicial != null) { //si es <> null encontró la c1 en el grafo
				ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
				devolverCamino(vInicial, marca, caminoActual, camino, ciudad2);
			}
		}
		
		
		return camino;
	}
	

	private void devolverCamino(Vertice<String> vInicial, boolean [] marca, ListaGenerica<String> caminoActual, ListaGenerica<String> camino, String ciudad2) {
		
		marca[vInicial.posicion()] = true; // marco como visitado ese vértice
		caminoActual.agregarFinal(vInicial.dato()); // guardo el vértice actual
		
		if (vInicial.dato().equals(ciudad2)) {  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
			System.out.println("Encontre ciudad 2!!!!!!!!!!!!!!!");
			this.clonarLista(caminoActual, camino);
		}
		
		ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vInicial); //lista de adyacentes
		adyacentes.comenzar(); 
		while (!adyacentes.fin()) {  
			int i = adyacentes.proximo().verticeDestino().posicion(); 															
			if (!marca[i]) 
				devolverCamino(mapaCiudades.vertice(i), marca, caminoActual, camino, ciudad2);
		}
		caminoActual.eliminarEn(caminoActual.tamanio() - 1); //borro despues de recorrer todos los adyacentes
}
	
public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
		
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		//ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		
		if (this.mapaCiudades != null && !this.mapaCiudades.esVacio()) { 
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();			
			
			//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
			Vertice<String> vInicial = null; 
			listaVertices.comenzar();		
			while (!listaVertices.fin() && vInicial == null) { //mientras no termine la lista de vértices y no encuentre c1 
				Vertice<String> v = listaVertices.proximo();
				if (v.dato().equals(ciudad1)) {
					vInicial = v;
				}
			}
			// si encontre la c1 entonces recorro hasta encontrar c2 
			if (vInicial != null) { //si es <> null encontró la c1 en el grafo
				ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
				devolverCaminoExceptuando(vInicial, marca, caminoActual, camino, ciudad2, ciudades);
			}
		}
		
		
		return camino;
	}

	private void devolverCaminoExceptuando(Vertice<String> vInicial, boolean [] marca, ListaGenerica<String> caminoActual, ListaGenerica<String> camino, String ciudad2, ListaGenerica<String> ciudades) {
		
		marca[vInicial.posicion()] = true; // marco como visitado ese vértice
		caminoActual.agregarFinal(vInicial.dato()); // guardo el vértice actual
		
		if (vInicial.dato().equals(ciudad2)) {  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
			System.out.println("Encontre ciudad 2!!!!!!!!!!!!!!!");
			this.clonarLista(caminoActual, camino);
		}
		
		ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vInicial); //lista de adyacentes
		adyacentes.comenzar(); 
		while (!adyacentes.fin()) {  
			int i = adyacentes.proximo().verticeDestino().posicion(); 															
			if (!marca[i] && !ciudades.incluye(mapaCiudades.vertice(i).dato())) // si el vertice no esta marcado y tampoco esta en la lista de ciudades
				devolverCamino(mapaCiudades.vertice(i), marca, caminoActual, camino, ciudad2);
		}
		caminoActual.eliminarEn(caminoActual.tamanio() - 1); //borro despues de recorrer todos los adyacentes
	}
	

	 public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		 
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>(); //la que voy a devolver
			
		if (this.mapaCiudades != null && !this.mapaCiudades.esVacio()) { 
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();			
				
			//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
			Vertice<String> vInicial = null; 
			listaVertices.comenzar();		
			while (!listaVertices.fin() && vInicial == null) { //mientras no termine la lista de vértices y no encuentre c1 
				Vertice<String> v = listaVertices.proximo();
				if (v.dato().equals(ciudad1)) {
					vInicial = v;
				}
			}
			// si encontre la c1 entonces recorro hasta encontrar c2 
			if (vInicial != null) { //si es <> null encontró la c1 en el grafo
				ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
				caminoMasCorto(ciudad1, ciudad2, marca, vInicial, caminoActual, camino);
			}
		}
			
		return camino;
	}
	 
	private void caminoMasCorto(String ciudad1, String ciudad2, boolean [] marca, Vertice<String> vInicial, ListaGenerica<String> caminoActual, ListaGenerica<String> camino) {
		marca[vInicial.posicion()] = true; // marco como visitado ese vértice
		caminoActual.agregarFinal(vInicial.dato()); // guardo el vértice actual
		
		
		// mmmmmmmmmm no anda
		if (vInicial.dato().equals(ciudad2) &&(camino.esVacia() || caminoActual.tamanio() < camino.tamanio())) {  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
			System.out.println("Encontre ciudad 2!!!!!!!!!!!!!!!");                          // puedo tener un camino copiado anteriormente o puede estar vacio 
			this.clonarLista(caminoActual, camino);
		}
		System.out.println("Camino actual: " +  caminoActual);
		System.out.println("Camino: " +  camino);
		
		ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vInicial); //lista de adyacentes
		adyacentes.comenzar(); 
		while (!adyacentes.fin()) {  
			int i = adyacentes.proximo().verticeDestino().posicion(); 															
			if (!marca[i]) // si el vertice no esta marcado
				devolverCamino(mapaCiudades.vertice(i), marca, caminoActual, camino, ciudad2);
		}
		marca[vInicial.posicion()] = false; // por si voy por otro camino
		caminoActual.eliminarEn(caminoActual.tamanio() - 1); //borro despues de recorrer todos los adyacentes
	}
	
	
	/*
	 Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe quedarse sin combustible 
	 y no puede cargar. Si no existe camino retorna la lista vacía.
	*/
	
	 public ListaGenerica <String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		 ListaGenerica<String> camino = new ListaGenericaEnlazada<String>(); //la que voy a devolver
			
			if (this.mapaCiudades != null && !this.mapaCiudades.esVacio()) { 
				boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
				ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();			
					
				//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
				Vertice<String> vInicial = null; 
				listaVertices.comenzar();		
				while (!listaVertices.fin() && vInicial == null) { //mientras no termine la lista de vértices y no encuentre c1 
					Vertice<String> v = listaVertices.proximo();
					if (v.dato().equals(ciudad1)) {
						vInicial = v;
					}
				}
				// si encontre la c1 entonces recorro hasta encontrar c2 
				if (vInicial != null) { //si es <> null encontró la c1 en el grafo
					ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
					caminoSinCargarCombustibleDFS(vInicial, marca, caminoActual, camino, ciudad2, tanqueAuto);
				}
			}
				
			return camino;
		}		 


		private void caminoSinCargarCombustibleDFS(Vertice<String> vInicial, boolean[] marca, ListaGenerica<String> caminoActual, ListaGenerica<String> camino, String ciudad2, int tanqueAuto) {
			
			marca[vInicial.posicion()] = true; // marco como visitado ese vértice
			caminoActual.agregarFinal(vInicial.dato()); // guardo el vértice actual
			
			if (vInicial.dato().equals(ciudad2)) {  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
				System.out.println("Encontre ciudad 2!!!!!!!!!!!!!!!");
				this.clonarLista(caminoActual, camino);
			}
			
			
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vInicial); //lista de adyacentes
			adyacentes.comenzar(); 
			while (!adyacentes.fin()) {  
				Arista<String> arista = adyacentes.proximo(); // ahora hago lista de aristas porque necesito el peso
				int i = arista.verticeDestino().posicion(); 															
				if (!marca[i] && (tanqueAuto - arista.peso() >= 0)) 
					caminoSinCargarCombustibleDFS(mapaCiudades.vertice(i), marca, caminoActual, camino, ciudad2, tanqueAuto - arista.peso());
			}
			marca[vInicial.posicion()] = false; //por si paso con otro camino
			caminoActual.eliminarEn(caminoActual.tamanio() - 1); //borro despues de recorrer todos los adyacentes
	}

	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>(); //la que voy a devolver
			
			if (this.mapaCiudades != null && !this.mapaCiudades.esVacio()) { 
				boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
				ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();			
					
				//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
				Vertice<String> vInicial = null; 
				listaVertices.comenzar();		
				while (!listaVertices.fin() && vInicial == null) { //mientras no termine la lista de vértices y no encuentre c1 
					Vertice<String> v = listaVertices.proximo();
					if (v.dato().equals(ciudad1)) {
						vInicial = v;
					}
				}
				// si encontre la c1 entonces recorro hasta encontrar c2 
				if (vInicial != null) { //si es <> null encontró la c1 en el grafo
					ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
					caminoConMenorCargaDeCombustibleDFS(vInicial, marca, caminoActual, camino, ciudad2, tanqueAuto);
				}
			}
				
			return camino;
		}		 
		
		private void caminoConMenorCargaDeCombustibleDFS(Vertice<String> vInicial, boolean[] marca, ListaGenerica<String> caminoActual, ListaGenerica<String> camino, String ciudad2, int tanqueAuto) {
			
			marca[vInicial.posicion()] = true; // marco como visitado ese vértice
			caminoActual.agregarFinal(vInicial.dato()); // guardo el vértice actual
			
			if (vInicial.dato().equals(ciudad2) && (camino.esVacia() || caminoActual.tamanio() < camino.tamanio())) {  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
				System.out.println("Encontre ciudad 2!!!!!!!!!!!!!!!");
				this.clonarLista(caminoActual, camino);
			}
			
			int cant = 0;
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vInicial); //lista de adyacentes
			adyacentes.comenzar(); 
			while (!adyacentes.fin()) {  
				Arista<String> arista = adyacentes.proximo(); // ahora hago lista de aristas porque necesito el peso
				int i = arista.verticeDestino().posicion(); 															
				if (!marca[i]) 
					if (tanqueAuto - arista.peso() < 0) {
						cant++;
						tanqueAuto += arista.peso();
					}
					caminoConMenorCargaDeCombustibleDFS(mapaCiudades.vertice(i), marca, caminoActual, camino, ciudad2, tanqueAuto - arista.peso());
			}
			marca[vInicial.posicion()] = false; //por si paso con otro camino
			caminoActual.eliminarEn(caminoActual.tamanio() - 1); //borro despues de recorrer todos los adyacentes
	
		
		}

		
		
	
	
	
	
	
	
	
	
	
/*--------------------------------------------------------------------------------------------------------------------*/	
	private void clonarLista(ListaGenerica<String> l, ListaGenerica<String> camino) {
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

	

