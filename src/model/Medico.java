package model;

public class Medico extends Pessoa {

	private long crm;
	private String crmUf;
	private String especializacao;
	private Usuario usuario;

	public final Usuario getUsuario() {
		return usuario;
	}

	public final void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Medico() {}

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

	public String getCrmUf() {
		return crmUf;
	}

	public void setCrmUf(String crmUf) {
		this.crmUf = crmUf;
	}

}
