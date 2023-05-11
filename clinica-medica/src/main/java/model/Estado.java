package model;

public class Estado {

	private int id;
	private String nome;
	private String uf;

	public Estado() {
		super();
	}

	public Estado(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Estado(int id, String nome, String uf) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof Estado) {
			return ((Estado) obj).getId() == getId();
		} else if (obj instanceof String) {
			return nome.equals(obj);
		} else {
			// Or return false...
			return super.equals(obj);
		}
	}
}
