package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GestionSocio extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionSocio dialog = new GestionSocio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionSocio() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO SOCIO");
			nuevo.setBounds(25, 59, 189, 23);
			getContentPane().add(nuevo);
		}
		{
			JButton borrar = new JButton("BORRAR SOCIO");
			borrar.setBounds(35, 103, 189, 23);
			getContentPane().add(borrar);
		}
		{
			JButton consultas = new JButton("CONSULTAS  SOCIO\r\n");
			consultas.setBounds(35, 161, 189, 23);
			getContentPane().add(consultas);
		}
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
	}

}
