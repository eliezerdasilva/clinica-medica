package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.event.MenuListener;

import controler.MenuPrincipalController;

import javax.swing.event.MenuEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private MenuPrincipalController controller;

	public MenuPrincipal() {
		this.controller = new MenuPrincipalController(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 454, 22);
		contentPane.add(menuBar);
		
		JMenu MenuCadastro = new JMenu("Cadastro");
		MenuCadastro.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(MenuCadastro);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\frete\\eclipse-workspace\\Clinica_Java\\src\\view_Imagens_icons\\cliente (1).png"));
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		MenuCadastro.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Serviço");
		mntmNewMenuItem_1.setBackground(SystemColor.menuText);
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\frete\\eclipse-workspace\\Clinica_Java\\src\\view_Imagens_icons\\servico.png"));
		MenuCadastro.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Operação");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agenda");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.navegarParaAgenda();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
	}
}
