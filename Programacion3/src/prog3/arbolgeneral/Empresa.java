package prog3.arbolgeneral;

//import prog3.arbol.*;
import prog3.listagenerica.*;
import prog3.util.ColaGenerica;

public class Empresa {
	private ArbolGeneral<Empleado> empleados;

	public Empresa() {
		
	}
	

	
	public int empleadosPorCategoria(int categoria) {
		
		ArbolGeneral <Empleado> arbolAux = null;
		ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica<ArbolGeneral<Empleado>>();
		cola.encolar(this.empleados); //encola la raiz
		cola.encolar(null); //encola null porq termina el nivel
		int cant = 0;
		
		while (!cola.esVacia()) {
			arbolAux = cola.desencolar();
			if (arbolAux != null) {
				System.out.println(arbolAux.getDato());
				
				//si es de esa categoria cuenta 
				if (arbolAux.getDato().getCategoria() == categoria)
					cant ++;
				
				//pregunto si tiene hijos, si tiene creo lista de hijos y los encolo
				if (arbolAux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = arbolAux.getHijos();
					hijos.comenzar();
					while (!hijos.fin())
						cola.encolar(hijos.proximo());
				}
			}
			else { //se termino el nivel
				if ( !cola.esVacia()) {
					System.out.println();
					cola.encolar(null);
				}
			}
				
		}
		return cant;
	}
	
	public int categoriaConMasEmpleados() {
		ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> aux;
		cola.encolar(this.empleados) ; // encolo raiz 
		cola.encolar(null); 
		
		int cantMax = 0, categoriaMax = 0, cant = 0,  nivel = 0;  
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			// si es distinto de null, sigue en el mismo nivel
			if (aux != null) {
				cant ++; // cuenta empleado 
				//si tiene hijos, hago lista de hijos y los encolo
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
					cola.encolar(null);
				}
			}
			else if (!cola.esVacia()) {
				if (cantMax < cant) {
					cantMax = cant; 
					categoriaMax = nivel;
				}
			nivel ++; //si llega hasta aca cambia de nivel 
			cant = 0; // inicializo cant para proximo nivel
			cola.encolar(null); //termino el nivel 
			}
			
		}	
		return categoriaMax;
	}
	
	
	public int cantidadTotalDeEmpleados() {
		ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> aux;
		cola.encolar(this.empleados); //encolo raiz
		cola.encolar(null); //encolo null para indicar que termino el primer nivel 
		int cant = 0;
		
		while (! cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) { // sigue en el mismo nivel
				cant ++; //si es distinto de null es un empleado
				
				// si tiene hijos los tengo que encolar
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			}
			//si aux = null es porq termino el nivel, encolo null para saber que cambio
			else {
				System.out.println(" ");
				cola.encolar(null);
			}		
		}
		return cant;
	}
	
	
	
	// VERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
	 public void reemplazarPresidente() {
	        ArbolGeneral<Empleado> aux = this.empleados;

	        if (aux.esHoja()) {
	            aux = null;
	        }

	        while (true) {
	            ArbolGeneral<Empleado> empAsciende = aux.getHijos().elemento(0);
	            for (int i = 1; i<aux.getHijos().tamanio(); i++) {
	                if (empAsciende.getDato().getAntiguedad() < aux.getHijos().elemento(i).getDato().getAntiguedad()) {
	                    empAsciende = aux.getHijos().elemento(i);
	                }
	            }
	            empAsciende.getDato().setCategoria(empAsciende.getDato().getCategoria() - 1);
	            aux.setDato(empAsciende.getDato());
	            if (empAsciende.esHoja()) {
	                aux.eliminarHijo(empAsciende);
	                break;
	            }
	            aux = empAsciende;
	        }
	    }
	
	
}
