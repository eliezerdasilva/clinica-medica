package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.EnderecoDao;
import controller.FuncionarioDao;
import controller.UsuarioDao;
import helper.ManterFuncionarioHelper;
import helper.ManterEndereco;
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

	private String usuario;
	/*
	 * public TelaCadastroFuncionario() throws HeadlessException {
	 * 
	 * }
	 */

	private String senha;
	private int tipoUsuario;

	private Endereco cadastroEndereco;
	private Usuario usuarioModel;
	private Funcionario funcionario;
	private FuncionarioDao funcionarioDao;
	private EnderecoDao enderecoDao;
	private UsuarioDao usuarioDao;
	private TelaCadastroFuncionario telaCadastroFuncionario;

	private ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
	private ArrayList<Funcionario> listaEndereco = new ArrayList<>();
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

	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario(Usuario usuario) {
		this.usuario = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.tipoUsuario = usuario.getNivelAcesso();
		funcionarioDao = new FuncionarioDao();

		this.telaCadastroFuncionario = this;
		listaTabela();

		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Cadastro do funcinário");

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
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);

		BufferedImage bg = null;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(236, 253, 232));
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 0));
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
				new MigLayout("", "[978.00:n:1280,grow]", "[][160:n:160,grow][100:n:100,grow][380:n:380,grow]"));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(51, 153, 0), 4));
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
		panel_5.setBorder(new LineBorder(new Color(51, 153, 0), 5));
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
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Cidade
				String cepString = txtCep.getText().replace("-", "");

				Integer cep = Integer.parseInt(cepString);

				// TODO instância para os get e setrs do endereco
				Endereco consultaEndereco = new Endereco(cep);

				// TODO instâcia para cadastrar um endereco novo

				// TODO instância para consultar cep cadastrado

				// TODO instância para ver o resultado da busca de cep
				Endereco resultado = new Endereco();
				// TODO metodo de consulta

				resultado = enderecoDao.consultarEndereco(consultaEndereco);

				// TODO Setar resultado do banco, se acasso o cep existir
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

				} else {
					int replaced = JOptionPane.showConfirmDialog(null, "Endereço não Cadastrado, deseja cadastrar ?");

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
						StatusTela retorno = cadastroFuncionarioHelper.cadastrarEndereco(telaCadastroFuncionario);

						if (retorno.ENDERECOCADASTRADO == retorno) {
							JOptionPane.showMessageDialog(null, "Endereço cadastrado ");
							limpaBordaEndereco();

						} else {
							if (retorno == retorno.NAOEXIBIRMENSSAGEM) {

							} else {
								JOptionPane.showMessageDialog(null, "Erro ao  cadastrar endereço ");
							}

						}
					} else {
						limpaBordaEndereco();
						txtCep.setText("");
					}

				}
			}
		});
		btnBuscarCep.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnBuscarCep, "cell 3 0 2 1,grow");

		RoundButton btnEditarEnderço = new RoundButton(50);
		btnEditarEnderço.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManterFuncionarioHelper cadastroFuncionarioHelper = new ManterFuncionarioHelper();
				StatusTela retornoStatusTela = null;
				Endereco retornoEndereco = cadastroFuncionarioHelper.setarObjetoEndereco(telaCadastroFuncionario);
				if (retornoEndereco != null) {
					ManterEndereco manterEndereco = new ManterEndereco();
					 retornoStatusTela = manterEndereco.consultarEndereco(retornoEndereco);					
				}
				if(StatusTela.ENDERECOALTERADO == retornoStatusTela) {
					JOptionPane.showMessageDialog(null, "Endereço alterado");
				}else {
					if(StatusTela.ENDERECOCADASTRADO == retornoStatusTela) {
						JOptionPane.showMessageDialog(null, "Endereço cadastrado");
					}else {
						if(StatusTela.ERROALTERARENDERECO == retornoStatusTela) {
							JOptionPane.showMessageDialog(null, "Erro ao alterar o endereço ");
						}else {
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
		listaTabela();
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
		panel_9.setBorder(new LineBorder(new Color(51, 153, 0), 4));
		panel_4.add(panel_9, "cell 0 2,grow");
		panel_9.setLayout(new MigLayout("",
				"[80:n:80][200:n:200,grow][110:n:110][200:n:200,grow][10:n:10][][][150:n:150]", "[30:n:30][30:n:30]"));

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
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManterFuncionarioHelper cadastroFuncionarioHelper = new ManterFuncionarioHelper();
				StatusTela retorno = cadastroFuncionarioHelper.cadastrarFuncionario(telaCadastroFuncionario);

				if (retorno == retorno.ERROCADASTROFUNCIONARIO) {
					JOptionPane.showMessageDialog(null, "Erro no cadastro, tente novamete");
				} else {
					if (retorno == retorno.FUNCIONARIOJACADASTRADO) {
						JOptionPane.showMessageDialog(null, "Funcionario já cadastrado");
					} else {
						limparTela();
						JOptionPane.showInternalMessageDialog(null, "cadastrado");

						listaTabela();
					}
				}
			}
		});
		btnCadastrarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(btnCadastrarFuncionario, "cell 7 1,grow");

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(236, 253, 232));
		panel_6.setBorder(new LineBorder(new Color(51, 153, 0), 4));
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
					listaTabelaBuca(listfuncionario);

				}

			}
		});
		btnBuscarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnBuscarFuncionario, "cell 6 1,grow");

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(240, 255, 240));
		panel_7.setBorder(new LineBorder(new Color(51, 153, 0), 4));
		panel_6.add(panel_7, "cell 1 3 7 1,grow");
		panel_7.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 10, 971, 178);
		panel_7.add(scrollPane);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "E-mail" }));
		scrollPane.setViewportView(table_1);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				funcionarioClick = new Funcionario();

				btnCadastrarFuncionario.setVisible(false);
				panel_9.remove(btnCadastrarFuncionario);

				btnEditar.setVisible(false);
				panel_6.remove(btnEditar);

				btnExcluir.setVisible(false);
				panel_6.remove(btnExcluir);

				JButton voltar = new JButton("Volta");
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpaBorda();
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

				btnSalvar = new JButton("Salvar");
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManterFuncionarioHelper cadastroFuncionarioHelper = new ManterFuncionarioHelper();

						StatusTela retorno = cadastroFuncionarioHelper.editarFuncionario(telaCadastroFuncionario);
						if (retorno.FUNCIONARIEDITADO == retorno) {
							JOptionPane.showMessageDialog(null, "Funcionario editado");
							listaTabela();
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao editar");
						}

					}

				});
				btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_9.add(btnSalvar, "cell 5 1,grow");

				funcionarioClick = listaFuncionario.get(position);
				preencherFuncionarioTabela(funcionarioClick);

			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnEditar, "cell 1 5,grow");

		btnExcluir = new JButton("Excluir");
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
						listaTabela();
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(395)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1157, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(362, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane
						.createSequentialGroup().addGap(25).addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(101, Short.MAX_VALUE)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(panel_1,
				GroupLayout.PREFERRED_SIZE, 1157, GroupLayout.PREFERRED_SIZE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(11).addComponent(panel_1, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

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
		listaTabela();

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

	public void listaTabelaBuca(ArrayList<Funcionario> listFuncionarios) {

		modelTabelaBusca = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "E-mail" });

		for (int i = 0; i < listFuncionarios.size(); i++) {
			Funcionario funcionario = listFuncionarios.get(i);
			modelTabelaBusca
					.addRow(new Object[] { funcionario.getNome(), funcionario.getCpf(), funcionario.getEmail() });

		}
		table_1.setModel(modelTabelaBusca);
	}

	public void listaTabela() {

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

		txtCpf.setText("");
		txtCpf.setEditable(true);
		txtData.setText("");

		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");

		txtUsuario.setText("");
	}

	private void limparEndereco() {

		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");
	}

	protected void preencherFuncionarioTabela(Funcionario funcionarioClick) {

		txtNome.setText(funcionarioClick.getNome());
		txtEmail.setText(funcionarioClick.getEmail());
		txtTelefone.setText(funcionarioClick.getTelefone());
		txtComplemento.setText(funcionarioClick.getComplemento());
		txtNumero.setText(String.valueOf(funcionarioClick.getNumero()));
		txtCpf.setEditable(false);
		txtCpf.setText(String.valueOf(funcionarioClick.getCpf()));
		Date data = Date.valueOf(funcionarioClick.getDataNascimento());
		txtData.setText(formatDate.format(data));
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

	private void limpaBorda() {

		txtNome.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtEmail.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtTelefone.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtComplemento.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtNumero.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtCpf.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtData.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtUsuario.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		jpfSenha.setBorder(new LineBorder(new Color(255, 255, 255), 4));

	}

	private void limpaBordaEndereco() {
		txtRua.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtBairro.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtMunicipio.setBorder(new LineBorder(new Color(255, 255, 255), 4));

	}

}
