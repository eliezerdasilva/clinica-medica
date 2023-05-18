package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Usuario;

class LoginTest {
	
	LoginDao loginDao = new LoginDao();

	@Test
	void testConsultarLogin() {
		
		Usuario usuario = new Usuario();
		usuario.setSenha("teste");
		usuario.setUsuario("teste");
		
		Usuario user = loginDao.consultarLogin(usuario);
		
		assertNotNull(user);
	}

}
