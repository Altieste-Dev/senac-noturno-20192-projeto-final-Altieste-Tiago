package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class CadastrarCliente extends JPanel {
	private JTextField nomecliente;
	private JTextField telefonecliente;
	private JTextField sexocliente;
	private JFormattedTextField txtCpf;

	/**
	 * Create the panel.
	 */
	public CadastrarCliente() {
		setLayout(null);

		nomecliente = new JTextField();
		nomecliente.setBounds(152, 38, 162, 26);
		add(nomecliente);
		nomecliente.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(49, 43, 61, 16);
		add(lblNome);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(49, 71, 61, 16);
		add(lblCpf);

		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
		} catch (ParseException e) {
		}
		txtCpf.setBounds(152, 66, 162, 26);
		add(txtCpf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(49, 137, 61, 16);
		add(lblTelefone);

		telefonecliente = new JTextField();
		telefonecliente.setBounds(152, 132, 162, 26);
		add(telefonecliente);
		telefonecliente.setColumns(10);

		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCadastroDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCliente.setBounds(6, 6, 438, 16);
		add(lblCadastroDeCliente);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(49, 104, 61, 16);
		add(lblSexo);

		sexocliente = new JTextField();
		sexocliente.setBounds(152, 99, 162, 26);
		add(sexocliente);
		sexocliente.setColumns(10);

		JButton btnSalvarCliente = new JButton("Salvar");
		btnSalvarCliente.setBounds(152, 176, 117, 29);
		add(btnSalvarCliente);

	}
}
