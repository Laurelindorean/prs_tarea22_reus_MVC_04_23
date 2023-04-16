/**
 * 
 */
package bootcamp.UD22.Ejercicio2.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bootcamp.UD22.Ejercicio2.views.ClienteView;

/**
 * @author Palmira
 *
 */
public class ConsultasCliente extends Conexion {
	private Conexion conexion = new Conexion();
	private Connection con;
	private String table = "Cliente";
	private PreparedStatement ps;
	private ResultSet rs;
	private ClienteView view;

	public List listar() {
		List<Cliente> datos = new ArrayList<>();
		String sql = "SELECT * FROM " + table;
		con = conexion.getConexion();

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Cliente client = new Cliente();
				client.setId(rs.getInt(1));
				client.setNombre(rs.getString(2));
				client.setApellido(rs.getString(3));
				client.setDireccion(rs.getString(4));
				client.setDni(rs.getInt(5));
				client.setFecha(rs.getString(6));
				datos.add(client);
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return datos;
	}

	public boolean agregar(Cliente cliente) {
		String sql = "INSERT INTO " + table + " (nombre, apellido, direccion, dni, fecha) VALUES (?,?,?,?,?)";
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getDni());
			ps.setString(5, cliente.getFecha());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
