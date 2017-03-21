package vista;

import controlador.ControladorLibro;
import controlador.ControladorPrestamo;
import controlador.ControladorSocio;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import modelo.ModeloSocio;
import vista.libro.BorrarLibro;
import vista.libro.ConsultarLibro;
import vista.libro.GestionLibro;
import vista.libro.ListarLibros;
import vista.libro.NuevoLibro;
import vista.socio.FormularioDeBorrado;
import vista.socio.FormularioDeModificado;
import vista.socio.FormularioSocio;
import vista.socio.FormularioTodosSocios;
import vista.socio.GestionSocio;

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
		borrarLibro.setControladorLibro(controladorLibro);
		
		ConsultarLibro consultarLibro = new ConsultarLibro(gestionLibro, true);
		//consultarLibro.setControladorLibro(controladorLibro);
		
		ListarLibros listarLibros = new ListarLibros(gestionLibro, true);
		//listarLibros.setControladorLibro(controladorLibro);
		
		
		controladorLibro.setNuevoLibro(nuevoLibro);
		controladorLibro.setBorrarLibro(borrarLibro);
		controladorLibro.setConsultarLibro(consultarLibro);
		controladorLibro.setGestionLibro(gestionLibro);
		controladorLibro.setListarLibros(listarLibros);
		controladorLibro.setModeloLibro(modeloLibro);

		// SOCIO
		// Crear ventanas como variables locales del main
		

		//creacion de ventanas de la gestion de socios y asignar controladores
		GestionSocio gestionSocio = new GestionSocio(principal, true);
		gestionSocio.setControladorSocio(controladorSocio);
		
		FormularioDeBorrado formularioDeBorrado = new FormularioDeBorrado(gestionSocio, true);
		formularioDeBorrado.setControladorSocio(controladorSocio);
		
		FormularioSocio formularioSocio = new FormularioSocio(gestionSocio, true);
		formularioSocio.setControladorSocio(controladorSocio);
		
		FormularioDeModificado formularioDeModificado = new FormularioDeModificado(gestionSocio, true);
		formularioDeModificado.setControladorSocio(controladorSocio);
		
		FormularioTodosSocios formularioTodosSocios = new FormularioTodosSocios(gestionSocio, true);
		formularioTodosSocios.setControladorSocio(controladorSocio);
		
		
		//rellenar controladorSocio
		controladorSocio.setModeloSocio(modeloSocio);
		controladorSocio.setGestionSocio(gestionSocio);
		controladorSocio.setFormularioDeBorrado(formularioDeBorrado);
		controladorSocio.setFormularioSocio(formularioSocio);
		controladorSocio.setFormDeModificado(formularioDeModificado);
		controladorSocio.setFormTodosSocios(formularioTodosSocios);
		
		//abrir la ventana principal
		principal.setVisible(true);

	}

}
