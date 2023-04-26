package Practica2B;

import java.util.Scanner;
public class EjercicioTestSobreescritura {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;

        System.out.println("Ingrese marca: ");
        String marca = in.next();
        System.out.println("Ingrese sistema Operativo: ");
        String sisOp = in.next();
        System.out.println("Ingrese modelo: ");
        String modelo = in.next();
        System.out.println("Ingrese costo: ");
        int costo = in.nextInt();
        System.out.println("Ingrese pulgadas: ");
        float pulgadas = in.nextFloat();
        System.out.println("Ingrese numero: ");
        int numero = in.nextInt();

        Tablet2 t1 = new Tablet2 (marca, sisOp, modelo, costo, pulgadas);
        Smartphone s = new Smartphone(marca, sisOp, modelo, costo, numero);

        System.out.println(t1.devolverDatosTablet()) ; 
        System.out.println(s.devolverDatosSmarphone()) ; 
        
        
        System.out.println("Ingrese marca: ");
        String marca2 = in.next();
        System.out.println("Ingrese sistema Operativo: ");
        String sisOp2 = in.next();
        System.out.println("Ingrese modelo: ");
        String modelo2 = in.next();
        System.out.println("Ingrese costo: ");
        int costo2 = in.nextInt();
        System.out.println("Ingrese numero: ");
        int numero2 = in.nextInt();
        
  
        
        Smartphone s2 = new Smartphone(marca2, sisOp2, modelo2, costo2, numero2);
        System.out.println(s2.devolverDatosSmarphone()) ; 
        

        System.out.println(s.equals(s2));

        
        in.close();
     

	}

}
