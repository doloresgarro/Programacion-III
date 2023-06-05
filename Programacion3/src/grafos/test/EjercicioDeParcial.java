package grafos.test;

import grafos.*;
import prog3.listagenerica.*;

public class EjercicioDeParcial {
	
	public Resultado resolver(Grafo <String> ciudades, String origen, int montoMax) {
		Resultado resultado = new Resultado();
		resultado.setMontoSobrante(montoMax);
		if (ciudades != null && !ciudades.esVacio()) {
			ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
			boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
			
			ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
			vertices.comenzar();
			Vertice<String> vInicial = null;
			while (!vertices.fin() && vInicial == null) {
				Vertice<String> vertice = vertices.proximo();
				if (vertice.dato().equals(origen)) {
					vInicial = vertice;
				}
			}
			if (vInicial != null)
				dfs(vInicial, ciudades, visitados, resultado, camino, montoMax);
		}

		return resultado;
	}

	
	private void dfs(Vertice<String> vInicial, Grafo<String> ciudades, boolean[] visitados, Resultado resultado, ListaGenerica<String> camino, int montoMax) {
		visitados[vInicial.posicion()] = true;
		camino.agregarFinal(vInicial.dato());
		
		if ((camino.tamanio() > resultado.getCamino().tamanio()) || (camino.tamanio() == resultado.getCamino().tamanio() && resultado.getMontoSobrante() < montoMax)) {
			resultado.setCamino(clonar(camino));
			resultado.setMontoSobrante(montoMax);
		}
		
		ListaGenerica<Arista<String>> adyacentes = ciudades.listaDeAdyacentes(vInicial);
		adyacentes.comenzar();
		while(!adyacentes.fin()) {
			Arista<String> arista = adyacentes.proximo();
			int posicion = arista.verticeDestino().posicion();
			if (montoMax - arista.peso() >= 0 && !visitados[posicion])
				dfs(arista.verticeDestino(), ciudades, visitados, resultado, camino, montoMax - arista.peso());
		}
		visitados[vInicial.posicion()] = false;
		camino.eliminarEn(camino.tamanio() - 1);
	}
	
	public ListaGenerica<String> clonar (ListaGenerica<String> camino){
		ListaGenerica<String> nueva = new ListaGenericaEnlazada<String>();
		camino.comenzar();
		while (!camino.fin())
			nueva.agregarFinal(camino.proximo());
		return nueva;
	}
	
	
	
}
