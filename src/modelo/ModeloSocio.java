package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloSocio extends Conectar {

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

	public void insertar(Socio socio) throws Exception {

		PreparedStatement pst;
		try {
			pst = cn.prepareStatement("INSERT INTO SOCIOS(nombre,apellido,direccion,"
					+ "poblacion,provincia,dni) VALUES (?,?,?,?,?,?)");
			
			pst.setString(1, socio.getNombre());
			pst.setString(2, socio.getApellido());
			pst.setString(3, socio.getDireccion());
			pst.setString(4, socio.getPoblacion());
			pst.setString(5, socio.getProvincia());
			pst.setString(6, socio.getDni());

			System.out.println(pst);
			pst.execute();
			System.out.println("Alumno insertado correctamente");
		} catch (Exception e) {
			throw e;
		}

	}

	public void borrar(int id) {

		try {
			PreparedStatement pst = cn.prepareStatement("DELETE FROM socios WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();// ejecuta
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int modificar(Socio socio) {
		int lineascambiadas;
		try {
			Statement st = super.cn.createStatement();
			lineascambiadas = st.executeUpdate("UPDATE socios " + "SET nombre='" + socio.getNombre() + "'"
					+ ",apellido='" + socio.getApellido() + "'" + ",direccion='" + socio.getDireccion() + "'"
					+ ",poblacion='" + socio.getPoblacion() + "'" + ",provincia='" + socio.getProvincia() + "'"
					+ ",dni='" + socio.getDni() + "'" + " WHERE id=" + socio.getId());
			return lineascambiadas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

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

	public Socio select(int idSocio) {
		PreparedStatement ps;
		Socio socio;
		try {
			ps = cn.prepareStatement("select * from socios where id = ?");
			ps.setInt(1, idSocio);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				socio = new Socio();
				socio.setId(rs.getInt("id"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				socio.setDni(rs.getString("dni"));
				return socio;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
