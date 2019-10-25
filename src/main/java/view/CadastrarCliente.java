package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class CadastrarCliente extends JPanel {
	private JTextField nomecliente;
	private JFormattedTextField txtCpf;
	private JFormattedTextField formattedTel;

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
		txtCpf.setBounds(152, 66, 117, 26);
		add(txtCpf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(49, 137, 61, 16);
		add(lblTelefone);

		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCadastroDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCliente.setBounds(6, 6, 438, 16);
		add(lblCadastroDeCliente);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(49, 103, 61, 16);
		add(lblSexo);

		JButton btnSalvarCliente = new JButton("Salvar");
		btnSalvarCliente.setBounds(152, 176, 117, 29);
		add(btnSalvarCliente);

		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(152, 100, 45, 23);
		add(rdbtnF);

		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(209, 100, 45, 23);
		add(rdbtnM);

		MaskFormatter mascaraTel1;
		try {
			mascaraTel1 = new MaskFormatter("(##) #####-####");
			formattedTel = new JFormattedTextField(mascaraTel1);
		} catch (ParseException e) {
		}

		formattedTel.setBounds(152, 132, 111, 26);
		add(formattedTel);

	}
}
