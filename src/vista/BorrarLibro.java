package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSocio;
import modelo.Libro;
import modelo.Socio;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class BorrarLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private ControladorSocio controladorSocio;
	private JComboBox lista;

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	/**
	 * Create the dialog.
	 */
	public BorrarLibro(GestionLibro parent, boolean modal) {

		super(parent, modal);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			lista = new JComboBox();
			lista.setModel(new DefaultComboBoxModel(new String[] { "Elige un libro..." }));
			lista.setBounds(109, 26, 231, 36);
			contentPanel.add(lista);
		}
		{
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBounds(219, 73, 86, 20);
			contentPanel.add(textField);
		}
		{
			JLabel label = new JLabel("Id Libro");
			label.setBounds(60, 78, 46, 14);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(219, 129, 86, 20);
			contentPanel.add(textField_1);
		}
		{
			JLabel label = new JLabel("Titulo");
			label.setBounds(60, 133, 46, 14);
			contentPanel.add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(219, 185, 86, 20);
			contentPanel.add(textField_2);
		}
		{
			JLabel label = new JLabel("Autor");
			label.setBounds(60, 188, 46, 14);
			contentPanel.add(label);
		}
		{
			textField_3 = new JTextField();
			textField_3.setEditable(false);
			textField_3.setColumns(10);
			textField_3.setBounds(219, 241, 86, 20);
			contentPanel.add(textField_3);
		}
		{
			JLabel label = new JLabel("Num  de Paginas");
			label.setBounds(60, 243, 90, 14);
			contentPanel.add(label);
		}
		{
			JButton borrar = new JButton("BORRAR");
			borrar.setBounds(323, 133, 89, 23);
			contentPanel.add(borrar);
		}

	}

	public void rellenarLista(ArrayList<Libro> libros) {
		Iterator<Libro> iterator = libros.iterator();
		while (iterator.hasNext()) {
			Libro libro = iterator.next();
			this.lista.addItem(libro.getId() + " " + libro.getTitulo());
		}

		// for (Libro libro:libros){
		// this.lista.addItem(libro.getTitulo());
		// }

	}

}
