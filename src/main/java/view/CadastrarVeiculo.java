package view;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class CadastrarVeiculo extends JPanel {

	/**
	 * Create the panel.
	 */
	public CadastrarVeiculo() {
		setLayout(null);

		JLabel lblCadastrarVeiculo = new JLabel("Cadastrar Veículos");
		lblCadastrarVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarVeiculo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCadastrarVeiculo.setBounds(6, 6, 438, 16);
		add(lblCadastrarVeiculo);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(16, 35, 61, 16);
		add(lblMarca);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(60, 30, 99, 27);
		add(comboBox);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(203, 35, 61, 16);
		add(lblModelo);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(256, 30, 99, 27);
		add(comboBox_1);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(16, 74, 61, 16);
		add(lblCor);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(45, 69, 99, 27);
		add(comboBox_2);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(203, 74, 44, 16);
		add(lblAno);

		JLabel lblKm = new JLabel("Km:");
		lblKm.setBounds(16, 120, 61, 16);
		add(lblKm);

		JFormattedTextField formattedKm = new JFormattedTextField();
		formattedKm.setBounds(45, 115, 61, 26);
		add(formattedKm);

		JLabel lblPlca = new JLabel("Placa:");
		lblPlca.setBounds(203, 120, 61, 16);
		add(lblPlca);

		JFormattedTextField formattedTexPlaca = new JFormattedTextField();
		formattedTexPlaca.setBounds(247, 115, 67, 26);
		add(formattedTexPlaca);

		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setMinimum(10);
		slider.setMaximum(2019);
		slider.setBounds(237, 68, 147, 29);
		add(slider);

	}
}
