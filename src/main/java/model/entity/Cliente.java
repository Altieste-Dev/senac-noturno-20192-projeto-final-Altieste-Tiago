package model.entity;

import java.time.LocalDate;

public class Cliente {

	String nome;
	String sexo;
	String cpf;
	String celular;
<<<<<<< HEAD

=======
	LocalDate dataNascimento; //ta certo isso? usar LocalDate no Eclipse e Date no Script
	
>>>>>>> branch 'master' of https://github.com/Altieste07/senac-noturno-20192-projeto-final-Altieste-Tiago.git
	public Cliente(String nome, String sexo, String cpf, String celular) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.celular = celular;
	}

	public Cliente() {
		super();
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
