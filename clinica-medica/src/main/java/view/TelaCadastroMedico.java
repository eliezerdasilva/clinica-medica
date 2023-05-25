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

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.EnderecoDao;
import controller.MedicoDao;
import controller.UsuarioDao;
import model.Endereco;
import model.Estado;
import model.Medico;
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
	private int nivelAcesso;

	private JTextField textField_1;
	private JTextField textField_2;
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

	private JButton btnNewButton_4;

	private JButton btn_editar;

	private JComponent panel_5;

	private JComponent panel_6;

	private AbstractButton btnCadastrarMedico;

	private JComponent panel_9;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public TelaCadastroMedico(Usuario usuario) {
		this.usuario = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.nivelAcesso = usuario.getNivelAcesso();

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
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);

		formatDate = new SimpleDateFormat("dd/MM/yyyy");

		JPanel panel = new JPanel();
		panel.setBounds(379, 29, 1194, 959);
		panel.setBackground(new Color(144, 238, 144));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 25));

		JLabel lblNewLabel = new JLabel("Cadastro Médico ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);

		panel_4.setLayout(new MigLayout("", "[1150:n:1150,grow]",
				"[150:n:150px,grow][160:n:160,grow][60:n:60,grow][90:n:90,grow][350:n:350,grow]"));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(107, 142, 35), 4));
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

		JLabel lblNewLabel_2 = new JLabel("E-mail :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_2, "cell 0 3,alignx center");

		txtEmail = new JTextField();
		panel_3.add(txtEmail, "cell 1 3,grow");
		txtEmail.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Cpf :    ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_5, "flowx,cell 3 3,grow");

		txtCpf = new JTextField();

		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e3) {
			JOptionPane.showMessageDialog(null, "Data inválida");
			e3.printStackTrace();
		}
		panel_3.add(txtData, "cell 3 1,grow");
		txtData.setColumns(22);

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e5) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
			e5.printStackTrace();
		}

		panel_3.add(txtCpf, "cell 3 3,grow");
		txtCpf.setColumns(23);

		JLabel lblNewLabel_81 = new JLabel("Sexo :");
		lblNewLabel_81.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_81, "cell 0 5");

		rdbtnMasculino1 = new JRadioButton("M    ");
		buttonGroup.add(rdbtnMasculino1);
		rdbtnMasculino1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMasculino1.setBorder(new LineBorder(new Color(0, 0, 0)));
		rdbtnMasculino1.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnMasculino1, "flowx,cell 1 5,alignx left,growy");

		rdbtnFeminino1 = new JRadioButton("F");
		buttonGroup.add(rdbtnFeminino1);
		rdbtnFeminino1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnFeminino1.setBorder(new LineBorder(new Color(0, 0, 0)));
		rdbtnFeminino1.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnFeminino1, "cell 1 5,alignx center,growy");

		JLabel lblNewLabel_6 = new JLabel("Telefone :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_6, "flowx,cell 3 5");

		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e6) {
			JOptionPane.showMessageDialog(null, "Telefone inválido");
			e6.printStackTrace();
		}
		panel_3.add(txtTelefone, "cell 3 5,grow");
		txtTelefone.setColumns(10);

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 255, 240));
		panel_5.setBorder(new LineBorder(new Color(107, 142, 35), 5));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("", "[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][200:n:200px,grow]", "[5:n:5][][5:n:5][30:n:30][5:n:5][30:n:30][5:n:5]"));

		JLabel lblNewLabel_9 = new JLabel("CEP :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_9, "cell 0 1,alignx trailing");

		txtCep = new JTextField();

		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e7) {
			JOptionPane.showMessageDialog(null, "Telefone inválido");
			e7.printStackTrace();
		}

		panel_5.add(txtCep, "cell 1 1 2 1,grow");
		txtCep.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
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
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnBuscar, "cell 3 1 2 1,grow");

		JLabel lblNewLabel_10 = new JLabel("Estado :");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_10, "cell 0 3,alignx trailing");

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

		JLabel lblNewLabel_11 = new JLabel("Municipio :");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_11, "cell 2 3,alignx center");

		txtMunicipio = new JTextField();
		panel_5.add(txtMunicipio, "cell 3 3,grow");
		txtMunicipio.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Bairro: ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_12, "cell 4 3,alignx trailing,growy");

		txtBairro = new JTextField();
		panel_5.add(txtBairro, "cell 5 3,grow");
		txtBairro.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Rua : ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_13, "cell 6 3,alignx trailing");

		txtRua = new JTextField();
		panel_5.add(txtRua, "cell 7 3,grow");
		txtRua.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("N :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_14, "cell 0 5,alignx trailing");

		txtCasaNumero = new JTextField();
		panel_5.add(txtCasaNumero, "cell 1 5,grow");
		txtCasaNumero.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Complemento :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblNewLabel_15, "cell 2 5,alignx center");

		txtComplemento = new JTextField();
		panel_5.add(txtComplemento, "cell 3 5 2 1,grow");
		txtComplemento.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(240, 255, 240));
		panel_8.setBorder(new LineBorder(new Color(107, 142, 35), 4));
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
		panel_9.setBackground(new Color(240, 255, 240));
		panel_9.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_4.add(panel_9, "cell 0 3,grow");
		panel_9.setLayout(
				new MigLayout("", "[80:n:80][200:n:200,grow][130:n:130][200:n:200,grow][20:n:20][220:n:220]", "[30:n:30][30:n:30]"));

		JLabel lblNewLabel_23 = new JLabel("Login");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_23, "cell 0 0 6 1,alignx center");

		txtUsuario = new JTextField();
		panel_9.add(txtUsuario, "cell 1 1,grow");
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Senha :");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_20, "cell 2 1,alignx trailing");

		btnCadastrarMedico = new JButton("Cadastrar Novo Médico ");
		btnCadastrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cadastroMedico();
				atualizarTabela();

			}

		});

		txtSenha = new JPasswordField();
		panel_9.add(txtSenha, "cell 3 1,grow");

		btnCadastrarMedico.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(btnCadastrarMedico, "cell 5 1,grow");

		JLabel lblNewLabel_21 = new JLabel("Usuario : ");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_21, "cell 0 1,alignx trailing");

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 255, 240));
		panel_6.setBorder(new LineBorder(new Color(0, 128, 64), 4));
		panel_4.add(panel_6, "cell 0 4,grow");
		panel_6.setLayout(new MigLayout("", "[80:n:80][200:n:200,grow][100px:n:100px,grow][200:n:200][200:n:200,grow][][150:n:150]", "[][][][200:n:200,grow][][]"));

		JLabel lblNewLabel_8 = new JLabel("CRM : ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_8, "cell 0 1,alignx trailing");

		textField_1 = new JTextField();
		panel_6.add(textField_1, "cell 1 1,grow");
		textField_1.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Nome : ");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_16, "cell 3 1,alignx trailing");

		textField_2 = new JTextField();
		panel_6.add(textField_2, "cell 4 1,grow");
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_1, "cell 6 1,growx,aligny center");

		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, "cell 1 3 6 1,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CRM", "CPF", "Email" }));
		table.getColumnModel().getColumn(2).setPreferredWidth(77);
		atualizarTabela();
		scrollPane.setViewportView(table);

		btn_editar = new JButton("Editar");
		btn_editar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				btnCadastrarMedico.setVisible(false);
				panel_9.remove(btnCadastrarMedico);

				btn_editar.setVisible(false);
				panel_6.remove(btn_editar);

				btn_Excluir.setVisible(false);
				panel_6.remove(btn_Excluir);

				JButton voltar = new JButton("Volta");
				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpaBorda();
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

				int position = table.getSelectedRow();

				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
					return;
				}
				medicoClick = listaMedico.get(position);
				EditarMedico(medicoClick);

				btnSalvar = new JButton("Salvar");
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String validacao = "";
						String nomeNovo = txtNome.getText();

						String cpfTxt = txtCpf.getText().replace(".", "").replace("-", "");

						String sexo = "";
						if (rdbtnMasculino1.isSelected()) {

							sexo = "M";
						}

						if (rdbtnFeminino1.isSelected()) {

							sexo = "F";
						}
						if (rdbtnFeminino1 == null || rdbtnMasculino1 == null) {
							sexo = null;
						}

						String email = txtEmail.getText();

						String telefone = txtTelefone.getText().replace("-", "").replace("(", "").replace(")", "");

						String dataN = txtData.getText();

						String complemento = txtComplemento.getText();

						String crmString = txtCrm.getText();

						String especializacao = txtEspecializacao.getText();

						String n = txtCasaNumero.getText();

						// TODO Construindo Objeto
						Medico p = new Medico();

						// TODO nova validacao nome
						if (nomeNovo == null || nomeNovo.trim() == "" || nomeNovo.isEmpty()) {
							txtNome.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Nome\n";
						} else {
							txtNome.setBorder(new LineBorder(new Color(00, 00, 00), 1));
							p.setNome(nomeNovo);
						}

						// cpf
						if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
							txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Cpf\n";
						} else {
							txtCpf.setBorder(new LineBorder(new Color(00, 00, 00), 1));
							cpf = Long.valueOf(cpfTxt);
							p.setCpf(cpf);
						}
						// sexo

						if (sexo == null || sexo.isEmpty()) {
							rdbtnFeminino1.setBorderPainted(true);
							rdbtnFeminino1.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							rdbtnMasculino1.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Sexo\n";

						} else {
							p.setSexo(sexo);
						}

						// email
						if (email == null || email.trim() == "" || email.isEmpty()) {
							txtEmail.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Email\n";
						} else {
							txtEmail.setBorder(new LineBorder(new Color(00, 00, 00), 1));
							p.setEmail(email);
						}
						// telefone
						if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
							txtTelefone.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Telefone\n";
						} else {
							txtTelefone.setBorder(new LineBorder(new Color(00, 00, 00), 1));
							p.setTelefone(telefone);

						}
						// data Nascimento
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
								LocalDate dta = LocalDate.parse(dataN, formatter);
								dta.format(formatter);
								p.setDataNascimento(dta);
							}

						}

						// Complemento
						p.setComplemento(complemento);

						if (n == null || n.trim() == "" || n.isEmpty()) {
							txtCasaNumero.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Numero\n";
						} else {
							txtCasaNumero.setBorder(new LineBorder(new Color(00, 00, 00), 1));
							Integer nCasa = Integer.valueOf(n);
							p.setNumero(nCasa);
						}

						// TODO CADASTRO DO CEP NAO CADASTRADO

						// Validacao endereco
						String cepString = txtCep.getText().replace("-", "");
						String bairro = txtBairro.getText();
						String cidade = txtMunicipio.getText();
						String rua = txtRua.getText();

						if (cadastroEndereco == null) {
							cadastroEndereco = new Endereco();
						}

						EnderecoDao endereco = new EnderecoDao();

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
							JOptionPane.showMessageDialog(null, validacao, "Adicione:", JOptionPane.ERROR_MESSAGE,
									null);
							return;
						}

						Endereco resultado = new Endereco();
						resultado = endereco.ConsultarEndereco(cadastroEndereco);
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
						// TODO criacao do usuairo

						String usuario = txtUsuario.getText();
						String senha = txtSenha.getText();

						Usuario usuarioModelo = new Usuario();

						if (usuario == null || usuario.trim() == "" || usuario.isEmpty()) {
							txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Usuario\n";
						} else {
							usuarioModelo.setUsuario(usuario);
						}
						if (senha == null || senha.trim() == "" || senha.isEmpty()) {
							txtSenha.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Senha\n";
						} else {
							usuarioModelo.setSenha(senha);
						}
						usuarioModelo.setNivelAcesso(1);
						usuarioDao = new UsuarioDao();

						Usuario consultaUsuarioCadastrado = usuarioDao.consultarUsuarioCadastrado(usuarioModelo);
						if (consultaUsuarioCadastrado == null) {
							Boolean retorno = usuarioDao.inserirUsuario(usuarioModelo);
							if (retorno == true) {
								Usuario usuarioCadastrado = usuarioDao.consultarUsuarioCadastrado(usuarioModelo);
								if (usuarioCadastrado == null) {
									System.out.println("Erro");
								} else {
									p.setUsuario(usuarioCadastrado);
									usuarioDao.deletarUsuario(usuarioModelo);
								}

							}
						} else {
							Usuario usuarioCadastrado = usuarioDao.consultarUsuarioCadastrado(usuarioModelo);
							p.setUsuario(usuarioCadastrado);
						}

						// Dados do medico

						if (crmString == null || crmString.trim() == "" || crmString.isEmpty()) {
							txtCrm.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "Crm\n";
						} else {
							Long crmLong = Long.valueOf(crmString);
							p.setCrm(crmLong);

						}

						String epecificacao = txtEspecializacao.getText();
						if (epecificacao == null || epecificacao.trim() == "" || epecificacao.isEmpty()) {

							txtEspecializacao.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							validacao += "especializacao\n";
						} else {
							p.setEspecializacao(especializacao);

						}

						medicoDao = new MedicoDao();

						Medico med = medicoDao.consultarMedico(cpf);
						boolean consultaMedicoExistente = false;
						if(med != null) {
							consultaMedicoExistente = true;
						}
						
						if (consultaMedicoExistente != false) {

							resultado = endereco.ConsultarEndereco(cadastroEndereco);

							try {
								// Editar medico

								p.setEndereco(cadastroEndereco);
								boolean cds = medicoDao.alterarMedico(p);
								atualizarTabela();
								if (cds != true) {
									JOptionPane.showMessageDialog(null, "Erro ao editar, tente novamente");
								} else {
									JOptionPane.showMessageDialog(null, "Editado com sucesso");
									limpaBorda();
								}
							} catch (Exception e1) {
								e1.printStackTrace();
							}

						} else {
							JOptionPane.showMessageDialog(null, "ERRO");
						}

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

					int n = JOptionPane.showConfirmDialog(null,
							"Tem certeza que quer excluir?  " + medicoClick.getNome(), "", JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.YES_OPTION) {
						Boolean result = medicoDao.excluirMedico(Long.valueOf(medicoClick.getCpf()));
						if (result == true) {
							JOptionPane.showMessageDialog(null, "Excluindo");
						}
						atualizarTabela();
						limparTela();
					} else {
						JOptionPane.showMessageDialog(null, " erro ao excluir");
						limparTela();
					}
				}
			}
		});
		btn_Excluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btn_Excluir, "cell 3 5,grow");

		btnNewButton_4 = new JButton("Voltar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal mp = new TelaMenuPrincipal(usuario);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_4, "cell 6 5,grow");
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		panel.setLayout(new MigLayout("", "[1150]", "[900]"));
		panel.add(panel_1, "cell 0 0,alignx left,growy");
		contentPane.add(panel);
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
	}

	public void cadastroMedico() {

		String validacao = "";
		String nome = txtNome.getText();

		String cpfTxt = txtCpf.getText().replace(".", "").replace("-", "");

		String sexo = "";
		if (rdbtnMasculino1.isSelected()) {

			sexo = "M";
		}

		if (rdbtnFeminino1.isSelected()) {

			sexo = "F";
		}
		if (rdbtnFeminino1 == null || rdbtnMasculino1 == null) {
			sexo = null;
		}

		String email = txtEmail.getText();

		String telefone = txtTelefone.getText().replace("-", "").replace("(", "").replace(")", "");

		String dataN = txtData.getText();

		String complemento = txtComplemento.getText();

		String crmString = txtCrm.getText();

		String especializacao = txtEspecializacao.getText();

		String n = txtCasaNumero.getText();

		// TODO Construindo Objeto
		Medico p = new Medico();

		// TODO nova validacao nome
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			txtNome.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Nome\n";
		} else {
			p.setNome(nome);
		}

		// cpf
		if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
			txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Cpf\n";
		} else {
			cpf = Long.valueOf(cpfTxt);
			p.setCpf(cpf);
		}
		// sexo

		if (sexo == null || sexo.isEmpty()) {
			rdbtnFeminino1.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			rdbtnMasculino1.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Sexo\n";

		} else {
			p.setSexo(sexo);
		}
		// email
		if (email == null || email.trim() == "" || email.isEmpty()) {

			txtEmail.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Email\n";
		} else {
			p.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
			txtTelefone.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Telefone\n";
		} else {
			p.setTelefone(telefone);

		}
		// data Nascimento
		if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
			validacao += "Data\n";
			txtData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			String dataTest = dataN.replace("/", "").trim();
			if (dataTest.length() == 0) {
				txtData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dta = LocalDate.parse(dataN, formatter);
				dta.format(formatter);
				p.setDataNascimento(dta);
			}

		}

		// Complemento
		p.setComplemento(complemento);

		if (n == null || n.trim() == "" || n.isEmpty()) {
			txtCasaNumero.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Numero\n";
		} else {
			txtCasaNumero.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Integer nCasa = Integer.valueOf(n);
			p.setNumero(nCasa);
		}

		// TODO CADASTRO DO CEP NAO CADASTRADO

		// Validacao endereco
		String cepString = txtCep.getText().replace("-", "");
		String bairro = txtBairro.getText();
		String cidade = txtMunicipio.getText();
		String rua = txtRua.getText();

		if (cadastroEndereco == null) {
			cadastroEndereco = new Endereco();
		}

		EnderecoDao endereco = new EnderecoDao();

		if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
			validacao += "Cep\n";
			txtCep.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtCep.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Integer cep = Integer.valueOf(cepString);
			cadastroEndereco.setCep(cep);
		}

		if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
			validacao += "Bairro\n";
			txtBairro.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtBairro.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			cadastroEndereco.setBairro(bairro);
		}
		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			validacao += "Cidade\n";
			txtMunicipio.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtMunicipio.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			cadastroEndereco.setCidade(cidade);
		}
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			validacao += "Rua\n";
			txtRua.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtRua.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			cadastroEndereco.setRua(rua);
		}

		// Cadastramento do usuario

		String usuario = txtUsuario.getText();
		String senha = txtSenha.getText();

		Usuario usuarioModelo = new Usuario();

		if (usuario == null || usuario.trim() == "" || usuario.isEmpty()) {
			txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Usuario\n";
		} else {
			txtUsuario.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			usuarioModelo.setUsuario(usuario);
		}
		if (senha == null || senha.trim() == "" || senha.isEmpty()) {
			txtSenha.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Senha\n";
		} else {
			txtSenha.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			usuarioModelo.setSenha(senha);
		}

		// TODO criacao e valição do usuairo no banco de dados

		usuarioModelo.setNivelAcesso(1);
		usuarioDao = new UsuarioDao();

		Boolean resultadoUsuario = usuarioDao.consultarUsuarioExistente(usuario);
		if (resultadoUsuario != true) {
			p.setUsuario(usuarioModelo);
		} else {
			JOptionPane.showMessageDialog(null, "Informe outro Usuário para login.");
			txtUsuario.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		}

		Usuario consultaUsuarioCadastrado = usuarioDao.consultarUsuarioCadastrado(usuarioModelo);

		if (crmString == null || crmString.trim() == "" || crmString.isEmpty()) {
			txtCrm.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Crm\n";
		} else {
			txtCrm.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Long crmLong = Long.valueOf(crmString);
			p.setCrm(crmLong);

		}

		String especificacao = txtEspecializacao.getText();
		if (especificacao == null || especificacao.trim() == "" || especificacao.isEmpty()) {

			txtEspecializacao.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Especializacao\n";
		} else {
			txtEspecializacao.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			p.setEspecializacao(especializacao);

		}

		if (validacao.trim() != "") {
			JOptionPane.showMessageDialog(null, validacao, "Adicione:", JOptionPane.ERROR_MESSAGE, null);
			return;
		}

		Endereco resultado = new Endereco();
		resultado = endereco.ConsultarEndereco(cadastroEndereco);

		if (resultado == null) {
			Estado estado = (Estado) cbxEstado.getSelectedItem();
			int id = estado.getId();
			estado.setId(id);

			cadastroEndereco.setEstado(estado);

			// TODO cadastro do endereço

			try {
				Boolean result = enderecoDao.InserirEndereco(cadastroEndereco);
				if (result != true) {
					JOptionPane.showMessageDialog(null, "Erro no cadastro, endereço inválido", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					limpaBorda();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Erro no cadastro, endereço inválido", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		// Dados do medico

		//if (consultaUsuarioCadastrado != true) {

			medicoDao = new MedicoDao();
			
			Medico med = medicoDao.consultarMedico(cpf);
			boolean consultaMedicoExistente = false;
			if(med != null) {
				consultaMedicoExistente = true;
			}
			
			if (consultaMedicoExistente != true) {

				resultado = endereco.ConsultarEndereco(cadastroEndereco);

				if (resultado != null) {
					boolean cds = false;

					try {
						// Inserir o endereco no paciente

						p.setEndereco(cadastroEndereco);
						// boolean usuarioCadastrado = usuarioDao.inserirUsuario(usuarioModelo);
						boolean usuarioCadastrado = usuarioDao.inserirUsuario(usuarioModelo);
						if (usuarioCadastrado == true) {
							Usuario usuarioSelecionado = usuarioDao.selecionarUSuarioParaCadastrar(usuarioModelo);
							p.setUsuario(usuarioSelecionado);

							cds = medicoDao.cadastrarMedico(p);
						} else {
							JOptionPane.showMessageDialog(null, "Erro no cadastro, usuário inválido", "Erro",
									JOptionPane.ERROR_MESSAGE);
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}

					if (cds == false) {
						JOptionPane.showMessageDialog(null, "Erro no cadastro, tente novamente");
					} else {
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						limpaBorda();
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "ERRO: Médico já Cadastrado no sistema");
			}
	//	}
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
		Usuario usuario = usuarioDao.consultarUsuario(usuarioid);
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
		Endereco enderecoDoBanco = enderecoDao.ConsultarEndereco(endereco);
		txtCep.setText(String.valueOf(enderecoDoBanco.getCep()));
		txtBairro.setText(enderecoDoBanco.getBairro());
		txtMunicipio.setText(enderecoDoBanco.getCidade());
		txtRua.setText(enderecoDoBanco.getRua());
		cbxEstado.setSelectedIndex(enderecoDoBanco.getEstado().getId() - 1);

	}

	private void limpaBorda() {

		txtNome.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtEmail.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtTelefone.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtComplemento.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtCasaNumero.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtCpf.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtData.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtCrm.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtEspecializacao.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtUsuario.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		txtSenha.setBorder(new LineBorder(new Color(255, 255, 255), 4));

	}

	private void EditarMedico(Medico medicoSelecionado) {
		preencherMedicoTabela(medicoSelecionado);

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
