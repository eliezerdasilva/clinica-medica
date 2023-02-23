package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	private static Connection conexao;
	private static Conexao instancia;
	private static final String DATABASE = "jdbc";
	private static final String USER = "root";
	private static final String PSW = "Eliezer-2005";

	private Conexao() {

	}

	public static Conexao getInstacia() {
		if (instancia == null) {
			instancia = new Conexao();
		}
		return instancia;
	}

	public static Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER,
					PSW);
			JOptionPane.showMessageDialog(null,"Conectado",null,JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;

	}

	public boolean fecharConexao() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
