package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Veiculo;

public class VeiculoDAO implements BaseDAO<Veiculo> {

	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Veiculo salvar(Veiculo novoVeiculo) {
		String sql = " INSERT INTO ESTOQUE (ANO, COR, QUILOMETRAGEM, PLACA, "
				+ "SITUACAO, VALORFIPE, CARRO_IDCARRO) "
				+ " VALUES(?,?,?,?,?,?,?)";
		
		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			prepStmt.setInt(1, novoVeiculo.getAno());
			prepStmt.setString(2, novoVeiculo.getCor());
			prepStmt.setDouble	(3, novoVeiculo.getQuilometragem());
			prepStmt.setString(4, novoVeiculo.getPlaca());
			prepStmt.setString(5, novoVeiculo.getSituacao());
			prepStmt.setDouble(6, novoVeiculo.getValorFIPE());
			prepStmt.setInt(7, novoVeiculo.getModelo().getId());
			
			prepStmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo veículo.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		
		return null;
	}

	public boolean alterar(Veiculo veiculo) {
		boolean sucessoUpdate = false;
		
		Connection conn = Banco.getConnection();
		String sql = "UPDATE ESTOQUE SET ANO=?, COR=?, QUILOMETRAGEM=?, PLACA=?, "
				+ "SITUACAO=?, VALORFIPE=?, CARRO_IDCARRO=?"
				+ "WHERE ID =?";
		
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql);
		int registrosAlterados =0;
		try {
			prepStmt.setInt(1, veiculo.getAno());
			prepStmt.setString(2, veiculo.getCor());
			prepStmt.setDouble	(3, veiculo.getQuilometragem());
			prepStmt.setString(4, veiculo.getPlaca());
			prepStmt.setString(5, veiculo.getSituacao());
			prepStmt.setDouble(6, veiculo.getValorFIPE());
			prepStmt.setInt(7, veiculo.getModelo().getId());
			
			registrosAlterados = prepStmt.executeUpdate();
			
			if (registrosAlterados ==1) {
				sucessoUpdate = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o veículo. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		
		return sucessoUpdate;
	}

	public Veiculo consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
