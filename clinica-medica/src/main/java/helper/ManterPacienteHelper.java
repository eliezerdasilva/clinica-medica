package helper;

import controller.EnderecoDao;
import controller.PacienteDao;
import model.Endereco;
import model.Paciente;
import model.StatusTela;

public class ManterPacienteHelper {

	private PacienteDao pacienteDao;
	private Paciente pacienteConsulta;

	public StatusTela cadastrarPaciente(Paciente paciente) {

		pacienteConsulta = new Paciente();
		pacienteDao = new PacienteDao();
		Endereco endereco = new Endereco();
		EnderecoDao enderecoDao = new EnderecoDao();
		endereco = enderecoDao.consultarEndereco(paciente.getEndereco());
		if(endereco == null) {
			boolean retornoEndereco = enderecoDao.inserirEndereco(paciente.getEndereco());
			if (!retornoEndereco) {
				return StatusTela.ERROCADASTROPACIENTE;
			}
		}
		
		pacienteConsulta = pacienteDao.consultarPacienteExistenteCpf(paciente.getCpf());
		if (pacienteConsulta != null) {
			return StatusTela.CPFEXISTENTE;
		}
		boolean retorno = pacienteDao.cadastrarPaciente(paciente);
		if (retorno == false) {
			return StatusTela.ERROCADASTROPACIENTE;
		} else {
			return StatusTela.PACIENTECADASTRADO;
		}

	}

	public StatusTela editarPaciente(Paciente paciente) {

		pacienteConsulta = new Paciente();
		pacienteDao = new PacienteDao();

		pacienteConsulta = pacienteDao.consultarPacienteExistenteCpf(paciente.getCpf());
		if (pacienteConsulta == null) {
			return StatusTela.PACIENTENAOEXISTENTE;
		}
		boolean retorno = pacienteDao.alterarPaciente(paciente);
		if (retorno == false) {
			return StatusTela.ERROALTERARPACIENTE;
		} else {
			return StatusTela.PACIENTEALTERADO;
		}

	}
}
