package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import model.Usuario;

public class Tela extends JFrame {

	private JPanel contentPane;
	
	//Usuari
	private Usuario usuario;
	private String login;
	private String senha;
	private int nivelAcesso;
	private String verificaNivelAcesso;

	//Barra superior
	private JPanel panel;
	private JButton btnBotaoMenu;
	private JButton panelMenu;
	
	//Logica menus
	private int menu;
	private int sairPerfil;
	
	
	private JLabel lblNewLabel_1;
	

	//menu sair
	private JPanel panelSairPerfil;


	public Tela() {
		
		this.login = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.nivelAcesso = usuario.getNivelAcesso();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));

		btnBotaoMenu = new JButton("");
		btnBotaoMenu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnBotaoMenu.setBackground(new Color(102, 204, 255));
			}
		});
		btnBotaoMenu.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				btnBotaoMenu.setBackground(new Color(255, 255, 255));
			}
		});

		btnBotaoMenu.addActionListener(new ActionListener() {

			

			public void actionPerformed(ActionEvent e) {
				if (menu == 0) {
					menu++;
					panelMenu.setVisible(true);
				} else {
					panelMenu.setVisible(false);
					menu = 0;
				}

			}
		});

		btnBotaoMenu.setIcon(new ImageIcon("src\\main\\resources\\imagens\\Logo.png"));
		btnBotaoMenu.setBackground(Color.white);
		
		JButton btnLoginSair = new JButton("");
		btnLoginSair.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
				if (sairPerfil == 0) {
					sairPerfil=1;
					panelSairPerfil.setVisible(true);
				} else {
					panelSairPerfil.setVisible(false);
					sairPerfil = 0;
				}

			}
		});
		btnLoginSair.setIcon(new ImageIcon("src\\main\\resources\\imagens\\login.png"));
		btnLoginSair.setBackground(Color.white);
		
		if(nivelAcesso==0) {
			verificaNivelAcesso = "Administrador";
		}else {
			if(nivelAcesso==1) {
				verificaNivelAcesso = "Médico";
			}else {
				verificaNivelAcesso= "Funcionário";
			}
		}
		lblNewLabel_1 = new JLabel("Bem vindo : "+usuario.getUsuario()+"                Seu cargo é : "+verificaNivelAcesso);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(btnBotaoMenu)
					.addGap(33)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)
					.addGap(888)
					.addComponent(btnLoginSair))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBotaoMenu, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoginSair, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
		
		
		
		
	}

}
