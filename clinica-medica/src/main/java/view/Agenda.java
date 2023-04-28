package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.AgendaDao;
import controller.MedicoDao;
import controller.PacienteDao;
import model.Consulta;
import model.Medico;
import model.Paciente;
import net.miginfocom.swing.MigLayout;
import utils.Jcaledar;
import javax.swing.event.AncestorListener;
import javax.swing.text.DateFormatter;
import javax.swing.event.AncestorEvent;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField textObservacao;
	private String usuario;
	private String senha;
	private JTextField txtTipoConsulta;
	private JTextField txtHora;
	private AgendaDao agenda = new AgendaDao();
	private PacienteDao pacienteDao = new PacienteDao();
	private JComboBox<Medico> cbxMedico;

	public Agenda(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Cadastrar consulta");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/logo.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
<<<<<<< HEAD
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(295)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(305)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane
						.createSequentialGroup().addGap(38).addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE)));
=======
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(294)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(305))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
>>>>>>> master
		panel.setLayout(new MigLayout("", "[1300:n:1300,grow]", "[900:n:900,grow]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 6));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(51, 153, 0)));
		panel_2.setBackground(new Color(51, 153, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));

		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 50));
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(236, 253, 232));
		panel_1.add(panel_3, BorderLayout.CENTER);
<<<<<<< HEAD
		panel_3.setLayout(new MigLayout("", "[][250:n:250,grow][][][][150:n:150,grow][][200:n:200,grow][250:n:200]",
				"[20:n:20][35:n:35][][35:n:35][][35:n:35][][350:n:350,grow][35px:n:35px][35:n:35][]"));

		JLabel lblNewLabel_2 = new JLabel("Nome : ");
=======
		panel_3.setLayout(new MigLayout("", "[933.00,grow][]", "[20:n:20][35:n:35][][35:n:35][][35:n:35][][350:n:350,grow][35px:n:35px]"));
		
		JLabel lblNewLabel_2 = new JLabel("Nome: ");
>>>>>>> master
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_2, "flowx,cell 1 1");

		txtNome = new JTextField();
		txtNome.setBackground(new Color(255, 255, 255));
		panel_3.add(txtNome, "cell 1 1,grow");
		txtNome.setColumns(20);
<<<<<<< HEAD

		JLabel lblNewLabel_3 = new JLabel("CPF :");
=======
		
		JLabel lblNewLabel_3 = new JLabel("   CPF:    ");
>>>>>>> master
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_3, "flowx,cell 3 1,alignx left");

		txtCpf = new JTextField();
		panel_3.add(txtCpf, "cell 3 1,grow");
		txtCpf.setColumns(20);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String cpfString = txtCpf.getText();
				Paciente pacienteAgendamento = null;
				if (cpfString == null || cpfString.trim() == "" || cpfString.isEmpty()) {
					int n = JOptionPane.showConfirmDialog(null, "Paciente não cadastrado, deseja cadastrar um novo paciente ?  " + "", "",
							JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.YES_OPTION) {
						TelaCadastroPaciente telaPaciente = new TelaCadastroPaciente(usuario, senha);
						telaPaciente.setLocationRelativeTo(null);
						telaPaciente.setVisible(true);
						dispose();
						
					}

				} else {
					Long cpf = Long.parseLong(cpfString);
					pacienteAgendamento = pacienteDao.consultarPacienteExistenteCpf(cpf);
					txtNome.setText(pacienteAgendamento.getNome());
				}
	

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
<<<<<<< HEAD
		panel_3.add(btnBuscar, "cell 5 1,grow");

		JLabel lblNewLabel_4 = new JLabel("Médico :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_4, "flowx,cell 1 3,alignx left");

		JLabel lblNewLabel_6 = new JLabel("Data : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_6, "flowx,cell 3 3,alignx left");

		JLabel lblNewLabel_8 = new JLabel("Hora : ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_8, "flowx,cell 5 3");

		JLabel lblNewLabel_7 = new JLabel("Observação\r\n");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_7, "flowx,cell 1 5");

		Jcaledar txtCaledar = new Jcaledar();
		txtCaledar.getCalendarButton().addActionListener(new ActionListener() {
=======
		panel_3.add(btnBuscar, "cell 0 1,grow");
		
		JLabel lblNewLabel_4 = new JLabel("Médico:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_4, "flowx,cell 0 3");
		
		JLabel lblNewLabel_7 = new JLabel("Observação\r\n:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_7, "flowx,cell 0 5");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(236, 253, 232));
		panel_4.setBorder(new LineBorder(new Color(51, 153, 0), 2));
		panel_3.add(panel_4, "cell 0 7,grow");
		panel_4.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 1077, 329);
		panel_4.add(table);
		
		JButton btnEditar = new JButton("Editar ");
		btnEditar.setBackground(new Color(240, 255, 240));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnEditar, "flowx,cell 0 8,grow");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_2, "cell 0 8");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(240, 240, 240));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnExcluir, "cell 0 8,grow");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(400);
		panel_3.add(horizontalStrut_1, "cell 0 8");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(240, 255, 240));
		btnVoltar.setForeground(new Color(0, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
>>>>>>> master
			public void actionPerformed(ActionEvent e) {
			}
		});
