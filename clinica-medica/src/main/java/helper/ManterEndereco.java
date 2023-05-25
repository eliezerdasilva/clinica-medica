package helper;

import controller.EnderecoDao;
import model.Endereco;
import model.StatusTela;

public class ManterEndereco {
	
	private EnderecoDao enderecoDao;
	
	public StatusTela consultarEndereco(Endereco endereco) {
		
		Endereco enderecoBD = enderecoDao.ConsultarEndereco(endereco);
		if(endereco.equals(enderecoBD)) {
			
		}
		if(enderecoBD.equals(null)) {
			Boolean resultado = enderecoDao.inserirEndereco(enderecoBD);
			if(resultado.equals(true)) {
				return StatusTela.ENDERECOCADASTRADO;
			}
				return StatusTela.ERROCADASTRARENDERECO;
			
		}else {
			Boolean retorno =  enderecoDao.alterarEndereco(endereco);
			if(retorno.equals(true)) {
				return StatusTela.ENDERECOALTERADO;
			}
			return StatusTela.ERROALTERARENDERECO;
		}
		
	
	}
	

}
