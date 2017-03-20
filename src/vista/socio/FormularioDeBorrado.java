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

public class FormularioDeBorrado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField dni;
	private JTextField apellido;
	private JTextField direccion;
	private JTextField poblacion;
	private JTextField provincia;
	private JComboBox comboBoxSocios;

	private ControladorSocio controladorSocio;
	private JTextField id;

	/**
	 * Create the dialog.
	 */
	public FormularioDeBorrado(GestionSocio parent, boolean modal) {
		super(parent, modal);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblApellido = new JLabel("Apellido");

		JLabel lblDireccion = new JLabel("Direccion");

		JLabel lblPoblacion = new JLabel("Poblacion");

		JLabel lblProvincia = new JLabel("Provincia");

		JLabel lblDni = new JLabel("DNI");

		comboBoxSocios = new JComboBox();
		
		comboBoxSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(e.getActionCommand());
				String nombreSocio = (String) comboBoxSocios.getSelectedItem();
				if (nombreSocio != null) {
					String[] partes = nombreSocio.split(":");
					// en la parte 0 esta el id del socio
					controladorSocio.rellenarFormDeBorrado(Integer.parseInt(partes[0]));
				}
			}
		});
		

		JLabel lblSelccionaElAlumno = new JLabel("Selcciona el alumno");
		lblSelccionaElAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));

		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setEnabled(false);
		nombre.setColumns(10);

		dni = new JTextField();
		dni.setEditable(false);
		dni.setEnabled(false);
		dni.setColumns(10);

		apellido = new JTextField();
		apellido.setEditable(false);
		apellido.setEnabled(false);
		apellido.setColumns(10);

		direccion = new JTextField();
		direccion.setEditable(false);
		direccion.setEnabled(false);
		direccion.setColumns(10);

		poblacion = new JTextField();
		poblacion.setEditable(false);
		poblacion.setEnabled(false);
		poblacion.setColumns(10);

		provincia = new JTextField();
		provincia.setEditable(false);
		provincia.setEnabled(false);
		provincia.setColumns(10);

		JLabel lblId = new JLabel("id");

		id = new JTextField();
		id.setEnabled(false);
		id.setEditable(false);
		id.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPanel
												.createSequentialGroup().addGroup(gl_contentPanel
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
																.createSequentialGroup()
																.addGap(19)
																.addGroup(gl_contentPanel.createParallelGroup(
																		Alignment.LEADING)
																		.addGroup(gl_contentPanel
																				.createSequentialGroup()
																				.addGroup(gl_contentPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(lblProvincia)
																						.addComponent(lblPoblacion)
																						.addComponent(lblDireccion)
																						.addComponent(lblApellido)
																						.addComponent(
																								lblNombre)
																						.addComponent(lblDni))
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addGroup(gl_contentPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(nombre,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(id,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(dni,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(apellido,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(direccion,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(poblacion,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(provincia,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
																		.addComponent(lblId))
																.addGap(92))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(22)
																.addComponent(lblSelccionaElAlumno).addGap(18)
																.addComponent(comboBoxSocios,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
												.addContainerGap(172, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxSocios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelccionaElAlumno))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblId).addComponent(id,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(1)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre).addComponent(
						nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblDni).addComponent(dni,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblApellido)
						.addComponent(apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblDireccion)
						.addComponent(direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPoblacion)
						.addComponent(poblacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblProvincia)
						.addComponent(provincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton borrar = new JButton("BORRAR");
				borrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						eliminacion();
					}
				});
				borrar.setActionCommand("OK");
				buttonPane.add(borrar);
				getRootPane().setDefaultButton(borrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorSocio.cerrarFormularioDeBorrado();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void eliminacion() {
		int respuesta = JOptionPane.showConfirmDialog(this, "Desea realmente eliminar?", "adf", JOptionPane.YES_NO_OPTION);
		System.out.println(respuesta);
		if (respuesta==JOptionPane.YES_OPTION){
			this.controladorSocio.eliminarSocio(Integer.parseInt(this.id.getText()));
		}
		
	}

	public void rellenarComboSocios(ArrayList<Socio> socios) {
		Iterator<Socio> iterator = socios.iterator();
		while (iterator.hasNext()) {
			Socio socio = iterator.next();
			this.comboBoxSocios.addItem(socio.getId() + ": " + socio.getNombre() + " " + socio.getApellido());
		}
	}

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	public void rellenarFormulario(Socio socio) {
		this.id.setText(String.valueOf(socio.getId()));
		this.nombre.setText(socio.getNombre());
		this.apellido.setText(socio.getApellido());
		this.direccion.setText(socio.getDireccion());
		this.poblacion.setText(socio.getPoblacion());
		this.provincia.setText(socio.getProvincia());
		this.dni.setText(socio.getDni());
	}

	public void clear() {
		this.comboBoxSocios.removeAllItems();
		this.id.setText("");
		this.nombre.setText("");
		this.apellido.setText("");
		this.direccion.setText("");
		this.poblacion.setText("");
		this.provincia.setText("");
		this.dni.setText("");
	}

	public void mostrarMensaje(String string) {
		JOptionPane.showMessageDialog(this, string);
		
	}

	
}
