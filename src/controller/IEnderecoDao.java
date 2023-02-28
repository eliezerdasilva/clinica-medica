package controller;

import model.Endereco;

public interface IEnderecoDao {
	
	public Endereco ConsultarEndereco(Endereco endereco);
	
	public Endereco InserirEndereco(Endereco endereco);

}
