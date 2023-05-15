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

	public boolean editarPaciente(Agenda agendaTela, Consulta consultaClick) {

		Consulta consulta = coletarDados(agendaTela, consultaClick);
		agendaDao = new AgendaDao();

		boolean cadastroConsulta = agendaDao.alterarConsulta(consulta);

		return cadastroConsulta;

	}

	public static Consulta coletarDados(Agenda agendaTela, Consulta consultaClick) {

		JTextField textField = new JTextField();

		Date data = agendaTela.getTxtCaledar().getDate();
		String nome = agendaTela.getTxtNome().getText();
		String cpf = agendaTela.getTxtCpf().getText();
		String tipoConsulta = agendaTela.getTxtTipoConsulta().getText();
		String observacao = agendaTela.getTxtObservacao().getText();
		String validacao = "";
		String hora = agendaTela.getTxtHora().getText();

		Consulta consulta = new Consulta();
		Paciente paciente = new Paciente();
		if (consultaClick != null) {
			consulta.setId(consultaClick.getId());
		}
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			agendaTela.getTxtNome().setBorder(new LineBorder(new Color(255, 00, 00), 4));

			validacao += "Nome\n";
		} else {
			paciente.setNome(nome);
		}

		if (cpf == null || cpf.trim() == "" || cpf.isEmpty()) {
			agendaTela.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "CPF\n";
		} else {
			Long cpfLong = Long.valueOf(cpf);
			paciente.setCpf(cpfLong);
		}
		consulta.setPaciente(paciente);

		if (tipoConsulta == null || tipoConsulta.trim() == "" || tipoConsulta.isEmpty()) {
			agendaTela.getTxtTipoConsulta().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Tipo consulta\n";
		} else {
			consulta.setServico(tipoConsulta);
		}

		if (data == null) {
			agendaTela.getTxtCaledar().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Dat\n";

		} else {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

			String dataFormatada = formatador.format(data);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataFormatadaNova = LocalDate.parse(dataFormatada, formatter);
			consulta.setDate(dataFormatadaNova);
		}
		if (hora == null || hora.trim() == "" || hora.isEmpty()) {
			agendaTela.getTxtHora().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {

			LocalTime ts = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
			consulta.setHora(ts);

		}
		Medico medico = (Medico) agendaTela.getCbxMedico().getSelectedItem();
		Long cp = medico.getCpf();
		medico.setCpf(cp);
		consulta.setMedico(medico);

		if (observacao == null || observacao.trim() == "" || observacao.isEmpty()) {
			agendaTela.getTxtObservacao().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			consulta.setObservacao(observacao);
		}
		return consulta;

	}
	public boolean cadastrarConsulta(Agenda dadosTelaConsulta) {
		
		Consulta retornoColetaDados = coletarDados(dadosTelaConsulta,null);
		
		agendaDao = new AgendaDao();
		boolean cadastroConsulta = agendaDao.cadastraConsulta(retornoColetaDados);
		
		
		return cadastroConsulta;
		
	}
}
