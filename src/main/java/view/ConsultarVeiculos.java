package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

public class ConsultarVeiculos extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ConsultarVeiculos() {
		setLayout(new MigLayout("", "[][grow][126.00,grow][][][][][grow][][][36.00][55.00][166.00,grow][31.00]",
				"[][][][163.00,grow][62.00]"));

		JLabel lblConsultarVeculos = new JLabel("Consultar Veículos");
		lblConsultarVeculos.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		add(lblConsultarVeculos, "cell 0 0 12 1,alignx center");

		JLabel lblMarca = new JLabel("Marca:");
		add(lblMarca, "cell 1 1,alignx trailing");

		JComboBox comboMarca = new JComboBox();
		add(comboMarca, "cell 2 1,growx");

		JLabel lblAno = new JLabel("Ano:");
		add(lblAno, "cell 6 1,alignx trailing");

		JComboBox comboAno = new JComboBox();
		add(comboAno, "cell 7 1,growx");

		JLabel lblValor = new JLabel(" Valores:");
		add(lblValor, "cell 11 1");

		JComboBox comboValor = new JComboBox();
		add(comboValor, "cell 12 1,growx");

		JLabel lblModelo = new JLabel("Modelo:");
		add(lblModelo, "cell 1 2,alignx trailing");

		JComboBox comboModelo = new JComboBox();
		add(comboModelo, "cell 2 2,growx");

		JLabel lblCor = new JLabel("Cor:");
		add(lblCor, "cell 6 2,alignx trailing");

		JComboBox comboCor = new JComboBox();
		add(comboCor, "cell 7 2,growx");

		JCheckBox chckbxVendidos = new JCheckBox("Vendidos:");
		chckbxVendidos.setHorizontalTextPosition(JCheckBox.LEFT);
		add(chckbxVendidos, "cell 11 2");

		table = new JTable();
		add(table, "cell 1 3 12 1,grow");

		JButton btnImagem = new JButton("Ver foto");
		btnImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnImagem, "cell 1 4");

		JButton btnVender = new JButton("Vender");
		add(btnVender, "cell 7 4");

		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 9 4");

	}

}
