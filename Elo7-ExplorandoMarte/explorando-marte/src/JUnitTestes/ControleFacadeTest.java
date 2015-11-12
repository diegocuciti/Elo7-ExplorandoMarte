package JUnitTestes;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo7.explorandomarte.controle.ControleFacade;
import br.com.elo7.explorandomarte.dto.Planalto;
import br.com.elo7.explorandomarte.exception.CamposInvalidosException;
import br.com.elo7.explorandomarte.exception.CoordenadaForaDoEixoDoPlanaltoException;
import junit.framework.TestCase;

public class ControleFacadeTest extends TestCase {
	
	@Test()
	public void testProcessarDadosUmaSondaComSucesso() throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {
		String saidaEsperada = ("1 3 N\n");
		
		String planalto = ("5 5");
		String coordenadas = ("1 2 N\nLMLMLMLMM");
		
		ControleFacade controle = new ControleFacade();
		String retorno = controle.processarDados(planalto, coordenadas);
		
		assertEquals(saidaEsperada, retorno);
	}
	
	@Test()
	public void testProcessarDadosListaSondaComSucesso() throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {
		String saidaEsperada = ("1 3 N\n5 1 E\n");
		
		String planalto = ("5 5");
		String coordenadas = ("1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");
		
		ControleFacade controle = new ControleFacade();
		String retorno = controle.processarDados(planalto, coordenadas);
		
		assertEquals(saidaEsperada, retorno);
	}
	
	@Test()
	public void testProcessarDadosUmaSondaComErro() throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {
		String saidaEsperada = ("1 3 N");
		
		String planalto = ("5 5");
		String coordenadas = ("1 2 N\nLMLMLMLM");
		
		ControleFacade controle = new ControleFacade();
		String retorno = controle.processarDados(planalto, coordenadas);
		
		Assert.assertNotEquals(saidaEsperada, retorno);
	}
	
	@Test()
	public void testProcessarDadosListaSondaComErro() throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {
		String saidaEsperada = ("1 3 N\n5 1 N");
		
		String planalto = ("5 5");
		String coordenadas = ("1 2 N\nLMLMLMLMM\n3 3 S\nMMRMMRMRRM");
		
		ControleFacade controle = new ControleFacade();
		String retorno = controle.processarDados(planalto, coordenadas);
		
		Assert.assertNotEquals(saidaEsperada, retorno);
	}
	
	@Test()
	public void testRecuperarPlanaltoComSucesso() {
		int saidaEsperadaPlanaltoX = (5);
		int saidaEsperadaPlanaltoY = (5);
		
		String planalto = ("5 5");
		
		Planalto planaltoRetorno = new Planalto(planalto);
		
		assertEquals(saidaEsperadaPlanaltoX, planaltoRetorno.getCoordenadaPontoSuperiorX());
		assertEquals(saidaEsperadaPlanaltoY, planaltoRetorno.getCoordenadaPontoSuperiorY());
	}
}
