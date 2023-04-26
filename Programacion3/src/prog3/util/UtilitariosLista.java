package prog3.util;
import prog3.listaenteros.ListaDeEnterosEnlazada;

public class UtilitariosLista {

	public static void main(String[] args) {
	
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		
		l.agregarFinal(72);
		l.agregarFinal(10);
		l.agregarFinal(23);
		l.agregarFinal(1);
		l.agregarFinal(45);
		
		System.out.println("Imprime lista: ");
		imprimir(l);
		
		
		System.out.println("Imprime merge sort: ");
		imprimir(mergeSort(l));
		
	}
	/*
	 consiste en ordenar una lista dividiendo “el
problema” (la lista a ordenar) recursivamente hasta llegar a un punto en que no se
puede dividir más. Luego, a medida que se vuelve de la recursión, se devuelven
listas ya ordenadas y simplemente se combinan. P*/
	
	public static ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada l) {
		if (l.tamanio() <= 1) {
			return l;
		}
		
		
		int mitad = l.tamanio() / 2; 
		
		//creo dos listas -> una izq y otra derecha y las voy llenando para dsp ordenarlas
		ListaDeEnterosEnlazada izquierda = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada derecha = new ListaDeEnterosEnlazada();
		
		for (int i = 0; i < mitad; i++)
			izquierda.agregarFinal(l.elemento(i)); 
		
		for (int i = mitad; i < l.tamanio(); i++)
			derecha.agregarFinal(l.elemento(i)); 
		
		ListaDeEnterosEnlazada izq = mergeSort(izquierda);
		ListaDeEnterosEnlazada der = mergeSort(derecha);
		
		
		return izq.combinarOrdenado(der);
	}
		
		


	private static void imprimir (ListaDeEnterosEnlazada lista) {
	lista.comenzar(); //→ apunta al primer elemento de la lista
	while (! lista.fin() ) {	//→ recorre hasta que sea <> de nil
		System.out.println( lista.proximo() ); // → devuelve elem actual y avanza 
	}
}
	

}