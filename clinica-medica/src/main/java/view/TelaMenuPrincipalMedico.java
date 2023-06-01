package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AgendaDao;
import model.Consulta;
import model.Paciente;
import model.Usuario;

public class TelaMenuPrincipalMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String login;
	private String senha;
	private int nivelAcesso;
	private JTable table;
	private ArrayList<Consulta> listConulta;
	private Consulta consulta;
	private AgendaDao agendaDao;



	public TelaMenuPrincipalMedico(Usuario login) {
		this.login = login.getUsuario();
		this.senha = login.getSenha();
		this.nivelAcesso = login.getNivelAcesso();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1900, 400));
		setBounds(100, 100, 2000, 1050);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Menu principal");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/LocoHospital.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(209, 234, 198));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		
		JLabel lblNewLabel_1 = new JLabel("Bem vindo : <dynamic>                Seu cargo é : null");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnLoginSair = new JButton("");
		btnLoginSair.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(73)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)
					.addGap(888)
					.addComponent(btnLoginSair))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(btnLoginSair, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF","Data" ,"Hora"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_1_1 = new JPanel();
		
		JPanel panel_1_2 = new JPanel();
		
		JPanel panel_1_3 = new JPanel();
		
		JPanel panel_1_4 = new JPanel();
		
		JPanel panel_1_5 = new JPanel();
		
		JPanel panel_1_6 = new JPanel();
		
		JPanel panel_1_7 = new JPanel();
		
		JButton btnNewButton = new JButton("Atender");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JSplitPane splitPane = new JSplitPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1904, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(210)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
									.addGap(291)
									.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 693, GroupLayout.PREFERRED_SIZE)
									.addGap(106)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1_4, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1_6, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))
									.addGap(41)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_1_5, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1_7, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1_3, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_1_4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_1_3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_1_5, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1_6, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_7, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(242, Short.MAX_VALUE))
		);
		
		JButton btnNewButton_1 = new JButton("Semana");
		splitPane.setLeftComponent(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("    Dia     ");
		splitPane.setRightComponent(btnNewButton_2);
		panel_1_7.setLayout(null);
		panel_1_5.setLayout(null);
		panel_1_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Total de horas para ser atendidas : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(24, 0, 317, 130);
		panel_1_3.add(lblNewLabel_6);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Total de consulta(semana)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(21, 0, 234, 130);
		panel_1_1.add(lblNewLabel_5);
		panel_1_6.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Total  de consulta(dia) :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(26, 0, 285, 130);
		panel_1_6.add(lblNewLabel_4);
		panel_1_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Vila de espera : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(29, 0, 171, 130);
		panel_1_4.add(lblNewLabel_3);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Faltantes : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(31, 0, 218, 130);
		panel_1_2.add(lblNewLabel_2);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente atendidos : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(26, 0, 188, 130);
		panel_1.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}
	private void atualizarTabelaDia() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF","Data" ,"Hora" });
		listConulta = new ArrayList<>();
		agendaDao = new AgendaDao();
		consulta = new Consulta();
		listConulta = agendaDao.consultarCosultaDia();
		for (int i = 0; i < listConulta.size(); i++) {
			Consulta consulta = listConulta.get(i);
			tabela.addRow(new Object[] { consulta.getPaciente().getNome(), consulta.getPaciente().getCpf(), consulta.getDate(),consulta.getHora() });

		}
		table.setModel(tabela);
	}
}
