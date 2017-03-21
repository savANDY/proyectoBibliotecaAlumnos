package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloSocio extends Conectar {
	Scanner scan = new Scanner(System.in);

	public ModeloSocio() {
		super();
	}

	public ArrayList<Socio> seleccionarTodos() {

		Statement st;
		try {
			st = cn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM SOCIOS ");

			// pasar de ResultSet a ArrayList

			ArrayList<Socio> socios = new ArrayList<Socio>();

			while (rs.next()) {

				Socio socio = new Socio();
				socio.setId(rs.getInt(1));
				socio.setNombre(rs.getString(2));
				socio.setApellido(rs.getString(3));
				socio.setDireccion(rs.getString(4));
				socio.setPoblacion(rs.getString(5));
				socio.setProvincia(rs.getString(6));
				socio.setDni(rs.getString(7));
				socios.add(socio);
			}
			return socios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void insertar(Socio socio) {

		PreparedStatement pst;
		try {
			pst = cn.prepareStatement("INSERT INTO SOCIOS VALUES (?,?,?,?,?,?)");
			pst.setString(1, socio.getNombre());
			pst.setString(2, socio.getApellido());
			pst.setString(3, socio.getDireccion());
			pst.setString(4, socio.getPoblacion());
			pst.setString(5, socio.getProvincia());
			pst.setString(6, socio.getDni());

			pst.execute();
			System.out.println("Alumno insertado correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void borrar(int id) throws Exception {
		try {
			System.out.println("\n\t\tBorrar Socio por id");
			System.out.println("\t\tId: ");
			id = (Integer.parseInt(scan.nextLine()));

			PreparedStatement pst = cn.prepareStatement("DELETE FROM socios WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();// ejecuta

			if (pst.getUpdateCount() == 0) {// no a borrado nada
				System.out.println("Socio no existe");
			} else {
				System.out.println("Socio borrado correctamente");
			}

		} catch (SQLException ex) {
			throw ex;
		}
	}

	public void modificar() throws Exception {
		try {
			System.out.println("\n\t\tDatos Socio a modificar");
			System.out.println("\t\tId: ");
			int id = Integer.parseInt(scan.nextLine());
			System.out.println("\t\tNueva direccion: ");
			String nueva_direccion = (scan.nextLine());

			PreparedStatement pst = cn.prepareStatement("UPDATE socios SET direccion=? WHERE id=?");

			pst.setString(1, nueva_direccion);
			pst.setInt(2, id);

			pst.execute();// ejecuta

			System.out.println("Direccion del socio " + id + " modificado exitosisimamente");
		} catch (Exception ex) {
			throw ex;

		}
	}

	public ArrayList<Socio> seleccionarDni(String dni) throws Exception {

		PreparedStatement pst;
		try {
			pst = cn.prepareStatement("SELECT * FROM SOCIOS WHERE DNI=?");

			pst.setString(1, dni);

			System.out.println(pst);

			ResultSet rs = pst.executeQuery();

			ArrayList<Socio> socios = new ArrayList<Socio>();

			// Solo hay 1 registro para rescatar

			rs.next();
			Socio socio = new Socio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7));

			socios.add(socio);
			return socios;

		} catch (Exception e) {
			throw e;
		}
	}

	public String seleccionarId(int id) throws Exception {
		try {

			PreparedStatement pst = cn.prepareStatement("SELECT NOMBRE,APELLIDO FROM socios WHERE id = ?");
			pst.setInt(1, id);

			// System.out.println(pst);

			ResultSet rs = pst.executeQuery();// ejecuta
			String nomApellido = "";

			while (rs.next()) {
				nomApellido = rs.getString(1) + " " + rs.getString(2);
			}

			return nomApellido;

		} catch (Exception ex) {
			throw ex;
		}
	}

	public int seleccionarPorNombre(String nombre, String apellido) throws Exception {

		try {

			PreparedStatement pst = cn.prepareStatement("SELECT ID from socios WHERE nombre = ? and apellido=?");

			pst.setString(1, nombre);
			pst.setString(2, apellido);

			// System.out.println(pst);

			ResultSet rs = pst.executeQuery();// ejecuta
			int id = 0;

			while (rs.next()) {
				id = rs.getInt(1);
			}
			return id;

		} catch (Exception ex) {
			throw ex;
		}

	}

}
