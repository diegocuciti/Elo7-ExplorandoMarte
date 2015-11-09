package br.com.elo7.explorandomarte.enums;

/**
 * @author Diego Armelin Cuciti
 * @since 31/10/2015
 *
 * Respons�vel por especificar as instru��es v�lidas para cada sonda informada
 */

public enum InstrucaoMovimento {

	LEFT('L'),
	
	RIGHT('R'),
	
	MOVE('M');
	
	private char valor;
	
	private InstrucaoMovimento(char valor) {
		this.valor = valor;
	}

	public char getValor() {
		return valor;
	}
}
