package vista.libro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLibro;
import controlador.ControladorSocio;
import modelo.Libro;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrarLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private JTextField titulo;
	private JTextField autor;
	private JTextField num_pag;

	private ControladorLibro controladorLibro;

	private JComboBox lista;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label;

	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	/**
	 * Create the dialog.
	 */
	public BorrarLibro(JDialog parent, boolean modal) {

		super(parent, modal);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			lista = new JComboBox();
			lista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					controladorLibro.seleccionarDatosLibro((String) lista.getSelectedItem());

				}
			});
			lista.setModel(new DefaultComboBoxModel(new String[] { "Elige libro....." }));
			lista.setBounds(109, 26, 231, 36);
			contentPanel.add(lista);
		}
		{
			id = new JTextField();
			id.setEditable(false);
			id.setColumns(10);
			id.setBounds(219, 73, 86, 20);
			contentPanel.add(id);
		}
		{
			label_1 = new JLabel("Id Libro");
			label_1.setBounds(60, 78, 46, 14);
			contentPanel.add(label_1);
		}
		{
			titulo = new JTextField();
			titulo.setEditable(false);
			titulo.setColumns(10);
			titulo.setBounds(219, 129, 86, 20);
			contentPanel.add(titulo);
		}
		{
			label_2 = new JLabel("Titulo");
			label_2.setBounds(60, 133, 46, 14);
			contentPanel.add(label_2);
		}
		{
			autor = new JTextField();
			autor.setEditable(false);
			autor.setColumns(10);
			autor.setBounds(219, 185, 86, 20);
			contentPanel.add(autor);
		}
		{
			label_3 = new JLabel("Autor");
			label_3.setBounds(60, 188, 46, 14);
			contentPanel.add(label_3);
		}
		{
			num_pag = new JTextField();
			num_pag.setEditable(false);
			num_pag.setColumns(10);
			num_pag.setBounds(219, 241, 86, 20);
			contentPanel.add(num_pag);
		}
		{
			label = new JLabel("Num  de Paginas");
			label.setBounds(60, 243, 90, 14);
			contentPanel.add(label);
		}

		JButton borrar = new JButton("BORRAR");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controladorLibro.borrarLibro((String) lista.getSelectedItem());
				lista.setSelectedIndex(0);
				controladorLibro.abrirBorrarLibro();

			}
		});
		borrar.setBounds(335, 128, 89, 23);
		contentPanel.add(borrar);

	}

	public void rellenarLista(ArrayList<Libro> libros) {

		lista.removeAllItems();

		for (Libro libro : libros) {

			lista.addItem(libro.getTitulo());
		}
	}

	public void mostrarDatos(Libro libro) {

		id.setText(String.valueOf(libro.getId()));
		titulo.setText(libro.getTitulo());
		autor.setText(libro.getAutor());
		num_pag.setText(String.valueOf(libro.getNum_pag()));

	}

	public void limpiar() {
		lista.setSelectedIndex(0);
		// id.setText("");
		// titulo.setText("");
		// autor.setText("");
		// num_pag.setText("");

	}
}
