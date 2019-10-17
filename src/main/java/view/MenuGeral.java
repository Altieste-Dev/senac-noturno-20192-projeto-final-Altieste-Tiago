package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

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
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {}, new RowSpec[] {}));
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {}, new RowSpec[] {}));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		setJMenuBar(menuBar);

		JMenu mnVendedor = new JMenu("Vendedor");
		mnVendedor.setAlignmentX(Component.RIGHT_ALIGNMENT);
		menuBar.add(mnVendedor);

		JMenu mnVeculos = new JMenu("Veículos");
		menuBar.add(mnVeculos);

		JMenu mnRelatrio = new JMenu("Relatório");
		menuBar.add(mnRelatrio);

		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
	}

}
