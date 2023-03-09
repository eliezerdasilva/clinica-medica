package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.Medico;

public class MedicoDao implements InterfaceMedico{

	private Conexao con;

	@Override
	public boolean cadastrarMedico(Medico medico) {
		int retorno = 0;
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO paciente(nome, cpf , sexo, email, telefone, crm, especializacao, data_nascimento) values(?,?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, medico.getNome());
			stm.setLong(2, medico.getCpf());
			stm.setString(3,medico.getSexo());
			stm.setString(4, medico.getEmail());
			stm.setString(5 , medico.getTelefone());
			stm.setLong(6, medico.getCrm());
			stm.setString(7, medico.getEspecializacao());
			stm.setDate(8,Date.valueOf(medico.getDataNascimento()));
			retorno = stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean alterarMedico(Medico medico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Medico consultarMedico(Medico medico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean excluirMedico(Medico medico) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
