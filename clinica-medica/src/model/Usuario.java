package model;

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

}