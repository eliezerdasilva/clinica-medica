package controller;
import java.io.BufferedReader;	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Conexao {

	private static Connection conexao;
	private static Conexao instancia;

	private static String DATABASE = null;
	private static String USER = null;
	private static String PSW = null;

	private Conexao() {
			
	}

	public static Conexao getInstacia() {
		if (instancia == null) {
			instancia = new Conexao();
			lerArquivoBD();
		}
		return instancia;
	}
		
	public Connection conectar() {
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER,
					PSW);
			return conexao;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static void lerArquivoBD() {
		// Lê as informações de login e senha do arquivo de texto
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
			if (reader != null) {
				DATABASE = reader.readLine(); 
				USER = reader.readLine(); 
				PSW = reader.readLine(); 
			}
			reader.close();

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
			return;
		}
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
