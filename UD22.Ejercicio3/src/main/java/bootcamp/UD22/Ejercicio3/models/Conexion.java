/**
 * 
 */
package bootcamp.UD22.Ejercicio3.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Palmira
 *
 */
public class Conexion {

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://192.168.1.63:3306?useTimezone=true&serverTimezone=UTC";
	private final String USER = "remote";
	private final String PSW = "Palmira-85";
	private final String DB = "UD22_Ejercicio3";
	private Connection con;

	public Connection getConexion() {

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(this.URL, this.USER, this.PSW);
			String queryDB = "USE " + DB + ";";
			Statement st = con.createStatement();
			st.executeUpdate(queryDB);
			if (con != null) {
				System.out.println("Conexión establecida");
				return con;
			} else {
				System.out.println("Error de conexión");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

	public void desconectar() {
		try {
			con.close();
			System.out.println("Conexión cerrada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
