package model.entity;

import java.time.LocalDate;

import com.google.protobuf.TextFormat.ParseException;

public class Vendas {
	
	int id;
	Cliente cliente;
	Vendedor vendedor;
	Modelo modelo;
	Veiculo veiculo;
	Double precoDeVenda;
	LocalDate dataDaVenda;
	
	
	public Vendas(Cliente cliente, Vendedor vendedor, Modelo modelo, Veiculo veiculo, Double precoDeVenda, LocalDate dataDaVenda) {
		super();
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.modelo = modelo;
		this.veiculo = veiculo;
		this.precoDeVenda = precoDeVenda;
		this.dataDaVenda = dataDaVenda;
	}


	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDataDaVenda() {
		return dataDaVenda;
	}


	public void setDataDaVenda(LocalDate dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}


	public Vendas() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public Double getPrecoDeVenda() {
		return precoDeVenda;
	}


	public void setPrecoDeVenda(Double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	
	

}
