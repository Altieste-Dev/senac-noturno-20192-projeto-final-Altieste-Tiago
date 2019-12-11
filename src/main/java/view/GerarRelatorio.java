package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class GerarRelatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarRelatorio frame = new GerarRelatorio();
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
	public GerarRelatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[61px][125px,grow]", "[27px][16px][][][][]"));

		JLabel lblRelatrio = new JLabel("Relatório:");
		contentPane.add(lblRelatrio, "cell 0 0,growx,aligny center");

		JComboBox comboTipoRelatorio = new JComboBox();
		contentPane.add(comboTipoRelatorio, "cell 1 0,growx,aligny top");

		JLabel lblPerodo = new JLabel("Período:");
		contentPane.add(lblPerodo, "cell 0 1,alignx trailing,aligny top");

		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, "cell 1 1,growx");

		JButton btnGerar = new JButton("Gerar");
		contentPane.add(btnGerar, "cell 1 5");
	}
}
