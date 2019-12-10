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
			//stmt.setInt(0, novoVendedor.getId());
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
		String sql = " DELETE FROM VENDEDOR WHERE IDVENDEDOR = ?";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);


		boolean sucessoDelete = false;

		try {
			prepStmt.setInt(1, id);
			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}

		} catch (SQLException e){
			System.out.println("Erro ao excluir empregado.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoDelete;
	}

	public boolean alterar(Vendedor vendedor) {
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE VENDEDOR"
				+ " SET NOME=?, SEXO=?, CPF=?, CONTATO=?, COMISSAO=? "
				+ " WHERE IDVENDEDOR = ?";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		int registrosAlterados = 0;
		try {
			prepStmt.setString(1, vendedor.getNome());
			prepStmt.setString(2, vendedor.getSexo());
			prepStmt.setString(3, vendedor.getCpf());
			prepStmt.setString(4, vendedor.getCelular());
			prepStmt.setDouble(5, vendedor.getComissao());
			prepStmt.setInt(6, vendedor.getId());
			registrosAlterados = prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o vendedor. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return registrosAlterados > 0;
	}

	//	public Vendedor consultarPorId(int id) {
	//		String sql = " SELECT * FROM VENDEDOR " + "WHERE IDVENDEROR = " + id;
	//		Connection conn = Banco.getConnection();
	//		Statement stmt = Banco.getStatement(conn);
	//		
	//		Vendedor v = null;
	//		ResultSet rs = null;
	//		
	//		try {
	//			
	//			rs = stmt.executeQuery(sql);
	//
	//			while (rs.next()) {
	//				v = new Vendedor();
	//
	//				v.setIdVendedor(rs.getInt("IDVENDEDOR"));
	//				v.setNome(rs.getString("NOME"));
	//				v.setSexo(rs.getString("SEXO"));
	//				v.setCpf(rs.getString("CPF"));
	//				v.setCelular(rs.getString("CONTATO"));
	//				v.setComissao(rs.getDouble("COMISSAO"));
	//			}
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		} finally { 
	//			Banco.closeResultSet(rs);
	//			Banco.closePreparedStatement(stmt);
	//			Banco.closeConnection(conn);
	//		}
	//		
	//		
	//		return v;
	//				
	//	}

	public Vendedor consultarPorId(int id) {
		String sql = "SELECT * FROM VENDEDOR " + "WHERE id=?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		Vendedor v = null;

		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				v = new Vendedor();

				v.setId(result.getInt("id"));
				v.setNome(result.getString("NOME"));
				v.setSexo(result.getString("SEXO"));
				v.setCpf(result.getString("CPF"));
				v.setCelular(result.getString("CONTATO"));
				v.setComissao(result.getDouble("COMISSAO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

	public ArrayList<Vendedor> consultarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT IDVENDEDOR, NOME, SEXO, CPF, CONTATO, COMISSAO FROM VENDEDOR";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Vendedor v = construirVendedorDoResultSet(rs);
				vendedores.add(v);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar vendedores.");
			System.out.println("Erro: " + e.getMessage());
		}

		return vendedores;
	}

	private Vendedor construirVendedorDoResultSet(ResultSet result) {
		Vendedor v = new Vendedor();

		try {
			v.setId(result.getInt("IDVENDEDOR"));
			v.setNome(result.getString("NOME"));
			v.setSexo(result.getString("SEXO"));
			v.setCpf(result.getString("CPF"));
			v.setCelular(result.getString("CONTATO"));
			v.setComissao(result.getDouble("COMISSAO"));
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return v;
	}
}