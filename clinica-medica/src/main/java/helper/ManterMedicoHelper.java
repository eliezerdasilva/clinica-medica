package helper;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import controller.EnderecoDao;
import model.Convenio;
import model.Endereco;
import model.Estado;
import model.Medico;
import model.Paciente;
import model.StatusTela;
import view.TelaCadastroMedico;

public class ManterMedicoHelper {
	
	private Endereco endereco;
	private EnderecoDao enderecoDao;

	public Endereco setarObjetoEndereco(TelaCadastroMedico telaCadastroMedico) {

		StatusTela statusTela = null;
		endereco = new Endereco();
		enderecoDao = new EnderecoDao();
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco resultadoEndereco = new Endereco();
		String cepString = telaCadastroMedico.getTxtCep().getText().replace(".", "").replace("-", "");

		String cidade = telaCadastroMedico.getTxtMunicipio().getText();
		telaCadastroMedico.getTxtCep().setEditable(false);
		String bairro = telaCadastroMedico.getTxtBairro().getText();
		String rua = telaCadastroMedico.getTxtRua().getText();
		String validacao = "";

		if (cepString == null || cepString.trim() == "" || cepString.isEmpty()) {
			validacao += " Cep\n";
			telaCadastroMedico.getTxtCep().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			Integer cep = Integer.valueOf(cepString);
			endereco.setCep(cep);
		}

		if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
			validacao += " Bairro\n";
			telaCadastroMedico.getTxtBairro().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setBairro(bairro);
		}
		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			validacao += " Cidade\n";
			telaCadastroMedico.getTxtMunicipio().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setCidade(cidade);
		}
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			validacao += " Rua\n";
			telaCadastroMedico.getTxtRua().setBorder(new LineBorder(new Color(255, 00, 00), 4));
		} else {
			endereco.setRua(rua);
		}

		if (validacao.trim() != "") {
			JOptionPane.showMessageDialog(null, validacao, "Dados inválidos:", JOptionPane.ERROR_MESSAGE, null);
		}

		int posicao = telaCadastroMedico.getCbxEstado().getSelectedIndex();
		Estado estado = new Estado();
		estado.setId(posicao + 1);
		endereco.setEstado(estado);

		resultadoEndereco = enderecoDao.ConsultarEndereco(endereco);
		
		if(validacao.trim() == "") {
			return endereco;
		}
		JOptionPane.showMessageDialog(null, validacao);
		return null; 
	
	}

	public Medico setarObjetoMedico(TelaCadastroMedico telaCadastroMedico) {
		
		String validacao = "";
		Medico medico = new Medico();
		
		String nome = telaCadastroMedico.getTxtNome().getText();

		String cpfTxt = telaCadastroMedico.getTxtCpf().getText().replace(".", "").replace("-", "");

		String sexo = "";
		if (telaCadastroMedico.getRdbtnFeminino1().isSelected()) {
			sexo = "F";
		}
		if (telaCadastroMedico.getRdbtnMasculino1().isSelected()) {
			sexo = "M";
		}
		if (telaCadastroMedico.getRdbtnMasculino1() == null || telaCadastroMedico.getRdbtnFeminino1() == null) {
			sexo = null;
		}
		String email = telaCadastroMedico.getTxtEmail().getText();

		String telefone = telaCadastroMedico.getTxtTelefone().getText().replace("-", "").replace("(", "")
				.replace(")", "");

		String dataN = telaCadastroMedico.getTxtData().getText();

		String complemento = telaCadastroMedico.getTxtComplemento().getText();

		String numeroCasa = telaCadastroMedico.getTxtCasaNumero().getText();

		String usuarioLogin = telaCadastroMedico.getTxtUsuario().getText();

		String senha = telaCadastroMedico.getTxtSenha().getText();

		

		// TODO nova validacao nome
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			txtNome.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Nome\n";
		} else {
			txtNome.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			p.setNome(nome);
		}
		// cpf

		if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
			txtCpf.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "CPF\n";
		} else {
			txtCpf.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			Long cpf = Long.valueOf(cpfTxt);
			Long cpfConsulta = Long.valueOf(cpfTxt);
			p.setCpf(cpf);
		}
		// sexo

		if (sexo == null || sexo.isEmpty()) {
			jrbFemi.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			jrbMasc.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Sexo\n";
		} else {
			jrbFemi.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			jrbMasc.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			p.setSexo(sexo);
		}
		// email
		if (email == null || email.trim() == "" || email.isEmpty()) {
			txtEmail.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Email\n";
		} else {
			txtEmail.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			p.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
			txtTelefone.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Telefone\n";
		} else {
			txtTelefone.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			p.setTelefone(telefone);

		}
		// profissao
		if (profissao == null || profissao.trim() == "" || profissao.isEmpty()) {
			txtProfissao.setBorder(new LineBorder(new Color(255, 00, 00), 4));
			validacao += "Profissao\n";
		} else {
			txtProfissao.setBorder(new LineBorder(new Color(00, 00, 00), 1));
			p.setProfissao(profissao);
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
		
		return ;
		
	}
}
