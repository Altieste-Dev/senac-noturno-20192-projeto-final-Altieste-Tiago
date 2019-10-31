package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import net.miginfocom.swing.MigLayout;

public class CadastrarCliente extends JPanel {
	protected static final String SEXO_MASCULINO = "M";
	protected static final String SEXO_FEMININO = "F";
	private JTextField nomecliente;
	private JFormattedTextField txtCpf;
	private JFormattedTextField formattedTel;
	JFormattedTextField formattedNascimento;
	private JRadioButton rdbtnF;
	private JRadioButton rdbtnM;

	/**
	 * Create the panel.
	 */
	public CadastrarCliente() {
		setLayout(new MigLayout("", "[122px,fill][24px,fill][45px][12px][235px]",
				"[16px][26px][26px][23px][26px][26px][29px]"));

		nomecliente = new JTextField();
		add(nomecliente, "cell 2 1 3 1,alignx left,aligny top");
		nomecliente.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 1,alignx center,aligny center");

		JLabel lblCpf = new JLabel("Cpf:");
		add(lblCpf, "cell 0 2,alignx center,aligny center");

		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
		} catch (ParseException e) {
		}
		add(txtCpf, "cell 2 2 3 1,alignx left,aligny top");

		JLabel lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "cell 0 5,alignx center,aligny center");

		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCadastroDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCadastroDeCliente, "cell 0 0 5 1,grow");

		JButton btnSalvarCliente = new JButton("Salvar");
		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cliController = new ClienteController();
				String nomeDigitado = nomecliente.getName();
				String cpfDigitado = txtCpf.getText();
				String sexoDigitado = "";
				if (rdbtnM.isSelected()) {
					sexoDigitado = SEXO_MASCULINO;
				}
				if (rdbtnF.isSelected()) {
					sexoDigitado = SEXO_FEMININO;
				}
				// cliController.salvar

			}
		});
		add(btnSalvarCliente, "cell 2 6 3 1,alignx left,aligny top");

		JLabel lblSexo = new JLabel("Sexo:");
		add(lblSexo, "cell 0 3,alignx center,aligny center");

		rdbtnF = new JRadioButton("F");
		add(rdbtnF, "cell 2 3,growx,aligny top");

		rdbtnM = new JRadioButton("M");
		add(rdbtnM, "cell 4 3,alignx left,aligny top");

		ButtonGroup radioGroupSexo = new ButtonGroup();
		radioGroupSexo.add(rdbtnM);
		radioGroupSexo.add(rdbtnF);

		MaskFormatter mascaraTel1;
		try {
			mascaraTel1 = new MaskFormatter("(##) #####-####");
			formattedTel = new JFormattedTextField(mascaraTel1);
		} catch (ParseException e) {
		}
		add(formattedTel, "cell 2 5 3 1,alignx left,aligny top");

		JLabel lblNascimento = new JLabel("Nascimento:");
		add(lblNascimento, "cell 0 4,alignx right,aligny center");

		MaskFormatter mascaraNasc;
		try {
			mascaraNasc = new MaskFormatter("##/##/####");
			formattedNascimento = new JFormattedTextField(mascaraNasc);
		} catch (ParseException e) {
		}
		add(formattedNascimento, "cell 2 4 3 1,alignx left,aligny top");

	}
}
