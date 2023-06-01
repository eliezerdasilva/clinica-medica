package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Consulta;
import model.Medico;
import model.Paciente;

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
			stm.setTime(2, Time.valueOf(consulta.getHora()));
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
			PreparedStatement ps = c.prepareStatement("Update consulta set data_consulta = ?, hora_consulta = ? ,tipo_consulta = ? , medico_cpf = ?, observacao = ? where id_consulta = ?;");
			ps.setDate(1, Date.valueOf(consulta.getDate()));
			ps.setTime(2, Time.valueOf(consulta.getHora()));
			ps.setString(3, consulta.getServico());
			ps.setLong(4, consulta.getMedico().getCpf());
			ps.setString(5, consulta.getObservacao());
			ps.setInt(6, consulta.getId());
			ps.executeUpdate();
			valida = 1 ; 
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}

	@Override
	public boolean excluirConsulta(Consulta consulta) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
		  String sql = "DELETE FROM consulta where id_consulta = ?";
		    PreparedStatement ps = c.prepareStatement(sql);
		    ps.setLong(1, consulta.getId());
		    ps.executeUpdate();
		    return true; 
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			con.fecharConexao();
		}
		return false;
	}

	@Override
	public ArrayList<Consulta> listConsulta() {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
	
		ArrayList<Consulta> listConsulta = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement("select consulta.data_consulta, \r\n"
					+ "consulta.hora_consulta,\r\n"
					+ " paciente.nome as nome_paciente,\r\n"
					+ " paciente.cpf as cpf_paciente,\r\n"
					+ " medico.cpf as cpf_medico, \r\n"
					+ " consulta.observacao, \r\n"
					+ " consulta.tipo_consulta,\r\n"
					+ " consulta.id_consulta, \r\n"
					+ " consulta.status, \r\n"
					+ " medico.nome as nome_medico \r\n"
					+ " from consulta \r\n"
					+ " inner join paciente on consulta.paciente_cpf = paciente.cpf\r\n"
					+ " inner join medico on consulta.medico_cpf = medico.cpf;\r\n"
				
			
			  
			 );
			ResultSet rs = ps.executeQuery();
		
			
			while(rs.next()) {
				Consulta consulta = new Consulta();
				Paciente paciente  =  new Paciente();
				Medico medico = new Medico();
				consulta.setDate(rs.getDate("data_consulta").toLocalDate());
				Time dataHora = rs.getTime("hora_consulta");
				consulta.setHora(dataHora.toLocalTime());
				paciente.setNome(rs.getString("nome_paciente"));
				paciente.setCpf(rs.getLong("cpf_paciente"));
				consulta.setObservacao(rs.getString("observacao"));
				consulta.setServico(rs.getString("tipo_consulta"));
				consulta.setId(rs.getInt("id_consulta"));
				medico.setCpf(rs.getLong("cpf_medico"));
				medico.setNome(rs.getString("nome_medico"));
				consulta.setPresença(rs.getString("status"));
				consulta.setPaciente(paciente);
				consulta.setMedico(medico);
				listConsulta.add(consulta);

		
				
			}

		
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.fecharConexao();
		}
		return listConsulta;
	}

	@Override
	public ArrayList<Consulta> listConsultaDia(LocalDate date ) {
		
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
		ArrayList<Consulta> listConsulta = new ArrayList<>();
		try { 
			PreparedStatement ps = c.prepareStatement("Select * from consulta where data_consulta = ? ");
			ps.setDate(1, Date.valueOf(date));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Consulta consulta = new Consulta();
	
				consulta.setId(rs.getInt("id_consulta"));
		
				listConsulta.add(consulta);
			
			}
			return listConsulta;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	
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

	@Override
	public boolean confirmarPresença(Consulta consulta) {

		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
		String presente  = "Presente";
		try {
			PreparedStatement ps = c.prepareStatement("Update consulta set status = ? where id_consulta = ?;");
			ps.setString(1, presente);	
			ps.setInt(2, consulta.getId());
			ps.executeUpdate();
			valida = 1 ; 
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
		
	}

	public ArrayList<Consulta> consultarCosultaDia() {
		// TODO Auto-generated method stub
		return null;
	}

}
