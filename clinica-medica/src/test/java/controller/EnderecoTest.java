package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import model.Endereco;
import model.Estado;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnderecoTest {
	
	EnderecoDao enderecoDao = new EnderecoDao();

	@Order(1)
	@Test
	public void testCadastro() {

		Estado estado = new Estado();
		estado.setId(24);
		estado.setNome("Santa Catarina");
		estado.setUf("SC");

		Endereco endereco = new Endereco();
		endereco.setBairro("Poco Grande");
		endereco.setCep(89110111);
		endereco.setCidade("Gaspar");
		endereco.setEstado(estado);
		endereco.setRua("Rua Silvio Garzewski");

		boolean result = enderecoDao.InserirEndereco(endereco);
		
		assertTrue(result);
		
		Endereco end = enderecoDao.ConsultarEndereco(endereco);
		
		assertNotNull(end);
		assertEquals(endereco.getBairro(), end.getBairro());
	}
	
	@Order(2)
	@Test
	void testConsulta() {
		Endereco endereco = new Endereco();
		endereco.setCep(89110111);
		Endereco result = enderecoDao.ConsultarEndereco(endereco);	
		assertEquals(endereco.getCep(), result.getCep());
	}
	
	/*Não faz sentido, e nem sei  como roda, pq o metodo de consulta na aceita nada sendo passado por ele. 
	@Order(3)
	@Test
	void testConsultaEstadoCidade() {
		ArrayList<Estado> espera = new ArrayList<Estado>();

		Estado Acre = new Estado();
		Estado Alagoas = new Estado();
		Estado Amazonas = new Estado();
		Estado Amapa = new Estado();
		Estado Bahia = new Estado();
		Estado Ceara = new Estado();
		Estado DistritoFederal = new Estado();
		Estado EspiritoSanto = new Estado();
		Estado Goias = new Estado();
		Estado Maranhao = new Estado();
		Estado MinasGerais = new Estado();
		Estado MatoGrossoDoSul = new Estado();
		Estado MatoGrosso = new Estado();
		Estado Para = new Estado();
		Estado Paraiba = new Estado();
		Estado Pernambuco = new Estado();
		Estado Piaui = new Estado();
		Estado Parana = new Estado();
		Estado RioDeJaneiro = new Estado();
		Estado RioGrandeDoNorte = new Estado();
		Estado RioGrandeDoSul = new Estado();
		Estado Rondonia = new Estado();
		Estado Roraima = new Estado();
		Estado SantaCataina = new Estado();
		Estado Sergipe = new Estado();
		Estado SaoPaulo = new Estado();
		Estado Tocantins = new Estado();

		Acre.setId(1);
		Alagoas.setId(2);
		Amazonas.setId(3);
		Amapa.setId(4);
		Bahia.setId(5);
		Ceara.setId(6);
		DistritoFederal.setId(7);
		EspiritoSanto.setId(8);
		Goias.setId(9);
		Maranhao.setId(10);
		MinasGerais.setId(11);
		MatoGrossoDoSul.setId(12);
		MatoGrosso.setId(13);
		Para.setId(14);
		Paraiba.setId(15);
		Pernambuco.setId(16);
		Piaui.setId(17);
		Parana.setId(18);
		RioDeJaneiro.setId(19);
		RioGrandeDoNorte.setId(20);
		RioGrandeDoSul.setId(23);
		Rondonia.setId(21);
		Roraima.setId(22);
		SantaCataina.setId(24);
		Sergipe.setId(25);
		SaoPaulo.setId(26);
		Tocantins.setId(27);

		Acre.setNome("Acre");
		Alagoas.setNome("Alagoas");
		Amazonas.setNome("Amazonas");
		Amapa.setNome("Amapa");
		Bahia.setNome("Bahia");
		Ceara.setNome("Ceara");
		DistritoFederal.setNome("Distrito Federal");
		EspiritoSanto.setNome("Espirito Santo");
		Goias.setNome("Goias");
		Maranhao.setNome("Maranhao");
		MinasGerais.setNome("Minas Gerais");
		MatoGrossoDoSul.setNome("Mato Grosso do Sul");
		MatoGrosso.setNome("MatoGrosso");
		Para.setNome("Para");
		Paraiba.setNome("Paraiba");
		Pernambuco.setNome("Pernambuco");
		Piaui.setNome("Piaui");
		Parana.setNome("Parana");
		RioDeJaneiro.setNome("Rio de Janeiro");
		RioGrandeDoNorte.setNome("Rio Grande Do Norte");
		RioGrandeDoSul.setNome("Rio Grande Do Sul");
		Rondonia.setNome("Rondonia");
		Roraima.setNome("Roraima");
		SantaCataina.setNome("Santa Cataina");
		Sergipe.setNome("Sergipe");
		SaoPaulo.setNome("SaoPaulo");
		Tocantins.setNome("Tocantins");

		Acre.setUf("AC");
		Alagoas.setUf("AL");
		Amazonas.setUf("AM");
		Amapa.setUf("AP");
		Bahia.setUf("BA");
		Ceara.setUf("CE");
		DistritoFederal.setUf("DF");
		EspiritoSanto.setUf("ES");
		Goias.setUf("GO");
		Maranhao.setUf("MA");
		MinasGerais.setUf("MG");
		MatoGrossoDoSul.setUf("MS");
		MatoGrosso.setUf("MT");
		Para.setUf("PA");
		Paraiba.setUf("PB");
		Pernambuco.setUf("PE");
		Piaui.setUf("PI");
		Parana.setUf("PR");
		RioDeJaneiro.setUf("RJ");
		RioGrandeDoNorte.setUf("RN");
		RioGrandeDoSul.setUf("RS");
		Rondonia.setUf("RO");
		Roraima.setUf("RR");
		SantaCataina.setUf("SC");
		Sergipe.setUf("SE");
		SaoPaulo.setUf("SP");
		Tocantins.setUf("TO");

		espera.add(Acre);
		espera.add(Alagoas);
		espera.add(Amazonas);
		espera.add(Amapa);
		espera.add(Bahia);
		espera.add(Ceara);
		espera.add(DistritoFederal);
		espera.add(EspiritoSanto);
		espera.add(Goias);
		espera.add(Maranhao);
		espera.add(MinasGerais);
		espera.add(MatoGrossoDoSul);
		espera.add(MatoGrosso);
		espera.add(Para);
		espera.add(Paraiba);
		espera.add(Pernambuco);
		espera.add(Piaui);
		espera.add(Parana);
		espera.add(RioDeJaneiro);
		espera.add(RioGrandeDoNorte);
		espera.add(RioGrandeDoSul);
		espera.add(Rondonia);
		espera.add(Roraima);
		espera.add(SantaCataina);
		espera.add(Sergipe);
		espera.add(SaoPaulo);
		espera.add(Tocantins);
		

		ArrayList<Estado> result = enderecoDao.ConsultaEstadoCidade();
		assertEquals(espera, result);
	}*/
	
	@Order(3)
	@Test
	public void testRemove() {

		Endereco endereco = new Endereco();
	
	
		endereco.setCep(89110111);
	

		boolean result = enderecoDao.excluirEndereco(endereco);
		System.out.println(result);
		assertEquals(true, result);
	}
}
