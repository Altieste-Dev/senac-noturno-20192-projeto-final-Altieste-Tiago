package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuGeral extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGeral frame = new MenuGeral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuGeral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		setJMenuBar(menuBar);

		JMenu mnVendedor = new JMenu("Vendedor");
		mnVendedor.setAlignmentX(Component.RIGHT_ALIGNMENT);
		menuBar.add(mnVendedor);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CadastrarVendedor painelCadastroVendedor = new CadastrarVendedor();
				setContentPane(painelCadastroVendedor);
				revalidate();

			}
		});
		mnVendedor.add(mntmCadastrar);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente painelCadastroCliente = new CadastrarCliente();
				setContentPane(painelCadastroCliente);
				revalidate();
			}
		});
		mnCliente.add(mntmCadastrar_2);

		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCliente painelConsultaCliente = new ConsultarCliente();
				setContentPane(painelConsultaCliente);
				revalidate();
			}
		});
		mnCliente.add(mntmConsultar_1);

		JMenu mnVeculos = new JMenu("Veículos");
		menuBar.add(mnVeculos);

		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mnVeculos.add(mntmCadastrar_1);

		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnVeculos.add(mntmConsultar);

		JMenu mnRelatrio = new JMenu("Relatório");
		menuBar.add(mnRelatrio);

		JMenuItem mntmGerar = new JMenuItem("Gerar");
		mnRelatrio.add(mntmGerar);

		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
	}

}
