package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Usuario;

public class FuncionarioDao implements InterfaceFuncionarioDao {

	private Conexao con;
	private Endereco endereco;
	private Estado estado;
	private Usuario usuario;
	private Funcionario funcionario;
	

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

			String query = "UPDATE funcionario SET nome = ?, sexo = ?, telefone = ?, data_nascimento = ?, usuario_idusuario= ?, endereco_cep = ?, numero = ?,complemento = ?, email = ? WHERE cpf = ?;";
			stm = c.prepareStatement(query);
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getSexo());
			stm.setString(3, funcionario.getTelefone());
			stm.setDate(4, Date.valueOf(funcionario.getDataNascimento()));
			stm.setLong(5, funcionario.getUsuario().getId());
			stm.setInt(6, funcionario.getEndereco().getCep());
			stm.setInt(7, funcionario.getNumero());
			stm.setString(8, funcionario.getComplemento());
			stm.setString(9, funcionario.getEmail());
			stm.setLong(10, funcionario.getCpf());

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
	public Funcionario consultarFuncionarioCPF(Funcionario funcionario) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();

		try {

			PreparedStatement ps = c.prepareStatement("select funcionario.*, usuario.*, endereco.* from funcionario\r\n"
					+ "join usuario on funcionario.usuario_idusuario = usuario.idusuario\r\n"
					+ "join endereco on funcionario.endereco_cep = endereco.cep\r\n"
					+ "where cpf = ?;");
			ps.setLong(1, funcionario.getCpf());
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);

			while (rs.next()) {
				funcionario = new Funcionario();
				endereco = new Endereco();
				estado = new Estado();
				usuario = new Usuario();
				
				//estado 
				estado.setId(rs.getInt("id_estado"));
				
				//Endereco 
				endereco.setBairro(rs.getString("Bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(estado);
				endereco.setRua(rs.getString("rua"));
				endereco.setCep(rs.getInt("cep"));
				
				funcionario.setNumero(rs.getInt("numero"));
				funcionario.setComplemento(rs.getString("complemento"));
					
				//Usuario
				usuario.setId(rs.getLong("idusuario"));
				usuario.setUsuario(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivelAcesso(rs.getInt("tipo_usuario"));

				funcionario.setCpf(rs.getLong("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				
				funcionario.setNumero(rs.getInt("numero"));
				funcionario.setComplemento(rs.getString("complemento"));
				
				funcionario.setEndereco(endereco);
				funcionario.setUsuario(usuario);

				return funcionario;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return null;
	}

	@Override
	public boolean consultaCpfBoolean(Long cpf) {
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

	@Override
	public ArrayList<Funcionario> consultaCPFNome(String nome, long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		Funcionario funcionarioSelect = new Funcionario();
		int valida = 0;
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement("select funcionario.*, usuario.*, endereco.* from funcionario\r\n"
					+ "join usuario on funcionario.usuario_idusuario = usuario.idusuario\r\n"
					+ "join endereco on funcionario.endereco_cep = endereco.cep\r\n"
					+ "where cpf = ? or nome = ? ");
			
			ps.setLong(1, cpf);
			ps.setString(2, nome);

			ResultSet rs = ps.executeQuery();

			
			while (rs.next()) {
				funcionario = new Funcionario();
				endereco = new Endereco();
				estado = new Estado();
				usuario = new Usuario();
				
				//estado 
				estado.setId(rs.getInt("id_estado"));
				
				//Endereco 
				endereco.setBairro(rs.getString("Bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(estado);
				endereco.setRua(rs.getString("rua"));
				endereco.setCep(rs.getInt("cep"));
				
				funcionario.setNumero(rs.getInt("numero"));
				funcionario.setComplemento(rs.getString("complemento"));
					
				//Usuario
				usuario.setId(rs.getLong("idusuario"));
				usuario.setUsuario(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivelAcesso(rs.getInt("tipo_usuario"));

				funcionario.setCpf(rs.getLong("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				
				funcionario.setNumero(rs.getInt("numero"));
				funcionario.setComplemento(rs.getString("complemento"));
				
				funcionario.setEndereco(endereco);
				funcionario.setUsuario(usuario);

			}
			return listaFuncionarios;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return listaFuncionarios;

	}

	@Override
	public ArrayList<Funcionario> consultarTodosFuncionario() {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		
		int valida = 0;
		ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement("select funcionario.*, usuario.*, endereco.* from funcionario \r\n"
					+ "join usuario on funcionario.usuario_idusuario = usuario.idusuario \r\n "
					+ "join endereco on funcionario.endereco_cep = endereco.cep ");
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				funcionario = new Funcionario();
				endereco = new Endereco();
				estado = new Estado();
				usuario = new Usuario();
				
				//estado 
				estado.setId(rs.getInt("id_estado"));
				
				//Endereco 
				endereco.setBairro(rs.getString("Bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(estado);
				endereco.setRua(rs.getString("rua"));
				endereco.setCep(rs.getInt("cep"));
				
				funcionario.setNumero(rs.getInt("numero"));
				funcionario.setComplemento(rs.getString("complemento"));
					
				//Usuario
				usuario.setId(rs.getLong("idusuario"));
				usuario.setUsuario(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivelAcesso(rs.getInt("tipo_usuario"));

				funcionario.setCpf(rs.getLong("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				
				funcionario.setNumero(rs.getInt("numero"));
				funcionario.setComplemento(rs.getString("complemento"));
				
				funcionario.setEndereco(endereco);
				funcionario.setUsuario(usuario);
				listaFuncionario.add(funcionario);
			}
			return listaFuncionario;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return null;

	}

	@Override
	public Funcionario consultaFuncionairoCPF(Long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		Funcionario funcionarioSelect = new Funcionario();
		int valida = 0;
		
		try {
			PreparedStatement ps = c.prepareStatement("select funcionario.*, usuario.*, endereco.* from funcionario\r\n"
					+ "join usuario on funcionario.usuario_idusuario = usuario.idusuario\r\n"
					+ "join endereco on funcionario.endereco_cep = endereco.cep\r\n"
					+ "where cpf = ?; ");
			ps.setLong(1, cpf);
	

			ResultSet rs = ps.executeQuery();

			
			while (rs.next()) {

				int endereco_cep = rs.getInt("endereco_cep");
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");

				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();
				int idusuario = rs.getInt("usuario_idusuario");
				usuario.setId(rs.getLong("usuario_idusuario"));

				funcionarioSelect.setCpf(rs.getLong("cpf"));
				funcionarioSelect.setNome(rs.getString("nome"));
				funcionarioSelect.setSexo(rs.getString("sexo"));
				funcionarioSelect.setEmail(rs.getString("email"));
				funcionarioSelect.setTelefone(rs.getString("telefone"));

				funcionarioSelect.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				endereco.setCep(rs.getInt("endereco_cep"));
				funcionarioSelect.setEndereco(endereco);
				funcionarioSelect.setNumero(rs.getInt("numero"));
				funcionarioSelect.setComplemento(rs.getString("complemento"));
				funcionarioSelect.setUsuario(usuario);
				

			}
			return funcionarioSelect;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return funcionarioSelect;

	}

}
