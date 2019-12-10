package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuGeral extends JFrame {
	// Alti

	private int larguraDosPaineis;
	private int alturaDaTela;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGeral frame = new MenuGeral();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// tela funcionando
	public MenuGeral() {
		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		larguraDosPaineis = (int) ((dimensoesTela.getWidth() - 20));
		alturaDaTela = (int) (dimensoesTela.getHeight() - 10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 369);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		setJMenuBar(menuBar);

		JMenu mnVendedor = new JMenu("Vendedor");
		mnVendedor.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-businessman-48.png")));
		mnVendedor.setAlignmentX(Component.RIGHT_ALIGNMENT);
		menuBar.add(mnVendedor);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-attitude-48.png")));
		mntmCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CadastrarVendedor painelCadastroVendedor = new CadastrarVendedor();
				painelCadastroVendedor.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelCadastroVendedor);
				revalidate();

			}
		});
		mnVendedor.add(mntmCadastrar);

		JMenuItem mntmConsultarVendedor = new JMenuItem("Consultar");
		mntmConsultarVendedor.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-decision-48.png")));
		mntmConsultarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarVendedor painelConsultarVendedor = new ConsultarVendedor();
				painelConsultarVendedor.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelConsultarVendedor);
				revalidate();

			}
		});
		mnVendedor.add(mntmConsultarVendedor);

		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-consultation-48.png")));
		menuBar.add(mnCliente);

		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2
				.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-add-user-male-skin-type-7-48.png")));
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente painelCadastroCliente = new CadastrarCliente();
				painelCadastroCliente.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelCadastroCliente);
				revalidate();
			}
		});
		mnCliente.add(mntmCadastrar_2);

		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-find-user-male-48.png")));
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCliente painelConsultaCliente = new ConsultarCliente();
				painelConsultaCliente.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelConsultaCliente);
				revalidate();
			}
		});
		mnCliente.add(mntmConsultar_1);

		JMenu mnVeiculos = new JMenu("Veiculos");
		mnVeiculos.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-garage-48.png")));
		menuBar.add(mnVeiculos);

		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-add-48.png")));
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarVeiculo painelCadastrarVeiculo = new CadastrarVeiculo();
				painelCadastrarVeiculo.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelCadastrarVeiculo);
				revalidate();
			}
		});
		mnVeiculos.add(mntmCadastrar_1);

		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-find-and-replace-48.png")));
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarVeiculos painelConsultarVeiculo = new ConsultarVeiculos();
				painelConsultarVeiculo.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelConsultarVeiculo);
				revalidate();

			}
		});
		mnVeiculos.add(mntmConsultar);

		JMenu mnRelatrio = new JMenu("Relatorio");
		mnRelatrio.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-terms-and-conditions-48.png")));
		menuBar.add(mnRelatrio);

		JMenuItem mntmGerar = new JMenuItem("Gerar");
		mntmGerar.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-answers-48.png")));
		mnRelatrio.add(mntmGerar);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(MenuGeral.class.getResource("/icons/icons8-about-48.png")));
		menuBar.add(mnSobre);
		getContentPane().setLayout(null);
	}

}
