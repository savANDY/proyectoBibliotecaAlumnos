package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLibro;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private ControladorLibro controladorLibro;

	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	/**
	 * Create the dialog.
	 */
	public GestionLibro(Principal parent, boolean modal) {
		
		super(parent,modal);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO LIBRO");
			nuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controladorLibro.abrirNuevoLibro();
				}
			});
			nuevo.setBounds(49, 77, 189, 23);
			contentPanel.add(nuevo);
		}
		{
			JButton borrar = new JButton("BORRARLIBRO");
			borrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					controladorLibro.abrirBorrarLibro();
				}
			});
			borrar.setBounds(49, 123, 189, 23);
			contentPanel.add(borrar);
		}
		{
			JButton consultas = new JButton("CONSULTAS LIBRO");
			consultas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					controladorLibro.abrirConsultarLibro();
				}
			});
			consultas.setBounds(49, 168, 189, 23);
			contentPanel.add(consultas);
		}
		{
			JLabel lblNewLabel = new JLabel("GESTION DE LIBRO");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(94, 28, 275, 23);
			contentPanel.add(lblNewLabel);
		}
		
		JButton listar = new JButton("LISTAR LIBROS");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controladorLibro.abrirListarLibros();
			}
		});
		listar.setBounds(49, 214, 189, 23);
		contentPanel.add(listar);
	}
}
