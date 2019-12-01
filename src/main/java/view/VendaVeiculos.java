package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class VendaVeiculos extends JPanel {
	//Alti

	private JTextField textVeicSelec;
	JNumberFormatField formattedValorFinal;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public VendaVeiculos() {
		setLayout(new MigLayout("", "[][][][533.00,grow][][]", "[][][][][][][][][]"));

		JLabel lblVendedor = new JLabel("Vendedor:");
		add(lblVendedor, "cell 0 0");

		JComboBox comboVendedor = new JComboBox();
		add(comboVendedor, "cell 3 0,growx");

		JLabel lblCliente = new JLabel("Cliente:");
		add(lblCliente, "cell 0 2");

		JComboBox comboCliente = new JComboBox();
		add(comboCliente, "cell 3 2,growx");

		JLabel lblVeculo = new JLabel("Veículo:");
		add(lblVeculo, "cell 0 4");

		textVeicSelec = new JTextField();
		add(textVeicSelec, "cell 3 4,growx");
		textVeicSelec.setColumns(10);

		JLabel lblValorFinalDa = new JLabel("Valor final da Venda:");
		add(lblValorFinalDa, "cell 0 6");

		JNumberFormatField txtValorEmReais = new JNumberFormatField(2);
		txtValorEmReais.setBounds(270, 86, 155, 20);
		contentPane.add(txtValorEmReais);
		txtValorEmReais.setBounds(270, 86, 155, 20);
		contentPane.add(txtValorEmReais);

		JLabel lblR = new JLabel("R$:");
		add(lblR, "cell 2 6,alignx trailing");

		JNumberFormatField textField_1 = new JNumberFormatField(2);
		add(textField_1, "cell 3 6,growx");

		JButton btnVender = new JButton("Vender");
		add(btnVender, "cell 3 8");

	}

}
