package vista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorLibro;
import controlador.ControladorSocio;

public class ListarLibros extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable libros;

	private ControladorLibro controladorLibro;

	/**
	 * Create the dialog.
	 */
	public ListarLibros(JDialog parent, boolean modal) {
		
		super(parent,modal);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			libros = new JTable();
			libros.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column"
				}
			));
			contentPanel.add(libros);
		}
	}

}
