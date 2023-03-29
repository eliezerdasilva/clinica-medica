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
import javax.lang.model.util.SimpleAnnotationValueVisitor14;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.MaskFormatter;

import controller.EnderecoDao;
import controller.PacienteDao;
import model.Convenio;
import model.Endereco;
import model.Estado;
import model.Paciente;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpringLayout;

/**
 * 
 * @author Eliezer da Silva
 * 
 *         Classe resposavel por exibir Tela de cadastro de paciente
 *
 */
public class TelaCadastroPaciente extends JFrame {
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
	private MaskFormatter mascaraCep = null;
	private JTextField txtMunicipio;
	private JTextField txtBairro;
	private JTextField txtRua;

	private JTextField txtNCasa;
	private JTextField txtComplemento;
	private JTextField txtBuscaCep;
	private JTextField txtBuscaNome;
	protected String[] convenios;
	private Estado estado;
	private Endereco cadastroEndereco;

	ArrayList<Estado> estados = new ArrayList<>();
	ArrayList<Convenio> convenio = new ArrayList<>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCep;
	private JTable table;
	private ArrayList<Paciente> listaPaciente = new ArrayList<>();
	private ArrayList<Paciente> listaEndereco = new ArrayList<>();
	private Paciente pacienteClick;
	private Endereco enderecoClink;

	/**
	 * Create the frame.
	 * 
	 * @param listaPaciente
	 */
	public TelaCadastroPaciente(ArrayList<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Tela cadastro de paciente");

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
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);

		BufferedImage bg = null;

