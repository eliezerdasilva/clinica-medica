package controller;

import java.util.ArrayList;

import model.Paciente;

public interface InterfacePacienteDao {
	
	public Boolean inserir(Paciente paciente);
	public Boolean Editar(Paciente paciente);
	public Boolean excluir(Paciente paciente);
	public static final ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();

}
