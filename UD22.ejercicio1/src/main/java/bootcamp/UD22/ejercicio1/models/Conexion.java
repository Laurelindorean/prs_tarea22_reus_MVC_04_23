package bootcamp.UD22.ejercicio1.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Palmira
 *
 */
public class Conexion {

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://192.168.1.63:3306?useTimezone=true&serverTimezone=UTC";
	private final String USER = "remote";
	private final String PSW = "Palmira-85";
	private Connection con;
	
	public Conexion() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PSW);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int actualizar(String consulta) {
		
		try {
			Statement st = con.createStatement();
			return st.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
