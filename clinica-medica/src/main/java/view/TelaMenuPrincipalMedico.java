package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.AgendaDao;
import controller.EnderecoDao;
import controller.MedicoDao;
import controller.UsuarioDao;
import model.Consulta;
import model.Endereco;
import model.Medico;
import model.Paciente;
import model.Usuario;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaMenuPrincipalMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String loginUsuario;
	private String senha;
	private int nivelAcesso;
	private JTable table;
	private ArrayList<Consulta> listConulta;
	private Consulta consulta;
	private AgendaDao agendaDao;
	private Consulta consultaClick;
	private Usuario usuario;
	private MedicoDao medicoDao;
	private Medico medico;
	private JPanel panelSairPerfil;
	private JLabel lblNewLabel;
	private JButton btnSair;
	private int sairPerfil;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtDataNascimeto;
	private JTextField txtEspecializacao;
	private JTextField txtTelefone;
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JTextField txtNCasa;
	private int totaldeConsulta;
	private int filaDeEspera;
	private int naoPresentes;
	private SimpleDateFormat formatDate;
	private JTextField txtBairro;
	private JLabel pacientesAtendidos;
	private JLabel lblNewLabel_2;
	private JLabel totalConsulta;
	private JLabel filaEspera;

	public TelaMenuPrincipalMedico(Usuario login) {
		this.loginUsuario = login.getUsuario();
		this.senha = login.getSenha();
		this.nivelAcesso = login.getNivelAcesso();
		this.usuario = login;
		medico = new Medico();
		medicoDao = new MedicoDao();
		medico = medicoDao.consultarUsuarioMedico(usuario);
		formatDate = new SimpleDateFormat("dd/MM/yyyy");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1900, 400));
		setBounds(100, 100, 2000, 1050);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Menu principal");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/LocoHospital.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 150, 891, 706);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Data", "Hora", "Status" }));
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1130, 150, 360, 150);
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBorder(new LineBorder(new Color(143, 188, 143), 3));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(1549, 150, 360, 706);
		panel_1_1.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_1_1.setBackground(new Color(240, 255, 240));

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(1130, 337, 360, 149);
		panel_1_2.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_1_2.setBackground(new Color(240, 255, 240));

		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBounds(1130, 706, 360, 150);
		panel_1_6.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_1_6.setBackground(new Color(240, 255, 240));
		JButton btnAtender = new JButton("Atender");
		btnAtender.setBounds(864, 867, 151, 41);
		btnAtender.setForeground(new Color(255, 255, 255));
		btnAtender.setBackground(new Color(149, 208, 157));
		btnAtender.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				consultaClick = new Consulta();
				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}

				consultaClick = listConulta.get(position);

				int n = JOptionPane.showConfirmDialog(null,
						" Deseja confirma Atendimento " + consultaClick.getPaciente().getNome() + " ", "",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					agendaDao = new AgendaDao();
					agendaDao.confirmarAtendimento(consultaClick);
					atualizarTabelaDia();
					TelaConsultaMedico telaConsultaMedico = new TelaConsultaMedico(consultaClick, usuario);
					telaConsultaMedico.setLocationRelativeTo(null);
					telaConsultaMedico.setVisible(true);
					dispose();

				}

			}
		});
		btnAtender.setFont(new Font("Tahoma", Font.BOLD, 12));

		panelSairPerfil = new JPanel();
		panelSairPerfil.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		panelSairPerfil.setBackground(new Color(143, 188, 143));
		panelSairPerfil.setBounds(1650, 80, 266, 100);
		panelSairPerfil.setForeground(Color.BLACK);
		panelSairPerfil.setLayout(new MigLayout("", "[240:n]", "[][50:n][10:n][50:n][10:n][50:n][10:n][50:n]"));
		contentPane.add(panelSairPerfil);
		panelSairPerfil.setVisible(false);

		lblNewLabel = new JLabel("Configurações");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelSairPerfil.add(lblNewLabel, "cell 0 0,alignx center");

		btnSair = new JButton("Sair do sistema ");
		btnSair.setBackground(SystemColor.controlHighlight);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBorder(null);
		btnSair.setForeground(Color.BLACK);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl = new TelaLogin();
				tl.setLocationRelativeTo(null);
				tl.setVisible(true);
				dispose();

			}
		});
		panelSairPerfil.add(btnSair, "cell 0 1,grow");
		btnSair.setVisible(true);
		lblNewLabel.setVisible(true);

		contentPane.add(panelSairPerfil);
		panelSairPerfil.setVisible(false);

		JButton btnLoginSair = new JButton("");
		btnLoginSair.setIcon(new ImageIcon("src\\main\\resources\\imagens\\login.png"));
		btnLoginSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (sairPerfil == 0) {
					sairPerfil = 1;
					panelSairPerfil.setVisible(true);
				} else {
					panelSairPerfil.setVisible(false);
					sairPerfil = 0;
				}
			}
		});
		btnLoginSair.setBackground(Color.WHITE);

		JPanel panel_1_6_1 = new JPanel();
		panel_1_6_1.setBounds(1130, 520, 360, 153);
		panel_1_6_1.setLayout(null);
		panel_1_6_1.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_1_6_1.setBackground(new Color(240, 255, 240));

		filaEspera = new JLabel("  Fila de espera : ");
		filaEspera.setFont(new Font("Tahoma", Font.BOLD, 16));
		filaEspera.setBounds(0, 0, 360, 153);
		panel_1_6_1.add(filaEspera);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(707, 867, 151, 41);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				consultaClick = new Consulta();
				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}

				consultaClick = listConulta.get(position);

				int n = JOptionPane.showConfirmDialog(null,
						"Deseja cancelar o  atendimento" + consultaClick.getPaciente().getNome() + " ", "",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					agendaDao = new AgendaDao();
					agendaDao.cancelarPresença(consultaClick);
					atualizarTabelaDia();

				}

			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBackground(new Color(149, 208, 157));

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 0, 1924, 78);
		panel_8.setBackground(new Color(143, 188, 143));

		JLabel lblNewLabel_1_1 = new JLabel("Bem vindo :  " + usuario.getUsuario());
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));

		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING).addGap(0, 1924, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup().addGap(73)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)
						.addGap(888).addComponent(btnLoginSair)));
		gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING).addGap(0, 73, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup().addGap(7).addComponent(btnLoginSair,
						GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_8.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addContainerGap()));
		panel_8.setLayout(gl_panel_8);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("src\\main\\resources\\imagens\\medico.png"));
		lblNewLabel_5.setBounds(138, 37, 132, 84);
		panel_1_1.add(lblNewLabel_5);

		txtNome = new JTextField();
		txtNome.setBounds(88, 165, 243, 28);
		panel_1_1.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Nome :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(29, 165, 61, 28);
		panel_1_1.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Email : ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(29, 204, 61, 29);
		panel_1_1.add(lblNewLabel_8);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(88, 204, 243, 28);
		panel_1_1.add(txtEmail);

		JLabel lblNewLabel_9 = new JLabel("Data Nascimento : ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(29, 244, 172, 27);
		panel_1_1.add(lblNewLabel_9);

		txtDataNascimeto = new JTextField();
		txtDataNascimeto.setColumns(10);
		txtDataNascimeto.setBounds(188, 243, 143, 28);
		panel_1_1.add(txtDataNascimeto);

		JLabel lblNewLabel_10 = new JLabel("Especialização : ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(29, 286, 143, 14);
		panel_1_1.add(lblNewLabel_10);

		txtEspecializacao = new JTextField();
		txtEspecializacao.setColumns(10);
		txtEspecializacao.setBounds(165, 281, 166, 28);
		panel_1_1.add(txtEspecializacao);

		JLabel lblNewLabel_11 = new JLabel("Telefone : ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(29, 320, 96, 28);
		panel_1_1.add(lblNewLabel_11);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(135, 320, 196, 28);
		panel_1_1.add(txtTelefone);

		JLabel lblNewLabel_12 = new JLabel("Enderço");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(29, 391, 302, 20);
		panel_1_1.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Cep : ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_13.setBounds(29, 434, 61, 23);
		panel_1_1.add(lblNewLabel_13);

		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(78, 429, 253, 28);
		panel_1_1.add(txtCep);

		JLabel lblNewLabel_14 = new JLabel("Estado : ");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_14.setBounds(29, 468, 77, 28);
		panel_1_1.add(lblNewLabel_14);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(108, 468, 223, 28);
		panel_1_1.add(txtEstado);

		JLabel lblNewLabel_15 = new JLabel("Cidade : ");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_15.setBounds(29, 507, 77, 28);
		panel_1_1.add(lblNewLabel_15);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(108, 507, 223, 28);
		panel_1_1.add(txtCidade);

		JLabel lblNewLabel_16 = new JLabel("Rua : ");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_16.setBounds(29, 586, 53, 27);
		panel_1_1.add(lblNewLabel_16);

		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(78, 587, 253, 28);
		panel_1_1.add(txtRua);

		JLabel lblNewLabel_17 = new JLabel("Número : ");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_17.setBounds(29, 624, 80, 28);
		panel_1_1.add(lblNewLabel_17);

		txtNCasa = new JTextField();
		txtNCasa.setColumns(10);
		txtNCasa.setBounds(108, 626, 223, 28);
		panel_1_1.add(txtNCasa);

		JLabel lblNewLabel_12_1 = new JLabel("Dados Médico");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12_1.setBounds(29, 134, 302, 20);
		panel_1_1.add(lblNewLabel_12_1);

		JLabel lblNewLabel_3 = new JLabel("Bairro : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(39, 546, 67, 27);
		panel_1_1.add(lblNewLabel_3);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(108, 545, 223, 28);
		panel_1_1.add(txtBairro);
		panel_1_6.setLayout(null);

		totalConsulta = new JLabel(" Total  de consulta(dia) : " + totaldeConsulta);
		totalConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		totalConsulta.setBounds(0, 0, 360, 150);
		panel_1_6.add(totalConsulta);
		panel_1_2.setLayout(null);

		lblNewLabel_2 = new JLabel("  Não presentes :");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(0, 0, 360, 149);
		panel_1_2.add(lblNewLabel_2);
		panel_1.setLayout(null);

		pacientesAtendidos = new JLabel("  Paciente atendidos : ");
		pacientesAtendidos.setBackground(new Color(240, 255, 240));
		pacientesAtendidos.setFont(new Font("Tahoma", Font.BOLD, 16));
		pacientesAtendidos.setBounds(0, 0, 360, 150);

		panel_1.add(pacientesAtendidos);
		contentPane.setLayout(null);
		contentPane.add(panelSairPerfil);
		contentPane.add(btnCancelar);
		contentPane.add(btnAtender);
		contentPane.add(scrollPane);
		contentPane.add(panel_1_6_1);
		contentPane.add(panel_1);
		contentPane.add(panel_1_2);
		contentPane.add(panel_1_6);
		contentPane.add(panel_1_1);
		contentPane.add(panel_8);

		setarMedico(medico);
		atualizarTabelaDia();

	}

	private void setarMedico(Medico medicoSetar) {

		txtNome.setText(medicoSetar.getNome());
		txtEmail.setText(medicoSetar.getEmail());
		txtTelefone.setText(medicoSetar.getTelefone());
		txtNCasa.setText(String.valueOf(medicoSetar.getNumero()));

		Date data = Date.valueOf(medicoSetar.getDataNascimento());
		txtDataNascimeto.setText(formatDate.format(data));

		txtEspecializacao.setText(medicoSetar.getEspecializacao());

		Integer cep = medicoSetar.getEndereco().getCep();
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = new Endereco(cep);
		Endereco enderecoDoBanco = enderecoDao.consultarEndereco(endereco);
		txtCep.setText(String.valueOf(enderecoDoBanco.getCep()));
		txtBairro.setText(enderecoDoBanco.getBairro());
		txtCidade.setText(enderecoDoBanco.getCidade());
		txtRua.setText(enderecoDoBanco.getRua());
		txtEstado.setText(enderecoDoBanco.getEstado().getNome());

	}

	private void atualizarTabelaDia() {

		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "Data", "Hora", "Status" });
		listConulta = new ArrayList<>();
		agendaDao = new AgendaDao();
		consulta = new Consulta();
		int pacientesAtend = 0;
		int pacientesNaoPresentes = 0;
		int filaEsp = 0;

		int i = 0;
		listConulta = agendaDao.consultarCosultaDia(medico.getCpf());
		for (i = 0; i < listConulta.size(); i++) {
			Consulta consulta = listConulta.get(i);
			tabela.addRow(new Object[] { consulta.getPaciente().getNome(), consulta.getPaciente().getCpf(),
					consulta.getDate(), consulta.getHora(), consulta.getPresença() });
			
			if (consulta.getPresença() != null) {
				if (consulta.getPresença().equals("Atendido")) {
					pacientesAtend++;
				}
				if (consulta.getPresença().trim() == "" && !consulta.getPresença().equals("Atendido")
						&& !consulta.getPresença().equals("Presente")) {

					pacientesNaoPresentes++;
				}
				if (consulta.getPresença().equals("Presente")) {
					filaEsp++;
				} 

			}else {
				pacientesNaoPresentes++;
			}

			totalConsulta.setText(" Total  de consulta(dia) :" + listConulta.size());
			pacientesAtendidos.setText("Paciente atendidos : " + pacientesAtend);
			lblNewLabel_2.setText("Pacientes não presentes : " + pacientesNaoPresentes);
			filaEspera.setText("Fila de espera " + filaEsp);

			table.setModel(tabela);
		}
	}
}
