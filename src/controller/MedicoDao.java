package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Endereco;
import model.Medico;

public class MedicoDao implements InterfaceMedico {

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
			stm.setString(3, medico.getSexo());
			stm.setString(4, medico.getEmail());
			stm.setString(5, medico.getTelefone());
			stm.setLong(6, medico.getCrm());
			stm.setString(7, medico.getEspecializacao());
			stm.setDate(8, medico.getDataNascimento());
			retorno = stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean alterarMedico(Medico medico) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement stm = null;
		try {
			stm = c.prepareStatement (
					
					"UPDATE medico SET nome = ?, sexo = ?, email = ?, telefone = ?, crm = ?, especializacao = ?, data_nascimento = ? WHERE cpf = ?"
					);
			
			stm.setString(1, medico.getNome());
			stm.setString(2, medico.getSexo());
			stm.setString(3, medico.getEmail());
			stm.setString(4, medico.getTelefone());
			stm.setLong(5, medico.getCrm());
			stm.setString(6, medico.getEspecializacao());
			stm.setDate(7, medico.getDataNascimento());
			stm.setLong(8, medico.getCpf());
				
			
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
	public Medico consultarMedico(Medico medico) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from medico where crm = ? ");
			ps.setLong(1, medico.getCrm());

			ResultSet rs = ps.executeQuery();
			Medico medico1 = new Medico(0, "");

			while (rs.next()) {
				Long crm = rs.getLong("crm");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				Date data_nascimento = rs.getDate("data_nascimento");
				String especializacao = rs.getString("especializacao");
				Long cpf = rs.getLong("cpf");		

				medico1.setCrm(crm);
				medico1.setNome(nome);
				medico1.setSexo(sexo);
				medico1.setEmail(email);
				medico1.setTelefone(telefone);
				medico1.setDataNascimento(data_nascimento);
				medico1.setEspecializacao(especializacao);
				medico1.setCpf(cpf);
			}
			return medico1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean excluirMedico(Medico medico) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
	
		try {
			
			String query = "DELETE FROM medico WHERE crm = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, medico.getCrm());
			stm.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return false;
	}

}
