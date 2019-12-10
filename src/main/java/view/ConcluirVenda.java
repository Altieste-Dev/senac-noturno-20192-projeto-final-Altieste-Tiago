package view;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.entity.Veiculo;
import net.miginfocom.swing.MigLayout;

public class ConcluirVenda extends JFrame {

	private JPanel contentPane;
	private JTextField textValorVenda;
	private Veiculo veiculoVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcluirVenda frame = new ConcluirVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConcluirVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][]", "[][][][][][][]"));

		JLabel lblVendedor = new JLabel("Vendedor:");
		contentPane.add(lblVendedor, "cell 0 0,alignx trailing");

		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, "cell 1 0,growx");

		JLabel lblCliente = new JLabel("Cliente:");
		contentPane.add(lblCliente, "cell 0 2,alignx trailing");

		JComboBox comboBox_1 = new JComboBox();
		contentPane.add(comboBox_1, "cell 1 2,growx");

		JLabel lblVeculo = new JLabel("Veículo:");
		contentPane.add(lblVeculo, "cell 0 4,alignx right");

		JLabel lblValorFinalDa = new JLabel("Valor final da venda: R$:");
		contentPane.add(lblValorFinalDa, "cell 0 6,alignx trailing");

		textValorVenda = new JNumberFormatField();
		contentPane.add(textValorVenda, "flowx,cell 1 6,growx");
		textValorVenda.setColumns(10);

	}

	public Veiculo getVeiculoVenda() {
		return veiculoVenda;
	}

	public void setVeiculoVenda(Veiculo veiculoVenda) {
		this.veiculoVenda = veiculoVenda;
	}

}
