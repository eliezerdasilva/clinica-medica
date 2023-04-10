package controller;

import model.Medico;

public interface  InterfaceMedico {

	public abstract boolean cadastrarMedico(Medico medico);
	
	public boolean excluirMedico(Medico medico);
	
	public boolean alterarMedico(Medico medico);

	public boolean ConsultaCpfMedico(Long cpf);

	boolean consultarMedico(Long cpf);

}
