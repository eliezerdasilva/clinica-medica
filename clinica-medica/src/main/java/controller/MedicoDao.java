package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import model.Endereco;
import model.Medico;
import model.Paciente;
import model.Usuario;

public class MedicoDao implements InterfaceMedico {

	private Conexao con;

	@Override
	public boolean cadastrarMedico(Medico medico) {
		int retorno = 0;
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO medico(cpf, nome , sexo, email, telefone, data_nascimento, crm,especializacao, endereco_cep, numero, usuario_idusuario, complemento) values(?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, medico.getCpf());
			stm.setString(2, medico.getNome());
			stm.setString(3, medico.getSexo());
			stm.setString(4, medico.getEmail());
			stm.setString(5, medico.getTelefone());
			stm.setDate(6, Date.valueOf(medico.getDataNascimento()));
			stm.setLong(7, medico.getCrm());
			stm.setString(8, medico.getEspecializacao());
			stm.setInt(9, medico.getEndereco().getCep());
			stm.setInt(10, medico.getNumero());
			stm.setLong(11, medico.getUsuario().getId());
			stm.setString(12, medico.getComplemento());

			retorno = stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean alterarMedico(Medico medico) {

		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement stm = null;
		int valida = 0;
		try {
			stm = c.prepareStatement(

					"UPDATE medico SET nome = ?, sexo = ?, email = ?, telefone = ?,data_nascimento = ?, crm = ?, especializacao = ?, endereco_cep = ?, numero = ?, usuario_idusuario = ?, complemento = ?  WHERE cpf = ?");

			stm.setString(1, medico.getNome());
			stm.setString(2, medico.getSexo());
			stm.setString(3, medico.getEmail());
			stm.setString(4, medico.getTelefone());
			stm.setDate(5, Date.valueOf(medico.getDataNascimento()));
			stm.setLong(6, medico.getCrm());
			stm.setString(7, medico.getEspecializacao());
			stm.setInt(8, medico.getEndereco().getCep());
			stm.setInt(9, medico.getNumero());
			stm.setLong(10, medico.getUsuario().getId());
			stm.setString(11, medico.getComplemento());
			stm.setLong(12, medico.getCpf());

			valida = stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (valida == 0 ? false : true);
	}

	@Override
	public Medico consultarMedico(Long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from medico where crm = ? ");
			ps.setLong(1, cpf);

			ResultSet rs = ps.executeQuery();
			Medico medico1 = new Medico();

			System.out.println("AOF");
			System.out.println(rs);
			while (rs.next()) {
				Long crm = rs.getLong("crm");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				Date data_nascimento = rs.getDate("data_nascimento");
				String especializacao = rs.getString("especializacao");
				Long cpf1 = rs.getLong("cpf");

				System.out.println("ÇÇ");
				System.out.println(nome);
				System.out.println(crm);
				System.out.println(sexo);
				System.out.println(email);
				System.out.println(telefone);
				System.out.println(data_nascimento);
				System.out.println(especializacao);
				System.out.println(cpf1);
				
				LocalDate localDate = data_nascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				medico1.setCrm(crm);
				medico1.setNome(nome);
				medico1.setSexo(sexo);
				medico1.setEmail(email);
				medico1.setTelefone(telefone);
				medico1.setDataNascimento(localDate);
				medico1.setEspecializacao(especializacao);
				medico1.setCpf(cpf1);
			}
			return medico1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return null;
	}

	@Override
	public boolean excluirMedico(Long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();

		try {

			String query = "DELETE FROM medico WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, cpf);
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
	public boolean ConsultaCpfMedico(Long cpf) {
		/**
		 * Consultar se tem medico já cadastrado
		 */
		con = Conexao.getInstacia();
		Connection c = con.conectar();

		boolean resultado = false;
		try {
			PreparedStatement ps = c.prepareStatement("select * from medico where cpf = ?");
			ps.setLong(1, cpf);
			ResultSet rs = ps.executeQuery();

			ArrayList<Medico> medicoList = new ArrayList<>();
			Medico medico = new Medico();
			while (rs.next()) {
				medico.setCpf(rs.getLong("cpf"));
				medicoList.add(medico);
				resultado = true; 
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			con.fecharConexao();
		}
		return resultado;
	}

	@Override
	public ArrayList<Medico> listaMedicos() {

		con = Conexao.getInstacia();
		Connection c = con.conectar();
		ArrayList<Medico> listMedicos = new ArrayList<>();
		try {

			PreparedStatement ps = c.prepareStatement("Select * from medico");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Medico medico = new Medico();
				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();

				medico.setCpf(rs.getLong("cpf"));
				medico.setNome(rs.getString("nome"));
				medico.setSexo(rs.getString("sexo"));
				medico.setEmail(rs.getString("email"));
				medico.setTelefone(rs.getString("telefone"));
				medico.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				medico.setCrm(rs.getLong("crm"));
				medico.setEspecializacao(rs.getString("especializacao"));
				endereco.setCep(rs.getInt("endereco_cep"));
				medico.setEndereco(endereco);
				medico.setNumero(rs.getInt("numero"));
				usuario.setId(rs.getLong("usuario_idusuario"));
				medico.setUsuario(usuario);
				medico.setComplemento(rs.getString("complemento"));

				listMedicos.add(medico);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return listMedicos;
	}

	@Override
	public Medico consultaDadosMedico(Long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from medico where cpf = ? ");
			ps.setLong(1, cpf);

			ResultSet rs = ps.executeQuery();
			Medico medico1 = new Medico();

			while (rs.next()) {
				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();

				medico1.setCpf(rs.getLong("cpf"));
				medico1.setNome(rs.getString("nome"));
				medico1.setSexo(rs.getString("sexo"));
				medico1.setEmail(rs.getString("email"));
				medico1.setTelefone(rs.getString("telefone"));
				medico1.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				medico1.setCrm(rs.getLong("crm"));
				medico1.setEspecializacao(rs.getString("especializacao"));
				endereco.setCep(rs.getInt("endereco_cep"));
				medico1.setEndereco(endereco);
				medico1.setNumero(rs.getInt("numero"));
				usuario.setId(rs.getLong("usuario_idusuario"));
				medico1.setUsuario(usuario);
				medico1.setComplemento(rs.getString("complemento"));

				return medico1;
			}
			return null;

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			con.fecharConexao();
		}
		return null; 
	}
}
