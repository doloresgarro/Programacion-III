package prog3.listagenerica;


public class TestListaGenerica <T>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
		//ListaGenericaEnlazada<Integer> copiaa = new ListaGenericaEnlazada<Integer>();
		
		 l.agregarFinal(32);
	     l.agregarFinal(2);
	     l.agregarFinal(78);
	     l.agregarFinal(4);
	     l.agregarFinal(0);
		
	    System.out.println("Imprime lista: ");
	    imprimir(l);
	    
	    System.out.println("Imprime invertido");	   
	    imprimir(l.invertir());	   
	
	}

	private static void imprimir (ListaGenerica<Integer> lista) {		
		for (int i = 0; i < lista.tamanio(); i++ ) {	
			System.out.println( lista.elemento(i) ); // 
}

}
}
