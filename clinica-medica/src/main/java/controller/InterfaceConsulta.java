package controller;

import java.util.ArrayList;

import model.Consulta;
import view.Agenda;

public interface InterfaceConsulta {
	
	public boolean cadastraConsulta(Consulta consulta);
	
	public boolean alterarConsulta(Consulta consulta);
	
	public boolean excluitConsulta(Consulta consulta);
	 
	public ArrayList<Agenda> listConsulta();
	
	public ArrayList<Agenda> listConsultaDia();
	
	public ArrayList<Agenda> listConsultaSemana();
	
	public ArrayList<Agenda> listConsultaMes();
	
	public Agenda consultaAgendaPaciente();

}
