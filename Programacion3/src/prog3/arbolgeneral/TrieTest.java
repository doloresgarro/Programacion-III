package prog3.arbolgeneral;

public class TrieTest {

	public static void main(String[] args) {

		Trie t = new Trie(' ');
		t.agregarPalabra("dedo");
		System.out.println(t);
		
		t.agregarPalabra("dejo");
		t.agregarPalabra("tero");
		t.agregarPalabra("tiro");
		System.out.println(t);
	}

}
