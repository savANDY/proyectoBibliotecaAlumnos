package vista;

import java.awt.BorderLayout;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/book-2869_1280.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuLibros = new JMenu("Gestion Libros");
		menuBar.add(menuLibros);
		
		JMenu menuSocios = new JMenu("Gestion Socios");
		menuBar.add(menuSocios);
		
		JMenu menuPrestamos = new JMenu("Prestamos");
		menuBar.add(menuPrestamos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton prestamos = new JButton("PRESTAMOS");
		prestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//controladorPrestamo.abrirGestionPrestamo();

			}
		});
		prestamos.setBounds(40, 190, 168, 23);
		contentPane.add(prestamos);
		
		JButton socios = new JButton("GESTION SOCIOS");
		socios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controladorSocio.abrirGestionSocio();

			}
		});
		socios.setBounds(40, 109, 168, 23);
		contentPane.add(socios);
		
		JButton libros = new JButton("GESTION LIBROS");
		libros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controladorLibro.abrirGestionLibro();
				
			}
		});
		libros.setBounds(40, 48, 168, 23);
		contentPane.add(libros);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/book-2869_1280.jpg")));
		lblNewLabel.setBounds(234, 51, 190, 199);
		contentPane.add(lblNewLabel);
		
		JLabel titulo = new JLabel("ZORNOTZAko UDAL LIBURUTEGIA");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		titulo.setBounds(40, 11, 366, 26);
		contentPane.add(titulo);
	}
}
