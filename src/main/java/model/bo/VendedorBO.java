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
	
	public String atualizarVendedor(Vendedor novoVendedor) {
		boolean alterou = dao.alterar(novoVendedor);
		
		String mensagem = "";
		if(alterou) {
			mensagem = "Vendedor atualizado com sucesso";
		}else {
			mensagem = "Erro ao atualizar vendedor";
		}
		
		return mensagem;
	}

	public String excluir(Vendedor vendedor) {
		String mensagem = "";
		if (dao.excluir(vendedor.getId())) {
			mensagem = "Vendedor " + vendedor.getNome() + " foi excluido com sucesso";
		} else {
			mensagem = "Erro ao excluir o vendedor " + vendedor.getNome();
		}
		
		return mensagem;
	}
}