<<<<<<< HEAD

		panel_3.add(txtCaledar, "cell 3 3,grow");
		txtCaledar.setPreferredSize(new Dimension(120, 20));
		contentPane.setLayout(gl_contentPane);

		JLabel lblNewLabel_5 = new JLabel("Tipo de Consulta : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel_3.add(lblNewLabel_5, "cell 3 5");

		txtTipoConsulta = new JTextField();
		panel_3.add(txtTipoConsulta, "cell 5 5,grow");
		txtTipoConsulta.setColumns(10);

=======
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnVoltar, "cell 0 8,grow");
		
		JComboBox cbxMedico = new JComboBox();
		cbxMedico.setModel(new DefaultComboBoxModel(new String[] {"                                             "}));
		panel_3.add(cbxMedico, "cell 0 3,growy");
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de Consulta: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel_3.add(lblNewLabel_5, "cell 0 3");
		
		textConsulta = new JTextField();
		panel_3.add(textConsulta, "cell 0 3,grow");
		textConsulta.setColumns(20);
		
		JLabel lblNewLabel_6 = new JLabel("Data: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_6, "cell 0 3");
		
		textData = new JTextField();
		panel_3.add(textData, "cell 0 3,grow");
		textData.setColumns(15);
		
>>>>>>> master
		textObservacao = new JTextField();
		panel_3.add(textObservacao, "cell 1 5,grow");
		textObservacao.setColumns(25);

		txtHora = new JTextField();
		panel_3.add(txtHora, "cell 5 3,growy");
		txtHora.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date data = txtCaledar.getDate();

				String nome = txtNome.getText();

				String cpf = txtCpf.getText().replace(".", "").replace("-", "");

				String tipoConsulta = txtTipoConsulta.getText();

				String observacao = textObservacao.getText();

				String validacao = "";

				String hora = txtHora.getText();

				Consulta c = new Consulta();
				Paciente p = new Paciente();

				if (nome == null || nome.trim() == "" || nome.isEmpty()) {
					txtNome.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					validacao += "Nome\n";
				} else {
					p.setNome(nome);
				}

				if (cpf == null || cpf.trim() == "" || cpf.isEmpty()) {
					txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					validacao += "CPF\n";
				} else {
					Long cpfLong = Long.valueOf(cpf);
					p.setCpf(cpfLong);
				}
				c.setPaciente(p);

				if (tipoConsulta == null || tipoConsulta.trim() == "" || tipoConsulta.isEmpty()) {
					txtTipoConsulta.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					validacao += "Tipo consulta\n";
				} else {
					c.setServico(tipoConsulta);
				}

				if (data == null) {
					txtCaledar.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					validacao += "Dat\n";

				} else {
					SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
					System.out.println(data);
					String dataFormatada = formatador.format(data);
					System.out.println(dataFormatada);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataFormatadaNova = LocalDate.parse(dataFormatada,formatter);
					c.setDate(dataFormatadaNova);
				}
				if (hora == null || hora.trim() == "" || hora.isEmpty()) {
					txtHora.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				} else {
					SimpleDateFormat dt = new SimpleDateFormat("hh:mm"); 
					Date date = null;
					try {
						date = dt.parse(hora);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					 DateFormat df = new SimpleDateFormat("HH:mm");					
					
					 try {
						Date datse = df.parse(hora);
						Timestamp ts = new Timestamp(date.getTime());
						c.setHora(ts);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				Medico medico = (Medico) cbxMedico.getSelectedItem();
				Long cp = medico.getCpf();
				medico.setCpf(cp);
				c.setMedico(medico);

				if (observacao == null || observacao.trim() == "" || observacao.isEmpty()) {
					textObservacao.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				} else {
					c.setObservacao(observacao);
				}
				boolean cadastroConsulta = agenda.cadastraConsulta(c);
				if (cadastroConsulta != true) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
				} else {

					JOptionPane.showMessageDialog(null, "Consulta cadastrada");
				}

			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.add(panel_4, "cell 1 7 8 1,grow");
		panel_4.setLayout(null);

		btnCadastrar.setBackground(new Color(240, 255, 240));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnCadastrar, "cell 7 5,grow");

		cbxMedico = new JComboBox();
		cbxMedico.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				ArrayList<Medico> medicos = new ArrayList<Medico>();
				MedicoDao medicoDao = new MedicoDao();
				medicos = medicoDao.listaMedicos();
				for (int i = 0; i < medicos.size(); i++) {
					cbxMedico.addItem(medicos.get(i));
				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_3.add(cbxMedico, "cell 1 3,grow");

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(240, 255, 240));
		btnVoltar.setForeground(new Color(0, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal(usuario, senha);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();
			}
		});

		JButton btnEditar = new JButton("Editar ");
		btnEditar.setBackground(new Color(240, 255, 240));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnEditar, "cell 1 9,grow");

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(240, 240, 240));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnExcluir, "cell 3 9,grow");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnVoltar, "cell 7 9,grow");

	}
}
