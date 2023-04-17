/**
 * 
 */
package bootcamp.UD22.Ejercicio3.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * @author Palmira
 *
 */
public class ConsultasProyecto {
	
	private Conexion conexion = new Conexion();
	private Connection con;
	private String table = "Proyecto";
	private PreparedStatement ps;
	private ResultSet rs;

	public List<Proyecto> listar() {
		List<Proyecto> datos = new ArrayList<>();
		String sql = "SELECT * FROM " + table;
		con = conexion.getConexion();

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Proyecto proyecto = new Proyecto();
				proyecto.setId(rs.getString(1));
				proyecto.setNombre(rs.getString(2));
				proyecto.setHoras(rs.getInt(3));
				datos.add(proyecto);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return datos;
	}

	public boolean agregar(Proyecto proyecto) {
		validar(proyecto);
		String sql = "INSERT INTO " + table + " (id, nombre, horas) VALUES (?,?,?)";

		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, proyecto.getId());
			ps.setString(2, proyecto.getNombre());
			ps.setInt(3, proyecto.getHoras());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean actualizar(Proyecto proyecto, String id) {
		String sql = "UPDATE " + table + " SET id=?, nombre=?, horas=? WHERE id=?";
		validar(proyecto);
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, proyecto.getId());
			ps.setString(2, proyecto.getNombre());
			ps.setInt(3, proyecto.getHoras());
			ps.setString(4, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void eliminar(String id) {
		String sql = "DELETE FROM " + table + " WHERE id='" + id + "'";
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	private void validar(Proyecto proyecto) {
		if (proyecto.getId().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo ID es obligatorio");
			throw new RuntimeException("El campo ID es obligatorio");
		} else if (proyecto.getNombre().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo nombre Completo es obligatorio");
			throw new RuntimeException("El campo nombre Completo es obligatorio");
		} 

	}

}
