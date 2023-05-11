package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.LocalTime;



public class Consulta {

	private int id;
	private LocalDate date;
	private LocalTime hora; 
	private String servico;
	private String observacao;
	private Paciente paciente;
	private Medico medico;
	
	
	public Consulta(){}
 


	public Consulta(int id, LocalDate date, LocalTime hora, String servico, String observacao, Paciente paciente,
			Medico medico) {
		super();
		this.id = id;
		this.date = date;
		this.hora = hora;
		this.servico = servico;
		this.observacao = observacao;
		this.paciente = paciente;
		this.medico = medico;
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
	

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public String toString() {
		return "servico=" + servico + ", date=" + date + ", observacao=" + observacao + "]";
	}

}
