package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.entity.Cliente;

public class ClienteBO {
	ClienteDAO clienteDAO = new ClienteDAO();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public static Cliente salvar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		return cliente;
	}

	public ArrayList<Cliente> consultarClientes() {
		clientes = clienteDAO.consultarTodos();
		return clientes;
	}

	

}
