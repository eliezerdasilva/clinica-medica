package model;

public class Convenio {
	
	private int id;
	private String convenio;
	
	
	
	
	public Convenio() {
		super();
	}
	public Convenio(int id, String convenio) {
		super();
		this.id = id;
		this.convenio = convenio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	@Override
	public String toString() {
		return  convenio ;
	}
	
	

}
