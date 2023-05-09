package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import model.Funcionario;
import model.Usuario;
import model.Endereco;
import model.Estado;

class FuncionarioTest {

	private static final LocalDate data = LocalDate.now();
	FuncionarioDao funcionarioDao = new FuncionarioDao();
	UsuarioDao usuarioDao = new UsuarioDao();

	@Test
	void testConsulta() {

	}

	@Test
	void testCadastro() {
		Funcionario func = new Funcionario();
		Usuario user = new Usuario();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		estado.setId(2);
		endereco.setEstado(estado);
		endereco.setBairro("gaspar");
		endereco.setCep(89112555);
		endereco.setCidade("Gaspar");
		endereco.setCep(123546);
		endereco.setRua("rua gaspar");
		func.setEndereco(endereco);
		user.setNivelAcesso(1);
		user.setSenha("1234");
		user.setUsuario("Funcionario");
		
		usuarioDao.inserirUsuario(user);
		Usuario usuario = usuarioDao.selecionarUSuarioParaCadastrar(user);
		func.setNome("Joao");
		func.setCpf(Long.valueOf(123456789));
		func.setNumero(912345678);
		func.setSexo("M");
		func.setTelefone("9 1234-5678");
		func.setUsuario(usuario);
		func.setComplemento("Amigo do dono");
		func.setEmail("default@gmail.com");
		func.setDataNascimento(data);
		func.setNumero(27);
		func.setEndereco(endereco);
		
	
		
	
		boolean resposta = funcionarioDao.cadastrarFuncionario(func);

		assertTrue(resposta);
	}

	@Test
	void testAlterar() {
//		Funcionario func = new Funcionario();
//		func.setNome("Joao");
//		func.setCpf(Long.valueOf(123456789));
//		func.setNumero(912345678);
//		func.setSexo("M");
//		func.setTelefone("9 1234-5678");
//		
//	
//		boolean resposta = funcionarioDao.alterarFuncionario(func);
//
//		assertTrue(resposta);
	}

	@Test
	void testExcluir() {
		Funcionario func = new Funcionario();
		func.setNome("Elezer");
		func.setCpf(Long.valueOf(123456789));
		func.setNumero(912345678);
		func.setSexo("M");
		func.setTelefone("9 1234-5678");
		
	
		boolean resposta = funcionarioDao.excluirFuncionario(func);

		assertTrue(resposta);
	}

}
