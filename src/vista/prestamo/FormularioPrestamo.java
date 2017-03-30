package vista.prestamo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBoxLibros = new JComboBox();
		comboBoxLibros.setEditable(true);
		comboBoxLibros.setBounds(141, 64, 131, 20);
		contentPanel.add(comboBoxLibros);
		
		JLabel lblLibros = new JLabel("Libros");
		lblLibros.setBounds(31, 67, 46, 14);
		contentPanel.add(lblLibros);
		
		JLabel lblSocios = new JLabel("Socios");
		lblSocios.setBounds(31, 122, 46, 14);
		contentPanel.add(lblSocios);
		
		comboBoxSocios = new JComboBox();
		comboBoxSocios.setEditable(true);
		comboBoxSocios.setBounds(145, 119, 127, 20);
		contentPanel.add(comboBoxSocios);
		
		JLabel lblPrestamoDeLibros = new JLabel("Prestamo de libros");
		lblPrestamoDeLibros.setBounds(29, 27, 141, 14);
		contentPanel.add(lblPrestamoDeLibros);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton buttonPrestamo = new JButton("Prestar");
				buttonPrestamo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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
