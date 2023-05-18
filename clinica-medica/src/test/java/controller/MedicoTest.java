package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

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
		System.out.println(1);
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
		
		
		boolean result = medicoDao.cadastrarMedico(medico);
		assertTrue(result);
		
		Medico med = medicoDao.consultarMedico(medico.getCpf());
		assertNotNull(med);
		System.out.println(med.getNome());
		System.out.println(medico.getNome());
		assertEquals(med.getNome(), medico.getNome());
		
	}

	@Order(2)
	@Test
	void testAlterar() {
		System.out.println(2);
	}
	
	@Order(3)
	@Test
	void testConsulta() {
		System.out.println(3);
	}
	
	@Order(6)
	@Test
	void testExcluir() {
		System.out.println(6);
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
		
		
		boolean result = medicoDao.excluirMedico(medico.getCpf());
		assertTrue(result);
	}
	
	@Order(4)
	@Test
	void testConsultaCPF() {
		System.out.println(4);
	}
	
	@Order(5)
	@Test
	void testLista() {
		System.out.println(5);
	}

}
