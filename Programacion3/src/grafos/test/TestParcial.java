package grafos.test;

import grafos.*;

public class TestParcial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertice<String> v1 = new VerticeImplListAdy<String>("LaPlata");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Pinamar");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Quilmes");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Abasto");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Moreno");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Cañuelas");
		Vertice<String> v7 = new VerticeImplListAdy<String>("Carlos Keen");
		Vertice<String> v8 = new VerticeImplListAdy<String>("Suipacha");
		Vertice<String> v9 = new VerticeImplListAdy<String>("Navarro");
		Vertice<String> v10 = new VerticeImplListAdy<String>("Lobos");
		Vertice<String> v11 = new VerticeImplListAdy<String>("Saladillo");
		
		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);
		ciudades.agregarVertice(v8);
		ciudades.agregarVertice(v9);
		ciudades.agregarVertice(v10);
		ciudades.agregarVertice(v11);

		// como no es dirigido lo tengo que conectar de ambos lados
		
		//Saladillo - Navarro
		ciudades.conectar(v11, v9, 25);
		ciudades.conectar(v9, v11, 25);
		//Navarro - Lobos
		ciudades.conectar(v9, v10, 110);
		ciudades.conectar(v10, v9, 110);
		//Navarro - Suipacha
		ciudades.conectar(v8, v9, 50);
		ciudades.conectar(v9, v8, 50);
		//Navarro - Cañuelas
		ciudades.conectar(v6,  v9, 200);
		ciudades.conectar(v9,  v6, 200);
		//Suipacha - Carlos Keen
		ciudades.conectar(v7, v8, 100);
		ciudades.conectar(v8, v7, 100);
		//Carlos Keen - Moreno
		ciudades.conectar(v5,  v7, 100);
		ciudades.conectar(v7,  v5, 100);
		//Cañuelas - Abasto 
		ciudades.conectar(v4,  v6, 100);
		ciudades.conectar(v6,  v4, 100);
		//Abasto - Moreno
		ciudades.conectar(v4, v5, 100);
		ciudades.conectar(v5, v4, 100);
		//Abasto - La Plata
		ciudades.conectar(v1, v4, 100);
		ciudades.conectar(v4, v1, 100);
		//Moreno - Quilmes
		ciudades.conectar(v3, v5, 100);
		ciudades.conectar(v5, v3, 100);
		//Quilmes - La Plata
		ciudades.conectar(v1, v3, 50);
		ciudades.conectar(v3, v1, 50);
		//La Plata - Pinamar
		ciudades.conectar(v1, v2, 300);
		ciudades.conectar(v2, v1, 300);
		
		EjercicioDeParcial mapa = new EjercicioDeParcial();
		Resultado camino = mapa.resolver(ciudades, "La Plata", 500);
				
		
		System.out.println("Imprime camino: " + camino.getCamino());
		System.out.println("Imprime monto sobrante: " + camino.getMontoSobrante());
	}

}
