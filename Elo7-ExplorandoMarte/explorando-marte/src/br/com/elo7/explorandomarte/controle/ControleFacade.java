package br.com.elo7.explorandomarte.controle;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.com.elo7.explorandomarte.dto.Planalto;
import br.com.elo7.explorandomarte.dto.Sonda;
import br.com.elo7.explorandomarte.exception.CamposInvalidosException;
import br.com.elo7.explorandomarte.exception.CoordenadaForaDoEixoDoPlanaltoException;

/**
 * 
 * @author Diego Armelin Cuciti
 * @since 04/11/2015 
 *
 * Classe responsável por:
 * - Processar os dados de entrada (criar planalto e a sonda);
 * - Para cada sonda informada, executar a classe responsável por processar os dados e executar as instruções; 
 * - Formatar e exibir a saída com as coordenadas de destino da sonda.
 */
public class ControleFacade {
	
	StringBuilder coordenadaDestino = new StringBuilder();

	JTextArea areaResult = new JTextArea();
	
	public String processarDados(String coordenadasPlanalto, String coordenadasSonda) {
		
		try {
			Planalto planalto = new Planalto(coordenadasPlanalto);
		
			String[] arraySonda = coordenadasSonda.split("\n");
	
			for (int i = 0; i < arraySonda.length; i++) {

				Sonda sonda = new Sonda(planalto, 
						arraySonda[i], arraySonda[i+1].replace(" ", ""));

				MovimentoSonda movimentoSonda = new MovimentoSonda();
				movimentoSonda.executarInstrucao(sonda);
				
				processarSaida(sonda);
				
				++i;
			}
			
			limparQuantidadeSondas();
			
			return String.valueOf(getCoordenadaDestino());
			
		} catch (CoordenadaForaDoEixoDoPlanaltoException ex)  {
			areaResult.setText(coordenadaDestino.toString());
			limparQuantidadeSondas();
			JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
		} catch (CamposInvalidosException ex) {
			areaResult.setText(coordenadaDestino.toString());
			limparQuantidadeSondas();
			JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
		} catch (NumberFormatException ex) {
			areaResult.setText(coordenadaDestino.toString());
			limparQuantidadeSondas();
			JOptionPane.showMessageDialog(null, "Coordenadas incorretas. Informar dados válidos para cada campo! \nExemplo: Planalto: 0 0 / Sondas: 0 0 N");
		} catch (ArrayIndexOutOfBoundsException ex) {
			areaResult.setText(coordenadaDestino.toString());
			limparQuantidadeSondas();
			JOptionPane.showMessageDialog(null, "Preencher todas as coordenadas separando os dados com espaços! \nExemplo: Planalto: 0 0 / Sondas: 0 0 N");
		}
		return null;
	}
	
	public String processarSaida(Sonda sonda) {
		coordenadaDestino.append(String.valueOf(sonda.getCoordenadaX() + " " 
			+ sonda.getCoordenadaY() + " " 
			+ sonda.getDirecaoAtual() + "\n")).toString();
		
		return coordenadaDestino.toString();
	}
	
	public void limparQuantidadeSondas() {
		Sonda.quantidadeSondas = 0;
	}
	
	public StringBuilder getCoordenadaDestino() {
		return coordenadaDestino;
	}

}
