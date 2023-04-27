package controller;

import java.util.ArrayList;

import model.Medico;
import model.Paciente;
import model.Usuario;

public interface  InterfaceMedico {

	public abstract boolean cadastrarMedico(Medico medico);
	
	public boolean excluirMedico(Long cpf);
	
	public boolean alterarMedico(Medico medico);

	public boolean ConsultaCpfMedico(Long cpf);

	boolean consultarMedico(Long cpf);
	
	public ArrayList<Medico> listaMedicos();
	

}
