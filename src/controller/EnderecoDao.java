package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Endereco;
import model.Usuario;

public class EnderecoDao implements IEnderecoDao{

	private Conexao con;
	
	@Override
	public Endereco ConsultarEndereco(Endereco endereco) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from endereco where cep = ? ");
			ps.setInt(1, endereco.getCep());
			
			ResultSet rs = ps.executeQuery();
			Endereco enderecoConfirmado = new Endereco();

			while(rs.next()) {
				int cep = rs.getInt("cep");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String estado = rs.getString("estado");
				String rua = rs.getString("rua");
				
				enderecoConfirmado.setCep(cep);
				enderecoConfirmado.setCidade(cidade);
				enderecoConfirmado.setBairro(bairro);
				enderecoConfirmado.setEstado(estado);
				enderecoConfirmado.setRua(rua);
				
				return enderecoConfirmado;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Endereco InserirEndereco(Endereco endereco) {
		// TODO Auto-generated method stub
		return null;
	}

}
