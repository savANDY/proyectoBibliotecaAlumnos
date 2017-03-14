package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class NuevoLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private JTextField titulo;
	private JTextField autor;
	private JTextField numPag;
	private JButton guardar;
	private JLabel lblNewLabel;



	/**
	 * Create the dialog.
	 */
	public NuevoLibro() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			id = new JTextField();
			id.setEditable(false);
			id.setBounds(213, 62, 86, 20);
			contentPanel.add(id);
			id.setColumns(10);
		}
		{
			JLabel lblIdLibro = new JLabel("Id Libro");
			lblIdLibro.setBounds(54, 67, 46, 14);
			contentPanel.add(lblIdLibro);
		}
		
		titulo = new JTextField();
		titulo.setColumns(10);
		titulo.setBounds(213, 118, 86, 20);
		contentPanel.add(titulo);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(54, 122, 46, 14);
		contentPanel.add(lblTitulo);
		
		autor = new JTextField();
		autor.setColumns(10);
		autor.setBounds(213, 174, 86, 20);
		contentPanel.add(autor);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(54, 177, 46, 14);
		contentPanel.add(lblAutor);
		
		numPag = new JTextField();
		numPag.setColumns(10);
		numPag.setBounds(213, 230, 86, 20);
		contentPanel.add(numPag);
		
		JLabel lblNumDePaginas = new JLabel("Num  de Paginas");
		lblNumDePaginas.setBounds(54, 232, 90, 14);
		contentPanel.add(lblNumDePaginas);
		
		guardar = new JButton("GUARDAR");
		guardar.setBounds(322, 123, 89, 23);
		contentPanel.add(guardar);
		
		lblNewLabel = new JLabel("ALTA DE LIBRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 11, 300, 14);
		contentPanel.add(lblNewLabel);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(322, 173, 89, 23);
		contentPanel.add(btnLimpiar);
	}
}
