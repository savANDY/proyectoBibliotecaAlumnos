package controlador;


import modelo.ModeloPrestamo;
import vista.Principal;
import vista.prestamo.FormularioPrestamo;
import vista.prestamo.GestionPrestamo;


public class ControladorPrestamo {

	private ModeloPrestamo modeloPrestamo;
	private GestionPrestamo gestionPrestamo;
	private FormularioPrestamo formularioPrestamo;
	private Principal principal;
	
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

	public ControladorPrestamo() {
		super();
		
		
	}
	
	public void abrirGestionPrestamo() {
		this.gestionPrestamo.setVisible(true);
	}
	
	public void abrirFormularioPrestamo() {
		this.formularioPrestamo.setVisible(true);
	}
	
	
}
