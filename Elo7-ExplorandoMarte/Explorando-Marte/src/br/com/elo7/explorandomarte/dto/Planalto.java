package br.com.elo7.explorandomarte.dto;

/**
 * @author Diego Armelin Cuciti
 * @since 31/10/2015 
 * 
 */

public class Planalto {
	
	private int coordenadaPontoInferiorX = 0;
	private int coordenadaPontoInferiorY = 0;
	private int coordenadaPontoSuperiorX;
	private int coordenadaPontoSuperiorY;
	
	public Planalto(int coordenadaPontoSuperiorX,
			int coordenadaPontoSuperiorY) {
		super();
		this.coordenadaPontoSuperiorX = coordenadaPontoSuperiorX;
		this.coordenadaPontoSuperiorY = coordenadaPontoSuperiorY;
	}

	public int getCoordenadaPontoInferiorX() {
		return coordenadaPontoInferiorX;
	}

	public int getCoordenadaPontoInferiorY() {
		return coordenadaPontoInferiorY;
	}

	public int getCoordenadaPontoSuperiorX() {
		return coordenadaPontoSuperiorX;
	}

	public int getCoordenadaPontoSuperiorY() {
		return coordenadaPontoSuperiorY;
	}
}
