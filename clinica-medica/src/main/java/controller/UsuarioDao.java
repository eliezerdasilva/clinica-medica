package controller;

import java.sql.Connection;
import java.sql.Date;
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
			int valida = 0;
			
		
			try {
				String query = "INSERT INTO usuario(login,senha,tipo_usuario) values(?,?,?);";
				PreparedStatement stm = c.prepareStatement(query);
				stm.setString(1, usuario.getUsuario());
				stm.setString(2, usuario.getSenha());
				stm.setInt(3, usuario.getNivelAcesso());
	
				
				valida =  stm.executeUpdate();

			
				
			
			}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
			return (valida == 0 ? false : true);


	}

	@Override
	public boolean deletarUsuario(Usuario usuario) {
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
			PreparedStatement ps = c.prepareStatement("select * from medico where login = ? ");
			  ps.setString(1, usuarioModelo.getUsuario());
		
			
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


	@Override
	public Usuario alterarUsuario(Usuario usuario) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement stm = null;
		int valida = 0; 
		Usuario usuarioNovo = new Usuario();
		try {
			stm= c.prepareStatement("Select * from  usuario where login = ? and senha = ?");
			stm.setString(1, usuario.getUsuario());
			stm.setString(2,usuario.getSenha());
			
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Long idUsuario = rs.getLong("idusuario");
				String usuarioLogin= rs.getString("login");
				String senha = rs.getString("senha");
				int n_usuario = rs.getInt("tipo_usuario");
				
				usuarioNovo.setId(idUsuario);
				usuarioNovo.setUsuario(usuarioLogin);
				usuarioNovo.setSenha(senha);
				usuarioNovo.setNivelAcesso(n_usuario);
			} 
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			stm = c.prepareStatement ("update usuario SET login = ?, senha = ? , tipo_usuario = ? WHERE idusuario = ? "
					);
			
			stm.setString(1, usuarioNovo.getUsuario());
			stm.setString(2, usuarioNovo.getSenha());
			stm.setInt(3, usuarioNovo.getNivelAcesso());
			stm.setLong(4,usuarioNovo.getId());
			 stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return usuarioNovo;
	}

	@Override
	public boolean consultarUsuarioExistente(String Usuario) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			PreparedStatement stm = c.prepareStatement("Select * from  usuario where login = ? ");
			stm.setString(1, Usuario);
			valida = stm.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		
		return (valida == 0 ? false : true);
	}

}
