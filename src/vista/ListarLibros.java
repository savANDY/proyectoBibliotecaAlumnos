package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorLibro;
import modelo.Libro;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ListarLibros extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorLibro  controladorLibro;
	private JTable tabla;
	private JScrollPane scrollPane;

	public ListarLibros(JDialog parent, boolean modal) {
		
		super(parent,modal);
		
		setBounds(100, 100, 829, 445);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 813, 406);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblListadoDeLibros = new JLabel("LISTADO DE LIBROS");
		lblListadoDeLibros.setBounds(240, 32, 300, 14);
		contentPanel.add(lblListadoDeLibros);
		lblListadoDeLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeLibros.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 57, 439, 285);
		contentPanel.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
	}
	public void rellenarTabla(ArrayList<Libro> libros) {
		
		DefaultTableModel dtm=new DefaultTableModel();
		
		String[] encabezados={"ID","TITULO","AUTOR","NUM PAGINAS"};
		
		dtm.setColumnIdentifiers(encabezados);
		
		for (Libro libro:libros){
			
			String[]  fila={ String.valueOf(libro.getId()),libro.getTitulo(),libro.getAutor(),String.valueOf(libro.getNum_pag())};
			dtm.addRow(fila);
		}
		tabla.setModel(dtm);
		
	}
	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}
	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}
	public JTable getTabla() {
		return tabla;
	}
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
	
}
