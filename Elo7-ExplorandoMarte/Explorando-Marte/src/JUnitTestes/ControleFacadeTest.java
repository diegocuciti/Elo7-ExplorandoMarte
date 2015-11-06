package JUnitTestes;

import javax.swing.JTextArea;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo7.explorandomarte.controle.ControleFacade;
import br.com.elo7.explorandomarte.dto.Planalto;
import junit.framework.TestCase;

public class ControleFacadeTest extends TestCase {
	
	@Test()
	public void testProcessarDadosUmaSondaComSucesso() {
		String saidaEsperada = ("1 3 N\n");
		
		String planalto = ("5 5");
		String coordenadas = ("1 2 N\nLMLMLMLMM\n");
		JTextArea area = new JTextArea();
		
		ControleFacade controle = new ControleFacade();
		String retorno = controle.processarDados(planalto, coordenadas, area);
		
		assertEquals(saidaEsperada, retorno);
	}
	
	@Test()
	public void testProcessarDadosListaSondaComSucesso() {
		String saidaEsperada = ("1 3 N\n5 1 E\n");
		
		String planalto = ("5 5");
		String coordenadas = ("1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");
		JTextArea area = new JTextArea();
		
		ControleFacade controle = new ControleFacade();
		String retorno = controle.processarDados(planalto, coordenadas, area);
		
		assertEquals(saidaEsperada, retorno);
	}
	
	@Test()
	public void testProcessarDadosUmaSondaComErro() {
		String saidaEsperada = ("1 3 N");
		
		String planalto = ("5 5");
		String coordenadas = ("1 2 N\nLMLMLMLM");
		JTextArea area = new JTextArea();
		
		ControleFacade controle = new ControleFacade();
		String retorno = controle.processarDados(planalto, coordenadas, area);
		
		Assert.assertNotEquals(saidaEsperada, retorno);
	}
	
	@Test()
	public void testProcessarDadosListaSondaComErro() {
		String saidaEsperada = ("1 3 N\n5 1 N");
		
		String planalto = ("5 5");
		String coordenadas = ("1 2 N\nLMLMLMLMM\n3 3 \nMMRMMRMRRM");
		JTextArea area = new JTextArea();
		
		ControleFacade controle = new ControleFacade();
		String retorno = controle.processarDados(planalto, coordenadas, area);
		
		Assert.assertNotEquals(saidaEsperada, retorno);
	}
	
	@Test
	public void testRecuperarPlanaltoComSucesso() {
		int saidaEsperadaPlanaltoX = (5);
		int saidaEsperadaPlanaltoY = (5);
		
		String planalto = ("5 5");
		
		ControleFacade controleFacade = new ControleFacade();
		Planalto planaltoRetorno = controleFacade.recuperarPlanalto(planalto);
		
		assertEquals(saidaEsperadaPlanaltoX, planaltoRetorno.getCoordenadaPontoSuperiorX());
		assertEquals(saidaEsperadaPlanaltoY, planaltoRetorno.getCoordenadaPontoSuperiorY());
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testArrayIndexOutOfBoundsExceptionComSucesso() throws ArrayIndexOutOfBoundsException {
		
		String planalto = ("5 ");
		String coordenadas = ("1 2 N\nLMLMLMLMM\n");
		JTextArea area = new JTextArea();
		
		ControleFacade controle = new ControleFacade();
		controle.processarDados(planalto, coordenadas, area);
	}
}
