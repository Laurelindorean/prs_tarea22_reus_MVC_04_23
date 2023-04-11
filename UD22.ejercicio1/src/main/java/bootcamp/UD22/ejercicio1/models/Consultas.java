/**
 * 
 */
package bootcamp.UD22.ejercicio1.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Palmira
 *
 */
public class Consultas extends Conexion {

	public boolean registro(Cliente cliente) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO Cliente (nombre, apellido, direccion, dni, fecha) VALUES(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getDni());
			ps.setString(5, cliente.getFecha());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			desconectar();
		}
	}
	
	public boolean modificar(Cliente cliente) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "UPDATE Cliente SET nombre=?, apellido=?, direccion=?, dni=?, fecha=? WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getDni());
			ps.setString(5, cliente.getFecha());
			ps.setInt(6, cliente.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			desconectar();
		}
	}
	
	public boolean eliminar(Cliente cliente) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "DELETE FROM Cliente WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			desconectar();
		}
	}
	
	public boolean buscar(Cliente cliente) {
		PreparedStatement ps = null;
		ResultSet rs= null;
		Connection con = getConexion();
		String sql = "SELECT * FROM Cliente WHERE nombre=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			rs = ps.executeQuery();
			if(rs.next()) {
				cliente.setId(Integer.parseInt(rs.getString("id")));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setDni(Integer.parseInt(rs.getString("dni")));
				cliente.setFecha(rs.getString("fecha"));
				
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			desconectar();
		}
	}
}