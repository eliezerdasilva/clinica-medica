package controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Estado;

public interface IEnderecoDao {
	
	public Endereco consultarEndereco(Endereco endereco);
	
	public boolean inserirEndereco(Endereco endereco);
	
	public ArrayList<Estado> ConsultaEstadoCidade();
	
	public boolean excluirEndereco(Endereco endereco);
	public boolean alterarEndereco(Endereco endereco);

}
