package helper;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import org.junit.platform.commons.util.FunctionUtils;

import controller.EnderecoDao;
import controller.FuncionarioDao;
import controller.UsuarioDao;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Usuario;
import view.TelaCadastroFuncionario;

public class CadastroFuncionarioHelper {

	private static UsuarioDao usuarioDao;
	private static Usuario usuario;
	private Funcionario funcionario;
	private static FuncionarioDao funcionarioDao;

	public static Funcionario dadosFuncinario(TelaCadastroFuncionario telaCadatrosFuncionario) {

		usuario = new Usuario();
		usuarioDao = new UsuarioDao();

		String nome = telaCadatrosFuncionario.getTxtNome().getText();

		String validacao = "";

		String cpfTxt = telaCadatrosFuncionario.getTxtCpf().getText().replace(".", "").replace("-", "");

		String sexo = "";
		if (telaCadatrosFuncionario.getRdbtnMasculino().isSelected()) {

			sexo = "M";
		}
		if (telaCadatrosFuncionario.getRdbtnFeminino().isSelected()) {
			sexo = "F";
		}
		if (telaCadatrosFuncionario.getRdbtnMasculino() == null || telaCadatrosFuncionario.getRdbtnFeminino() == null) {
			sexo = null;
		}
		String email = telaCadatrosFuncionario.getTxtEmail().getText();

		String telefone = telaCadatrosFuncionario.getTxtTelefone().getText().replace("-", "").replace("(", "")
				.replace(")", "");

		String dataN = telaCadatrosFuncionario.getTxtData().getText();

		String complemento = telaCadatrosFuncionario.getTxtComplemento().getText();

		String numeroCasa = telaCadatrosFuncionario.getTxtNumero().getText();

		String usuarioLogin = telaCadatrosFuncionario.getTxtUsuario().getText();

		String senha = telaCadatrosFuncionario.getJpfSenha().getText();

		int tipoUsuario = 0;

		if (telaCadatrosFuncionario.getRdbtnAdministrador().isSelected()) {
			tipoUsuario = 0;
		}
		if (telaCadatrosFuncionario.getRdbtnFuncionario().isSelected()) {
			tipoUsuario = 2;
		}

		funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = new Funcionario();
		Funcionario funcionarioNovo = new Funcionario();
		funcionario = funcionarioDao.consultaERetornarCPF(Long.valueOf(cpfTxt));
		if(funcionario == null) {
		long id = funcionario.getUsuario().getId();

		Usuario retorno = usuarioDao.consultarUsuario(id);
		}
		
		// Cadastrar adm
		if (tipoUsuario == 0) {

			if (usuarioLogin == null || usuarioLogin.trim() == "" || usuarioLogin.isEmpty()) {
				validacao += "Usuário\n";
				telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				usuario.setUsuario(usuarioLogin);
			}
			if (senha == null || senha.trim() == "" || senha.isEmpty()) {
				validacao += "Usuário\n";
				telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				usuario.setSenha(senha);
			}
			usuario.setNivelAcesso(tipoUsuario);
			Boolean resultadoUsuario = usuarioDao.consultarUsuarioExistente(usuarioLogin);
			if (resultadoUsuario != true) {
				Boolean resposta = usuarioDao.inserirUsuario(usuario);
				if (resposta == true) {
					JOptionPane.showMessageDialog(null, "Administrador Cadastrado ");
				} else {
					JOptionPane.showMessageDialog(null, "Erro, Administrador não Cadastrado ");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Informe outro Usuário para login.");
				telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			}
		}
		// Cadastrar Funcionario
		boolean resultado = funcionarioDao.consultaCpf(Long.valueOf(cpfTxt));

		if (tipoUsuario != 0 ) {

			// TODO nova validacao nome
			if (nome == null || nome.trim() == "" || nome.isEmpty()) {
				telaCadatrosFuncionario.getTxtNome().setBorder(new LineBorder(new Color(255, 00, 00), 4));
				JOptionPane.showMessageDialog(null, "Nome vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
			} else {
				funcionarioNovo.setNome(nome);
			}
			// cpf
			if (cpfTxt != null || cpfTxt.trim() != "") {
				Long cpf = Long.valueOf(cpfTxt);
				// Cadastrar
				if (resultado != true && !funcionario.getCpf().equals(Long.valueOf(cpfTxt))) {
					funcionario.setCpf(cpf);

					// Cadastro do Usuário
					if (usuarioLogin == null || usuarioLogin.trim() == "" || usuarioLogin.isEmpty()) {
						validacao += "Usuário\n";
						telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						usuario.setUsuario(usuarioLogin);
					}
					if (senha == null || senha.trim() == "" || senha.isEmpty()) {
						validacao += "Usuário\n";
						telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						usuario.setSenha(senha);
					}

					usuario.setNivelAcesso(tipoUsuario);
					Boolean resultadoUsuario = usuarioDao.consultarUsuarioExistente(usuarioLogin);

					if (resultadoUsuario != true) {
						Boolean retorno1 = usuarioDao.inserirUsuario(usuario);
						if (retorno1 != false) {
							Usuario usuarioSelecionado = usuarioDao.selecionarUSuarioParaCadastrar(usuario);
							funcionarioNovo.setUsuario(usuarioSelecionado);
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Usuário");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Informe outro Usuário para login.");
						telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));

					}

					// Editar
				} else {
					telaCadatrosFuncionario.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
					JOptionPane.showMessageDialog(null, "Funcionario já cadastrado");

				}
				if (resultado == true && funcionario.getCpf().equals(Long.valueOf(cpfTxt))) {

					if (usuarioLogin == null || usuarioLogin.trim() == "" || usuarioLogin.isEmpty()) {
						validacao += "Usuário\n";
						telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						usuario.setUsuario(usuarioLogin);
					}
					if (senha == null || senha.trim() == "" || senha.isEmpty()) {
						validacao += "Usuário\n";
						telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
					} else {
						usuario.setSenha(senha);
					}
					if (funcionario.getUsuario().getSenha().equals(senha)
							&& funcionario.getUsuario().getUsuario().equals(usuarioLogin)
							&& funcionario.getUsuario().getNivelAcesso() == 2) {
						usuario.setUsuario(usuarioLogin);
						usuario.setSenha(senha);
						usuario.setNivelAcesso(tipoUsuario);

					} else {
						usuario.setUsuario(usuarioLogin);
						usuario.setSenha(senha);
						usuario.setNivelAcesso(tipoUsuario);
						var retornoUsuario = usuarioDao.alterarUsuario(usuario);
						if (retornoUsuario != null) {
							JOptionPane.showMessageDialog(null, "Erro ao editar o usuário");
						} else
							funcionarioNovo.setUsuario(retornoUsuario);
					}
				}

			}
		} else {
			telaCadatrosFuncionario.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			JOptionPane.showMessageDialog(null, "CPF vazio", "ok", JOptionPane.ERROR_MESSAGE);

		}
		// sexo

		if (sexo == null || sexo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sexo vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
			telaCadatrosFuncionario.getRdbtnFeminino().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			telaCadatrosFuncionario.getRdbtnMasculino().setBorder(new LineBorder(new Color(255, 00, 00), 4));

		} else {
			funcionarioNovo.setSexo(sexo);
		}
		// email
		if (email == null || email.trim() == "" || email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sexo vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
			telaCadatrosFuncionario.getTxtEmail().setBorder(new LineBorder(new Color(255, 00, 00), 4));

		} else {
			funcionarioNovo.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Telefone vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
			telaCadatrosFuncionario.getTxtTelefone().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			funcionarioNovo.setTelefone(telefone);
		}
		// data nascimento
		if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
			validacao += "Data\n";
			telaCadatrosFuncionario.getTxtData().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			String dataTest = dataN.replace("/", "").trim();
			if (dataTest.length() == 0) {
				validacao += "Data\n";
				telaCadatrosFuncionario.getTxtData().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				telaCadatrosFuncionario.getTxtData().setBorder(new LineBorder(new Color(00, 00, 00), 1));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate data = LocalDate.parse(dataN, formatter);
				data.format(formatter);
				funcionarioNovo.setDataNascimento(data);
			}

		}
		// Complmento
		funcionario.setComplemento(complemento);

