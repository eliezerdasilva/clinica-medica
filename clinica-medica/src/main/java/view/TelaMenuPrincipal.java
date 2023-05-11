package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.Usuario;
import net.miginfocom.swing.MigLayout;



/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
*/
public class TelaMenuPrincipal extends JFrame {

	//Usuario 
	private Usuario usuario;
	private String login;
	private String senha;
	private int nivelAcesso;
	private String verificaNivelAcesso;

	//Logica do menu e do panel de sair
	int d = 0;
	private int menu = 0;
	private int sairPerfil = 0;
	 
	
	//Componetes da tela
	private JPanel paneL;
	private JPanel panelSairPerfil;
	private JLabel lblNewLabel;
	private JButton btnSair;
	private JButton btnPerfil;	
	private JPanel panelMenu;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCadastraPaciente;
	private JButton btnCadastraMedico;
	private JButton btnCadastroFuncionario;
	private JButton btnCadastroConsulta;
	private JPanel panel_10;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_11;
	private JLabel lblNewLabel_1;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnBotaoMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPrincipal frame = new TelaMenuPrincipal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param login 
	 */
	public TelaMenuPrincipal(Usuario usuario) {
		this.login = usuario.getUsuario();
		this.senha = usuario.getSenha();
		this.nivelAcesso = usuario.getNivelAcesso();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1050);
		setMinimumSize(new Dimension(1250, 1000));
		;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));

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

		btnBotaoMenu.setIcon(new ImageIcon("src\\main\\resources\\imagens\\botao-de-menu.png"));
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
		lblNewLabel_1 = new JLabel("Bem vindo : "+usuario.getUsuario()+ "   Seu cargo é "+verificaNivelAcesso);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(btnBotaoMenu)
					.addGap(33)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
					.addGap(1307)
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


		panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		panelMenu.setBackground(new Color(0, 0, 255));
		panelMenu.setBounds(0, 80, 266, 930);
		panelMenu.setForeground(Color.BLACK);
		panelMenu.setLayout(new MigLayout("", "[240:n]", "[][50:n][10:n][50:n][10:n][50:n][10:n][50:n]"));
		contentPane.add(panelMenu);
		panelMenu.setVisible(false);

		lblNewLabel = new JLabel("Cadastar/Consultar");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelMenu.add(lblNewLabel, "cell 0 0,alignx center");

		btnCadastraPaciente = new JButton("Paciente");
		btnCadastraPaciente.setBackground(SystemColor.controlHighlight);
		btnCadastraPaciente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastraPaciente.setBorder(null);
		btnCadastraPaciente.setForeground(Color.BLACK);
		
		panelMenu.add(btnCadastraPaciente, "cell 0 1,grow");

		btnCadastraMedico = new JButton("Médico");
		btnCadastraMedico.setBackground(SystemColor.controlHighlight);
		btnCadastraMedico.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastraMedico.setBorder(null);
		btnCadastraMedico.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TelaCadastroMedico telaFunc = new TelaCadastroMedico(usuario);
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
				dispose();

			}
		});
		panelMenu.add(btnCadastraMedico, "cell 0 3,grow");

		btnCadastroFuncionario = new JButton("Funcionário");
		btnCadastroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastroFuncionario.setBorder(null);
		btnCadastroFuncionario.setBackground(SystemColor.controlHighlight);
		btnCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario telaFunc = new TelaCadastroFuncionario(usuario);
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
				dispose();

			}
		});
		panelMenu.add(btnCadastroFuncionario, "cell 0 5,grow");

		btnCadastroConsulta = new JButton("Consulta");
		btnCadastroConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastroConsulta.setBorder(null);
		btnCadastroConsulta.setBackground(SystemColor.controlHighlight);
		btnCadastroConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agenda agenda = new Agenda(usuario);
				agenda.setLocationRelativeTo(null);
				agenda.setVisible(true);
				dispose();
			}
		});
		panelMenu.add(btnCadastroConsulta, "cell 0 7,grow");

		btnCadastroConsulta.setVisible(true);
		btnCadastroFuncionario.setVisible(true);
		btnCadastraMedico.setVisible(true);
		btnCadastraPaciente.setVisible(true);
		lblNewLabel.setVisible(true);
		btnBotaoMenu.repaint();

		contentPane.add(panelMenu);
		panelMenu.repaint();
		

		panelSairPerfil = new JPanel();
		panelSairPerfil.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		panelSairPerfil.setBackground(new Color(0, 0, 255));
		panelSairPerfil.setBounds(1650, 80, 266, 200);
		panelSairPerfil.setForeground(Color.BLACK);
		panelSairPerfil.setLayout(new MigLayout("", "[240:n]", "[][50:n][10:n][50:n][10:n][50:n][10:n][50:n]"));
		contentPane.add(panelSairPerfil);
		panelSairPerfil.setVisible(false);

		lblNewLabel = new JLabel("Sair");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelSairPerfil.add(lblNewLabel, "cell 0 0,alignx center");

		btnSair = new JButton("Paciente");
		btnSair.setBackground(SystemColor.controlHighlight);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBorder(null);
		btnSair.setForeground(Color.BLACK);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPaciente telaPaciente = new TelaCadastroPaciente(usuario);
				telaPaciente.setLocationRelativeTo(null);
				telaPaciente.setVisible(true);
				dispose();
			}
		});
		panelSairPerfil.add(btnSair, "cell 0 1,grow");

		btnPerfil = new JButton("Médico");
		btnPerfil.setBackground(SystemColor.controlHighlight);
		btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPerfil.setBorder(null);
		btnPerfil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TelaCadastroMedico telaFunc = new TelaCadastroMedico(usuario);
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
				dispose();

			}
		});
		panelSairPerfil.add(btnPerfil, "cell 0 3,grow");
		btnPerfil.setVisible(true);
		btnSair.setVisible(true);
		lblNewLabel.setVisible(true);
		btnBotaoMenu.repaint();

		contentPane.add(panelSairPerfil);
		panelSairPerfil.setVisible(false);

		JPanel panel_3 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 935, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3.setLayout(new CardLayout(0, 0));

		

		panel_2 = new JPanel();
		panel_3.add(panel_2, "name_5152966362900");
		panel_2.setLayout(new MigLayout("", "[100px,grow][802.00,grow][61.00px,grow][383.00px,grow][61px]", "[][::50px,grow][::700,grow][][][][]"));

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 0));
		panel_2.add(panel_4, "cell 1 1,grow");

		panel_5 = new JPanel();
		panel_2.add(panel_5, "cell 1 2,grow");
		panel_5.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 894, 635);
		panel_5.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Cliente", "Servi\u00E7o", "Valor", "Hora", "Data", "Observação" }));

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(128, 255, 255));
		panel_2.add(panel_6, "cell 3 2,grow");
		panel_6.setLayout(new MigLayout("", "[grow]", "[][100px:n:100px,grow][][100px:n:100px,grow][][100px:n:100px,grow][][250:n:250,grow][][100px:n:100px,grow]"));
		
		panel_7 = new JPanel();
		panel_6.add(panel_7, "cell 0 1,grow");
		
		panel_8 = new JPanel();
		panel_6.add(panel_8, "cell 0 3,grow");
		
		panel_9 = new JPanel();
		panel_6.add(panel_9, "cell 0 5,grow");
		
		panel_11 = new JPanel();
		panel_6.add(panel_11, "cell 0 7,grow");
		
		
		contentPane.setLayout(gl_contentPane);
		
	

	}
}
