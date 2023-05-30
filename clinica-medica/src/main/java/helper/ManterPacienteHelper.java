package helper;

import controller.PacienteDao;
import model.Paciente;
import model.StatusTela;

public class ManterPacienteHelper {

	private PacienteDao pacienteDao;
	private Paciente pacienteConsulta;

	public StatusTela cadastrarPaciente(Paciente paciente) {
		
		pacienteConsulta = new Paciente();
		pacienteDao = new PacienteDao();
		
		pacienteConsulta = pacienteDao.consultarPacienteExistenteCpf(paciente.getCpf());
		if(pacienteConsulta != null) {
			return StatusTela.CPFEXISTENTE;
		}			
		boolean retorno =pacienteDao.cadastrarPaciente(paciente);
		if(retorno == false) {
			return StatusTela.ERROCADASTROPACIENTE; 
		}else {
			return StatusTela.PACIENTECADASTRADO;
		}

		
	}
	public StatusTela editarPaciente(Paciente paciente) {
		
		pacienteConsulta = new Paciente();
		pacienteDao = new PacienteDao();
		
		pacienteConsulta = pacienteDao.consultarPacienteExistenteCpf(paciente.getCpf());
		if(pacienteConsulta == null) {
			return StatusTela.PACIENTENAOEXISTENTE;
		}			
		boolean retorno =pacienteDao.alterarPaciente(paciente);
		if(retorno == false) {
			return StatusTela.ERROALTERARPACIENTE; 
		}else {
			return StatusTela.PACIENTEALTERADO;
		}
		
	}
}
