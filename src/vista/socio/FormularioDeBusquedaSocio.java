package vista.socio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSocio;
import modelo.Socio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class FormularioDeBusquedaSocio extends JDialog {
//	public FormularioBusquedaSocio() {
//	}
	
	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField apellido;

	private ControladorSocio controladorSocio;
	private JTable table;
	private JComboBox comboProvincias;
	private JComboBox comboPoblacion;

	/**
	 * Create the dialog.
	 */
	public FormularioDeBusquedaSocio(GestionSocio parent, boolean modal) {
		super(parent, modal);

		setBounds(100, 100, 508, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblApellido = new JLabel("Apellido");

		JLabel lblPoblacion = new JLabel("Poblacion");
		

		JLabel lblSelccionaElAlumno = new JLabel("Busqueda de Socio");
		lblSelccionaElAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));

		nombre = new JTextField();
		nombre.setEditable(true);
		nombre.setEnabled(true);
		nombre.setColumns(10);

		apellido = new JTextField();
		apellido.setEditable(true);
		apellido.setEnabled(true);
		apellido.setColumns(10);
		
		JButton buscarNombre = new JButton("Buscar");
		buscarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.mostrarSociosPorNombre(nombre.getText());
			}
		});
		
		
		
		JButton buscarApellido = new JButton("Buscar");
		buscarApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.mostrarSociosPorApellido(apellido.getText());
			}
		});
		
		
		JButton buscarPoblacion = new JButton("Buscar");
		buscarPoblacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.mostrarSociosPorPoblacion(String.valueOf(comboPoblacion.getSelectedItem()));
			}
		});
		
		JLabel lblProvincia = new JLabel("Provincia");
		
		comboProvincias = new JComboBox();
		comboProvincias.setEditable(true);
		
		table = new JTable();
		table.setToolTipText("Prueba");
		
		comboPoblacion = new JComboBox();
		comboPoblacion.setEditable(true);
		
		JButton buscarProvincia = new JButton("Buscar");
		buscarProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.mostrarSociosPorProvincia(String.valueOf(comboProvincias.getSelectedItem()));
			}
		});
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblNombre)
											.addGap(18)
											.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPoblacion)
												.addComponent(lblApellido)
												.addComponent(lblProvincia, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(comboProvincias, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(comboPoblacion, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(apellido))))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(buscarNombre, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
										.addComponent(buscarApellido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(buscarPoblacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(buscarProvincia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(lblSelccionaElAlumno)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(120, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelccionaElAlumno)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buscarNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buscarApellido))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPoblacion)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboPoblacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buscarPoblacion)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProvincia)
						.addComponent(comboProvincias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buscarProvincia))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		contentPanel.setLayout(gl_contentPanel);
		
	}

	
	
	

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	public void rellenarTabla(ArrayList<Socio> socios) {
		
	}
}
