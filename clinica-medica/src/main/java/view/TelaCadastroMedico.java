package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import controller.MedicoDao;
import controller.UsuarioDao;
import helper.ManterEndereco;
import helper.ManterFuncionarioHelper;
import helper.ManterMedicoHelper;
import helper.ManterPacienteHelper;
import model.Endereco;
import model.Estado;
import model.Medico;
import model.StatusTela;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import utils.RoundButton;
import javax.swing.ButtonGroup;

/**
 * 
 * @author Eliezer da Silva
 * 
 *         Classe resposavel por exibir Tela de cadastro de paciente
 *
 */
public class TelaCadastroMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EnderecoDao enderecoDao = new EnderecoDao();

	private MedicoDao medicoDao = new MedicoDao();
	private UsuarioDao usuarioDao;
	private Medico medicoClick;

	private JPanel contentPane;
	Endereco enderecoPronto = null;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtData;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtCep;
	private JTextField txtMunicipio;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtCasaNumero;
	private JTextField txtComplemento;
	private JTextField txtCrm;
	private JTextField txtEspecializacao;
	private JTextField txtUsuario;
	private JButton btnSalvar;
	private JPasswordField txtSenha;

	// USuario
	private String usuario;
	private String senha;
	private String validacao = "";
	private int nivelAcesso;

	private JTextField txtBuscarCrm;
	private JTextField txtBuscarCPF;
	private JTable table;
	private SimpleDateFormat formatDate;

	private JRadioButton rdbtnFeminino1;

	private JRadioButton rdbtnMasculino1;

	private Endereco cadastroEndereco;

	ArrayList<Estado> estados = new ArrayList<>();
	private ArrayList<Medico> listaMedico = new ArrayList<>();
	private JComboBox<Estado> cbxEstado;

	private Long cpf;

	private JButton btn_Excluir;

	private JButton btnVoltar;

	private JButton btn_editar;

	private JComponent panel_5;

	private JComponent panel_6;

	private AbstractButton btnCadastrarMedico;

	private JComponent panel_9;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private TelaCadastroMedico telaCadastroMedico;

	private JPanel panelSairPerfil;

	private JButton btnSair;

	private JComponent lblNewLabel;

	private JButton btnPerfil;
	private int sairPerfil;

	/**
	 * Create the frame.
	 */
	public TelaCadastroMedico(Usuario usuario) {
		this.usuario = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.nivelAcesso = usuario.getNivelAcesso();
		this.telaCadastroMedico = this;
		this.listaMedico = medicoDao.listaMedicos();
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Tela Cadastro de médico");

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

		formatDate = new SimpleDateFormat("dd/MM/yyyy");

		JPanel panel = new JPanel();
		panel.setBounds(372, 86, 1184, 876);
		panel.setBackground(new Color(143, 188, 143));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(143, 188, 143));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 25));

		JLabel lblNewLabel = new JLabel("Cadastro Médico ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_4, BorderLayout.CENTER);

		panel_4.setLayout(new MigLayout("", "[1167.00:n:1150,grow]",
				"[150:n:150,grow][160:n:125,grow][60:n:60,grow][90:n:80,grow][350:n:300,grow]"));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_3.setBackground(new Color(236, 253, 232));
		panel_4.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(
				new MigLayout("", "[][300:n:300,grow][300:n:300][150:n:150,grow]", "[30:n:30][30:n:30][30:n:30]"));

		JLabel lblNewLabel_1 = new JLabel("Nome : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_1, "cell 0 0,alignx center,growy");

		txtNome = new JTextField();
		panel_3.add(txtNome, "cell 1 0,grow");
		txtNome.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Data :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_4, "flowx,cell 2 0,growx");

		JLabel lblNewLabel_2 = new JLabel("E-mail :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_2, "cell 0 1,alignx center");

		txtEmail = new JTextField();
		panel_3.add(txtEmail, "cell 1 1,grow");
		txtEmail.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Cpf :    ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_5, "flowx,cell 2 1,grow");

		txtCpf = new JTextField();

		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e3) {
			JOptionPane.showMessageDialog(null, "Data inválida");
			e3.printStackTrace();
		}
		panel_3.add(txtData, "cell 2 0,grow");
		txtData.setColumns(22);

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e5) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
			e5.printStackTrace();
		}

		panel_3.add(txtCpf, "cell 2 1,grow");
		txtCpf.setColumns(23);

		JLabel lblNewLabel_81 = new JLabel("Sexo :");
		lblNewLabel_81.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_81, "cell 0 2");

		rdbtnMasculino1 = new JRadioButton("M    ");
		buttonGroup.add(rdbtnMasculino1);
		rdbtnMasculino1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMasculino1.setBorder(new LineBorder(new Color(0, 0, 0)));
		rdbtnMasculino1.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnMasculino1, "flowx,cell 1 2,alignx left,growy");

		rdbtnFeminino1 = new JRadioButton("F");
		buttonGroup.add(rdbtnFeminino1);
		rdbtnFeminino1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnFeminino1.setBorder(new LineBorder(new Color(0, 0, 0)));
		rdbtnFeminino1.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnFeminino1, "cell 1 2,alignx center,growy");

		JLabel lblNewLabel_6 = new JLabel("Telefone :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_6, "flowx,cell 2 2");

		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e6) {
			JOptionPane.showMessageDialog(null, "Telefone inválido");
			e6.printStackTrace();
		}
		panel_3.add(txtTelefone, "cell 2 2,grow");
		txtTelefone.setColumns(10);

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(236, 253, 232));
		panel_5.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("",
				"[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][200:n:200px,grow]",
				"[][][30:n:30][30:n:30]"));

		JLabel lblNewLabel_9 = new JLabel("CEP :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_9, "cell 0 0,alignx trailing");

		txtCep = new JTextField();

		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e7) {
			JOptionPane.showMessageDialog(null, "Telefone inválido");
			e7.printStackTrace();
		}

		panel_5.add(txtCep, "cell 1 0 2 1,grow");
		txtCep.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBackground(new Color(149, 208, 157));
		btnBuscar.addActionListener(new ActionListener() {
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

						telaCadastroMedico.getTxtCep().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroMedico.getTxtBairro().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroMedico.getTxtMunicipio().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroMedico.getTxtRua().setBorder(new LineBorder(new Color(00, 00, 00), 1));
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
								JOptionPane.showMessageDialog(null, validacao,"Erro",JOptionPane.ERROR_MESSAGE);
								return;
							}
							if (consultaEndereco != null) {
								boolean retorno = enderecoDao.inserirEndereco(consultaEndereco);
								if (retorno == true) {
									JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!");
									limpaBordaEndereco();
									limparEndereco();
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao cadastrar!", "Erro",
											JOptionPane.ERROR_MESSAGE);
									limpaBordaEndereco();
									limparEndereco();
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
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnBuscar, "cell 3 0 2 1,grow");

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
		panel_5.add(btnEditarEndereco, "cell 5 0,growy");

		JLabel lblNewLabel_10 = new JLabel("Estado :");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_10, "cell 0 2,alignx trailing");

		cbxEstado = new JComboBox<Estado>();
		cbxEstado.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				estados = enderecoDao.ConsultaEstadoCidade();
				for (int i = 0; i < estados.size(); i++) {
					cbxEstado.addItem(estados.get(i));
				}

			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub

			}

		});
		panel_5.add(cbxEstado, "cell 1 2,grow");

		JLabel lblNewLabel_11 = new JLabel("Municipio :");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_11, "cell 2 2,alignx center");

		txtMunicipio = new JTextField();
		panel_5.add(txtMunicipio, "cell 3 2,grow");
		txtMunicipio.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Bairro: ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_12, "cell 4 2,alignx trailing,growy");

		txtBairro = new JTextField();
		panel_5.add(txtBairro, "cell 5 2,grow");
		txtBairro.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Rua : ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_13, "cell 6 2,alignx trailing");

		txtRua = new JTextField();
		panel_5.add(txtRua, "cell 7 2,grow");
		txtRua.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("N :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_14, "cell 0 3,alignx trailing");

		txtCasaNumero = new JTextField();
		panel_5.add(txtCasaNumero, "cell 1 3,grow");
		txtCasaNumero.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Complemento :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblNewLabel_15, "cell 2 3,alignx center");

		txtComplemento = new JTextField();
		panel_5.add(txtComplemento, "cell 3 3 2 1,grow");
		txtComplemento.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(236, 253, 232));
		panel_8.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_8, "cell 0 2,grow");
		panel_8.setLayout(new MigLayout("", "[][][200:n:200,grow][][200:n:200,grow][][150:n:150]", "[][30:n:30]"));

		JLabel lblNewLabel_18 = new JLabel("CRM :");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_8.add(lblNewLabel_18, "cell 1 1,alignx trailing");

		JLabel lblNewLabel_19 = new JLabel("Especialização :");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_8.add(lblNewLabel_19, "cell 3 1,alignx trailing");

		try {
			txtCrm = new JFormattedTextField(new MaskFormatter("######"));
		} catch (ParseException e8) {
			JOptionPane.showMessageDialog(null, "CRM inválido");
			e8.printStackTrace();
		}
		panel_8.add(txtCrm, "cell 2 1,grow");
		txtCrm.setColumns(10);

		txtEspecializacao = new JTextField();
		panel_8.add(txtEspecializacao, "cell 4 1,grow");
		txtEspecializacao.setColumns(10);

		panel_9 = new JPanel();
		panel_9.setBackground(new Color(236, 253, 232));
		panel_9.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_9, "cell 0 3,grow");
		panel_9.setLayout(new MigLayout("",
				"[80:n:80][200:n:200,grow][130:n:130][200:n:200,grow][300:n:250][495.00:n:220]", "[30:n:30][30:n:30]"));

		JLabel lblNewLabel_23 = new JLabel("Login");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_9.add(lblNewLabel_23, "cell 0 0 6 1,alignx center");

		txtUsuario = new JTextField();
		panel_9.add(txtUsuario, "cell 1 1,grow");
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Senha :");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_20, "cell 2 1,alignx trailing");

		btnCadastrarMedico = new JButton("Cadastrar Novo Médico ");
		btnCadastrarMedico.setForeground(new Color(255, 255, 255));
		btnCadastrarMedico.setBackground(new Color(149, 208, 157));
		btnCadastrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManterMedicoHelper manterMedicoHelper = new ManterMedicoHelper();

				Medico medico = new Medico();
				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();

				validacao = "";

				medico = setarObjetoMedico();
				endereco = setarObjetoEndereco();
				usuario = setarObjetoUsuario();

				if (medico != null && usuario != null && endereco != null) {
					StatusTela retorno = manterMedicoHelper.cadastrarMedico(medico);
					if (retorno.USUARIOEXISTENTE == retorno) {
						JOptionPane.showMessageDialog(null, "Usuário existente, informe outro", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (retorno.MEDICOCADASTRADO == retorno) {
							JOptionPane.showMessageDialog(null, "Médico cadastrado");
							atualizarTabela();
							limparTela();
							limparBorda();
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar", "ERRO",
									JOptionPane.ERROR_MESSAGE);
						}

					}

				} else {
					JOptionPane.showMessageDialog(null, validacao, "Dados inválidos:", JOptionPane.ERROR_MESSAGE, null);
				}

			}

		});

		txtSenha = new JPasswordField();
		panel_9.add(txtSenha, "cell 3 1,grow");

		btnCadastrarMedico.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(btnCadastrarMedico, "cell 5 1,growx,aligny top");

		JLabel lblNewLabel_21 = new JLabel("Usuario : ");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_21, "cell 0 1,alignx trailing");

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(236, 253, 232));
		panel_6.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_6, "cell 0 4,grow");
		panel_6.setLayout(new MigLayout("",
				"[80:n:80][200:n:200,grow][100px:n:100px,grow][200:n:200][][200:n:200,grow][][][150:n:150]",
				"[][][][200:n:150,grow][][]"));

		JLabel lblNewLabel_8 = new JLabel("CRM : ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_8, "cell 0 1,alignx trailing");

		txtBuscarCrm = new JTextField();
		panel_6.add(txtBuscarCrm, "cell 1 1,grow");
		txtBuscarCrm.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("CPF : ");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_16, "cell 2 1,alignx trailing");

		txtBuscarCPF = new JTextField();
		panel_6.add(txtBuscarCPF, "cell 3 1,grow");
		txtBuscarCPF.setColumns(10);

		JButton btnBuscarTabela = new JButton("Buscar");
		btnBuscarTabela.setForeground(new Color(255, 255, 255));
		btnBuscarTabela.setBackground(new Color(149, 208, 157));
		btnBuscarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String crm = txtBuscarCrm.getText();
				String cpf = txtBuscarCPF.getText().replace(".", "").replace("-", "");
				;
				var medico = new Medico();
				if (cpf != null) {
					medico = medicoDao.consultaDadosMedicoCPF(Long.valueOf(cpf));
					if (medico != null) {
						atualizarTabelaBusca(medico);
					}

				}

				if (crm != null) {
					medico = medicoDao.consultarDadosMedicoCRM(Long.valueOf(crm));
					if (medico != null) {
						atualizarTabelaBusca(medico);

					}
				}
				if (medico == null) {
					JOptionPane.showMessageDialog(null, "Nenhum médico Cadastrado");
				}
				if (crm == null && cpf == null) {
					JOptionPane.showMessageDialog(null, "Informe algum dado");
				}

			}
		});
		btnBuscarTabela.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnBuscarTabela, "cell 5 1,growx,aligny center");

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setBackground(new Color(149, 208, 157));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
				txtBuscarCPF.setText("");
				txtBuscarCrm.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnLimpar, "cell 7 1,growy");

		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, "cell 1 3 8 1,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CRM", "CPF", "Email" }));
		table.getColumnModel().getColumn(2).setPreferredWidth(77);
		atualizarTabela();
		scrollPane.setViewportView(table);

		btn_editar = new JButton("Editar");
		btn_editar.setForeground(new Color(255, 255, 255));
		btn_editar.setBackground(new Color(149, 208, 157));
		btn_editar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				medicoClick = listaMedico.get(position);
				EditarMedico(medicoClick);

				btnCadastrarMedico.setVisible(false);
				panel_9.remove(btnCadastrarMedico);

				btn_editar.setVisible(false);
				panel_6.remove(btn_editar);

				btn_Excluir.setVisible(false);
				panel_6.remove(btn_Excluir);

				JButton voltar = new JButton("Cancelar");
				voltar.setForeground(new Color(255, 255, 255));
				voltar.setBackground(new Color(149, 208, 157));
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limparBorda();
						panel_9.add(btnCadastrarMedico);
						btnCadastrarMedico.setVisible(true);

						btn_editar.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_6.add(btn_editar, "cell 1 5,growx");
						btn_editar.setVisible(true);

						btn_Excluir.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_6.add(btn_Excluir, "cell 3 5,grow");
						btn_Excluir.setVisible(true);

						panel_6.remove(voltar);

						btnSalvar.setVisible(false);
						panel_9.remove(btnSalvar);

						limparTela();
					}
				});
				voltar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_6.add(voltar, "cell 1 5,growx");

				btnSalvar = new JButton("Salvar");
				btnSalvar.setForeground(new Color(255, 255, 255));
				btnSalvar.setBackground(new Color(149, 208, 157));
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Medico medico = new Medico();
						txtCpf.setEditable(false);
						txtCrm.setEditable(false);
						medico = setarObjetoMedico();
						ManterMedicoHelper manterMedicoHelper = new ManterMedicoHelper();
						long id = (medicoClick.getUsuario().getId());
						medico.getUsuario().setId(id);
						StatusTela retorno = manterMedicoHelper.alterarMedico(medico);
						if (retorno.USUARIOEXISTENTE == retorno) {
							JOptionPane.showMessageDialog(null, "Usuário existente, Informe outro");
						} else {
							if (retorno.MEDICOEDITADO == retorno) {
								JOptionPane.showMessageDialog(null, "Alteração com sucesso");
								limparBorda();
								panel_9.add(btnCadastrarMedico);
								btnCadastrarMedico.setVisible(true);

								btn_editar.setFont(new Font("Tahoma", Font.BOLD, 16));
								panel_6.add(btn_editar, "cell 1 5,growx");
								btn_editar.setVisible(true);

								btn_Excluir.setFont(new Font("Tahoma", Font.BOLD, 16));
								panel_6.add(btn_Excluir, "cell 3 5,grow");
								btn_Excluir.setVisible(true);

								panel_6.remove(voltar);

								btnSalvar.setVisible(false);
								panel_9.remove(btnSalvar);
								atualizarTabela();
								limparTela();
							} else {
								limparBorda();
								panel_9.add(btnCadastrarMedico);
								btnCadastrarMedico.setVisible(true);

								btn_editar.setFont(new Font("Tahoma", Font.BOLD, 16));
								panel_6.add(btn_editar, "cell 1 5,growx");
								btn_editar.setVisible(true);

								btn_Excluir.setFont(new Font("Tahoma", Font.BOLD, 16));
								panel_6.add(btn_Excluir, "cell 3 5,grow");
								btn_Excluir.setVisible(true);

								panel_6.remove(voltar);

								btnSalvar.setVisible(false);
								panel_9.remove(btnSalvar);
								atualizarTabela();
								limparTela();
							}
						}
						txtCpf.setEditable(true);
						txtCrm.setEditable(true);

					}
				});
				btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_9.add(btnSalvar, "cell 5 1,grow");

				if (medicoClick != null) {
					preencherMedicoTabela(medicoClick);

				}
			}
		});
		btn_editar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btn_editar, "cell 1 5,growx");

		btn_Excluir = new JButton("Excluir");
		btn_Excluir.setForeground(new Color(255, 255, 255));
		btn_Excluir.setBackground(new Color(149, 208, 157));
		btn_Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = table.getSelectedRow();
				
				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}

				medicoClick = listaMedico.get(position);
				if (btn_editar != null)
					panel_5.remove(btn_editar);
				if (medicoClick != null) {
					AgendaDao agendaDao = new AgendaDao();

					int n = JOptionPane.showConfirmDialog(null,
							"Tem certeza que quer excluir?  " + medicoClick.getNome(), "", JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.YES_OPTION) {

						boolean retorno = agendaDao
								.consultaMedicoCadastradoNaConsulta(Long.valueOf(medicoClick.getCpf()));

						if (retorno == true) {
							Boolean result = medicoDao.excluirMedico(Long.valueOf(medicoClick.getCpf()));
							JOptionPane.showMessageDialog(null, "Excluindo");
							UsuarioDao usuarioDao = new UsuarioDao();
							usuarioDao.deletarUsuario(medicoClick.getUsuario());
							atualizarTabela();
							limparTela();
						} else {
							n = JOptionPane.showConfirmDialog(null,
									"Existe consultas relacionadas com o médico, deseja excluir mesmo assim ?\n"
											+ "Todos as consultas serão excluidas.",
									"Informação", JOptionPane.YES_NO_OPTION);
							if (n == JOptionPane.YES_OPTION) {
								boolean retornoExcluir = agendaDao
										.deletarConsultaReferenciadaMedico(medicoClick.getCpf());
								if (retornoExcluir == true) {
									Boolean result = medicoDao.excluirMedico(Long.valueOf(medicoClick.getCpf()));
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
				} else {
					JOptionPane.showMessageDialog(null, " erro ao excluir");
					limparTela();
				}

			}
		});
		btn_Excluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btn_Excluir, "cell 3 5,grow");

		btnVoltar = new JButton("Voltar para o menu principal");
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
		panel_6.add(btnVoltar, "cell 7 5 2 1,grow");
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		panel.setLayout(new MigLayout("", "[1164.00px:n:1300]", "[780:n:900]"));
		panel.add(panel_1, "cell 0 0,alignx left,growy");
		contentPane.add(panel);
		contentPane.add(panel);

		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBackground(new Color(143, 188, 143));
		panel_8_1.setBounds(0, 0, 1934, 68);
		contentPane.add(panel_8_1);

		JLabel lblNewLabel_1_1 = new JLabel("Manter médico");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(149, 208, 157));
		btnNewButton_3.addActionListener(new ActionListener() {

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

		panelSairPerfil = new JPanel();
		panelSairPerfil.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		panelSairPerfil.setBackground(new Color(143, 188, 143));
		panelSairPerfil.setBounds(1650, 80, 266, 200);
		panelSairPerfil.setForeground(Color.BLACK);
		panelSairPerfil.setLayout(new MigLayout("", "[240:n]", "[][50:n][10:n][50:n][10:n][50:n][10:n][50:n]"));
		contentPane.add(panelSairPerfil);
		panelSairPerfil.setVisible(false);

		lblNewLabel = new JLabel("/");
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

		btnPerfil = new JButton("Perfil");
		btnPerfil.setBackground(SystemColor.controlHighlight);
		btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPerfil.setBorder(null);
		btnPerfil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		panelSairPerfil.add(btnPerfil, "cell 0 3,grow");
		btnPerfil.setVisible(true);
		btnSair.setVisible(true);
		lblNewLabel.setVisible(true);

		contentPane.add(panelSairPerfil);
		panelSairPerfil.setVisible(false);

		GroupLayout gl_panel_8_1 = new GroupLayout(panel_8_1);
		gl_panel_8_1.setHorizontalGroup(gl_panel_8_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_8_1
				.createSequentialGroup().addGap(59)
				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE).addGap(893)
				.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE).addGap(96)));
		gl_panel_8_1.setVerticalGroup(gl_panel_8_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_8_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_8_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
								.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
						.addGap(11)));
		panel_8_1.setLayout(gl_panel_8_1);

		JButton btnNewButton = new RoundButton("Entrar");
		btnNewButton.setIcon(new ImageIcon(
				"C:\\Users\\frete\\Documents\\clinica-medica\\src\\imagens\\icons8-login-arredondado-30.png"));

		btnNewButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnNewButton.setBackground(new Color(00, 255, 00));
			}

			@Override
			public void focusLost(FocusEvent e) {
				btnNewButton.setBackground(new Color(51, 153, 51));
			}
		});
	}

	protected void limparEndereco() {
		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");

	}

	protected void limparBorda() {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		txtNome.setBorder(blackline);
		txtEmail.setBorder(blackline);
		txtTelefone.setBorder(blackline);
		txtComplemento.setBorder(blackline);
		txtCasaNumero.setBorder(blackline);
		txtCpf.setBorder(blackline);
		txtData.setBorder(blackline);

		txtUsuario.setBorder(blackline);
		txtSenha.setBorder(blackline);

		txtCep.setBorder(blackline);
		txtRua.setBorder(blackline);
		txtBairro.setBorder(blackline);
		txtMunicipio.setBorder(blackline);

		txtCrm.setBorder(blackline);
		txtEspecializacao.setBorder(blackline);

	}

	public JRadioButton getRdbtnFeminino1() {
		return rdbtnFeminino1;
	}

	public void setRdbtnFeminino1(JRadioButton rdbtnFeminino1) {
		this.rdbtnFeminino1 = rdbtnFeminino1;
	}

	public JComboBox<Estado> getCbxEstado() {
		return cbxEstado;
	}

	public void setCbxEstado(JComboBox<Estado> cbxEstado) {
		this.cbxEstado = cbxEstado;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
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

	public JTextField getTxtCep() {
		return txtCep;
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

	public JTextField getTxtCasaNumero() {
		return txtCasaNumero;
	}

	public JTextField getTxtComplemento() {
		return txtComplemento;
	}

	public JTextField getTxtCrm() {
		return txtCrm;
	}

	public JTextField getTxtEspecializacao() {
		return txtEspecializacao;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public String getSenha() {
		return senha;
	}

	public JTextField getTxtBuscarCrm() {
		return txtBuscarCrm;
	}

	public JTextField getTxtBuscarNome() {
		return txtBuscarCPF;
	}

	public JRadioButton getRdbtnMasculino1() {
		return rdbtnMasculino1;
	}

	public Medico setarObjetoMedico() {

		Medico medico = new Medico();

		String nome = telaCadastroMedico.getTxtNome().getText();

		String cpfTxt = telaCadastroMedico.getTxtCpf().getText().replace(".", "").replace("-", "");

		String sexo = "";
		if (telaCadastroMedico.getRdbtnFeminino1().isSelected()) {
			sexo = "F";
		}
		if (telaCadastroMedico.getRdbtnMasculino1().isSelected()) {
			sexo = "M";
		}
		if (telaCadastroMedico.getRdbtnMasculino1() == null || telaCadastroMedico.getRdbtnFeminino1() == null) {
			sexo = null;
		}
		String email = telaCadastroMedico.getTxtEmail().getText();

		String telefone = telaCadastroMedico.getTxtTelefone().getText().replace("-", "").replace("(", "").replace(")",
				"");

		String dataN = telaCadastroMedico.getTxtData().getText();

		String complemento = telaCadastroMedico.getTxtComplemento().getText();

		String numeroCasa = telaCadastroMedico.getTxtCasaNumero().getText();

		String usuarioLogin = telaCadastroMedico.getTxtUsuario().getText();

		String senha = telaCadastroMedico.getTxtSenha().getText();

		String crm = telaCadastroMedico.getTxtCrm().getText();

		String especializacao = telaCadastroMedico.getTxtEspecializacao().getText();

		// TODO nova validacao nome
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			telaCadastroMedico.getTxtNome().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Nome\n";
		} else {
			telaCadastroMedico.getTxtNome().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			medico.setNome(nome);
		}
		// cpf

		if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
			telaCadastroMedico.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "CPF\n";
		} else {
			telaCadastroMedico.getTxtCpf().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Long cpf = Long.valueOf(cpfTxt);
			Long cpfConsulta = Long.valueOf(cpfTxt);
			medico.setCpf(cpf);
		}
		// sexo

		if (sexo == null || sexo.isEmpty()) {
			telaCadastroMedico.getRdbtnFeminino1().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			telaCadastroMedico.getRdbtnMasculino1().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Sexo\n";
		} else {
			telaCadastroMedico.getRdbtnFeminino1().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			telaCadastroMedico.getRdbtnMasculino1().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			medico.setSexo(sexo);
		}
		// email
		if (email == null || email.trim() == "" || email.isEmpty()) {
			telaCadastroMedico.getTxtEmail().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Email\n";
		} else {
			telaCadastroMedico.getTxtEmail().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			medico.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
			telaCadastroMedico.getTxtTelefone().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Telefone\n";
		} else {
			telaCadastroMedico.getTxtTelefone().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			medico.setTelefone(telefone);

		}

		// data Nascimento
		if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
			validacao += "Data\n";
			telaCadastroMedico.getTxtData().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			String dataTest = dataN.replace("/", "").trim();
			if (dataTest.length() == 0) {
				validacao += "Data\n";
				telaCadastroMedico.getTxtData().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				telaCadastroMedico.getTxtData().setBorder(new LineBorder(new Color(00, 00, 00), 1));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dta = LocalDate.parse(dataN, formatter);
				dta.format(formatter);

				LocalDate dataAtual = LocalDate.now();

				if (dataAtual.isBefore(dta)) {
					validacao += "Informe uma data anterior";

				} else {
					medico.setDataNascimento(dta);
				}

			}

		}

		// Complemento
		medico.setComplemento(complemento);

		if (numeroCasa == null || numeroCasa.trim() == "" || numeroCasa.isEmpty()) {
			validacao += "Numero\n";
			telaCadastroMedico.getTxtCasaNumero().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			telaCadastroMedico.getTxtCasaNumero().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Integer nCasa = Integer.valueOf(numeroCasa);
			medico.setNumero(nCasa);
		}

		// CRM
		if (crm == null || crm.trim() == "" || crm.isEmpty()) {
			telaCadastroMedico.getTxtCrm().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Crm\n";
		} else {
			telaCadastroMedico.getTxtCrm().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Long crmLong = Long.valueOf(crm);
			medico.setCrm(crmLong);

		}
		if (especializacao == null || especializacao.trim() == "" || especializacao.isEmpty()) {

			telaCadastroMedico.getTxtEspecializacao().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Especializacao\n";
		} else {
			telaCadastroMedico.getTxtEspecializacao().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			medico.setEspecializacao(especializacao);

		}

		Usuario usuario = new Usuario();
		usuario = setarObjetoUsuario();
		Endereco endereco = new Endereco();
		endereco = setarObjetoEndereco();

		if (endereco != null && usuario != null) {
			if (validacao.trim() != "") {
				return null;
			} else {
				medico.setUsuario(usuario);
				medico.setEndereco(endereco);
				return medico;

			}
		}
		return null;

	}

	public Endereco setarObjetoEndereco() {

		StatusTela statusTela = null;
		Endereco endereco = new Endereco();
		enderecoDao = new EnderecoDao();
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco resultadoEndereco = new Endereco();
		String cepString = telaCadastroMedico.getTxtCep().getText().replace(".", "").replace("-", "");

		String cidade = telaCadastroMedico.getTxtMunicipio().getText();
		String bairro = telaCadastroMedico.getTxtBairro().getText();
		String rua = telaCadastroMedico.getTxtRua().getText();

		if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
			validacao += " Cep\n";
			telaCadastroMedico.getTxtCep().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			Integer cep = Integer.valueOf(cepString);
			endereco.setCep(cep);
		}

		if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
			validacao += " Bairro\n";
			telaCadastroMedico.getTxtBairro().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setBairro(bairro);
		}
		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			validacao += " Cidade\n";
			telaCadastroMedico.getTxtMunicipio().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setCidade(cidade);
		}
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			validacao += " Rua\n";
			telaCadastroMedico.getTxtRua().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setRua(rua);
		}

		int posicao = telaCadastroMedico.getCbxEstado().getSelectedIndex();
		Estado estado = new Estado();
		estado.setId(posicao + 1);
		endereco.setEstado(estado);

		if (validacao.trim() == "") {
			return endereco;
		}
		return null;

	}

	public Usuario setarObjetoUsuario() {
		String usuarioLogin = telaCadastroMedico.getTxtUsuario().getText();
		String senha = telaCadastroMedico.getTxtSenha().getText();

		Usuario usuario = new Usuario();

		if (usuarioLogin == null || usuarioLogin.trim() == "" || usuarioLogin.isEmpty()) {
			telaCadastroMedico.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Usuario\n";
		} else {
			telaCadastroMedico.getTxtUsuario().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			usuario.setUsuario(usuarioLogin);
		}
		if (senha == null || senha.trim() == "" || senha.isEmpty()) {
			telaCadastroMedico.getTxtSenha().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Senha\n";
		} else {
			telaCadastroMedico.getTxtSenha().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			usuario.setSenha(senha);
		}
		if (validacao.trim() == "") {
			usuario.setNivelAcesso(1);
			return usuario;
		}
		return null;

	}

	private void atualizarTabelaBusca(Medico medico) {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "CRM", "Email" });
		tabela.addRow(new Object[] { medico.getNome(), medico.getCpf(), medico.getCrm(), medico.getEmail() });
		table.setModel(tabela);
	}

	private void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "CRM", "Email" });

		listaMedico = medicoDao.listaMedicos();
		for (int i = 0; i < listaMedico.size(); i++) {
			Medico medico = listaMedico.get(i);
			tabela.addRow(new Object[] { medico.getNome(), medico.getCpf(), medico.getCrm(), medico.getEmail() });

		}
		table.setModel(tabela);
	}

	protected void preencherMedicoTabela(Medico medicoClick) {

		txtNome.setText(medicoClick.getNome());
		txtEmail.setText(medicoClick.getEmail());
		txtTelefone.setText(medicoClick.getTelefone());
		txtComplemento.setText(medicoClick.getComplemento());
		txtCasaNumero.setText(String.valueOf(medicoClick.getNumero()));
		txtCpf.setEditable(false);
		txtCpf.setText(String.valueOf(medicoClick.getCpf()));
		Date data = Date.valueOf(medicoClick.getDataNascimento());
		txtData.setText(formatDate.format(data));
		txtCrm.setText(String.valueOf(medicoClick.getCrm()));
		txtEspecializacao.setText(medicoClick.getEspecializacao());
		Long usuarioid = medicoClick.getUsuario().getId();
		usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.consultarUsuarioID(usuarioid);
		txtUsuario.setText(usuario.getUsuario());
		txtSenha.setText(usuario.getSenha());
		String sexo = medicoClick.getSexo();
		if (sexo.equals("F")) {
			rdbtnFeminino1.setSelected(true);
		} else if (sexo.equals("M")) {
			rdbtnMasculino1.setSelected(true);
		}

		Integer cep = medicoClick.getEndereco().getCep();
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = new Endereco(cep);
		Endereco enderecoDoBanco = enderecoDao.consultarEndereco(endereco);
		txtCep.setText(String.valueOf(enderecoDoBanco.getCep()));
		txtBairro.setText(enderecoDoBanco.getBairro());
		txtMunicipio.setText(enderecoDoBanco.getCidade());
		txtRua.setText(enderecoDoBanco.getRua());
		cbxEstado.setSelectedIndex(enderecoDoBanco.getEstado().getId() - 1);

	}

	private void EditarMedico(Medico medicoSelecionado) {
		preencherMedicoTabela(medicoSelecionado);

	}

	private void limpaBordaEndereco() {
		txtCep.setBorder(new LineBorder(new Color(00, 00, 00), 1));
		txtRua.setBorder(new LineBorder(new Color(00, 00, 00), 1));
		txtBairro.setBorder(new LineBorder(new Color(00, 00, 00), 1));
		txtMunicipio.setBorder(new LineBorder(new Color(00, 00, 00), 1));

	}

	private void limparTela() {
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtComplemento.setText("");
		txtCasaNumero.setText("");
		txtCpf.setText("");
		txtCpf.setEditable(true);
		txtData.setText("");
		txtCrm.setText("");
		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");
		txtEspecializacao.setText("");
		txtSenha.setText("");
		txtUsuario.setText("");
	}
}
