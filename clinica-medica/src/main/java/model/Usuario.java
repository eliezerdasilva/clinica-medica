package model;

import java.util.Objects;

public class Usuario {

	private Long id;
	private String usuario;
	protected String senha;
	protected int nivelAcesso;

	public Usuario() {

	}
	

	public Usuario(String usuario, String senha, int nivelAcesso) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}


	public Usuario(String usuario, String senha) {
		
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario(Long id, String usuario, String senha, int nivelAcesso) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public final String getUsuario() {
		return usuario;
	}

	public final void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public final String getSenha() {
		return senha;
	}

	public final void setSenha(String senha) {
		this.senha = senha;
	}

	public final int getNivelAcesso() {
		return nivelAcesso;
	}

	public final void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nivelAcesso, senha, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && nivelAcesso == other.nivelAcesso && Objects.equals(senha, other.senha)
				&& Objects.equals(usuario, other.usuario);
	}
	

}