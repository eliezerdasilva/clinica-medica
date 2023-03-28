
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Convenio;
import model.Endereco;
import model.Paciente;

public class PacienteDao implements InterfacePacienteDao {

	private Conexao con;

	@Override
	public boolean cadastrarPaciente(Paciente paciente) {
		boolean retorno = false;
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		
	
		try {
			String query = "INSERT INTO paciente(cpf, nome,sexo,email,telefone,profissao,convenio_id,data_nascimento,endereco_cep,numero,complemento) values(?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, paciente.getCpf());
			stm.setString(2, paciente.getNome());
			stm.setString(3, paciente.getSexo());
			stm.setString(4, paciente.getEmail());
			stm.setString(5, paciente.getTelefone());
			stm.setString(6, paciente.getProfissao());	
			stm.setInt(7,paciente.getConvenio().getId());
	
			stm.setDate(8, Date.valueOf(paciente.getDataNascimento()));
			stm.setInt(9, paciente.getEndereco().getCep());
			stm.setInt(10, paciente.getNumero());
			stm.setString(11, paciente.getComplemento());
			stm.executeUpdate();

			retorno = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;

		
	}

	@Override
	public boolean excluirPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Paciente> consultarPaciente() {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		ArrayList<Paciente> listaPacientes = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement("Select * from paciente");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
		
				
				
				int endereco_cep = rs.getInt("endereco_cep");
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");
				
				Paciente paciente  =  new Paciente();
				Convenio convenio = new Convenio();
				Endereco endereco = new Endereco();
				
				paciente.setCpf(rs.getLong("cpf"));
				paciente.setNome(rs.getString("nome"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setEmail(rs.getString("email"));
				paciente.setTelefone(rs.getString("telefone"));
				paciente.setProfissao(rs.getString("profissao"));
				convenio.setId(rs.getInt("convenio_id")); 
				paciente.setConvenio(convenio);
				paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				endereco.setCep(rs.getInt("endereco_cep"));
				paciente.setEndereco(endereco);
				paciente.setNumero(rs.getInt("numero"));
				paciente.setComplemento(rs.getString("complemento"));
				
				listaPacientes.add(paciente);
				
						 
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		return listaPacientes;
	}

	@Override
	public ArrayList<Convenio> consultaConvenio() {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from convenio");

			ResultSet rs = ps.executeQuery();

			ArrayList<Convenio> convenios = new ArrayList<>();
			while (rs.next()) {
				Convenio convenio = new Convenio();
				
				convenio.setId(rs.getInt("id"));
				convenio.setConvenio(rs.getString("convenio"));
				convenios.add(convenio);

			}
			return convenios;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	@SuppressWarnings("unused")
	@Override
	public boolean ConsultaCpfPaciente(Long cpfConsulta) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		boolean resultado = false; 
		try {
			PreparedStatement ps = c.prepareStatement("select * from paciente");

			ResultSet rs = ps.executeQuery();

			ArrayList<Paciente> paciente = new ArrayList<>();
			Paciente paciente2 = new Paciente();
			while (rs.next()) {
				paciente2.setCpf(rs.getLong("cpf"));
				paciente.add(paciente2);
				
				
			}
			for (Paciente p : paciente) {
				if(paciente2.getCpf().equals(cpfConsulta)) {
					resultado = false;
				}else {
					resultado = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
		
	}


}
