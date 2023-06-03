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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.EnderecoDao;
import controller.FuncionarioDao;
import controller.UsuarioDao;
import helper.ManterEndereco;
import helper.ManterFuncionarioHelper;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.StatusTela;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import utils.RoundButton;

/**
 * 
 * @author Eliezer da Silva
 * 
 *         Classe resposavel por exibir Tela de cadastro de paciente
 *
 */
public class TelaCadastroFuncionario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBuscarCpf;
	private JTextField txtBuscarNome;
	private JTextField txtUsuario;
	private JPasswordField jpfSenha;

	private String senha;
	private String validacao = "";
	private int tipoUsuario;

	private FuncionarioDao funcionarioDao;
	private EnderecoDao enderecoDao;
	private UsuarioDao usuarioDao;
	private TelaCadastroFuncionario telaCadastroFuncionario;

	private ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
	ArrayList<Estado> estados = new ArrayList<>();
	private JComboBox<Estado> cbxEstado;
	private JTable table_1 = new JTable();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	private DefaultTableModel modelTabela;

	private JRadioButton rdbtnAdministrador;

	private AbstractButton rdbtnFuncionario;

	private AbstractButton rdbtnMasculino;

	private JRadioButton rdbtnFeminino;

	private DefaultTableModel modelTabelaBusca;

	private AbstractButton btnExcluir;

	private SimpleDateFormat formatDate;
	private JButton btnEditar;
	private Funcionario funcionarioClick;
	private AbstractButton btnSalvar;
	private JButton voltar;
	int d = 0;
	private int menu = 0;
	private int sairPerfil = 0;

	private JPanel panelSairPerfil;

	private JButton btnSair;

	private JButton btnPerfil;
	private Date date;

	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario(Usuario usuario) {
		usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.tipoUsuario = usuario.getNivelAcesso();
		funcionarioDao = new FuncionarioDao();

		this.telaCadastroFuncionario = this;
		AtualizarTabela();

		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Tela cadastro de funcinário");

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
		panel.setBounds(437, 84, 1157, 887);
		panel.setBorder(new LineBorder(new Color(143, 188, 143), 4));
		panel.setBackground(new Color(143, 188, 143));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(143, 188, 143));
		// panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(143, 188, 143));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 15));

		JLabel lblNewLabel = new JLabel("Cadastro do funcionário");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 204));
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(
				new MigLayout("", "[1142.00:n:1134,grow]", "[][160:n:160,grow][100:n:100,grow][380:n:390,grow]"));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_3.setBackground(new Color(236, 253, 232));
		panel_4.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[80:n:80][300:n:300,grow][][300:n:300][][][150:n:150,grow]",
				"[30:n:30][10:n:10][30:n:30]"));

		JLabel lblNewLabel_1 = new JLabel("Nome : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_1, "cell 0 0,alignx right,growy");

		txtNome = new JTextField();
		panel_3.add(txtNome, "cell 1 0,grow");
		txtNome.setColumns(10);

		formatDate = new SimpleDateFormat("dd/MM/yyyy");
		JLabel lblNewLabel_4 = new JLabel("Data de nascimento:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_4, "flowx,cell 3 0,growx");

		JLabel lblNewLabel_6 = new JLabel("Telefone :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_6, "cell 5 0");

		JLabel lblNewLabel_2 = new JLabel("E-mail :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_2, "cell 0 2,alignx right");

		txtEmail = new JTextField();
		panel_3.add(txtEmail, "cell 1 2,grow");
		txtEmail.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("CPF:    ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_5, "flowx,cell 3 2,grow");

		JLabel lblNewLabel_8 = new JLabel("Sexo:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_8, "cell 5 2");

		rdbtnMasculino = new JRadioButton("M");
		buttonGroup.add(rdbtnMasculino);
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMasculino.setBackground(new Color(236, 253, 232));
		panel_3.add(rdbtnMasculino, "flowx,cell 6 2,grow");
		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data inválido");
			e.printStackTrace();
		}
		panel_3.add(txtData, "cell 3 0,alignx center,growy");
		txtData.setColumns(22);
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cpf inválido");
			e.printStackTrace();
		}
		panel_3.add(txtCpf, "cell 3 2,grow");
		txtCpf.setColumns(23);
		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Telefone inválido");
			e.printStackTrace();
		}
		panel_3.add(txtTelefone, "cell 6 0,alignx left,growy");
		txtTelefone.setColumns(10);

		rdbtnFeminino = new JRadioButton("F");
		buttonGroup.add(rdbtnFeminino);
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFeminino.setBackground(new Color(236, 253, 232));
		panel_3.add(rdbtnFeminino, "cell 6 2,grow");

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(236, 253, 232));
		panel_5.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("",
				"[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][170:n:170,grow]",
				"[30:n:30][10:n:10][30:n:30][10:n:10][30:n:30]"));

		JLabel lblNewLabel_9 = new JLabel("CEP:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_9, "cell 0 0,alignx trailing");

		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e5) {
			JOptionPane.showMessageDialog(null, "CEP inválido");
			e5.printStackTrace();
		}
		panel_5.add(txtCep, "cell 1 0 2 1,grow");
		txtCep.setColumns(10);

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

						telaCadastroFuncionario.getTxtCep().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroFuncionario.getTxtBairro().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroFuncionario.getTxtMunicipio().setBorder(new LineBorder(new Color(00, 00, 00), 1));
						telaCadastroFuncionario.getTxtRua().setBorder(new LineBorder(new Color(00, 00, 00), 1));
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
							if (consultaEndereco != null) {
								boolean retorno = enderecoDao.inserirEndereco(consultaEndereco);
								if (retorno == true) {
									JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!");
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
		panel_5.add(btnBuscarCep, "cell 3 0 2 1,grow");

		JButton btnEditarEnderço = new JButton();	
		btnEditarEnderço.setForeground(new Color(255, 255, 255));
		btnEditarEnderço.setBackground(new Color(149, 208, 157));
		btnEditarEnderço.setIcon(new ImageIcon("src\\main\\resources\\imagens\\editar.png"));
		btnEditarEnderço.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManterFuncionarioHelper cadastroFuncionarioHelper = new ManterFuncionarioHelper();
				StatusTela retornoStatusTela = null;
				Endereco retornoEndereco = setarObjetoEndereco();
				if (retornoEndereco != null) {
					ManterEndereco manterEndereco = new ManterEndereco();
					retornoStatusTela = manterEndereco.consultarEndereco(retornoEndereco);
				}
				if (StatusTela.ENDERECOALTERADO == retornoStatusTela) {
					JOptionPane.showMessageDialog(null, "Endereço alterado");
				} else {
					if (StatusTela.ENDERECOCADASTRADO == retornoStatusTela) {
						JOptionPane.showMessageDialog(null, "Endereço cadastrado");
					} else {
						if (StatusTela.ERROALTERARENDERECO == retornoStatusTela) {
							JOptionPane.showMessageDialog(null, "Erro ao alterar o endereço ");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar o endereço ");
						}

					}
				}
			}
		});
		btnEditarEnderço.setIcon(new ImageIcon("src\\main\\resources\\imagens\\editar.png"));
		panel_5.add(btnEditarEnderço, "cell 5 0,growy");

		JLabel lblNewLabel_10 = new JLabel("Estado:");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_10, "cell 0 2,alignx trailing");

		enderecoDao = new EnderecoDao();

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

		JLabel lblNewLabel_11 = new JLabel("Município:");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_11, "cell 2 2,alignx center");

		txtMunicipio = new JTextField();
		panel_5.add(txtMunicipio, "cell 3 2,grow");
		txtMunicipio.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Bairro: ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_12, "cell 4 2,alignx trailing,growy");

		txtBairro = new JTextField();
		panel_5.add(txtBairro, "cell 5 2,grow");
		txtBairro.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Rua: ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_13, "cell 6 2,alignx trailing");

		txtRua = new JTextField();
		panel_5.add(txtRua, "cell 7 2,grow");
		txtRua.setColumns(10);
		AtualizarTabela();
		JLabel lblNewLabel_14 = new JLabel("N°:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_14, "cell 0 4,alignx trailing");

		txtNumero = new JTextField();
		panel_5.add(txtNumero, "cell 1 4,grow");
		txtNumero.setColumns(10);
		/*
		 * try { txtNumero = new JFormattedTextField(new MaskFormatter("########")); }
		 * catch (ParseException e5) { JOptionPane.showMessageDialog(null,
		 * "Número residencial inválido"); e5.printStackTrace(); }
		 */
		JLabel lblNewLabel_15 = new JLabel("Complemento:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_15, "cell 2 4,alignx center");

		txtComplemento = new JTextField();
		panel_5.add(txtComplemento, "cell 3 4 2 1,grow");
		txtComplemento.setColumns(10);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(240, 255, 240));
		panel_9.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_9, "cell 0 2,grow");
		panel_9.setLayout(new MigLayout("", "[80:n:80][200:n:200,grow][110:n:110][200:n:200,grow][10:n:10][][][214.00:n:200]", "[30:n:30][30:n:30]"));

		JLabel lblNewLabel_23 = new JLabel("Login");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_9.add(lblNewLabel_23, "cell 0 0 8 1,alignx center");

		JLabel lblNewLabel_21 = new JLabel("Usuário: ");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(lblNewLabel_21, "cell 0 1,alignx trailing");

		txtUsuario = new JTextField();
		panel_9.add(txtUsuario, "cell 1 1,grow");
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Senha:");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(lblNewLabel_20, "cell 2 1,alignx trailing");

		jpfSenha = new JPasswordField();
		panel_9.add(jpfSenha, "cell 3 1,grow");

		rdbtnAdministrador = new JRadioButton("Administrador");
		buttonGroup_1.add(rdbtnAdministrador);
		rdbtnAdministrador.setBackground(new Color(236, 253, 232));
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(rdbtnAdministrador, "cell 5 1");

		rdbtnFuncionario = new JRadioButton("Funcionário");
		buttonGroup_1.add(rdbtnFuncionario);
		rdbtnFuncionario.setBackground(new Color(236, 253, 232));
		rdbtnFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(rdbtnFuncionario, "cell 6 1");

		JButton btnCadastrarFuncionario = new JButton("Cadastrar funcionário");
		btnCadastrarFuncionario.setForeground(new Color(255, 255, 255));
		btnCadastrarFuncionario.setBackground(new Color(149, 208, 157));
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManterFuncionarioHelper manterFuncionarioHelper = new ManterFuncionarioHelper();

				Funcionario funcionario = new Funcionario();
				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();

				validacao = "";

				funcionario = setarObjetoFuncionario();
				usuario = setarObjetoUsuario();
				endereco = setarObjetoEndereco();

				if (funcionario != null && usuario != null && endereco != null) {
					StatusTela retorno = manterFuncionarioHelper.cadastrarFuncionario(funcionario);
					if (StatusTela.USUARIOEXISTENTE == retorno) {
						JOptionPane.showMessageDialog(null, "Usuário existente, informe outro","ERRO", JOptionPane.ERROR_MESSAGE);
					} else {
						if (StatusTela.FUNCIONARIOCADASTRADO == retorno) {
							JOptionPane.showMessageDialog(null, "Funcionario cadastrado");
							AtualizarTabela();
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
		btnCadastrarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(btnCadastrarFuncionario, "cell 7 1,grow");

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(236, 253, 232));
		panel_6.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_4.add(panel_6, "cell 0 3,grow");
		panel_6.setLayout(
				new MigLayout("", "[80:n:80][200:n:200,grow][][100:n:100][200:n:200,grow][][220:n:220][230:n:230][]",
						"[30:n:30][30:n:30][][200:n:200,grow][5:n:5][30:n:30]"));

		JLabel lblNewLabel_22 = new JLabel("Consultar");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_6.add(lblNewLabel_22, "cell 0 0 8 1,alignx center");

		JLabel lblNewLabel_16 = new JLabel("CPF :\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6.add(lblNewLabel_16, "cell 0 1,alignx trailing");

		try {
			txtBuscarCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e6) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
			e6.printStackTrace();
		}
		panel_6.add(txtBuscarCpf, "cell 1 1,grow");
		txtBuscarCpf.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Nome :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6.add(lblNewLabel_17, "cell 3 1,alignx trailing");

		txtBuscarNome = new JTextField();
		panel_6.add(txtBuscarNome, "cell 4 1,grow");
		txtBuscarNome.setColumns(10);

		JButton btnBuscarFuncionario = new JButton("Buscar");
		btnBuscarFuncionario.setForeground(new Color(255, 255, 255));
		btnBuscarFuncionario.setBackground(new Color(149, 208, 157));
		btnBuscarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = txtBuscarCpf.getText().replace(".", "").replace("-", "");
				String nome = txtBuscarNome.getText();
				funcionarioDao = new FuncionarioDao();

				if ((cpf != null && nome != null) || (cpf != null && nome == null) || (cpf == null && nome != null)) {
					ArrayList<Funcionario> listfuncionario = new ArrayList<>();
					if (cpf.trim() == "") {
						cpf = "0";

					}
					if (nome.trim() == "") {
						nome = "0";

					}
					listfuncionario = funcionarioDao.consultaCPFNome(nome, Long.parseLong(cpf));
					listaTabelaBusca(listfuncionario);

				}

			}
		});
		btnBuscarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnBuscarFuncionario, "cell 6 1,grow");

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
		
		JButton btnLimpar = new JButton("   Limpar   ");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarTabela();
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLimpar.setBackground(new Color(149, 208, 157));
		panel_6.add(btnLimpar, "cell 7 1");
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(240, 255, 240));
		panel_7.setBorder(new LineBorder(new Color(143, 188, 143), 3));
		panel_6.add(panel_7, "cell 1 3 7 1,grow");
		panel_7.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 968, 178);
		panel_7.add(scrollPane);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "E-mail" }));
		scrollPane.setViewportView(table_1);

		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(149, 208, 157));
		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				funcionarioClick = new Funcionario();

				btnCadastrarFuncionario.setVisible(false);
				panel_9.remove(btnCadastrarFuncionario);

				btnEditar.setVisible(false);
				panel_6.remove(btnEditar);

				btnExcluir.setVisible(false);
				panel_6.remove(btnExcluir);

				voltar = new JButton("Cancelar");
				voltar.setForeground(new Color(255, 255, 255));
				voltar.setBackground(new Color(149, 208, 157));
				
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limparBorda();
						panel_9.add(btnCadastrarFuncionario);
						btnCadastrarFuncionario.setVisible(true);

						btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_6.add(btnEditar, "cell 1 5,growx");
						btnEditar.setVisible(true);

						btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_6.add(btnExcluir, "cell 3 5,grow");
						btnExcluir.setVisible(true);

						panel_6.remove(voltar);

						btnSalvar.setVisible(false);
						panel_9.remove(btnSalvar);

						limparTela();
					}
				});
				voltar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_6.add(voltar, "cell 1 5,growx");

				int position = table_1.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}

				funcionarioClick = listaFuncionario.get(position);
				
				preencherFuncionarioTabela(funcionarioClick);
				
				btnSalvar = new JButton("Salvar");
				btnSalvar.setForeground(new Color(255, 255, 255));
				btnSalvar.setBackground(new Color(149, 208, 157));
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						validacao = "";

						Funcionario funcionario = new Funcionario();
						var endereco = new Endereco();
						var usuario = new Usuario();
						funcionario = setarObjetoFuncionario();
						endereco = setarObjetoEndereco();
						usuario = setarObjetoUsuario();

						if (funcionario != null && usuario != null && endereco != null) {

							funcionario.setEndereco(endereco);
							funcionario.setUsuario(usuario);

							ManterFuncionarioHelper cadastroFuncionarioHelper = new ManterFuncionarioHelper();
							StatusTela retorno = cadastroFuncionarioHelper.editarFuncionario(funcionario);
							if (StatusTela.FUNCIONARIEDITADO == retorno) {
								JOptionPane.showMessageDialog(null, "Funcionario editado");
								AtualizarTabela();
								limparTela();

							} else {
								JOptionPane.showMessageDialog(null, "Erro ao editar");
							}

							panel_9.add(btnCadastrarFuncionario);
							btnCadastrarFuncionario.setVisible(true);

							btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
							panel_6.add(btnEditar, "cell 1 5,growx");
							btnEditar.setVisible(true);

							btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
							panel_6.add(btnExcluir, "cell 3 5,grow");
							btnExcluir.setVisible(true);
							limparBorda();
							voltar.setVisible(false);
							panel_6.remove(voltar);
							limparTela();

							btnSalvar.setVisible(false);
							panel_9.remove(btnSalvar);

						} else {
							JOptionPane.showMessageDialog(null, validacao, "Dados inválidos:",
									JOptionPane.ERROR_MESSAGE, null);
						}

					}

				});
				btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_9.add(btnSalvar, "cell 7 1,grow");

			
			

			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnEditar, "cell 1 5,grow");

		btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBackground(new Color(149, 208, 157));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int position = table_1.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				funcionarioClick = new Funcionario();
				funcionarioClick = listaFuncionario.get(position);

				ManterFuncionarioHelper cadastroFuncionarioHelper = new ManterFuncionarioHelper();

				int replaced = JOptionPane.showConfirmDialog(null,
						"Deseja excluit mesmo" + funcionarioClick.getNome() + " ? ");

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
				if (result.equals("Yes")) {
					boolean retorno = cadastroFuncionarioHelper.excluirFuncionario(funcionarioClick);
					
					if (retorno == true) {
						JOptionPane.showMessageDialog(null, "Excluido com sucesso");
						UsuarioDao usuarioDao = new UsuarioDao();
						usuarioDao.deletarUsuario(funcionarioClick.getUsuario());
						
						AtualizarTabela();
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possivel excluir:" + funcionarioClick.getNome(),
								"null", JOptionPane.ERROR_MESSAGE);
					}
				} else {

				}

			}

		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnExcluir, "cell 4 5,grow");

		JButton btnVoltar = new JButton("     Voltar       ");
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
		panel_6.add(btnVoltar, "cell 7 5,alignx trailing,growy");
		contentPane.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 0, 1929, 73);
		panel_8.setBackground(new Color(143, 188, 143));

		JLabel lblNewLabel_1_1 = new JLabel("Manter funcionário ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));

		JButton btnLoginSair = new JButton("");
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
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup().addGap(73)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)
						.addGap(888).addComponent(btnLoginSair)));
		gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup().addGap(7).addComponent(btnLoginSair,
						GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_8.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addContainerGap()));
		panel_8.setLayout(gl_panel_8);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(panel_1,
				GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addContainerGap().addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(panelSairPerfil);
		contentPane.add(panel_8);
		contentPane.add(panel);

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
		AtualizarTabela();

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

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public JTextField getTxtComplemento() {
		return txtComplemento;
	}

	public JTextField getTxtBuscarCpf() {
		return txtBuscarCpf;
	}

	public JTextField getTxtBuscarNome() {
		return txtBuscarNome;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JPasswordField getJpfSenha() {
		return jpfSenha;
	}

	public String getSenha() {
		return senha;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public JRadioButton getRdbtnAdministrador() {
		return rdbtnAdministrador;
	}

	public AbstractButton getRdbtnFuncionario() {
		return rdbtnFuncionario;
	}

	public AbstractButton getRdbtnMasculino() {
		return rdbtnMasculino;
	}

	public JRadioButton getRdbtnFeminino() {
		return rdbtnFeminino;
	}

	public JComboBox<Estado> getCbxEstado() {
		return cbxEstado;
	}

	public void setTxtCep(JTextField txtCep) {
		this.txtCep = txtCep;
	}

	public void listaTabelaBusca(ArrayList<Funcionario> listFuncionarios) {

		modelTabelaBusca = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "E-mail" });

		for (int i = 0; i < listFuncionarios.size(); i++) {
			Funcionario funcionario = listFuncionarios.get(i);
			modelTabelaBusca
					.addRow(new Object[] { funcionario.getNome(), funcionario.getCpf(), funcionario.getEmail() });

		}
		table_1.setModel(modelTabelaBusca);
	}

	public void AtualizarTabela() {

		modelTabela = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "E-mail" });

		funcionarioDao = new FuncionarioDao();
		listaFuncionario = funcionarioDao.consultarTodosFuncionario();
		for (int i = 0; i < listaFuncionario.size(); i++) {
			Funcionario funcionario = listaFuncionario.get(i);
			modelTabela.addRow(new Object[] { funcionario.getNome(), funcionario.getCpf(), funcionario.getEmail() });

		}
		table_1.setModel(modelTabela);
	}

	public void limparTela() {
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtComplemento.setText("");
		txtData.setText("");

		txtCpf.setText("");
		txtCpf.setEditable(true);
		txtData.setText("");

		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");

		txtUsuario.setText("");
		jpfSenha.setText("");
	}

	private void limparEndereco() {
		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");
	}

	protected void preencherFuncionarioTabela(Funcionario funcionarioClick) {

		Date data = Date.valueOf(funcionarioClick.getDataNascimento());
		txtData.setText(formatDate.format(data));

		txtNome.setText(funcionarioClick.getNome());
		txtEmail.setText(funcionarioClick.getEmail());
		txtTelefone.setText(funcionarioClick.getTelefone());
		txtComplemento.setText(funcionarioClick.getComplemento());
		txtNumero.setText(String.valueOf(funcionarioClick.getNumero()));
		txtCpf.setEditable(false);
		txtCpf.setText(String.valueOf(funcionarioClick.getCpf()));
	
		
		
		Long usuarioid = funcionarioClick.getUsuario().getId();
		usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.consultarUsuarioID(usuarioid);
		txtUsuario.setText(usuario.getUsuario());
		jpfSenha.setText(usuario.getSenha());
		String sexo = funcionarioClick.getSexo();
		if (sexo.equals("F")) {
			rdbtnFeminino.setSelected(true);
		} else if (sexo.equals("M")) {
			rdbtnMasculino.setSelected(true);
		}

		Integer cep = funcionarioClick.getEndereco().getCep();
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = new Endereco(cep);
		Endereco enderecoDoBanco = enderecoDao.consultarEndereco(endereco);
		txtCep.setText(String.valueOf(enderecoDoBanco.getCep()));
		txtBairro.setText(enderecoDoBanco.getBairro());
		txtMunicipio.setText(enderecoDoBanco.getCidade());
		txtRua.setText(enderecoDoBanco.getRua());
		cbxEstado.setSelectedIndex(enderecoDoBanco.getEstado().getId() - 1);
		long nivelAcesso = usuario.getId();
		if (nivelAcesso == 0) {
			rdbtnAdministrador.setSelected(true);
		} else {
			rdbtnFuncionario.setSelected(true);
		}
	}

	private void limparBorda() {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		txtNome.setBorder(blackline);
		txtEmail.setBorder(blackline);
		txtTelefone.setBorder(blackline);
		txtComplemento.setBorder(blackline);
		txtNumero.setBorder(blackline);
		txtCpf.setBorder(blackline);
		txtData.setBorder(blackline);

		txtUsuario.setBorder(blackline);
		jpfSenha.setBorder(blackline);

		txtCep.setBorder(blackline);
		txtRua.setBorder(blackline);
		txtBairro.setBorder(blackline);
		txtMunicipio.setBorder(blackline);
	}

	private void limpaBordaEndereco() {
		txtCep.setBorder(new LineBorder(new Color(00, 00, 00), 1));
		txtRua.setBorder(new LineBorder(new Color(00, 00, 00), 1));
		txtBairro.setBorder(new LineBorder(new Color(00, 00, 00), 1));
		txtMunicipio.setBorder(new LineBorder(new Color(00, 00, 00), 1));

	}

	public Funcionario setarObjetoFuncionario() {


		Funcionario funcionario = new Funcionario();

		String nome = telaCadastroFuncionario.getTxtNome().getText();

		String cpfTxt = telaCadastroFuncionario.getTxtCpf().getText().replace(".", "").replace("-", "");

		String sexo = "";
		if (telaCadastroFuncionario.getRdbtnFeminino().isSelected()) {
			sexo = "F";
		}
		if (telaCadastroFuncionario.getRdbtnMasculino().isSelected()) {
			sexo = "M";
		}
		if (telaCadastroFuncionario.getRdbtnMasculino() == null || telaCadastroFuncionario.getRdbtnFeminino() == null) {
			sexo = null;
		}
		String email = telaCadastroFuncionario.getTxtEmail().getText();

		String telefone = telaCadastroFuncionario.getTxtTelefone().getText().replace("-", "").replace("(", "")
				.replace(")", "");

		String dataN = telaCadastroFuncionario.getTxtData().getText();

		String complemento = telaCadastroFuncionario.getTxtComplemento().getText();

		String numeroCasa = telaCadastroFuncionario.getTxtNumero().getText();

		// nova validacao nome
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			telaCadastroFuncionario.getTxtNome().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Nome\n";
		} else {
			telaCadastroFuncionario.getTxtNome().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			funcionario.setNome(nome);
		}
		// cpf

		if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
			telaCadastroFuncionario.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "CPF\n";
		} else {
			telaCadastroFuncionario.getTxtCpf().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Long cpf = Long.valueOf(cpfTxt);
			funcionario.setCpf(cpf);
		}
		// sexo

		if (sexo == null || sexo.isEmpty()) {
			telaCadastroFuncionario.getRdbtnFeminino().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			telaCadastroFuncionario.getRdbtnMasculino().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Sexo\n";
		} else {
			telaCadastroFuncionario.getRdbtnFeminino().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			telaCadastroFuncionario.getRdbtnMasculino().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			funcionario.setSexo(sexo);
		}
		// email
		if (email == null || email.trim() == "" || email.isEmpty()) {
			telaCadastroFuncionario.getTxtEmail().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Email\n";
		} else {
			telaCadastroFuncionario.getTxtEmail().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			funcionario.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
			telaCadastroFuncionario.getTxtTelefone().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Telefone\n";
		} else {
			telaCadastroFuncionario.getTxtTelefone().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			funcionario.setTelefone(telefone);

		}

		// data Nascimento
		if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
			validacao += "Data\n";
			telaCadastroFuncionario.getTxtData().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			String dataTest = dataN.replace("/", "").trim();
			if (dataTest.length() == 0) {
				validacao += "Data\n";
				telaCadastroFuncionario.getTxtData().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				telaCadastroFuncionario.getTxtData().setBorder(new LineBorder(new Color(00, 00, 00), 1));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dta = LocalDate.parse(dataN, formatter);
				dta.format(formatter);

				LocalDate dataAtual = LocalDate.now();

				if (dataAtual.isBefore(dta)) {
					validacao += "Informe uma data anterior";

				} else {
					funcionario.setDataNascimento(dta);
				}

			}

		}

		// Complemento
		funcionario.setComplemento(complemento);

		if (numeroCasa == null || numeroCasa.trim() == "" || numeroCasa.isEmpty()) {
			validacao += "Numero\n";
			telaCadastroFuncionario.getTxtNumero().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			telaCadastroFuncionario.getTxtNumero().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Integer nCasa = Integer.valueOf(numeroCasa);
			funcionario.setNumero(nCasa);
		}

		Usuario usuario = new Usuario();
		usuario = setarObjetoUsuario();
		Endereco endereco = new Endereco();
		endereco = setarObjetoEndereco();

		if (endereco != null && usuario != null) {
			if (validacao.trim() != "") {
				return null;
			} else {
				funcionario.setUsuario(usuario);
				funcionario.setEndereco(endereco);
				return funcionario;

			}
		}
		return null;
	}

	public Endereco setarObjetoEndereco() {

		Endereco endereco = new Endereco();
		enderecoDao = new EnderecoDao();
		new EnderecoDao();
		String cepString = telaCadastroFuncionario.getTxtCep().getText().replace(".", "").replace("-", "");

		String cidade = telaCadastroFuncionario.getTxtMunicipio().getText();
		String bairro = telaCadastroFuncionario.getTxtBairro().getText();
		String rua = telaCadastroFuncionario.getTxtRua().getText();

		if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
			validacao += " Cep\n";
			telaCadastroFuncionario.getTxtCep().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			telaCadastroFuncionario.getTxtCep().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Integer cep = Integer.valueOf(cepString);
			endereco.setCep(cep);
		}

		if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
			validacao += " Bairro\n";
			telaCadastroFuncionario.getTxtBairro().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			telaCadastroFuncionario.getTxtBairro().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			endereco.setBairro(bairro);
		}
		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			validacao += " Cidade\n";
			telaCadastroFuncionario.getTxtMunicipio().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			telaCadastroFuncionario.getTxtBairro().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			endereco.setCidade(cidade);
		}
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			validacao += " Rua\n";
			telaCadastroFuncionario.getTxtRua().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			telaCadastroFuncionario.getTxtBairro().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			endereco.setRua(rua);
		}

		int posicao = telaCadastroFuncionario.getCbxEstado().getSelectedIndex();
		Estado estado = new Estado();
		estado.setId(posicao + 1);
		endereco.setEstado(estado);

		if (validacao.trim() == "") {
			return endereco;
		} else {
			return null;
		}

	}

	public Usuario setarObjetoUsuario() {
		String usuarioLogin = telaCadastroFuncionario.getTxtUsuario().getText();
		String senha = telaCadastroFuncionario.getJpfSenha().getText();

		Usuario usuario = new Usuario();

		if (usuarioLogin == null || usuarioLogin.trim() == "" || usuarioLogin.isEmpty()) {
			telaCadastroFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Usuario\n";
		} else {
			telaCadastroFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			usuario.setUsuario(usuarioLogin);
		}
		if (senha == null || senha.trim() == "" || senha.isEmpty()) {
			telaCadastroFuncionario.getJpfSenha().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Senha\n";
		} else {
			telaCadastroFuncionario.getJpfSenha().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			usuario.setSenha(senha);
		}
		if (validacao.trim() == "") {
			usuario.setNivelAcesso(1);
			return usuario;
		}
		return null;

	}

}
