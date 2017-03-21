package vista.libro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLibro;
import controlador.ControladorPrestamo;
import controlador.ControladorSocio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	private ControladorLibro controladorLibro;
	private ControladorSocio controladorSocio;
	private ControladorPrestamo controladorPrestamo;

	
	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}


	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}


	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}


	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}


	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}


	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}


	public Principal() {
		setTitle("Gestion Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 390, 325);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton button = new JButton("Gestion Socios");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controladorSocio.abrirGestionSocio();

			}
		});
		button.setBounds(30, 100, 157, 77);

		JButton button_1 = new JButton("Gestion Libros");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controladorLibro.abrirGestionLibro();

			}
		});
		button_1.setBounds(196, 11, 157, 77);

		JButton btnPrestamos = new JButton("Prestamos");
		btnPrestamos.setBounds(196, 187, 157, 77);
		btnPrestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controladorPrestamo = new ControladorPrestamo();

				//controladorPrestamo.abrirGestionPrestamo();

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnPrestamos);
		contentPane.add(button_1);
		contentPane.add(button);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/prestamos.jpg")));
		label.setBounds(29, 187, 157, 77);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/libros.jpg")));
		label_1.setBounds(29, 11, 157, 77);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/socios.jpg")));
		label_2.setBounds(196, 99, 157, 77);
		contentPane.add(label_2);
	}
}
