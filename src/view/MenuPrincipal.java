package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controler.MenuPrincipalController;
import controler.TelaCadastroFuncionarioController;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private MenuPrincipalController controller;
	private TelaCadastroFuncionarioController telaCadastroFuncionarioController;

	public MenuPrincipal() {
		telaCadastroFuncionarioController = new TelaCadastroFuncionarioController(this);
		setExtendedState(MAXIMIZED_BOTH);
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Paciente");
		mntmNewMenuItem_1.setBackground(SystemColor.menuText);
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\frete\\eclipse-workspace\\Clinica_Java\\src\\view_Imagens_icons\\servico.png"));
		MenuCadastro.add(mntmNewMenuItem_1);
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Médico");
		MenuCadastro.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Funcinario");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadastroFuncionarioController.navegarParaCadastroFuncionario();
				telaCadastroFuncionarioController.fecharMenuCadastro();
			}
		});
		MenuCadastro.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu = new JMenu("Operação");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agenda");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.navegarParaAgenda();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
	}
}
