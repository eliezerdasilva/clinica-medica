package model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;

public class Consulta {

	private int id;
	private LocalDate date;
	private Instant hora; 
	private String servico;
	private String observacao;
	private Paciente paciente;
	
	public Consulta(){}
 
	public Consulta(int id, LocalDate date, Instant hora, String servico, String observacao, Paciente paciente) {
		super();
		this.id = id;
		this.date = date;
		this.hora = hora;
		this.servico = servico;
		this.observacao = observacao;
		this.paciente = paciente;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

	public Instant getHora() {
		return hora;
	}

	public void setHora(Instant hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "servico=" + servico + ", date=" + date + ", observacao=" + observacao + "]";
	}

}
