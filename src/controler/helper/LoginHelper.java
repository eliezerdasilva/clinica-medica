  package controler.helper;

import model.Usuario;
import view.Login;

public class LoginHelper implements IPacienteDAO{
	
	private final Login view;
	
	public LoginHelper(Login view) {
		this.view = view;
	}
	public Usuario obterModelo() {
		String nome = view.getTxtUsuario().getText();
		String senha = view.getTxtUsuario().getText();
		
		Usuario modelo = new Usuario(0, nome, senha);
		return modelo;
	}
	public void setarModelo(Usuario modelo) {
		String nome = modelo.getNome();
		String senha = modelo.getSenha();
		
		view.getTxtUsuario().setText(nome);
		view.getTxtSenha().setText(senha);
	}
	public void limpartela() {
		view.getTxtUsuario().setText("");
		view.getTxtSenha().setText("");
	}
	@Override
	public void limparTela() {
		// TODO Auto-generated method stub
		
	}
	
	

}
