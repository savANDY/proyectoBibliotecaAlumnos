package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GestionLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionLibro dialog = new GestionLibro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionLibro() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO LIBRO");
			nuevo.setBounds(49, 77, 189, 23);
			contentPanel.add(nuevo);
		}
		{
			JButton borrar = new JButton("BORRARLIBRO");
			borrar.setBounds(49, 123, 189, 23);
			contentPanel.add(borrar);
		}
		{
			JButton consultas = new JButton("CONSULTAS LIBRO");
			consultas.setBounds(49, 168, 189, 23);
			contentPanel.add(consultas);
		}
	}

}
