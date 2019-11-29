package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuGeral extends JFrame {

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
		setBounds(100, 100, 450, 300);

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
				painelCadastroVendedor.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
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
				painelCadastroCliente.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelCadastroCliente);
				revalidate();
			}
		});
		mnCliente.add(mntmCadastrar_2);

		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCliente painelConsultaCliente = new ConsultarCliente();
				painelConsultaCliente.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelConsultaCliente);
				revalidate();
			}
		});
		mnCliente.add(mntmConsultar_1);

		JMenu mnVeculos = new JMenu("Veículos");
		menuBar.add(mnVeculos);

		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarVeiculo painelCadastrarVeiculo = new CadastrarVeiculo();
				painelCadastrarVeiculo.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelCadastrarVeiculo);
				revalidate();
			}
		});
		mnVeculos.add(mntmCadastrar_1);

		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarVeiculos painelConsultarVeiculo = new ConsultarVeiculos();
				painelConsultarVeiculo.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
				setContentPane(painelConsultarVeiculo);
				revalidate();

			}
		});
		mnVeculos.add(mntmConsultar);

		JMenu mnRelatrio = new JMenu("Relatório");
		menuBar.add(mnRelatrio);

		JMenuItem mntmGerar = new JMenuItem("Gerar");
		mnRelatrio.add(mntmGerar);

		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		getContentPane().setLayout(null);
	}

}
