package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.Validate;

import model.Endereco;
import model.Funcionario;
import model.Medico;
import model.Usuario;

public class FuncionarioDao implements InterfaceFuncionarioDao {

	private Conexao con;

	@Override
	public boolean cadastrarFuncionario(Funcionario funcionario) {
		int retorno = 0;
		con = Conexao.getInstacia();
		Connection c = con.conectar();

		try {
			String query = "INSERT INTO funcionario(cpf,nome, sexo, telefone, data_nascimento, usuario_idusuario,endereco_cep, numero,complemento,email) VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, funcionario.getCpf());
			stm.setString(2, funcionario.getNome());
			stm.setString(3, funcionario.getSexo());
			stm.setString(4, funcionario.getTelefone());
			stm.setDate(5, Date.valueOf(funcionario.getDataNascimento()));
			stm.setLong(6, funcionario.getUsuario().getId());
			stm.setInt(7, funcionario.getEndereco().getCep());
			stm.setInt(8, funcionario.getNumero());
			stm.setString(9, funcionario.getComplemento());
			stm.setString(10, funcionario.getEmail());
			
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
			stm = c.prepareStatement(

					"UPDATE seller SET nome = ?, sexo = ?, telefone = ?, data_nascimento = ? WHERE cpf = ?");

			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getSexo());
			stm.setString(3, funcionario.getTelefone());
			// stm.setDate(4, funcionario.getDataNascimento());

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
				Date dataNascimento = rs.getDate("datA");
				int endereco = rs.getInt("endereco_cep");
				rs.getArray(endereco);
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");

				Funcionario f = new Funcionario();
				f.setComplemento(complemento);
				f.setCpf(cpf);
				// f.setDataNascimento(dataNascimento);
				f.setNome(nome);
				f.setNumero(numero);
				f.setSexo(sexo);
				f.setTelefone(telefone);

				Endereco e = new Endereco();
				e.setBairro(complemento);
				f.setEndereco(e);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return null;
	}

	@Override
	public boolean consultaCpf(Long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0; 
		try {
			PreparedStatement ps = c.prepareStatement("select * from funcionario where cpf = ? ");
			ps.setLong(1, cpf);

			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {
				valida = 1;
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}

}
