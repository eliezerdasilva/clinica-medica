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

import model.Usuario;
import javax.swing.JLabel;


public class MenuPrincipal extends JFrame {

	private JPanel contentPane;


	public MenuPrincipal(Usuario login) {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 478, 22);
		contentPane.add(menuBar);
		
		JMenu MenuCadastro = new JMenu("Cadastro");
		MenuCadastro.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(MenuCadastro);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Paciente");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPaciente telaCadastroPaciente = new TelaCadastroPaciente();
				telaCadastroPaciente.setLocationRelativeTo(null);
				telaCadastroPaciente.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_1.setBackground(SystemColor.menuText);
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\frete\\eclipse-workspace\\Clinica_Java\\src\\view_Imagens_icons\\servico.png"));
		MenuCadastro.add(mntmNewMenuItem_1);
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Médico");
		MenuCadastro.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Funcinario");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		MenuCadastro.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu = new JMenu("Edições e Alterações");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Editar Funcionario");
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Editar Médico");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Editar paciente ");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Agendamento");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agendar Consulta");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Consulta Dados");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Consultar Médicos");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Consultar pacientes");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("Configurações");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Exit");
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setBounds(251, 247, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(login.getUsuario());
		lblNewLabel_1.setBounds(331, 247, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dia :");
		lblNewLabel_2.setBounds(10, 48, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mês :");
		lblNewLabel_3.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ano :");
		lblNewLabel_4.setBounds(10, 98, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hora :");
		lblNewLabel_5.setBounds(10, 123, 46, 14);
		contentPane.add(lblNewLabel_5);
		
	}
}
