package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Libro;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import modelo.ModeloSocio;
import modelo.Prestamo;
import modelo.Socio;
import vista.*;
import vista.prestamo.BorrarPrestamo;
import vista.prestamo.FormularioPrestamo;
import vista.prestamo.GestionPrestamo;
import vista.prestamo.ListarPrestamos;

public class ControladorPrestamo {

	private Principal principal;
	private GestionPrestamo gestionPrestamo;
	private FormularioPrestamo formularioPrestamo;
	private ModeloSocio modeloSocio;
	private ModeloLibro modeloLibro;
	private ModeloPrestamo modeloPrestamo;
	private BorrarPrestamo borrarPrestamo;
	private ListarPrestamos listarPrestamos;

	public GestionPrestamo getGestorPrestamo() {
		return gestionPrestamo;
	}

	public void setGestorPrestamo(GestionPrestamo gestorPrestamo) {
		this.gestionPrestamo = gestorPrestamo;
	}

	public ModeloPrestamo getModeloPrestamo() {
		return modeloPrestamo;
	}

	public void setModeloPrestamo(ModeloPrestamo modeloPrestamo) {
		this.modeloPrestamo = modeloPrestamo;
	}

	public GestionPrestamo getGestionPrestamo() {
		return gestionPrestamo;
	}

	public void setGestionPrestamo(GestionPrestamo gestionPrestamo) {
		this.gestionPrestamo = gestionPrestamo;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public FormularioPrestamo getFormularioPrestamo() {
		return formularioPrestamo;
	}

	public void setFormularioPrestamo(FormularioPrestamo formularioPrestamo) {
		this.formularioPrestamo = formularioPrestamo;
	}
	

	public ListarPrestamos getListarPrestamos() {
		return listarPrestamos;
	}

	public void setListarPrestamos(ListarPrestamos listarPrestamos) {
		this.listarPrestamos = listarPrestamos;
	}

	
	// Constructor
	public ControladorPrestamo() {
		super();

	}

	public void abrirGestionPrestamo() {
		this.gestionPrestamo.setVisible(true);

	}

	public void abrirFormularioPrestamo() {
		// lortu socio guztiak
		ArrayList<Socio> socios = this.modeloSocio.seleccionarTodos();
		// Bete socioen comboa
		this.formularioPrestamo.rellenarComboSocio(socios);
		// Prestamo gabeko liburuak
		ArrayList<Libro> libros = this.modeloLibro.seleccionarNoPrestados();
		// Bete liburuen comboa
		this.formularioPrestamo.rellenarComboLibros(libros);

		this.formularioPrestamo.setVisible(true);

	}

	public void listarTodosPrestamos() {

		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

		try {
			prestamos = modeloPrestamo.seleccionarTodos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(gestionPrestamo, "Error al seleccionar todos los prestammos!");
			// e.printStackTrace();
		}

		gestionPrestamo.rellenarTabla(prestamos);

		// formTodosSocios.setVisible(true);

	}
	
	public void abrirBorrarPrestamo() {
		
		this.borrarPrestamo.setVisible(true);
		
	}
	
	public void abrirListarPrestamos() {
		
		this.listarPrestamos.setVisible(true);
		
	}

	public ModeloSocio getModeloSocio() {
		return modeloSocio;
	}

	public void setModeloSocio(ModeloSocio modeloSocio) {
		this.modeloSocio = modeloSocio;
	}

	public ModeloLibro getModeloLibro() {
		return modeloLibro;
	}

	public void setModeloLibro(ModeloLibro modeloLibro) {
		this.modeloLibro = modeloLibro;
	}

	public void prestar(int libro, int socio) throws Exception {

		modeloPrestamo.prestar(libro, socio);

	}

	public BorrarPrestamo getBorrarPrestamo() {
		return borrarPrestamo;
	}

	public void setBorrarPrestamo(BorrarPrestamo borrarPrestamo) {
		this.borrarPrestamo = borrarPrestamo;
	}





	
}
