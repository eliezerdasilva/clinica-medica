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

		boolean result = enderecoDao.inserirEndereco(endereco);
		
		assertTrue(result);
		
		Endereco end = enderecoDao.consultarEndereco(endereco);
		
		assertNotNull(end);
		assertEquals(endereco.getBairro(), end.getBairro());
	}
	
	@Order(2)
	@Test
	void testConsulta() {
		Endereco endereco = new Endereco();
		endereco.setCep(89110111);
		Endereco result = enderecoDao.consultarEndereco(endereco);	
		assertEquals(endereco.getCep(), result.getCep());
	}
	
	@Order(3)
	@Test
	void testConsultaEstadoCidade() {
		ArrayList<Estado> result = enderecoDao.ConsultaEstadoCidade();
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
	
	@Order(4)
	@Test
	public void testRemove() {

		Endereco endereco = new Endereco();
		endereco.setCep(89110111);
	
		boolean result = enderecoDao.excluirEndereco(endereco);
		assertEquals(true, result);
		
		Endereco end = enderecoDao.consultarEndereco(endereco);
		assertEquals(null, end);
	}
}
