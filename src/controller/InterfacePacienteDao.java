package controller;

import model.Paciente;

public interface InterfacePacienteDao {
	

	public boolean cadastrarPaciente(Paciente paciente);
	
	public boolean excluirPaciente(Paciente paciente);
	
	public boolean alterarPaciente(Paciente paciente);
	
	public Paciente consultarPaciente(Paciente paciente);


}
