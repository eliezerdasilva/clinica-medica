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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import controller.EnderecoDao;
import controller.PacienteDao;
import model.Endereco;
import model.Estado;
import model.Paciente;
import net.miginfocom.swing.MigLayout;
import javax.swing.ButtonGroup;

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
	private JTextField txtCep;
	private JTextField txtMunicipio;
	private JTextField txtBairro;
	private JTextField txtRua;

	private JTextField txtNCasa;
	private JTextField txtComplemento;
	private JTextField txtBuscaCep;
	private JTextField txtBuscaNome;
	protected String[] convenios;

	private JTextField txtBuscarCpf;
	private JTextField txtBuscarNome;
	

	
	ArrayList<Estado> estados = new ArrayList<>();
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the frame.
	 */
	public TelaCadastroPaciente() {
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE));
		panel.setLayout(new MigLayout("", "[][1286.00,grow]", "[800:n:800,grow][]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		panel.add(panel_1, "cell 1 0,grow");
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
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(
				new MigLayout("", "[1280:n:1280,grow]", "[150:n:150px,grow][200:n:200,grow][300:n:300,grow]"));

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


		JComboBox cbxConvenio = new JComboBox();
		cbxConvenio.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				ArrayList<String> convenios = pacienteDao.consultaConvenio();
				for (String convenio : convenios) {
					cbxConvenio.addItem(convenio);
				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		panel_3.add(cbxConvenio, "cell 6 1,grow");

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

		txtData = new JTextField();
		panel_3.add(txtData, "cell 3 1,grow");
		txtData.setColumns(22);

		txtCpf = new JTextField();
		panel_3.add(txtCpf, "cell 3 3,grow");
		txtCpf.setColumns(23);

		JLabel lblNewLabel_6 = new JLabel("Telefone :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_6, "flowx,cell 3 5");

		txtTelefone = new JTextField();
		panel_3.add(txtTelefone, "cell 3 5,grow");
		txtTelefone.setColumns(10);

		JRadioButton jrbFemi = new JRadioButton("F");
		buttonGroup.add(jrbFemi);
		jrbFemi.setBackground(new Color(240, 255, 240));
		panel_3.add(jrbFemi, "cell 6 3,grow");
		

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 255, 240));
		panel_5.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("",
				"[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][200:n:200px,grow][100px:n:100px]",
				"[5:n:5][][5:n:5][30:n:30][5:n:5][30:n:30][5:n:5][30:n:30]"));

		JLabel lblNewLabel_9 = new JLabel("CEP :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_18 = new JLabel("Cep : ");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_18, "cell 0 1,alignx trailing");


		
		txtCep = new JTextField();
		panel_5.add(txtCep, "cell 1 1 2 1,grow");
		txtCep.setColumns(10);
		
		JButton btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnBuscarCep, "cell 3 1 2 1,grow");
		

		JLabel lblNewLabel_10 = new JLabel("Estado :");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_10, "cell 0 3,alignx trailing");


		JComboBox<Estado> cbxEstado = new JComboBox<>();
		cbxEstado.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				estados = enderecoDao.ConsultaEstadoCidade();
				for (int i = 0; i < estados.size(); i++) {
					cbxEstado.addItem(estados.get(i));
				}

			}

			public void ancestorMoved(AncestorEvent event) {
				
				//int pos = cbxEstado.getSelectedIndex();
				//Estado estadoselecionado = estados.get(pos);
			}

			public void ancestorRemoved(AncestorEvent event) {
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
				//

				String nome = txtNome.getText();
				String cpf = txtCpf.getText();

				String sexo = null;
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
				dataN = dataN.replace("/", ""); // limpar as barras digitadas
				String dia = dataN.substring(0, 2);
				String mes = dataN.substring(2, 4);
				String ano = dataN.substring(4, 8);
				LocalDate dataNascimento = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes),
						Integer.valueOf(dia));
				
				int pos = cbxEstado.getSelectedIndex();
				Estado estadoselecionado = estados.get(pos);
				
				
				Paciente p = new Paciente();
				p.setDataNascimento(dataNascimento);
				// DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				// LocalDate.parse(dataN, formatacao);
				// String convenio = txtConvenio.getText();
				// String dataNascimento = txtDataNasciemento.getText();
				// String complemento = txtComplemento.getText();
				// String numero = txtNumero.getText();

				// String cep = String.valueOf(resultado.);

				if (nome.isEmpty() || cpf.isEmpty() || sexo == null || email.isEmpty()
						|| dataNascimento.equals("  /  /    ") || telefone.isEmpty() || profissao.isEmpty()) {
					{
						if (nome.isEmpty()) {
							txtNome.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						}
						
						if(cpf.isEmpty()) {
							txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						}
						
						if(sexo.isEmpty()) {
							jrbMasc.setBorder(new LineBorder(new Color(255, 00, 00), 4));
							jrbFemi.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						}
						
						if(cpf.isEmpty()) {
							txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						}
						
						if(email.isEmpty()) {
							txtEmail.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						}
						
						if(dataNascimento == null) {
							txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						}
						
						if(telefone.isEmpty()) {
							txtTelefone.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						}
						
						if(profissao.isEmpty()) {
							txtProfissao.setBorder(new LineBorder(new Color(255, 00, 00), 4));
						}
						
					}

				} /*
					 * if(nome == null || nome.trim() == "" || nome.isEmpty()) {
					 * JOptionPane.showMessageDialog(null, "Nome Vazio", "Nome Vazio",
					 * JOptionPane.ERROR_MESSAGE); }else { //manipular nome }
					 * 
					 * 
					 * if (cpf == null || cpf.trim() == "" || cpf.isEmpty()) {
					 * 
					 * } else { //TRANSFORMAR EM STRING //MANIPULAR CPF }
					 * 
					 * 
					 * /*if (sexo == null || sexo.trim() == "" || sexo.isEmpty()) {
					 * JOptionPane.showMessageDialog(null, "Sexo Vazio" ,"Sexo Vazio",
					 * JOptionPane.ERROR_MESSAGE); } else if (sexo != "F" && sexo != "M") {
					 * JOptionPane.showMessageDialog(null, "Sexo Vazio" ,"Sexo Invalido",
					 * JOptionPane.ERROR_MESSAGE); } else { //MANIPULAR SEXO }
					 * 
					 * 
					 * 
					 * 
					 * if (email == null || email.trim() == "" || email.isEmpty()) {
					 * JOptionPane.showMessageDialog(null, "E-mail Vazio" ,"E-mail Vazio",
					 * JOptionPane.ERROR_MESSAGE); }else { //MANIPULAR EMAIL }
					 * 
					 * 
					 * 
					 * 
					 * if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
					 * JOptionPane.showMessageDialog(null, "Telefone Vazio" ,"Telefone Vazio",
					 * JOptionPane.ERROR_MESSAGE); }else { //MANIPULAR TELEFONE }
					 * 
					 * 
					 * 
					 * 
					 * 
					 * if (profissao == null || profissao.trim() == "" || profissao.isEmpty()) {
					 * JOptionPane.showMessageDialog(null, "Profissao Vazia" ,"Profissao Vazia",
					 * JOptionPane.ERROR_MESSAGE); }else { //MANIPULAR PROFISSAO }
					 * 
					 * 
					 * 
					 * 
					 * 
					 * /* if (convenio == null || convenio.trim() == "" || convenio.isEmpty()) {
					 * JOptionPane.showMessageDialog(null, "Convenio Vazia" ,"Convenio Vazia",
					 * JOptionPane.ERROR_MESSAGE); }else { //MANIPULAR CONVENIO }
					 * 
					 * 
					 * 
					 * if (dataNascimento == null || dataNascimento.trim() == "" ||
					 * dataNascimento.isEmpty()) { JOptionPane.showMessageDialog(null, "Data Vazia"
					 * ,"Data Vazia", JOptionPane.ERROR_MESSAGE); }else { //MANIPULAR DATA }
					 * 
					 * 
					 * 
					 * if (complemento == null || complemento.trim() == "" || complemento.isEmpty())
					 * { JOptionPane.showMessageDialog(null, "Complemento Vazia"
					 * ,"Complemento Vazio", JOptionPane.ERROR_MESSAGE); }else { //MANIPULAR
					 * COMPLEMENTO }
					 * 
					 * 
					 * 
					 * 
					 * /*if (numero == null || numero.trim() == "" || numero.isEmpty()) {
					 * JOptionPane.showMessageDialog(null, "Numero Vazia" ,"Numero Vazio",
					 * JOptionPane.ERROR_MESSAGE); }else { //MANIPULAR NUMERO }
					 */

				/*
				 * Endereco resultado = enderecoDao.ConsultarEndereco(consultaEndereco);
				 * 
				 * if(resultado != null) {
				 * 
				 * Paciente paciente = new Paciente(nome,sexo,endereco, cpf, dataNascimento,
				 * telefone, email, rg, profissao, convenio) {
				 * 
				 * } super(id, nome, sexo, endereco, cpf, dataNascimento, telefone, email, rg)
				 * (nome,cpf,sexo,endereco, email,telefone,email,telefone,profissao,convenio,
				 * dataNascimento,); Endereco endereco = EnderecoDAO.buscarEnderecoPorCep();
				 * }else enderecoDao. } Paciente paciente = new Paciente();
				 * paciente.setEndereco(endereco);
				 */

			}
		});
		btnCadastra.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnCadastra, "cell 1 7 2 1,grow");
		
		txtBairro = new JTextField();
		panel_5.add(txtBairro, "cell 5 3,grow");
		txtBairro.setColumns(10);
		
		txtRua = new JTextField();
		panel_5.add(txtRua, "cell 7 3,grow");
		txtRua.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 255, 240));
		panel_6.setBorder(new LineBorder(new Color(85, 107, 47), 4));
		panel_4.add(panel_6, "cell 0 2,grow");
		panel_6.setLayout(
				new MigLayout("", "[80:n:80][200:n:200,grow][][100px:n:100px][200:n:200,grow][][150:n:150][400:n:400]",
						"[5:n:5][30:n:30][][200:n:200,grow][5:n:5][30:n:30]"));

		JLabel lblNewLabel_16 = new JLabel("CPF :\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_16, "cell 0 1,alignx trailing");


		txtBuscaCep = new JTextField();
		panel_6.add(txtBuscaCep, "cell 1 1,grow");
		txtBuscaCep.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Nome :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_17, "cell 3 1,alignx trailing");

		txtBuscaNome = new JTextField();
		panel_6.add(txtBuscaNome, "cell 4 1,grow");
		txtBuscaNome.setColumns(10);

		JButton btnBuscaPaciente = new JButton("Buscar");
		btnBuscaPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnBuscaPaciente, "cell 6 1,grow");

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_6.add(panel_7, "cell 1 3 7 1,grow");

		JButton btnNewButton_4 = new JButton("Editar");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_4, "cell 1 5,grow");

		JButton btnNewButton_5 = new JButton("Excluir");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_5, "cell 4 5,grow");
		/*
		JButton btnNewButton_6 = new JButton("     Voltar       ");
		btnNewButton_6.addActionListener(new ActionListener() /*{

		txtBuscarCpf = new JTextField();
		panel_6.add(txtBuscarCpf, "cell 1 1,grow");
		txtBuscarCpf.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Nome :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_17, "cell 3 1,alignx trailing");
		
		txtBuscarNome = new JTextField();
		panel_6.add(txtBuscarNome, "cell 4 1,grow");
		txtBuscarNome.setColumns(10);
		
		JButton btnBuscarPaciente = new JButton("Buscar");
		btnBuscarPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnBuscarPaciente, "cell 6 1,grow");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_6.add(panel_7, "cell 1 3 7 1,grow");
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnEditar, "cell 1 5,grow");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnExcluir, "cell 4 5,grow");
		
		JButton btnVoltar = new JButton("     Voltar       ");
		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();

/*
				String nome = txtNome.getText();
				String cpf = txtCpf.getText();
				String sexo = txtSexo.getText();
				String email = txtEmail.getText();
				String telefone = txtTelefone.getText();
				String profissao = txtProfissao.getText();
				String convenio = txtConvenio.getText();
				String dataNascimento = txtDataNasciemento.getText();
				String complemento =  txtComplemento.getText();
				String numero = txtNumero.getText();
				String erro;
				
				//String cep = String.valueOf(resultado.);
				
					
					if(nome == null || nome.trim() == "" || nome.isEmpty()) {
						erro = "Nome Vazio";
					}else {
						//manipular nome
					}
					

					if (cpf == null || cpf.trim() == "" || cpf.isEmpty()) {
						erro += "CPF Vazio";
					} else {
						//TRANSFORMAR EM STRING
						//MANIPULAR CPF
					}
				

						if (sexo == null || sexo.trim() == "" || sexo.isEmpty()) {
							erro += "Sexo Vazio";
						} else if (sexo != "F" && sexo != "M") {
							erro += "Sexo Inválido";
						} else {
							//MANIPULAR SEXO
						}
			

					

						if (email == null || email.trim() == "" || email.isEmpty()) {
							erro += "Email Vazio";
						}else {
							//MANIPULAR EMAIL
						}
					

					

						if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
							erro += "Telefone Vazio";
						}else {
							//MANIPULAR TELEFONE
						}

					

					

						if (profissao == null || profissao.trim() == "" || profissao.isEmpty()) {
							erro += "Profissão Vazia";	
						}else {
							//MANIPULAR PROFISSAO
						}

						

					

						if (convenio == null || convenio.trim() == "" || convenio.isEmpty()) {
							erro += "Convenio Vazio";
						}else {
							//MANIPULAR CONVENIO
						}

					

						if (dataNascimento == null || dataNascimento.trim() == "" || dataNascimento.isEmpty()) {
							erro += "Data de Nascimento Vazia";
						}else {
							//MANIPULAR DATA
						}

				
						
						if (complemento == null || complemento.trim() == "" || complemento.isEmpty()) {
							erro += "Complemento Vazio";	
						}else {
							//MANIPULAR COMPLEMENTO
						}


					

						if (numero == null || numero.trim() == "" || numero.isEmpty()) {
							erro += "Numero Vazio";
						}else {
							//MANIPULAR NUMERO
						}

						
						
						if (erro != null || erro.trim() != "") {
							JOptionPane.showMessageDialog(null, "erro", erro, JOptionPane.ERROR_MESSAGE);
						}
				
			
				
				
			/*
				//Endereco resultado = enderecoDao.ConsultarEndereco(consultaEndereco);
				
				//if(resultado != null) {
				
				//Paciente paciente = new Paciente(nome,sexo,endereco, cpf, dataNascimento,
					//	telefone, email,  rg,   profissao,  convenio) {
					
				}/*
					super(id, nome, sexo, endereco, cpf, dataNascimento, telefone, email, rg)
						(nome,cpf,sexo,endereco, email,telefone,email,telefone,profissao,convenio, dataNascimento,);
				//Endereco endereco = EnderecoDAO.buscarEnderecoPorCep();
				}else
					enderecoDao.
				}
				Paciente paciente = new Paciente();
				paciente.setEndereco(endereco);
				
				
			//}

			
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnVoltar, "cell 7 5,alignx trailing,growy");

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
		});*/
	

}
}
