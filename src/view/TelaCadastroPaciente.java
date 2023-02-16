package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtSexo;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtProfissao;
	private JTextField txtConvenio;
	private JTextField txtDataNasciemento;
	private JTextField txtRua;
	private JLabel lblNewLabel_9;
	private JTextField txtCep;
	private JLabel lblNewLabel_10;
	private JTextField txtNumero;
	private JLabel lblNewLabel_11;
	private JTextField txtBairro;
	private JLabel lblNewLabel_12;
	private JTextField txtComplemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPaciente frame = new TelaCadastroPaciente();
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
	public TelaCadastroPaciente() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nome");
		lblNewLabel.setBounds(57, 96, 45, 13);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(93, 93, 96, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("cpf");
		lblNewLabel_1.setBounds(42, 145, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(93, 142, 96, 19);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("sexo");
		lblNewLabel_2.setBounds(42, 200, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(93, 197, 96, 19);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("email");
		lblNewLabel_3.setBounds(42, 259, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(93, 256, 96, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(93, 306, 96, 19);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtProfissao = new JTextField();
		txtProfissao.setBounds(93, 355, 96, 19);
		contentPane.add(txtProfissao);
		txtProfissao.setColumns(10);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(93, 409, 96, 19);
		contentPane.add(txtConvenio);
		txtConvenio.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("telefone");
		lblNewLabel_4.setBounds(38, 309, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("profissao");
		lblNewLabel_5.setBounds(27, 358, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("convenio");
		lblNewLabel_6.setBounds(27, 412, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		txtDataNasciemento = new JTextField();
		txtDataNasciemento.setBounds(257, 93, 96, 19);
		contentPane.add(txtDataNasciemento);
		txtDataNasciemento.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("data nascimento");
		lblNewLabel_7.setBounds(202, 96, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		txtRua = new JTextField();
		txtRua.setBounds(257, 142, 96, 19);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("rua");
		lblNewLabel_8.setBounds(202, 145, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("cep");
		lblNewLabel_9.setBounds(202, 200, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		txtCep = new JTextField();
		txtCep.setBounds(257, 197, 96, 19);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Nuemro");
		lblNewLabel_10.setBounds(202, 259, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(257, 256, 96, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Bairro");
		lblNewLabel_11.setBounds(202, 309, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(257, 306, 96, 19);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		lblNewLabel_12 = new JLabel("complemento");
		lblNewLabel_12.setBounds(202, 358, 45, 13);
		contentPane.add(lblNewLabel_12);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(257, 355, 96, 19);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JButton btnNewButton = new JButton("cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(257, 408, 85, 21);
		contentPane.add(btnNewButton);
	}
}
