package vista;

import controlador.ControladorLibro;
import controlador.ControladorPrestamo;
import controlador.ControladorSocio;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import modelo.ModeloSocio;

public class Main {

	public static void main(String[] args) {

		// Crear controladores como variables locales del main

		ControladorLibro controladorLibro = new ControladorLibro();
		ControladorSocio controladorSocio = new ControladorSocio();
		ControladorPrestamo controladorPrestamo = new ControladorPrestamo();

		ModeloLibro modeloLibro = new ModeloLibro();
		ModeloSocio modeloSocio = new ModeloSocio();
		ModeloPrestamo modeloPrestamo = new ModeloPrestamo();

		Principal principal = new Principal();
		principal.setControladorLibro(controladorLibro);
		principal.setControladorSocio(controladorSocio);
		principal.setControladorPrestamo(controladorPrestamo);

		// LIBRO
		// Crear ventanas como variables locales del main
		GestionLibro gestionLibro = new GestionLibro(principal, true);
		gestionLibro.setControladorLibro(controladorLibro);

		NuevoLibro nuevoLibro = new NuevoLibro(gestionLibro, true);
		nuevoLibro.setControladorLibro(controladorLibro);

		BorrarLibro borrarLibro = new BorrarLibro(gestionLibro, true);

		ConsultarLibro consultarLibro = new ConsultarLibro(gestionLibro, true);

		ListarLibros listarLibros = new ListarLibros(gestionLibro, true);

		controladorLibro.setNuevoLibro(nuevoLibro);
		controladorLibro.setBorrarLibro(borrarLibro);
		controladorLibro.setConsultarLibro(consultarLibro);
		controladorLibro.setGestionLibro(gestionLibro);
		controladorLibro.setListarLibros(listarLibros);
		controladorLibro.setModeloLibro(modeloLibro);

		// SOCIO
		// Crear ventanas como variables locales del main
		
		GestionSocio gestionSocio = new GestionSocio(principal, true);
		gestionSocio.setControladorSocio(controladorSocio);

		NuevoSocio nuevoSocio = new NuevoSocio(gestionSocio, true);
		nuevoSocio.setControladorSocio(controladorSocio);

		BorrarSocio borrarSocio = new BorrarSocio(gestionSocio, true);

		ConsultarSocio consultarSocio = new ConsultarSocio(gestionSocio, true);

		ListarSocios listarSocios = new ListarSocios(gestionSocio, true);

		controladorSocio.setNuevoSocio(nuevoSocio);
		controladorSocio.setBorrarSocio(borrarSocio);
		controladorSocio.setConsultarSocio(consultarSocio);
		controladorSocio.setGestionSocio(gestionSocio);
		controladorSocio.setListarSocios(listarSocios);
		controladorSocio.setModeloSocio(modeloSocio);

		principal.setVisible(true);

	}

}
