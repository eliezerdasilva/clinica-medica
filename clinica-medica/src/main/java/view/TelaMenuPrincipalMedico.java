package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
*/
public class TelaMenuPrincipalMedico extends JFrame {

	private JPanel contentPane;
	private JButton btnBotaoMenu;
	private JPanel panel_1;
	int d = 0;
	private JPanel panel;
	private JPanel panel2;
	private JLabel lblNewLabel;
	private JButton btnCadastraPaciente;
	private JButton btnCadastraMedico;
	private JButton btnCadastroConsulta;
	private JButton btnCadastroFuncionario;
	private JPanel panelSair;
	private JButton btnPerfil;
	private JButton btnSair;
	private int menu = 0; 
	private int sairPerfil = 0 ;
	private String usuario;
	private String senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPrincipalMedico frame = new TelaMenuPrincipalMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaMenuPrincipalMedico() {
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
					menu = 1; 
					panel2 = new JPanel();
					panel2.setBorder(new LineBorder(new Color(255, 255, 255), 4));
					panel2.setBackground(new Color(0, 0, 255));
					panel2.setBounds(0, 68, 266, 930);
					panel2.setForeground(Color.BLACK);
					panel2.setLayout(new MigLayout("", "[240:n]", "[][50:n][10:n][50:n][10:n][50:n][10:n][50:n]"));
					contentPane.add(panel2);
					panel2.setVisible(false);
					
					
					
					lblNewLabel = new JLabel("Cadastar/Consultar");
					lblNewLabel.setForeground(SystemColor.window);
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel2.add(lblNewLabel, "cell 0 0,alignx center");
					
				

					btnCadastraPaciente = new JButton("Paciente");
					btnCadastraPaciente.setBackground(SystemColor.controlHighlight);
					btnCadastraPaciente.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnCadastraPaciente.setBorder(null);
					btnCadastraPaciente.setForeground(Color.BLACK);
					btnCadastraPaciente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							TelaCadastroPaciente telaPaciente = new TelaCadastroPaciente(usuario, senha);
							telaPaciente.setLocationRelativeTo(null);
							telaPaciente.setVisible(true);
							dispose();
						}
					});
					panel2.add(btnCadastraPaciente, "cell 0 1,grow");

					btnCadastraMedico = new JButton("Médico");
					btnCadastraMedico.setBackground(SystemColor.controlHighlight);
					btnCadastraMedico.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnCadastraMedico.setBorder(null);
					btnCadastraMedico.addActionListener(new ActionListener() {
						

						public void actionPerformed(ActionEvent e) {
							TelaCadastroMedico telaFunc = new TelaCadastroMedico(usuario, senha);
							telaFunc.setLocationRelativeTo(null);
							telaFunc.setVisible(true);
							dispose();

						}
					});
					panel2.add(btnCadastraMedico, "cell 0 3,grow");

					btnCadastroFuncionario = new JButton("Funcionário");
					btnCadastroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnCadastroFuncionario.setBorder(null);
					btnCadastroFuncionario.setBackground(SystemColor.controlHighlight);
					btnCadastroFuncionario.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							TelaCadastroFuncionario telaFunc = new TelaCadastroFuncionario(usuario, senha);
							telaFunc.setLocationRelativeTo(null);
							telaFunc.setVisible(true);
							dispose();

						}
					});
					panel2.add(btnCadastroFuncionario, "cell 0 5,grow");

					btnCadastroConsulta = new JButton("Consulta");
					btnCadastroConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
					btnCadastroConsulta.setBorder(null);
					btnCadastroConsulta.setBackground(SystemColor.controlHighlight);
					btnCadastroConsulta.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Agenda agenda = new Agenda(usuario, senha);
							agenda.setLocationRelativeTo(null);
							agenda.setVisible(true);
							dispose();
						}
					});
					panel2.add(btnCadastroConsulta, "cell 0 7,grow");
					
					

					btnCadastroConsulta.setVisible(true);
					btnCadastroFuncionario.setVisible(true);
					btnCadastraMedico.setVisible(true);
					btnCadastraPaciente.setVisible(true);
					lblNewLabel.setVisible(true);
					btnBotaoMenu.repaint();
					
					contentPane.add(panel2);
					panel2.repaint();
					panel2.setVisible(true);
					
					
				} else {
					
					panel2.remove(btnCadastroConsulta);
					panel2.remove(btnCadastraPaciente);
					panel2.remove(btnCadastroFuncionario);
					panel2.remove(lblNewLabel);
					panel2.setVisible(false);
					contentPane.remove(panel2);
					contentPane.repaint();
					menu= 0; 
				}

			}
		});
		btnBotaoMenu.setIcon(new ImageIcon(
				"src\\main\\resources\\imagens\\botao-de-menu.png"));
		btnBotaoMenu.setBackground(Color.white);
		
		JButton btnLoginSair = new JButton("");
		btnLoginSair.addActionListener(new ActionListener() {
			

			

		

			public void actionPerformed(ActionEvent e) {
				
				if(sairPerfil==0) {
					sairPerfil =1 ;
			
				panelSair = new JPanel();
				panelSair.setBackground(new Color(00, 00, 255));
				panelSair.setBounds(1800, 79, 114, 128);
				panelSair.setLayout(new MigLayout("", "[100px:n:100px]", "[40:n:40][10:n:10][40:n:40]"));
				contentPane.add(panelSair);
				
				panelSair.setVisible(false);
				
				
				btnSair = new JButton("Sair");
				btnSair.addActionListener(new ActionListener() {
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
				btnSair.setForeground(new Color(00, 00, 00));
				btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
				panelSair.add(btnSair, "cell 0 0,grow");
				btnSair.setBorder(null);
				btnSair.setBackground(SystemColor.controlHighlight);
				
				btnPerfil = new JButton("Perfil");
				btnPerfil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaPerfil telaPerfil = new TelaPerfil(usuario, senha);
						telaPerfil.setLocationRelativeTo(null);
						telaPerfil.setVisible(true);
						dispose();
						
					}
				});
				btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 16));
				btnPerfil.setForeground(new Color(00, 00, 00));
				btnPerfil.setBackground(SystemColor.controlHighlight);
				panelSair.add(btnPerfil, "cell 0 2,grow");
				
				panelSair.repaint();
				panelSair.setVisible(true);
				
				}else {
					
					panelSair.remove(btnLoginSair);
					panelSair.remove(btnPerfil);
					panelSair.setVisible(false);
					contentPane.remove(panelSair);
					contentPane.repaint();
					sairPerfil =0 ;
					
				}
				
			}
		});
		btnLoginSair.setIcon(new ImageIcon(
				"src\\main\\resources\\imagens\\login.png"));
		btnLoginSair.setBackground(Color.white);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(btnBotaoMenu)
					.addGap(1762)
					.addComponent(btnLoginSair))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBotaoMenu, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoginSair, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1924, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(933))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
