package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class LoginDao implements InterfaceLogin {

	private Conexao con;

	@Override
	public Usuario consultarLogin(Usuario usuario) {

		try {

			con = Conexao.getInstacia();
			Connection c = con.conectar();
			PreparedStatement ps = c.prepareStatement("select * from usuario where login = ? and senha = ?");
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());

			ResultSet rs = ps.executeQuery();
			Usuario usuarioConectado = new Usuario();
			while (rs.next()) {
				long idUsuario = rs.getInt("idusuario");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int tipoUsuario = rs.getInt("tipo_usuario");

				usuarioConectado.setId(idUsuario);
				usuarioConectado.setUsuario(login);
				usuarioConectado.setSenha(senha);
				usuarioConectado.setNivelAcesso(tipoUsuario);

				return usuarioConectado;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			con.fecharConexao();
		}

		return null;
	}


}
