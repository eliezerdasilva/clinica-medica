package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.LoginDao;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import utils.RoundButton;
import utils.RoundJTextField;
import utils.RoundJTextPassword;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setMinimumSize(new Dimension(1000, 400));
					frame.setExtendedState(MAXIMIZED_BOTH);
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1894, Short.MAX_VALUE).addGap(20)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE).addContainerGap()));
		panel.setLayout(
				new MigLayout("", "[300,grow,center][1175.00,grow][277.00,grow]", "[98.00,grow][784.00,grow][98.00]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(143, 188, 143), 8));
		panel.add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(143, 188, 143));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 40));

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(236, 253, 232));
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[102.00,grow,center][817.00,grow][118.00][38.00]", "[36.00,grow][47.00][72.00,grow][78.00,grow][72.00,grow][105.00,grow][38.00,grow][70.00,grow][67.00,grow][grow][]"));

		txtUsuario = new RoundJTextField(15);
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));	
		
//		txtUsuario.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				if (txtUsuario.getText().equals("Usuario")) {
//					txtUsuario.setText("");
//					txtUsuario.setSelectedTextColor(Color.BLACK);
//
//				}
//
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				if (txtUsuario.getText().equals("")) {
//					txtUsuario.setText("Usuario");
//					txtUsuario.setSelectedTextColor(Color.GRAY);
//
//				}
//
//			}
//		});

		JLabel lblNewLabel_1_1 = new JLabel("Usuário:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_4.add(lblNewLabel_1_1, "flowx,cell 0 2");
		panel_4.add(txtUsuario, "cell 1 2 2 1,grow");
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha:\r\n\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_4.add(lblNewLabel_2, "flowx,cell 0 4");

		txtSenha = new RoundJTextPassword(15);
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		
//		txtSenha.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				if (txtSenha.getText().equals("Senha")) {
//					txtSenha.setText("");
//					txtSenha.setSelectedTextColor(Color.BLACK);
//
//				}
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				if (txtSenha.getText().equals("")) {
//					txtSenha.setText("Senha");
//					txtSenha.setSelectedTextColor(Color.GRAY);
//
//				}
//			}
//		});
		
		panel_4.add(txtSenha, "cell 1 4 2 1,grow");

		JButton btnNewButton = new RoundButton("Entrar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		panel_4.add(btnNewButton, "cell 1 7,grow");
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(149, 208, 157));
		btnNewButton.setIcon(new ImageIcon(
				"C:\\Users\\frete\\Documents\\clinica-medica\\src\\imagens\\icons8-login-arredondado-30.png"));

		// btnNewButton.addFocusListener(new FocusAdapter() {
		// @Override
		// public void focusGained(FocusEvent e) {
		// btnNewButton.setBackground(new Color(00, 255, 00));
		// }
		//
		// @Override
		// public void focusLost(FocusEvent e) {
		// btnNewButton.setBackground(new Color(149, 208, 157));
		// }
		// });

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

		contentPane.setLayout(gl_contentPane);
	}
}
