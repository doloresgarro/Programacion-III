package grafos.test;

import grafos.*;

import prog3.listagenerica.*;

public class Mapa <T>{
	private Grafo <String> mapaCiudades;
	
	
	
	/*El método devolverCamino (String ciudad1, String ciudad2): ListaGenerica<String>
	// Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
	que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).*/
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];
		
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		
		//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
		boolean encontre = false;
		int i = -1; // pos de ciudad1 para dsp chequear si la encontré o no
		while (!listaVertices.fin() && !encontre) { //mientras no termine la lista de vértices y no encuentre c1 
			Vertice<String> v = listaVertices.proximo();
			if (v.dato() == ciudad1) {
				encontre = true;
				i = v.posicion(); //me guardo la pos
				lista.agregarFinal(v.dato()); // agrego a la lista la c1
			}
		}
		// si encontre la c1 entonces recorro hasta encontrar c2 
		if (i != -1) { //si es -1 no encontró la c1 en el grafo
			devolverCamino(i, marca, lista, camino, ciudad2);
		}
		return camino;
	}

	private void devolverCamino(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino, String ciudad2) {
		
		marca[i] = true; // marco como visitado ese vértice
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // guardo el vértice actual
		
		if (v.dato() == ciudad2)  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
			copiarLista(lista, camino);
		
		//si camino es vacío es porque todavía no se encontró la c2
		if (camino.esVacia()) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); //lista de adyacentes
																								
			adyacentes.comenzar(); 
			while (!adyacentes.fin() && camino.esVacia()) { //mientras no se termine la lista de adyacentes y el camino este vacío
				Vertice<String> destino = adyacentes.proximo().verticeDestino(); //para no avanzar dos veces
																					
				int j = destino.posicion(); // me guardo la pos para marcarla
				if (!marca[j]) {
					lista.agregarFinal(destino.dato()); // agrego el dato a lista
					devolverCamino(j, marca, lista, camino, ciudad2);
					//cuando vuelva en el bactracking puedo ir eliminado la lista porq ya se copio la lista en camino
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	
/*--------------------------------------------------------------------------------------------------------------------*/	
	/*devolverCaminoExceptuando (String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades): ListaGenerica<String> // Retorna la lista de ciudades
			que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades que están
			contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
			vacía. (Sin tener en cuenta el combustible).*/
	
	public ListaGenerica<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];

		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		
		//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
		boolean encontre = false;
		int i = -1; // pos de ciudad1 para dsp chequear si la encontré o no
		while (!listaVertices.fin() && !encontre) { //mientras no termine la lista de vértices y no encuentre c1 
			Vertice<String> v = listaVertices.proximo();
			if (v.dato() == ciudad1) {
				encontre = true;
				i = v.posicion(); //me guardo la pos
				lista.agregarFinal(v.dato()); // agrego a la lista la c1
			}
		}
		// si encontre la c1 entonces recorro hasta encontrar c2 
		if (i != -1) { //si es -1 no encontró la c1 en el grafo
			devolverCaminoExceptuando(i, marca, lista, camino, ciudad2, ciudades);
		}
		return camino;

	}
	
	private void devolverCaminoExceptuando(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino, String ciudad2,  ListaGenerica<String> ciudades) {
		
		marca[i] = true; // marco como visitado ese vértice
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // guardo el vértice actual
		
		//verifico si esta en la lista de ciudades
		if (!estaEnCiudades(v, ciudades)) {
			
			if (v.dato() == ciudad2)  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
				copiarLista(lista, camino);
		
			//si camino es vacío es porque todavía no se encontró la c2
			if (camino.esVacia()) {
				ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); //lista de adyacentes
																								
				adyacentes.comenzar(); 
				while (!adyacentes.fin() && camino.esVacia()) { //mientras no se termine la lista de adyacentes y el camino este vacío
					Vertice<String> destino = adyacentes.proximo().verticeDestino(); //para no avanzar dos veces
																					
					int j = destino.posicion(); // me guardo la pos para marcarla
					if (!marca[j] && (!ciudades.incluye(destino.dato()))) { // si no fue visitada y no esta en ciudades
						lista.agregarFinal(destino.dato()); // agrego el dato a lista
						devolverCaminoExceptuando(j, marca, lista, camino, ciudad2, ciudades);
						//cuando vuelva en el bactracking puedo ir eliminado la lista porq ya se copio la lista en camino
						lista.eliminarEn(lista.tamanio());
					}
				}
			}
		}
	}
	
	
	
