package controler;

import java.util.ArrayList;

import controler.helper.AgendaHelper;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import model_DAO.AgendamentoDAO;
import model_DAO.ClienteDAO;
import model_DAO.ServicoDAO;
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
	public void atualizaCliente() {
		//Busca 
		ClienteDAO clienteDao = new ClienteDAO();
		ArrayList<Cliente> clientes =  clienteDao.selectAll();
		
		//Exibe no combo
		helper.preencherClientes(clientes);
	}
	public void atualizaServico() {
		ServicoDAO servicoDAO = new ServicoDAO();
		ArrayList<Servico> servicos = servicoDAO.selectAll();
		
		helper.preencherServico(servicos);
		
	}
	public void atualizaValor(){
		Servico servico = helper.obterServico();
		helper.setarValor(servico.getValor());
	}
	public void agendar() {
		// Buscar agendamento tela 
		Agendamento agendamento = helper.obterModelo();
		//Salva no bd
		new AgendamentoDAO().insert(agendamento);
		//atualizar e inserir
		atualizaTabela();
		helper.limparTela();
	}
	

	
}
