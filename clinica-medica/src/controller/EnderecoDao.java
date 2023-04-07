package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Endereco;
import model.Estado;

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
			PreparedStatement ps = c.prepareStatement(
					"select endereco.*, estados.id as id_estado, estados.nome as nome_estado, estados.uf as uf_estado from endereco inner join estados on estados.id = endereco.id_estado where cep = ? ");
			ps.setInt(1, endereco.getCep());

			ResultSet rs = ps.executeQuery();
			Endereco enderecoConfirmado = new Endereco();

			while (rs.next()) {
				int cep = rs.getInt("cep");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");

				String nome_estado = rs.getString("nome_estado");
				String uf_estado = rs.getString("uf_estado");
				int id_estado = rs.getInt("id_estado");

				Estado e = new Estado();
				e.setId(id_estado);
				e.setNome(nome_estado);
				e.setUf(uf_estado);

				enderecoConfirmado.setCep(cep);
				enderecoConfirmado.setCidade(cidade);
				enderecoConfirmado.setBairro(bairro);
				enderecoConfirmado.setEstado(e);
				enderecoConfirmado.setRua(rua);

				return enderecoConfirmado;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

	@Override
	public boolean InserirEndereco(Endereco endereco) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement st = null;
		int valida = 0;
		try {
			String query = "INSERT INTO endereco (cep, cidade,bairro,id_estado,rua)values(?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, endereco.getCep());
			stm.setString(2, endereco.getCidade());
			stm.setString(3, endereco.getBairro());
			stm.setInt(4, endereco.getEstado().getId());
			stm.setString(5, endereco.getRua());

			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return (valida == 0 ? false : true);
	}

	@Override
	public ArrayList<Estado> ConsultaEstadoCidade() {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from estados");

			ResultSet rs = ps.executeQuery();

			ArrayList<Estado> endereco = new ArrayList<Estado>();
			while (rs.next()) {
				Estado estado = new Estado();

				estado.setId(rs.getInt("id"));
				estado.setNome(rs.getString("nome"));
				estado.setUf(rs.getString("uf"));
				endereco.add(estado);

			}
			return endereco;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
