package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Eliezer da Silva
 * 
 *         Classe resposavel por exibir Tela de cadastro de paciente
 *
 */
public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	Endereco enderecoPronto = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1500, 400));
		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		BufferedImage bg = null;
		try {
			bg = ImageIO.read(new File("src/imagens/fundoLogin.jpeg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel = new FundoImagemLogin(bg);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow]", "[40:n:40][35:n:35,grow][][2:n:2][30:n:30,grow][90:n:90,grow][][30:n:30,grow][80:n:80,grow][2:n:2][45:n:45][2:n:2][30:n:30,grow][60:n:60,grow][][25:n:25,grow][60:n:60,grow][50:n:50][60:n:60,grow][150:n:150][35:n:35]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(panel_1, "cell 0 1,grow");
		
		JLabel lblNewLabel = new JLabel("Cadastro Pessoal ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(192, 192, 192));
		panel_6.setBorder(new MatteBorder(4, 4, 0, 4, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel.add(panel_6, "cell 0 4,grow");
		
		JLabel lblNewLabel_1 = new JLabel("    Dados ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_6.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "cell 0 5,grow");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("       Nome  :     ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setText("");
		panel_4.add(textField);
		textField.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("   Cpf :  ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(20);
		
		JLabel lblNewLabel_4 = new JLabel("   E-mail :   ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(25);
		
		JLabel lblNewLabel_5 = new JLabel("  Telefone :  ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		panel_4.add(textField_3);
		textField_3.setColumns(20);
		
		JLabel lblNewLabel_6 = new JLabel("   Sexo :   ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_6);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("  F   ");
		panel_4.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("  M  ");
		panel_4.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("      Convênio :      ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"                                           "}));
		panel_4.add(comboBox);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(100);
		panel_4.add(horizontalStrut_4);
		
		JLabel lblNewLabel_8 = new JLabel("       Data Nascimento :    ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		panel_4.add(textField_4);
		textField_4.setColumns(15);
		
		JLabel lblNewLabel_18 = new JLabel("    Profissão :    ");
		panel_4.add(lblNewLabel_18);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_11 = new JTextField();
		panel_4.add(textField_11);
		textField_11.setColumns(20);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBorder(new MatteBorder(4, 4, 0, 4, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_5, "cell 0 7,grow");
		
		JLabel lblNewLabel_9 = new JLabel("     Endereço ");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblNewLabel_9);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(panel_3, "cell 0 8,grow");
		
		JLabel lblNewLabel_10 = new JLabel("      Cep :           ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_10);
		
		textField_5 = new JTextField();
		textField_5.setText("");
		panel_3.add(textField_5);
		textField_5.setColumns(17);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(30);
		panel_3.add(horizontalStrut_1);
		
		JButton btnNewButton = new JButton("       Buscar Cep         ");
		btnNewButton.setBackground(new Color(255, 255, 255));
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("    Estado    :    ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_11);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"                                                       "}));
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel_12 = new JLabel("     Municipio :      ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_12);
		
		textField_6 = new JTextField();
		panel_3.add(textField_6);
		textField_6.setColumns(20);
		
		JLabel lblNewLabel_13 = new JLabel("   Bairro   :    ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_13);
		
		textField_7 = new JTextField();
		panel_3.add(textField_7);
		textField_7.setColumns(20);
		
		JLabel lblNewLabel_14 = new JLabel("     Rua :     ");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_14);
		
		textField_8 = new JTextField();
		panel_3.add(textField_8);
		textField_8.setColumns(25);
		
		JButton btnNewButton_1 = new JButton("Cadastrar endereço ");
		btnNewButton_1.setBackground(new Color(119, 136, 153));
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(64, 128, 128));
		panel.add(btnNewButton_1, "flowx,cell 0 10,grow");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		panel_7.setBorder(new MatteBorder(4, 4, 0, 4, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setVgap(10);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel.add(panel_7, "cell 0 12,grow");
		
		JLabel lblNewLabel_15 = new JLabel("       Dados pessoais : ");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.LEFT);
		panel_7.add(lblNewLabel_15);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_5 = (FlowLayout) panel_8.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(panel_8, "cell 0 13,grow");
		
		JLabel lblNewLabel_16 = new JLabel("       N Casa :       ");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_8.add(lblNewLabel_16);
		
		textField_9 = new JTextField();
		panel_8.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("    Complemento :           ");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_8.add(lblNewLabel_17);
		
		textField_10 = new JTextField();
		panel_8.add(textField_10);
		textField_10.setColumns(35);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(192, 192, 192));
		panel_9.setBorder(new MatteBorder(4, 4, 0, 4, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout_6 = (FlowLayout) panel_9.getLayout();
		flowLayout_6.setVgap(10);
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel.add(panel_9, "cell 0 15,grow");
		
		JLabel lblNewLabel_19 = new JLabel("     Responsavel :   ");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_9.add(lblNewLabel_19);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		FlowLayout flowLayout_7 = (FlowLayout) panel_10.getLayout();
		flowLayout_7.setHgap(10);
		flowLayout_7.setVgap(25);
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel.add(panel_10, "cell 0 16,grow");
		
		JLabel lblNewLabel_20 = new JLabel("       Nome :    ");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_10.add(lblNewLabel_20);
		
		textField_12 = new JTextField();
		panel_10.add(textField_12);
		textField_12.setColumns(25);
		
		JLabel lblNewLabel_21 = new JLabel("     Cpf :      ");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_10.add(lblNewLabel_21);
		
		textField_13 = new JTextField();
		panel_10.add(textField_13);
		textField_13.setColumns(20);
		
		JButton btnNewButton_2 = new JButton("Cadastar");
		btnNewButton_2.setBackground(new Color(119, 136, 153));
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setSize(100, 50);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_2, "flowx,cell 0 18,grow");
		
		Component horizontalStrut = Box.createHorizontalStrut(100);
		panel.add(horizontalStrut, "cell 0 18");
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(119, 136, 153));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(btnNewButton_3, "cell 0 18,grow");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(500);
		panel.add(horizontalStrut_3, "cell 0 18");
		
		JButton btnNewButton_4 = new JButton("Voltar Para tela de Menu ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBackground(new Color(119, 136, 153));
		btnNewButton_4.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(btnNewButton_4, "flowx,cell 0 20,grow");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(1300);
		panel.add(horizontalStrut_2, "cell 0 20");
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(1250);
		panel.add(horizontalStrut_5, "cell 0 10");
	}
}


