
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Convenio;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Paciente;
import model.Usuario;

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
		}finally {
			con.fecharConexao();
		}
		return retorno;

		
	}

	@Override
	public boolean excluirPaciente(Long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();

		try {   
		    String sql = "DELETE FROM paciente where cpf = ?";
			    PreparedStatement stmt = c.prepareStatement(sql);
			    stmt.setLong(1, cpf);
	 
			    stmt.executeUpdate();
			    stmt.execute();
			return true; 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			con.fecharConexao();
		}
		return false;
	}

	@Override
	public boolean alterarPaciente(Paciente paciente) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			String query = "update paciente set  nome =? ,sexo=? ,email=?,telefone=?,profissao=?,convenio_id=?,data_nascimento=?,endereco_cep=?,numero=?,complemento=? where cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);	
			
			stm.setString(1, paciente.getNome());
			stm.setString(2, paciente.getSexo());
			stm.setString(3, paciente.getEmail());
			stm.setString(4, paciente.getTelefone());
			stm.setString(5, paciente.getProfissao());	
			stm.setInt(6,paciente.getConvenio().getId());
	
			stm.setDate(7, Date.valueOf(paciente.getDataNascimento()));
			stm.setInt(8, paciente.getEndereco().getCep());
			stm.setInt(9, paciente.getNumero());
			stm.setString(10, paciente.getComplemento());
			stm.setLong(11, paciente.getCpf());
			stm.executeUpdate();

			valida = stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		
				
		return (valida == 0 ? false : true);
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
		}finally {
			con.fecharConexao();
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
		}finally {
			con.fecharConexao();
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
					resultado = true;
				}else {
					resultado = false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			con.fecharConexao();
		}
		return resultado;
		
	}

	@Override
	public Paciente consultarPacienteExistenteNome(String nome) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		Paciente paciente = new Paciente();
		try {
			PreparedStatement ps = c.prepareStatement("select * from paciente where nome = ?");
			ps.setString(1, nome);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
	
				
				int endereco_cep = rs.getInt("endereco_cep");
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");
				

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
				
				return paciente;
			
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		
		
		return null;
	}

	@Override
	public Paciente consultarPacienteExistenteCpf(Long cpf) {
	
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		Paciente paciente = new Paciente();
		try {
			PreparedStatement ps = c.prepareStatement("select * from paciente where cpf = ?");
			ps.setLong(1, cpf);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
	
				
				int endereco_cep = rs.getInt("endereco_cep");
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");
				

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
				
				return paciente;
			
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		
		
		return null;
	}

	public ArrayList<Paciente> consultaCPFNome(String nome, long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
		ArrayList<Paciente> listaPaciente = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement("select paciente.*, endereco.* from paciente  \r\n"
					+ "join endereco on paciente.endereco_cep = endereco.cep  \r\n"
                    + "where cpf = ? or nome = ? ;") ;
			
			ps.setLong(1, cpf);
			ps.setString(2, nome);

			ResultSet rs = ps.executeQuery();

			
			while (rs.next()) {
				var paciente = new Paciente();
				var endereco = new Endereco();
				var estado = new Estado();
			
				
				//estado 
				estado.setId(rs.getInt("id_estado"));
				
				//Endereco 
				endereco.setBairro(rs.getString("Bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(estado);
				endereco.setRua(rs.getString("rua"));
				endereco.setCep(rs.getInt("cep"));
				
				paciente.setNumero(rs.getInt("numero"));
				paciente.setComplemento(rs.getString("complemento"));
					
	
				paciente.setCpf(rs.getLong("cpf"));
				paciente.setNome(rs.getString("nome"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setEmail(rs.getString("email"));
				paciente.setTelefone(rs.getString("telefone"));
				paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				
				paciente.setNumero(rs.getInt("numero"));
				paciente.setComplemento(rs.getString("complemento"));
				
				paciente.setEndereco(endereco);
				
				listaPaciente.add(paciente);
			

			}
			return listaPaciente;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return listaPaciente;
	}

	public long quantidadeDePaciente() {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int resultado = 0 ;
		try {
			PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM paciente;");
			
	

			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {
				 resultado = rs.getInt(1);
			}
		

		} catch (Exception e) {

		} finally {
			con.fecharConexao();
		}
		return resultado;
	}
}
