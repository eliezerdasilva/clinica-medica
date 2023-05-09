package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import model.Funcionario;

class FuncionarioTest {

	private static final LocalDate LocalDate = null;
	FuncionarioDao funcionarioDao = new FuncionarioDao();

	@Test
	void testConsulta() {

	}

	@Test
	void testCadastro() {
		Funcionario func = new Funcionario();
		func.setNome("Joao");
		func.setCpf(Long.valueOf(123456789));
		func.setNumero(912345678);
		func.setSexo("M");
		func.setTelefone("9 1234-5678");
		
	
		boolean resposta = funcionarioDao.cadastrarFuncionario(func);

		assertTrue(resposta);
	}

	@Test
	void testExcluir() {

	}

	@Test
	void testAlterar() {

	}

}
