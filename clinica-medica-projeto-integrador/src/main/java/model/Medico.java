package model;

import java.time.LocalDate;

public class Medico extends Pessoa {

	private long crm;
	private String especializacao;
	private Usuario usuario;
	
	

	public Medico() {
		super();
	}
	
	

	public Medico(String nome, String sexo, Endereco endereco, Long cpf, LocalDate dataNascimento, String telefone,
			String email, String rg, long crm, String especializacao, Usuario usuario) {
		super(nome, sexo, endereco, cpf, dataNascimento, telefone, email, rg);
		this.crm = crm;
		this.especializacao = especializacao;
		this.usuario = usuario;
	}



	public final Usuario getUsuario() {
		return usuario;
	}

	public final void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Medico(long crm, String especializacao) {
		super();
		this.crm = crm;
		this.especializacao = especializacao;
	}

	public final long getCrm() {
		return crm;
	}

	public final void setCrm(long crm) {
		this.crm = crm;
	}

	public final String getEspecializacao() {
		return especializacao;
	}

	public final void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

}
