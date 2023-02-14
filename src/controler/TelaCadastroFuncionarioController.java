package controler;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import view.MenuPrincipal;
import view.TelaCadastroFuncionario;

public class TelaCadastroFuncionarioController {

	MenuPrincipal menuPrincipal;
	TelaCadastroFuncionario telaCadastroFuncionario = new TelaCadastroFuncionario();
	
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

	public CadastrarFuncionario() {
		
	}
}
