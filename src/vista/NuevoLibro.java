package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLibro;
import modelo.Libro;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField titulo;
	private JTextField autor;
	private JTextField num_pag;
	private JButton guardar;
	private JLabel lblNewLabel;
	
	private ControladorLibro controladorLibro;

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}
	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}
	/**
	 * Create the dialog.
	 */
	public NuevoLibro(JDialog parent,boolean modal) {
		
		super(parent,modal);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		titulo = new JTextField();
		titulo.setColumns(10);
		titulo.setBounds(193, 74, 86, 20);
		contentPanel.add(titulo);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(34, 78, 46, 14);
		contentPanel.add(lblTitulo);
		
		autor = new JTextField();
		autor.setColumns(10);
		autor.setBounds(193, 130, 86, 20);
		contentPanel.add(autor);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(34, 133, 46, 14);
		contentPanel.add(lblAutor);
		
		num_pag = new JTextField();
		num_pag.setColumns(10);
		num_pag.setBounds(193, 186, 86, 20);
		contentPanel.add(num_pag);
		
		JLabel lblNumDePaginas = new JLabel("Num  de Paginas");
		lblNumDePaginas.setBounds(34, 188, 90, 14);
		contentPanel.add(lblNumDePaginas);
		
		guardar = new JButton("GUARDAR");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controladorLibro.insertarLibro(titulo.getText(), autor.getText(), Integer.parseInt(num_pag.getText()));
				
			}
		});
		guardar.setBounds(322, 123, 89, 23);
		contentPanel.add(guardar);
		
		lblNewLabel = new JLabel("ALTA DE LIBRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 11, 300, 14);
		contentPanel.add(lblNewLabel);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(322, 173, 89, 23);
		contentPanel.add(btnLimpiar);
	}
}