/*--------------------------------------------------------------------------------------------------------------------*/
/*
 El método caminoMasCorto(String ciudad1, String ciudad2): ListaGenerica<String> //
Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a
ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la distancia). (Sin tener
en cuenta el combustible).
 */	
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()]; //vector de marcas
		
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>(); //camino que voy a devolver
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>(); //lista para ir agregando valores, luego la voy a eliminar
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		Integer minDistancia = 9999; 
		
		//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
		boolean encontre = false;
		int i = -1; // pos de ciudad1 para dsp chequear si la encontré o no
		
		while (!listaVertices.fin() && !encontre) { //mientras no termine la lista de vértices y no encuentre c1 
			Vertice<String> v = listaVertices.proximo();
			if (v.dato() == ciudad1) {
				encontre = true;
				i = v.posicion(); //me guardo la pos
				lista.agregarFinal(v.dato()); // agrego a la lista la c1
			}
		}
		// si encontre la c1 entonces recorro hasta encontrar c2 
		if (i != -1) { //si es -1 no encontró la c1 en el grafo
			int distancia = 0;
			caminoMasCorto(i, marca, lista, camino, ciudad2, minDistancia, distancia);
		}
		return camino;
	}

	private void caminoMasCorto(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino, String ciudad2, Integer minD, int distancia) {
		
		marca[i] = true; // marco como visitado ese vértice
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // guardo el vértice actual
		lista.agregarFinal(v.dato());
		
		if (v.dato() == ciudad2) {  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
			if (distancia < minD) { //si el camino es mas corto
				copiarLista(lista, camino);
				minD = distancia;
				marca[i] = false; //le cambio la marca porque puedo volver a pasar x ahi
			}
		}
		else {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); //lista de adyacentes																				
			adyacentes.comenzar(); 
			while (!adyacentes.fin()) { //mientras no se termine la lista de adyacentes 
				Arista<String> arista = adyacentes.proximo(); 
																					
				int j = arista.verticeDestino().posicion(); // me guardo la pos para marcarla
				if (!marca[j]) {
					distancia += arista.peso(); //sumo el peso para comparar con el minimo
					caminoMasCorto(j, marca, lista, camino, ciudad2, minD, distancia);
					lista.eliminarEn(lista.tamanio()); //elimino elem de lista 
					distancia -= arista.peso(); 
					marca[j] = false; //desmarco por si vuelvo a pasar por ahi
				}
			}
		}
	}
	
/*--------------------------------------------------------------------------------------------------------------------*/
/*El método caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): ListaGenerica<String> 
--> Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe quedarse 
sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.*/
	
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()]; //vector de marcas
		
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>(); //camino que voy a devolver
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>(); //lista para ir agregando valores, luego la voy a eliminar
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		
		//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
		boolean encontre = false;
		int i = -1; // pos de ciudad1 para dsp chequear si la encontré o no
		
		while (!listaVertices.fin() && !encontre) { //mientras no termine la lista de vértices y no encuentre c1 
			Vertice<String> v = listaVertices.proximo();
			if (v.dato() == ciudad1) {
				encontre = true;
				i = v.posicion(); //me guardo la pos
				lista.agregarFinal(v.dato()); // agrego a la lista la c1
			}
		}
		// si encontre la c1 entonces recorro hasta encontrar c2 
		if (i != -1) { //si es -1 no encontró la c1 en el grafo
			caminoSinCargarCombustible(i, marca, lista, camino, ciudad2, tanqueAuto);
		}
		return camino;
	}

	private void caminoSinCargarCombustible(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino, String ciudad2, int tanqueAuto) {
		marca[i] = true; // marco como visitado ese vértice
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // guardo el vértice actual
		lista.agregarFinal(v.dato());
		
		if (v.dato() == ciudad2)  // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
			copiarLista(lista, camino);
		
		if (!camino.esVacia()) {
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); //lista de adyacentes																				
			adyacentes.comenzar(); 
			while (!adyacentes.fin()) { //mientras no se termine la lista de adyacentes 
				Arista<String> arista = adyacentes.proximo(); 
																					
				int j = arista.verticeDestino().posicion(); // me guardo la pos para marcarla
				if (!marca[j]) {
					tanqueAuto -= arista.peso(); // al pasar al prox vértice gaste el peso entonces le resto al tanque
					if (tanqueAuto - arista.peso() > 0) { //si no me quedo sin nafta sigo avanzando ;)
						caminoSinCargarCombustible(j, marca, lista, camino, ciudad2, tanqueAuto);
						lista.eliminarEn(lista.tamanio()); //elimino elem de lista 
					}
					tanqueAuto += arista.peso(); // cuando vuelve de la recursión le sumo el peso porq "retrocedió
				}
			}
		}
	}
	
	
	
