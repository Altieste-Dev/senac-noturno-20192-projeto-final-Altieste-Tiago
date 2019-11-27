package model.entity;

public class Veiculo {
	
	int ano;
	String cor;
	double quilometragem;
	String placa;
	double valorFIPE;
	String situacao;
	Modelo modelo;
	
	
	public Veiculo(int ano, String cor, double quilometragem, String placa, 
			String situacao, double valorFIPE, Modelo modelo) {
		super();
		this.ano = ano;
		this.cor = cor;
		this.quilometragem = quilometragem;
		this.placa = placa;
		this.situacao = situacao;
		this.valorFIPE = valorFIPE;
		this.modelo = modelo;
	}


	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
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


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
	
	
}