package model.bo;

import model.dao.VendedorDAO;
import model.entity.Vendedor;

public class VendedorBO {

	private static VendedorDAO dao = new VendedorDAO();
	
	public Vendedor salvar(Vendedor novoVendedor) {
		return dao.salvar(novoVendedor);
	}

}
