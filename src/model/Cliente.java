package model;

public class Cliente extends Pessoa{
	
	
	public Cliente(int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg, String string, String string2) {
		super(id, nome, sexo, dataNascimento, telefone, email, rg);
		// TODO Auto-generated constructor stub
	}
	



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}




	protected Endereco endereco;

	
	
	public String toString() {
		return  getNome();
	}
 
}
