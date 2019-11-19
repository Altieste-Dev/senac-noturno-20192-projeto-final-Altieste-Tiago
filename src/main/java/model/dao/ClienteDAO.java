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

	
	public ArrayList consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean alterar(Cliente entidade) {
		// TODO Auto-generated method stub
		return false;
	}



	public Cliente consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
