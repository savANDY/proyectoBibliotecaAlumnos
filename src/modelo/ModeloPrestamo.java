package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;

public class ModeloPrestamo extends Conectar {
	Scanner scan = new Scanner(System.in);

	public ModeloPrestamo() {
		super();
	}

	public void insertar(Prestamo prestamo) throws SQLException {
		PreparedStatement pst = cn.prepareStatement("INSERT INTO PRESTAMOS VALUES (?,?,?,?)");

		pst.setInt(1, prestamo.getId_libro());
		pst.setInt(2, prestamo.getId_socio());
		Date sqlDate = new Date(prestamo.getFecha().getTime());
		pst.setDate(3, sqlDate);
		pst.setBoolean(4, prestamo.isDevuelto());
		pst.execute();// ejecuta
		System.out.println("Prestamo insertado correctamente");
	}

	public void borrar(int id_libro,int id_socio,java.util.Date fecha) throws Exception {
		try {
			
			PreparedStatement pst = cn.prepareStatement("DELETE FROM prestamos "
					+ "WHERE id_libro = ? AND id_socio= ? AND fecha= ? ");
			pst.setInt(1, id_libro);
			pst.setInt(2, id_socio);
			
			Date  sqlDate=new Date(fecha.getTime());
			pst.setDate(3, sqlDate);
			pst.execute();// ejecuta

			System.out.println("Prestamo borrado correctamente");
			

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

			System.out.println("Direccion del socio " + id + " modificado exitosamente");
		} catch (Exception ex) {
			throw ex;

		}

	}

	public ArrayList<Prestamo> seleccionarTodos() throws Exception {
		
		Statement st = cn.createStatement();
	
		ResultSet rs = st.executeQuery("SELECT * FROM PRESTAMOS ");
		
		//pasar de ResultSet a ArrayList
		
		ArrayList<Prestamo> prestamos=new ArrayList<Prestamo>();
		
		while (rs.next()){
			
			Prestamo prestamo=new Prestamo();
			prestamo.setId_libro(rs.getInt(1));
			prestamo.setId_socio(rs.getInt(2));
			prestamo.setFecha(rs.getDate(3));
			prestamo.setDevuelto(rs.getBoolean(4));

			prestamos.add(prestamo);
		}
		return prestamos;
	
	}

	public ArrayList<Prestamo> seleccionarNoDevueltos(java.util.Date fecha_util) throws Exception {
		
		PreparedStatement pst;
		try {
			pst = cn.prepareStatement("SELECT * FROM PRESTAMOS WHERE FECHA<=? "
					+ " AND DEVUELTO=FALSE ");
			
			Date fecha_sql=new Date(fecha_util.getTime());
			
			pst.setDate(1,fecha_sql);
			
			//System.out.println(pst);
			
			ResultSet rs = pst.executeQuery();
			
			//pasar de ResultSet a ArrayList
			
			ArrayList<Prestamo> prestamos=new ArrayList<Prestamo>();
			
			while (rs.next()){
				
				Prestamo prestamo=new Prestamo();
				prestamo.setId_libro(rs.getInt(1));
				prestamo.setId_socio(rs.getInt(2));
				prestamo.setFecha(rs.getDate(3));
				prestamo.setDevuelto(rs.getBoolean(4));

				prestamos.add(prestamo);
			}
			
			return prestamos;
			
		} catch (Exception e) {
			throw e;
		}		
		
		
	}

	public ArrayList<Prestamo> seleccionarIdSocio(int id_socio) throws Exception {

		PreparedStatement pst;
		try {
			pst = cn.prepareStatement("SELECT * FROM PRESTAMOS WHERE id_socio=?");
			
			pst.setInt(1,id_socio);
			
			//System.out.println(pst);
			
			ResultSet rs = pst.executeQuery();
			
			//pasar de ResultSet a ArrayList
			
			ArrayList<Prestamo> prestamos=new ArrayList<Prestamo>();
			
			while (rs.next()){
				
				Prestamo prestamo=new Prestamo();
				prestamo.setId_libro(rs.getInt(1));
				prestamo.setId_socio(rs.getInt(2));
				prestamo.setFecha(rs.getDate(3));
				prestamo.setDevuelto(rs.getBoolean(4));

				prestamos.add(prestamo);
			}
			
			return prestamos;
			
		} catch (Exception e) {
			throw e;
		}		
	}
}
