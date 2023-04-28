package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {
	
	private int id;

	
	private float valor ;
	private Date date;
	private String observacao;
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * nao esta sendo usada
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public Agendamento() {
		
	}
	
	public Agendamento(int id, float valor, Date date, String observacao) {
		super();
		this.id = id;
		this.valor = valor;
		this.date = date;
		this.observacao = observacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public Date getDate() {
		return date;
	}
	public String getDataFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
		
	}
	public String getHoraFormatada(){
		return new SimpleDateFormat("HH:mm").format(date);
		
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	@Override
	public String toString() {
		return  "servico=" +", valor=" + valor
				+ ", date=" + date + ", observacao=" + observacao + "]";
	}
	
	
	
	
	
}
