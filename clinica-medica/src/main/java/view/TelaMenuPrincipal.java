package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.AgendaDao;
import controller.MedicoDao;
import model.Consulta;
import model.Usuario;
import net.miginfocom.swing.MigLayout;



public class TelaMenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Usuario 

	private Usuario usuario;
	private String login;
	private String senha;
	private int nivelAcesso;
	private String verificaNivelAcesso;

	//Logica do menu e do panel de sair
	int d = 0;
	private int menu = 0;
	private int sairPerfil = 0;
	 
	
	
	//Componetes da tela
	private JPanel paneL;
	private JPanel panelSairPerfil;
	private JLabel lblNewLabel;
	private JButton btnSair;
	private JPanel panelMenu;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JScrollPane scrollPane;
	private JButton btnCadastraPaciente;
	private JButton btnCadastraMedico;
	private JButton btnCadastroFuncionario;
	private JButton btnCadastroConsulta;

	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_11;
	private JLabel lblNewLabel_1;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnBotaoMenu;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private JButton btnConfimarPresenca;
	private DefaultTableModel tabela ;
	private JTable table;
	private ArrayList<Consulta> listaConsulta;
	private AgendaDao agendaDao;
	private Consulta consultaClick; 
	private JLabel pacienteCadastrados;
	private JLabel lblNewLabel_6;
	private JButton btnCancelarPresenca;
	private String quantidadeNaoPresente;
	private int quantidadeMedicosCadastrados;
	private JLabel iconeMedico;
	private JLabel iconeFaltante;

	private JLabel pacientesNaoPresentes;
	private JLabel quantidadeDeConsulta;
	private JLabel medicosCadastrados;


	/**
	 * Create the frame.
	 * @param login 
	 */
	public TelaMenuPrincipal(Usuario usuario) {
		
		
		this.login = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.nivelAcesso = usuario.getNivelAcesso();
		
		
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
		
		
		;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));

		btnBotaoMenu = new JButton("");
		btnBotaoMenu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnBotaoMenu.setBackground(new Color(102, 204, 255));
			}
		});
		btnBotaoMenu.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				btnBotaoMenu.setBackground(new Color(255, 255, 255));
			}
		});

		btnBotaoMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (menu == 0) {
					menu++;
					panelMenu.setVisible(true);
				} else {
					panelMenu.setVisible(false);
					menu = 0;
				}

			}
		});

		btnBotaoMenu.setIcon(new ImageIcon("src\\main\\resources\\imagens\\Logo.png"));
		btnBotaoMenu.setBackground(Color.white);
		
		JButton btnLoginSair = new JButton("");
		btnLoginSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (sairPerfil == 0) {
					sairPerfil=1;
					panelSairPerfil.setVisible(true);
				} else {
					panelSairPerfil.setVisible(false);
					sairPerfil = 0;
				}

			}
		});
		btnLoginSair.setIcon(new ImageIcon("src\\main\\resources\\imagens\\login.png"));
		btnLoginSair.setBackground(Color.white);
		
		if(nivelAcesso==0) {
			verificaNivelAcesso = "Administrador";
		}else {
			if(nivelAcesso==1) {
				verificaNivelAcesso = "Médico";
			}else {
				verificaNivelAcesso= "Funcionário";
			}
		}
		lblNewLabel_1 = new JLabel("Bem vindo : "+usuario.getUsuario()+"                Seu cargo é : "+verificaNivelAcesso);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(btnBotaoMenu)
					.addGap(33)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)
					.addGap(888)
					.addComponent(btnLoginSair))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBotaoMenu, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoginSair, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		
		panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		panelMenu.setBackground(new Color(143, 188, 143));
		panelMenu.setBounds(0, 80, 266, 930);
		panelMenu.setForeground(Color.BLACK);
		panelMenu.setLayout(new MigLayout("", "[240:n]", "[][50:n][10:n][50:n][10:n][50:n][10:n][50:n]"));
		contentPane.add(panelMenu);
		panelMenu.setVisible(false);

		lblNewLabel = new JLabel("Cadastar/Consultar");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelMenu.add(lblNewLabel, "cell 0 0,alignx center");

		btnCadastraPaciente = new JButton("Paciente");
		btnCadastraPaciente.setBackground(SystemColor.controlHighlight);
		btnCadastraPaciente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastraPaciente.setBorder(null);
		btnCadastraPaciente.setForeground(Color.BLACK);
		btnCadastraPaciente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TelaCadastroPaciente telaPaciente = new TelaCadastroPaciente(usuario);
				telaPaciente.setLocationRelativeTo(null);
				telaPaciente.setVisible(true);
				dispose();

			}
		});
		
		panelMenu.add(btnCadastraPaciente, "cell 0 1,grow");
		if(nivelAcesso!=2) {
		btnCadastraMedico = new JButton("Médico");
		btnCadastraMedico.setBackground(SystemColor.controlHighlight);
		btnCadastraMedico.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastraMedico.setBorder(null);
		btnCadastraMedico.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TelaCadastroMedico telaFunc = new TelaCadastroMedico(usuario);
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
				dispose();

			}
		});
		panelMenu.add(btnCadastraMedico, "cell 0 3,grow");
		
		btnCadastroFuncionario = new JButton("Funcionário");
		btnCadastroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastroFuncionario.setBorder(null);
		btnCadastroFuncionario.setBackground(SystemColor.controlHighlight);
		btnCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario tcf = new TelaCadastroFuncionario(usuario);
				tcf.setLocationRelativeTo(null);
				tcf.setVisible(true);
				dispose();

			}
		});
		panelMenu.add(btnCadastroFuncionario, "cell 0 5,grow");
		}
		btnCadastroConsulta = new JButton("Consulta");
		btnCadastroConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastroConsulta.setBorder(null);
		btnCadastroConsulta.setBackground(SystemColor.controlHighlight);
		btnCadastroConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agenda agenda = new Agenda(usuario);
				agenda.setLocationRelativeTo(null);
				agenda.setVisible(true);
				dispose();
			}
		});
		
		if(nivelAcesso==2) {
			panelMenu.add(btnCadastroConsulta, "cell 0 3,grow");
		}else {
		panelMenu.add(btnCadastroConsulta, "cell 0 7,grow");
		}
		contentPane.add(panelMenu);
		panelMenu.repaint();
		
		
		panelSairPerfil = new JPanel();
		panelSairPerfil.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		panelSairPerfil.setBackground(new Color(143, 188, 143));
		panelSairPerfil.setBounds(1650, 80, 266, 100);
		panelSairPerfil.setForeground(Color.BLACK);
		panelSairPerfil.setLayout(new MigLayout("", "[240:n]", "[][50:n][10:n][10:n]"));
		contentPane.add(panelSairPerfil);
		panelSairPerfil.setVisible(false);

		lblNewLabel = new JLabel("Configurações");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelSairPerfil.add(lblNewLabel, "cell 0 0,alignx center");

		btnSair = new JButton("Sair do sistema ");
		
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBorder(null);
		btnSair.setBackground(SystemColor.controlHighlight);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl =  new TelaLogin();
				tl.setLocationRelativeTo(null);
				tl.setVisible(true);
				dispose();
				
			}
		});
		panelSairPerfil.add(btnSair, "cell 0 1,grow");
		btnSair.setVisible(true);
		lblNewLabel.setVisible(true);
		btnBotaoMenu.repaint();

		contentPane.add(panelSairPerfil);
		panelSairPerfil.setVisible(false);

		JPanel panel_3 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 935, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3.setLayout(new CardLayout(0, 0));

		

		panel_2 = new JPanel();
		panel_3.add(panel_2, "name_5152966362900");
		panel_2.setLayout(new MigLayout("", "[100px,grow][920:n:920,grow][61.00px,grow][383.00px,grow][61px]", "[][::50px,grow][::700,grow][][grow][][]"));

		panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(new Color(143, 188, 143));
		panel_2.add(panel_4, "cell 1 1,grow");
		
		lblNewLabel_2 = new JLabel("Consultas do dia ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblNewLabel_2);

		panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_5, "cell 1 2,grow");
		panel_5.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 902, 657);
		panel_5.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Paciente", "Serviço","Medico", "Hora", "Data", "Presente" }));
	
		scrollPane.setViewportView(table);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_6.setBackground(new Color(143, 188, 143));
		panel_2.add(panel_6, "cell 3 2,grow");
		panel_6.setLayout(new MigLayout("", "[grow]", "[][100px:n:100px,grow][][100px:n:100px,grow][][100px:n:100px,grow][][100:n:100,grow][][][100px:n:100px,grow]"));
		
		panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		listaConsultaDia();
		panel_6.add(panel_7, "cell 0 1,grow");
		panel_7.setLayout(null);
		

		quantidadeDeConsulta = new JLabel("  Quantidade de consulta hoje : ");
		quantidadeDeConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		quantidadeDeConsulta.setBounds(0, 0, 550, 100);
		panel_7.add(quantidadeDeConsulta);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("src\\main\\resources\\imagens\\iconeConsulta.png"));
		
		lblNewLabel_4.setBounds(31, 29, 49, 48);
		panel_7.add(lblNewLabel_4);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_6.add(panel_8, "cell 0 3,grow");
		panel_8.setLayout(null);
		
		pacienteCadastrados = new JLabel(" Pacientes cadastrados : ");
		pacienteCadastrados.setBounds(0, 0, 481, 100);
		pacienteCadastrados.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_8.add(pacienteCadastrados);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("src\\main\\resources\\imagens\\pessoa.png"));
		lblNewLabel_6.setBounds(32, 22, 57, 67);
		panel_8.add(lblNewLabel_6);
		
		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_6.add(panel_9, "cell 0 5,grow");
		
		
		var medicoDao = new MedicoDao();
		quantidadeMedicosCadastrados = medicoDao.quantidadeDeMedico();
		
		medicosCadastrados = new JLabel("Médicos cadastrados : "+quantidadeMedicosCadastrados);
		medicosCadastrados.setFont(new Font("Tahoma", Font.BOLD, 16));
		medicosCadastrados.setBounds(0, 0, 481, 100);
		panel_9.add(medicosCadastrados);
		
		iconeMedico = new JLabel("");
		iconeMedico.setIcon(new ImageIcon("src\\main\\resources\\imagens\\medico.png"));
		iconeMedico.setBounds(32, 22, 57, 67);
		panel_9.add(iconeMedico);
		
		
		panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_11.setLayout(null);
		panel_6.add(panel_11, "cell 0 7,grow");
		
		iconeFaltante = new JLabel("");
		iconeFaltante.setIcon(new ImageIcon("src\\main\\resources\\imagens\\faltante.png"));
		iconeFaltante.setBounds(32, 22, 57, 67);
		panel_11.add(iconeFaltante);
		
		
		pacientesNaoPresentes = new JLabel("Pacientes não presentes : ");
		pacientesNaoPresentes.setFont(new Font("Tahoma", Font.BOLD, 16));
		pacientesNaoPresentes.setBounds(0, 0, 471, 100);
		panel_11.add(pacientesNaoPresentes);

		panel_1 = new JPanel();
		panel_2.add(panel_1, "cell 1 4,grow");
		panel_1.setLayout(new MigLayout("", "[510:n:510][190:n:190][190:n:190]", "[40:n:40]"));
		
		btnConfimarPresenca = new JButton("Confirmar Presença");
		btnConfimarPresenca.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConfimarPresenca.setForeground(new Color(255, 255, 255));
		btnConfimarPresenca.setBackground(new Color(149, 208, 157));
		btnConfimarPresenca.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		btnConfimarPresenca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consultaClick = new Consulta();
				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				
				consultaClick = listaConsulta.get(position);
				
				int n = JOptionPane.showConfirmDialog(null, "Deseja confirma presença" + consultaClick.getPaciente().getNome()+ " ", "",
						JOptionPane.YES_NO_OPTION);
				if(n== JOptionPane.YES_OPTION) {
					agendaDao = new AgendaDao();
					agendaDao.confirmarPresença(consultaClick);
					atualizarTabela();
				}
				
			}
		});
		panel_1.add(btnConfimarPresenca, "cell 1 0,grow");
		
		
		btnCancelarPresenca = new JButton("Cancelar Presença");
		btnCancelarPresenca.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelarPresenca.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		btnCancelarPresenca.setForeground(new Color(255, 255, 255));
		btnCancelarPresenca.setBackground(new Color(149, 208, 157));
		btnCancelarPresenca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consultaClick = new Consulta();
				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				
				consultaClick = listaConsulta.get(position);
				
				int n = JOptionPane.showConfirmDialog(null, "Deseja cancelar presença ?" + consultaClick.getPaciente().getNome()+ " ", "",
						JOptionPane.YES_NO_OPTION);
				if(n== JOptionPane.YES_OPTION) {
					agendaDao = new AgendaDao();
					agendaDao.cancelarPresença(consultaClick);
					atualizarTabela();
				}
				
			}
		});
		panel_1.add(btnCancelarPresenca, "cell 2 0,grow");
		
		
		contentPane.setLayout(gl_contentPane);
		
		atualizarTabela();

	}

	public void atualizarTabela() {
		tabela = new DefaultTableModel(new Object[][] {}, new String[] {  "Paciente", "Serviço","Medico", "Hora", "Data", "Presente" });
		// listConsulta.clear();
		listaConsulta = new ArrayList<>();
		agendaDao = new AgendaDao();
		listaConsulta = agendaDao.listConsulta();
		//
		int quantidadePresente = 0 ;

		for (int i = 0; i < listaConsulta.size(); i++) {

			Consulta consultaList = listaConsulta.get(i);
			tabela.addRow(new Object[] {
					consultaList.getPaciente().getNome(), 
					consultaList.getServico(),
					consultaList.getMedico().getNome(),
					consultaList.getDate(), 
					consultaList.getHora(), 
					consultaList.getPresença(),
					});

		}
		for (Consulta consulta : listaConsulta) {
			if(consulta.getPresença()=="Presente") {
				quantidadePresente++;
			}
			
		}
		
		
		pacientesNaoPresentes.setText("Pacientes presentes : "+quantidadePresente);
		quantidadeDeConsulta.setText(" Total de consultas hoje : "+listaConsulta.size());
		pacientesNaoPresentes.setText("Quantidade de pacinetes nao presentes"+(listaConsulta.size()+quantidadeNaoPresente));
		
		
		table.setModel(tabela);
	}
	
	private String listaConsultaDia() {
		AgendaDao consulta = new AgendaDao();
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(formatador);
		
		
		ArrayList<Consulta> lista =  consulta.listConsultaDia(hoje);
		int soma = 0; 
		
		
		if(lista==null) {
			return "Nenhum paciente";
		}else {
			for (Consulta consulta2 : lista) {
				soma++;
				return Integer.toString(soma);
			}
		}
		return "Erro";
		
	}
	private String quatidadefaltantes() {
		return login;
		
	}
}
