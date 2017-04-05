package vista.prestamo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrestamo;
import modelo.Prestamo;
import modelo.Socio;
import vista.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Font;

public class GestionPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControladorPrestamo controladorPrestamo;
	private FormularioPrestamo formulacionPrestamo;
	private JTable tabla;
	private JTextPane txtpnMensajesVentana;

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	/**
	 * Create the dialog.
	 */
	public GestionPrestamo(JFrame principal, boolean modal) {
		super(principal, true);
		setTitle("Gestion de prestamos");
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nuevo prestamo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 191, 463, 107);
		contentPanel.add(panel);
		
				JButton btnNewButton = new JButton("Realizar Prestamo");
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
							.addContainerGap())
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
							.addContainerGap())
				);
				panel.setLayout(gl_panel);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opciones prestamos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(10, 309, 463, 115);
				contentPanel.add(panel_1);
				
				JButton btnBorrarSeleccionado = new JButton("Borrar Seleccionado");
				
				JButton btnBorrarOtros = new JButton("Borrar otros");
				btnBorrarOtros.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						controladorPrestamo.abrirBorrarPrestamo();
						
					}
				});
				
				JButton btnLibroDevuelto = new JButton("Libro devuelto");
				btnLibroDevuelto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if (!tabla.getSelectionModel().isSelectionEmpty()){
							
						String tituloLibro = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
						tabla.setValueAt("Si",tabla.getSelectedRow(), 3);
						
						txtpnMensajesVentana.setText("¡Hecho, libro " + tituloLibro + " devuelto!");
						
						System.out.println(tituloLibro);
						}
					}
				});
				
				JButton btnListarPrestamos = new JButton("Listar Por Socio");
				btnListarPrestamos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						controladorPrestamo.abrirListarPorSocio();
						
					}
				});
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(btnBorrarSeleccionado, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(btnBorrarOtros, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
											.addGap(11)))
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnListarPrestamos, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
									.addGap(10)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLibroDevuelto, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnLibroDevuelto, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnListarPrestamos)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnBorrarSeleccionado)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBorrarOtros)))
							.addContainerGap())
				);
				panel_1.setLayout(gl_panel_1);
				
				
				
				txtpnMensajesVentana = new JTextPane();
				
				SimpleAttributeSet attribs = new SimpleAttributeSet();  
				StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER);  
				txtpnMensajesVentana.setParagraphAttributes(attribs,true);
				
				txtpnMensajesVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
				txtpnMensajesVentana.setOpaque(false);
				txtpnMensajesVentana.setEditable(false);
				txtpnMensajesVentana.setText("Elige una opci\u00F3n:");
				txtpnMensajesVentana.setBounds(10, 160, 463, 20);
				
				contentPanel.add(txtpnMensajesVentana);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(null, "Historial de prestamos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 153, 153)));
				panel_2.setBounds(10, 11, 464, 140);
				contentPanel.add(panel_2);
				panel_2.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 21, 444, 108);
				panel_2.add(scrollPane);
				
								tabla = new JTable();
								scrollPane.setViewportView(tabla);
				
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						controladorPrestamo.abrirFormularioPrestamo();

					}
				});
	}
	
	public void rellenarTabla(ArrayList<Prestamo> prestamos) {

		DefaultTableModel dtm = new DefaultTableModel();
		
		String[] cabeceras = { "LIBRO", "SOCIO", "FECHA", "DEVUELTO" };
		dtm.setColumnIdentifiers(cabeceras);
		
		String devuelto = null;

		for (Prestamo prestamo : prestamos) {

			if (prestamo.isDevuelto()) {
				devuelto = "Si";
			} else {
				devuelto = "No";
			}
			
			String libro = controladorPrestamo.seleccionarTituloPorId(prestamo.getId_libro());
			String socio = controladorPrestamo.seleccionarSocioPorId(prestamo.getId_socio());
			
			String[] fila = { libro, socio, prestamo.getFecha().toString(), devuelto };


			dtm.addRow(fila);
		}
		tabla.setModel(dtm);
		// para poder ordenar por las cabeceras
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(dtm);
		tabla.setRowSorter(modeloOrdenado);
	}
}
