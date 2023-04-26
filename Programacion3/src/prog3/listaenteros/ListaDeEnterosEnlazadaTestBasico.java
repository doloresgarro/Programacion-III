package prog3.listaenteros;

public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		l.agregarFinal(1);
		l.agregarFinal(4);
		l.agregarFinal(7);
		l.agregarFinal(8);
		
		System.out.println("Imprime iterativo");
		imprimir(l);
		
		System.out.println("Imprime recursivo");
		imprimirReves(l);
		
		

		
		
	}

	private static void imprimir (ListaDeEnterosEnlazada lista) {
		lista.comenzar(); //→ apunta al primer elemento de la lista
		while (! lista.fin() ) {	//→ recorre hasta que sea <> de nil
			System.out.println( lista.proximo() ); // → devuelve elem actual y avanza 
		}
	}
	
	private static void imprimirRecursivo(ListaDeEnterosEnlazada l) {
		if (! l.fin() ) {
			int aux = l.proximo();
			imprimirRecursivo(l);
			System.out.println(aux);
		}
	}


	public static void imprimirReves(ListaDeEnterosEnlazada l) {
		l.comenzar();
		imprimirRecursivo(l);
	}
}
