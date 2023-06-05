package grafos.test;

import grafos.*;
import grafos.utiles.Mapa;
import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.listagenerica.*;

public class MapaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			 Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
			 Vertice<String> v2 = new VerticeImplListAdy<String>("Lima");
			 Vertice<String> v3 = new VerticeImplListAdy<String>("Santiago");
			 Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
			 Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
			 Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
			 Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");
			 
			 
			 Grafo <String> ciudades = new GrafoImplListAdy <String>();
			 ciudades.agregarVertice(v1);
			 ciudades.agregarVertice(v2);
			 ciudades.agregarVertice(v3);
			 ciudades.agregarVertice(v4);
			 ciudades.agregarVertice(v5);
			 ciudades.agregarVertice(v6);
			 ciudades.agregarVertice(v7);
			 
			 
			 ciudades.conectar(v1, v2, 2); 
			 ciudades.conectar(v1, v3, 3); 
			 ciudades.conectar(v1, v4, 4); 
			 ciudades.conectar(v1, v5, 10); 
			 ciudades.conectar(v3, v5, 500); 
			 ciudades.conectar(v3, v7, 40);
			 ciudades.conectar(v2, v5, 4);
			 ciudades.conectar(v4, v5, 6);
			 ciudades.conectar(v6, v5, 10);
			 ciudades.conectar(v6, v7, 10);
			 //ciudades.conectar(v1, v7, 10);
			
			 
			 
			 /*		
			 EjercicioDeParcial mapa = new EjercicioDeParcial();
			 Resultado camino = mapa.resolver(ciudades, "La Plata", 500);
				*/
			 Mapa<String> m = new Mapa<String>(ciudades);
	        // ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();

			 System.out.println("Devolver camino mas corto desde Bs As a La Habana: " + m.devolverCamino("Buenos Aires", "holis"));
			 
			 ListaGenerica<String> l = new ListaGenericaEnlazada<String>(); 
			 l.agregarFinal("Buenos Aires");
			 l.agregarFinal("Montevideo");
			 l.agregarFinal("Asuncion");
			 System.out.println("Devolver camino exceptuando..: " + m.devolverCaminoExceptuando("Buenos Aires", "holis", l));
			 
			 System.out.println("Devolver camino mas corto: " + m.caminoMasCorto("Buenos Aires", "La Habana"));
			 System.out.println("Devolver camino sin cargar combustible: " + m.caminoSinCargarCombustible("Buenos Aires", "Asuncion", 6));
			// System.out.println("Devolver camino con menor carga de combustible: " + m.caminoConMenorCargaDeCombustible("Buenos Aires", "La Habana", 2));
			 
	}
}
