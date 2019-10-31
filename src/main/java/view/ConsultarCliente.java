package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class ConsultarCliente extends JPanel {
	private JTable table;
	private JTextField nomeconsultacliente;
	JFormattedTextField formattedCpf;
	JFormattedTextField formattedNasci;

	/**
	 * Create the panel.
	 */
	public ConsultarCliente() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Consulta de Clientes");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 16);
		add(lblNewLabel);

		table = new JTable();
		table.setBounds(16, 126, 413, 153);
		add(table);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(40, 34, 61, 16);
		add(lblNome);

		nomeconsultacliente = new JTextField();
		nomeconsultacliente.setBounds(128, 34, 130, 26);
		add(nomeconsultacliente);
		nomeconsultacliente.setColumns(10);

		JButton btnConsultarClientes = new JButton("Consultar");
		btnConsultarClientes.setBounds(77, 291, 117, 29);
		add(btnConsultarClientes);

		JButton btnExcluirClientes = new JButton("Excluir");
		btnExcluirClientes.setBounds(272, 291, 117, 29);
		add(btnExcluirClientes);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(40, 60, 61, 16);
		add(lblCpf);

		MaskFormatter mascaraCpf1;
		try {
			mascaraCpf1 = new MaskFormatter("###.###.###-##");
			formattedCpf = new JFormattedTextField(mascaraCpf1);
		} catch (ParseException e) {
		}
		formattedCpf.setBounds(128, 60, 130, 26);
		add(formattedCpf);

		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(40, 88, 87, 16);
		add(lblNascimento);

		MaskFormatter mascaraNasc;
		try {
			mascaraNasc = new MaskFormatter("##/##/####");
			formattedNasci = new JFormattedTextField(mascaraNasc);
		} catch (ParseException e) {
		}
		formattedNasci.setBounds(128, 83, 130, 26);
		add(formattedNasci);
	}
}
