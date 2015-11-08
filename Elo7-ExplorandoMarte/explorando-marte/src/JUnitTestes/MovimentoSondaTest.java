package JUnitTestes;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo7.explorandomarte.controle.MovimentoSonda;
import br.com.elo7.explorandomarte.dto.Planalto;
import br.com.elo7.explorandomarte.dto.Sonda;
import br.com.elo7.explorandomarte.exception.CamposInvalidosException;
import br.com.elo7.explorandomarte.exception.CoordenadaForaDoEixoDoPlanaltoException;
import junit.framework.TestCase;

public class MovimentoSondaTest extends TestCase {
	
	@Test
	public void testAtribuirCoordenadasComSucesso() throws CamposInvalidosException {
		int saidaEsperadaX = (1);
		int saidaEsperadaY = (3);
		
		Planalto planalto = new Planalto(5, 5);
		String coordenadas = ("1 2 N\nM");
		Sonda sonda = new Sonda(planalto, coordenadas, coordenadas);
		sonda.setDirecaoAtual('N');
		
		MovimentoSonda movimentoSonda = new MovimentoSonda();
		Sonda retorno = movimentoSonda.atribuirCoordenadasSonda(sonda);
		
		assertEquals(saidaEsperadaX, retorno.getCoordenadaX());
		assertEquals(saidaEsperadaY, retorno.getCoordenadaY());
	}
	
	@Test
	public void testAtribuirCoordenadasComErro() throws CamposInvalidosException {
		int saidaEsperadaX = (1);
		int saidaEsperadaY = (3);
		
		Planalto planalto = new Planalto(5, 5);
		String coordenadas = ("1 2 N\nM");
		Sonda sonda = new Sonda(planalto, coordenadas, coordenadas);
		sonda.setDirecaoAtual('N');
		
		MovimentoSonda movimentoSonda = new MovimentoSonda();
		Sonda retorno = movimentoSonda.atribuirCoordenadasSonda(sonda);
		
		assertEquals(saidaEsperadaX, retorno.getCoordenadaX());
		assertEquals(saidaEsperadaY, retorno.getCoordenadaY());
	}
	
	@Test
	public void testBuscarDirecaoComSucesso() throws CamposInvalidosException {
		char saidaEsperada = ('E');
		
		Planalto planalto = new Planalto(5, 5);
		String coordenadas = ("1 2 N\nR");
		Sonda sonda = new Sonda(planalto, coordenadas, coordenadas);
		sonda.setDirecaoAnterior('N');
		
		MovimentoSonda movimentoSonda = new MovimentoSonda();
		Sonda retorno = movimentoSonda.buscarDirecaoAtual(sonda);
		
		assertEquals(saidaEsperada, retorno.getDirecaoAtual());
	}
	
	@Test
	public void testValidarEixoCoordenadasSondaPlanaltoComSucesso() throws CoordenadaForaDoEixoDoPlanaltoException {
		Planalto planalto = new Planalto(5, 5);
		String coordenadas = ("1 2 N\nM");
		Sonda sonda = new Sonda(planalto, coordenadas, coordenadas);
		
		MovimentoSonda movimentoSonda = new MovimentoSonda();
		movimentoSonda.validarEixoCoordenadasSondaPlanalto(sonda);
		
		assertFalse(false);
	}
	
	@Test
	public void testExecutarInstrucaoSondaComSucesso() throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {
		int saidaEsperadaX = (1);
		int saidaEsperadaY = (3);
		char saidaEsperadaDirecaoCardinal = ('N');
		
		Planalto planalto = new Planalto(5, 5);
		String coordenadas = ("1 2 N\n");
		String instrucao = ("LMLMLMLMM");
		Sonda sonda = new Sonda(planalto, coordenadas, instrucao);
		
		MovimentoSonda movimentoSonda = new MovimentoSonda();
		Sonda retorno = movimentoSonda.executarInstrucao(sonda);
		
		assertEquals(saidaEsperadaX, retorno.getCoordenadaX());
		assertEquals(saidaEsperadaY, retorno.getCoordenadaY());
		assertEquals(saidaEsperadaDirecaoCardinal, retorno.getDirecaoAtual());
	}
	
	@Test
	public void testExecutarInstrucaoSondaComErro() throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {
		int saidaEsperadaX = (1);
		int saidaEsperadaY = (3);
		char saidaEsperadaDirecaoCardinal = ('N');
		
		Planalto planalto = new Planalto(5, 5);
		String coordenadas = ("1 2 N\n");
		String instrucao = ("RMMM");
		Sonda sonda = new Sonda(planalto, coordenadas, instrucao);
		
		MovimentoSonda movimentoSonda = new MovimentoSonda();
		Sonda retorno = movimentoSonda.executarInstrucao(sonda);
		
		Assert.assertNotEquals(saidaEsperadaX, retorno.getCoordenadaX());
		Assert.assertNotEquals(saidaEsperadaY, retorno.getCoordenadaY());
		Assert.assertNotEquals(saidaEsperadaDirecaoCardinal, retorno.getDirecaoAtual());
	}
}
