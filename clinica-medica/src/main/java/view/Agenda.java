package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import controller.AgendaDao;
import controller.MedicoDao;
import controller.PacienteDao;
import model.Consulta;
import model.Medico;
import model.Paciente;
import net.miginfocom.swing.MigLayout;
import utils.Jcaledar;

/**
 *  
 *  @author Eliézer da Silva
 *  
 */
public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtObservacao;
	private String usuario;
	private String senha;
	private JTextField txtTipoConsulta;
	private JTextField txtHora;
	private AgendaDao agendaDao = new AgendaDao();
	private PacienteDao pacienteDao = new PacienteDao();
	private JComboBox<Medico> cbxMedico;
	private JTable table = null;
	private ArrayList<Consulta> listaConsulta = new ArrayList<>();
	private JButton btnCadastrar;
	private JButton btnEditar;
	private  Consulta consultaClick = new Consulta();
	private ArrayList<Consulta> listConsulta = new ArrayList<>();
	private Jcaledar txtCaledar;
	private JButton btnVoltarMenu;
	private JButton btnExcluir; 
	

	public Agenda(String usuario, String senha) {

		this.usuario = usuario;
		this.senha = senha;
		this.listConsulta = agendaDao.listConsulta();
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

		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(295)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(305)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane
						.createSequentialGroup().addGap(38).addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE)));

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
		panel_1.add(panel_3, BorderLayout.WEST);

		panel_3.setLayout(new MigLayout("", "[120:n:120,grow][][][][][200:n:200][][150:n:150][120:n:120]",
				"[20:n:20][35:n:35][][35:n:35][][35:n:35][][350:n:350,grow][][35px:n:35px]"));

		JLabel lblNewLabel_2 = new JLabel("Nome: ");

		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_2, "flowx,cell 1 1");

		txtNome = new JTextField();
		txtNome.setBackground(new Color(255, 255, 255));
		panel_3.add(txtNome, "cell 1 1,grow");
		txtNome.setColumns(20);

		JLabel lblNewLabel_3 = new JLabel(" CPF: ");

		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_3, "flowx,cell 3 1,alignx left");

		txtCpf = new JTextField();
		panel_3.add(txtCpf, "cell 3 1,alignx left,growy");
		txtCpf.setColumns(20);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String cpfString = txtCpf.getText();
				Paciente pacienteAgendamento = null;
				if (cpfString == null || cpfString.trim() == "" || cpfString.isEmpty()) {
					int n = JOptionPane.showConfirmDialog(null,
							"Paciente não cadastrado, deseja cadastrar um novo paciente ?  " + "", "",
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnNewButton, "cell 5 1 2 1,grow");

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

		 txtCaledar = new Jcaledar();
		txtCaledar.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		panel_3.add(txtCaledar, "cell 3 3,grow");
		txtCaledar.setPreferredSize(new Dimension(120, 20));
		contentPane.setLayout(gl_contentPane);

		JLabel lblNewLabel_5 = new JLabel("Tipo de Consulta : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel_3.add(lblNewLabel_5, "flowx,cell 3 5");

		txtObservacao = new JTextField();
		panel_3.add(txtObservacao, "cell 1 5,grow");
		txtObservacao.setColumns(25);

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

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(236, 253, 232));
		panel_4.setBorder(new LineBorder(new Color(51, 153, 0), 2));
		panel_3.add(panel_4, "cell 1 7 7 1,grow");
		panel_4.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 972, 330);
		panel_4.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Paciente", "Medico", "Data", "Hora" }));
		atualizarTabela();
		scrollPane.setViewportView(table);

		btnEditar = new JButton("Editar ");
		btnEditar.addActionListener(new ActionListener() {
			private JButton btnsalvar;
			private AbstractButton voltar;

			public void actionPerformed(ActionEvent e) {

				btnCadastrar.setVisible(false);
				panel_3.remove(btnCadastrar);

				btnExcluir.setVisible(false);
				panel_3.remove(btnExcluir);

				btnEditar.setVisible(false);
				panel_3.remove(btnEditar);
				
				btnVoltarMenu.setVisible(false);
				panel_3.remove(btnVoltarMenu);
				
			

				voltar = new JButton("Volta");
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						panel_3.remove(voltar);
						voltar.setVisible(false);

						btnsalvar.setVisible(false);
						panel_3.remove(btnsalvar);
						
						panel_3.add(btnCadastrar);
						btnCadastrar.setVisible(true);
						
						btnCadastrar.setBackground(new Color(240, 255, 240));
						btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_3.add(btnCadastrar, "cell 5 5 2 1,grow");


						panel_3.add(btnExcluir, "cell 5 9,grow");
						btnExcluir.setVisible(true);
						btnExcluir.setBackground(new Color(240, 240, 240));
						btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
						

						panel_3.add(btnVoltarMenu);
						btnVoltarMenu.setVisible(true);
						btnVoltarMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_3.add(btnVoltarMenu, "cell 7 9,grow");
						
						panel_3.add(btnEditar);
						btnEditar.setVisible(true);
						btnEditar.setBackground(new Color(240, 255, 240));
						btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
						panel_3.add(btnEditar, "cell 1 9,grow");

						
						
					}
				});
				voltar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_3.add(voltar, "cell 7 9,grow");
				
				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				consultaClick = listConsulta.get(position);
				setarDados(consultaClick);
				
				btnsalvar = new JButton("Salvar");
				btnsalvar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {

						
						
						Date data = txtCaledar.getDate();

						String nome = txtNome.getText();

						String cpf = txtCpf.getText().replace(".", "").replace("-", "");

						String tipoConsulta = txtTipoConsulta.getText();

						String observacao = txtObservacao.getText();

						String validacao = "";

						String hora = txtHora.getText();

						Consulta c = new Consulta();
						Paciente p = new Paciente();
						c.setId(consultaClick.getId());

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

							String dataFormatada = formatador.format(data);

							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate dataFormatadaNova = LocalDate.parse(dataFormatada, formatter);
							c.setDate(dataFormatadaNova);
						}
						if (hora == null || hora.trim() == "" || hora.isEmpty()) {
							txtHora.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						} else {
						
							LocalTime ts = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
							c.setHora(ts);

						}
						Medico medico = (Medico) cbxMedico.getSelectedItem();
						Long cp = medico.getCpf();
						medico.setCpf(cp);
						c.setMedico(medico);

						if (observacao == null || observacao.trim() == "" || observacao.isEmpty()) {
							txtObservacao.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						} else {
							c.setObservacao(observacao);
						}
						
						boolean cadastroConsulta = agendaDao.alterarConsulta(c);
						if (cadastroConsulta != true) {
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
						} else {

							JOptionPane.showMessageDialog(null, "Consulta editada con");
							atualizarTabela();
							limparTela();
							// atualizarTabela();
						}
					
						
					}
				});
				btnsalvar.setBackground(new Color(240, 255, 240));
				btnsalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_3.add(btnsalvar, "cell 5 5 2 1,grow");
				

				

			}
		});
		btnEditar.setBackground(new Color(240, 255, 240));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnEditar, "cell 1 9,grow");

		txtTipoConsulta = new JTextField();
		panel_3.add(txtTipoConsulta, "flowx,cell 3 5,grow");
		txtTipoConsulta.setColumns(10);

		txtHora = new JTextField();
		panel_3.add(txtHora, "cell 5 3,grow");
		txtHora.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date data = txtCaledar.getDate();

				String nome = txtNome.getText();

				String cpf = txtCpf.getText().replace(".", "").replace("-", "");

				String tipoConsulta = txtTipoConsulta.getText();

				String observacao = txtObservacao.getText();

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

					String dataFormatada = formatador.format(data);

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataFormatadaNova = LocalDate.parse(dataFormatada, formatter);
					c.setDate(dataFormatadaNova);
				}
				if (hora == null || hora.trim() == "" || hora.isEmpty()) {
					txtHora.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				} else {
					SimpleDateFormat dt = new SimpleDateFormat("hh:mm");
					Date date = null;
					
					LocalTime ts = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
					c.setHora(ts);

				}
				Medico medico = (Medico) cbxMedico.getSelectedItem();
				Long cp = medico.getCpf();
				medico.setCpf(cp);
				c.setMedico(medico);

				if (observacao == null || observacao.trim() == "" || observacao.isEmpty()) {
					txtObservacao.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				} else {
					c.setObservacao(observacao);
				}
				boolean cadastroConsulta = agendaDao.cadastraConsulta(c);
				if (cadastroConsulta != true) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
					int n = JOptionPane.showConfirmDialog(null,
							"Deseja limpar a tela" + " ", "", JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.YES_OPTION) {
					limparTela();
					}
				} else {

					JOptionPane.showMessageDialog(null, "Consulta cadastrada");
					atualizarTabela();
					 atualizarTabela();
					 limparTela();
				}

			}
		});

		btnCadastrar.setBackground(new Color(240, 255, 240));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnCadastrar, "cell 5 5 2 1,grow");

		btnVoltarMenu = new JButton("Voltar");
		btnVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal mp = new MenuPrincipal(usuario, senha);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();
			}
		});
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnCadastrar.setVisible(false);
				panel_3.remove(btnCadastrar);


				btnEditar.setVisible(false);
				panel_3.remove(btnEditar);
				
				btnVoltarMenu.setVisible(false);
				panel_3.remove(btnVoltarMenu);
				
				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				consultaClick = listConsulta.get(position);
				
				
				int n = JOptionPane.showConfirmDialog(null,
						"Tem certeza que quer excluir?  " + " ", "", JOptionPane.YES_NO_OPTION);

				if (n == JOptionPane.YES_OPTION) {
					boolean retorno = agendaDao.excluitConsulta(consultaClick);
					JOptionPane.showMessageDialog(null, "Excluindo");
					atualizarTabela();
				
				} else {
					JOptionPane.showMessageDialog(null, " erro ao excluir");
			
				}
				agendaDao.excluitConsulta(consultaClick);
				
				panel_3.add(btnCadastrar);
				btnCadastrar.setVisible(true);
				
				btnCadastrar.setBackground(new Color(240, 255, 240));
				btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_3.add(btnCadastrar, "cell 5 5 2 1,grow");

				panel_3.add(btnVoltarMenu);
				btnVoltarMenu.setVisible(true);
				btnVoltarMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_3.add(btnVoltarMenu, "cell 7 9,grow");
				
				panel_3.add(btnEditar);
				btnEditar.setVisible(true);
				btnEditar.setBackground(new Color(240, 255, 240));
				btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
				panel_3.add(btnEditar, "cell 1 9,grow");
				limparTela();
				
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnExcluir, "cell 5 9,grow");
		btnVoltarMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnVoltarMenu, "cell 7 9,grow");

		

	}
	//Metodos 
	

	protected void setarDados(Consulta consultaClick2) {
		txtHora.setText(String.valueOf(consultaClick2.getHora()));
		txtNome.setText(consultaClick2.getPaciente().getNome());
		txtCpf.setText(String.valueOf(consultaClick2.getPaciente().getCpf()));
		txtCpf.setEditable(false);
		txtTipoConsulta.setText(consultaClick2.getServico());
		Date date = java.sql.Date.valueOf(consultaClick2.getDate());
		txtCaledar.setDate(date);
		txtObservacao.setText(consultaClick2.getServico());
		MedicoDao medicoDao = new MedicoDao();
		Medico medico = medicoDao.consultaDadosMedico(consultaClick2.getMedico().getCpf());
		int cpf = Long.valueOf(medico.getCpf()).intValue();
		
		int posicao = cbxMedico.getSelectedIndex();
		cbxMedico.setSelectedItem(medico);
		
	}

	protected void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Paciente", "Medico", "Data", "Hora" });
		listaConsulta = agendaDao.listConsulta();
		for (int i = 0; i < listaConsulta.size(); i++) {
			Consulta consultaList = listaConsulta.get(i);
			tabela.addRow(new Object[] { consultaList.getPaciente().getNome(), consultaList.getMedico().getNome(),
					consultaList.getDate(), consultaList.getHora() });

		}
		table.setModel(tabela);
	}
	protected void limparTela() {
		txtHora.setText("");
		txtNome.setText("");
		txtCpf.setText("");
		txtCpf.setEditable(true);
		txtTipoConsulta.setText("");
		Date date = java.sql.Date.valueOf("");
		txtCaledar.setDate(date);
		txtObservacao.setText("");
		
		
	}
}
