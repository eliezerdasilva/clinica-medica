package helper;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import controller.EnderecoDao;
import model.Endereco;
import model.Estado;
import model.Paciente;
import model.StatusTela;
import view.TelaCadastroFuncionario;
import view.TelaCadastroPaciente;

public class ManterPacienteHelper {

	private Endereco endereco;
	private EnderecoDao enderecoDao;

	public Endereco setarObjetoEndereco(TelaCadastroPaciente telaCadastroPaciente) {

		StatusTela statusTela = null;
		endereco = new Endereco();
		enderecoDao = new EnderecoDao();
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco resultadoEndereco = new Endereco();
		String cepString = telaCadastroPaciente.getTxtCep().getText().replace(".", "").replace("-", "");

		String cidade = telaCadastroPaciente.getTxtMunicipio().getText();
		telaCadastroPaciente.getTxtCep().setEditable(false);
		String bairro = telaCadastroPaciente.getTxtBairro().getText();
		String rua = telaCadastroPaciente.getTxtRua().getText();
		String validacao = "";

		if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
			validacao += " Cep\n";
			telaCadastroPaciente.getTxtCep().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			Integer cep = Integer.valueOf(cepString);
			endereco.setCep(cep);
		}

		if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
			validacao += " Bairro\n";
			telaCadastroPaciente.getTxtBairro().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setBairro(bairro);
		}
		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			validacao += " Cidade\n";
			telaCadastroPaciente.getTxtMunicipio().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setCidade(cidade);
		}
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			validacao += " Rua\n";
			telaCadastroPaciente.getTxtRua().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setRua(rua);
		}

		if (validacao.trim() != "") {
			JOptionPane.showMessageDialog(null, validacao, "Dados inválidos:", JOptionPane.ERROR_MESSAGE, null);
		}

		int posicao = telaCadastroPaciente.getCbxEstado().getSelectedIndex();
		Estado estado = new Estado();
		estado.setId(posicao + 1);
		endereco.setEstado(estado);

		resultadoEndereco = enderecoDao.ConsultarEndereco(endereco);

		if (validacao.trim() == "") {
			return endereco;
		}
		JOptionPane.showMessageDialog(null, validacao);
		return null;

	}

	public Paciente setarObejtoFuncinario(TelaCadastroPaciente telaCadastroPaciente) {
		
		String validacao = "";
		Paciente paciente = new Paciente();
		
		String nome = telaCadastroPaciente.getTxtNome().getText();

		String cpfTxt = telaCadastroPaciente.getTxtCpf().getText().replace(".", "").replace("-", "");

		String sexo = "";
		if (telaCadastroPaciente.getJrbFemi().isSelected()) {
			sexo = "F";
		}
		if (telaCadastroPaciente.getJrbMasc().isSelected()) {
			sexo = "M";
		}
		if (telaCadastroPaciente.getJrbMasc() == null || telaCadastroPaciente.getJrbFemi() == null) {
			sexo = null;
		}
		String email = telaCadastroPaciente.getTxtEmail().getText();

		String telefone = telaCadastroPaciente.getTxtTelefone().getText().replace("-", "").replace("(", "")
				.replace(")", "");

		String dataN = telaCadastroPaciente.getTxtData().getText();

		String complemento = telaCadastroPaciente.getTxtComplemento().getText();

		String numeroCasa = telaCadastroPaciente.getTxtNCasa().getText();

		String profissao = telaCadastroPaciente.getTxtProfissao().getText();
		


		// TODO nova validacao nome
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			telaCadastroPaciente.getTxtNome().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Nome\n";
		} else {
			telaCadastroPaciente.getTxtNome().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setNome(nome);
		}
		// cpf

		if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
			telaCadastroPaciente.getTxtCpf().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "CPF\n";
		} else {
			telaCadastroPaciente.getTxtCpf().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Long cpf = Long.valueOf(cpfTxt);
			Long cpfConsulta = Long.valueOf(cpfTxt);
			paciente.setCpf(cpf);
		}
		// sexo

		if (sexo == null || sexo.isEmpty()) {
			telaCadastroPaciente.getJrbFemi().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			telaCadastroPaciente.getJrbMasc().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Sexo\n";
		} else {
			telaCadastroPaciente.getJrbFemi().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			telaCadastroPaciente.getJrbMasc().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setSexo(sexo);
		}
		// email
		if (email == null || email.trim() == "" || email.isEmpty()) {
			telaCadastroPaciente.getTxtEmail().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Email\n";
		} else {
			telaCadastroPaciente.getTxtEmail().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
			telaCadastroPaciente.getTxtTelefone().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Telefone\n";
		} else {
			telaCadastroPaciente.getTxtTelefone()..setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setTelefone(telefone);

		}
		// profissao
		if (profissao == null || profissao.trim() == "" || profissao.isEmpty()) {
			telaCadastroPaciente.getTxtProfissao().setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Profissao\n";
		} else {
			telaCadastroPaciente.getTxtProfissao().setBorder(new LineBorder(new Color(00, 00, 00), 1));
			paciente.setProfissao(profissao);
		}
		// convenio
		if (convenio == null || convenio.isEmpty()) {
			cbxConvenio.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Convenio\n";
		} else {

			// cbx.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Convenio convenios = (Convenio) cbxConvenio.getSelectedItem();
			int id = convenios.getId();
			String convenio = convenios.getConvenio();

			p.setConvenio(convenios);

		}

		// data Nascimento
		if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
			validacao += "Data\n";
			txtData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			String dataTest = dataN.replace("/", "").trim();
			if (dataTest.length() == 0) {
				validacao += "Data\n";
				txtData.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			} else {
				txtData.setBorder(new LineBorder(new Color(00, 00, 00), 1));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dta = LocalDate.parse(dataN, formatter);
				dta.format(formatter);
				p.setDataNascimento(dta);
			}

		}

		// Complemento
		p.setComplemento(complemento);

		if (n == null || n.trim() == "" || n.isEmpty()) {
			validacao += "Numero\n";
			txtNCasa.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtNCasa.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Integer nCasa = Integer.valueOf(n);
			p.setNumero(nCasa);
		}
		// TODO CADASTRO DO CEP NAO CADASTRADO

		// Validacao endereco
		String cepString = txtCep.getText().replace("-", "");
		String bairro = txtBairro.getText();
		String cidade = txtMunicipio.getText();
		String rua = txtRua.getText();

		if (cadastroEndereco == null) {
			cadastroEndereco = new Endereco();
		}

		EnderecoDao endereco = new EnderecoDao();

		if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
			validacao += "Cep\n";
			txtCep.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtCep.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Integer cep = Integer.valueOf(cepString);
			cadastroEndereco.setCep(cep);
		}

		if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
			validacao += "Bairro\n";
			txtBairro.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtBairro.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			cadastroEndereco.setBairro(bairro);
		}

		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			validacao += "Cidade\n";
			txtMunicipio.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtMunicipio.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			cadastroEndereco.setCidade(cidade);
		}

		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			validacao += "Rua\n";
			txtRua.setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			txtRua.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			cadastroEndereco.setRua(rua);
		}

		if (validacao.trim() != "") {
			JOptionPane.showMessageDialog(null, validacao, "Adicione:", JOptionPane.ERROR_MESSAGE, null);
			return;
		}

		Endereco resultado = new Endereco();
		resultado = endereco.ConsultarEndereco(cadastroEndereco);

		if (resultado == null) {
			Estado estado = (Estado) cbxEstado.getSelectedItem();
			int id = estado.getId();
			estado.setId(id);

			cadastroEndereco.setEstado(estado);

			// TODO cadastro do endereço
			boolean resuEnd = false;
			try {
				resuEnd = enderecoDao.inserirEndereco(cadastroEndereco);
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		Long cpfConsulta = null;
		// TODO ver se paciente existe
		boolean resultadoPacienteCadastrado = pacienteDao.ConsultaCpfPaciente(cpfConsulta);

		if (resultadoPacienteCadastrado != true) {
			resultado = endereco.ConsultarEndereco(cadastroEndereco);

			if (resultado != null) {
				boolean cds = false;

				try {
					// Inserir o endereco no paciente
					p.setEndereco(cadastroEndereco);
					cds = pacienteDao.cadastrarPaciente(p);
					limparTela();

		return null;
		
	}
			}
}
	}
}
