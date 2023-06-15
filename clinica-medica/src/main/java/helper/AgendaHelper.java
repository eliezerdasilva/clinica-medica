package helper;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.AgendaDao;
import controller.PacienteDao;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Usuario;
import view.Agenda;
import view.TelaCadastroPaciente;

public class AgendaHelper {
	AgendaDao agendaDao;

	private Agenda agenda;
	private Consulta consultaClick = new Consulta();

	public Paciente buscarPaciente(String cpf, Usuario usuario, Agenda agendaTela) {

		PacienteDao pacienteDao = new PacienteDao();
		Paciente paciente = new Paciente();
		if (cpf == null || cpf.trim() == "" || cpf.isEmpty()) {
			int n = JOptionPane.showConfirmDialog(null,
					"Paciente não cadastrado, deseja cadastrar um novo paciente ?  " + "", "",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				TelaCadastroPaciente telaPaciente = new TelaCadastroPaciente(usuario);
				telaPaciente.setLocationRelativeTo(null);
				telaPaciente.setVisible(true);
				agendaTela.dispose();

			}
		} else {
			Long cpfLong = Long.parseLong(cpf);
			paciente = pacienteDao.consultarPacienteExistenteCpf(cpfLong);
			return paciente;
		}
		return null;
	}

	public boolean editarPaciente(Consulta consulta) {

		AgendaDao agendaDao = new AgendaDao();
		boolean alterarConsulta = agendaDao.alterarConsulta(consulta);

		return alterarConsulta;

	}


	public boolean cadastrarConsulta(Consulta consulta) {
		
		AgendaDao agendaDao = new AgendaDao();
		boolean cadastroConsulta = agendaDao.cadastraConsulta(consulta);
		
		
		return cadastroConsulta;
		
	}
}
