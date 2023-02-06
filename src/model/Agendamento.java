package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {
	
	private int id;
	private Cliente cliente;
	private Servico servico;
	private float valor ;
	private Date date;
	private String observacao;
	
	
	public Agendamento(int id, Cliente cliente, Servico servico, float valor, String date) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.servico = servico;
		this.valor = valor;
		try {
			this.date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
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
		return "Agendamento [id=" + id + ", cliente=" + cliente + ", servico=" + servico + ", valor=" + valor
				+ ", date=" + date + ", observacao=" + observacao + "]";
	}
	
	
	
	
	
}
