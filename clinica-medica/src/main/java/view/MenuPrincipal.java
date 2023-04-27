package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String usuario;
	private String senha;

	public MenuPrincipal(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha; 
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Tela Menu Principal");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/logo.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}
		setExtendedState(MAXIMIZED_BOTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(0, 4, 4, 4, (Color) new Color(0, 0, 0)));
		setBounds(100, 100, 2000, 1050);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 128, 128));
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		menuBar.setFont(new Font("Verdana", Font.BOLD, 17));
		menuBar.setMargin(new Insets(10, 100, 10, 10));
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("                                                              Cadastro");

		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setPreferredSize(new Dimension(470, 40));
		mnNewMenu.setBorder(new MatteBorder(4, 4, 4, 2, (Color) new Color(0, 0, 0)));
		mnNewMenu.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Funcionario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario telaFunc = new TelaCadastroFuncionario(usuario, senha);
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
				dispose();

			}
		});
		mntmNewMenuItem_1.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem_1.setBorder(new MatteBorder(4, 4, 2, 4, (Color) new Color(0, 0, 0)));

		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Paciente");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPaciente telaPaciente = new TelaCadastroPaciente(usuario, senha);
				telaPaciente.setLocationRelativeTo(null);
				telaPaciente.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_3.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem_3.setBorder(new MatteBorder(2, 4, 2, 4, (Color) new Color(0, 0, 0)));
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Médico");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroMedico telaFunc = new TelaCadastroMedico(usuario, senha);
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
				dispose();

			}
		});
		mntmNewMenuItem_2.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem_2.setBorder(new MatteBorder(2, 4, 4, 4, (Color) new Color(0, 0, 0)));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("                                                           Agendar");
		mnNewMenu_1.setBackground(new Color(0, 128, 0));
		mnNewMenu_1.setForeground(Color.BLACK);

		mnNewMenu_1.setBorder(new MatteBorder(4, 2, 4, 2, (Color) new Color(0, 0, 0)));
		mnNewMenu_1.setPreferredSize(new Dimension(470, 40));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agenda agenda = new Agenda(usuario, senha);
				agenda.setLocationRelativeTo(null);
				agenda.setVisible(true);
				dispose();
			}
		});

		mntmNewMenuItem.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem.setBorder(new MatteBorder(4, 4, 2, 4, (Color) new Color(0, 0, 0)));

		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu mnNewMenu_2 = new JMenu("                                                Consultar dados");
		mnNewMenu_2.setForeground(Color.BLACK);
		mnNewMenu_2.setBorder(new MatteBorder(4, 2, 4, 2, (Color) new Color(0, 0, 0)));
		mnNewMenu_2.setPreferredSize(new Dimension(470, 40));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Tabela Funcionario");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTabela telaTabela = new TelaTabela(usuario, senha);
				telaTabela.setLocationRelativeTo(null);
				telaTabela.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_7.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem_7.setBorder(new MatteBorder(4, 4, 2, 4, (Color) new Color(0, 0, 0)));
		mnNewMenu_2.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Tabela Médico");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTabela telaTabela = new TelaTabela(usuario, senha);
				telaTabela.setLocationRelativeTo(null);
				telaTabela.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_6.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem_6.setBorder(new MatteBorder(4, 4, 2, 4, (Color) new Color(0, 0, 0)));
		mnNewMenu_2.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Tabela Usuário");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTabela telaTabela = new TelaTabela(usuario, senha);
				telaTabela.setLocationRelativeTo(null);
				telaTabela.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_8.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem_8.setBorder(new MatteBorder(4, 4, 2, 4, (Color) new Color(0, 0, 0)));
		mnNewMenu_2.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_3 = new JMenu("                                                 Configuração\r\n");
		mnNewMenu_3.setForeground(Color.BLACK);
		mnNewMenu_3.setBorder(new MatteBorder(4, 3, 4, 4, (Color) new Color(0, 0, 0)));

		mnNewMenu_3.setPreferredSize(new Dimension(470, 40));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Sair");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int n = JOptionPane.showConfirmDialog(  
			                null,
			                "Tem certeza que quer sair?  "+usuario,
			                "",
			                JOptionPane.YES_NO_OPTION);

			      if(n == JOptionPane.YES_OPTION)
			      {
			          JOptionPane.showMessageDialog(null, "Saindo...");
			          dispose();
			      }
			      
			      
			        
			}
		});
		mntmNewMenuItem_5.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem_5.setBorder(new MatteBorder(4, 4, 2, 4, (Color) new Color(0, 0, 0)));
		mnNewMenu_3.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Perfil");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPerfil telaPerfil = new TelaPerfil(usuario, senha);
				telaPerfil.setLocationRelativeTo(null);
				telaPerfil.setVisible(true);
				dispose();

			}
		});
		mntmNewMenuItem_4.setPreferredSize(new Dimension(470, 40));
		mntmNewMenuItem_4.setBorder(new MatteBorder(4, 4, 2, 4, (Color) new Color(0, 0, 0)));
		mnNewMenu_3.add(mntmNewMenuItem_4);

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));


		JPanel panel = new JPanel();
		contentPane.add(panel, "name_432207963291300");
		panel.setLayout(new MigLayout("", "[100px,grow][802.00,grow][61.00px,grow][383.00px,grow][61px]", "[][::50px,grow][::700,grow][][]"));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel.add(panel_2, "cell 1 1,grow");
		panel_2.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Consultas do dia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		panel_2.add(lblNewLabel, "name_433992018899300");

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "cell 1 2,grow");
		panel_4.setLayout(new CardLayout(0, 0));
		panel_4.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(201, 362, 619, 197);
		panel_4.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "Cliente", "Servi\u00E7o", "Valor", "Hora", "Data", "Observacao" }));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.add(panel_5, "cell 3 2,grow");
		panel_5.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][][][]"));

		JLabel lblNewLabel_1 = new JLabel("Cadastrados");
		panel_5.add(lblNewLabel_1, "cell 1 1");

		JLabel lblNewLabel_2 = new JLabel("Total de consulta / /");
		panel_5.add(lblNewLabel_2, "cell 1 3");

		JLabel lblNewLabel_3 = new JLabel("");
		panel_5.add(lblNewLabel_3, "cell 1 5");
		
		JLabel lblNewLabel_4 = new JLabel("Usuário : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel_4, "flowx,cell 3 4,alignx center");
		
		JLabel lblUsuario = new JLabel(usuario);
		panel.add(lblUsuario, "cell 3 4");

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
