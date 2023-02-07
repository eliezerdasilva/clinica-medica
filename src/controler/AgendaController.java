package controler;

import java.util.ArrayList;

import controler.helper.AgendaHelper;
import model.Agendamento;
import model_DAO.AgendamentoDAO;
import view.Agenda;

public class AgendaController {

	private final Agenda view;
	private final AgendaHelper helper;

	public AgendaController(Agenda view) {
		
		this.view = view;
		this.helper = new AgendaHelper(view);		
	}
	public void atualizaTabela() {
		
		//Buscar agendamentos 
		AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
		ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
		
		//exibi 
		helper.preencherTabela(agendamentos);
		
	}
	
	

	
}