		try {
			bg = ImageIO.read(new File("src/imagens/fundoLogin.jpeg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel = new FundoImagemLogin(bg);
		panel.setBackground(new Color(204, 255, 204));
		panel.setLayout(new MigLayout("", "[300:n:300][1286.00,grow][250:n:250]", "[60:n:60][830:n:830,grow,top][80:n:80]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		panel.add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		BufferedImage filc = null;

		try {
			filc = ImageIO.read(new File("src/imagens/fundoVerde.jpeg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel_2 = new FundoImagemLoginCabecario(filc);
		panel_2.setBackground(new Color(51, 153, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 25));

		JLabel lblNewLabel = new JLabel("Cadastro Paciente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(
				new MigLayout("", "[1310:n:1310,grow]", "[150:n:150px,grow][200:n:200,grow][350:n:350,grow]"));

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

		JLabel lblNewLabel_7 = new JLabel("Convênio :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_7, "cell 5 1,alignx trailing");

		JComboBox<Convenio> cbxConvenio = new JComboBox();
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
		panel_6.setBorder(new LineBorder(new Color(85, 107, 47), 4));
		panel_4.add(panel_6, "cell 0 2,grow");
		panel_6.setLayout(
				new MigLayout("", "[80:n:80][200:n:200,grow][][100px:n:100px][200:n:200,grow][][150:n:150][400:n:400]", "[5:n:5][30:n:30][][230:n:230,grow][5:n:5][30:n:30]"));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 255, 240));
		panel_5.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("",
				"[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][200:n:200px,grow][100px:n:100px]",
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

		JRadioButton jrbMasc = new JRadioButton("M");
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

		txtBairro = new JTextField();
		panel_5.add(txtBairro, "cell 5 3,grow");
		txtBairro.setColumns(10);

		txtRua = new JTextField();
		panel_5.add(txtRua, "cell 7 3,grow");
		txtRua.setColumns(10);

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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
			JOptionPane.showMessageDialog(null,"CPF inválido");
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
			JOptionPane.showMessageDialog(null,"Telefone inválido");
			e5.printStackTrace();
		}
		panel_3.add(txtTelefone, "cell 3 5,grow");
		txtTelefone.setColumns(10);

		JRadioButton jrbFemi = new JRadioButton("F");
		buttonGroup.add(jrbFemi);
		jrbFemi.setBackground(new Color(240, 255, 240));
		panel_3.add(jrbFemi, "cell 6 3,grow");

		JLabel lblNewLabel_9 = new JLabel("CEP :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNewLabel_18 = new JLabel("Cep : ");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_18, "cell 0 1,alignx trailing");

		JComboBox<Estado> cbxEstado = new JComboBox<>();
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

		txtBuscaCep = new JTextField();
		panel_6.add(txtBuscaCep, "cell 1 1,grow");
		txtBuscaCep.setColumns(10);

		JButton btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
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
					System.out.println("nao faz setnioo");

				} else {
					JOptionPane.showMessageDialog(null, "Cep não cadastrado");

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
		panel_5.add(lblNewLabel_11, "cell 2 3,alignx center");

		txtMunicipio = new JTextField();

		panel_5.add(txtMunicipio, "cell 3 3,grow");
		txtMunicipio.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Bairro: ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_12, "cell 4 3,alignx trailing,growy");

		JLabel lblNewLabel_13 = new JLabel("Rua : ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_13, "cell 6 3,alignx trailing");

		JLabel lblNewLabel_14 = new JLabel("N :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_14, "cell 0 5,alignx trailing");

		txtNCasa = new JTextField();

		panel_5.add(txtNCasa, "cell 1 5,grow");
		txtNCasa.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Complemento :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblNewLabel_15, "cell 2 5,alignx center");

		txtComplemento = new JTextField();
		panel_5.add(txtComplemento, "cell 3 5 2 1,grow");
		txtComplemento.setColumns(10);

		JButton btnCadastra = new JButton("Cadastrar");
		btnCadastra.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String nome = txtNome.getText();
				Long cpfConsulta;
				String cpfTxt = txtCpf.getText();

				String sexo = "ma";
				if (jrbMasc.isSelected()) {

					sexo = "Masculino";
				}

				if (jrbFemi.isSelected()) {

					sexo = "Feminino";
				}
				if (jrbFemi == null || jrbMasc == null) {
					sexo = null;
				}

				String email = txtEmail.getText();

				String telefone = txtTelefone.getText();

				String profissao = txtProfissao.getText();

				String dataN = txtData.getText();

				String complemento = txtComplemento.getText();

				String n = txtNCasa.getText();

				// TODO Construindo Objeto
				Paciente p = new Paciente();

				// TODO nova validacao nome
				if (nome == null || nome.trim() == "" || nome.isEmpty()) {
					txtNome.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					JOptionPane.showMessageDialog(null, "Nome Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
					return;
				} else {
					p.setNome(nome);
				}
				// cpf

				if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
					txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					JOptionPane.showMessageDialog(null, "CPF Vazio", "ok", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					Long cpf = Long.valueOf(cpfTxt);
					cpfConsulta = Long.valueOf(cpfTxt);
					p.setCpf(cpf);
				}
				// sexo

				if (sexo == null || sexo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sexo Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
					jrbFemi.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					jrbMasc.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
					p.setSexo(sexo);
				}
				// email
				if (email == null || email.trim() == "" || email.isEmpty()) {
					JOptionPane.showMessageDialog(null, "E-mail Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtEmail.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
					p.setEmail(email);
				}
				// telefone
				if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Telefone Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtTelefone.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
					p.setTelefone(telefone);

				}
				// profissao
				if (profissao == null || profissao.trim() == "" || profissao.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Profissao Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtProfissao.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
					p.setProfissao(profissao);
				}
				// convenio
				if (convenio == null || convenio.isEmpty()) {
					cbxConvenio.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					JOptionPane.showMessageDialog(null, "Convenio Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
					return;
				} else {

					Convenio convenios = (Convenio) cbxConvenio.getSelectedItem();
					int id = convenios.getId();
					String convenio = convenios.getConvenio();

					p.setConvenio(convenios);

				}

				// data Nascimento
				if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Data Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {

					String data = "25/01/2016";
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate date = LocalDate.parse(data, formatter);

					p.setDataNascimento(date);

				}

				// Complemento
				p.setComplemento(complemento);

				if (n == null || n.trim() == "" || n.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Numero Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtNCasa.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
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
					JOptionPane.showMessageDialog(null, "cep Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtCep.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
					Integer cep = Integer.valueOf(cepString);
					cadastroEndereco.setCep(cep);
				}

				if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
					JOptionPane.showMessageDialog(null, "cep Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtBairro.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
					cadastroEndereco.setBairro(bairro);
				}
				if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
					JOptionPane.showMessageDialog(null, "cep Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtMunicipio.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
					cadastroEndereco.setCidade(cidade);
				}
				if (rua == null || rua.trim() == "" || rua.isEmpty()) {
					JOptionPane.showMessageDialog(null, "cep Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
					txtRua.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					return;
				} else {
					cadastroEndereco.setRua(rua);
				}
				Endereco resultado = new Endereco();
				resultado = endereco.ConsultarEndereco(cadastroEndereco);

				if (resultado == null) {
					Estado estado = (Estado) cbxEstado.getSelectedItem();
					int id = estado.getId();
					String nomeEstado = estado.getNome();
					String uf = estado.getUf();
					System.out.println(id);

					Estado estadoSel = new Estado();
					estadoSel.setId(id);
					;
					estadoSel.setNome(nomeEstado);
					estadoSel.setUf(uf);

					// Cria o objeto endereco

					// TODO cadastro do endereço
					boolean resuEnd = false;
					try {
						resuEnd = enderecoDao.InserirEndereco(cadastroEndereco);
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}

				// TODO ver se paciente existe
				boolean resultadoPacienteCadastrado = pacienteDao.ConsultaCpfPaciente(cpfConsulta);

				if (resultadoPacienteCadastrado != false) {

					if (resultado != null) {
						boolean cds = false;

						try {
							// Inserir o endereco no paciente
							p.setEndereco(cadastroEndereco);
							cds = pacienteDao.cadastrarPaciente(p);
							limparTela();
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						if (cds == false) {
							JOptionPane.showMessageDialog(null, "Erro no cadastro, tente novamente");
						} else {
							JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
							atualizarTabela();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Paciente Cadastrado");
				}
			}

		});

		btnCadastra.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnCadastra, "cell 1 7 2 1,grow");

		JLabel lblNewLabel_16 = new JLabel("CPF :\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_16, "cell 0 1,alignx trailing");

		JLabel lblNewLabel_17 = new JLabel("Nome :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_17, "cell 3 1,alignx trailing");

		try {
			txtBuscaNome = new JFormattedTextField(new MaskFormatter("###.####.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();	
		}
		panel_6.add(txtBuscaNome, "cell 4 1,grow");
		txtBuscaNome.setColumns(10);

		JButton btnBuscaPaciente = new JButton("Buscar");
		btnBuscaPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnBuscaPaciente, "cell 6 1,grow");

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_6.add(panel_7, "cell 1 3 7 1,grow");
		panel_7.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();

		panel_7.add(scrollPane, "name");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int position = table.getSelectedRow();
				pacienteClick = listaPaciente.get(position);

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Email" }));
		atualizarTabela();
		scrollPane.setViewportView(table);

		JButton btnNewButton_4 = new JButton("Editar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pacienteClick != null) {
					txtNome.setText(pacienteClick.getNome());
					txtEmail.setText(pacienteClick.getEmail());
					txtTelefone.setText(pacienteClick.getTelefone());
					txtComplemento.setText(pacienteClick.getComplemento());
					txtNCasa.setText(String.valueOf(pacienteClick.getNumero()));
					txtCpf.setText(String.valueOf(pacienteClick.getCpf()));
					Date data = Date.valueOf(pacienteClick.getDataNascimento());
					txtData.setText(format.format(data));
					txtProfissao.setText(pacienteClick.getProfissao());

					String sexo = pacienteClick.getSexo();
					System.out.println(sexo);
					if (sexo == "m") {
						jrbFemi.isSelected();
					} else {
						jrbMasc.isSelected();
					}
					cbxConvenio.setSelectedIndex(pacienteClick.getConvenio().getId());

					Integer cep = pacienteClick.getEndereco().getCep();
					EnderecoDao enderecoDao = new EnderecoDao();
					Endereco endereco = new Endereco(cep);
					Endereco enderecoDoBanco = enderecoDao.ConsultarEndereco(endereco);
					txtCep.setText(String.valueOf(enderecoDoBanco.getCep()));
					txtBairro.setText(enderecoDoBanco.getBairro());
					txtMunicipio.setText(enderecoDoBanco.getCidade());
					txtRua.setText(enderecoDoBanco.getRua());

					cbxEstado.setSelectedIndex(enderecoDoBanco.getEstado().getId());

				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_4, "cell 1 5,grow");

		JButton btnNewButton_5 = new JButton("Excluir");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_5, "cell 4 5,grow");

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal mp = new MenuPrincipal();
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();

			}
		});
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		contentPane.setLayout(sl_contentPane);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton, "cell 7 5,growx");
		contentPane.add(panel);

	}

	private void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Email" }

		);
		for (int i = 0; i < listaPaciente.size(); i++) {
			Paciente paciente = listaPaciente.get(i);
			tabela.addRow(new Object[] { paciente.getNome(), paciente.getCpf(), paciente.getEmail()

			});
			;
		}
		table.setModel(tabela);
	}
	private void limparTela() {
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtComplemento.setText("");
		txtNCasa.setText("");
		txtCpf.setText("");
		txtData.setText("");
		txtProfissao.setText("");
		txtCep.setText("");
		txtBairro.setText("");
		txtMunicipio.setText("");
		txtRua.setText("");
	}

}
