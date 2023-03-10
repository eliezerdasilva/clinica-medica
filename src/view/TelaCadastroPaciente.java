package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Endereco;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
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
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;

/**
 * 
 * @author Eliezer da Silva
 * 
 *         Classe resposavel por exibir Tela de cadastro de paciente
 *
 */
public class TelaCadastroPaciente extends JFrame {
	private JPanel contentPane;
	Endereco enderecoPronto = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_7;
	private JTextField textField_13;
	
	

	/**
	 * Create the frame.
	 */
	public TelaCadastroPaciente() {
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Tala de login");

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
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
		);
		panel.setLayout(new MigLayout("", "[331.00][1286.00,grow][299.00]", "[50:n:50][900:n:900,grow][50:n:50]"));

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
		panel_2.setLayout(new CardLayout(0, 40));

		JLabel lblNewLabel = new JLabel("Cadastro Paciente"); 
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[1280:n:1280,grow]", "[150:n:150px,grow][200:n:200,grow][62.00,grow]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_3.setBackground(new Color(240, 255, 240));
		panel_4.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[][300:n:300,grow][][300:n:300][][][150:n:150,grow]", "[][30:n:30][][30:n:30][][30:n:30][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_1, "cell 0 1,alignx center,growy");
		
		textField = new JTextField();
		panel_3.add(textField, "cell 1 1,grow");
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_4, "flowx,cell 3 1,growx");
		
		JLabel lblNewLabel_7 = new JLabel("Conv??nio :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_7, "cell 5 1,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox, "cell 6 1,grow");
		
		JLabel lblNewLabel_2 = new JLabel("E-mail :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_2, "cell 0 3,alignx center");
		
		textField_1 = new JTextField();
		panel_3.add(textField_1, "cell 1 3,grow");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cpf :    ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_5, "flowx,cell 3 3,grow");
		
		JLabel lblNewLabel_8 = new JLabel("Sexo :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_8, "cell 5 3");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		rdbtnNewRadioButton.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnNewRadioButton, "flowx,cell 6 3,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Profiss??o :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_3, "cell 0 5,alignx trailing");
		
		textField_2 = new JTextField();
		panel_3.add(textField_2, "cell 1 5,grow");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3, "cell 3 1,grow");
		textField_3.setColumns(22);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4, "cell 3 3,grow");
		textField_4.setColumns(23);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_6, "flowx,cell 3 5");
		
		textField_5 = new JTextField();
		panel_3.add(textField_5, "cell 3 5,grow");
		textField_5.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("F");
		rdbtnNewRadioButton_1.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnNewRadioButton_1, "cell 6 3,grow");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 255, 240));
		panel_5.setBorder(new LineBorder(new Color(107, 142, 35), 5));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("", "[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][200:n:200px,grow][150:n:150]", "[5:n:5][][5:n:5][30:n:30][5:n:5][30:n:30][5:n:5][30:n:30]"));
		
		JLabel lblNewLabel_9 = new JLabel("CEP :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_9, "cell 0 1,alignx trailing");
		
		textField_6 = new JTextField();
		panel_5.add(textField_6, "cell 1 1 2 1,grow");
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnNewButton_1, "cell 3 1 2 1,grow");
		
		JLabel lblNewLabel_10 = new JLabel("Estado :");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_10, "cell 0 3,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		panel_5.add(comboBox_1, "cell 1 3,grow");
		
		JLabel lblNewLabel_11 = new JLabel("Municipio :");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_11, "cell 2 3,alignx center");
		
		textField_8 = new JTextField();
		panel_5.add(textField_8, "cell 3 3,grow");
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Bairro: ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_12, "cell 4 3,alignx trailing,growy");
		
		textField_9 = new JTextField();
		panel_5.add(textField_9, "cell 5 3,grow");
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Rua : ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_13, "cell 6 3,alignx trailing");
		
		textField_10 = new JTextField();
		panel_5.add(textField_10, "cell 7 3,grow");
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("N :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_14, "cell 0 5,alignx trailing");
		
		textField_11 = new JTextField();
		panel_5.add(textField_11, "cell 1 5,grow");
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Complemento :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblNewLabel_15, "cell 2 5,alignx center");
		
		textField_12 = new JTextField();
		panel_5.add(textField_12, "cell 3 5 2 1,grow");
		textField_12.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(btnNewButton_2, "cell 1 7 2 1,grow");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 255, 240));
		panel_6.setBorder(new LineBorder(new Color(85, 107, 47), 4));
		panel_4.add(panel_6, "cell 0 2,grow");
		panel_6.setLayout(new MigLayout("", "[80:n:80][200:n:200,grow][][100px:n:100px][200:n:200,grow][][150:n:150][400:n:400]", "[5:n:5][30:n:30][][270:n:270,grow][5:n:5][30:n:30]"));
		
		JLabel lblNewLabel_16 = new JLabel("CPF :\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_16, "cell 0 1,alignx trailing");
		
		textField_7 = new JTextField();
		panel_6.add(textField_7, "cell 1 1,grow");
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Nome :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_17, "cell 3 1,alignx trailing");
		
		textField_13 = new JTextField();
		panel_6.add(textField_13, "cell 4 1,grow");
		textField_13.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnNewButton_3, "cell 6 1,grow");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_6.add(panel_7, "cell 1 3 7 1,grow");
		
		JButton btnNewButton_4 = new JButton("Editar");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_4, "cell 1 5,grow");
		
		JButton btnNewButton_5 = new JButton("Excluir");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_5, "cell 4 5,grow");
		
		JButton btnNewButton_6 = new JButton("     Voltar       ");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
			
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
							erro += "Sexo Inv??lido";
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
							erro += "Profiss??o Vazia";	
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
				*/
				
			//}

	
			}

		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnNewButton_6, "cell 7 5,alignx trailing,growy");

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
	}

}


