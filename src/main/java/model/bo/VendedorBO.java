package model.bo;

import java.util.ArrayList;

import model.dao.VendedorDAO;
import model.entity.Vendedor;

public class VendedorBO {

	private static VendedorDAO dao = new VendedorDAO();
	
	public Vendedor salvar(Vendedor novoVendedor) {
		return dao.salvar(novoVendedor);
	}

	public ArrayList<Vendedor> consultarTodosVendedores() {
		VendedorDAO vendedorDAO = new VendedorDAO();
		ArrayList<Vendedor> vendedoresVO = vendedorDAO.consultarTodos();
		if (vendedoresVO.isEmpty()) {
			System.out.println("\nLista de Vendedores está vazia");
			
		}
		return vendedoresVO;
	}
	
	public void atualizarVendedor(Vendedor novoVendedor) {
		dao.alterar(novoVendedor);
	}
}
