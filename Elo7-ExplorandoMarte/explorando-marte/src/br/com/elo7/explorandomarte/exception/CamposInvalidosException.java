package br.com.elo7.explorandomarte.exception;

/**
 * @author Diego Armelin Cuciti
 * @since 01/11/2015
 *
 */

public class CamposInvalidosException extends Exception {

	public CamposInvalidosException() {
		super();
	}
	
	public CamposInvalidosException(String erro) {
		super(erro);
	}
}
