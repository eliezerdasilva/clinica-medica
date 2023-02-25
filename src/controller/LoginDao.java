package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao implements InterfaceLogin {

	private Conexao con;

	@Override
	public boolean ConferirLogin(String usuario, String senha) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		boolean check = false;
		try {
			stmt = c.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}

		return check;
	}

}
