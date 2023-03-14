package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

	private Usuario usuario;
	

	public Funcionario() {
	
	}

	public Funcionario(String nome, String sexo, Endereco endereco, int endereco_cep, int numero, String complemento, Long cpf, LocalDate dataNascimento, String telefone,
			String email, String rg, Usuario usuario) {
		super(nome, sexo, endereco, cpf, dataNascimento, telefone, email, rg);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
