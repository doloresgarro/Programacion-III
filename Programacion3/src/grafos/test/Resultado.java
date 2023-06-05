package grafos.test;

import prog3.listagenerica.*;

public class Resultado {
	private ListaGenerica<String> camino;
	private int montoSobrante;
	
	public Resultado() {
		camino = new ListaGenericaEnlazada<String>();
		montoSobrante = 0;
	}

	public ListaGenerica<String> getCamino() {
		return camino;
	}

	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}

	public int getMontoSobrante() {
		return montoSobrante;
	}

	public void setMontoSobrante(int montoSobrante) {
		this.montoSobrante = montoSobrante;
	}
	
}
