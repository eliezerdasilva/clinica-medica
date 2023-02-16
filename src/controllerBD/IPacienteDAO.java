package controllerBD;

import java.util.ArrayList;

import model.Paciente;
import view.TelaCadastroFuncionairo;

public interface IPacienteDAO {

	public boolean inserir(Paciente paciente);

	public boolean update(Paciente paciente);

	public boolean excluirPorCpf(Long cpf);

	public ArrayList<Paciente> listar();
	
	public abstract Paciente obterModelo();
}
