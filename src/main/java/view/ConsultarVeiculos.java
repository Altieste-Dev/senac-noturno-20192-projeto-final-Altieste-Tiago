package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerVeiculo;
import model.entity.Veiculo;
import net.miginfocom.swing.MigLayout;

public class ConsultarVeiculos extends JPanel {
	// Alti

	private JTable tabelaVeiculos;
	private int larguraDosPaineis;
	private int alturaDaTela;
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	private String[] nomesColunas = { "Marca", "Modelo", "Ano", "Cor", "Quilometragem", "Placa", "Situacao",
			"Valor Fipe" };

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

		tabelaVeiculos = new JTable();
		add(tabelaVeiculos, "cell 1 3 12 1,grow");

		JButton btnImagem = new JButton("Ver foto");
		btnImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnImagem, "cell 1 4");

		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
				larguraDosPaineis = (int) ((dimensoesTela.getWidth() - 20));
				alturaDaTela = (int) (dimensoesTela.getHeight() - 10);

				int linhaSelecionada = tabelaVeiculos.getSelectedRow();
				if (linhaSelecionada >= 0) {
					Veiculo veiculoVenda = veiculos.get(linhaSelecionada);

					ConcluirVenda janelaConclusaoDeVenda = new ConcluirVenda();
					janelaConclusaoDeVenda.setVeiculoVenda(veiculoVenda);
					janelaConclusaoDeVenda.setVisible(true);
					revalidate();
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um Veículo");
				}

			}
		});
		add(btnVender, "cell 7 4");

		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 9 4");

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	private void limparTabelaVeiculos() {
		tabelaVeiculos.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	protected void atualizarTabelaVeiculos() {
		veiculos = (ControllerVeiculo.consultarVeiculos());
		limparTabelaVeiculos();

		DefaultTableModel modeloVeiculos = (DefaultTableModel) tabelaVeiculos.getModel();
		for (Veiculo emp : veiculos) {
			String[] novaLinha = new String[5];
			novaLinha[0] = emp.getModelo().getMarca();
			novaLinha[1] = emp.getModelo().getModelo();
			novaLinha[2] = emp.getCor();

		}
	}
}
