package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;

public class ControllerCliente {
	
	ClienteBO bo = new ClienteBO();

	public void salvar(Cliente cliente) {
	bo.salvar(cliente);

	}

}
