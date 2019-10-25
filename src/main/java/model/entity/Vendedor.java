package model.entity;

public class Vendedor {
	
	String nome;
	String sexo;
	String cpf;
	String celular;
	Double comissao;
	
	public Vendedor(String nome, String sexo, String cpf, String celular, Double comissao) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.celular = celular;
		this.comissao = comissao;
	}
	
	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}
	
	
}
