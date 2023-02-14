package controler.helper;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import view.Agenda;

public class AgendaHelper implements Ihelpe {

	private final Agenda view;

	public AgendaHelper(Agenda view) {
		super();
		this.view = view;
	}

	public void preencherTabela(ArrayList<Agendamento> agendamentos) {
		
		DefaultTableModel  tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Cliente", "Servi\u00E7o", "Valor", "Hora", "Data", "Observacao"
				}
			);
		//(DefaultTableModel) view.getTable().getModel();
		//tableModel.setNumRows(0);
		
		// Percorrer a lista da tabela
		for (Agendamento agendamento : agendamentos) {
			tableModel.addRow(new Object[]{
			agendamento.getId(),
			agendamento.getCliente().getNome(),
			agendamento.getServico().getDescricao(),
			agendamento.getValor(),
			agendamento.getDataFormatada(),
			agendamento.getHoraFormatada(),
			agendamento.getObservacao()});
		}
		view.getTable().setModel(tableModel);		
		
	}

	public void preencherClientes(ArrayList<Cliente> clientes) {
		DefaultComboBoxModel comboBoxModel=  (DefaultComboBoxModel) view.getComboBoxCliente().getModel();
		
		for (Cliente cliente : clientes) {
			comboBoxModel.addElement(cliente); //inserido no comboBox
		}
	}

	public void preencherServico(ArrayList<Servico> servicos) {
		DefaultComboBoxModel comboBoxModel=  (DefaultComboBoxModel) view.getComboBoxServico().getModel();

		for (Servico servico : servicos) {
			comboBoxModel.addElement(servico);
			
		}
		
	}
	public Cliente obterCliente() {
		return (Cliente) view.getComboBoxCliente().getSelectedItem();
	}
	
	
	public Servico obterServico() {
		return (Servico) view.getComboBoxServico().getSelectedItem();
	}

	public void setarValor(float valor) {
	view.getTxtValor().setText(valor + "");
		
	}

	@Override
	public Agendamento obterModelo() {
		
		//ID
		//String idString = view.getTxtID().getText();
		//int id = Integer.parseInt(idString);
		//Cliente
		Cliente cliente = obterCliente();
		//Servico
		Servico servico = obterServico();
		String valorString = view.getTxtValor().getText();
		float valor = Float.parseFloat(valorString);
		String data = view.getTxtData().getText();
		String hora = view.getTxtHora().getText();
		String datahora = data + " "+ hora;
		String observacao = view.getTxtobservacao().getText();
		
		//criando o objeto
		Agendamento agendamento = new Agendamento(cliente, servico, valor, datahora, observacao);
		return agendamento;
		
	}

	@Override
	public void limparTela() {
	view.getTxtID().setText("");
	view.getTxtData().setText("");
	view.getTxtHora().setText("");
	view.getTxtobservacao().setText("");
	view.getTxtValor().setText("");
		
	}
	
	
	
	
	
}
