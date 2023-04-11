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
	private final String BD = "UD22_Ejercicio1";
	private Connection con;
	
	public Conexion() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PSW);
			Statement st = con.createStatement();
			st.executeQuery("USE " + BD + ";");
			if(con!=null) {
				System.out.println("Conexión establecida");
			}
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConexion() {
		return con;
	}
	public void desconectar() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
