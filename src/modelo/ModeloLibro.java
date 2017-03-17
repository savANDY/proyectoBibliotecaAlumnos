package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloLibro extends Conectar {
	Scanner scan = new Scanner(System.in);

	public ModeloLibro() {
		super();
	}

	public ArrayList<Libro> seleccionarTodos() {

		Statement st;
		try {
			st = cn.createStatement();

			ResultSet rs = st.executeQuery("SELECT id, titulo FROM libros");

			ArrayList<Libro> libros = new ArrayList<Libro>();

			while (rs.next()) {

				Libro libro = new Libro();
				libro.setId(rs.getInt(1));
				libro.setTitulo(rs.getString(2));
				libros.add(libro);
			}

			return libros;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insertar(Libro libro) throws SQLException {
		// escribir la instruccion INSERT
		try {

			PreparedStatement pst = cn.prepareStatement("INSERT INTO LIBROS (titulo, autor, num_pag) VALUES (?,?,?)");

			System.out.println(pst);

			pst.setString(1, libro.getTitulo());
			pst.setString(2, libro.getAutor());
			pst.setInt(3, libro.getNum_pag());

			pst.execute();// ejecuta
			System.out.println("Libro insertado correctamente");
		} catch (SQLException ex) {
			throw ex;

		}
	}

	public void borrar(int id) throws Exception {
		try {
			System.out.println("\n\t\tBorrar libro por id");
			System.out.println("\t\tId: ");
			id = (Integer.parseInt(scan.nextLine()));

			PreparedStatement pst = cn.prepareStatement("DELETE FROM libros WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();// ejecuta

			if (pst.getUpdateCount() == 0) {// no a borrado nada
				System.out.println("Libro no existe");
			} else {
				System.out.println("Libro borrado correctamente");
			}

		} catch (SQLException ex) {
			throw ex;
		}
	}

	public void modificar(int id, String nueva_direccion) throws Exception {
		try {

			PreparedStatement pst = cn.prepareStatement("UPDATE socios SET direccion=? WHERE id=?");

			pst.setString(1, nueva_direccion);
			pst.setInt(2, id);

			pst.execute();// ejecuta

			System.out.println("Direccion del libro " + id + " modificado exitosisimamente");
		} catch (Exception ex) {
			throw ex;

		}

	}

	public String seleccionarId(int id_libro) throws Exception {

		PreparedStatement pst;
		String titulo = "";
		try {
			pst = cn.prepareStatement("SELECT TITULO FROM LIBROS WHERE id=?");
			pst.setInt(1, id_libro);

			ResultSet rs = pst.executeQuery();// ejecuta

			while (rs.next()) { // coge el titulo que es UNO SOLO

				titulo = rs.getString(1);
			}
			return titulo;

		} catch (Exception e) {
			throw e;

		}
	}
}
