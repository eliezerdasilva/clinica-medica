package helper;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import org.junit.platform.commons.util.FunctionUtils;

import controller.EnderecoDao;
import controller.FuncionarioDao;
import controller.MedicoDao;
import controller.UsuarioDao;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.StatusTela;
import model.Usuario;
import view.TelaCadastroFuncionario;

public class ManterFuncionarioHelper {

	private static UsuarioDao usuarioDao;
	private static Usuario usuario;
	private Funcionario funcionario;
	private static FuncionarioDao funcionarioDao;
	private static Endereco endereco;
	private static EnderecoDao enderecoDao;

	public static Funcionario setarObjetoFuncionario(TelaCadastroFuncionario telaCadatrosFuncionario) {

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
		// Vê se o funcionario é cadastrado
		if (cpfTxt.trim() != "") {
			funcionario = funcionarioDao.consultaFuncionairoCPF(Long.valueOf(cpfTxt));
		}
		// Cadastrar adm
		if (tipoUsuario == 0 && funcionario == null) {

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
				JOptionPane.showMessageDialog(null, "Informe outro Usuário para login .");
				telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			}
		}
		usuarioDao = new UsuarioDao();
		if (tipoUsuario != 0) {

			// TODO nova validacao nome
			if (nome == null || nome.trim() == "" || nome.isEmpty()) {
				telaCadatrosFuncionario.getTxtNome().setBorder(new LineBorder(new Color(255, 00, 00), 4));
				JOptionPane.showMessageDialog(null, "Nome vazio", "ok", JOptionPane.ERROR_MESSAGE, null);
			} else {
				funcionarioNovo.setNome(nome);
			}
			// cpf
			if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
				telaCadatrosFuncionario.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
				JOptionPane.showMessageDialog(null, "CPF vazio", "ok", JOptionPane.ERROR_MESSAGE);

			} else {
				funcionarioNovo.setCpf(Long.valueOf(cpfTxt));
			}
			// Coleta dados do usuario
			if (usuarioLogin == null || usuarioLogin.trim() == "" || usuarioLogin.isEmpty()) {
				validacao += "Usuário\n";
				telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));

			} else {

				if (funcionario.getCpf() != null) {
					usuario = usuarioDao.consultarUsuarioID(funcionario.getUsuario().getId());
					usuario.setUsuario(usuarioLogin);

				}

				if (funcionario.getCpf() == null) {
					boolean resultado = usuarioDao.consultarUsuarioExistente(usuarioLogin);
					if (resultado != true) {
						usuario.setUsuario(usuarioLogin);
					} else {
						JOptionPane.showMessageDialog(null, "Informe outro usuário para login");
					}

				}

			}
			if (senha == null || senha.trim() == "" || senha.isEmpty()) {
				validacao += "Usuário\n";
				telaCadatrosFuncionario.getTxtUsuario().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				usuario.setSenha(senha);
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
					String resultadoDia = dataTest.substring(0, 1);
					String resultadoMes = dataTest.substring(3, 4);
					int converterDia = Integer.valueOf(resultadoDia);
					int converteMes = Integer.valueOf(resultadoMes);
					System.out.println(converterDia + converteMes);
					if (converterDia <= 31 && converterDia > 0 && converteMes > 1 && converteMes < 13) {
						try {
							LocalDate data = LocalDate.parse(dataN, formatter);
							data.format(formatter);
							funcionarioNovo.setDataNascimento(data);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Data inválida", "Erro", JOptionPane.ERROR_MESSAGE);
					}

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
			resultadoEndereco = enderecoDao.consultarEndereco(endereco);

			boolean resuEnd = false;
			if (resultadoEndereco == null) {
				Estado estado = (Estado) telaCadatrosFuncionario.getCbxEstado().getSelectedItem();
				int idEstado = estado.getId();
				estado.setId(idEstado);

				endereco.setEstado(estado);

				// TODO cadastro do endereço

				try {
					resuEnd = enderecoDao.inserirEndereco(endereco);
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
					funcionarioNovo.setUsuario(usuario);
					funcionarioNovo.setEndereco(endereco);

				} catch (Exception el) {
					el.printStackTrace();
				}

			}
		}
		return funcionarioNovo;

	}

	public StatusTela editarFuncionario(Funcionario funcionario) {
		Usuario usuarioAlterado = new Usuario();
		Funcionario funcionarioConsulta = new Funcionario();
		usuario = new Usuario();
		usuarioDao  = new UsuarioDao();
		enderecoDao = new EnderecoDao();
		endereco = new Endereco();
		funcionarioDao = new FuncionarioDao();

		endereco = enderecoDao.consultarEndereco(funcionario.getEndereco());
		
		if (endereco == null) {
			int i = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o cep ?");
			if (i == JOptionPane.YES_OPTION) {
				boolean retorno = enderecoDao.inserirEndereco(funcionario.getEndereco());
				if (retorno == true) {
					JOptionPane.showMessageDialog(null, "Endereço cadastrado");
				} else {
					JOptionPane.showMessageDialog(null, "Endereço não cadastrado");
					return StatusTela.NAOEXIBIRMENSSAGEM;
				}
			} else {
				return StatusTela.NAOEXIBIRMENSSAGEM;
			}

		}
		if (!endereco.getBairro().equals(funcionario.getEndereco().getBairro())
				|| !endereco.getCidade().equals(funcionario.getEndereco().getCidade())
				|| !(endereco.getEstado().getId() == funcionario.getEndereco().getEstado().getId())
				|| !endereco.getRua().equals(funcionario.getEndereco().getRua())) {

			int i = JOptionPane.showConfirmDialog(null, "Deseja Alterar o endereço ?");
			if (i == JOptionPane.YES_OPTION) {
				boolean retorno = enderecoDao.alterarEndereco(funcionario.getEndereco());
				if (retorno == true) {
					JOptionPane.showMessageDialog(null, "Endereço cadastrado");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao editar endereco");
					return StatusTela.NAOEXIBIRMENSSAGEM;
				}
			} else {
				return StatusTela.NAOEXIBIRMENSSAGEM;
			}
		}
		
		
		
		// Consulta o id usuario
		funcionarioConsulta = funcionarioDao.consultaFuncionairoCPF(funcionario.getCpf());
		// consulta o usuario
		usuario = usuarioDao.consultarUsuarioID(funcionarioConsulta.getUsuario().getId());
		usuario.setNivelAcesso(2);
		// conferi se a mudança no usuario
		if ((!funcionario.getUsuario().getSenha().equals(usuario.getSenha())
				|| !funcionario.getUsuario().getUsuario().equals(usuario.getUsuario()))
				&& (funcionario.getUsuario().getNivelAcesso() != 0)) {

			// senha os novos dados
			long id = usuario.getId();
			usuario.setId(id);
			usuario.setNivelAcesso(2);
			usuario.setSenha(funcionario.getUsuario().getSenha());
			usuario.setUsuario(funcionario.getUsuario().getUsuario());

			usuario = usuarioDao.alterarUsuarioID(usuario);
		}
		if (usuario != null) {
			funcionario.setUsuario(usuario);
			Boolean retorno = funcionarioDao.alterarFuncionario(funcionario);
			if (retorno = true) {
				return StatusTela.FUNCIONARIEDITADO;
			}
		} else {

		}

		return StatusTela.ERROAOEDITAROFUNCIONARIO;

	}

	public StatusTela cadastrarFuncionario(Funcionario funcionario) {
		endereco = new Endereco();
		usuario = new Usuario();
		enderecoDao = new EnderecoDao();
		usuarioDao = new UsuarioDao();

		endereco = enderecoDao.consultarEndereco(funcionario.getEndereco());
		usuario = usuarioDao.consultarUsuario(funcionario.getUsuario());

		if (endereco.getCep() == null) {
			int i = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o cep ?");
			if (i == JOptionPane.YES_OPTION) {
				boolean retorno = enderecoDao.inserirEndereco(funcionario.getEndereco());
				if (retorno == true) {
					JOptionPane.showMessageDialog(null, "Endereço cadastrado");
				} else {
					JOptionPane.showMessageDialog(null, "Endereço não cadastrado");
					return StatusTela.NAOEXIBIRMENSSAGEM;
				}
			} else {
				return StatusTela.NAOEXIBIRMENSSAGEM;
			}

		}
		if (!endereco.getBairro().equals(funcionario.getEndereco().getBairro())
				|| !endereco.getCidade().equals(funcionario.getEndereco().getCidade())
				|| !(endereco.getEstado().getId() == funcionario.getEndereco().getEstado().getId())
				|| !endereco.getRua().equals(funcionario.getEndereco().getRua())) {

			int i = JOptionPane.showConfirmDialog(null, "Deseja Alterar o endereço ?");
			if (i == JOptionPane.YES_OPTION) {
				boolean retorno = enderecoDao.alterarEndereco(funcionario.getEndereco());
				if (retorno == true) {
					JOptionPane.showMessageDialog(null, "Endereço cadastrado");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao editar endereco");
					return StatusTela.NAOEXIBIRMENSSAGEM;
				}
			} else {
				return StatusTela.NAOEXIBIRMENSSAGEM;
			}

		}
		if (usuario != null) {
			return StatusTela.USUARIOEXISTENTE;
		}
		boolean retornoUsuairo = usuarioDao.inserirUsuario(funcionario.getUsuario());
		usuario = usuarioDao.consultarUsuario(funcionario.getUsuario());
		if (retornoUsuairo != true) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir o usuario");
			return StatusTela.NAOEXIBIRMENSSAGEM;
		}
		usuario = usuarioDao.consultarUsuario(funcionario.getUsuario());
		funcionario.setUsuario(usuario);
		funcionarioDao = new FuncionarioDao();
		boolean retornoMedico = funcionarioDao.cadastrarFuncionario(funcionario);
		if (retornoMedico == true) {
			return StatusTela.FUNCIONARIOCADASTRADO;
		}
		JOptionPane.showMessageDialog(null, "Erro ao inserir médico");
		return StatusTela.NAOEXIBIRMENSSAGEM;
	}

	
	public boolean excluirFuncionario(Funcionario funcionarioClick) {
		funcionarioDao = new FuncionarioDao();
		boolean result = funcionarioDao.excluirFuncionario(funcionarioClick);
		if (result == true) {
			return true;
		}
		return false;

	}

}
