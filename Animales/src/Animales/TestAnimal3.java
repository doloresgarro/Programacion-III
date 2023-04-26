package Animales;

public class TestAnimal3 {
	public static void main(String[] args) {
		Gato gato1 = new Gato();
		gato1.saludo();
		
		Perro perro1 = new Perro();
		perro1.saludo();
		
		PerroGrande perroGrande1 = new PerroGrande();
		perroGrande1.saludo();
		
		Animal animal1 = new Gato(); //upcasting 
		animal1.saludo();
		
		Animal animal2 = new Perro(); //upcasting 
		animal2.saludo();
		
		Animal animal3 = new PerroGrande();//upcasting 
		animal3.saludo();
		
		Perro perro2 = (Perro)animal2; //recupero el tipo del objeto, lo teniamos de tipo animal y lo bajamos a categoria perro
		
		PerroGrande perroGrande2 = (PerroGrande) animal3; //downcasting 
		
		Perro perro3 = (PerroGrande)animal3; //downcasting
		
		Gato gato2 = (Gato)animal1;
		
		perro2.saludo(perro3);
		perro3.saludo(perro2);
		perro2.saludo(perroGrande2);
		perroGrande2.saludo(perro2);
		perroGrande2.saludo(perroGrande1);
		}
	}
