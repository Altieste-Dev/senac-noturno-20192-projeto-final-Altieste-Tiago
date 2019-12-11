package model.entity;


import java.time.LocalDate;
import java.util.Date;

public class Cliente {

	int idCliente;
	String nome;
	String sexo;
	String cpf;
	String celular;
	String residencial;
	LocalDate dataNascimento; // ta certo isso? usar Date no Eclipse e Date no Script

	public Cliente(int idCliente, String nome, String sexo, String cpf, String celular, String residencial, LocalDate dataNascimento) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.celular = celular;
		this.residencial = residencial;
		this.dataNascimento = dataNascimento;
	}

	public Cliente() {
		super();
	}

	public int getId() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getResidencial() {
		return residencial;
	}

	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

}
