package br.com.elo7.explorandomarte.tela;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import br.com.elo7.explorandomarte.controle.ControleFacade;

/**
 * @author Diego Armelin Cuciti
 * @since 04/11/2015
 * 
 * Tela desenvolvida para processar os dados de entrada/saída
 *
 */
public class ExplorandoMarteTela extends JFrame {
	
	// Area de input/output
	JTextArea areaPlanalto;
	JTextArea areaSonda;
	JTextArea areaResult;
	// Labels
	JLabel labelPlanalto;
	JLabel labelSondas;
	JLabel labelDestino;
	// Botões
	JButton botaoExecutar;
	JButton botaoLimparTela;
	
	Border border = BorderFactory.createLineBorder(Color.GRAY);

	public ExplorandoMarteTela() {
		super("EXPLORANDO MARTE");
		Container contentPane = getContentPane();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		contentPane.setLayout(layout);
		
		// Area de entrada de dados - Planalto
		configurarAreaPlanalto();
		
		// Area de entrada de dados - Sondas
		configurarAreaSonda();
		
		// Area de saida de dados - Destino da Sonda
		configurarAreaSaidaSonda();
		
		// Executar ação do botão que irá processar os dados de entrada/saída 
		botaoExecutar = new JButton("Executar");
		executarControleDados();
		
		// Executar ação do botão que irá limpar a tela e limpar a quantidade de sondas 
		botaoLimparTela = new JButton("Limpar");
		limparDados();
		
		adicionarComponentesNoContainer(contentPane);

		configurarContentPane(contentPane);
	}
	
	public void configurarContentPane(Container contentPane) {
		setSize(235, 520);
		setVisible(true);
		setResizable(false);
		contentPane.setBackground(Color.LIGHT_GRAY);
		super.setLocationRelativeTo(null);
	}
	
	public void configurarAreaPlanalto() {
		labelPlanalto = new JLabel("Coordenadas Planalto");
		areaPlanalto = new JTextArea(0, 15);
		areaPlanalto.setBorder(border);
		areaPlanalto.setBackground(Color.YELLOW);
		areaPlanalto.setFont(new Font("Verdana", Font.BOLD, 13));
	}
	
	public void configurarAreaSonda() {
		
		labelSondas = new JLabel("Coordenadas Sondas");
		areaSonda = new JTextArea(10, 15);
		areaSonda.setBorder(border);
		areaSonda.setBackground(Color.YELLOW);
		areaSonda.setFont(new Font("Verdana", Font.BOLD, 13));
	}
	
	public void configurarAreaSaidaSonda() {
		labelDestino = new JLabel("Coordenadas de destino");
		areaResult = new JTextArea(10, 15);
		areaResult.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.GRAY));
		areaResult.setBackground(Color.BLACK);
		areaResult.setFont(new Font("Verdana", Font.BOLD, 13));
		areaResult.setEnabled(false);
	}
	
	public void adicionarComponentesNoContainer(Container contentPane) {
		contentPane.add(labelPlanalto);
		contentPane.add(areaPlanalto);
	
		contentPane.add(labelSondas);
		contentPane.add(areaSonda);
		contentPane.add(new JScrollPane(areaSonda));
	
		contentPane.add(botaoExecutar);
		contentPane.add(botaoLimparTela);

		contentPane.add(labelDestino);
		contentPane.add(new JScrollPane(areaResult));
	}
	
	/**
	 * Executar 'método: processarDados - classe: ControleFacade' enviando os dados informados em tela
	 */
	public void executarControleDados() {
		botaoExecutar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				ControleFacade controle = new ControleFacade();
				controle.processarDados(areaPlanalto.getText(), areaSonda.getText(), areaResult);
			}
		});
	}
	
	/**
	 * Limpar os dados da tela para a realização de uma nova consulta
	 */
	public void limparDados() {
		botaoLimparTela.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				areaPlanalto.setText(null);
				areaSonda.setText(null);
				areaResult.setText(null);
				
				ControleFacade controle = new ControleFacade();
				controle.limparQuantidadeSondas();
			}
		});
	}

	public static void main(String args[]) {
		ExplorandoMarteTela explorandoMarteTela = new ExplorandoMarteTela();
		explorandoMarteTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
