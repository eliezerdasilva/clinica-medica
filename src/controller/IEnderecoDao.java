package controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;

public interface IEnderecoDao {
	
	public Endereco ConsultarEndereco(Endereco endereco);
	
	public boolean InserirEndereco(Endereco endereco);
	
	public ArrayList<String> ConsultaEstadoCidade();

}
