package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;

public class CadastrarVeiculo extends JPanel {
	JFormattedTextField formattedTexPlaca;

	/**
	 * Create the panel.
	 */
	public CadastrarVeiculo() {
		setLayout(new MigLayout("",
				"[48px,fill][13px,fill][61px,fill][2px][36px,fill][37px,fill][44px,fill][13px,fill][184px,fill]",
				"[16px][31px,fill][31px,fill][30px,fill][26px,fill][29px,fill]"));

		JLabel lblCadastrarVeiculo = new JLabel("Cadastrar Veículos");
		lblCadastrarVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarVeiculo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		add(lblCadastrarVeiculo, "cell 0 0 9 1,grow");

		JLabel lblMarca = new JLabel("Marca:");
		add(lblMarca, "cell 0 1,alignx left,aligny center");

		JComboBox comboMarca = new JComboBox();
		add(comboMarca, "cell 2 1 3 1,growx,aligny bottom");

		JLabel lblModelo = new JLabel("Modelo:");
		add(lblModelo, "cell 6 1,alignx left,aligny center");

		JComboBox comboModelo = new JComboBox();
		add(comboModelo, "cell 8 1,growx,aligny top");

		JLabel lblCor = new JLabel("Cor:");
		add(lblCor, "cell 0 2,alignx left,aligny center");

		JComboBox comboCor = new JComboBox();
		add(comboCor, "cell 2 2 3 1,growx,aligny bottom");

		JLabel lblAno = new JLabel("Ano:");
		add(lblAno, "cell 6 2,growx,aligny center");

		JLabel lblKm = new JLabel("Km:");
		add(lblKm, "cell 0 3,alignx left,aligny center");

		JFormattedTextField formattedKm = new JFormattedTextField();
		add(formattedKm, "cell 2 3,growx,aligny bottom");

		JLabel lblPlca = new JLabel("Placa:");
		add(lblPlca, "cell 6 3,alignx left,aligny center");

		MaskFormatter mascaraNasc;
		try {
			mascaraNasc = new MaskFormatter("???-####");
			formattedTexPlaca = new JFormattedTextField(mascaraNasc);
		} catch (ParseException e) {
		}
		add(formattedTexPlaca, "cell 8 3,growx,aligny top");

		JComboBox comboAno = new JComboBox();
		add(comboAno, "cell 8 2,growx,aligny top");

		JLabel lblFipe = new JLabel("Fipe:");
		add(lblFipe, "cell 0 4,alignx left,aligny top");

		JFormattedTextField formattedFipe = new JFormattedTextField();
		add(formattedFipe, "cell 2 4 3 1,growx,aligny top");

		JButton btnSalVar = new JButton("Sal var");
		add(btnSalVar, "cell 4 5 3 1,growx,aligny top");

	}
}
