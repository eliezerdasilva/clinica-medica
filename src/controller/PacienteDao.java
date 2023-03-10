
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import model.Paciente;

public class PacienteDao implements InterfacePacienteDao {

	private Conexao con;

	@Override
	public boolean cadastrarPaciente(Paciente paciente) {
		int retorno = 0;
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO paciente(nome, cpf , sexo,email,telefone,profissao,convenio,data_nascimento,endereco_cep) values(?,?,?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, paciente.getNome());
			stm.setLong(2, paciente.getCpf());
			stm.setString(3,paciente.getSexo());
			stm.setString(4, paciente.getEmail());
			stm.setString(5 , paciente.getTelefone());
			stm.setString(6, paciente.getConvenio());
			stm.setDate(7,paciente.getDataNascimento());
			stm.setInt(8, paciente.getEndereco().getCep());
			retorno = stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (retorno == 0 ? false : true);
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
	public Paciente consultarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

}
