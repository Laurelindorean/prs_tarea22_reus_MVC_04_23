/**
 * 
 */
package bootcamp.UD22.ejercicio1.models;

import javax.swing.JOptionPane;

/**
 * @author Palmira
 *
 */
public class Validacion {
	private Cliente cliente;

	public boolean validarDni(int dni) {
		if (dni > 5 && dni <= 11) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarNull(Cliente cliente) {
		if (cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty() || cliente.getDireccion().isEmpty()
				|| cliente.getFecha().isEmpty()) {
			return false;

		} 
		return true;
	}
	public boolean validarString(Cliente cliente) {
		if (cliente.getNombre() instanceof String && cliente.getApellido() instanceof String
				&& cliente.getDireccion() instanceof String && cliente.getFecha() instanceof String) {
			return true;
		}
		return false;
	}
}
