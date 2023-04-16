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
public class ConsultasCliente{
	private Conexion conexion = new Conexion();
	private Connection con;
	private String table = "Cliente";
	private PreparedStatement ps;
	private ResultSet rs;
	

	public List<Cliente> listar() {
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
		validar(cliente);
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
	
	public boolean actualizar(Cliente cliente) {
		String sql = "UPDATE " + table + " SET nombre=?, apellido=?, direccion=?, dni=?, fecha=? WHERE id=?";
		validar(cliente);
		try {
			con=conexion.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getDni());
			ps.setString(5, cliente.getFecha());
			ps.setInt(6, cliente.getId());	
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
	
	private void validar(Cliente cliente) {
		if(cliente.getApellido().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo apellido es obligatorio");
			throw new RuntimeException("El apellido es obligatorio");
		}else if(cliente.getNombre().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo nombre es obligatorio");
			throw new RuntimeException("El nombre es obligatorio");
		}else if(cliente.getDireccion().isBlank()) {
			JOptionPane.showMessageDialog(null, "El campo dirección es obligatorio");
			throw new RuntimeException("La dirección es obligatorio");
		}else if(cliente.getDni()>8 && cliente.getDni()<=11) {
			JOptionPane.showMessageDialog(null, "El número debe tener entre 8 y 11 caracteres");
			throw new RuntimeException("El número debe tener entre 8 y 11 caracteres");
		}else if(cliente.getFecha().isBlank()) {
			JOptionPane.showMessageDialog(null, "La fecha es obligatoria");
			throw new RuntimeException("La fecha es obligatoria");
		}
		
	}
}
