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
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			PreparedStatement ps = c.prepareStatement("Update consulta set data_consulta = ? , hora_consulta = ? ,tipo_consulta = ? , observacao = ? where paciente_cpf = ?;");
			ps.setDate(1, Date.valueOf(consulta.getDate()));
			ps.setTimestamp(2, consulta.getHora());
			ps.setString(4, consulta.getServico());
			ps.setLong(5, consulta.getMedico().getCpf());
			ps.setString(6, consulta.getObservacao());
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
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
			PreparedStatement ps = c.prepareStatement("select consulta.data_consulta, \r\n"
					+ "consulta.hora_consulta,\r\n"
					+ " paciente.nome as nome_paciente,\r\n"
					+ " paciente.cpf as cpf_paciente,\r\n"
					+ " medico.cpf as cpf_medico, \r\n"
					+ " consulta.observacao, \r\n"
					+ " consulta.tipo_consulta,\r\n"
					+ " medico.nome as nome_medico \r\n"
					+ " from consulta \r\n"
					+ " inner join paciente on consulta.paciente_cpf = paciente.cpf\r\n"
					+ " inner join medico on consulta.medico_cpf = medico.cpf;\r\n"
				
			
			  
			 );
			ResultSet rs = ps.executeQuery();
			ArrayList<Consulta> listConsulta = new ArrayList<>();
			
			while(rs.next()) {
				Consulta consulta = new Consulta();
				Paciente paciente  =  new Paciente();
				Medico medico = new Medico();
				consulta.setDate(rs.getDate("data_consulta").toLocalDate());
				Timestamp dataHora = rs.getTimestamp("hora_consulta");
				consulta.setHora(dataHora);
				paciente.setNome(rs.getString("nome_paciente"));
				paciente.setCpf(rs.getLong("cpf_paciente"));
				consulta.setObservacao(rs.getString("observacao"));
				consulta.setServico(rs.getString("tipo_consulta"));
				medico.setCpf(rs.getLong("cpf_medico"));
				medico.setNome(rs.getString("nome_medico"));
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
