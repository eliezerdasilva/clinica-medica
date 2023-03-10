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
public class TelaCadastroFuncionario extends JFrame {
	private JPanel contentPane;
	Endereco enderecoPronto = null;
	private JTextField txtNomw;
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
	
	

	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario() {
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

		JLabel lblNewLabel = new JLabel("Cadastro Funcion??rio"); 
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[1280:n:1280,grow]", "[150:n:150px,grow][160:n:160,grow][100:n:100,grow][330:n:330,grow]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(107, 142, 35), 4));
		panel_3.setBackground(new Color(240, 255, 240));
		panel_4.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[][300:n:300,grow][][300:n:300][][][150:n:150,grow]", "[][30:n:30][][30:n:30][][30:n:30][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_1, "cell 0 1,alignx center,growy");
		
		txtNomw = new JTextField();
		panel_3.add(txtNomw, "cell 1 1,grow");
		txtNomw.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_4, "flowx,cell 3 1,growx");
		
		JLabel lblNewLabel_7 = new JLabel("Conv??nio :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_7, "cell 5 1,alignx trailing");
		
		JComboBox cbxConvenio = new JComboBox();
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		rdbtnNewRadioButton.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnNewRadioButton, "flowx,cell 6 3,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Profiss??o :");
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
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("F");
		rdbtnNewRadioButton_1.setBackground(new Color(240, 255, 240));
		panel_3.add(rdbtnNewRadioButton_1, "cell 6 3,grow");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 255, 240));
		panel_5.setBorder(new LineBorder(new Color(107, 142, 35), 5));
		panel_4.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("", "[80:n:80][150:n:150,grow][150:n:150][150:n:150,grow][100:n:100][180:n:180,grow][70:n:70][200:n:200px,grow][150:n:150]", "[5:n:5][][5:n:5][30:n:30][5:n:5][30:n:30][5:n:5]"));
		
		JLabel lblNewLabel_9 = new JLabel("CEP :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_9, "cell 0 1,alignx trailing");
		
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
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Administrador");
		rdbtnNewRadioButton_2.setBackground(new Color(240, 255, 240));
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_9.add(rdbtnNewRadioButton_2, "cell 5 1");
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Funcionario");
		rdbtnNewRadioButton_3.setBackground(new Color(240, 255, 240));
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(rdbtnNewRadioButton_3, "cell 6 1");
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar Novo M??dico ");
		btnCadastrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(btnCadastrarUsuario, "cell 8 1,grow");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 255, 240));
		panel_6.setBorder(new LineBorder(new Color(85, 107, 47), 4));
		panel_4.add(panel_6, "cell 0 3,grow");
		panel_6.setLayout(new MigLayout("", "[80:n:80][200:n:200,grow][][100:n:100][200:n:200,grow][][220:n:220][350:n:350]", "[30:n:30][30:n:30][][180:n:180,grow][5:n:5][30:n:30]"));
		
		JLabel lblNewLabel_22 = new JLabel("Editar");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_22, "cell 0 0 8 1,alignx center");
		
		JLabel lblNewLabel_16 = new JLabel("CPF :\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_16, "cell 0 1,alignx trailing");
		
		txtBuscarCpf = new JTextField();
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
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(btnVoltar, "cell 7 5,alignx trailing,growy");

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


