package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;


import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.Box;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textCpf;
	private JTable table;
	private JTextField textConsulta;
	private JTextField textData;
	private JTextField textObservacao;
	
	

	
	public Agenda() {
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Tela de Cadastro de Consulta");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/logo.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1906, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
		);
		panel.setLayout(new MigLayout("", "[331.00][1286.00,grow][299.00]", "[800:n:800,grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(60, 179, 113));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
		
		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 50));
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(152, 251, 152));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new MigLayout("", "[933.00,grow][]", "[20:n:20][35:n:35][][35:n:35][][35:n:35][][350:n:350,grow][35px:n:35px]"));
		
		JLabel lblNewLabel_2 = new JLabel("Nome : ");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_2, "flowx,cell 0 1");
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(255, 255, 255));
		panel_3.add(txtNome, "cell 0 1,grow");
		txtNome.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("   CPF :    ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_3, "cell 0 1");
		
		textCpf = new JTextField();
		panel_3.add(textCpf, "cell 0 1,grow");
		textCpf.setColumns(20);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel_3.add(horizontalStrut, "cell 0 1");
		
		JButton btnBuscar = new JButton("    Buscar  ");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnBuscar, "cell 0 1,grow");
		
		JLabel lblNewLabel_4 = new JLabel("Médico :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_4, "flowx,cell 0 3");
		
		JLabel lblNewLabel_7 = new JLabel("Observação\r\n");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_7, "flowx,cell 0 5");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.add(panel_4, "cell 0 7,grow");
		panel_4.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 1077, 329);
		panel_4.add(table);
		
		JButton btnEditar = new JButton("Editar ");
		btnEditar.setBackground(new Color(240, 255, 240));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnEditar, "flowx,cell 0 8,grow");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_2, "cell 0 8");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(240, 240, 240));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnExcluir, "cell 0 8,grow");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(400);
		panel_3.add(horizontalStrut_1, "cell 0 8");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(240, 255, 240));
		btnVoltar.setForeground(new Color(0, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnVoltar, "cell 0 8,grow");
		
		JComboBox cbxMedico = new JComboBox();
		cbxMedico.setModel(new DefaultComboBoxModel(new String[] {"                                               "}));
		panel_3.add(cbxMedico, "cell 0 3,growy");
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de Consulta : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel_3.add(lblNewLabel_5, "cell 0 3");
		
		textConsulta = new JTextField();
		panel_3.add(textConsulta, "cell 0 3,grow");
		textConsulta.setColumns(20);
		
		JLabel lblNewLabel_6 = new JLabel("Data : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_6, "cell 0 3");
		
		textData = new JTextField();
		panel_3.add(textData, "cell 0 3,grow");
		textData.setColumns(15);
		
		textObservacao = new JTextField();
		panel_3.add(textObservacao, "cell 0 5,grow");
		textObservacao.setColumns(25);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_3, "cell 0 5");
		
		JButton btnCadastrar = new JButton("         Cadastrar            ");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBackground(new Color(240, 255, 240));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnCadastrar, "cell 0 5,grow");
		contentPane.setLayout(gl_contentPane);
		
		

	}
}
