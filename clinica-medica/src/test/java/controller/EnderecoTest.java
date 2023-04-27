package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Endereco;

class EnderecoTest {

	@Test
	void testCadastro() {
		Endereco endereco = new Endereco();
		EnderecoDao enderecoDao = new EnderecoDao();
		boolean result = enderecoDao.InserirEndereco(endereco);
		assertEquals(true, result);
	}
	
	@Test
	void testConsulta() {
		
	}

	@Test
	void testConsultaEstadoCidade() {
		
	}
}
