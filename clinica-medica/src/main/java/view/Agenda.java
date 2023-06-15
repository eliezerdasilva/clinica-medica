package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
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
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;

import controller.AgendaDao;
import controller.MedicoDao;
import controller.PacienteDao;
import helper.AgendaHelper;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import utils.Jcaledar;

/**
 * 
 * @author Eliézer da Silva
 * 
 */
public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtObservacao;
	private Usuario usuario;

	private JTextField txtTipoConsulta;
	private JTextField txtHora;

	//
	private Consulta consultaClick;
	private ArrayList<Consulta> listConsulta = new ArrayList<>();
	private AgendaDao agendaDao = new AgendaDao();
	private PacienteDao pacienteDao = new PacienteDao();
	private AgendaHelper agendaHelper;
	private Agenda agenda;

	private JComboBox<Medico> cbxMedico;
	private JTable table = null;
	private ArrayList<Consulta> listaConsulta = new ArrayList<>();
	private JButton btnCadastrar;
	private JButton btnEditar;

	private Jcaledar txtCaledar;
	private JButton btnVoltarMenuPrincipal;
	private JButton btnExcluir;
	private JButton btnsalvar;
	private JButton voltar;

	// Usuário
	private String usuarioLogin;
	private String senhaLogin;
	private int nivelAcesso;

	// Dados
	private Date data;
	private String nome;
	private String cpf;
	private String tipoConsulta;
	private String observacao;
	private String validacao;
	private String hora;
	private DefaultTableModel tabela;
	private JPanel panel_3;

	public Agenda(Usuario usuario) {
		this.agenda = this;
		this.usuario = usuario;
		this.usuarioLogin = usuario.getUsuario();
		this.senhaLogin = usuario.getSenha();
		this.nivelAcesso = usuario.getNivelAcesso();

		this.listConsulta = agendaDao.listConsulta();
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Cadastrar consulta");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/LocoHospital.png");
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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
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
		panel_1.setBorder(new LineBorder(new Color(143, 188, 143), 6));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(143, 188, 143)));
		panel_2.setBackground(new Color(143, 188, 143));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));

		JLabel lblNewLabel = new JLabel("Consulta");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 50));
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);

		panel_3 = new JPanel();
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

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cpf inválido");
			e.printStackTrace();
		}
		panel_3.add(txtCpf, "cell 3 1,alignx left,growy");
		txtCpf.setColumns(20);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBackground(new Color(149, 208, 157));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpfString = txtCpf.getText().replace(".", "").replace("-", "");
				agendaHelper = new AgendaHelper();
				Paciente pacienteBusca = new Paciente();
				pacienteBusca = agendaHelper.buscarPaciente(cpfString, usuario, agenda);

				if (pacienteBusca != null) {
					txtNome.setText(pacienteBusca.getNome());
				} else {
					JOptionPane.showMessageDialog(null, "Paciente não cadastrado");
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
		scrollPane.setBounds(10, 11, 1011, 330);
		panel_4.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Paciente", "Medico", "Data", "Hora" }));
		atualizarTabela();
		scrollPane.setViewportView(table);

		btnEditar = new JButton("Editar ");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(149, 208, 157));
		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				alterarLayoutEditar();
				consultaClick = listaConsulta.get(position);

				setarDados(consultaClick);

				voltar = new JButton("Cancelar");
				voltar.setForeground(new Color(255, 255, 255));
				voltar.setBackground(new Color(149, 208, 157));
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						alterarLayoutVoltarEditar();
						limparTela();
						return;

					}
				});
				voltar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_3.add(voltar, "cell 7 9,grow");

				btnsalvar = new JButton("Salvar");
				btnsalvar.setBackground(new Color(149, 208, 157));
				btnsalvar.setForeground(new Color(255, 255, 255));
				btnsalvar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						Consulta consulta = setarDadosConsulta();
						if (consulta == null) {
							JOptionPane.showMessageDialog(null, validacao, "ERRO", JOptionPane.ERROR_MESSAGE);
							return;
						}
						AgendaHelper agendaHelper = new AgendaHelper();
						boolean retorno = agendaHelper.editarPaciente(consulta);
						if (retorno) {
							JOptionPane.showMessageDialog(null, "Consulta Alterada");
							atualizarTabela();
							limparTela();
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao  alterar consulta", "", JOptionPane.ERROR_MESSAGE);
							atualizarTabela();
							limparTela();
						}

					}
				});
				btnsalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_3.add(btnsalvar, "cell 5 5 2 1,grow");

			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnEditar, "cell 1 9,grow");

		txtTipoConsulta = new JTextField();
		panel_3.add(txtTipoConsulta, "flowx,cell 3 5,grow");
		txtTipoConsulta.setColumns(10);

		txtHora = new JTextField();
		panel_3.add(txtHora, "cell 5 3,grow");
		txtHora.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(149, 208, 157));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Consulta consulta = setarDadosConsulta();
				if (consulta == null) {
					JOptionPane.showMessageDialog(null, validacao, "ERRo", JOptionPane.ERROR_MESSAGE);
					return;
				}
				AgendaHelper agendaHelper = new AgendaHelper();
				boolean retorno = agendaHelper.cadastrarConsulta(consulta);
				if (retorno) {
					JOptionPane.showMessageDialog(null, "Consulta cadastrada");
					atualizarTabela();
					limparTela();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao  cadastrada consulta", "", JOptionPane.ERROR_MESSAGE);
					atualizarTabela();
					limparTela();
				}

			}
		});

		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnCadastrar, "cell 5 5 2 1,grow");

		btnVoltarMenuPrincipal = new JButton("Voltar");
		btnVoltarMenuPrincipal.setBackground(new Color(149, 208, 157));
		btnVoltarMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnVoltarMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaMenuPrincipal mp = new TelaMenuPrincipal(usuario);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();
			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(149, 208, 157));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				consultaClick = new Consulta();
				consultaClick = listConsulta.get(position);

				int n = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?  " + " ", "",
						JOptionPane.YES_NO_OPTION);

				if (n == JOptionPane.YES_OPTION) {
					boolean retorno = agendaDao.excluirConsulta(consultaClick);
					if (retorno != false) {
						JOptionPane.showMessageDialog(null, "Consulta excluida com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao excluir", " ERRO", JOptionPane.ERROR_MESSAGE);
					}

					atualizarTabela();

				}
				limparTela();

			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnExcluir, "cell 3 9,grow");
		btnVoltarMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnVoltarMenuPrincipal, "cell 7 9,grow");

	}

	// Metodos
	public void alterarLayoutVoltarEditar() {

		txtNome.setEditable(true);
		txtCpf.setEditable(true);
		panel_3.add(btnEditar);
		btnEditar.setBackground(new Color(149, 208, 157));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setVisible(true);

		panel_3.remove(voltar);
		voltar.setVisible(false);

		btnsalvar.setVisible(false);
		panel_3.remove(btnsalvar);

		btnCadastrar.setBackground(new Color(149, 208, 157));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		panel_3.add(btnCadastrar, "cell 5 5 2 1,grow");
		btnCadastrar.setVisible(true);

		btnExcluir.setBackground(new Color(149, 208, 157));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnExcluir, "cell 5 9,grow");
		btnExcluir.setVisible(true);

		btnVoltarMenuPrincipal.setBackground(new Color(149, 208, 157));
		btnVoltarMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnVoltarMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnVoltarMenuPrincipal, "cell 7 9,grow");

		btnVoltarMenuPrincipal.setVisible(true);
		btnEditar.setBackground(new Color(149, 208, 157));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnEditar, "cell 1 9,grow");
		btnEditar.setVisible(true);

	}

	public void alterarLayoutEditar() {

		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(149, 208, 157));
		btnEditar.setVisible(false);
		panel_3.remove(btnEditar);

		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(149, 208, 157));
		btnCadastrar.setVisible(false);
		panel_3.remove(btnCadastrar);

		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(149, 208, 157));
		btnExcluir.setVisible(false);
		panel_3.remove(btnExcluir);

		btnVoltarMenuPrincipal.setForeground(new Color(255, 255, 255));
		btnVoltarMenuPrincipal.setBackground(new Color(149, 208, 157));
		btnVoltarMenuPrincipal.setVisible(false);
		panel_3.remove(btnVoltarMenuPrincipal);

	}

	protected void setarDados(Consulta consultaClick2) {

		txtHora.setText(String.valueOf(consultaClick2.getHora()));
		txtNome.setText(consultaClick2.getPaciente().getNome());
		txtNome.setEditable(false);
		txtCpf.setText(String.valueOf(consultaClick2.getPaciente().getCpf()));
		txtCpf.setEditable(false);
		txtTipoConsulta.setText(consultaClick2.getServico());
		Date date = java.sql.Date.valueOf(consultaClick2.getDate());
		txtCaledar.setDate(date);
		txtObservacao.setText(consultaClick2.getObservacao());
		MedicoDao medicoDao = new MedicoDao();
		Medico medico = medicoDao.consultaDadosMedicoCPF(consultaClick2.getMedico().getCpf());
		Long.valueOf(medico.getCpf()).intValue();
		cbxMedico.getSelectedIndex();
		cbxMedico.setSelectedItem(medico);

	}

	public void atualizarTabela() {

		tabela = new DefaultTableModel(new Object[][] {},
				new String[] { "Paciente", "Medico", "Data", "Hora", "Observação" });
		// listConsulta.clear();
		listaConsulta = new ArrayList<>();
		listaConsulta = agendaDao.listConsulta();

		for (int i = 0; i < listaConsulta.size(); i++) {

			Consulta consultaList = listaConsulta.get(i);
			tabela.addRow(new Object[] { consultaList.getPaciente().getNome(), consultaList.getMedico().getNome(),
					consultaList.getDate(), consultaList.getHora(), consultaList.getObservacao() });

		}
		table.setModel(tabela);
	}

	public void limparTela() {
		txtHora.setText("");
		txtNome.setText("");
		txtCpf.setText("");
		txtCpf.setEditable(true);
		txtTipoConsulta.setText("");

		txtObservacao.setText("");

	}

	// Get set

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getbtnVoltarMenuPrincipal() {
		return btnVoltarMenuPrincipal;
	}

	public void setbtnVoltarMenuPrincipal(JButton btnVoltarMenuPrincipal) {
		this.btnVoltarMenuPrincipal = btnVoltarMenuPrincipal;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getValidacao() {
		return validacao;
	}

	public void setValidacao(String validacao) {
		this.validacao = validacao;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	// Txt
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtCpf() {
		return txtCpf;
	}

	public void setTxtCpf(JTextField txtCpf) {
		this.txtCpf = txtCpf;
	}

	public JTextField getTxtObservacao() {
		return txtObservacao;
	}

	public void setTxtObservacao(JTextField txtObservacao) {
		this.txtObservacao = txtObservacao;
	}

	public JTextField getTxtTipoConsulta() {
		return txtTipoConsulta;
	}

	public void setTxtTipoConsulta(JTextField txtTipoConsulta) {
		this.txtTipoConsulta = txtTipoConsulta;
	}

	public JTextField getTxtHora() {
		return txtHora;
	}

	public void setTxtHora(JTextField txtHora) {
		this.txtHora = txtHora;
	}

	public Jcaledar getTxtCaledar() {
		return txtCaledar;
	}

	public void setTxtCaledar(Jcaledar txtCaledar) {
		this.txtCaledar = txtCaledar;
	}
	// ComboBox

	public JComboBox<Medico> getCbxMedico() {
		return cbxMedico;
	}

	public Consulta setarDadosConsulta() {
		validacao = "";

		JTextField textField = new JTextField();

		Date data = agenda.getTxtCaledar().getDate();
		String nome = agenda.getTxtNome().getText();
		String cpf = agenda.getTxtCpf().getText().replace(".", "").replace("-", "");
		String tipoConsulta = agenda.getTxtTipoConsulta().getText();
		String observacao = agenda.getTxtObservacao().getText();
		String hora = agenda.getTxtHora().getText();

		Consulta consulta = new Consulta();
		Paciente paciente = new Paciente();
		if (consultaClick != null) {
			consulta.setId(consultaClick.getId());
		}
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			agenda.getTxtNome().setBorder(new LineBorder(new Color(255, 00, 00), 4));

			validacao += "Nome\n";
		} else {
			paciente.setNome(nome);
		}

		if (cpf == null || cpf.trim() == "" || cpf.isEmpty()) {
			agenda.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "CPF\n";
		} else {
			Long cpfLong = Long.valueOf(cpf);
			paciente.setCpf(cpfLong);
		}
		consulta.setPaciente(paciente);

		if (tipoConsulta == null || tipoConsulta.trim() == "" || tipoConsulta.isEmpty()) {
			agenda.getTxtTipoConsulta().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Tipo consulta\n";
		} else {
			consulta.setServico(tipoConsulta);
		}

		if (data == null) {
			agenda.getTxtCaledar().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Data\n";

		} else {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

			String dataFormatada = formatador.format(data);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataFormatadaNova = LocalDate.parse(dataFormatada, formatter);

			LocalDate dataAtual = LocalDate.now();

			if (dataFormatadaNova.isBefore(dataAtual)) {
				validacao += "Informe uma data posterior";

			} else {
				consulta.setDate(dataFormatadaNova);
			}

		}
		if (hora == null || hora.trim() == "" || hora.isEmpty()) {
			agenda.getTxtHora().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Hora\n";
		} else {

			LocalTime ts = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
			consulta.setHora(ts);

		}
		Medico medico = (Medico) agenda.getCbxMedico().getSelectedItem();
		Long cp = medico.getCpf();
		medico.setCpf(cp);
		consulta.setMedico(medico);

		if (observacao == null || observacao.trim() == "" || observacao.isEmpty()) {
			agenda.getTxtObservacao().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			consulta.setObservacao(observacao);
		}
		if (validacao.trim() == "") {
			return consulta;
		}
		return null;

	}
}
