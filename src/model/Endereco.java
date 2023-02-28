package model;

public class Endereco {

	private int cep;
	private String estado;
	private String bairro;
	private String cidade;
	private String rua;
	

	
	public Endereco() {
	
	}


	public Endereco(String rua,String bairro) {
		super();
		this.rua = rua;
		
		this.bairro = bairro;
	}
	

	public Endereco(int cep, String estado, String bairro, String cidade, String rua) {
		super();
		this.cep = cep;
		this.estado = estado;
		this.bairro = bairro;
		this.cidade = cidade;
		this.rua = rua;
	}


	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
