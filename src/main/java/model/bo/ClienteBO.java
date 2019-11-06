package model.bo;

import model.dao.ClienteDAO;
import model.entity.Cliente;

public class ClienteBO {

	public static Cliente salvar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		return cliente;
	}

}
