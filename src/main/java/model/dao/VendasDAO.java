package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Vendas;

public class VendasDAO implements BaseDAO<Vendas> {

	public Vendas salvar(Vendas novaVenda) {
		String sql = " INSERT INTO VENDAS (VALOR_REVENDA, DATA_VENDA, CLIENTE_IDCLIENTE, "
				+ "ESTOQUE_IDESTOQUE, VENDEDOR_IDVENDEDOR) "
				+ " VALUES(?,?,?,?,?)";
		
		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			prepStmt.setDouble(1,  novaVenda.getPrecoDeVenda());
			prepStmt.setDate(2, Date.valueOf(novaVenda.getDataDaVenda()));
			prepStmt.setInt(3, novaVenda.getCliente().getId());
			prepStmt.setInt(4, novaVenda.getVeiculo().getId());
			prepStmt.setInt(5, novaVenda.getVendedor().getId());
			
			prepStmt.execute();
			
			ResultSet rs = prepStmt.getGeneratedKeys();
			if(rs.next()) {
				novaVenda.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Vendedor. ");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novaVenda;
	}

//	public boolean excluir(int id) {
//		Connection conn = Banco.getConnection();
//		String sql = "DELETE FROM EMPREGADO WHERE ID = ?";
//		PreparedStatement prepStmt = Banco
//		return false;
//	}

	public boolean alterar(Vendas venda) {
		// TODO Auto-generated method stub
		return false;
	}

	public Vendas consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
