package controler;

import view.Agenda;
import view.MenuPrincipal;

public class MenuPrincipalController {
	
	private final MenuPrincipal view;

	public MenuPrincipalController(MenuPrincipal view) {
		super();
		this.view = view;
	}
	public void navegarParaAgenda() {
		Agenda agenda = new Agenda();
		agenda.setVisible(true);
	}
	public void fecharTelaMenuPrincipal() {
	    view.dispose();
	}

	
	
}
