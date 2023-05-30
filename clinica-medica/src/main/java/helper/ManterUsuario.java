package helper;

import controller.UsuarioDao;
import model.Endereco;
import model.StatusTela;
import model.Usuario;

public class ManterUsuario {
	
	private Usuario usuarioConsultado;
	private UsuarioDao UsuarioDao;
	
	public StatusTela consultarUsuario(Usuario usuario) {
		
		usuarioConsultado = new Usuario();

		
		usuarioConsultado = UsuarioDao.consultarUsuario(usuario);
		if(usuarioConsultado.getId()!=null) {
			return StatusTela.USUARIOEXISTENTE;
		}else {
			return StatusTela.USUARIONAOCADASTRADO;
		}
		
		
		
	
		
	}

}
