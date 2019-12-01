package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			prepStmt.setLong(2, novaVenda.getDataDaVenda());
			prepStmt.set
		}
		
		return null;
	}

	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean alterar(Vendas entidade) {
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
