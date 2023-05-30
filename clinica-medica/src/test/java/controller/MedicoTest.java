package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import model.Endereco;
import model.Estado;
import model.Medico;
import model.Usuario;

class MedicoTest {

	MedicoDao medicoDao = new MedicoDao();
	UsuarioDao usuarioDao = new UsuarioDao();
	private static final LocalDate data = LocalDate.now();
	
	@Order(1)
	@Test
	void testCadastro() {
		Medico medico = new Medico();
		Usuario user = new Usuario();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		
		estado.setId(2);
		endereco.setCep(89110000);
		user.setNivelAcesso(1);
		user.setSenha("1234");
		user.setUsuario("Funcionario");
		
		usuarioDao.inserirUsuario(user);
		Usuario usuario = usuarioDao.selecionarUSuarioParaCadastrar(user);
		medico.setNome("Dr Joao");
		medico.setCpf(Long.valueOf(12345678965l));
		medico.setCrm(Long.valueOf(777777));
		medico.setEmail("joaozinho@gmail.com");
		medico.setSexo("M");
		medico.setEspecializacao("Cardiologista");
		medico.setTelefone("5678");
		medico.setDataNascimento(data);
		medico.setComplemento("teste");
		medico.setUsuario(usuario);
		medico.setEndereco(endereco);
		
		
		boolean result = medicoDao.cadastrarMedico(medico);
		assertTrue(result);
		
		Medico med = medicoDao.consultarDadosMedicoCRM(medico.getCpf());
		assertNotNull(med);		
		
		usuarioDao.deletarUsuario(user);
	}

	@Order(2)
	@Test
	void testAlterar() {
		Medico medico = new Medico();
		Usuario user = new Usuario();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		
		estado.setId(2);
		endereco.setCep(89110000);
		user.setNivelAcesso(1);
		user.setSenha("1234");
		user.setUsuario("Funcionario");
		
		usuarioDao.inserirUsuario(user);
		Usuario usuario = usuarioDao.selecionarUSuarioParaCadastrar(user);
		medico.setNome("Dr ELiezer");
		medico.setCpf(Long.valueOf(7777777));
		medico.setCrm(Long.valueOf(77777777));
		medico.setEmail("joaozinho@gmail.com");
		medico.setSexo("M");
		medico.setEspecializacao("Cardiologista");
		medico.setTelefone("5678");
		medico.setDataNascimento(data);
		medico.setComplemento("teste");
		medico.setUsuario(usuario);
		medico.setEndereco(endereco);
		
		
		boolean resultado = medicoDao.alterarMedico(medico);
		assertTrue(resultado);
		
		usuarioDao.deletarUsuario(user);
	}
	
	@Order(3)
	@Test
	void testConsulta() {
		Medico medico = new Medico();
		
		medico.setCpf(Long.valueOf(12345678965l));
		medico.setCrm(Long.valueOf(777777));
		
		Medico resultado = medicoDao.consultarDadosMedicoCRM(medico.getCrm());
		assertNotNull(resultado);
		assertEquals(medico.getNome(), resultado.getNome());
		
	}
	
	@Order(4)
	@Test
	void testLista() {
		ArrayList<Medico> lista = medicoDao.listaMedicos();
		assertNotNull(lista);
	}

	@Order(5)
	@Test
	void testExcluir() {
		Medico medico = new Medico();
		
		medico.setCpf(Long.valueOf(12345678965l));
		medico.setCrm(Long.valueOf(777777));
		
		Medico resultad = medicoDao.consultarDadosMedicoCRM(medico.getCrm());
		assertNotNull(resultad.getCpf());
		
		boolean result = medicoDao.excluirMedico(medico.getCpf());
		assertTrue(result);
		
		Medico resultado = medicoDao.consultarDadosMedicoCRM(medico.getCrm());
		assertNull(resultado.getCpf());
		
	}
	
	
}
