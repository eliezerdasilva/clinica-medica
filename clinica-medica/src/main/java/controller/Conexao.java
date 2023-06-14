package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Conexao {

	private static Connection conexao;
	private static Conexao instancia;

	private static final String DATABASE = "clinica";
	private static final String USER = "root";
	private static final String PSW = "root";

	private Conexao() {

	}

	public static Conexao getInstacia() {
		if (instancia == null) {
			instancia = new Conexao();
		}
		return instancia;
	}

	public Connection conectar() {
		String configFilePath = "src\\main\\java\\controller\\config.txt";
		String localhost = "";
		String dbName = "";
		String username = "";
		String password = "";

		try {
		
			File configFile = new File(configFilePath);
			Scanner scanner = new Scanner(configFile);
			localhost = scanner.nextLine();
			dbName = scanner.nextLine();
			username = scanner.nextLine();
			password = scanner.nextLine();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conexao = DriverManager.getConnection("jdbc:mysql://"+localhost+"/" + dbName + "?serverTimezone=UTC", username,	password);
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
