package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Modelo;

public class ModeloDAO implements BaseDAO<Modelo> {

	public Modelo salvar(Modelo novoModelo) {
				
		String sql = "INSERT INTO CARRO (MARCA, MODELO) " + "VALUES (?, ?)";
		
		Connection conn = Banco.getConnection();
		PreparedStatement  prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
			prepStmt.setString(1, novoModelo.getMarca());
			prepStmt.setString(2, novoModelo.getModelo());
			
			prepStmt.execute();
			
			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				novoModelo.setId(idGerado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o modelo. Erro: \n " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoModelo;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM CARRO WHERE ID=" + id;
		Statement stmt = Banco.getStatement(conn);
		
		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir telefone.");
			System.out.println("Erro: " + e.getMessage());
		}
		return quantidadeLinhasAfetadas > 0;
	}

	public boolean alterar(Modelo modelo) {
		Connection conn = Banco.getConnection();
		String sql = " UPDATE CARRO " + "SET marca=?, modelo=?" + "WHERE ID= ? ";
		
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quantidadeLinhasAfetadas =0;
		
		try {
			stmt.setString(1, modelo.getMarca());
			stmt.setString(2, modelo.getModelo());
			quantidadeLinhasAfetadas = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar telefone.");
			System.out.println("Erro: " + e.getMessage());
		}
		return quantidadeLinhasAfetadas > 0;
	}
	
	private Modelo construirModeloDoResultSet (ResultSet result) {
		Modelo modelo = new Modelo();
		
		try {
			modelo.setId(result.getInt("ID"));
			modelo.setMarca(result.getString("MARCA"));
			modelo.setModelo(result.getString("MODELO"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelo;
	}

	public Modelo consultarPorId(int id) {
		String sql = " SELECT * FROM PRODUTO " + "WHERE ID=?";
		
		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql);
		Modelo m = null;
		
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();
			
			while (result.next()) {
				m = new Modelo();
				
				m.setId(result.getInt("ID"));
				m.setMarca(result.getString("MARCA"));
				m.setModelo(result.getString("MODELO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return m;
	}

	public ArrayList<Modelo> consultarTodos() {
		String sql = " SELECT * FROM PRODUTO ";
		
		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql);
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		
		try {
			ResultSet result = prepStmt.executeQuery();
			
			while (result.next()) {
				Modelo m = new Modelo();
				
				m.setId(result.getInt("ID"));
				m.setMarca(result.getString("MARCA"));
				m.setModelo(result.getString("MODELO"));
				modelos.add(m);
			} 
		} catch (SQLException e) {
				e.printStackTrace();
			}
		return modelos;
	}

}
