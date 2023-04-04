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
<<<<<<< HEAD
import java.text.ParseException;
=======
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
>>>>>>> cadastroFuncionario

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
<<<<<<< HEAD
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
=======
>>>>>>> cadastroFuncionario
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
import javax.swing.table.DefaultTableModel;

import controller.EnderecoDao;
import controller.FuncionarioDao;
import model.Endereco;
<<<<<<< HEAD
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Panel;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import utils.RoundButton;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
=======
import model.Estado;
import model.Funcionario;
import net.miginfocom.swing.MigLayout;
>>>>>>> cadastroFuncionario

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
	private JTextField txtProfissao;
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
	private JTextField txtSenha;
	private JPasswordField passwordField;
	private JTable table;
<<<<<<< HEAD
	private String usuario;
	private String senha;
=======
	private Endereco cadastroEndereco;
	
	EnderecoDao enderecoDao = new EnderecoDao();
	FuncionarioDao funcionarioDao = new FuncionarioDao(); 
	
	private ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
	private ArrayList<Funcionario> listaEndereco = new ArrayList<>();
	
>>>>>>> cadastroFuncionario
	
	
	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha; 
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Tela Cadastro de Funcionario");

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
		panel.setLayout(new MigLayout("", "[1310px]", "[900]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		BufferedImage filc = null;

		try {
			filc = ImageIO.read(new File("src/imagens/fundoVerde.jpeg"));

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel panel_2 = new FundoImagemLoginCabecario(filc);
		panel_2.setBackground(new Color(51, 153, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 25));

		JLabel lblNewLabel = new JLabel("Cadastro Funcionario"); 
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[1280:n:1280,grow]", "[150:n:150px,grow][160:n:160,grow][100:n:100,grow][350:n:350,grow]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_3.setBackground(new Color(240, 255, 240));
		panel_4.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[][300:n:300,grow][][300:n:300][][][150:n:150,grow]", "[][30:n:30][][30:n:30][][30:n:30][]"));
		
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
		
		JLabel lblNewLabel_8 = new JLabel("Sexo :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_8, "cell 5 3");
		
		JRadioButton rdbtnMasculino = new JRadioButton("M");
		rdbtnMasculino.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnMasculino, "flowx,cell 6 3,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Profissão :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_3, "cell 0 5,alignx trailing");
		
		txtProfissao = new JTextField();
		panel_3.add(txtProfissao, "cell 1 5,grow");
		txtProfissao.setColumns(10);
		
		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null,"Data inválida");
			e2.printStackTrace();
		}
		panel_3.add(txtData, "cell 3 1,grow");
		txtData.setColumns(22);
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e3) {
			JOptionPane.showMessageDialog(null,"CPF inválido");
			e3.printStackTrace();
		}
		panel_3.add(txtCpf, "cell 3 3,grow");
		txtCpf.setColumns(23);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_6, "flowx,cell 3 5");
		
		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e4) {
			JOptionPane.showMessageDialog(null,"Telefone inválido");
			e4.printStackTrace();
		}
		panel_3.add(txtTelefone, "cell 3 5,grow");
		txtTelefone.setColumns(10);
		
		JRadioButton rdbtnFeminino = new JRadioButton("F");
		rdbtnFeminino.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnFeminino, "cell 6 3,grow");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 255, 240));
		panel_5.setBorder(new LineBorder(new Color(107, 142, 35), 5));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("", "[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][200:n:200px,grow][150:n:150]", "[5:n:5][][5:n:5][30:n:30][5:n:5][30:n:30][5:n:5]"));
		
		JLabel lblNewLabel_9 = new JLabel("CEP :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_9, "cell 0 1,alignx trailing");
		
		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e5) {
			JOptionPane.showMessageDialog(null,"CEP inválido");
			e5.printStackTrace();
		}
		panel_5.add(txtCep, "cell 1 1 2 1,grow");
		txtCep.setColumns(10);
		
		JButton btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnBuscarCep, "cell 3 1 2 1,grow");
		
		JLabel lblNewLabel_10 = new JLabel("Estado :");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_10, "cell 0 3,alignx trailing");
		
		JComboBox cbxEstado = new JComboBox();
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
		
		txtNumero = new JTextField();
		panel_5.add(txtNumero, "cell 1 5,grow");
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Complemento :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblNewLabel_15, "cell 2 5,alignx center");
		
		txtComplemento = new JTextField();
		panel_5.add(txtComplemento, "cell 3 5 2 1,grow");
		txtComplemento.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(240, 255, 240));
		panel_9.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_4.add(panel_9, "cell 0 2,grow");
		panel_9.setLayout(new MigLayout("", "[80:n:80][200:n:200,grow][130:n:130][200:n:200,grow][20:n:20][][][][220:n:220]", "[30:n:30][30:n:30]"));
		
		JLabel lblNewLabel_23 = new JLabel("Login");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_23, "cell 0 0 9 1,alignx center");
		
		JLabel lblNewLabel_20 = new JLabel("Senha :");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_20, "cell 0 1,alignx trailing");
		
		txtSenha = new JTextField();
		panel_9.add(txtSenha, "cell 1 1,grow");
		txtSenha.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("Usuario : ");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_21, "cell 2 1,alignx trailing");
		
		passwordField = new JPasswordField();
		panel_9.add(passwordField, "cell 3 1,grow");
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setBackground(new Color(240, 255, 240));
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_9.add(rdbtnAdministrador, "cell 5 1");
		
		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionario");
		rdbtnFuncionario.setBackground(new Color(240, 255, 240));
		rdbtnFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(rdbtnFuncionario, "cell 6 1");
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar Novo Funcionario");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				
				String cpfTxt = txtCpf.getText();
				
				String sexo = "ma";
				if (rdbtnMasculino.isSelected()) {
					
					sexo = "Masulino";
				}
				if (rdbtnFeminino.isSelected()) {
					sexo = "Feminino";
				}
				if (rdbtnFeminino == null || rdbtnMasculino == null) {
					sexo = null;
				}
				String email = txtEmail.getText();
				
				String telefone = txtTelefone.getText();
				
				String profissao = txtProfissao.getText();
				
				String dataN = txtData.getText();
				
				String complemento = txtComplemento.getText();
				
				String n = txtNumero.getText();
			
			//TODO Construindo Objeto
			Funcionario p = new Funcionario();
			
			//TODO nova validacao nome
			if (nome == null || nome.trim() == "" || nome.isEmpty()) {
				txtNome.setBorder(new LineBorder (new Color (255, 00, 00), 4));
				JOptionPane.showMessageDialog(null,  "Nome Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
				return;
			} else {
				p.setNome(nome);
			}
			// cpf
			
		if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
			//txtCpf.setBorder(new LineBorder(new Color(255, 00, 00, 4));
			JOptionPane.showMessageDialog(null,"CPF Vazio", "ok", JOptionPane.ERROR_MESSAGE);
			return;
		}else {
			Long cpf = Long.valueOf(cpfTxt);
			p.setCpf(cpf);
		}
		// sexo
		
		if (sexo == null || sexo.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Sexo Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
			rdbtnFeminino.setBorder(new LineBorder(new Color(255, 00, 00),4));
			rdbtnMasculino.setBorder(new LineBorder(new Color(255, 00, 00),4));
			return;
		}else {
			p.setSexo(sexo);
		}
		//email
		if (email == null || email.trim() ==  "" || email.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Sexo Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
		txtEmail.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		return;
		}else {
			p.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim()== "" || telefone.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Telefone Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
			txtTelefone.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			return;
		}else {
			p.setTelefone(telefone);
		}
		// data nascimento
		if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Data Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
			txtData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			return;
		}else {
		
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(dataN, formatter);
			
			p.setDataNascimento(date);
			
			// Complmento
			p.setComplemento(complemento);
			
			if (n == null || n.trim() == "" || n.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Numero Vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
				txtNumero.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				return;
			}else {
				Integer nCasa = Integer.valueOf(n);
				p.setNumero(nCasa);
			}
			// TODO CADASTRO DO CEP NAO CADASTRADO
			
			//Validação endereco
			String cepString = txtCep.getText();
			String bairro = txtBairro.getText();
			String cidade = txtMunicipio.getText();
			String rua = txtRua.getText();
			
			if (cadastroEndereco == null) {
				cadastroEndereco = new Endereco();	
			}
			
			EnderecoDao endereco = new EnderecoDao();
			
			if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
				JOptionPane.showInternalMessageDialog(null, "cep Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
				txtCep.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				return;
			}else {
				Integer cep = Integer.valueOf(cepString);
				cadastroEndereco.setCep(cep);
			}
			
			if (bairro == null || bairro.trim()== "" || bairro.isEmpty()) {
				JOptionPane.showInternalMessageDialog(null,"cep Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
				txtBairro.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				return;
			}else {
				cadastroEndereco.setBairro(bairro);
			}
			if (cidade == null || cidade.trim() == "" || cidade.isEmpty()){
				JOptionPane.showMessageDialog(null, "cep Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
				txtMunicipio.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				return;
			}else {
				cadastroEndereco.setCidade(cidade);
			}
			if(rua == null || rua.trim() == "" || rua.isEmpty()) {
				JOptionPane.showMessageDialog(null, "cep Vazia", "ok", JOptionPane.ERROR_MESSAGE, null);
				txtRua.setBorder(new LineBorder(new Color(255, 00, 00), 4));
				return;
			}else {
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
				
				//Cria o objeto endereco
				
				// TODO cadastro do endereco
				boolean resuEnd = false;
				try {
					resuEnd = enderecoDao.InserirEndereco(cadastroEndereco);
					
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (resultado != null) {
				boolean cds = false;
				try {
					//Inserir o endereco no funcionario
					p.setEndereco(cadastroEndereco);
					cds = funcionarioDao.cadastrarFuncionario(p);
				}catch (Exception el) {
					el.printStackTrace();
				}
				if (cds == false) {
					JOptionPane.showMessageDialog(null, "Erro no cadastro, tente novamete");
					JOptionPane.showInternalMessageDialog(null, "cadastrado");
				}
			}
		}
			}});
		btnCadastrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(btnCadastrarUsuario, "cell 8 1,grow");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 255, 240));
		panel_6.setBorder(new LineBorder(new Color(85, 107, 47), 4));
		panel_4.add(panel_6, "cell 0 3,grow");
		panel_6.setLayout(new MigLayout("", "[80:n:80][200:n:200,grow][][100:n:100][200:n:200,grow][][220:n:220][350:n:350]", "[30:n:30][30:n:30][][220:n:220,grow][5:n:5][30:n:30]"));
		
		JLabel lblNewLabel_22 = new JLabel("Editar");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_22, "cell 0 0 8 1,alignx center");
		
		JLabel lblNewLabel_16 = new JLabel("CPF :\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_16, "cell 0 1,alignx trailing");
		
		try {
			txtBuscarCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e6) {
			JOptionPane.showMessageDialog(null,"CPF inválido");
			e6.printStackTrace();
		}
		panel_6.add(txtBuscarCpf, "cell 1 1,grow");
		txtBuscarCpf.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Nome :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_17, "cell 3 1,alignx trailing");
		
		txtBuscarNome = new JTextField();
		panel_6.add(txtBuscarNome, "cell 4 1,grow");
		txtBuscarNome.setColumns(10);
		
		JButton btnBuscarFuncionario = new JButton("Buscar");
		btnBuscarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnBuscarFuncionario, "cell 6 1,grow");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_6.add(panel_7, "cell 1 3 7 1,grow");
		panel_7.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1124, 198);
		panel_7.add(scrollPane);
		
	
		scrollPane.setViewportView(table);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnEditar, "cell 1 5,grow");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnExcluir, "cell 4 5,grow");
		
		JButton btnVoltar = new JButton("     Voltar       ");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal(usuario,senha);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnVoltar, "cell 7 5,alignx trailing,growy");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(282)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		JButton btnNewButton = new RoundButton("Entrar");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\frete\\Documents\\clinica-medica\\src\\imagens\\icons8-login-arredondado-30.png"));

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
	
		}}


