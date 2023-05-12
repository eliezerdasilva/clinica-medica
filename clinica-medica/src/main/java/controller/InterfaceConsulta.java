package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Consulta;
import view.Agenda;

public interface InterfaceConsulta {
	
	public boolean cadastraConsulta(Consulta consulta);
	
	public boolean alterarConsulta(Consulta consulta);
	
	public boolean excluitConsulta(Consulta consulta);
	 
	public ArrayList<Consulta> listConsulta();
	
	public ArrayList<Consulta> listConsultaDia(LocalDate date);
	
	public ArrayList<Consulta> listConsultaSemana();
	
	public ArrayList<Consulta> listConsultaMes();
	
	public Consulta consultaAgendaPaciente();

}
