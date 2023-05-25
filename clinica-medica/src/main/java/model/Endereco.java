package model;

import java.util.Objects;

public class Endereco {

	private int cep;
	private String bairro;
	private String cidade;
	private String rua;
	private Estado estado;
	
	public Endereco(String string) {
	
	}
	public Endereco(int cep) {
		this.cep = cep;
	}
	public Endereco(String rua,String bairro) {
		super();
		this.rua = rua;
		
		this.bairro = bairro;
	}
	public Endereco(int cep, Estado estado, String bairro, String cidade, String rua) {
		super();
		this.cep = cep;
		this.estado = estado;
		this.bairro = bairro;
		this.cidade = cidade;
		this.rua = rua;
	}
	public Endereco() {
		// TODO Auto-generated constructor stub
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
	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, estado, rua);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && cep == other.cep && Objects.equals(cidade, other.cidade)
				&& Objects.equals(estado, other.estado) && Objects.equals(rua, other.rua);
	}
	

}
