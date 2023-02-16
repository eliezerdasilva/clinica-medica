package model;

public class Paciente extends Pessoa {
	
	private String observacao;

	public Paciente(int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg,
			String observacao) {
		super(id, nome, sexo, dataNascimento, telefone, email, rg);
		this.observacao = observacao;
	}
	
	

}
