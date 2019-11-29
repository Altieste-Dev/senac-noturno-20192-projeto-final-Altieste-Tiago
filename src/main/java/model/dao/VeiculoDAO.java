package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Modelo;
import model.entity.Veiculo;

public class VeiculoDAO implements BaseDAO<Veiculo> {

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM ESTOQUE WHERE ID= " + id;
		Statement stmt = Banco.getStatement(conn);
		
		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return quantidadeLinhasAfetadas > 0;
	}

	public ArrayList<Veiculo> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM CLIENTE ";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		try {
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				Veiculo v = construirVeiculoDoResultSet(rs);
				veiculos.add(v);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return veiculos;
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
		Connection conn = Banco.getConnection();
		String sql = "SELECT idEstoque, ano, cor, quilomentragem, placa, situacao, valorFIPE, Carro_idCarro"
				+ "FROM ESTOQUE "
				+ "WHERE ID= " + id;
		
				
		Statement stmt = Banco.getStatement(conn);
		Veiculo veiculo = null;
		
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);
			if(resultadoDaConsulta.next()) {
				veiculo = construirVeiculoDoResultSet (resultadoDaConsulta);
				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar o veículo por id =" + id);
			System.out.println("Erro: " + e.getMessage());
		}
		
		return veiculo;
	}

	private Veiculo construirVeiculoDoResultSet(ResultSet resultadoDaConsulta) {
		Veiculo novoVeiculo = null;
		try {
			novoVeiculo = new Veiculo();
			novoVeiculo.setId(resultadoDaConsulta.getInt("id"));
			novoVeiculo.setAno(resultadoDaConsulta.getInt("ano"));
			novoVeiculo.setCor(resultadoDaConsulta.getString("cor"));
			novoVeiculo.setQuilometragem(resultadoDaConsulta.getDouble("quilometragem"));
			novoVeiculo.setPlaca(resultadoDaConsulta.getString("placa"));
			novoVeiculo.setCor(resultadoDaConsulta.getString("situação"));
			novoVeiculo.setCor(resultadoDaConsulta.getString("valorFIPE"));
			
			ModeloDAO modeloDAO = new ModeloDAO();
			Modelo modelo = modeloDAO.consultarPorId(resultadoDaConsulta.getInt("idcarro"));
			
			novoVeiculo.setModelo(modelo);
			
		} catch (SQLException e) {
			System.out.println("Erro ao construir veículo a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}
		return novoVeiculo;
	}

}