		if (numeroCasa == null || numeroCasa.trim() == "" || numeroCasa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Numero vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
			telaCadatrosFuncionario.getTxtNumero().setBorder(new LineBorder(new Color(255, 00, 00), 4));

		} else {
			Integer nCasa = Integer.valueOf(numeroCasa);
			funcionario.setNumero(nCasa);
		}

		// TODO

		// Validação endereco
		String cepString = telaCadatrosFuncionario.getTxtCep().getText().replace("-", "");
		String bairro = telaCadatrosFuncionario.getTxtBairro().getText();
		String cidade = telaCadatrosFuncionario.getTxtMunicipio().getText();
		String rua = telaCadatrosFuncionario.getTxtRua().getText();
		Endereco endereco = new Endereco();

		if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
			validacao += "Cep\n";
			telaCadatrosFuncionario.getTxtCep().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			Integer cep = Integer.valueOf(cepString);
			endereco.setCep(cep);
		}

		if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
			validacao += "Bairro\n";
			telaCadatrosFuncionario.getTxtBairro().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setBairro(bairro);
		}
		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			validacao += "Cidade\n";
			telaCadatrosFuncionario.getTxtMunicipio().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setCidade(cidade);
		}
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			validacao += "Rua\n";
			telaCadatrosFuncionario.getTxtRua().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setRua(rua);
		}

		if (validacao.trim() != "") {
			JOptionPane.showMessageDialog(null, validacao, "Adicione:", JOptionPane.ERROR_MESSAGE, null);
		}
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco resultadoEndereco = new Endereco();
		resultadoEndereco = enderecoDao.ConsultarEndereco(endereco);

		boolean resuEnd = false;
		if (resultadoEndereco == null) {
			Estado estado = (Estado) telaCadatrosFuncionario.getCbxEstado().getSelectedItem();
			int idEstado = estado.getId();
			estado.setId(idEstado);

			endereco.setEstado(estado);

			// TODO cadastro do endereço

			try {
				resuEnd = enderecoDao.InserirEndereco(endereco);
				if (resuEnd != true) {
					JOptionPane.showMessageDialog(null, "Erro no cadastro, endereço inválido", "Erro",
							JOptionPane.ERROR_MESSAGE);

				} else {

				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Erro no cadastro, endereço inválido", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (resultadoEndereco != null || resuEnd == true) {

			try {
				// Inserir o endereco no funcionario
				funcionarioNovo.setEndereco(endereco);

			} catch (Exception el) {
				el.printStackTrace();
			}
			
		}

		return funcionarioNovo;

	}

	

	public boolean editarFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
		funcionario = new Funcionario();
		 funcionario = dadosFuncinario(telaCadastroFuncionario);
		 funcionarioDao = new FuncionarioDao();
		 //boolean retorno = funcionarioDao.cadastrarFuncionario(funcionario);
		
		return false;

	}

	public boolean cadastrarFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
		funcionario = new Funcionario();
		 funcionario = dadosFuncinario(telaCadastroFuncionario);
		 funcionarioDao = new FuncionarioDao();
		 boolean retorno = funcionarioDao.cadastrarFuncionario(funcionario);
		
		return retorno;
	
	}

	

}
