package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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

		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		setTitle("Tela de login");

		URL resourceIcon = TelaLogin.class.getResource("/imagens/logo.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 2000, 1050);

		setContentPane(contentPane);

		BufferedImage bg = null;

		try {
			bg = ImageIO.read(new File("src/imagens/fundoLogin.jpeg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel = new FundoImagemLogin(bg);
		panel.setBackground(new Color(204, 255, 204));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE)
					.addGap(20))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new MigLayout("", "[331.00][1286.00,grow][299.00]", "[185.00][657.00,grow][226.00]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 153, 0), 8));
		panel.add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		BufferedImage filc = null;

		try {
			filc = ImageIO.read(new File("src/imagens/fundoVerde.jpeg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel_2 = new FundoImagemLoginCabecario(filc);
		panel_2.setBackground(new Color(51, 153, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new CardLayout(0, 40));

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_169020969106100");

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[383.00][192.00][933.00,grow][416.00][]",
				"[73.00][44.00][62.00][45.00][][72.00][grow][55.00,grow]"));

		JLabel lblNewLabel_1 = new JLabel("Usuario ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_4.add(lblNewLabel_1, "cell 2 1");

		txtUsuario = new RoundJTextField(15);

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
		panel_4.add(txtUsuario, "cell 2 2,growx,aligny center");
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_4.add(lblNewLabel_2, "cell 2 3");

		txtSenha = new RoundJTextPassword(15);
		txtSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtSenha.getText().equals("Senha")) {
					txtSenha.setText("");
					txtSenha.setSelectedTextColor(Color.BLACK);

				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtSenha.getText().equals("")) {
					txtSenha.setText("Senha");
					txtSenha.setSelectedTextColor(Color.GRAY);

				}
			}
		});
		panel_4.add(txtSenha, "cell 2 4,growx");

		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3, "cell 2 6,grow");
		panel_3.setLayout(new MigLayout("", "[316.00][275.00][287.00]", "[10.00][39.00][10.00]"));

		JButton btnNewButton = new RoundButton("Entrar");
		btnNewButton.setIcon(new ImageIcon(
				"C:\\Users\\frete\\Documents\\clinica-medica\\src\\imagens\\icons8-login-arredondado-30.png"));

		btnNewButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnNewButton.setBackground(new Color(00, 255, 00));
			}

			@Override
			public void focusLost(FocusEvent e) {
				btnNewButton.setBackground(new Color(51, 153, 51));
			}
		});

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

						MenuPrincipal telaFunc = new MenuPrincipal(usuario, senha);
						telaFunc.setLocationRelativeTo(null);
						telaFunc.setVisible(true);
						dispose();

					} else {

						JOptionPane.showMessageDialog(null, "Senha ou Usuario incorretos!");
					}
				} else {

					JOptionPane.showMessageDialog(null, "Senha ou Usuario não preenchidos!");
				}
			}
		});

		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setBackground(new Color(51, 153, 51));
		panel_3.add(btnNewButton, "cell 1 1,grow");
		contentPane.setLayout(gl_contentPane);
	}

	private void setMinimumSize(int i, int j) {
		// TODO Auto-generated method stub

	}
}

//Tela de inicio
class FundoImagemLogin extends JPanel {

	Image bg;

	FundoImagemLogin(Image bg) {
		this.bg = bg;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
}

//cabecario login
class FundoImagemLoginCabecario extends JPanel {

	Image bg;

	FundoImagemLoginCabecario(Image bg) {
		this.bg = bg;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
}

class botao extends JButton {
	private Shape shape;
	Image bg;

	botao(Image bg, String label) {
		super(label);
		setOpaque(false);
		this.bg = bg;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
}
