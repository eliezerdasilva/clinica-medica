package model;

public class Medico extends Pessoa {

	private long crm;
	private String especializacao;
	
	public Medico(int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg,
			long crm, String especializacao) {
		super(id, nome, sexo, dataNascimento, telefone, email, rg);
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
