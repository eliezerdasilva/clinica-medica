package controler.helper;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import model.Agendamento;
import view.Agenda;

public class AgendaHelper {

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
			agendamento.getDate(),
			agendamento.getDate(),
			agendamento.getObservacao()});
		}
		view.getTable().setModel(tableModel);		
		
	}
	
	
	
	
	
}
