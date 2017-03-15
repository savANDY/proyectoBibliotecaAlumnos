package controlador;

import vista.*;
import modelo.*;

public class ControladorLibro {

	
	private GestionLibro gestionLibro;
	private NuevoLibro nuevoLibro;
	private BorrarLibro borrarLibro;
	private ConsultarLibro consultarLibro;
	private ModeloLibro modeloLibro;

	public ControladorLibro() {
		super();
		
		modeloLibro=new ModeloLibro();
	}
	
	public void abrirGestionLibro() {
		
		gestionLibro=new GestionLibro();
		this.gestionLibro.setVisible(true);
	}

	public void abrirNuevoLibro() {
		nuevoLibro=new NuevoLibro();
		this.gestionLibro.setVisible(true);
	}

	public void abrirBorrarLibro() {
		borrarLibro=new BorrarLibro();
		this.gestionLibro.setVisible(true);
	}

	public void abrirConsultarLibro() {
		consultarLibro=new ConsultarLibro();
		this.gestionLibro.setVisible(true);
	}
	public void insertarLibro(String titulo,String autor,int num_pag){
		
		
		Libro libro=new Libro();
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setNum_pag(num_pag);
		
	}

}
