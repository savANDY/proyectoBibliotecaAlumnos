package controlador;

import modelo.Socio;

import java.util.ArrayList;

import modelo.ModeloSocio;
import vista.FormularioDeBorrado;
import vista.FormularioSocio;
import vista.Principal;
import vista.GestionSocio;

public class ControladorSocio {

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
}
