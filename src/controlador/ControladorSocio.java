package controlador;

import modelo.Socio;
import modelo.ModeloSocio;
import vista.FormularioSocio;
import vista.Principal;
import vista.GestionSocio;

public class ControladorSocio {
	
	private ModeloSocio modeloSocio;
	private GestionSocio gestionSocio;
	private Principal principal;
	private FormularioSocio formularioSocio;

	public ControladorSocio() {
		modeloSocio = new ModeloSocio();
		this.principal = new Principal();
		this.gestionSocio = new GestionSocio(principal, true);
		this.formularioSocio = new FormularioSocio(gestionSocio, true);
	}
	public void insertarSocio(String nombre, String apellido, String direccion, String poblacion, String provincia,
			String dni) {

		// TODO para Borja Porque crear socio aqui y no en Vista
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
}
