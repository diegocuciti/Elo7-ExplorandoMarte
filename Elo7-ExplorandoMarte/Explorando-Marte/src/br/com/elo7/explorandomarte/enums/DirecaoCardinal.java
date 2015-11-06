package br.com.elo7.explorandomarte.enums;

import br.com.elo7.explorandomarte.dto.Sonda;
import br.com.elo7.explorandomarte.interfaces.DirecaoCardinalSonda;

/**
 * @author Diego Armelin Cuciti
 * @since 31/10/2015
 * 
 * Responsável por manter as especificações e implementar as ações de cada Direção Cardinal em sua particularidade 
 */

public enum DirecaoCardinal implements DirecaoCardinalSonda {
	
	NORTH('N') {
		@Override
		public void alterarCoordenadas(Sonda coordenadasY) {
			coordenadasY.setCoordenadaY(coordenadasY.getCoordenadaY() + 1);
		}

		@Override
		public void recuperarDirecaoAtual(Sonda coordenadas) {
			if (coordenadas.getMovimentoAtual() == Instrucao.LEFT.getValor())
				coordenadas.setDirecaoAtual(DirecaoCardinal.WEST.codigoDirecaoCardinal);
			else 
				coordenadas.setDirecaoAtual(DirecaoCardinal.EAST.codigoDirecaoCardinal);
		}
	},
	
	SOUTH('S') {
		@Override
		public void alterarCoordenadas(Sonda coordenadasY) {
			coordenadasY.setCoordenadaY(coordenadasY.getCoordenadaY() - 1);
		}
		
		@Override
		public void recuperarDirecaoAtual(Sonda coordenadas) {
			if (coordenadas.getMovimentoAtual() == Instrucao.LEFT.getValor())
				coordenadas.setDirecaoAtual(DirecaoCardinal.EAST.codigoDirecaoCardinal);
			else 
				coordenadas.setDirecaoAtual(DirecaoCardinal.WEST.codigoDirecaoCardinal);
		}
	},
	
	EAST('E') {
		@Override
		public void alterarCoordenadas(Sonda coordenadasX) {
			coordenadasX.setCoordenadaX(coordenadasX.getCoordenadaX() + 1);
		}
		
		@Override
		public void recuperarDirecaoAtual(Sonda coordenadas) {
			if (coordenadas.getMovimentoAtual() == Instrucao.LEFT.getValor())
				coordenadas.setDirecaoAtual(DirecaoCardinal.NORTH.codigoDirecaoCardinal);
			else 
				coordenadas.setDirecaoAtual(DirecaoCardinal.SOUTH.codigoDirecaoCardinal);
		}
	},
	
	WEST('W') {
		@Override
		public void alterarCoordenadas(Sonda coordenadasX) {
			coordenadasX.setCoordenadaX(coordenadasX.getCoordenadaX() - 1);
		}
	
		@Override
		public void recuperarDirecaoAtual(Sonda coordenadas) {
			if (coordenadas.getMovimentoAtual() == Instrucao.LEFT.getValor())
				coordenadas.setDirecaoAtual(DirecaoCardinal.SOUTH.codigoDirecaoCardinal);
			else 
				coordenadas.setDirecaoAtual(DirecaoCardinal.NORTH.codigoDirecaoCardinal);
		}
	};

	private char codigoDirecaoCardinal;
	
	private DirecaoCardinal(char direcaoCardinal) {
		this.codigoDirecaoCardinal = direcaoCardinal;
	}

	public char getCodigoDirecaoCardinal() {
		return codigoDirecaoCardinal;
	}

}
