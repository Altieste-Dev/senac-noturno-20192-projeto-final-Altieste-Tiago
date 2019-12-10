package model.bo;

import java.util.ArrayList;

import model.dao.VeiculoDAO;
import model.entity.Veiculo;

public class VeiculoBO {

	public ArrayList<Veiculo> consultarVeiculos() {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		return veiculoDAO.consultarTodos();
	}

}
