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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import model.Consulta;
import model.Paciente;

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
	private String usuario;
	private String senha;
	
	

	
	public Agenda(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha; 
		setMinimumSize(new Dimension(1250, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Agendar");

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
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(294)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(305))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(new MigLayout("", "[1300:n:1300,grow]", "[900:n:900,grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 6));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(51, 153, 0)));
		panel_2.setBackground(new Color(51, 153, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
		
		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 50));
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(236, 253, 232));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new MigLayout("", "[933.00,grow][]", "[20:n:20][35:n:35][][35:n:35][][35:n:35][][350:n:350,grow][35px:n:35px]"));
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_2, "flowx,cell 0 1,alignx right");
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(255, 255, 255));
		panel_3.add(txtNome, "cell 0 1,grow");
		txtNome.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("   CPF:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_3, "cell 0 1,alignx right");
		
		textCpf = new JTextField();
		panel_3.add(textCpf, "cell 0 1,grow");
		textCpf.setColumns(20);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel_3.add(horizontalStrut, "cell 0 1");
		
		JButton btnBuscar = new JButton("    Buscar  ");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnBuscar, "cell 0 1,grow");
		
		JLabel lblNewLabel_4 = new JLabel("Médico:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_4, "flowx,cell 0 3,alignx right");
		
		JLabel lblNewLabel_7 = new JLabel("Observação\r\n:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_7, "flowx,cell 0 5,alignx right");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(236, 253, 232));
		panel_4.setBorder(new LineBorder(new Color(51, 153, 0), 2));
		panel_3.add(panel_4, "cell 0 7,grow");
		panel_4.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 1077, 329);
		panel_4.add(table);
		
		JButton btnEditar = new JButton("Editar ");
		btnEditar.setBackground(new Color(240, 255, 240));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnEditar, "flowx,cell 0 8,grow");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_2, "cell 0 8");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(240, 240, 240));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnExcluir, "cell 0 8,grow");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(400);
		panel_3.add(horizontalStrut_1, "cell 0 8");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(240, 255, 240));
		btnVoltar.setForeground(new Color(0, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal(usuario, senha);
				mp.setLocationRelativeTo(null);
				mp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnVoltar, "cell 0 8,grow");
		
		JComboBox cbxMedico = new JComboBox();
		cbxMedico.setModel(new DefaultComboBoxModel(new String[] {"                                             "}));
		panel_3.add(cbxMedico, "cell 0 3,growy");
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de Consulta:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel_3.add(lblNewLabel_5, "cell 0 3,alignx right");
		
		textConsulta = new JTextField();
		panel_3.add(textConsulta, "cell 0 3,grow");
		textConsulta.setColumns(20);
		
		JLabel lblNewLabel_6 = new JLabel("Data: ");
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
				String nome = txtNome.getText();
				
				String cpf = textCpf.getText().replace(".", "").replace("-", "");
				
				String tipoConsulta = textConsulta.getText();
				
				String dataConsulta = textData.getText();
				System.out.println(dataConsulta);
				
				String observacao = textObservacao.getText();
				
				String validacao = "";
				Consulta c = new Consulta();
				Paciente p = new Paciente();
				
				if (nome == null || nome.trim() == "" || nome.isEmpty()) {
					txtNome.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					validacao += "Nome\n";
				} else {
					p.setNome(nome);
				}
				
				if (cpf == null || cpf.trim()== "" || cpf.isEmpty()) {
					textCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					validacao += "CPF\n";
				} else {
					Long cpfLong = Long.valueOf(cpf);
					p.setCpf(cpfLong);
				}
				c.setPaciente(p);
				
				if (tipoConsulta == null || tipoConsulta.trim()=="" || tipoConsulta.isEmpty()) {
					textConsulta.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					validacao += "Tipo consulta\n";
				} else {
					c.setServico(tipoConsulta);
				}
				
				if (dataConsulta == null || dataConsulta.trim()==""|| dataConsulta.isEmpty()) {
					textData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					validacao += "Dat\n";
				} else {
					String dataTest = dataConsulta.replace("/", "").trim();
					if (dataTest.length() == 0) {
						// TODO erro
						System.out.println("Erro");
						textData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate dta = LocalDate.parse(dataConsulta, formatter);
						dta.format(formatter);
						c.setDate(dta);
					}
				}
				
			}
		});
		btnCadastrar.setBackground(new Color(240, 255, 240));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(btnCadastrar, "cell 0 5,grow");
		contentPane.setLayout(gl_contentPane);
		
		

	}
}
