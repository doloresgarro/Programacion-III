package prog3.util;

public class PilaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Escriba una clase llamada PilaTest, donde demuestre el uso de su pila
		con elementos de tipo “Character”.
		i. Agregue a la pila los caracteres ‘a’, ‘b’, ‘c’, ’d’, ’e’
		ii. Saque de la pila 4 elementos del tope
		iii. Imprima en pantalla el elemento en el tope de la pila (debería
		imprimir ‘a’).*/
		

		Pila <Character> p = new Pila <Character>();
		
		p.apilar('a');
		p.apilar('b');
		p.apilar('c');
		p.apilar('d');
		p.apilar('e');
		
		for (int i = 0; i < 4; i++) {
			p.desapilar();
		}
		
		System.out.println(p.tope());
	}
}