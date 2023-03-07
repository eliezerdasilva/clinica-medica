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

import controller.EnderecoDao;
import model.Endereco;
import model.Paciente;

/**
 * 
 * @author Eliezer da Silva
 * 
 *         Classe resposavel por exibir Tela de cadastro de paciente
 *
 */
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
	private JTextField txt;
	Endereco enderecoPronto = null;
	private JTextField txtCidade;
	private JLabel lblNewLabel_14;
	private JTextField txtEstado;
	private JLabel lblNewLabel_15;

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
		txtDataNasciemento.setBounds(93, 445, 96, 19);
		contentPane.add(txtDataNasciemento);
		txtDataNasciemento.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("data nascimento");
		lblNewLabel_7.setBounds(27, 449, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		txtRua = new JTextField();
		txtRua.setBounds(470, 141, 96, 19);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("rua");
		lblNewLabel_8.setBounds(415, 145, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("cep");
		lblNewLabel_9.setBounds(415, 186, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		txtCep = new JTextField();
		txtCep.setBounds(470, 196, 96, 19);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Nuemro");
		lblNewLabel_10.setBounds(415, 235, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(470, 231, 96, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Bairro");
		lblNewLabel_11.setBounds(415, 275, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(470, 271, 96, 19);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		lblNewLabel_12 = new JLabel("complemento");
		lblNewLabel_12.setBounds(415, 310, 45, 13);
		contentPane.add(lblNewLabel_12);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(470, 306, 96, 19);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);
		

		txtCidade = new JTextField();
		txtCidade.setBounds(473, 92, 86, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(473, 50, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				String nome = txtNome.getText();
				String cpf = txtCpf.getText();
				String sexo = txtSexo.getText();
				String email = txtEmail.getText();
				String telefone = txtTelefone.getText();
				String profissao = txtProfissao.getText();
				String convenio = txtConvenio.getText();
				String dataNascimento = txtDataNasciemento.getText();
				String complemento =  txtComplemento.getText();
				String numero = txtNumero.getText();
				
				//String cep = String.valueOf(resultado.);
				
					
					if(nome == null || nome.trim() == "" || nome.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nome Vazio", "Nome Vazio", JOptionPane.ERROR_MESSAGE);
					}else {
						//manipular nome
					}
					

					if (cpf == null || cpf.trim() == "" || cpf.isEmpty()) {
							
					} else {
						//TRANSFORMAR EM STRING
						//MANIPULAR CPF
					}
				

						if (sexo == null || sexo.trim() == "" || sexo.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Sexo Vazio" ,"Sexo Vazio", JOptionPane.ERROR_MESSAGE);
						} else if (sexo != "F" && sexo != "M") {
							JOptionPane.showMessageDialog(null, "Sexo Vazio" ,"Sexo Invalido", JOptionPane.ERROR_MESSAGE);
						} else {
							//MANIPULAR SEXO
						}
			

					

						if (email == null || email.trim() == "" || email.isEmpty()) {
							JOptionPane.showMessageDialog(null, "E-mail Vazio" ,"E-mail Vazio", JOptionPane.ERROR_MESSAGE);
						}else {
							//MANIPULAR EMAIL
						}
					

					

						if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Telefone Vazio" ,"Telefone Vazio", JOptionPane.ERROR_MESSAGE);
						}else {
							//MANIPULAR TELEFONE
						}

					

					

						if (profissao == null || profissao.trim() == "" || profissao.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Profissao Vazia" ,"Profissao Vazia", JOptionPane.ERROR_MESSAGE);	
						}else {
							//MANIPULAR PROFISSAO
						}

						

					

						if (convenio == null || convenio.trim() == "" || convenio.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Convenio Vazia" ,"Convenio Vazia", JOptionPane.ERROR_MESSAGE);
						}else {
							//MANIPULAR CONVENIO
						}

					

						if (dataNascimento == null || dataNascimento.trim() == "" || dataNascimento.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Data Vazia" ,"Data Vazia", JOptionPane.ERROR_MESSAGE);
						}else {
							//MANIPULAR DATA
						}

				
						
						if (complemento == null || complemento.trim() == "" || complemento.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Complemento Vazia" ,"Complemento Vazio", JOptionPane.ERROR_MESSAGE);
						}else {
							//MANIPULAR COMPLEMENTO
						}


					

						if (numero == null || numero.trim() == "" || numero.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Numero Vazia" ,"Numero Vazio", JOptionPane.ERROR_MESSAGE);
						}else {
							//MANIPULAR NUMERO
						}

				
				
			
				
				
			
				//Endereco resultado = enderecoDao.ConsultarEndereco(consultaEndereco);
				
				//if(resultado != null) {
				
				//Paciente paciente = new Paciente(nome,sexo,endereco, cpf, dataNascimento,
					//	telefone, email,  rg,   profissao,  convenio) {
					
				}/*
					super(id, nome, sexo, endereco, cpf, dataNascimento, telefone, email, rg)
						(nome,cpf,sexo,endereco, email,telefone,email,telefone,profissao,convenio, dataNascimento,);
				//Endereco endereco = EnderecoDAO.buscarEnderecoPorCep();
				}else
					enderecoDao.
				}
				Paciente paciente = new Paciente();
				paciente.setEndereco(endereco);
				*/
				
			//}
		});
		btnNewButton.setBounds(214, 581, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO Cidade
				String rua = txtRua.getText();
				Integer cep = Integer.parseInt(txtCep.getText());
				String bairro = txtBairro.getText();
				String cidade = txtCidade.getText();
				String estado = txtEstado.getText();
			
				//TODO instância para os get e setrs do endereco
				Endereco consultaEndereco = new Endereco(cep);
				
				//TODO instâcia para cadastrar um endereco novo
				Endereco cadastroEndereco;
				
				//TODO instância para consultar cep cadastrado
				EnderecoDao enderecoDao = new EnderecoDao();
			
				//TODO instância para ver o resultado da busca de cep
				Endereco resultado = new Endereco();
				// TODO metodo de consulta
				
				resultado = enderecoDao.ConsultarEndereco(consultaEndereco);
				 
				 //TODO Setar resultado do banco, se acasso o cep existir 
				if(resultado != null) {
					int cepNovo = resultado.getCep();
					String ruaNova = resultado.getRua();
					String bairroNovo = resultado.getBairro();
					String cidadeNova = resultado.getCidade();
					String estadoNovo = resultado.getEstado();
					
					enderecoPronto = new Endereco();
					enderecoPronto.setCep(cepNovo);
					enderecoPronto.setCidade(cidadeNova);
					enderecoPronto.setEstado(estadoNovo);
					enderecoPronto.setRua(ruaNova);
					enderecoPronto.setBairro(bairroNovo);
					System.out.println("foi");
							
				//TODO Cadastrar novo cep 
				}else {
				
					cadastroEndereco = new Endereco(cep , estado, bairro, cidade, rua);
					Boolean veroficacaoNovoEndereco = enderecoDao.InserirEndereco(cadastroEndereco);
					System.out.println("nqa");
					
					
				}
				
			}
		});
		btnNewButton_1.setBounds(470, 408, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_13 = new JLabel("Estado");
		lblNewLabel_13.setBounds(415, 338, 46, 14);
		contentPane.add(lblNewLabel_13);
		
		txt = new JTextField();
		txt.setBounds(480, 336, 86, 20);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("limpar");
		btnNewButton_2.setBounds(67, 496, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("excluir");
		btnNewButton_3.setBounds(180, 496, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("voltar");
		btnNewButton_4.setBounds(727, 591, 89, 23);
		contentPane.add(btnNewButton_4);
		
		lblNewLabel_14 = new JLabel("cidade");
		lblNewLabel_14.setBounds(383, 95, 46, 14);
		contentPane.add(lblNewLabel_14);
		
		
		lblNewLabel_15 = new JLabel("estado");
		lblNewLabel_15.setBounds(383, 53, 46, 14);
		contentPane.add(lblNewLabel_15);
	}

}
