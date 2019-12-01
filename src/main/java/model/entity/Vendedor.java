package model.entity;

public class Vendedor {
	private int id;
	private String nome;
	private String sexo;
	private String cpf;
	private String celular;
	private Double comissao;
	
	public Vendedor( int id, String nome, String sexo, String cpf, String celular, Double comissao) {
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		String nome = this.nome;
		
		return "Nome: " + nome;

	}

	

	
	
	
}
