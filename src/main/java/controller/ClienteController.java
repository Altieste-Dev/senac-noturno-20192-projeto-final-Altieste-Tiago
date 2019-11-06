package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;

public class ClienteController {

	public Cliente salvar(Cliente cliente) {
		return ClienteBO.salvar(cliente);
	}

}
