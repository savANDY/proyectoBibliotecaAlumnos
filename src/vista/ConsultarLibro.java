package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLibro;
import controlador.ControladorSocio;
import modelo.Libro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class ConsultarLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorLibro controladorLibro;
	private JTable tabla;

	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	public ConsultarLibro(JDialog parent, boolean modal) {

		super(parent, modal);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblConsultasDeLibros = new JLabel("CONSULTAS DE LIBROS");
		lblConsultasDeLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultasDeLibros.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsultasDeLibros.setBounds(66, 11, 300, 14);
		contentPanel.add(lblConsultasDeLibros);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 61, 359, 178);
		contentPanel.add(scrollPane_1);
		
		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(tabla);
	}



	public void rellenarTabla(ArrayList<Libro> libros) {
		// cargar la tabla
		DefaultTableModel dtm = new DefaultTableModel();

		dtm.setColumnIdentifiers(new Object[] { "TITULO", "AUTOR", "NUM PAGINAS" });

		for (Libro libro : libros) {
			dtm.addRow(new Object[] { libro.getTitulo(), libro.getAutor(), String.valueOf(libro.getNum_pag()) });
		}
		tabla.setModel(dtm);
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(dtm);
		tabla.setRowSorter(modeloOrdenado);
	}

	

}
