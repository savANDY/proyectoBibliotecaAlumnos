package vista;

import controlador.ControladorLibro;
import controlador.ControladorPrestamo;
import controlador.ControladorSocio;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import modelo.ModeloSocio;

public class Main {
	

	public static void main(String[] args) {
		
		//Crear controladores como variables locales del main
		
		ControladorLibro controladorLibro=new ControladorLibro();
		ControladorSocio controladorSocio=new ControladorSocio();
		ControladorPrestamo controladorPrestamo=new ControladorPrestamo();
		
		ModeloLibro modeloLibro=new ModeloLibro();
		ModeloSocio modeloSocio=new ModeloSocio();
		ModeloPrestamo modeloPrestamo=new ModeloPrestamo();
		
		Principal principal = new Principal();
		principal.setControladorLibro(controladorLibro);
		principal.setControladorSocio(controladorSocio);
		principal.setControladorPrestamo(controladorPrestamo);
		
		//Crear ventanas como variables locales del main	
		GestionLibro gestionLibro=new GestionLibro(principal,true);
		gestionLibro.setControladorLibro(controladorLibro);
		
		NuevoLibro nuevoLibro=new NuevoLibro(gestionLibro,true);
		nuevoLibro.setControladorLibro(controladorLibro);

		BorrarLibro borrarLibro=new BorrarLibro(gestionLibro,true);
		
		ConsultarLibro consultarLibro=new ConsultarLibro(gestionLibro,true);
		
		ListarLibros listarLibros=new ListarLibros(gestionLibro,true);
		
		controladorLibro.setBorrarLibro(borrarLibro);
		controladorLibro.setConsultarLibro(consultarLibro);
		controladorLibro.setGestionLibro(gestionLibro);
		controladorLibro.setListarLibros(listarLibros);
		controladorLibro.setModeloLibro(modeloLibro);
		
		principal.setVisible(true);

	}

}
