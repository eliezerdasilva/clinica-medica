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

public class TelaMenu extends JFrame {

	private JPanel contentPane;

	//Login
	private String login;
	private String senha;
	private int nivelAcesso;
	private Usuario usuario;

	//Barra superior 
	private JPanel panel;
	private JButton btnBotaoMenu;
	
	
	//Menu lateral
	private int menu;
	private JPanel panelMenu;

	//Menu sair perfil
	private int sairPerfil;
	private JComponent panelSairPerfil;

	//verificar acesso 
	private String verificaNivelAcesso;

	private JLabel lblNewLabel_1;
	
	

	

	public TelaMenu (Usuario usuario) {
		this.login = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.nivelAcesso = usuario.getNivelAcesso();
		
		
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
		
		
		;


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
		
	
		
	}

}
