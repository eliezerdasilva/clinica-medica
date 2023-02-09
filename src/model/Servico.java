package model;

public class Servico {
	
	private int id;
	private String descricao;
	private float valor;
	
	public Servico() {
		
	}
	public Servico(int id, String descricao, float valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return getDescricao();
	}
	

}
