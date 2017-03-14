package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import modelo.Libro;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import modelo.ModeloSocio;
import modelo.Prestamo;
import modelo.Socio;

public class PRINCIPAL {

	final static int SOCIOS = 1;
	final static int LIBROS = 2;
	final static int PRESTAMOS = 3;
	final static int SALIR = 4;
	final static int NUEVO = 1;
	final static int BORRAR = 2;
	final static int MODIFICAR = 3;
	final static int CONSULTAR = 4;
	final static int SALIR_OPERACIONES = 5;
	final static int TODOS = 1;
	final static int POR_DNI = 2;
	final static int POR_POBLACION = 3;
	
	final static int POR_TITULO = 2;
	final static int POR_DNI_SOCIO = 3;
	final static int POR_FECHA_DEVOL = 4;
	static final int POR_NOMBRE_SOCIO = 5;
	final static int SALIR_CONSUL_PRESTAMOS = 6;
	
	final static int SALIR_CONSULTAS = 4;


	static void gestionSocios() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		ModeloSocio model_socio = new ModeloSocio();
		Socio socio = new Socio();
		int id = 0;
		int opcion;
		do {

			System.out.println("\n\n\tMENU SOCIOS" + "\n\t1.NUEVO" + "\n\t2.BORRAR" + "\n\t3.MODIFICAR"
					+ "\n\t4.CONSULTAR" + "\n\t5.SALIR");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {

			case NUEVO:

				try {
					model_socio.insertar(socio);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				break;
			case BORRAR:
				try {
					model_socio.borrar(id);

				} catch (Exception e) {

				}

				break;
			case MODIFICAR:
				try {

					model_socio.modificar();

				} catch (Exception e) {

				}
				break;
			case CONSULTAR:

				do {

					System.out.println("\n\n\tMENU CONSULTAS SOCIOS" + "\n\t1.TODOS LOS SOCIOS" + "\n\t2.POR DNI"
							+ "\n\t3.POR POBLACION" + "\n\t4.SALIR");

					opcion = Integer.parseInt(scan.nextLine());

					switch (opcion) {

					case TODOS:
						ArrayList<Socio> socios = new ArrayList<Socio>();
						try {
							socios = model_socio.seleccionarTodos();

							System.out.println("\t\tSOCIOS");

							for (Socio soc : socios) {

								System.out.println("\n\n\t SOCIO Id : " + soc.getId());
								System.out.println("\t Nombre : " + soc.getNombre());
								System.out.println("\t Apellido : " + soc.getApellido());
								System.out.println("\t Direccion : " + soc.getDireccion());
								System.out.println("\t Poblacion : " + soc.getPoblacion());
								System.out.println("\t Provincia : " + soc.getProvincia());
								System.out.println("\t DNI : " + soc.getDni());
							}
						} catch (Exception e) {
							System.out.println("\tERROR AL SELECCIONAR SOCIOS");
						}

						break;
					case POR_DNI:

						socios = new ArrayList<Socio>();
						try {

							System.out.println("\tIntroduce el DNI del socio a consultar : ");
							String dni = scan.nextLine();
							socios = model_socio.seleccionarDni(dni);

							System.out.println("\t\tSOCIOS");

							for (Socio soc : socios) {

								System.out.println("\n\n\t SOCIO Id : " + soc.getId());
								System.out.println("\t Nombre : " + soc.getNombre());
								System.out.println("\t Apellido : " + soc.getApellido());
								System.out.println("\t Direccion : " + soc.getDireccion());
								System.out.println("\t Poblacion : " + soc.getPoblacion());
								System.out.println("\t Provincia : " + soc.getProvincia());
								System.out.println("\t DNI : " + soc.getDni());
							}
						} catch (Exception e) {
							System.out.println("\tERROR AL SELECCIONAR SOCIOS"+e.getMessage());
						}

						break;

					case POR_POBLACION:

						break;
					case SALIR_CONSULTAS:
						System.out.println("\n\tSALIENDO DE LA APLICACION");
						break;

					default:
						System.out.println("\n\tOPCION INCORRECTA");
						break;
					}

				} while (opcion != SALIR_CONSULTAS);

				break;
			case SALIR_OPERACIONES:
				System.out.println("\n\tSALIENDO DE LA APLICACION");
				break;

			default:
				System.out.println("\n\tOPCION INCORRECTA");
				break;
			}

		} while (opcion != SALIR_OPERACIONES);
	}

