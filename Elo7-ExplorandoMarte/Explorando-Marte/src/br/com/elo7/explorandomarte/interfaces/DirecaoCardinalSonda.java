package br.com.elo7.explorandomarte.interfaces;

import br.com.elo7.explorandomarte.dto.Sonda;

/**
 * @author Diego Armelin Cuciti
 * @since 31/10/2015
 * 
 */
public interface DirecaoCardinalSonda {

	// Alterar os valores das coordenadas X-Y da sonda
	public void alterarCoordenadas(Sonda coordenadas);
	
	// Recuperar direção atual, através do movimento atual da instrução
	public void recuperarDirecaoAtual(Sonda coordenadas);

}
