package br.com.elo7.explorandomarte.controle;

import br.com.elo7.explorandomarte.dto.Sonda;
import br.com.elo7.explorandomarte.enums.DirecaoCardinal;
import br.com.elo7.explorandomarte.enums.InstrucaoMovimento;
import br.com.elo7.explorandomarte.exception.CamposInvalidosException;
import br.com.elo7.explorandomarte.exception.CoordenadaForaDoEixoDoPlanaltoException;

/**
 * @author Diego Armelin Cuciti
 * @since 31/10/2015
 *
 *        Respons�vel por executar as instru��es de cada sonda informada,
 *        validando regras funcionais.
 */
public class MovimentoSonda {

	public Sonda executarInstrucao(Sonda sonda)
			throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {

		// Validar tamanho das coordenadas X-Y de entrada da sonda
		validarEixoCoordenadasSondaPlanalto(sonda);

		for (int i = 0; i < sonda.getInstrucaoMovimentos().length(); i++) {

			validarMovimentoAtual(i, sonda);

			if (i == 0) {
				sonda.setDirecaoAnterior(sonda.getDirecaoCardinalInicial());
				sonda.setDirecaoAtual(sonda.getDirecaoCardinalInicial());
			} else {
				sonda.setDirecaoAnterior(sonda.getDirecaoAtual());
			}

			if (sonda.getMovimentoAtual() != InstrucaoMovimento.MOVE.getValor()) {
				buscarDirecaoAtual(sonda);
			} else {
				atribuirCoordenadasSonda(sonda);
				// Validar tamanho das coordenadas X-Y da instru��o atual da
				// sonda
				validarEixoCoordenadasSondaPlanalto(sonda);
			}

			sonda.setDirecaoAnterior(sonda.getDirecaoAtual());
		}
		return sonda;
	}

	// Realizar manuten��o nas coordenadas X-Y da sonda
	public Sonda atribuirCoordenadasSonda(Sonda sonda) throws CamposInvalidosException {
		
		try {
			DirecaoCardinal.find(sonda.getDirecaoAtual()).alterarCoordenadas(sonda);
		} catch (CamposInvalidosException e) {
			throw new CamposInvalidosException(
					"Sonda " + sonda.getQuantidadeSondas() + " possui Dire��o Cardinal inv�lida.");
		}
		return sonda;
	}

	// Buscar a dire��o atual, atrav�s do movimento de instru��o atual
	public Sonda buscarDirecaoAtual(Sonda sonda) throws CamposInvalidosException {

		try {
			DirecaoCardinal.find(sonda.getDirecaoAnterior()).recuperarDirecaoAtual(sonda);
		} catch (CamposInvalidosException e) {
			throw new CamposInvalidosException(
					"Sonda " + sonda.getQuantidadeSondas() + " possui Dire��o Cardinal inv�lida.");
		}
		return sonda;
	}

	// Validar se as coordenadas X-Y da sonda s�o v�lidas, com base nas
	// coordenadas do ponto inferior-esquerdo e
	// superior-direito do planalto
	public void validarEixoCoordenadasSondaPlanalto(Sonda sonda) throws CoordenadaForaDoEixoDoPlanaltoException {

		if ((sonda.getCoordenadaX() < sonda.getPlanalto().getCoordenadaPontoInferiorX())
				|| (sonda.getCoordenadaX() > sonda.getPlanalto().getCoordenadaPontoSuperiorX()))
			tratarMensagemErro('X', sonda);
		else if ((sonda.getCoordenadaY() < sonda.getPlanalto().getCoordenadaPontoInferiorY())
				|| (sonda.getCoordenadaY() > sonda.getPlanalto().getCoordenadaPontoSuperiorY()))
			tratarMensagemErro('Y', sonda);
	}

	public void tratarMensagemErro(char coordenada, Sonda sonda) throws CoordenadaForaDoEixoDoPlanaltoException {
		throw new CoordenadaForaDoEixoDoPlanaltoException("Sonda " + sonda.getQuantidadeSondas()
				+ " estourou o limite do eixo " + coordenada
				+ " do planalto e n�o foi processada por completo. \nAs pr�ximas sondas n�o seram processadas!");
	}

	public void validarMovimentoAtual(int i, Sonda sonda) throws CamposInvalidosException {
		sonda.setMovimentoAtual(sonda.getInstrucaoMovimentos().charAt(i));

		if ((sonda.getMovimentoAtual() != InstrucaoMovimento.MOVE.getValor())
				&& (sonda.getMovimentoAtual() != InstrucaoMovimento.LEFT.getValor())
				&& (sonda.getMovimentoAtual() != InstrucaoMovimento.RIGHT.getValor())) {
			throw new CamposInvalidosException("Sonda " + sonda.getQuantidadeSondas()
					+ " possui instru��o de movimento inv�lida. Movimento de instru��o: " + sonda.getMovimentoAtual()
					+ " � uma instru��o inv�lida. \nInstru��es v�lidas: L R M ");
		}
	}
}
