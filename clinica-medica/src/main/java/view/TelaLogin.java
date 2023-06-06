package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.LoginDao;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import utils.RoundButton;
import utils.RoundFormattedJTextField;
import utils.RoundJTextField;
import utils.RoundJTextPassword;


import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtSenha;
	private RoundButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private RoundJTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LocoHospital.png")));
		setTitle("Login");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/LocoHospital.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[600:n:600][600:n:600,grow][600:n:600]", "[100px:n:100px][780:n:780,grow][100px:n:100px]"));
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "cell 0 1 2 1,grow");
		layeredPane.setLayout(new MigLayout("", "[600:n:600][150:n:150][300:n:300,grow][250:n:250]", "[100px:n:100px][][][200:n:200][20:n:20][30:n:30][30:n:30][30:n:30][30:n:30][35:n:35]"));
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		layeredPane.add(lblNewLabel, "cell 2 1,growx");
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\imagens\\pessoa3e.png"));
		layeredPane.add(lblNewLabel_1, "cell 2 3,alignx center");
		
		txtUsuario = new RoundJTextField(15);
		layeredPane.add(txtUsuario, "cell 2 5,grow");
		txtUsuario.setColumns(10);
		
		txtSenha = new RoundJTextPassword(15);
		txtSenha.setColumns(10);
		layeredPane.add(txtSenha, "cell 2 7,grow");
		
		btnNewButton = new RoundButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			

			

			public void actionPerformed(ActionEvent e) {
				
				String usuario = txtUsuario.getText();
				String senha = txtSenha.getText();
				Usuario login = null;

				if (!usuario.isEmpty() && !senha.isEmpty()) {
					LoginDao loginDao;
					loginDao = new LoginDao();

					login = loginDao.consultarLogin(new Usuario(usuario, senha));

					if (login != null) {

						if (login.getNivelAcesso() == 0 || login.getNivelAcesso() == 2) {
							TelaMenuPrincipal telaFuncAdm = new TelaMenuPrincipal(login);
							telaFuncAdm.setLocationRelativeTo(null);
							telaFuncAdm.setVisible(true);
							dispose();
						} else {
							TelaMenuPrincipalMedico telaMenuPrincipalMedico = new TelaMenuPrincipalMedico(login);
							telaMenuPrincipalMedico.setLocationRelativeTo(null);
							telaMenuPrincipalMedico.setVisible(true);
							dispose();
						}

					} else {

						JOptionPane.showMessageDialog(null, "Senha ou Usuario incorretos!");
					}
				} else {

					JOptionPane.showMessageDialog(null, "Senha ou Usuario não preenchidos!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(149, 208, 157));
		layeredPane.add(btnNewButton, "cell 2 9,grow");
		
		JPanel panel = createRoundedPanel(450);
		panel.setBackground(new Color(236, 253, 232));
		contentPane.add(panel, "cell 1 1,grow");
		
	
		
		

	}
	 private static JPanel createRoundedPanel(int cornerRadius) {
	        JPanel panel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                Graphics2D g2 = (Graphics2D) g.create();
	                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	                int width = getWidth();
	                int height = getHeight();
	                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, width, height, cornerRadius, cornerRadius);
	                g2.setColor(getBackground());
	                g2.fill(roundedRectangle);

	                g2.dispose();
	            }
	        };

	        panel.setLayout(new BorderLayout());
	        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

	        return panel;
	    }

}
