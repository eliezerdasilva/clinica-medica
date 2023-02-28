package controller;

import model.Usuario;

public interface InterfaceLogin {
	
	
	public Usuario ConferirLogin(Usuario usuario);

	Boolean consularLogin(Usuario usuario);

	Boolean preenchido(Usuario usuario);
	

}
