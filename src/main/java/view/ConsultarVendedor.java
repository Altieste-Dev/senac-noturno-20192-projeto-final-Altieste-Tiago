package view;

import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;

public class ConsultarVendedor extends JPanel {
	private JTextField textNome;

	/**
	 * Create the panel.
	 */
	public ConsultarVendedor() {
		setLayout(new MigLayout("", "[][grow][][]", "[][][][][][][][][]"));

		JLabel lblNome = new JLabel("Vendedor:");
		add(lblNome, "cell 0 0,alignx trailing");

		JComboBox comboVendedor = new JComboBox();
		add(comboVendedor, "cell 1 0,growx");

		JLabel lblNome_1 = new JLabel("Nome:");
		add(lblNome_1, "cell 0 2,alignx trailing");

		textNome = new JTextField();
		add(textNome, "cell 1 2,growx");
		textNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 0 3,alignx trailing");

		JFormattedTextField formattedCPF = new JFormattedTextField();
		MaskFormatter mascaraCpf1;
		try {
			mascaraCpf1 = new MaskFormatter("###.###.###-##");
			mascaraCpf1.setValueContainsLiteralCharacters(false);
			mascaraCpf1.setOverwriteMode(true);
			formattedCPF = new JFormattedTextField(mascaraCpf1);
			mascaraCpf1.setValidCharacters("0123456789");
		} catch (ParseException e) {
		}
		add(formattedCPF, "cell 1 3,growx");

		JLabel lblSexo = new JLabel("Sexo:");
		add(lblSexo, "cell 0 4,alignx right");

		JLabel lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "cell 0 5,alignx trailing");

		JFormattedTextField formattedTel = new JFormattedTextField();
		MaskFormatter mascaraTel1;
		try {
			mascaraTel1 = new MaskFormatter("(##) #####-####");
			formattedTel = new JFormattedTextField(mascaraTel1);
		} catch (ParseException e) {
		}
		add(formattedTel, "cell 1 5,growx");

		JLabel lblComisso = new JLabel("Comissão:");
		add(lblComisso, "cell 0 6,alignx trailing");

		JFormattedTextField formattedComissao = new JFormattedTextField();
		add(formattedComissao, "cell 1 6,growx");

		ButtonGroup radioButtonGroupSexo = new ButtonGroup();
		final JRadioButton rbSexFem = new JRadioButton("F");
		rbSexFem.setBounds(152, 101, 42, 23);
		add(rbSexFem, "flowx,cell 1 4");

		final JRadioButton rbSexMas = new JRadioButton("M");
		rbSexMas.setBounds(206, 101, 50, 23);
		add(rbSexMas, "cell 1 4");
		radioButtonGroupSexo.add(rbSexMas);

		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir, "flowx,cell 1 8");

		JButton btnSalvarVendedor = new JButton("Salvar");

		add(btnSalvarVendedor, "cell 1 8");

	}

}
