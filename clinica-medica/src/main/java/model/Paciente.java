package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {

	private String observacao;
	private String profissao;
	private Convenio convenio;
	private String sobre;

	public Paciente() {
		super();
	}


	public Paciente(String observacao, String profissao, Convenio convenio, String sobre) {
		super();
		this.observacao = observacao;
		this.profissao = profissao;
		this.convenio = convenio;
		this.sobre = sobre;
	}
	public Paciente(String nome, String sexo, Endereco endereco, Long cpf, LocalDate dataNascimento, String telefone,
			String email, String rg, String observacao, String profissao, Convenio convenio, String sobre) {
		super(nome, sexo, endereco, cpf, dataNascimento, telefone, email, rg);
		this.observacao = observacao;
		this.profissao = profissao;
		this.convenio = convenio;
		this.sobre = sobre;
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
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	
	



	
}