/*--------------------------------------------------------------------------------------------------------------------*/	
/*El método caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): ListaGenerica<String> 
--> Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en medio de
una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino retorna la lista
vacía.*/
	
	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		Integer min = 9999;
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1]; //vector de marcas
		
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>(); //camino que voy a devolver
		ListaGenerica<String> lista = new ListaGenericaEnlazada<String>(); //lista para ir agregando valores, luego la voy a eliminar
		
		
		if (tanqueAuto != 0) {
			ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
			listaVertices.comenzar();
			Vertice<String> v;
			//primero busco la c1 y si la encuentro ahi empiezo a buscar el camino a c2
			boolean encontre = false;
			int i = -1; // pos de ciudad1 para dsp chequear si la encontré o no
		
			while (!listaVertices.fin() && !encontre) { //mientras no termine la lista de vértices y no encuentre c1 
				v = listaVertices.proximo(); //tomo el vertice actual
				if (v.dato() == ciudad1) { //si es la c1
					encontre = true;
					i = v.posicion(); //me guardo la pos
					lista.agregarFinal(v.dato()); // agrego a la lista la c1
				}
			}
			// si encontre la c1 entonces recorro hasta encontrar c2 
			if (i != -1) { //si es -1 no encontró la c1 en el grafo
				int carga = tanqueAuto;
				int cantParadas = 0;
				caminoConMenorCargaDeCombustible(i, marca, lista, camino, ciudad2, tanqueAuto, carga, cantParadas, min);
			}
		}
		return camino;
	}

	private void caminoConMenorCargaDeCombustible(int i, boolean[] marca, ListaGenerica<String> lista, ListaGenerica<String> camino, String ciudad2, int tanqueAuto, int carga, int cantParadas, int min) {
		
		
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i); // guardo el vértice actual
		//lista.agregarFinal(v.dato());
		
		if (v.dato() == ciudad2) { // si el vértice es la c2 entonces copio la lista en camino y devuelvo el camino
			copiarLista(lista, camino);
			if (cantParadas < min) {
				copiarLista(lista, camino);
				min = cantParadas;
			}	
		}
		else {
			marca[i] = true; // marco como visitado ese vértice
			ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(v); //lista de adyacentes																				
			adyacentes.comenzar(); 
			while (!adyacentes.fin()) { //mientras no se termine la lista de adyacentes 
				Arista<String> arista = adyacentes.proximo(); 
																					
				int j = arista.verticeDestino().posicion(); // me guardo la pos para marcarla
				if (!marca[j]) {
					boolean cargo = false; 
					if (tanqueAuto < arista.peso()) { //si tengo menos nafta q la q necesito
						cargo = true; //cargo
						tanqueAuto += carga - tanqueAuto; // le cargo lo max q se puede (carga) entonces le tengo q restar lo q tenia?
						cantParadas++; // incremento porq pare una vez
					}				
					tanqueAuto -= arista.peso(); // al pasar al prox vértice gaste el peso entonces le resto al tanque
					if (tanqueAuto - arista.peso() >= 0) { //si no me quedo sin nafta sigo avanzando ;)
						lista.agregarFinal(arista.verticeDestino().dato());
						caminoConMenorCargaDeCombustible(j, marca, lista, camino, ciudad2, tanqueAuto, carga, cantParadas, min);
						lista.eliminarEn(lista.tamanio()); //elimino elem de lista 
					}
					tanqueAuto += arista.peso(); // cuando vuelve de la recursión le sumo el peso porq "retrocedió
					if (cargo) { //si llego hasta aca ya cargó y proceso, entonces descargo para verificar los otros caminos
						tanqueAuto -= arista.peso(); 
						cantParadas--;
					}
				}
			}
		}
	}
	
	
/*--------------------------------------------------------------------------------------------------------------------*/	
	private void copiarLista(ListaGenerica<String> l, ListaGenerica<String> camino) {
		l.comenzar();
		while (!l.fin()) {
			camino.agregarFinal(l.proximo());
		}
	}
	
	
}
