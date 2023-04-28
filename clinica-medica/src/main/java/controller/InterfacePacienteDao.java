package controller;

import java.util.ArrayList;

import model.Convenio;
import model.Paciente;

public interface InterfacePacienteDao {
	

	public boolean cadastrarPaciente(Paciente paciente);
	
	public boolean alterarPaciente(Paciente paciente);
	
	public ArrayList<Paciente>  consultarPaciente();
	
	public ArrayList<Convenio> consultaConvenio();
	
	public boolean ConsultaCpfPaciente(Long cpfConsulta);

	boolean excluirPaciente(Long cpf);

	public Paciente consultarPacienteExistenteNome(String nome);

	public Paciente consultarPacienteExistenteCpf(Long cpf);


}
