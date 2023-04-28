package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.Consulta;
import view.Agenda;

public class AgendaDao implements InterfaceConsulta {
	
	private Conexao con;
	
	@Override
	public boolean cadastraConsulta(Consulta consulta) {
		boolean retorno = false;
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
	
		try {
			String query = "INSERT INTO consulta(id_consulta, data_consulta,hora_consulta,paciente_cpf,tipo_consulta,medico_cpf,observacao) values(?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, consulta.getId());
			stm.setDate(2, Date.valueOf(consulta.getDate()));
			stm.setTimestamp(3, consulta.getHora());
			stm.setLong(4, consulta.getPaciente().getCpf());
			stm.setString(5, consulta.getServico());
			stm.setLong(6, consulta.getMedico().getCpf());
			stm.setString(7, consulta.getObservacao());

			valida = stm.executeUpdate();

			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
		
	}

	@Override
	public boolean alterarConsulta(Consulta consulta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluitConsulta(Consulta consulta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Agenda> listConsulta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Agenda> listConsultaDia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Agenda> listConsultaSemana() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Agenda> listConsultaMes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agenda consultaAgendaPaciente() {
		// TODO Auto-generated method stub
		return null;
	}

}
