package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Usuario;

public class loginDao implements InterfaceLogin{

	private Conexao con;
	@Override
	public boolean consularLogin(Usuario usuario) {
		Connection conn = Conexao.getInstacia().conectar();
		try {
			String query = "SELECT usuario, senha FROM usuarios  WHERE usuario = ?  and senha = ?";
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setString(1,usuario.getUsuario());
			stm.setString(2,usuario.getSenha());
			int valida = stm.executeUpdate();
			JOptionPane.showMessageDialog(null,"Feito","BD", JOptionPane.PLAIN_MESSAGE);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		con.fecharConexao();
		return false;
		
	}
	

}