	static void gestionLibros() {
		ModeloLibro model_libro = new ModeloLibro();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int opcion;
		int id = 0;
		do {
			// MENU PRINCIPAL
			System.out.println("\n\n\tMENU LIBROS" + "\n\t1.NUEVO" + "\n\t2.BORRAR" + "\n\t3.MODIFICAR" + "\n\t4.SALIR");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {

			case NUEVO:
				Libro libro = new Libro();
				try {
					model_libro.insertar(libro);
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
				break;
			case BORRAR:
				try {
					model_libro.borrar(id);

				} catch (Exception e) {

				}
				break;
			case MODIFICAR:

				break;
			case SALIR:
				System.out.println("\n\tSALIENDO DE LA APLICACION");
				break;

			default:
				System.out.println("\n\tOPCION INCORRECTA");
				break;
			}

		} while (opcion != SALIR_OPERACIONES);
	}

	static void gestionPrestamos() {
		ModeloPrestamo model_prestamo = new ModeloPrestamo();

		Date fecha_date;
		SimpleDateFormat formato;
		String fecha_string;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int opcion;
		do {
			// MENU PRINCIPAL
			System.out
					.println("\n\n\tMENU PRESTAMO\n" + "\n\t1.NUEVO" + "\n\t2.BORRAR" + "\n\t3.MODIFICAR" + "\n\t4.CONSULTAR"+"\n\t5.SALIR");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {

			case NUEVO:
				Prestamo prestamo = new Prestamo();

				System.out.println("\n\t\tDatos Prestamo");
				System.out.println("\t\tId_libro: ");
				prestamo.setId_libro(Integer.parseInt(scan.nextLine()));

				System.out.println("\t\tId_socio: ");
				prestamo.setId_socio(Integer.parseInt(scan.nextLine()));

				System.out.println("\t\tFecha YYYY/MM/DD: ");
				fecha_string = scan.nextLine();
				formato = new SimpleDateFormat("yyyy/MM/dd");
				try {
					// pasar de string a date
					fecha_date = formato.parse(fecha_string);
					prestamo.setFecha(fecha_date);

				} catch (Exception e1) {
					System.out.println("\tError al insertar");
				}
				System.out.println("\t\tDevuelto: ");
				prestamo.setDevuelto(Boolean.parseBoolean(scan.nextLine()));

				try {
					model_prestamo.insertar(prestamo);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				break;
			case BORRAR:
				try {
					System.out.println("\n\t\tBorrar Socio");
					System.out.println("\t\tId_libro: ");
					int id_libro = (Integer.parseInt(scan.nextLine()));
					System.out.println("\t\tId_socio: ");
					int id_socio = (Integer.parseInt(scan.nextLine()));
					System.out.println("\t\tFecha YYYY/MM/DD: ");
					fecha_string = scan.nextLine();
					formato = new SimpleDateFormat("yyyy/MM/dd");
					try {
						// pasar de string a date

						fecha_date = formato.parse(fecha_string);
						model_prestamo.borrar(id_libro, id_socio, fecha_date);

					} catch (Exception e1) {
						System.out.println("\tError al insertar");
					}

				} catch (Exception e) {

				}
				break;
			case MODIFICAR:

				break;
				
			case CONSULTAR:

				do {

					System.out.println("\n\n\n\tMENU CONSULTAS PRESTAMOS" 
					+ "\n\t1.TODOS LOS PRESTAMOS" 
							+ "\n\t2.POR DNI SOCIO"
							+ "\n\t3.POR TITULO LIBRO"
							+ "\n\t4.POR FECHA DEVOLUCION"+ "\n\t5.SALIR");

					opcion = Integer.parseInt(scan.nextLine());

					switch (opcion) {

					case TODOS:
						ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
						try {
							prestamos = model_prestamo.seleccionarTodos();

							System.out.println("\n\t\tPRESTAMOS");

							for (Prestamo pres : prestamos) {
								
								System.out.print("\n\n\t ID Socio : " + pres.getId_libro());
								System.out.print("\t  ID Libro : " + pres.getId_socio());
								System.out.print("\t Fecha Prestamo : " + pres.getFecha());
								System.out.print("\t Devuelto Si/No : " + pres.isDevuelto());
							}
						} catch (Exception e) {
							System.out.println("\tERROR AL SELECCIONAR PRESTAMOS");
						}

						break;
					case POR_TITULO:
						//Buscar los prestamos de los libros de los que pide el titulo
						//JOIN EN LA SELECT
						//   SELECT P.* FROM PRESTAMOS P,LIBROS L 
						//   WHERE P.ID_LIBRO=L.ID
						//   AND   L.TITULO=?
						
						
						
						
						break;

					case POR_DNI_SOCIO:
						//Buscar los prestamos de los socios de los que pide el DNI
						//JOIN EN LA SELECT
						//
						//   SELECT P.* FROM PRESTAMOS P,SOCIOS S 
						//   WHERE P.ID_LIBRO=S.ID
						//   AND   S.DNI=?
						
						break;
					case POR_FECHA_DEVOL:
						// libros no devueltos a la fecha que se pide
						
						prestamos = new ArrayList<Prestamo>();
						ModeloLibro  model_libro=new ModeloLibro();
						ModeloSocio  model_socio=new ModeloSocio();
						try {
							System.out.print("\n\n\t FECHA PARA VER NO DEVUELTOS AÑO/MES/DIA :");
							fecha_string=scan.nextLine();
							
							formato=new SimpleDateFormat("yyyy/MM/dd");
							
							fecha_date=formato.parse(fecha_string);
							
							prestamos = model_prestamo.seleccionarNoDevueltos(fecha_date);

							System.out.println("\n\t\tPRESTAMOS");

							for (Prestamo pres : prestamos) {
								
								System.out.print("\n\n\t ID Libro : " + pres.getId_libro());
								
								String titulo=model_libro.seleccionarId(pres.getId_libro());
								
								System.out.print("\t  Titulo Libro : " + titulo);
								
								System.out.print("\t  ID Socio : " + pres.getId_socio());
								
								String nomApellido=model_socio.seleccionarId(pres.getId_socio());
								System.out.print("\t  Nombre Socio : " + nomApellido);
								
								System.out.print("\t Fecha Prestamo : " + pres.getFecha());
								System.out.print("\t Devuelto Si/No : " + pres.isDevuelto());
							}
						} catch (Exception e) {
							System.out.println("\tERROR AL SELECCIONAR PRESTAMOS NO DEVUELTOS");
						}

						break;
					case POR_NOMBRE_SOCIO:
						// prestamos del socio del que se pide el nombre apellido
						
						prestamos = new ArrayList<Prestamo>();
						model_socio=new ModeloSocio();						
						
						
						try {
							System.out.print("\n\n\t Nombre  :");
							String nombre=scan.nextLine();
							System.out.print("\n\n\t Apellido  :");
							String apellido=scan.nextLine();
							
							
							int id_socio= model_socio.seleccionarPorNombre(nombre,apellido);
							
							prestamos=model_prestamo.seleccionarIdSocio(id_socio);
							System.out.println("\n\t\tPRESTAMOS DE "+nombre+" "+apellido);

							for (Prestamo pres : prestamos) {
								
								System.out.print("\n\n\t ID Socio : " + pres.getId_libro());
								System.out.print("\t  ID Libro : " + pres.getId_socio());
								System.out.print("\t Fecha Prestamo : " + pres.getFecha());
								System.out.print("\t Devuelto Si/No : " + pres.isDevuelto());
							}
						
						} catch	(Exception e){
							System.out.println("\tERROR AL SELECCIONAR PRESTAMOS POR SOCIO");
						}
						
					case SALIR_CONSUL_PRESTAMOS:
						System.out.println("\n\tSALIENDO DE LA APLICACION");
						break;

					default:
						System.out.println("\n\tOPCION INCORRECTA");
						break;
					}

				} while (opcion != SALIR_CONSUL_PRESTAMOS);
				
			case SALIR_OPERACIONES:
				System.out.println("\n\tSALIENDO DE LA APLICACION");
				break;

			default:
				System.out.println("\n\tOPCION INCORRECTA");
				break;
			}

		} while (opcion != SALIR_OPERACIONES);
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int opcion;
		do {
			// MENU PRINCIPAL
			System.out.println("\n\tMENU BD BIBLIOTECA" + "\n\t1.GESTION SOCIOS " + "\n\t2.GESTION LIBROS"
					+ "\n\t3.GESTION PRESTAMOS" + "\n\t4.SALIR");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {

			case SOCIOS:
				gestionSocios();
				break;
			case LIBROS:
				gestionLibros();
				break;
			case PRESTAMOS:
				gestionPrestamos();
				break;
			case SALIR:
				System.out.println("\n\tSALIENDO DE LA APLICACION");
				break;

			default:
				System.out.println("\n\tOPCION INCORRECTA");
				break;
			}

		} while (opcion != 4);

	}

}
