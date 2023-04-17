package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import model.Convenio;
import model.Endereco;
import model.Medico;
import model.Paciente;
import model.Usuario;

public class MedicoDao implements InterfaceMedico {

	private Conexao con;

	@Override
	public boolean cadastrarMedico(Medico medico) {
		int retorno = 0;
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO medico(cpf, nome , sexo, email, telefone,data_nascimento, crm,especializacao, endereco_cep, numero,usuario_idusuario, complemento) values(?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, medico.getCpf());
			stm.setString(2, medico.getNome());
			stm.setString(3, medico.getSexo());
			stm.setString(4, medico.getEmail());
			stm.setString(5, medico.getTelefone());
			stm.setDate(6, Date.valueOf(medico.getDataNascimento()));
			stm.setLong(7, medico.getCrm());
			stm.setString(8, medico.getEspecializacao());

			stm.setInt(9, medico.getEndereco().getCep());
			stm.setInt(10, medico.getNumero());
			stm.setLong(11, medico.getUsuario().getId());
			stm.setString(12,medico.getComplemento());
			
			retorno = stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean alterarMedico(Medico medico) {

		con = Conexao.getInstacia();
		Connection c = con.conectar();
		PreparedStatement stm = null;
		try {
			stm = c.prepareStatement (
					
					"UPDATE medico SET nome = ?, sexo = ?, email = ?, telefone = ?, crm = ?, especializacao = ?, data_nascimento = ? WHERE cpf = ?"
					);
			
			stm.setString(1, medico.getNome());
			stm.setString(2, medico.getSexo());
			stm.setString(3, medico.getEmail());
			stm.setString(4, medico.getTelefone());
			stm.setLong(5, medico.getCrm());
			stm.setString(6, medico.getEspecializacao());
			stm.setDate(7, Date.valueOf(medico.getDataNascimento()));
			stm.setLong(8, medico.getCpf());
				
			
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		

		return false;
	}

	@Override
	public boolean consultarMedico(Long cpf) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		try {
			PreparedStatement ps = c.prepareStatement("select * from medico where crm = ? ");
			ps.setLong(1, cpf);

			ResultSet rs = ps.executeQuery();
			Medico medico1 = new Medico();

			while (rs.next()) {
				Long crm = rs.getLong("crm");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				Date data_nascimento = rs.getDate("data_nascimento");
				String especializacao = rs.getString("especializacao");
				Long cpf1 = rs.getLong("cpf");		

			   LocalDate localDate = data_nascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				medico1.setCrm(crm);
				medico1.setNome(nome);
				medico1.setSexo(sexo);
				medico1.setEmail(email);
				medico1.setTelefone(telefone);
				medico1.setDataNascimento(localDate);
				medico1.setEspecializacao(especializacao);
				medico1.setCpf(cpf1);
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean excluirMedico(Medico medico) {
		con = Conexao.getInstacia();
		Connection c = con.conectar();
	
		try {
			
			String query = "DELETE FROM medico WHERE crm = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, medico.getCrm());
			stm.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean ConsultaCpfMedico(Long cpf) {
		/**
		 * Consultar se tem medico já cadastrado
		 */
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		boolean resultado = false; 
		try {
			PreparedStatement ps = c.prepareStatement("select * from medico");

			ResultSet rs = ps.executeQuery();

			ArrayList<Paciente> paciente = new ArrayList<>();
			Paciente paciente2 = new Paciente();
			while (rs.next()) {
				paciente2.setCpf(rs.getLong("cpf"));
				paciente.add(paciente2);
				
				
			}
			for (Paciente p : paciente) {
				if(paciente2.getCpf().equals(cpf)) {
					resultado = true;
				}else {
					resultado = false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}
	@Override
	public ArrayList<Medico> listaMedicos() {
		
		con = Conexao.getInstacia();
		Connection c = con.conectar();
		ArrayList<Medico> listMedicos = new ArrayList<>();
		try {
			
			PreparedStatement ps = c.prepareStatement("Select * from medico");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
							
				Medico medico  =  new Medico();
				Endereco endereco = new Endereco();
				Usuario usuario = new Usuario();
				
				medico.setCpf(rs.getLong("cpf"));
				medico.setNome(rs.getString("nome"));
				medico.setSexo(rs.getString("sexo"));
				medico.setEmail(rs.getString("email"));
				medico.setTelefone(rs.getString("telefone"));
				medico.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				medico.setCrm(rs.getLong("crm"));
				medico.setEspecializacao(rs.getString("especializacao"));
				endereco.setCep(rs.getInt("endereco_cep"));
				medico.setEndereco(endereco);
				medico.setNumero(rs.getInt("numero"));
				usuario.setId(rs.getLong("usuario_idusuario"));
				medico.setUsuario(usuario);				
				medico.setComplemento(rs.getString("complemento"));
				
				listMedicos.add(medico);
				
						 
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		return listMedicos;
	}
	
	
	

}
