package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControllerVendedor;
import model.entity.Vendedor;
import net.miginfocom.swing.MigLayout;

public class ConsultarVendedor extends JPanel {
	// Alti

	private JTextField textNome;
	private JFormattedTextField textCPF;
	private JFormattedTextField textTel;
	private JTextField textComissao;
	private Vendedor novoVendedor;
	private JComboBox<Vendedor> cbVendedor;
	private ControllerVendedor conVendedor;
	private Vendedor vendedorSelecionado = new Vendedor();

	public ConsultarVendedor() {
		setLayout(new MigLayout("", "[][grow][][]", "[][][][][][][][][]"));

		JLabel lblNome = new JLabel("Vendedor:");
		add(lblNome, "cell 0 0,alignx trailing");

		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		conVendedor = new ControllerVendedor();
		vendedores = conVendedor.consultarTodosVendedores();

		cbVendedor = new JComboBox(vendedores.toArray());
		cbVendedor.setSelectedIndex(-1);

		cbVendedor.setToolTipText("Escolha um vendedor da Lista de Vendedores Cadastrados");

		// for (Vendedor user : vendedores) {
		// cbVendedor.addItem(user);
		//
		// }

		add(cbVendedor, "cell 1 0,growx");

		JLabel lblNome_1 = new JLabel("Nome:");
		add(lblNome_1, "cell 0 2,alignx trailing");

		textNome = new JTextField();
		add(textNome, "cell 1 2,growx");
		textNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		add(lblCpf, "cell 0 3,alignx trailing");

		MaskFormatter mascaraCpf1;
		try {
			mascaraCpf1 = new MaskFormatter("###.###.###-##");
			mascaraCpf1.setValueContainsLiteralCharacters(false);
			mascaraCpf1.setOverwriteMode(true);
			mascaraCpf1.setValidCharacters("0123456789");
			textCPF = new JFormattedTextField(mascaraCpf1);

		} catch (ParseException e) {
		}
		add(textCPF, "cell 1 3,growx");
		textCPF.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		add(lblSexo, "cell 0 4,alignx right");

		JLabel lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "cell 0 5,alignx trailing");

		// textTel = new JTextField();
		MaskFormatter mascaraTel1;
		try {
			mascaraTel1 = new MaskFormatter("(##) #####-####");
			mascaraTel1.setValueContainsLiteralCharacters(false);
			mascaraTel1.setOverwriteMode(true);
			mascaraTel1.setValidCharacters("0123456789");
			textTel = new JFormattedTextField(mascaraTel1);

		} catch (ParseException e) {
		}
		add(textTel, "cell 1 5,growx");
		textTel.setColumns(10);

		JLabel lblComisso = new JLabel("Comissão:");
		add(lblComisso, "cell 0 6,alignx trailing");

		final JRadioButton rbSexFem = new JRadioButton("F");
		rbSexFem.setBounds(152, 101, 42, 23);
		add(rbSexFem, "flowx,cell 1 4");

		final JRadioButton rbSexMas = new JRadioButton("M");
		rbSexMas.setBounds(206, 101, 50, 23);
		add(rbSexMas, "cell 1 4");

		ButtonGroup radioGroupSexo = new ButtonGroup();
		radioGroupSexo.add(rbSexMas);
		radioGroupSexo.add(rbSexFem);

		textComissao = new JTextField();
		add(textComissao, "cell 1 6,growx");
		textComissao.setColumns(10);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerVendedor controllerVendedor = new ControllerVendedor();
				Vendedor excluirVendedor = (Vendedor) cbVendedor.getSelectedItem();
				String mensagem = controllerVendedor.excluirVendedor(excluirVendedor);

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		add(btnExcluir, "flowx,cell 1 8");

		cbVendedor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				vendedorSelecionado = (Vendedor) cbVendedor.getSelectedItem();

				textNome.setText(vendedorSelecionado.getNome());
				textCPF.setText(vendedorSelecionado.getCpf());
				textTel.setText(vendedorSelecionado.getCelular());
				textComissao.setText(vendedorSelecionado.getComissao().toString());

				String sexo = vendedorSelecionado.getSexo().toString();

				if (sexo.equals("F")) {
					rbSexFem.setSelected(true);
				}

				if (sexo.equals("M")) {
					rbSexMas.setSelected(true);
				}
			}
		});

		JButton btnAlterarVendedor = new JButton("Alterar");
		btnAlterarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerVendedor controllerVendedor = new ControllerVendedor();
				vendedorSelecionado = (Vendedor) cbVendedor.getSelectedItem();

				String nome = textNome.getText();
				String sexo = " ";
				String cpf = textCPF.getText().replace(".", "").replace("-", "");
				String celular = textTel.getText();
				String comissao = textComissao.getText();

				if (rbSexFem.isSelected()) {
					sexo = "F";
				}

				if (rbSexMas.isSelected()) {
					sexo = "M";
				}

				String mensagem = controllerVendedor.validarCamposSalvar(nome, sexo, cpf, celular, comissao);
				if (mensagem.isEmpty()) {
					Double comissaoDouble = Double.valueOf(comissao);
					vendedorSelecionado = new Vendedor(vendedorSelecionado.getId(), nome, cpf, celular, comissaoDouble,
							sexo);
					mensagem = controllerVendedor.atualizarVendedor(vendedorSelecionado);

					JOptionPane.showMessageDialog(null, mensagem, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		add(btnAlterarVendedor, "cell 1 8");

	}

}
