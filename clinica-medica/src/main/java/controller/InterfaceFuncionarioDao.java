package controller;

import java.util.ArrayList;

import model.Funcionario;

public interface InterfaceFuncionarioDao {
	
   public boolean cadastrarFuncionario(Funcionario funcionario);
	
	public boolean excluirFuncionario(Funcionario funcionario);
	
	public boolean alterarFuncionario(Funcionario funcionario);
	
	public Funcionario consultarFuncionarioCPF(Funcionario funcionario);

	public boolean consultaCpfBoolean(Long cpf);
	
	public ArrayList<Funcionario> consultaCPFNome(String nome, long cpf);
	
	public ArrayList<Funcionario> consultarTodosFuncionario();
	
	public Funcionario consultaFuncionairoCPF(Long cpf);

}
