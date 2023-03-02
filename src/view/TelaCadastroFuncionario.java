package view;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtEmail;
	private JTextField txtSexo;
	private JTextField txtTelefone;
	private JTextField TxtDataNascimento;
	private JTextField txtCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 469);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(97, 44, 96, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(97, 85, 96, 19);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setBounds(97, 131, 96, 19);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(97, 183, 96, 19);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(301, 44, 96, 19);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(301, 85, 96, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setBounds(301, 131, 96, 19);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("nome");
		lblNewLabel.setBounds(23, 47, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("cpf");
		lblNewLabel_1.setBounds(23, 88, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("rua");
		lblNewLabel_2.setBounds(23, 134, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("bairro");
		lblNewLabel_3.setBounds(23, 186, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("complemento");
		lblNewLabel_4.setBounds(246, 47, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("numero");
		lblNewLabel_5.setBounds(246, 88, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("cep");
		lblNewLabel_6.setBounds(246, 134, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(301, 183, 96, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("email");
		lblNewLabel_7.setBounds(246, 186, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(474, 44, 96, 19);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("sx");
		lblNewLabel_8.setBounds(423, 47, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(474, 85, 96, 19);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("telefone");
		lblNewLabel_9.setBounds(407, 88, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("data nas");
		lblNewLabel_10.setBounds(407, 134, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		TxtDataNascimento = new JTextField();
		TxtDataNascimento.setBounds(474, 131, 96, 19);
		contentPane.add(TxtDataNascimento);
		TxtDataNascimento.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("cidade");
		lblNewLabel_11.setBounds(407, 186, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(474, 183, 96, 19);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JButton btnNewButton = new JButton("cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String nome = txtNome.setText(getName());
			}
		});
		btnNewButton.setBounds(167, 239, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_12 = new JLabel("usuario");
		lblNewLabel_12.setBounds(539, 11, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBounds(595, 11, 46, 14);
		contentPane.add(lblNewLabel_13);
	}
}
