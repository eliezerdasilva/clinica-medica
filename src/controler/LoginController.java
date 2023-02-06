package controler;

import controler.helper.LoginHelper;
import model.Usuario;
import model_DAO.UsuarioDAO;
import view.Login;
import view.MenuPrincipal;

public class LoginController {

	private final Login view;
	private LoginHelper helper;

	public LoginController(Login view) {
		this.view = view;
		this.helper = new  LoginHelper(view);
	}
	
	
	public void entrarNoSistema() {
		Usuario usuario = helper.obterModelo();
		// Pesquisa 
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		 Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
		
		 if(usuarioAutenticado != null) {
			 MenuPrincipal menu = new MenuPrincipal();
			 menu.setVisible(true);
			 this.view.dispose();
			 
		 }else {
			 view.exibeMensagem("Usuario e senha invalidos");
		 }
		
		
		}
	
	public void FizTarefa() {
		System.out.println("Busquei algo do banco de dados");
		
		this.view.exibeMensagem("Executei o fiz tarefa");
	}
	
	
}
