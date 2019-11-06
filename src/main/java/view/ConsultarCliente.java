package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;

public class ConsultarCliente extends JPanel {
	private JTable table;
	private JTextField nomeconsultacliente;
	JFormattedTextField formattedCpf;
	JFormattedTextField formattedNasci;
	private int larguraDosPaineis;
	private int alturaDaTela;

	/**
	 * Create the panel.
	 */
	public ConsultarCliente() {
		setLayout(new MigLayout("", "[121px][1px][130px][14px][315.00px]",
				"[16px][26px][16px][7px][3px][2px][21px][153px][29px]"));

		JLabel lblNewLabel = new JLabel("Consulta de Clientes");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, "cell 0 0 5 1,grow");

		table = new JTable();
		add(table, "cell 0 7 5 1,grow");

		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 1,alignx center,aligny top");

		nomeconsultacliente = new JTextField();
		add(nomeconsultacliente, "cell 2 1,alignx left,aligny top");
		nomeconsultacliente.setColumns(10);

		JButton btnConsultarClientes = new JButton("Consultar");
		add(btnConsultarClientes, "cell 0 8,alignx center,aligny top");

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarCliente painelAlterarCliente = new AlterarCliente();
				painelAlterarCliente.setVisible(true);
			}
		});
		add(btnEditar, "cell 2 8,alignx center");

		JButton btnExcluirClientes = new JButton("Excluir");
		add(btnExcluirClientes, "cell 4 8,alignx left,aligny top");

		JLabel lblCpf = new JLabel("Cpf:");
		add(lblCpf, "cell 0 2,alignx center,aligny top");

		MaskFormatter mascaraCpf1;
		try {
			mascaraCpf1 = new MaskFormatter("###.###.###-##");
			formattedCpf = new JFormattedTextField(mascaraCpf1);
		} catch (ParseException e) {
		}
		add(formattedCpf, "cell 2 2 1 3,growx,aligny top");

		JLabel lblNascimento = new JLabel("Nascimento:");
		add(lblNascimento, "cell 0 6,alignx right,aligny top");

		MaskFormatter mascaraNasc;
		try {
			mascaraNasc = new MaskFormatter("##/##/####");
			formattedNasci = new JFormattedTextField(mascaraNasc);
		} catch (ParseException e) {
		}
		add(formattedNasci, "cell 2 4 1 3,growx,aligny top");
	}
}
