package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
			stm.setDate(8, Date.valueOf(medico.getDataNascimento()));
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
			stm = c.prepareStatement(

					"UPDATE medico SET nome = ?, sexo = ?, email = ?, telefone = ?, especializacao = ? WHERE cpf = ?");

			stm.setString(1, medico.getNome());
			stm.setString(2, medico.getSexo());
			stm.setString(3, medico.getEmail());
			stm.setString(4, medico.getTelefone());
			stm.setString(5, medico.getEspecializacao());

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
			Statement stm = c.prepareStatement(null);
			String query = "SELECT * FROM medico";
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				Date data = rs.getDate("data");
				LocalDate dataNascimento = LocalDate.of(data.getYear(), data.getMonth(), data.getDay());
				int crm = rs.getInt("crm");
				String especializacao = rs.getString("especializacao");
				Long cpf = rs.getLong("cpf");
				String crmUf = rs.getString("crm_uf");

				Medico m = new Medico();
				
				m.setNome(nome);
				m.setSexo(sexo);
				m.setEmail(email);
				m.setTelefone(telefone);
				m.setDataNascimento(dataNascimento);
				m.setCrm(crm);
				m.setEspecializacao(especializacao);
				m.setCpf(cpf);
				m.setCrmUf(crmUf);
			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return null;
	}

	@Override
	public boolean excluirMedico(Medico medico) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();

		try {
			String query = "DELETE FROM medico WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, medico.getCpf());
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
