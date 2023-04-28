package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Consulta;
import model.Medico;
import model.Paciente;
import view.Agenda;

public class AgendaDao implements InterfaceConsulta {
	
	private Conexao con;
	
	@Override
	public boolean cadastraConsulta(Consulta consulta) {
	
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
	
		try {
			String query = "INSERT INTO consulta( data_consulta,hora_consulta,paciente_cpf,tipo_consulta,medico_cpf,observacao) values(?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setDate(1, Date.valueOf(consulta.getDate()));
			stm.setTimestamp(2, consulta.getHora());
			stm.setLong(3, consulta.getPaciente().getCpf());
			stm.setString(4, consulta.getServico());
			stm.setLong(5, consulta.getMedico().getCpf());
			stm.setString(6, consulta.getObservacao());

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
	public ArrayList<Consulta> listConsulta() {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			PreparedStatement ps = c.prepareStatement("Select * from consulta");
			ResultSet rs = ps.executeQuery();
			ArrayList<Consulta> listConsulta = new ArrayList<>();
			Consulta consulta = new Consulta();
			Paciente paciente  =  new Paciente();
			Medico medico = new Medico();
			while(rs.next()) {
				consulta.setDate(rs.getDate("data_consulta").toLocalDate());
				consulta.setHora(rs.getTimestamp("hora_consulta"));
				paciente.setNome(rs.getString("nome"));
				medico.setNome(rs.getString("nome"));
				consulta.setPaciente(paciente);
				consulta.setMedico(medico);
				listConsulta.add(consulta);
				
			}

			return listConsulta;
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
		}
		return null;
	}

	@Override
	public ArrayList<Consulta> listConsultaDia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Consulta> listConsultaSemana() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Consulta> listConsultaMes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta consultaAgendaPaciente() {
		// TODO Auto-generated method stub
		return null;
	}

}
