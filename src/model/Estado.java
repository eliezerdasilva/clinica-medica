package model;

public class Estado {
	
	private int id;
	private String nome;
	private String uf;
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
	// TODO Auto-generated method stub
	System.out.println("211211 "+nome);
	return this.nome;
}


@Override
public boolean equals(Object obj) {
	System.out.println("qui");
   if(obj==null){
       return false;
   }

   if(obj instanceof Estado){
	   System.out.println("aqui2");
	   System.out.println(((Estado)obj).getId());
	   System.out.println(getId());
       return ((Estado)obj).getId() == getId();
   }else if (obj instanceof String){
       return nome.equals(obj);
   }else {
       // Or return false...
       return super.equals(obj);
   }
}
}
