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
public class ConsultaAsignado {
	private Conexion conexion = new Conexion();
	private Connection con;
	private String table = "asignado_a";
	private PreparedStatement ps;
	private ResultSet rs;

	public List<Asignado> listar() {
		List<Asignado> datos = new ArrayList<>();
		String sql = "SELECT * FROM " + table;
		con = conexion.getConexion();

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Asignado asignado = new Asignado();
				asignado.setCientifico(rs.getString(1));
				asignado.setProyecto(rs.getString(2));
				datos.add(asignado);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return datos;
	}

	public boolean agregar(Asignado asignado) {
		validar(asignado);
		String sql = "INSERT INTO " + table + " (FK_id_cientifico, FK_id_proyecto) VALUES (?,?)";

		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, asignado.getCientifico());
			ps.setString(2, asignado.getProyecto());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean actualizar(Asignado asignado) {
		String sql = "UPDATE " + table + " SET FK_id_cientifico=?, FK_id_proyecto=? WHERE FK_id_cientifico=? OR FK_id_proyecto=?";
		validar(asignado);
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, asignado.getCientifico());
			ps.setString(2, asignado.getProyecto());
			ps.setString(3, asignado.getCientifico());
			ps.setString(4,  asignado.getProyecto());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void eliminar(String dni) {
		String sql = "DELETE FROM " + table + " WHERE FK_id_cientifico='" + dni +"'";
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	private void validar(Asignado asignado) {
		if (asignado.getCientifico().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo DNI Cientifico es obligatorio");
			throw new RuntimeException("El campo DNI es obligatorio");
		} else if (asignado.getProyecto().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo ID proyecto es obligatorio");
			throw new RuntimeException("El campo nombre Completo es obligatorio");
		} 

	}
}
