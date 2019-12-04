package controller;

import java.util.ArrayList;

import model.bo.VendedorBO;
import model.entity.Vendedor;

public class ControllerVendedor {

	public String validarCamposSalvar(String nome, String sexo, String cpf, String telefone, String comissao) {
		String mensagem = "";
		
		if (nome.isEmpty() || nome.trim().length() < 3) {
			mensagem += "Nome deve possuir pelo menos 3 letras \n";
		}
		
		if (cpf.isEmpty() || cpf.trim().length() != 11) {
			mensagem += "CPF deve possuir exatamente 11 dígitos \n";
		}
		
		if (telefone.isEmpty() || telefone.trim().length() < 9) {
			mensagem += "Telefone deve possuir pelo menos 9 números \n";
		}

		if(comissao.isEmpty()) {
			mensagem += "Vendedor tem que ganhar sua comissao \n";
		}
		
		if (sexo.isEmpty() || sexo.trim().length() < 1) {
			mensagem += "Selecione o Sexo \n";
		}
		
		return mensagem;

	}

	public Vendedor salvar(Vendedor novoVendedor) {
		VendedorBO bo = new VendedorBO();
		return bo.salvar(novoVendedor);
	}

	public ArrayList<Vendedor> consultarTodosVendedores() {
		VendedorBO vendedorBO = new VendedorBO();
		return vendedorBO.consultarTodosVendedores();
	}

	public void atualizarVendedor(Vendedor novoVendedor) {
		VendedorBO bo = new VendedorBO();
		bo.atualizarVendedor(novoVendedor);
		
	}

}
