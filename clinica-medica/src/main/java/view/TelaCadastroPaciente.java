package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.AgendaDao;
import controller.EnderecoDao;
import controller.PacienteDao;
import controller.UsuarioDao;
import helper.ManterEndereco;
import helper.ManterFuncionarioHelper;
import helper.ManterMedicoHelper;
import helper.ManterPacienteHelper;
import model.Convenio;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Medico;
import model.Paciente;
import model.StatusTela;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 
 * @author Eliezer da Silva
 * 
 *         Classe resposavel por exibir Tela de cadastro de paciente
 *
 */
public class TelaCadastroPaciente extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	EnderecoDao enderecoDao = new EnderecoDao();

	Endereco enderecoPronto = null;

	PacienteDao pacienteDao = new PacienteDao();

	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtProfissao;
	private JTextField txtData;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtMunicipio;
	private JTextField txtBairro;
	private JTextField txtRua;

	private JTextField txtNCasa;
	private JTextField txtComplemento;
	private JTextField txtBuscaCpf;
	private JTextField txtBuscaNome;
	private JButton btnEditar;
	protected String[] convenios;
	private Estado estado;
	private Endereco cadastroEndereco;

	ArrayList<Estado> estados = new ArrayList<>();
	ArrayList<Convenio> convenio = new ArrayList<>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCep;
	private JTable table;
	private ArrayList<Paciente> listaPaciente = new ArrayList<>();
	private Paciente pacienteClick;

	// Usuario
	private String usuarioLogin;
	private String senha;
	private int nivelAcesso;
	private String validacao = "";

	private JRadioButton jrbFemi;
	private JComboBox<Estado> cbxEstado;
	private JRadioButton jrbMasc;
	private JComboBox<Convenio> cbxConvenio;
	private SimpleDateFormat formatDate;
	private JButton btnExcluir;
	private JButton btnCadastra;

	private JButton btnVoltarCadastro;
	private JButton btnVoltarEditar;
	private TelaCadastroPaciente telaCadastroPaciente;
	private JPanel panelSairPerfil;
	private JButton btnSair;
	private int sairPerfil;
	private DefaultTableModel modelTabelaBusca;
	private JButton btnSalvar;
	private JButton voltar;

	public TelaCadastroPaciente(Usuario usuario) {
		this.usuarioLogin = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.nivelAcesso = usuario.getNivelAcesso();
		this.telaCadastroPaciente = this;
		this.listaPaciente = pacienteDao.consultarPaciente();

		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Tela cadastro de paciente");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/LocoHospital.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(143, 188, 143), 0));
		panel.setBounds(386, 90, 1178, 864);
		panel.setBackground(new Color(143, 188, 143));
		panel.setLayout(new MigLayout("", "[1150:n:1200]", "[850]"));

		JPanel panel_1 = new JPanel();

		panel.add(panel_1, "cell 0 0,grow");

		panel_1.setLayout(new BorderLayout(5, 0));

		BufferedImage filc = null;

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(143, 188, 143));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 20));

		JLabel lblNewLabel = new JLabel("Cadastro Paciente");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new MigLayout("", "[1150:n:1150,grow]", "[150:n:150,grow][200:n:210,grow][400:n:380,grow]"));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_3.setBackground(new Color(240, 255, 240));
		panel_4.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[][300:n:300,grow][][300:n:300][][][150:n:150,grow]",
				"[][30:n:30][][30:n:30][][30:n:30][]"));

		JLabel lblNewLabel_1 = new JLabel("Nome : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_1, "cell 0 1,alignx center,growy");

		txtNome = new JTextField();
		panel_3.add(txtNome, "cell 1 1,grow");
		txtNome.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Data :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_4, "flowx,cell 3 1,growx");

		JLabel lblNewLabel_7 = new JLabel("Convênio :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_7, "cell 5 1,alignx trailing");

		cbxConvenio = new JComboBox<Convenio>();
		cbxConvenio.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				convenio = pacienteDao.consultaConvenio();

				for (int i = 0; i < convenio.size(); i++) {
					cbxConvenio.addItem(convenio.get(i));

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		panel_3.add(cbxConvenio, "cell 6 1,grow");

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 255, 240));
		panel_6.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_6, "cell 0 2,grow");
		panel_6.setLayout(
				new MigLayout("", "[80:n:80][200:n:200,grow][][100px:n:100px][200:n:200,grow][][150:n:150][370:n:320]",
						"[][30:n:30][220:n:220,grow][5:n:5][30:n:30][]"));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 255, 240));
		panel_5.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("",
				"[80:n:80][150:n:150,grow][][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][165.00:n:180,grow]",
				"[5:n:5][][5:n:5][30:n:30][5:n:5][30:n:30][5:n:5][30:n:30]"));

		JLabel lblNewLabel_2 = new JLabel("E-mail :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_2, "cell 0 3,alignx center");

		txtEmail = new JTextField();
		panel_3.add(txtEmail, "cell 1 3,grow");
		txtEmail.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Cpf :    ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_5, "flowx,cell 3 3,grow");

		JLabel lblNewLabel_8 = new JLabel("Sexo :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_8, "cell 5 3");

		jrbMasc = new JRadioButton("M");
		buttonGroup.add(jrbMasc);
		jrbMasc.setBackground(new Color(240, 255, 240));
		panel_3.add(jrbMasc, "flowx,cell 6 3,grow");

		JLabel lblNewLabel_3 = new JLabel("Profissão :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_3, "cell 0 5,alignx trailing");

		txtProfissao = new JTextField();
		panel_3.add(txtProfissao, "cell 1 5,grow");
		txtProfissao.setColumns(10);

		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e3) {
			JOptionPane.showMessageDialog(null, "CEP inválido");
			e3.printStackTrace();
		}
		panel_5.add(txtCep, "cell 1 1,grow");
		txtCep.setColumns(10);

		JButton btnEditarEndereco = new JButton("");
		btnEditarEndereco.setForeground(new Color(255, 255, 255));
		btnEditarEndereco.setBackground(new Color(149, 208, 157));
		btnEditarEndereco.setIcon(new ImageIcon("src\\main\\resources\\imagens\\editar.png"));
		btnEditarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManterMedicoHelper cadastroMedicoHelper = new ManterMedicoHelper();
				StatusTela retornoStatusTela = null;
				Endereco retornoEndereco = setarObjetoEndereco();
				if(retornoEndereco==null) {
					JOptionPane.showMessageDialog(null, validacao,"Erro",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (retornoEndereco != null) {
					ManterEndereco manterEndereco = new ManterEndereco();
					retornoStatusTela = manterEndereco.consultarEndereco(retornoEndereco);
				}
				if (StatusTela.ENDERECOALTERADO == retornoStatusTela) {
					JOptionPane.showMessageDialog(null, "Endereço alterado");
					limparEndereco();
					limpaBordaEndereco();
				} else {
					if (StatusTela.ENDERECOCADASTRADO == retornoStatusTela) {
						JOptionPane.showMessageDialog(null, "Endereço cadastrado");
						limparEndereco();
						limpaBordaEndereco();
					} else {
						if (StatusTela.ERROALTERARENDERECO == retornoStatusTela) {
							JOptionPane.showMessageDialog(null, "Erro ao alterar o endereço ");
							limparEndereco();
							limpaBordaEndereco();
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar o endereço ");
							limparEndereco();
							limpaBordaEndereco();
						}

					}
				}

			}
		});
		panel_5.add(btnEditarEndereco, "cell 5 1,growy");

		txtBairro = new JTextField();
		panel_5.add(txtBairro, "cell 6 3,grow");
		txtBairro.setColumns(10);

		txtRua = new JTextField();
		panel_5.add(txtRua, "cell 8 3,grow");
		txtRua.setColumns(10);

		formatDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "Data inválida");
			e2.printStackTrace();
		}
		panel_3.add(txtData, "cell 3 1,grow");
		txtData.setColumns(22);

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e4) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
			e4.printStackTrace();
		}
		panel_3.add(txtCpf, "cell 3 3,grow");
		txtCpf.setColumns(23);

		JLabel lblNewLabel_6 = new JLabel("Telefone :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_6, "flowx,cell 3 5");

		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e5) {
			JOptionPane.showMessageDialog(null, "Telefone inválido");
			e5.printStackTrace();
		}
		panel_3.add(txtTelefone, "cell 3 5,grow");
		txtTelefone.setColumns(10);

		jrbFemi = new JRadioButton("F");
		buttonGroup.add(jrbFemi);
		jrbFemi.setBackground(new Color(240, 255, 240));
		panel_3.add(jrbFemi, "cell 6 3,grow");

		JLabel lblNewLabel_9 = new JLabel("CEP :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNewLabel_18 = new JLabel("Cep : ");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_18, "cell 0 1,alignx trailing");

		cbxEstado = new JComboBox<Estado>();
		cbxEstado.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				estados = enderecoDao.ConsultaEstadoCidade();
				for (int i = 0; i < estados.size(); i++) {
					cbxEstado.addItem(estados.get(i));
				}

			}

			public void ancestorMoved(AncestorEvent event) {

				// int pos = cbxEstado.getSelectedIndex();
				// Estado estadoselecionado = estados.get(pos);
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_5.add(cbxEstado, "cell 1 3,grow");

		JLabel lblNewLabel_20 = new JLabel("Consultar");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_6.add(lblNewLabel_20, "cell 0 0 8 1,alignx center");

		JLabel lblNewLabel_17 = new JLabel("Nome :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_17, "cell 0 1,alignx trailing");

		txtBuscaNome = new JTextField();
		panel_6.add(txtBuscaNome, "cell 1 1,grow");
		txtBuscaNome.setColumns(10);

		JButton btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.setForeground(new Color(255, 255, 255));
		btnBuscarCep.setBackground(new Color(149, 208, 157));
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cepString = txtCep.getText().replace("-", "");

				Endereco resultado = new Endereco();

				validacao = "";

				if (cepString != null && cepString.trim() != "" && !cepString.isEmpty()) {
					Integer cep = Integer.parseInt(cepString);
					Endereco consultaEndereco = new Endereco(cep);
					resultado = enderecoDao.consultarEndereco(consultaEndereco);

					if (resultado != null) {
						limparEndereco();
						int cepNovo = resultado.getCep();
						String ruaNova = resultado.getRua();
						String bairroNovo = resultado.getBairro();
						String cidadeNova = resultado.getCidade();
						Estado estadoNovo = resultado.getEstado();

						enderecoPronto = new Endereco();
						enderecoPronto.setCep(cepNovo);
						enderecoPronto.setCidade(cidadeNova);
						enderecoPronto.setEstado(estadoNovo);
						enderecoPronto.setRua(ruaNova);
						enderecoPronto.setBairro(bairroNovo);

						txtCep.setText(cepString);
						txtMunicipio.setText(enderecoPronto.getCidade());
						txtBairro.setText(enderecoPronto.getBairro());
						txtRua.setText(enderecoPronto.getRua());

						cbxEstado.setSelectedIndex(enderecoPronto.getEstado().getId() - 1);

						telaCadastroPaciente.getTxtCep().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroPaciente.getTxtBairro().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroPaciente.getTxtMunicipio().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroPaciente.getTxtRua().setBorder(new LineBorder(new Color(00, 00, 00), 1));
					} else {
						int replaced = JOptionPane.showConfirmDialog(null,
								"Endereço não Cadastrado, deseja cadastrar ?");

						String result = "0";
						switch (replaced) {

						case JOptionPane.NO_OPTION:
							result = "No";
							break;
						case JOptionPane.YES_OPTION:
							result = "Yes";
							break;

						case JOptionPane.CANCEL_OPTION:
							result = "Canceled";
							break;
						case JOptionPane.CLOSED_OPTION:
							result = "Closed";
							break;
						default:
							;
						}
						ManterFuncionarioHelper cadastroFuncionarioHelper = new ManterFuncionarioHelper();
						if (result.equals("Yes")) {
							consultaEndereco = setarObjetoEndereco();
							if(consultaEndereco==null) {
								return;
							}
							if (consultaEndereco != null) {
								boolean retorno = enderecoDao.inserirEndereco(consultaEndereco);
								if (retorno == true) {
									JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!");
									telaCadastroPaciente.getTxtCep()
											.setBorder(new LineBorder(new Color(00, 00, 00), 1));
									telaCadastroPaciente.getTxtBairro()
											.setBorder(new LineBorder(new Color(00, 00, 00), 1));
									telaCadastroPaciente.getTxtMunicipio()
											.setBorder(new LineBorder(new Color(00, 00, 00), 1));
									telaCadastroPaciente.getTxtRua()
											.setBorder(new LineBorder(new Color(00, 00, 00), 1));
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao cadastrar!", "Erro",
											JOptionPane.ERROR_MESSAGE);
								}
							}

						} else {
							limpaBordaEndereco();
							txtCep.setText("");
						}

					}
				} else {
					JOptionPane.showMessageDialog(null, "Informe o cep");
				}
			}

		});
		btnBuscarCep.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnBuscarCep, "cell 3 1 2 1,grow");

		JLabel lblNewLabel_10 = new JLabel("Estado :");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_10, "cell 0 3,alignx trailing");

		JLabel lblNewLabel_11 = new JLabel("Municipio :");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_11, "cell 3 3,alignx center");

		txtMunicipio = new JTextField();

		panel_5.add(txtMunicipio, "cell 4 3,grow");
		txtMunicipio.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Bairro: ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_12, "cell 5 3,alignx trailing,growy");

		JLabel lblNewLabel_13 = new JLabel("Rua : ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_13, "cell 7 3,alignx trailing");

		JLabel lblNewLabel_14 = new JLabel("N :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_14, "cell 0 5,alignx trailing");

		txtNCasa = new JTextField();

		panel_5.add(txtNCasa, "cell 1 5,grow");
		txtNCasa.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Complemento :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblNewLabel_15, "cell 3 5,alignx center");

		txtComplemento = new JTextField();
		panel_5.add(txtComplemento, "cell 4 5 2 1,grow");
		txtComplemento.setColumns(10);

		btnCadastra = new JButton("Cadastrar Paciente");
		btnCadastra.setForeground(new Color(255, 255, 255));
		btnCadastra.setBackground(new Color(149, 208, 157));
		btnCadastra.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ManterPacienteHelper manterPacienteHelper = new ManterPacienteHelper();

				Paciente paciente = new Paciente();
				Endereco endereco = new Endereco();

				validacao = "";

				paciente = setarObjetoPaciente();
				endereco = setarObjetoEndereco();

				if (paciente != null || endereco != null) {
					paciente.setEndereco(endereco);
					StatusTela retorno = manterPacienteHelper.cadastrarPaciente(paciente);
					if (retorno.PACIENTECADASTRADO == retorno) {
						JOptionPane.showMessageDialog(null, "Sucesso, paciente cadastrado");
						atualizarTabela();
						limparTela();
						limpaBorda();
					} else {
						if (retorno.PACIENTECADASTRADO == retorno) {
							JOptionPane.showMessageDialog(null, "Erro, paciente não cadastrado");
							limpaBorda();
						} else {
							JOptionPane.showMessageDialog(null, "Paciente existente", "Atenção",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				} else {
					JOptionPane.showMessageDialog(null, validacao, "Dados inválidos:", JOptionPane.ERROR_MESSAGE, null);
				}

			}

		});

		btnCadastra.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnCadastra, "cell 1 7 3 1,grow");

		JLabel lblNewLabel_16 = new JLabel("CPF :\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_16, "flowx,cell 3 1,alignx trailing");

		try {
			txtBuscaCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel_6.add(txtBuscaCpf, "cell 4 1,grow");
		txtBuscaCpf.setColumns(10);

		JButton btnBuscaPaciente = new JButton("Buscar");
		btnBuscaPaciente.setForeground(new Color(255, 255, 255));
		btnBuscaPaciente.setBackground(new Color(149, 208, 157));
		btnBuscaPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = txtBuscaCpf.getText().replace(".", "").replace("-", "");
				String nome = txtBuscaNome.getText();
				pacienteDao = new PacienteDao();
				if ((cpf != null && nome != null) || (cpf != null && nome == null) || (cpf == null && nome != null)) {
					ArrayList<Paciente> listPaciente = new ArrayList<>();
					if (cpf.trim() == "") {
						cpf = "0";

					}
					if (nome.trim() == "") {
						nome = "0";

					}
					listPaciente = pacienteDao.consultaCPFNome(nome, Long.parseLong(cpf));
					listaTabelaBusca(listPaciente);

				}

			}

		});
		btnBuscaPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnBuscaPaciente, "cell 6 1,grow");

		JButton btnLimpar = new JButton("   Limpar   ");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBackground(new Color(149, 208, 157));
		panel_6.add(btnLimpar, "cell 7 1,growy");

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_6.add(panel_7, "cell 1 2 7 1,grow");
		panel_7.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();

		panel_7.add(scrollPane, "name");

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Email" }));
		atualizarTabela();
		scrollPane.setViewportView(table);

		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(149, 208, 157));
		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}

				pacienteClick = listaPaciente.get(position);

				prencherPaciente(pacienteClick);

				pacienteClick = new Paciente();

				btnEditar.setVisible(false);
				panel_6.remove(btnEditar);

				btnExcluir.setVisible(false);
				panel_6.remove(btnExcluir);

				btnCadastra.setVisible(false);
				panel_5.remove(btnCadastra);

				voltar = new JButton("Cancelar");
				voltar.setForeground(new Color(255, 255, 255));
				voltar.setBackground(new Color(149, 208, 157));
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpaBorda();
						panel_5.add(btnCadastra);
						btnCadastra.setVisible(true);

						btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_6.add(btnEditar, "cell 1 4,grow");
						btnEditar.setVisible(true);

						btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_6.add(btnExcluir, "cell 4 4,grow");
						btnExcluir.setVisible(true);

						panel_6.remove(voltar);

						btnSalvar.setVisible(false);
						panel_5.remove(btnSalvar);

						limparTela();
					}
				});
				voltar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_6.add(voltar, "cell 1 4,grow");

				// TODO inserte de dados na tela

				btnSalvar = new JButton("Salvar");
				btnSalvar.setForeground(new Color(255, 255, 255));
				btnSalvar.setBackground(new Color(149, 208, 157));
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						validacao = "";

						Paciente paciente = new Paciente();
						Endereco endereco = new Endereco();
						paciente = setarObjetoPaciente();
						endereco = setarObjetoEndereco();

						if (paciente == null || endereco == null) {
							JOptionPane.showMessageDialog(null, validacao, "Dados inválidos:",
									JOptionPane.ERROR_MESSAGE, null);

						} else {
							paciente.setEndereco(endereco);
							ManterPacienteHelper manterPacienteHelper = new ManterPacienteHelper();
							StatusTela retorno = manterPacienteHelper.editarPaciente(paciente);
							if (retorno.PACIENTEALTERADO == retorno) {
								JOptionPane.showMessageDialog(null, "Sucesso, paciente alterado");
								atualizarTabela();
								limparTela();
								limpaBorda();
								panel_5.add(btnCadastra);
								btnCadastra.setVisible(true);

								btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
								panel_6.add(btnEditar, "cell 1 4,grow");
								btnEditar.setVisible(true);

								btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
								panel_6.add(btnExcluir, "cell 4 4,grow");
								btnExcluir.setVisible(true);

								panel_6.remove(voltar);

								btnSalvar.setVisible(false);
								panel_5.remove(btnSalvar);

							} else {
								if (retorno.PACIENTECADASTRADO == retorno) {
									JOptionPane.showMessageDialog(null, "Erro, paciente já cadastrado");
									limpaBorda();
								} else {
									JOptionPane.showMessageDialog(null, "Erro ao alterar o usuário", "SISTEMA",
											JOptionPane.ERROR_MESSAGE);

									limpaBorda();
									panel_5.add(btnCadastra);
									btnCadastra.setVisible(true);

									btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
									panel_6.add(btnEditar, "cell 1 4,grow");
									btnEditar.setVisible(true);

									btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
									panel_6.add(btnExcluir, "cell 4 4,grow");
									btnExcluir.setVisible(true);

									panel_6.remove(voltar);

									btnSalvar.setVisible(false);
									panel_5.remove(btnSalvar);

									limparTela();
								}

							}

						}

					}

				});
				btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_5.add(btnSalvar, "cell 1 6 3 1,grow");

			}

		});

		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnEditar, "cell 1 4,grow");

		btnVoltarEditar = new JButton("voltar");
		btnVoltarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();

				btnVoltarEditar.setVisible(false);
				panel_6.remove(btnVoltarEditar);

				btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_6.add(btnEditar, "cell 1 4,grow");
				btnEditar.setVisible(true);

				btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_6.add(btnExcluir, "cell 4 4,grow");
				btnExcluir.setVisible(true);

				btnCadastra.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_5.add(btnCadastra, "cell 1 7 3 1,grow");
				btnCadastra.setVisible(true);

			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBackground(new Color(149, 208, 157));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = table.getSelectedRow();
				
				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}

				pacienteClick = listaPaciente.get(position);
				
					
			

					AgendaDao agendaDao = new AgendaDao();

					int n = JOptionPane.showConfirmDialog(null,
							"Tem certeza que quer excluir?  " + pacienteClick.getNome(), "", JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.YES_OPTION) {

						boolean retorno = agendaDao
								.consultaPacienteCadastradoNaConsulta(Long.valueOf(pacienteClick.getCpf()));

						if (retorno == true) {
							Boolean result = pacienteDao.excluirPaciente(Long.valueOf(pacienteClick.getCpf()));
							JOptionPane.showMessageDialog(null, "Excluindo");
							atualizarTabela();
							limparTela();
						} else {
							n = JOptionPane.showConfirmDialog(null,
									"Existe consultas relacionadas com o paciente, deseja excluir mesmo assim ?\n"
											+ "Todos as consultas serão excluidas.",
									"Informação", JOptionPane.YES_NO_OPTION);
							if (n == JOptionPane.YES_OPTION) {
								boolean retornoExcluir = agendaDao
										.deletarConsultaReferenciadaPaciente(pacienteClick.getCpf());
								if (retornoExcluir == true) {
									Boolean result = pacienteDao.excluirPaciente(Long.valueOf(pacienteClick.getCpf()));
									if (result == true) {
										JOptionPane.showMessageDialog(null, "Excluindo");
										atualizarTabela();
										limparTela();
									} else {
										JOptionPane.showMessageDialog(null, " erro ao excluir");
										limparTela();
									}
								} else {
									JOptionPane.showMessageDialog(null, " erro ao excluir");
									limparTela();
								}

							}
						}

						atualizarTabela();
						limparTela();
					}

				
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnExcluir, "cell 4 4,grow");

		JButton btnVoltar = new JButton("Voltar para o menu principal");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(149, 208, 157));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaMenuPrincipal mp = new TelaMenuPrincipal(usuario);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnVoltar, "cell 7 4,growx");

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 0, 1924, 73);
		panel_8.setBackground(new Color(143, 188, 143));

		JLabel lblNewLabel_1_1 = new JLabel("Manter paciente\r\n");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));

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
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING).addGap(0, 1924, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup().addGap(73)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)
						.addGap(888).addComponent(btnLoginSair)));
		gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING).addGap(0, 68, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup().addGap(7).addComponent(btnLoginSair,
						GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_8.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addContainerGap()));
		panel_8.setLayout(gl_panel_8);
		contentPane.setLayout(null);
		contentPane.add(panelSairPerfil);
		contentPane.add(panel);
		contentPane.add(panel_8);

	}

	public JTextField getTxtBuscaCep() {
		return txtBuscaCpf;
	}

	public void setTxtBuscaCep(JTextField txtBuscaCep) {
		this.txtBuscaCpf = txtBuscaCep;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public Paciente getPacienteClick() {
		return pacienteClick;
	}

	public void setPacienteClick(Paciente pacienteClick) {
		this.pacienteClick = pacienteClick;
	}

	public JComboBox<Estado> getCbxEstado() {
		return cbxEstado;
	}

	public void setCbxEstado(JComboBox<Estado> cbxEstado) {
		this.cbxEstado = cbxEstado;
	}

	public JComboBox<Convenio> getCbxConvenio() {
		return cbxConvenio;
	}

	public void setCbxConvenio(JComboBox<Convenio> cbxConvenio) {
		this.cbxConvenio = cbxConvenio;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtProfissao() {
		return txtProfissao;
	}

	public JTextField getTxtData() {
		return txtData;
	}

	public JTextField getTxtCpf() {
		return txtCpf;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public JTextField getTxtMunicipio() {
		return txtMunicipio;
	}

	public JTextField getTxtBairro() {
		return txtBairro;
	}

	public JTextField getTxtRua() {
		return txtRua;
	}

	public JTextField getTxtNCasa() {
		return txtNCasa;
	}

	public JTextField getTxtComplemento() {
		return txtComplemento;
	}

	public JTextField getTxtBuscaNome() {
		return txtBuscaNome;
	}

	public JTextField getTxtCep() {
		return txtCep;
	}

	public JRadioButton getJrbFemi() {
		return jrbFemi;
	}

	public JRadioButton getJrbMasc() {
		return jrbMasc;
	}

	public Paciente setarObjetoPaciente() {

		Paciente paciente = new Paciente();

		String nome = telaCadastroPaciente.getTxtNome().getText();

		String cpfTxt = telaCadastroPaciente.getTxtCpf().getText().replace(".", "").replace("-", "");

		String sexo = "";

		String email = telaCadastroPaciente.getTxtEmail().getText();

		String telefone = telaCadastroPaciente.getTxtTelefone().getText().replace("-", "").replace("(", "").replace(")",
				"");

		String dataN = telaCadastroPaciente.getTxtData().getText();

		String complemento = telaCadastroPaciente.getTxtComplemento().getText();

		String numeroCasa = telaCadastroPaciente.getTxtNCasa().getText();

		String profissao = txtProfissao.getText();

		if (telaCadastroPaciente.getJrbFemi().isSelected()) {
			sexo = "F";
		}
		if (telaCadastroPaciente.getJrbMasc().isSelected()) {
			sexo = "M";
		}
		if (telaCadastroPaciente.getJrbMasc() == null || telaCadastroPaciente.getJrbFemi() == null) {
			sexo = null;
		}
		// TODO nova validacao nome
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			telaCadastroPaciente.getTxtNome().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Nome\n";
		} else {
			telaCadastroPaciente.getTxtNome().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setNome(nome);
		}
		// cpf

		if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
			telaCadastroPaciente.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "CPF\n";
		} else {
			telaCadastroPaciente.getTxtCpf().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Long cpf = Long.valueOf(cpfTxt);
			Long cpfConsulta = Long.valueOf(cpfTxt);
			paciente.setCpf(cpf);
		}
		// sexo

		if (sexo == null || sexo.isEmpty()) {
			telaCadastroPaciente.getJrbFemi().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			telaCadastroPaciente.getJrbMasc().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Sexo\n";
		} else {
			telaCadastroPaciente.getJrbFemi().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			telaCadastroPaciente.getJrbMasc().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setSexo(sexo);
		}
		// email
		if (email == null || email.trim() == "" || email.isEmpty()) {
			telaCadastroPaciente.getTxtEmail().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Email\n";
		} else {
			telaCadastroPaciente.getTxtEmail().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
			telaCadastroPaciente.getTxtTelefone().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Telefone\n";
		} else {
			telaCadastroPaciente.getTxtTelefone().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setTelefone(telefone);

		}

		// data Nascimento
		if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
			validacao += "Data\n";
			telaCadastroPaciente.getTxtData().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			String dataTest = dataN.replace("/", "").trim();
			if (dataTest.length() == 0) {
				validacao += "Data\n";
				telaCadastroPaciente.getTxtData().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				telaCadastroPaciente.getTxtData().setBorder(new LineBorder(new Color(00, 00, 00), 1));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dta = LocalDate.parse(dataN, formatter);
				dta.format(formatter);

				// tratamento de data para ver se é menor
				LocalDate dataAtual = LocalDate.now();

				if (dataAtual.isBefore(dta)) {
					validacao += "Informe uma data anterior";

				} else {
					paciente.setDataNascimento(dta);
				}

			}

		}
		if (profissao == null || profissao.trim() == "" || profissao.isEmpty()) {
			txtProfissao.setBorder(new LineBorder(new Color(255, 00, 00), 4));

		} else {
			paciente.setProfissao(profissao);
		}

		// Complemento
		paciente.setComplemento(complemento);

		if (numeroCasa == null || numeroCasa.trim() == "" || numeroCasa.isEmpty()) {
			validacao += "Numero\n";
			telaCadastroPaciente.getTxtNCasa().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			telaCadastroPaciente.getTxtNCasa().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Integer nCasa = Integer.valueOf(numeroCasa);
			paciente.setNumero(nCasa);
		}

		int posicao = telaCadastroPaciente.getCbxConvenio().getSelectedIndex();
		Convenio convenio = new Convenio();
		convenio.setId(posicao + 1);
		paciente.setConvenio(convenio);

		if (validacao.trim() != "") {
			return null;
		}
		return paciente;

	}

	public Endereco setarObjetoEndereco() {

		StatusTela statusTela = null;
		Endereco endereco = new Endereco();
		enderecoDao = new EnderecoDao();
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco resultadoEndereco = new Endereco();
		String cepString = telaCadastroPaciente.getTxtCep().getText().replace(".", "").replace("-", "");

		String cidade = telaCadastroPaciente.getTxtMunicipio().getText();
		String bairro = telaCadastroPaciente.getTxtBairro().getText();
		String rua = telaCadastroPaciente.getTxtRua().getText();

		if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
			validacao += " Cep\n";
			telaCadastroPaciente.getTxtCep().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			Integer cep = Integer.valueOf(cepString);
			endereco.setCep(cep);
		}

		if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
			validacao += " Bairro\n";
			telaCadastroPaciente.getTxtBairro().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setBairro(bairro);
		}
		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			validacao += " Cidade\n";
			telaCadastroPaciente.getTxtMunicipio().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setCidade(cidade);
		}
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			validacao += " Rua\n";
			telaCadastroPaciente.getTxtRua().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setRua(rua);
		}

		int posicao = telaCadastroPaciente.getCbxEstado().getSelectedIndex();
		Estado estado = new Estado();
		estado.setId(posicao + 1);
		endereco.setEstado(estado);

		if (validacao.trim() == "") {
			return endereco;
		}
		return null;

	}

	protected void prencherPaciente(Paciente pacienteClick2) {

		txtNome.setText(pacienteClick.getNome());
		txtEmail.setText(pacienteClick.getEmail());
		txtTelefone.setText(pacienteClick.getTelefone());
		txtComplemento.setText(pacienteClick.getComplemento());
		txtNCasa.setText(String.valueOf(pacienteClick.getNumero()));
		txtCpf.setEditable(false);
		txtCpf.setText(String.valueOf(pacienteClick.getCpf()));
		Date data = Date.valueOf(pacienteClick.getDataNascimento());
		txtData.setText(formatDate.format(data));
		txtProfissao.setText(pacienteClick.getProfissao());

		String sexo = pacienteClick.getSexo();
		if (sexo.equals("F")) {
			jrbFemi.setSelected(true);
		} else if (sexo.equals("M")) {
			jrbMasc.setSelected(true);
		}
		cbxConvenio.setSelectedIndex(pacienteClick.getConvenio().getId() - 1);

		Integer cep = pacienteClick.getEndereco().getCep();
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = new Endereco(cep);
		Endereco enderecoDoBanco = enderecoDao.consultarEndereco(endereco);
		txtCep.setText(String.valueOf(enderecoDoBanco.getCep()));
		txtBairro.setText(enderecoDoBanco.getBairro());
		txtMunicipio.setText(enderecoDoBanco.getCidade());
		txtRua.setText(enderecoDoBanco.getRua());
		cbxEstado.setSelectedIndex(enderecoDoBanco.getEstado().getId() - 1);

	}

	private void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Email" });

		listaPaciente = pacienteDao.consultarPaciente();
		for (int i = 0; i < listaPaciente.size(); i++) {
			Paciente paciente = listaPaciente.get(i);
			tabela.addRow(new Object[] { paciente.getNome(), paciente.getCpf(), paciente.getEmail() });

		}
		table.setModel(tabela);
	}

	private void habilitarInsercao() {
		limparTela();
		txtCpf.setEditable(true);
	}

	private void limparTela() {
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtComplemento.setText("");
		txtNCasa.setText("");
		txtCpf.setText("");
		txtCpf.setEditable(true);
		txtData.setText("");
		txtProfissao.setText("");
		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");
		txtCep.setText("");
		txtRua.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
	}

	private void limpaBorda() {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		txtNome.setBorder(blackline);
		txtEmail.setBorder(blackline);
		txtTelefone.setBorder(blackline);
		txtData.setBorder(blackline);
		txtCpf.setBorder(blackline);

		txtComplemento.setBorder(blackline);
		txtNCasa.setBorder(blackline);

		txtCep.setBorder(blackline);
		txtRua.setBorder(blackline);
		txtBairro.setBorder(blackline);
		txtMunicipio.setBorder(blackline);

		txtProfissao.setBorder(blackline);

		txtCep.setBorder(blackline);
		txtRua.setBorder(blackline);
		txtBairro.setBorder(blackline);
		txtMunicipio.setBorder(blackline);

	}

	private void limparEndereco() {

		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");
	}

	private void limpaBordaEndereco() {
		txtCep.setBorder(new LineBorder(new Color(00, 00, 00), 1));

		txtRua.setBorder(new LineBorder(new Color(00, 00, 00), 1));

		txtBairro.setBorder(new LineBorder(new Color(00, 00, 00), 1));

		txtMunicipio.setBorder(new LineBorder(new Color(00, 00, 00), 1));

	}

	public void listaTabelaBusca(ArrayList<Paciente> listPaciente) {

		modelTabelaBusca = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "E-mail" });

		for (int i = 0; i < listPaciente.size(); i++) {
			Paciente paciente = listPaciente.get(i);
			modelTabelaBusca.addRow(new Object[] { paciente.getNome(), paciente.getCpf(), paciente.getEmail() });

		}
		table.setModel(modelTabelaBusca);
	}
}