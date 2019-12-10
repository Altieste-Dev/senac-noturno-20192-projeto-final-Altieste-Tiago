package controller;

import java.util.ArrayList;

import model.bo.VeiculoBO;
import model.entity.Veiculo;

public class ControllerVeiculo {

	public static ArrayList<Veiculo> consultarVeiculos() {
		VeiculoBO veiculoBO = new VeiculoBO();
		return veiculoBO.consultarVeiculos();
	}
}
