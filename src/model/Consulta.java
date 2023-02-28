package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Consulta {

	private int id;
	private LocalDate date;
	private Servico servico;
	private String observacao;

	public Consulta(int id, Servico servico, float valor, String date) {
		super();
		this.id = id;

		this.servico = servico;
		// TODO corrigir data
		int dia = 28;
		int mes = 02;
		int ano = 2023;
		this.date = LocalDate.of(ano, mes, dia);
	}

	public Consulta(Servico servico, float valor, String date, String observacao) {
		this(0, servico, valor, date, observacao);
	}

	public Consulta(int id, Servico servico, float valor, String date, String observacao) {
		this(id, servico, valor, date);
		this.observacao = observacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDataFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);

	}

	public String getHoraFormatada() {
		return new SimpleDateFormat("HH:mm").format(date);

	}

	public void setDate(LocalDate date) {
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
		return "servico=" + servico + ", date=" + date + ", observacao=" + observacao + "]";
	}

}
