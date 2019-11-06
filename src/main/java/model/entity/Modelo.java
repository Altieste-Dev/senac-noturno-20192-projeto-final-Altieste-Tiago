package model.entity;

public class Modelo {
	
	String marca;
	String modelo;
	
	public Modelo(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	public Modelo() {
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
	
	
	

}
