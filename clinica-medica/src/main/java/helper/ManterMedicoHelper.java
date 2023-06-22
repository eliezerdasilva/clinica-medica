package helper;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import controller.EnderecoDao;
import controller.MedicoDao;
import controller.UsuarioDao;
import model.Endereco;
import model.Estado;
import model.Medico;
import model.StatusTela;
import model.Usuario;
import view.TelaCadastroMedico;

public class ManterMedicoHelper {

	private Endereco endereco;
	private EnderecoDao enderecoDao;
	private MedicoDao medicoDao;
	private UsuarioDao usuarioDao;
	private Usuario usuario;

	public StatusTela cadastrarMedico(Medico medico) {

		endereco = new Endereco();
		usuario = new Usuario();
		enderecoDao = new EnderecoDao();
		usuarioDao = new UsuarioDao();

		endereco = enderecoDao.consultarEndereco(medico.getEndereco());
		usuario = usuarioDao.consultarUsuario(medico.getUsuario());

		if (endereco == null) {
			int i = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o cep ?");
			if (i == JOptionPane.YES_OPTION) {
				boolean retorno = enderecoDao.inserirEndereco(medico.getEndereco());
				endereco = medico.getEndereco();
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
		if (!endereco.getBairro().equals(medico.getEndereco().getBairro())
				|| !endereco.getCidade().equals(medico.getEndereco().getCidade())
				|| !(endereco.getEstado().getId() == medico.getEndereco().getEstado().getId())
				|| !endereco.getRua().equals(medico.getEndereco().getRua())) {

			int i = JOptionPane.showConfirmDialog(null, "Deseja Alterar o endereço ?");
			if (i == JOptionPane.YES_OPTION) {
				boolean retorno = enderecoDao.alterarEndereco(medico.getEndereco());
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
		boolean retornoUsuairo = usuarioDao.inserirUsuario(medico.getUsuario());
		usuario = usuarioDao.consultarUsuario(medico.getUsuario());
		if (retornoUsuairo != true) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir o usuario");
			return StatusTela.NAOEXIBIRMENSSAGEM;
		}
		usuario = usuarioDao.consultarUsuario(medico.getUsuario());
		medico.setUsuario(usuario);
		medicoDao = new MedicoDao();
		boolean retornoMedico = medicoDao.cadastrarMedico(medico);
		if (retornoMedico == true) {
			return StatusTela.MEDICOCADASTRADO;
		}
		JOptionPane.showMessageDialog(null, "Erro ao inserir médico");
		return StatusTela.NAOEXIBIRMENSSAGEM;

	}

	public StatusTela alterarMedico(Medico medico) {

		endereco = new Endereco();
		usuario = new Usuario();
		enderecoDao = new EnderecoDao();
		usuarioDao = new UsuarioDao();
		medicoDao = new MedicoDao();
		var medicoConsulta = new Medico();
		medicoConsulta = medicoDao.consultaDadosMedicoCPF(medico.getCpf());

		if (medicoConsulta == null) {
			return StatusTela.MEDICONAOCADASTRADO;
		}
		endereco = enderecoDao.consultarEndereco(medico.getEndereco());
		usuario = usuarioDao.consultarUsuarioID(medico.getUsuario().getId());

		if (endereco.getCep() == null) {
			int i = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o cep ?");
			if (i == JOptionPane.YES_OPTION) {
				boolean retorno = enderecoDao.inserirEndereco(medico.getEndereco());
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
		if (!endereco.getBairro().equals(medico.getEndereco().getBairro())
				|| !endereco.getCidade().equals(medico.getEndereco().getCidade())
				|| !(endereco.getEstado().getId() == medico.getEndereco().getEstado().getId())
				|| !endereco.getRua().equals(medico.getEndereco().getRua())) {

			int i = JOptionPane.showConfirmDialog(null, "Deseja Alterar o endereço ?");
			if (i == JOptionPane.YES_OPTION) {
				boolean retorno = enderecoDao.alterarEndereco(medico.getEndereco());
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
		if(usuario.getId() == null) {
			int i = JOptionPane.showConfirmDialog(null, "Deseja alterar o usuário ?");
			if (i == JOptionPane.YES_OPTION) {
				usuario = usuarioDao.consultarUsuario(medico.getUsuario());
				if(usuario == null) {
					usuario = usuarioDao.alterarUsuarioID(medico.getUsuario());
					if (usuario != null) {
						JOptionPane.showMessageDialog(null, "Usuario Alterado");
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao alterara o usuário");
						return StatusTela.NAOEXIBIRMENSSAGEM;
					}
				}else {
					 return StatusTela.USUARIOEXISTENTE;
				}
				
			} else {
				return StatusTela.NAOEXIBIRMENSSAGEM;
			}
		}
	   boolean retorno = medicoDao.alterarMedico(medico);
	   if(retorno ==true) {
		   return StatusTela.MEDICOEDITADO;
	   }

		return null;
	}
}
