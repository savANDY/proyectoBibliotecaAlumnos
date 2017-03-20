package controlador;

import modelo.Socio;

import java.util.ArrayList;

import modelo.ModeloSocio;
import vista.Principal;
import vista.socio.FormularioDeBorrado;
import vista.socio.FormularioDeModificado;
import vista.socio.FormularioSocio;
import vista.socio.GestionSocio;

public class ControladorSocio {

	
	//un atributo por cada ventana de Socio
	//un atributo para el modelo Socio

	private ModeloSocio modeloSocio;
	
	private GestionSocio gestionSocio;
	private Principal principal;
	private FormularioSocio formularioSocio;
	private FormularioDeBorrado formularioDeBorrado;
	private FormularioDeModificado formDeModificado;



	public FormularioDeModificado getFormDeModificado() {
		return formDeModificado;
	}

	public void setFormDeModificado(FormularioDeModificado formDeModificado) {
		this.formDeModificado = formDeModificado;
	}

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

	//borrado de socio 
	public void abrirFormDeBorrado() {
		ArrayList<Socio> socios = this.modeloSocio.seleccionarTodos();

		this.formularioDeBorrado.rellenarComboSocios(socios);
		this.formularioDeBorrado.setVisible(true);
	}
	
	public void abrirFormDeModificar() {
		ArrayList<Socio> socios = this.modeloSocio.seleccionarTodos();

		this.formDeModificado.rellenarComboSocios(socios);
		this.formDeModificado.setVisible(true);
	}
	
	public void rellenarFormDeBorrado(int idSocio) {
		Socio socio = this.modeloSocio.select(idSocio);
		this.formularioDeBorrado.rellenarFormulario(socio);
	}
	
	public void rellenarFormDeModificado(int idSocio) {
		Socio socio = this.modeloSocio.select(idSocio);
		this.formDeModificado.rellenarFormulario(socio);
	}

	public void eliminarSocio(int idSocio) {
			this.modeloSocio.borrar(idSocio);
			this.formularioDeBorrado.mostrarMensaje("socio borrado");
	}

	public void cerrarFormularioDeBorrado() {
		this.formularioDeBorrado.clear();
		this.formularioDeBorrado.dispose();
	}
	//borrado de socio FIN
	
	
	public void cerrarFormularioDeModificado() {
		this.formDeModificado.clear();
		this.formDeModificado.dispose();
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

	public void modificarSocio(int parseInt, String nombre, String apellido, String direccion, String poblacion, String provincia,
			String dni) {
		Socio socio = new Socio();
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setPoblacion(poblacion);
		socio.setProvincia(provincia);
		socio.setDni(dni);
		
		this.modeloSocio.modificar(socio);
		
		
	}

}
