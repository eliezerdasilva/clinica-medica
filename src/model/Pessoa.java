package model;

import java.time.LocalDate;

public abstract class Pessoa {

	private int id;
	private Long cpf;
	private String nome;
	private LocalDate dataNascimento;
	private String email;
	private String sexo;
	private String telefone;
	private Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Pessoa(int id, String nome, String sexo, Endereco endereco, Long cpf, String dataNascimento, String telefone,
			String email, String rg) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		// TODO corrigir data
		int dia = 28;
		int mes = 02;
		int ano = 2023;
		this.dataNascimento = LocalDate.of(ano, mes, dia);
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
