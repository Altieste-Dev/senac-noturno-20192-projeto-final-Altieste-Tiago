package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControllerVendedor;
import model.entity.Vendedor;

public class CadastrarVendedor extends JPanel {
	private JTextField txtNome;
	private JTextField txtComissao;
	JFormattedTextField txtCPF;
	JFormattedTextField txtTel;
	private Vendedor novoVendedor;
	/**
	 * Create the panel.
	 */
	public CadastrarVendedor() {
		setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(152, 38, 162, 26);
		add(txtNome);
		txtNome.setColumns(10);

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
		
		final JRadioButton rbSexFem = new JRadioButton("F");
		rbSexFem.setBounds(152, 101, 42, 23);
		add(rbSexFem);

		final JRadioButton rbSexMas = new JRadioButton("M");
		rbSexMas.setBounds(206, 101, 50, 23);
		add(rbSexMas);

		JButton btnSalvarVendedor = new JButton("Salvar");
		btnSalvarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerVendedor controllerVendedor = new ControllerVendedor();
				
			String nome = txtNome.getText();
			String cpf = txtCPF.getText();
			String telefone = txtTel.getText();
			String comissao = txtComissao.getText(); 
			String sexo = " ";
			
			if (rbSexFem.isSelected()) {
				sexo = "F";
			}
			
			if (rbSexMas.isSelected()) {
				sexo = "M";
			}
			
			String mensagem = controllerVendedor.validarCamposSalvar(nome,cpf, telefone, comissao, sexo);
			
			if (mensagem.isEmpty()) {
				novoVendedor = new Vendedor(0, nome, cpf, telefone, sexo, Double.valueOf(comissao));
				novoVendedor = controllerVendedor.salvar(novoVendedor);
			};
		}});

		btnSalvarVendedor.setBounds(152, 212, 117, 29);
		add(btnSalvarVendedor);

		JLabel lblComisso = new JLabel("Comissão(%):");
		lblComisso.setBounds(49, 175, 93, 16);
		add(lblComisso);

		txtComissao = new JTextField();
		txtComissao.setBounds(152, 170, 42, 26);
		add(txtComissao);
		txtComissao.setColumns(10);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(49, 76, 61, 16);
		add(lblCpf);

		MaskFormatter mascaraCpf1;
		try {
			mascaraCpf1 = new MaskFormatter("###.###.###-##");
			txtCPF = new JFormattedTextField(mascaraCpf1);
		} catch (ParseException e) {
		}
		txtCPF.setBounds(152, 71, 134, 26);
		add(txtCPF);

		MaskFormatter mascaraTel1;
		try {
			mascaraTel1 = new MaskFormatter("(##) #####-####");
			txtTel = new JFormattedTextField(mascaraTel1);
		} catch (ParseException e) {
		}

		txtTel.setBounds(152, 132, 134, 26);
		add(txtTel);

		

	}
}
