package controller;

import java.util.ArrayList;

import model.Funcionario;

public interface InterfaceFuncionarioDao {
	
   public boolean cadastrarFuncionario(Funcionario funcionario);
	
	public boolean excluirFuncionario(Funcionario funcionario);
	
	public boolean alterarFuncionario(Funcionario funcionario);
	
	public Funcionario consultarFuncionario(Funcionario funcionario);

	public boolean consultaCpf(Long cpf);
	
	public ArrayList<Funcionario> consultaCPFNome(String nome, long cpf);
	
	public ArrayList<Funcionario> consultarTodosFuncionario();
	
	public Funcionario consultaERetornarCPF(Long cpf);

}
