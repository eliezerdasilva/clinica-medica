package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.Paciente;

public class PacienteDao implements InterfacePacienteDao {

	private Conexao con;
	@Override
	public Boolean inserir(Paciente paciente) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			String sql = "Insert into paciente(nome,cpf,sexo,email,telefone,profissao,convenio,data_nascimento,endereco_cep) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, paciente.getNome());
			stm.setLong(2, paciente.getCpf());
			stm.setString(3, paciente.getSexo());
			stm.setString(4, paciente.getEmail());
			stm.setString(5, paciente.getTelefone());
			stm.setString(6, paciente.getProfissao());
			stm.setString(7, paciente.getConvenio());
//			stm.setDate(8, (Date) paciente.getDataNascimento());
//			stm.set
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public Boolean Editar(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean excluir(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
