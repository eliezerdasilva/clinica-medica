package view;

import model.Agendamento;
import model.Cliente;
import model.Pessoa;
import model.Servico;
import model.Usuario;
import model_DAO.AgendamentoDAO;

public class main {
	
	public static void main(String[] args) {
		String nome = "tiago";
		System.out.println(nome);
		
		Servico servico = new Servico(1, "barba", 30);
		System.out.println(servico.getDescricao());
		System.out.println(servico.getValor());		
		
		
		
		Usuario usuario = new Usuario(1, "barbeiro", "senha ");
		System.out.println(usuario.getNome());
		
		Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "24/05/25 05:12");
		System.out.println(agendamento.getCliente().getNome() );
		
		AgendamentoDAO  agendamentos ;
		

		System.out.println(agendamento.getCliente());
	}

}
