package controlador;

import modelo.Socio;

import java.util.ArrayList;

import modelo.ModeloSocio;
import vista.FormularioDeBorrado;
import vista.FormularioSocio;
import vista.Principal;
import vista.GestionSocio;

public class ControladorSocio {

	
	//un atributo por cada ventana de Socio
	//un atributo para el modelo Socio

	private ModeloSocio modeloSocio;
	
	private GestionSocio gestionSocio;
	private Principal principal;
	private FormularioSocio formularioSocio;
	private FormularioDeBorrado formularioDeBorrado;



	/**
	 * socio bat sortu eta modeloari insert egiteko esaten dio
	 * 
	 * @param nombre nombre del socio
	 * @param apellido apellido del socio
	 * @param direccion direccion del socio
	 * @param poblacion poblacion del socio
	 * @param provincia provincia del socio
	 * @param dni dni del socio
	 *  
	 */

	public void insertarSocio(String nombre, String apellido, String direccion, String poblacion, String provincia,
			String dni) {

		Socio socio = new Socio();
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setPoblacion(poblacion);
		socio.setProvincia(provincia);
		socio.setDni(dni);

		this.modeloSocio.insertar(socio);
	}

	public void abrirGestionSocio() {
		this.gestionSocio.setVisible(true);
	}

	public void abrirFormularioSocio() {
		this.formularioSocio.setVisible(true);
	}

	public void abrirFormDeBorrado() {
		ArrayList<Socio> socios = this.modeloSocio.seleccionarTodos();

		this.formularioDeBorrado.rellenarComboSocios(socios);
		this.formularioDeBorrado.setVisible(true);
	}


	public ModeloSocio getModeloSocio() {
		return modeloSocio;
	}

	public void setModeloSocio(ModeloSocio modeloSocio) {
		this.modeloSocio = modeloSocio;
	}

	public GestionSocio getGestionSocio() {
		return gestionSocio;
	}

	public void setGestionSocio(GestionSocio gestionSocio) {
		this.gestionSocio = gestionSocio;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public FormularioSocio getFormularioSocio() {
		return formularioSocio;
	}

	public void setFormularioSocio(FormularioSocio formularioSocio) {
		this.formularioSocio = formularioSocio;
	}

	public FormularioDeBorrado getFormularioDeBorrado() {
		return formularioDeBorrado;
	}

	public void setFormularioDeBorrado(FormularioDeBorrado formularioDeBorrado) {
		this.formularioDeBorrado = formularioDeBorrado;
	}

	public void cerrarFormularioSocio() {
		this.formularioSocio.dispose();
		
	}
	
}
