package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {

	private String observacao;
	private String profissao;
	private Convenio convenio;

	public Paciente() {
		super();
	}

	public Paciente(String observacao, String profissao, Convenio convenio) {
		super();
		this.observacao = observacao;
		this.profissao = profissao;
		this.convenio = convenio;
	}
	public Paciente(String nome, String sexo, Endereco endereco, int cpf, LocalDate dataNascimento, String telefone,
			String email, String rg, String observacao, String profissao, Convenio convenio) {
		super(nome, sexo, endereco, cpf, dataNascimento, telefone, email, rg);
		this.observacao = observacao;
		this.profissao = profissao;
		this.convenio = convenio;
	}

	public final String getObservacao() {
		return observacao;
	}

	public final void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public final String getProfissao() {
		return profissao;
	}

	public final void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	



	
}
