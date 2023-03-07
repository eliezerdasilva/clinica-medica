package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.EnderecoDao;
import model.Endereco;
import model.Paciente;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;

/**
 * 
 * @author Eliezer da Silva
 * 
 * Classe resposavel por exibir Tela de cadastro de paciente 
 *
 */
public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	Endereco enderecoPronto = null;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JRadioButton rdbtnNewRadioButton;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel lblNewLabel_5;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public TelaCadastroPaciente() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 0,grow");
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel_1.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[20:n:20,grow][75:n:75,grow]"));
		
		panel_5 = new JPanel();
		panel_2.add(panel_5, "cell 0 0,grow");
		panel_5.setLayout(new CardLayout(0, 0));
		
		lblNewLabel = new JLabel("Cadastros Pessoais");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_5.add(lblNewLabel, "name_13133227365500");
		
		panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_6, "cell 0 1,grow");
		panel_6.setLayout(new MigLayout("", "[180:n:180,grow][100:n:100][170:n:170,grow][100px:n:100px][150:n:150][100px:n:100px][100px:n:100px][100px:n:100px][150:n:150,grow][100px:n:100px][150:n:150,grow]", "[][][]"));
		
		lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_6.add(lblNewLabel_1, "cell 0 0");
		
		lblNewLabel_4 = new JLabel("E-mail :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_6.add(lblNewLabel_4, "cell 2 0");
		
		lblNewLabel_2 = new JLabel("Cpf :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_6.add(lblNewLabel_2, "cell 4 0");
		
		lblNewLabel_3 = new JLabel("Sexo :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_6.add(lblNewLabel_3, "cell 6 0");
		
		lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_6.add(lblNewLabel_5, "cell 8 0");
		
		lblNewLabel_6 = new JLabel("Data Nascimento");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_6.add(lblNewLabel_6, "cell 10 0");
		
		textField = new JTextField();
		panel_6.add(textField, "cell 0 1,grow");
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		panel_6.add(textField_2, "cell 2 1,growx");
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1, "cell 4 1,growx");
		textField_1.setColumns(10);
		
		rdbtnNewRadioButton_1 = new JRadioButton("M");
		panel_6.add(rdbtnNewRadioButton_1, "flowx,cell 6 1,growx");
		
		rdbtnNewRadioButton = new JRadioButton("F");
		panel_6.add(rdbtnNewRadioButton, "cell 6 1,growx");
		
		textField_3 = new JTextField();
		panel_6.add(textField_3, "cell 8 1,growx");
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		panel_6.add(textField_5, "cell 10 1,growx");
		textField_5.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel_1.add(panel_3, "cell 0 1,grow");
		
		panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel_1.add(panel_4, "cell 0 2,grow");
	}
}
