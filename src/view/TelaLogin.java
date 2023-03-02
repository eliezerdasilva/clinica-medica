package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.LoginDao;
import model.Usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private Usuario usuario = new Usuario();

	private LoginDao loginDao = new LoginDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

		setTitle("Tela de Login");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 741);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		setVisible(true);

		txtUsuario = new RoundedJTextField(15);
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsuario.getText().equals("Usuario")) {
					txtUsuario.setText("");
					txtUsuario.setSelectedTextColor(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsuario.getText().equals("")) {
					txtUsuario.setText("Usuario");
					txtUsuario.setSelectedTextColor(Color.GRAY);
				}
			}
		});
		txtUsuario.setForeground(new Color(0, 0, 51));
		txtUsuario.setBackground(new Color(102, 204, 102));
		txtUsuario.setText("Usuario");
		txtUsuario.setBounds(162, 232, 249, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new RoundedJTextField(15);
		txtSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtSenha.getText().equals("")) {
					txtSenha.setText("Senha");
					txtSenha.setSelectedTextColor(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtSenha.getText().equals("Senha")) {
					txtSenha.setText("");
					txtSenha.setSelectedTextColor(Color.BLACK);
				}
			}
		});
		txtSenha.setForeground(new Color(0, 0, 51));
		txtSenha.setBackground(new Color(102, 204, 102));
		txtSenha.setText("Senha");
		txtSenha.setBounds(162, 299, 249, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		// TODO alteracao no estilo do Botao

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBorder(new LineBorder(new Color(0, 128, 128), 10, true));

		btnNewButton.setBorder(null);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
		// btnNewButton.setBorder(BorderFactory.createBevelBorder(1, Color.black,
		// Color.black));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Usuario = txtUsuario.getText();
				String Senha = txtSenha.getText();
				Usuario login = null;
				MenuPrincipal telaFunc = new MenuPrincipal(login);
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
				dispose();
				/*if (!Usuario.isEmpty() && !Senha.isEmpty()) {
					LoginDao loginDao;
					loginDao = new LoginDao();

					login = loginDao.consultarLogin(new Usuario(Usuario, Senha));

					if (login != null) {

						MenuPrincipal telaFunc = new MenuPrincipal(login);
						telaFunc.setLocationRelativeTo(null);
						telaFunc.setVisible(true);
						dispose();

					} else {

						JOptionPane.showMessageDialog(null, "Senha ou Usuario incorretos!");
					}
				} else {

					JOptionPane.showMessageDialog(null, "Senha ou Usuario não preenchidos!");
				}

*/

			}
		});

		btnNewButton.setBounds(162, 364, 249, 23);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 9, true));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(71, 22, 435, 585);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(34, 67, 351, 71);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setBackground(UIManager.getColor("Button.disabledForeground"));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\eliez\\OneDrive\\Documentos\\repositorio\\src\\imagens\\icons8-usuário-homem-com-círculo-24.png"));
		lblNewLabel_1.setBounds(344, 207, 46, 24);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\eliez\\OneDrive\\Documentos\\repositorio\\src\\imagens\\icons8-particular-2-24.png"));
		lblNewLabel_2.setBounds(344, 271, 46, 34);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(
				"C:\\Users\\eliez\\OneDrive\\Documentos\\repositorio\\src\\imagens\\icons8-login-arredondado-30.png"));
		lblNewLabel_3.setBounds(344, 335, 36, 34);
		panel.add(lblNewLabel_3);

	}
}

class RoundedJTextField extends JTextField {
	private Shape shape;

	public RoundedJTextField(int size) {
		super(size);
		setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}
}
