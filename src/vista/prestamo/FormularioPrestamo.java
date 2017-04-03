package vista.prestamo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrestamo;
import modelo.Libro;
import modelo.Socio;
import vista.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormularioPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControladorPrestamo controladorPrestamo;
	private JComboBox comboBoxSocios;
	private JComboBox comboBoxLibros;


	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	/**
	 * Create the dialog.
	 */
	public FormularioPrestamo(GestionPrestamo parent, boolean modal) {
		super(parent,true);
		setBounds(100, 100, 348, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Préstamo de libros"));
		panel.setBounds(10, 21, 312, 101);
		contentPanel.add(panel);
		
		JLabel lblLibros = new JLabel("Libro");
		
		comboBoxLibros = new JComboBox();
		comboBoxLibros.setEditable(true);
		
		JLabel lblSocios = new JLabel("Socio");
		
		comboBoxSocios = new JComboBox();
		comboBoxSocios.setEditable(true);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLibros, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxLibros, 0, 230, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSocios, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxSocios, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLibros)
						.addComponent(comboBoxLibros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSocios)
						.addComponent(comboBoxSocios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton buttonPrestamo = new JButton("Prestar");
				buttonPrestamo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						int idLibro = 0;
						int idSocio = 0;
						String nombreLibro = (String) comboBoxLibros.getSelectedItem();
						String nombreSocio = (String) comboBoxSocios.getSelectedItem();
						
						if (nombreLibro != null) {
							String[] partes = nombreLibro.split(":");
							// en la parte 0 esta el id del socio
							idLibro = Integer.parseInt(partes[0]);
						}
						
						if (nombreSocio != null) {
							String[] partes = nombreSocio.split(":");
							// en la parte 0 esta el id del socio
							idSocio = Integer.parseInt(partes[0]);
						}
												
						try {
							controladorPrestamo.prestar(idLibro,idSocio);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				buttonPrestamo.setActionCommand("OK");
				buttonPane.add(buttonPrestamo);
				getRootPane().setDefaultButton(buttonPrestamo);
			}
			{
				JButton buttonCancelar = new JButton("Cancelar");
				buttonCancelar.setActionCommand("Cancel");
				buttonPane.add(buttonCancelar);
			}
		}
	}

	public void rellenarComboSocio(ArrayList<Socio> socios) {
		
		for (Socio socio:socios){
			this.comboBoxSocios.addItem(socio.getId() + ":" + socio.getNombre() + " " + socio.getApellido());
		}
	}

	public void rellenarComboLibros(ArrayList<Libro> libros) {
		
		for (Libro libro:libros){
			this.comboBoxLibros.addItem(libro.getId() + ":" + libro.getTitulo());
		}
	}
}
