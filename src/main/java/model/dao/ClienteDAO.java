package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Cliente;

public class ClienteDAO implements BaseDAO<Cliente>{

	public Cliente salvar(Cliente novoCliente) {
		String sql = "INSERT INTO CLIENTE (NOME, SEXO, CPF, TEL_RESIDENCIAL,"
				+ " TEL_CELULAR, DATA_NASCIMENTO) "
				+ "VALUES (?,?,?,?,?,?)";
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
		try {
			stmt.setString(1, novoCliente.getNome());
			stmt.setString(2, novoCliente.getSexo());
			stmt.setString(3, novoCliente.getCpf());
			stmt.setString(4, novoCliente.getResidencial());
			stmt.setString(5, novoCliente.getCelular());
			stmt.setDate(6, novoCliente.getDataNascimento());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				novoCliente.setId(rs.getInt(1));
			}
			} catch (SQLException e) {
				System.out.println("Erro ao inserir novo Cliente. ");
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conn);
			}
		
		return novoCliente;

	}

	

	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		String sql = "DELETE FROM EMPREGADO WHERE ID =  ?";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		
		boolean sucessoDelete = false;
		
		try {
			prepStmt.setInt(1, id);
			int codigoRetorno = prepStmt.executeUpdate();
			
			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return sucessoDelete;
	}

	
	public boolean alterar(Cliente cliente) {
		boolean sucessoUpdate = false;
		
		Connection conn = Banco.getConnection();
		String sql = " UPDATE CLIENTE" 
				+ "SET NOME=?, SEXO=?,CPF=?, TEL_RESIDENCIAL=?, TEL_CELULAR=?"
				+ "DATA_NASCIMENTO=? "
				+ "WHERE ID = ?";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql);
		int registrosAlterados =0;
		try {
			prepStmt.setString(1, cliente.getNome());
			prepStmt.setString(2, cliente.getSexo());
			prepStmt.setString(3, cliente.getCpf());
			prepStmt.setString(4, cliente.getResidencial());
			prepStmt.setString(5, cliente.getCelular());
			prepStmt.setDate(6, cliente.getDataNascimento());
			registrosAlterados = prepStmt.executeUpdate();
			
			if (registrosAlterados == 1) {
				sucessoUpdate = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o vendedor. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		
		return sucessoUpdate;
	}


	public ArrayList<Cliente> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM CLIENTE ";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				Cliente c = construirClienteDoResultSet(rs);
				clientes.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
		}
		
				
		return clientes;
	}
	

	public Cliente consultarPorId(int id) {
		String sql = "SELECT * FROM CLIENTE " + "WHERE ID=?";
		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql);
		Cliente c = null;
		
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();
			
			while (result.next()) {
			c = new Cliente();
			
			c.setId(result.getInt("ID"));
			c.setNome(result.getString("NOME"));
			c.setSexo(result.getString("SEXO"));
			c.setCpf(result.getString("CPF"));
			c.setResidencial(result.getString("TEL_RESIDENCIAL"));
			c.setCelular(result.getString("TEL_CELULAR"));
			c.setDataNascimento(result.getDate("DATA_NASCIMENTO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	private Cliente construirClienteDoResultSet (ResultSet result) {
		Cliente c = new Cliente();
		
		try {
			c.setId(result.getInt("ID"));
			c.setNome(result.getString("NOME"));
			c.setSexo(result.getString("SEXO"));
			c.setCpf(result.getString("CPF"));
			c.setResidencial(result.getString("TEL_RESIDENCIAL"));
			c.setCelular(result.getString("TEL_CELULAR"));
			c.setDataNascimento(result.getDate("DATA_NASCIMENTO"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
