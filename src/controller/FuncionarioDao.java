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

public class FuncionarioDao implements IntefaceFuncionarioDao {

	private Conexao con;

	@Override
	public boolean cadastrarFuncionario(Funcionario funcionario) {
		int retorno = 0;
		con = Conexao.getInstacia();
		Connection c = con.conectar();

		try {
			String query = "INSERT INTO funcionario(cpf,nome, sexo, telefone, data_nascimento) VALUES (?,?,?,?,?)";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, funcionario.getCpf());
			stm.setString(2, funcionario.getNome());
			stm.setString(3, funcionario.getSexo());
			stm.setString(4, funcionario.getTelefone());
			stm.setDate(5, Date.valueOf(funcionario.getDataNascimento()));
			retorno = stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean excluirFuncionario(Funcionario funcionario) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		
		try {
			String query = "DELETE FROM funcionario WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, funcionario.getCpf());
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
	public boolean alterarFuncionario(Funcionario funcionario) {
		
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement stm = null;
		try {
			stm = c.prepareStatement (
					
					"UPDATE funcionario SET nome = ?, sexo = ?, telefone = ?, data_nascimento = ? WHERE cpf = ?"
					);
			
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getSexo());
			stm.setString(2, funcionario.getSexo());
			stm.setString(3, funcionario.getTelefone());
			stm.setDate(4, Date.valueOf(funcionario.getDataNascimento()));
				
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
	public Funcionario consultarFuncionario(Funcionario funcionario) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		
		try {
			Statement stm = c.prepareStatement(null);
			String query = "SELECT * FROM funcionario f INNER JOIN endereco e WHERE f.endereco_cep = e.cep";
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String telefone = rs.getString("telefone");
				Date data = rs.getDate("data");
				LocalDate dataNascimento = LocalDate.of(data.getYear(), data.getMonth(), data.getDay());
				int endereco = rs.getInt("endereco_cep");
				rs.getArray(endereco);
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");
				
				
				Funcionario f = new Funcionario();
				f.setComplemento(complemento);
				f.setCpf(cpf);
				f.setDataNascimento(dataNascimento);
				f.setNome(nome);
				f.setNumero(numero);
				f.setSexo(sexo);
				f.setTelefone(telefone);
				
				Endereco e = new Endereco();
				e.setBairro(complemento);
				f.setEndereco(e);
				
				
				
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return null;
	}

}
