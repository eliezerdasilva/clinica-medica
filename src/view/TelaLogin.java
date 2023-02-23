package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.loginDao;
import model.Usuario;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private Usuario usuario = new Usuario();
	
	private loginDao loginDao = new loginDao();
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
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(239, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("Usuario\r\n");
		txtUsuario.setBounds(163, 103, 249, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setText("Senha");
		txtSenha.setBounds(163, 147, 249, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Usuario = txtUsuario.getText();
				String Senha = txtSenha.getText();
				usuario.setUsuario(Usuario);
				usuario.setSenha(Senha);
				boolean retorno = loginDao.preenchido(usuario); 
				
				if(retorno == true) {
					Usuario login = loginDao.consularLogin(usuario);
					TelaCadastroFuncionairo telaFunc = new TelaCadastroFuncionairo();
					telaFunc.setLocationRelativeTo(null);
					telaFunc.setVisible(true);
					System.out.println("conectado");
				}
				else {
					JOptionPane.showMessageDialog(null, "Senha ou usuario invalidos", "Erro",JOptionPane.ERROR_MESSAGE);
				}
						
				
				
				
				
			}
		});
		btnNewButton.setBounds(163, 190, 249, 23);
		contentPane.add(btnNewButton);
		
		
	}
}