package model;

public class Paciente extends Pessoa {

	private String observacao;
	private String profissao;
	private String convenio;

	public Paciente() {
		super();
	}

	public Paciente(String observacao, String profissao, String convenio) {
		super();
		this.observacao = observacao;
		this.profissao = profissao;
		this.convenio = convenio;
	}
	
	
	public Paciente(String nome, String sexo, Endereco endereco, Long cpf, String dataNascimento,
			String telefone, String email, String rg, String observacao, String profissao, String convenio) {
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

	public final String getConvenio() {
		return convenio;
	}

	public final void setConvenio(String convenio) {
		this.convenio = convenio;
	}

}
