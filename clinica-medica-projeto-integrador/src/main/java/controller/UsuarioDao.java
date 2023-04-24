package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Endereco;
import model.Estado;
import model.Paciente;
import model.Usuario;

public class UsuarioDao implements InterfaceUsuario { 
	private Conexao con;
	private Usuario usuarioModelo;
	private Usuario usuario;

	@Override
	public boolean inserirUsuario(Usuario usuario) {
			this.usuario = usuario; 
			int retorno = 0;
			con = Conexao.getInstacia();
			Connection c = con.conectar();
			
		
			try {
				String query = "INSERT INTO usuario(login,senha,tipo_usuario) values(?,?,?);";
				PreparedStatement stm = c.prepareStatement(query);
				stm.setString(1, usuario.getUsuario());
				stm.setString(2, usuario.getSenha());
				stm.setInt(3, usuario.getNivelAcesso());
	
				
				retorno = stm.executeUpdate();

			
				
			
			}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
			return (retorno == 0 ? false : true);


	}

	@Override
	public boolean deletarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarUsuario(Usuario usurio) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean consultarUsuarioCadastrado(Usuario usuarioModelo) {
		/**
		 * Consultar se tem usuario já cadastrado
		 */
		this.usuarioModelo = usuarioModelo; 
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		boolean resultado = false; 
		try {
			PreparedStatement ps = c.prepareStatement("select * from medico where login = ? and usuario = ? ");
			  ps.setString(1, usuarioModelo.getUsuario());
			  ps.setString(2, usuarioModelo.getSenha());
			
			ResultSet rs = ps.executeQuery();

			ArrayList<Usuario> usuario = new ArrayList<>();
			Usuario usuario1 = new Usuario();
			while (rs.next()) {
				usuario1.setUsuario(rs.getString("usuario"));
				usuario1.setSenha(rs.getString("senha"));
				usuario.add(usuario1);
				
				
			}
			for (Usuario u : usuario) {
				if(u.getSenha() == (usuarioModelo.getSenha() )|| u.getUsuario() == (usuarioModelo.getUsuario())) {
					resultado = true;
				}else {
					resultado = false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			con.fecharConexao();
		}
		return resultado;
		
	}

	@Override
	public Usuario selecionarUSuarioParaCadastrar(Usuario usuarioModelo) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement(
					"select * from usuario where login = ? and senha = ? ");
			ps.setString(1, usuarioModelo.getUsuario());
			ps.setString(2,  usuarioModelo.getSenha());

			ResultSet rs = ps.executeQuery();
			Endereco enderecoConfirmado = new Endereco();

			while (rs.next()) {
				Long id = rs.getLong("idusuario");
				String usuario = rs.getString("login");
				String senha = rs.getString("senha");
				int tipoUsuario = rs.getInt("tipo_usuario");


				Usuario u = new Usuario();
				u.setId(id);
				u.setSenha(senha);
				u.setUsuario(usuario);
				u.setNivelAcesso(tipoUsuario);
			

				

				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			con.fecharConexao();
		}
		return null;
		

	}

	@Override
	public Usuario consultarUsuario(Long id) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from usuario where idusuario = ? ");
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			Usuario usuario = new Usuario();

			while (rs.next()) {
				Long idUsuario = rs.getLong("idusuario");
				String usuarioLogin= rs.getString("login");
				String senha = rs.getString("senha");
				int n_usuario = rs.getInt("tipo_usuario");
				


				Usuario usuarioNovo = new Usuario();
				
				usuarioNovo.setId(idUsuario);
				usuarioNovo.setUsuario(usuarioLogin);
				usuarioNovo.setSenha(senha);
				usuarioNovo.setNivelAcesso(n_usuario);
				
				return usuarioNovo;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			con.fecharConexao();
		}
		return null;
		
	}

}
