package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Funcionario consultarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return null;
	}

}
