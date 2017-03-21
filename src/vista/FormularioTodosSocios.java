package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ControladorSocio;
import modelo.Socio;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FormularioTodosSocios extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorSocio controladorSocio;
	private JTable tabla;


	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}




	/**
	 * Create the dialog.
	 */
	public FormularioTodosSocios( JDialog parent, boolean modal) {
		
		super(parent,modal);
		
		setBounds(100, 100, 552, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 536, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblConsultasDeSocios = new JLabel("CONSULTAS DE SOCIOS");
		lblConsultasDeSocios.setBounds(110, 29, 300, 14);
		lblConsultasDeSocios.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultasDeSocios.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPanel.add(lblConsultasDeSocios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 54, 403, 196);
		contentPanel.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
	}

	public void rellenarTabla(ArrayList<Socio> socios) {
		
		DefaultTableModel dtm=new DefaultTableModel();
		
		String[] cabeceras={"NOMBRE","APELLIDOS","POBLACION"};
		
		dtm.setColumnIdentifiers(cabeceras);
		
		for (Socio socio:socios){
			
			String[] fila={socio.getNombre(),socio.getApellido(),socio.getPoblacion()};
			
			//System.out.println(socio.getNombre()+" "+socio.getApellido()+" "+socio.getPoblacion());
			
			dtm.addRow(fila);
		}
		
		tabla.setModel(dtm);
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(dtm);
		tabla.setRowSorter(modeloOrdenado);
	}
}
