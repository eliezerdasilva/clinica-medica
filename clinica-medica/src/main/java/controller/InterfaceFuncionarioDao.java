package controller;

import model.Funcionario;

public interface InterfaceFuncionarioDao {
	
   public boolean cadastrarFuncionario(Funcionario funcionario);
	
	public boolean excluirFuncionario(Funcionario funcionario);
	
	public boolean alterarFuncionario(Funcionario funcionario);
	
	public Funcionario consultarFuncionario(Funcionario funcionario);

	boolean consultaCpf(Long cpf);
}
