package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				"Nome", "CPF", "Hora"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_1_1 = new JPanel();
		
		JPanel panel_1_2 = new JPanel();
		
		JSplitPane splitPane = new JSplitPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1904, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(210)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 693, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE))
							.addGap(402))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(658)
							.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane))
					.addGap(25)
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addGap(314))
		);
		
		JButton btnNewButton = new JButton("Dia");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(SystemColor.controlHighlight);
		
		splitPane.setLeftComponent(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mês");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		splitPane.setRightComponent(btnNewButton_1);
		contentPane.setLayout(gl_contentPane);
	}
}
