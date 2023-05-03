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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
import javax.swing.text.MaskFormatter;

import controller.EnderecoDao;
import controller.FuncionarioDao;
import controller.UsuarioDao;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Paciente;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import utils.RoundButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

/**
 * 
 * @author Eliezer da Silva
 * 
 *         Classe resposavel por exibir Tela de cadastro de paciente
 *
 */
public class TelaCadastroFuncionario extends JFrame {
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
	private JTable table;
	private String usuario;
	private String senha;

	private Endereco cadastroEndereco;
	private Usuario usuarioModel;
	private Funcionario funcionario;
	private FuncionarioDao funcionarioDao;
	private EnderecoDao enderecoDao;
	private UsuarioDao usuarioDao;

	private ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
	private ArrayList<Funcionario> listaEndereco = new ArrayList<>();
	ArrayList<Estado> estados = new ArrayList<>();
	private JComboBox<Estado> cbxEstado;
	private JTable table_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Cadastro do funcinário");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/logo.png");
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
		GroupLayout gl_contentPane2 = new GroupLayout(contentPane);
		gl_contentPane2.setHorizontalGroup(gl_contentPane2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane2.createSequentialGroup().addContainerGap().addComponent(panel,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane2.setVerticalGroup(gl_contentPane2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane2.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(21)));
		panel.setLayout(new MigLayout("", "[1286.00,grow]", "[910:n:910,grow]"));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(236, 253, 232));
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 25));

		JLabel lblNewLabel = new JLabel("Cadastro do funcionário");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 204));
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[1280:n:1280,grow]",
				"[150:n:150px,grow][160:n:160,grow][100:n:100,grow][350:n:350,grow]"));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(51, 153, 0), 4));
		panel_3.setBackground(new Color(236, 253, 232));
		panel_4.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[][300:n:300,grow][][300:n:300][][][150:n:150,grow]", "[][30:n:30][][30:n:30][]"));

		JLabel lblNewLabel_1 = new JLabel("Nome : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_1, "cell 0 1,alignx center,growy");

		txtNome = new JTextField();
		panel_3.add(txtNome, "cell 1 1,grow");
		txtNome.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Data de nascimento:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_4, "flowx,cell 3 1,growx");
		
				JLabel lblNewLabel_6 = new JLabel("Telefone :");
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
				panel_3.add(lblNewLabel_6, "cell 5 1");
		

		JLabel lblNewLabel_2 = new JLabel("E-mail :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_2, "cell 0 3,alignx center");

		txtEmail = new JTextField();
		panel_3.add(txtEmail, "cell 1 3,grow");
		txtEmail.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("CPF:    ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_5, "flowx,cell 3 3,grow");

		JLabel lblNewLabel_8 = new JLabel("Sexo:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_8, "cell 5 3");

		JRadioButton rdbtnMasculino = new JRadioButton("M");
		buttonGroup.add(rdbtnMasculino);
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMasculino.setBackground(new Color(236, 253, 232));
		panel_3.add(rdbtnMasculino, "flowx,cell 6 3,grow");

		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "Data inválida");
			e2.printStackTrace();
		}
		panel_3.add(txtData, "cell 3 1,alignx center,growy");
		txtData.setColumns(22);

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e3) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
			e3.printStackTrace();
		}
		panel_3.add(txtCpf, "cell 3 3,grow");
		txtCpf.setColumns(23);

		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
					
		} catch (ParseException e4) {
			JOptionPane.showMessageDialog(null, "Telefone inválido");
			e4.printStackTrace();
		}
		panel_3.add(txtTelefone, "cell 6 1,alignx left,growy");
		txtTelefone.setColumns(10);	

		JRadioButton rdbtnFeminino = new JRadioButton("F");
		buttonGroup.add(rdbtnFeminino);
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFeminino.setBackground(new Color(236, 253, 232));
		panel_3.add(rdbtnFeminino, "cell 6 3,grow");

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(236, 253, 232));
		panel_5.setBorder(new LineBorder(new Color(51, 153, 0), 5));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("",
				"[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][200:n:200px,grow][100:n:100]",
				"[5:n:5][][5:n:5][30:n:30][5:n:5][30:n:30][5:n:5]"));

		JLabel lblNewLabel_9 = new JLabel("CEP:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_9, "cell 0 1,alignx trailing");

		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e5) {
			JOptionPane.showMessageDialog(null, "CEP inválido");
			e5.printStackTrace();
		}
		panel_5.add(txtCep, "cell 1 1 2 1,grow");
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

				resultado = enderecoDao.ConsultarEndereco(consultaEndereco);

				// TODO Setar resultado do banco, se acasso o cep existir
				if (resultado != null) {

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

					txtMunicipio.setText(enderecoPronto.getCidade());
					txtBairro.setText(enderecoPronto.getBairro());
					txtRua.setText(enderecoPronto.getRua());

					cbxEstado.setSelectedIndex(enderecoPronto.getEstado().getId() - 1);
				

				} else {
					JOptionPane.showMessageDialog(null, "Cep não cadastrado");

				}

			}
		});
		btnBuscarCep.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnBuscarCep, "cell 3 1 2 1,grow");

		JLabel lblNewLabel_10 = new JLabel("Estado:");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_10, "cell 0 3,alignx trailing");

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
		panel_5.add(cbxEstado, "cell 1 3,grow");

		JLabel lblNewLabel_11 = new JLabel("Município:");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_11, "cell 2 3,alignx center");

		txtMunicipio = new JTextField();
		panel_5.add(txtMunicipio, "cell 3 3,grow");
		txtMunicipio.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Bairro: ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_12, "cell 4 3,alignx trailing,growy");

		txtBairro = new JTextField();
		panel_5.add(txtBairro, "cell 5 3,grow");
		txtBairro.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Rua: ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_13, "cell 6 3,alignx trailing");

		txtRua = new JTextField();
		panel_5.add(txtRua, "cell 7 3,grow");
		txtRua.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("N°:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_14, "cell 0 5,alignx trailing");

		txtNumero = new JTextField();
		panel_5.add(txtNumero, "cell 1 5,grow");
		txtNumero.setColumns(10);
		/*
		 * try { txtNumero = new JFormattedTextField(new MaskFormatter("########")); }
		 * catch (ParseException e5) { JOptionPane.showMessageDialog(null,
		 * "Número residencial inválido"); e5.printStackTrace(); }
		 */
		JLabel lblNewLabel_15 = new JLabel("Complemento:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_15, "cell 2 5,alignx center");

		txtComplemento = new JTextField();
		panel_5.add(txtComplemento, "cell 3 5 2 1,grow");
		txtComplemento.setColumns(10);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(240, 255, 240));
		panel_9.setBorder(new LineBorder(new Color(51, 153, 0), 4));
		panel_4.add(panel_9, "cell 0 2,grow");
		panel_9.setLayout(new MigLayout("",
				"[80:n:80][200:n:200,grow][130:n:130][200:n:200,grow][20:n:20][][][][220:n:220][70:n:70]",
				"[30:n:30][30:n:30]"));

		JLabel lblNewLabel_23 = new JLabel("Login");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_9.add(lblNewLabel_23, "cell 0 0 10 1,alignx center");

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

		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		buttonGroup_1.add(rdbtnAdministrador);
		rdbtnAdministrador.setBackground(new Color(236, 253, 232));
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(rdbtnAdministrador, "cell 5 1");

		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionário");
		buttonGroup_1.add(rdbtnFuncionario);
		rdbtnFuncionario.setBackground(new Color(236, 253, 232));
		rdbtnFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(rdbtnFuncionario, "cell 6 1");

		JButton btnCadastrarUsuario = new JButton("Cadastrar funcionário");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// A instanciação dos objetos ultilizados para cadastrar
				if (cadastroEndereco == null) {
					cadastroEndereco = new Endereco();
				}
				if (funcionario == null) {
					funcionario = new Funcionario();
				}
				if (usuarioModel == null) {
					usuarioModel = new Usuario();
				}
				if (enderecoDao == null) {
					enderecoDao = new EnderecoDao();
				}
				if (funcionarioDao == null) {
					funcionarioDao = new FuncionarioDao();
				}
				if (usuarioDao == null) {
					usuarioDao = new UsuarioDao();
				}

				String nome = txtNome.getText();

				String validacao = "";
				String cpfTxt = txtCpf.getText().replace(".", "").replace("-", "");

				String sexo = "";
				if (rdbtnMasculino.isSelected()) {

					sexo = "M";
				}
				if (rdbtnFeminino.isSelected()) {
					sexo = "F";
				}
				if (rdbtnFeminino == null || rdbtnMasculino == null) {
					sexo = null;
				}
				String email = txtEmail.getText();

				String telefone = txtTelefone.getText().replace("-", "").replace("(", "").replace(")", "");

				String dataN = txtData.getText();

				String complemento = txtComplemento.getText();

				String numeroCasa = txtNumero.getText();

				String usuario = txtUsuario.getText();

				String senha = jpfSenha.getText();

				int tipoUsuario = 0;

				if (rdbtnAdministrador.isSelected()) {
					tipoUsuario = 0;
				}
				if (rdbtnFuncionario.isSelected()) {
					tipoUsuario = 2;
				}

				// criação do usuário

				if (tipoUsuario == 0) {

					if (usuario == null || usuario.trim() == "" || usuario.isEmpty()) {
						validacao += "Usuário\n";
						txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						usuarioModel.setUsuario(usuario);
					}
					if (senha == null || senha.trim() == "" || senha.isEmpty()) {
						validacao += "Usuário\n";
						txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						usuarioModel.setSenha(senha);
					}
					usuarioModel.setNivelAcesso(tipoUsuario);
					Boolean resultadoUsuario = usuarioDao.consultarUsuarioExistente(usuario);
					if (resultadoUsuario != true) {
						Boolean resposta = usuarioDao.inserirUsuario(usuarioModel);
						if (resposta == true) {
							JOptionPane.showMessageDialog(null, "Administrador Cadastrado ");
						} else {
							JOptionPane.showMessageDialog(null, "Erro, Administrador não Cadastrado ");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Informe outro Usuário para login.");
						txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					}

				} else {
					// TODO Construindo Objeto

					// TODO nova validacao nome
					if (nome == null || nome.trim() == "" || nome.isEmpty()) {
						txtNome.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						JOptionPane.showMessageDialog(null, "Nome vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
						return;
					} else {
						funcionario.setNome(nome);
					}
					// cpf

					if (cpfTxt != null || cpfTxt.trim() != "") {
						Long cpf = Long.valueOf(cpfTxt);
						boolean resultado = funcionarioDao.consultaCpf(cpf);
						
						if (resultado == false) {
							
							//Cadastro do Usuário 
							funcionario.setCpf(cpf);
							
							if (usuario == null || usuario.trim() == "" || usuario.isEmpty()) {
								validacao += "Usuário\n";
								txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							} else {
								usuarioModel.setUsuario(usuario);
							}
							if (senha == null || senha.trim() == "" || senha.isEmpty()) {
								validacao += "Usuário\n";
								txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							} else {
								usuarioModel.setSenha(senha);
							}
							usuarioModel.setNivelAcesso(tipoUsuario);
							Boolean resultadoUsuario = usuarioDao.consultarUsuarioExistente(usuario);
							if (resultadoUsuario != true) {
								Boolean retorno = usuarioDao.inserirUsuario(usuarioModel);
								if (retorno != false) {
									Usuario usuarioSelecionado = usuarioDao.selecionarUSuarioParaCadastrar(usuarioModel);
									funcionario.setUsuario(usuarioSelecionado);
								} else {
									JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Usuário");
									return;
								}

							} else {
								JOptionPane.showMessageDialog(null, "Informe outro Usuário para login.");
								txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
								return;
							}
							
						} else {
							txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							JOptionPane.showMessageDialog(null, "Funcionario já cadastrado");
							return;
						}
					} else {

						// ERRO
						txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						JOptionPane.showMessageDialog(null, "CPF vazio", "ok", JOptionPane.ERROR_MESSAGE);
						return;

					}
					// sexo

					if (sexo == null || sexo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Sexo vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
						rdbtnFeminino.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						rdbtnMasculino.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						return;
					} else {
						funcionario.setSexo(sexo);
					}
					// email
					if (email == null || email.trim() == "" || email.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Sexo vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
						txtEmail.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						return;
					} else {
						funcionario.setEmail(email);
					}
					// telefone
					if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Telefone vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
						txtTelefone.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						return;
					} else {
						funcionario.setTelefone(telefone);
					}
					// data nascimento
					if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
						validacao += "Data\n";
						txtData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						String dataTest = dataN.replace("/", "").trim();
						if (dataTest.length() == 0) {
							validacao += "Data\n";
							txtData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						} else {
							txtData.setBorder(new LineBorder(new Color(00, 00, 00), 1));
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate data = LocalDate.parse(dataN, formatter);
							data.format(formatter);
							funcionario.setDataNascimento(data);
						}

					}
					// Complmento
					funcionario.setComplemento(complemento);

					if (numeroCasa == null || numeroCasa.trim() == "" || numeroCasa.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Numero vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
						txtNumero.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						return;
					} else {
						Integer nCasa = Integer.valueOf(numeroCasa);
						funcionario.setNumero(nCasa);
					}

					// TODO

					// Validação endereco
					String cepString = txtCep.getText().replace("-", "");
					String bairro = txtBairro.getText();
					String cidade = txtMunicipio.getText();
					String rua = txtRua.getText();

					if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
						validacao += "Cep\n";
						txtCep.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						Integer cep = Integer.valueOf(cepString);
						cadastroEndereco.setCep(cep);
					}

					if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
						validacao += "Bairro\n";
						txtBairro.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						cadastroEndereco.setBairro(bairro);
					}
					if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
						validacao += "Cidade\n";
						txtMunicipio.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						cadastroEndereco.setCidade(cidade);
					}
					if (rua == null || rua.trim() == "" || rua.isEmpty()) {
						validacao += "Rua\n";
						txtRua.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						cadastroEndereco.setRua(rua);
					}

					
					

					if (validacao.trim() != "") {
						JOptionPane.showMessageDialog(null, validacao, "Adicione:", JOptionPane.ERROR_MESSAGE, null);
						return;
					}
					EnderecoDao enderecoDao = new EnderecoDao();
					Endereco resultado = new Endereco();
					resultado = enderecoDao.ConsultarEndereco(cadastroEndereco);

					boolean resuEnd = false;
					if (resultado == null) {
						Estado estado = (Estado) cbxEstado.getSelectedItem();
						int id = estado.getId();
						estado.setId(id);

						cadastroEndereco.setEstado(estado);

						// TODO cadastro do endereço

						try {
							resuEnd = enderecoDao.InserirEndereco(cadastroEndereco);
						} catch (Exception e2) {
							e2.printStackTrace();
						}

					}

					if (resultado != null || resuEnd == true) {
						boolean cds = false;
						try {
							// Inserir o endereco no funcionario
							funcionario.setEndereco(cadastroEndereco);
							cds = funcionarioDao.cadastrarFuncionario(funcionario);
						} catch (Exception el) {
							el.printStackTrace();
						}
						if (cds == false) {
							JOptionPane.showMessageDialog(null, "Erro no cadastro, tente novamete");
							JOptionPane.showInternalMessageDialog(null, "cadastrado");
						}
					}
				}
			}
		});
		btnCadastrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(btnCadastrarUsuario, "cell 8 1,grow");

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(236, 253, 232));
		panel_6.setBorder(new LineBorder(new Color(51, 153, 0), 4));
		panel_4.add(panel_6, "cell 0 3,grow");
		panel_6.setLayout(
				new MigLayout("", "[80:n:80][200:n:200,grow][][100:n:100][200:n:200,grow][][220:n:220][350:n:350]",
						"[30:n:30][30:n:30][][220:n:220,grow][5:n:5][30:n:30]"));

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
		btnBuscarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnBuscarFuncionario, "cell 6 1,grow");

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(240, 255, 240));
		panel_7.setBorder(new LineBorder(new Color(51, 153, 0), 4));
		panel_6.add(panel_7, "cell 1 3 7 1,grow");
		panel_7.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1124, 198);
		panel_7.add(scrollPane);

		scrollPane.setViewportView(table);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "E-mail" }));
		scrollPane.setViewportView(table_1);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnEditar, "cell 1 5,grow");

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnExcluir, "cell 4 5,grow");

		JButton btnVoltar = new JButton("     Voltar       ");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal(usuario, senha);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnVoltar, "cell 7 5,alignx trailing,growy");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane
						.createSequentialGroup().addGap(282).addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(308, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane
						.createSequentialGroup().addGap(40).addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(126, Short.MAX_VALUE)));
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

	}
}
