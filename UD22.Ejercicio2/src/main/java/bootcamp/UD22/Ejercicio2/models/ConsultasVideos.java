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

import javax.swing.JOptionPane;



/**
 * @author Palmira
 *
 */
public class ConsultasVideos {
	private Conexion conexion = new Conexion();
	private Connection con;
	private String table = "Videos";
	private PreparedStatement ps;
	private ResultSet rs;

	
	public List listar() {
		List<Videos> datos = new ArrayList<>();
		String sql = "SELECT * FROM " + table;
		con = conexion.getConexion();

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Videos video = new Videos();
				video.setId(rs.getInt(1));
				video.setTitle(rs.getString(2));
				video.setDirector(rs.getString(3));
				video.setCli_id(rs.getInt(4));		
				datos.add(video);
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return datos;
	}
	
	public boolean agregar(Videos video) {
		String sql = "INSERT INTO " + table + " (title, director, cli_id) VALUES (?,?,?)";
		validar(video);
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, video.getTitle());
			ps.setString(2, video.getDirector());
			ps.setInt(3, video.getCli_id());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean actualizar(Videos video) {
		String sql = "UPDATE " + table + " SET title=?, director=?, cli_id=? WHERE id=?";
		validar(video);
		try {
			con=conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, video.getTitle());
			ps.setString(2, video.getDirector());
			ps.setInt(3, video.getCli_id());
			ps.setInt(4, video.getId());

			ps.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return true;
	}
	
	public void eliminar(int id) {
		String sql = "DELETE FROM " + table + " WHERE id=" + id;
		try {
			con = conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
	}
	
	private void validar(Videos video) {
		if(video.getTitle().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo titulo es obligatorio");
			throw new RuntimeException("El campo titulo es obligatorio");	
		}else if(video.getDirector().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo director es obligatorio");
			throw new RuntimeException("El campo director es obligatorio");
		}else if(video.getCli_id()<1) {
			JOptionPane.showMessageDialog(null, "El campo Id Cliente es obligatorio");
			throw new RuntimeException("El campo Id Cliente es obligatorio");
		}	
	}

}
