package controlador;

import vista.*;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.*;

public class ControladorLibro {

	//un atributo por cada ventana de libros-->5
	//un atributo por cada Tabla de la BD-->   1
	private GestionLibro gestionLibro;
	private NuevoLibro nuevoLibro;
	private BorrarLibro borrarLibro;
	private ConsultarLibro consultarLibro;
	private ListarLibros  listarLibros;
	
	
	
	
	private ModeloLibro modeloLibro;

	public ControladorLibro() {
		super();
		
		
	}
	
	
	public void insertarLibro(String titulo,String autor,int num_pag){
		
		Libro libro=new Libro();
		
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setNum_pag(num_pag);
		
		modeloLibro=new ModeloLibro();
		
		try {
			modeloLibro.insertar(libro);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al insertar nuevo LIBRO");
		}
	}

	public GestionLibro getGestionLibro() {
		return gestionLibro;
	}

	public void setGestionLibro(GestionLibro gestionLibro) {
		this.gestionLibro = gestionLibro;
	}

	public NuevoLibro getNuevoLibro() {
		return nuevoLibro;
	}

	public void setNuevoLibro(NuevoLibro nuevoLibro) {
		this.nuevoLibro = nuevoLibro;
	}

	public BorrarLibro getBorrarLibro() {
		return borrarLibro;
	}

	public void setBorrarLibro(BorrarLibro borrarLibro) {
		this.borrarLibro = borrarLibro;
	}

	public ConsultarLibro getConsultarLibro() {
		return consultarLibro;
	}

	public void setConsultarLibro(ConsultarLibro consultarLibro) {
		this.consultarLibro = consultarLibro;
	}

	public ListarLibros getListarLibros() {
		return listarLibros;
	}

	public void setListarLibros(ListarLibros listarLibros) {
		this.listarLibros = listarLibros;
	}

	public ModeloLibro getModeloLibro() {
		return modeloLibro;
	}

	public void setModeloLibro(ModeloLibro modeloLibro) {
		this.modeloLibro = modeloLibro;
	}


	public void abrirGestionLibro() {
		
		gestionLibro.setVisible(true);
		
	}


	public void abrirNuevoLibro() {

		nuevoLibro.setVisible(true);
		
	}


	public void abrirBorrarLibro() {

		borrarLibro.setVisible(true);
		
	}


	public void abrirConsultarLibro() {

		consultarLibro.setVisible(true);
		
	}


	public void abrirListarLibros() {

		listarLibros.setVisible(true);
		
	}

}
