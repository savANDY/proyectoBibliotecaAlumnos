package vista.socio;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSocio;
import vista.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GestionSocio extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorSocio  controladorSocio;
	private Component consultas;
	private AbstractButton nuevo;
	private JButton listar;

	
	
	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}



	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}


	/**
	 * Create the dialog.
	 */
	public GestionSocio(JFrame principal, boolean modal) {
		super(principal, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton nuevo = new JButton("NUEVO SOCIO");
			nuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controladorSocio.abrirFormularioSocio();
				}
			});
			nuevo.setBounds(25, 71, 189, 23);
			contentPanel.add(nuevo);
			{
				JButton borrar = new JButton("BORRAR SOCIO");
				borrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorSocio.abrirFormDeBorrado();
					}
				});
				borrar.setBounds(25, 105, 189, 23);
				contentPanel.add(borrar);
			}
			{
				JButton modificar = new JButton("MODIFICAR SOCIOS");
				modificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controladorSocio.abrirFormDeModificar();
					}
				});
				
				modificar.setBounds(25, 139, 189, 23);
				contentPanel.add(modificar);
			}
		}
		
		JLabel lblGestionDeSocios = new JLabel("GESTION DE SOCIOS");
		lblGestionDeSocios.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDeSocios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestionDeSocios.setBounds(89, 25, 275, 23);
		contentPanel.add(lblGestionDeSocios);
		
		JButton button = new JButton("BUSCAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorSocio.abrirBusquedaSocio();
				
			}
		});
		button.setBounds(25, 173, 189, 23);
		contentPanel.add(button);
		{
			listar = new JButton("LISTAR SOCIOS");
			listar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controladorSocio.abrirFormListar();
					
				}
			});
			listar.setBounds(25, 207, 189, 23);
			contentPanel.add(listar);
		}
	}
}
