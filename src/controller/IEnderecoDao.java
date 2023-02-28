package controller;

import model.Endereco;

public interface IEnderecoDao {
	
	public Endereco ConsultarEndereco(Endereco endereco);
	
	public boolean InserirEndereco(Endereco endereco);

}
