package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Vendedor;

public class VendedorDAO implements BaseDAO<Vendedor> {

	public Vendedor salvar(Vendedor novoVendedor) {
		String sql = "INSERT INTO VENDEDOR (NOME, SEXO, CPF,"
				+ " CONTATO, COMISSAO) "
				+ "VALUES(?,?,?,?,?)";
		
	Connection conn = Banco.getConnection();
	PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
	
	try {
		stmt.setString(1, novoVendedor.getNome());
		stmt.setString(2, novoVendedor.getSexo());
		stmt.setString(3, novoVendedor.getCpf());
		stmt.setString(4, novoVendedor.getCelular());
		stmt.setDouble(5, novoVendedor.getComissao());
		
	stmt.execute();
	
	ResultSet rs = stmt.getGeneratedKeys();
	if(rs.next()) {
		novoVendedor.setId(rs.getInt(1));
	}
	} catch (SQLException e) {
		System.out.println("Erro ao inserir novo Vendendor. ");
		System.out.println("Erro: " + e.getMessage());
	
	}
				
		return novoVendedor;
	}

	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		Statement statement = Banco.getStatement(conexao);
		String sql = " DELETE FROM EMPREGADO WHERE ID = " + id;
		
		int quantidadeRegistrosExcluidos = 0;
		try {
			quantidadeRegistrosExcluidos = statement.executeUpdate(sql);
		} catch (SQLException e){
			System.out.println("Erro ao excluir empregado.");
			System.out.println("Err: " + e.getMessage());
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(conexao);
		}
		
		return quantidadeRegistrosExcluidos > 0;
	}

	public boolean alterar(Vendedor novoVendedor) {
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE VENDEDOR"
				+ " SET NOME=?, SEXO=?, CPF=?, CONTATO=?, COMISSAO=? "
				+ " WHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int registrosAlterados = 0;
		try {
			stmt.setString(1, novoVendedor.getNome());
			stmt.setString(2, novoVendedor.getSexo());
			stmt.setString(novoVendedor.getCpf());
			stmt.setString(4, novoVendedor.getCelular());
			stmt.setDouble(5, novoVendedor.getComissao());
			registrosAlterados = stmt.executeUpdate();
			
			
		}
		return false;
	}

	public Vendedor consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Vendedor> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
