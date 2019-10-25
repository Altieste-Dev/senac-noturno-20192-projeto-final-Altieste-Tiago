package model.entity;

public class Veiculo {
	
	String marca;
	String modelo;
	int ano;
	String cor;
	double quilometragem;
	String placa;
	double valorFIPE;
	
	
	public Veiculo(String marca, String modelo, int ano, String cor, double quilometragem, String placa,
			double valorFIPE) {
		
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.quilometragem = quilometragem;
		this.placa = placa;
		this.valorFIPE = valorFIPE;
	}


	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public double getQuilometragem() {
		return quilometragem;
	}


	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public double getValorFIPE() {
		return valorFIPE;
	}


	public void setValorFIPE(double valorFIPE) {
		this.valorFIPE = valorFIPE;
	}
	
	
	

}
