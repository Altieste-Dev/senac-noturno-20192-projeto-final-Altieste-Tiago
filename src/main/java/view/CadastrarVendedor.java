package view;

import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.aula05.ClienteController;
import model.entity.aula05.Cliente;
import model.entity.aula05.Endereco;
import model.entity.aula05.Telefone;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarVendedor extends JPanel {
	private JTextField nomevendedor;
	private JTextField textField;
	JFormattedTextField formattedCpf;
	JFormattedTextField formattedTel;

	/**
	 * Create the panel.
	 */
	public CadastrarVendedor() {
		setLayout(null);

		nomevendedor = new JTextField();
		nomevendedor.setBounds(152, 38, 162, 26);
		add(nomevendedor);
		nomevendedor.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(49, 43, 61, 16);
		add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(49, 137, 61, 16);
		add(lblTelefone);

		JLabel lblCadastroDeVendedor = new JLabel("Cadastro de Vendedor");
		lblCadastroDeVendedor.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCadastroDeVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeVendedor.setBounds(6, 6, 438, 16);
		add(lblCadastroDeVendedor);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(49, 104, 61, 16);
		add(lblSexo);

		JButton btnSalvarVendedor = new JButton("Salvar");
		btnSalvarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController cliController = new ClienteController();
				String nomeDigitado = txtNome.getText();
				String sobrenomeDigitado = txtSobrenome.getText();
				String cpfDigitado = txtCPF.getText().replace("-", "").replace(".", "");
				Endereco enderecoSelecionado = (Endereco) cbEndereco.getSelectedItem();

				String mensagem = cliController.validarCamposSalvar(nomeDigitado, sobrenomeDigitado, cpfDigitado,
						enderecoSelecionado);

				if (mensagem.isEmpty()) {
					novoCliente = new Cliente(nomeDigitado, sobrenomeDigitado, cpfDigitado, new ArrayList<Telefone>(),
							enderecoSelecionado);
					novoCliente = cliController.salvar(novoCliente);

					if (novoCliente.getId() > 0) {
						btnAdicionarTelefone.setEnabled(true);
						btnSalvar.setEnabled(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Aten��o", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		});
		btnSalvarVendedor.setBounds(152, 212, 117, 29);
		add(btnSalvarVendedor);

		JLabel lblComisso = new JLabel("Comissão(%):");
		lblComisso.setBounds(49, 175, 93, 16);
		add(lblComisso);

		textField = new JTextField();
		textField.setBounds(152, 170, 42, 26);
		add(textField);
		textField.setColumns(10);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(49, 76, 61, 16);
		add(lblCpf);

		MaskFormatter mascaraCpf1;
		try {
			mascaraCpf1 = new MaskFormatter("###.###.###-##");
			formattedCpf = new JFormattedTextField(mascaraCpf1);
		} catch (ParseException e) {
		}
		formattedCpf.setBounds(152, 71, 134, 26);
		add(formattedCpf);

		MaskFormatter mascaraTel1;
		try {
			mascaraTel1 = new MaskFormatter("(##) #####-####");
			formattedTel = new JFormattedTextField(mascaraTel1);
		} catch (ParseException e) {
		}

		formattedTel.setBounds(152, 132, 134, 26);
		add(formattedTel);

		JRadioButton rdbtnFem = new JRadioButton("F");
		rdbtnFem.setBounds(152, 101, 42, 23);
		add(rdbtnFem);

		JRadioButton rdbtnMasc = new JRadioButton("M");
		rdbtnMasc.setBounds(206, 101, 50, 23);
		add(rdbtnMasc);

	}
}
