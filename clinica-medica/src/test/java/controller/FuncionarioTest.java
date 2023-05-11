package controller;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.google.protobuf.Method;

import model.Funcionario;
import model.Usuario;
import model.Endereco;
import model.Estado;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FuncionarioTest {

	private static final LocalDate data = LocalDate.now();
	
	
	FuncionarioDao funcionarioDao = new FuncionarioDao();
	UsuarioDao usuarioDao = new UsuarioDao();
	

	@Test
	@Order(1)
	public void testCadastro() {
		Funcionario func = new Funcionario();
		Usuario user = new Usuario();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		
		estado.setId(2);
		endereco.setCep(89110000);
		func.setEndereco(endereco);
		user.setNivelAcesso(1);
		user.setSenha("1234");
		user.setUsuario("Funcionario");
		
		usuarioDao.inserirUsuario(user);
		Usuario usuario = usuarioDao.selecionarUSuarioParaCadastrar(user);
		func.setNome("joao");
		func.setCpf(Long.valueOf(12345678998l));
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
	@Order(2)
	@Test
	public void testConsulta() {
		Funcionario func = new Funcionario();
		Usuario user = new Usuario();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		
		estado.setId(2);
		endereco.setCep(89110000);
		func.setEndereco(endereco);
		user.setNivelAcesso(1);
		user.setSenha("1234");
		user.setUsuario("Funcionario");
		
		
		func.setNome("Joao");
		func.setCpf(Long.valueOf(12345678989l));
		func.setNumero(912345678);
		func.setSexo("M");
		func.setTelefone("9 1234-5678");
		func.setUsuario(user);
		func.setComplemento("Amigo do dono");
		func.setEmail("default@gmail.com");
		func.setDataNascimento(data);
		func.setNumero(27);
		func.setEndereco(endereco);
		
		Funcionario resposta = funcionarioDao.consultarFuncionario(func);
		System.out.println(func.getNome());
		System.out.println(resposta.getNome());
		assertEquals(func.getNome(), resposta.getNome()); 
		
	}
	@Order(3)
	@Test
	public void testAlterar() {
		Funcionario func = new Funcionario();
		Usuario user = new Usuario();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		
		estado.setId(2);
		endereco.setCep(89110000);
		func.setEndereco(endereco);
		user.setNivelAcesso(1);
		user.setSenha("1234");
		user.setUsuario("Funcionario");
		
		usuarioDao.inserirUsuario(user);
		Usuario usuario = usuarioDao.selecionarUSuarioParaCadastrar(user);
		func.setNome("ELIEZER");
		func.setCpf(Long.valueOf(12345678998l));
		func.setNumero(912345678);
		func.setSexo("M");
		func.setTelefone("9 1234-5678");
		func.setUsuario(usuario);
		func.setComplemento("Amigo do dono");
		func.setEmail("default@gmail.com");
		func.setDataNascimento(data);
		func.setNumero(27);
		func.setEndereco(endereco);
		
	
		boolean resposta = funcionarioDao.alterarFuncionario(func);

		assertTrue(resposta);
	}
	@Order(4)
	@Test
	public void testExcluir() {
		Funcionario func = new Funcionario();
		Usuario user = new Usuario();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		
		estado.setId(2);
		endereco.setCep(89110000);
		func.setEndereco(endereco);
		user.setNivelAcesso(1);
		user.setSenha("1234");
		user.setUsuario("Funcionario");
		
		usuarioDao.inserirUsuario(user);
		Usuario usuario = usuarioDao.selecionarUSuarioParaCadastrar(user);
		func.setNome("Joao");
		func.setCpf(Long.valueOf(12345678998l));
		func.setNumero(912345678);
		func.setSexo("M");
		func.setTelefone("9 1234-5678");
		func.setUsuario(usuario);
		func.setComplemento("Amigo do dono");
		func.setEmail("default@gmail.com");
		func.setDataNascimento(data);
		func.setNumero(27);
		func.setEndereco(endereco);
		
	
		boolean resposta = funcionarioDao.excluirFuncionario(func);

		assertTrue(resposta);
	}

}
