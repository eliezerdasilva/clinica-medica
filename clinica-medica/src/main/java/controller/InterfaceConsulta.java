package controller;

import java.util.ArrayList;

import model.Consulta;
import view.Agenda;

public interface InterfaceConsulta {
	
	public boolean cadastraConsulta(Consulta consulta);
	
	public boolean alterarConsulta(Consulta consulta);
	
	public boolean excluitConsulta(Consulta consulta);
	 
	public ArrayList<Consulta> listConsulta();
	
	public ArrayList<Consulta> listConsultaDia();
	
	public ArrayList<Consulta> listConsultaSemana();
	
	public ArrayList<Consulta> listConsultaMes();
	
	public Consulta consultaAgendaPaciente();

}
