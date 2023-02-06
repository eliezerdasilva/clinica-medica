package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Pessoa  {

	protected  int id;
	protected  String nome;
	protected  char sexo;
	protected  Date dataNascimento;
	protected  String telefone;
	protected  String email;
	protected  String rg;
	
	public Pessoa(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Pessoa(int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		try {
			this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		};
		this.telefone = telefone;
		this.email = email;
		this.rg = rg;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	

}

