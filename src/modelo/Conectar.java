package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class Conectar {
	protected Connection cn;

	public Conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/biblioteca";
			cn = (Connection) DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
