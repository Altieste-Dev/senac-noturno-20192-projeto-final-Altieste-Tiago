package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControllerCliente;
import model.entity.Cliente;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class ConsultarCliente extends JPanel {
	// Alti

	private JTable tblClientes;
	private JTextField nomeconsultacliente;
	JFormattedTextField formattedCpf;
	JFormattedTextField formattedNasci;
	private int larguraDosPaineis;
	private int alturaDaTela;
	private ControllerCliente controller = new ControllerCliente();
	private Cliente cliente = new Cliente();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

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

		tblClientes = new JTable();
		tblClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "Sexo", "CPF", "Celular", null},
			},
			new String[] {
				"Nome", "Sexo", "CPF", "Celular", "Nascimento"
			}
		));
		add(tblClientes, "cell 0 7 5 1,grow");

		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 1,alignx center,aligny top");

		nomeconsultacliente = new JTextField();
		add(nomeconsultacliente, "cell 2 1,alignx left,aligny top");
		nomeconsultacliente.setColumns(10);

		JButton btnConsultarClientes = new JButton("Consultar");
		btnConsultarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				clientes = controller.consultarClientes();
				atualizarTabelaClientes(clientes);
				
			}
		});
		add(btnConsultarClientes, "cell 0 8,alignx center,aligny top");

		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
				larguraDosPaineis = (int) ((dimensoesTela.getWidth() - 20));
				alturaDaTela = (int) (dimensoesTela.getHeight() - 10);

				AlterarCliente janelaAlterarCliente = new AlterarCliente();
				janelaAlterarCliente.setVisible(true);
				revalidate();

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
	
	protected void atualizarTabelaClientes(ArrayList<Cliente> clientes2) {
		limparTabelaClientes();
		
		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
		
		Object novaLinha [] = new Object[5];
		for (Cliente cliente: clientes) {
			novaLinha[0] = cliente.getNome();
			novaLinha[1] = cliente.getSexo();
			novaLinha[2] = cliente.getCpf();
			novaLinha[3] = cliente.getCelular();
			novaLinha[4] = String.valueOf(cliente.getDataNascimento());
			
			model.addRow(novaLinha);
		}
		
	}

	private void limparTabelaClientes() {
		tblClientes.setModel(new DefaultTableModel(
				new Object[][] {
					{"Nome", "Sexo", "CPF", "Celular", null},
				},
				new String[] {
					"Nome", "Sexo", "CPF", "Celular", "Nascimento"
				}
			));
		
	}
}
