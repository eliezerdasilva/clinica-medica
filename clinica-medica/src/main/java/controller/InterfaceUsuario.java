package controller;

import model.Usuario;

public interface InterfaceUsuario {

	public boolean inserirUsuario(Usuario usuario);
	
	public boolean deletarUsuario(Usuario usuario);
	 
	public Usuario alterarUsuario(Usuario usuario);
	
	public Usuario consultarUsuarioCadastrado(Usuario usuarioModelo);
	
	public Usuario selecionarUSuarioParaCadastrar(Usuario usuarioModelo);
	
	public Usuario consultarUsuarioID(Long id);
	
	public boolean consultarUsuarioExistente(String Usuario);
	public Usuario alterarUsuarioID(Usuario usuario);

}
