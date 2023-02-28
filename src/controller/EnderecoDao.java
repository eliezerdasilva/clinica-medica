package controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Endereco;
import model.Usuario;

/**
 * Classe que representa o controller de endereço
 * 
 * @author eliezer
 * 
 *
 */
public class EnderecoDao implements IEnderecoDao {

	private Conexao con;

	/**
	 * Metodo que consulta cep cadastrar
	 * 
	 * @author eliezer
	 * @param ConsultaEndereco
	 * 
	 */
	@Override
	public Endereco ConsultarEndereco(Endereco endereco) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from endereco where cep = ? ");
			ps.setInt(1, endereco.getCep());

			ResultSet rs = ps.executeQuery();
			Endereco enderecoConfirmado = new Endereco();

			while (rs.next()) {
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean InserirEndereco(Endereco endereco) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement st = null;
		try {
			String query = "INSERT INTO endereco (cep, cidade,bairro,estado,rua)values(?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, endereco.getCep());
			stm.setString(2, endereco.getCidade());
			stm.setString(3, endereco.getBairro());
			stm.setString(4, endereco.getEstado());
			stm.setString(5, endereco.getRua());

			int valida = stm.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

}
