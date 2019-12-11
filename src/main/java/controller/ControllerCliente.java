package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.entity.Cliente;

public class ControllerCliente {
	
	ClienteBO bo = new ClienteBO();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public void salvar(Cliente cliente) {
	bo.salvar(cliente);

	}

	public ArrayList<Cliente> consultarClientes() {
		clientes = bo.consultarClientes();
		return clientes;
	}



}
