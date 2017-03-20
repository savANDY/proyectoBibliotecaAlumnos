package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSocio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GestionSocio extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public GestionSocio(Principal principal, boolean modal) {
		super(principal, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO SOCIO");
			nuevo.setBounds(25, 71, 189, 23);
			contentPanel.add(nuevo);
			{
				JButton borrar = new JButton("BORRAR SOCIO");
				borrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ControladorSocio().abrirFormDeBorrado();
					}
				});
				borrar.setBounds(25, 105, 189, 23);
				contentPanel.add(borrar);
			}
			{
				JButton consultas = new JButton("CONSULTAS  SOCIO\r\n");
				consultas.setBounds(25, 139, 189, 23);
				contentPanel.add(consultas);
			}
			
			JLabel lblGestionSocios = new JLabel("Gestion Socios");
			lblGestionSocios.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestionSocios.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblGestionSocios.setBounds(63, 25, 275, 23);
			contentPanel.add(lblGestionSocios);
			nuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ControladorSocio().abrirFormularioSocio();
				}
			});
		}
	}
}
