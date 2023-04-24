package model;
//package model;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class Agendamento {
//	
//	private int id;
//
//	private Servico servico;
//	private float valor ;
//	private Date date;
//	private String observacao;
//	
//	
//	public Agendamento(int id, Servico servico, float valor, String date) {
//		super();
//		this.id = id;
//		
//		this.servico = servico;
//		this.valor = valor;
//		try {
//			this.date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//	
//
//	public Agendamento(Servico servico, float valor, String date, String observacao) {
//		this(0,  servico, valor, date, observacao);
//	}
//	public Agendamento(int id, Servico servico, float valor, String date, String observacao) {
//		this(id, servico, valor, date);
//		this.observacao = observacao;
//	}
//
//
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//
//
//
//	public Servico getServico() {
//		return servico;
//	}
//
//
//	public void setServico(Servico servico) {
//		this.servico = servico;
//	}
//
//
//	public float getValor() {
//		return valor;
//	}
//
//
//	public void setValor(float valor) {
//		this.valor = valor;
//	}
//
//
//	public Date getDate() {
//		return date;
//	}
//	public String getDataFormatada() {
//		return new SimpleDateFormat("dd/MM/yyyy").format(date);
//		
//	}
//	public String getHoraFormatada(){
//		return new SimpleDateFormat("HH:mm").format(date);
//		
//	}
//
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//
//	public String getObservacao() {
//		return observacao;
//	}
//
//
//	public void setObservacao(String observacao) {
//		this.observacao = observacao;
//	}
//
//
//	@Override
//	public String toString() {
//		return  "servico=" + servico + ", valor=" + valor
//				+ ", date=" + date + ", observacao=" + observacao + "]";
//	}
//	
//	
//	
//	
//	
//}
