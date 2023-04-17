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
public class ConsultasCientificos {

	private Conexion conexion = new Conexion();
	private Connection con;
	private String table = "Cientificos";
	private PreparedStatement ps;
	private ResultSet rs;

	public List<Cientificos> listar() {
		List<Cientificos> datos = new ArrayList<>();
		String sql = "SELECT * FROM " + table;
		con = conexion.getConexion();

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Cientificos cientifico = new Cientificos();
				cientifico.setDni(rs.getString(1));
				cientifico.setNomApels(rs.getString(2));
				datos.add(cientifico);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return datos;
	}

	public boolean agregar(Cientificos cientifico) {
		validar(cientifico);
		String sql = "INSERT INTO " + table + " (dni, nomApels) VALUES (?,?)";

		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, cientifico.getDni());
			ps.setString(2, cientifico.getNomApels());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean actualizar(Cientificos cientifico) {
		String sql = "UPDATE " + table + " SET dni=?, nomApels=? WHERE dni=?";
		validar(cientifico);
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, cientifico.getDni());
			ps.setString(2, cientifico.getNomApels());
			ps.setString(3, cientifico.getDni());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void eliminar(String dni) {
		String sql = "DELETE FROM " + table + " WHERE dni='" + dni + "'";
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	private void validar(Cientificos cientifico) {
		if (cientifico.getDni().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo DNI es obligatorio");
			throw new RuntimeException("El campo DNI es obligatorio");
		} else if (cientifico.getNomApels().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo nombre Completo es obligatorio");
			throw new RuntimeException("El campo nombre Completo es obligatorio");
		} 

	}
}
