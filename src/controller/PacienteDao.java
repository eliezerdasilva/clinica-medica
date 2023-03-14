
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.Endereco;
import model.Funcionario;
import model.Paciente;

public class PacienteDao implements InterfacePacienteDao {

	private Conexao con;

	@Override
	public boolean cadastrarPaciente(Paciente paciente) {
		int retorno = 0;
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO paciente(cpf, nome , sexo, email, telefone, profissao, convenio, data_nascimento,endereco_cep, numero, complemento) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, paciente.getCpf());
			stm.setString(2, paciente.getNome());
			stm.setString(3, paciente.getSexo());
			stm.setString(4, paciente.getEmail());
			stm.setString(5, paciente.getTelefone());
			stm.setString(6, paciente.getProfissao());
			stm.setString(7, paciente.getConvenio());
			stm.setDate(8, Date.valueOf(paciente.getDataNascimento()));
			stm.setInt(9, paciente.getEndereco().getCep());
			stm.setInt(10, paciente.getNumero());
			stm.setString(11, paciente.getComplemento());
			
			
			retorno = stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean excluirPaciente(Paciente paciente) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();

		try {
			String query = "DELETE FROM paciente WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, paciente.getCpf());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	@Override
	public boolean alterarPaciente(Paciente paciente) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement stm = null;

		try {
			stm = c.prepareStatement(

					"UPDATE paciente SET nome = ?, sexo = ?, email = ?, telefone = ?, profissao = ?, convenio = ?,  endereco_cep = ?, numero = ?, complemento = ? WHERE cpf = ?");

			stm.setString(1, paciente.getNome());
			stm.setString(2, paciente.getSexo());
			stm.setString(4, paciente.getEmail());
			stm.setString(3, paciente.getTelefone());
			stm.setString(6, paciente.getProfissao());
			stm.setString(7, paciente.getConvenio());
			stm.setInt(8, paciente.getEndereco().getCep());
			stm.setInt(9, paciente.getNumero());
			stm.setString(10, paciente.getComplemento());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	@Override
	public Paciente consultarPaciente(Paciente paciente) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		
		try {
			Statement stm = c.prepareStatement(null);
			String query = "SELECT * FROM paciente p INNER JOIN endereco e WHERE f.endereco_cep = e.cep";
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String profissao = rs.getString("profissao");
				String convenio = rs.getString("convenio");
				Date data = rs.getDate("data");
				LocalDate dataNascimento = LocalDate.of(data.getYear(), data.getMonth(), data.getDay());
				int endereco = rs.getInt("endereco_cep");
				rs.getArray(endereco);
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");
				
				
				Paciente p = new Paciente();
				
				p.setCpf(cpf);
				p.setNome(nome);
				p.setSexo(sexo);
				p.setEmail(email);
				p.setTelefone(telefone);
				p.setProfissao(profissao);
				p.setConvenio(convenio);
				p.setDataNascimento(dataNascimento);	
				p.setNumero(numero);
				
				
				Endereco e = new Endereco();
				e.setBairro(complemento);
				p.setEndereco(e);	
				
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return null;
	}

}
