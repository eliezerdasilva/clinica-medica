package controler;

import view.MenuPrincipal;
import view.TelaCadastroFuncionairo;


public class TelaCadastroFuncionarioController {

	MenuPrincipal menuPrincipal;
	TelaCadastroFuncionairo telaCadastroFuncionario = new TelaCadastroFuncionairo();
	
	public TelaCadastroFuncionarioController(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
		// TODO Auto-generated constructor stub
	}
	public void navegarParaCadastroFuncionario() {
		
		telaCadastroFuncionario.setVisible(true);
		
		
	}
	public void fecharMenuCadastro() {
		menuPrincipal.setVisible(false);;
	}

	public void CadastrarFuncionario() {
		
	}
}
