/**
 * 
 */
package bootcamp.UD22.ejercicio1.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import bootcamp.UD22.ejercicio1.models.Cliente;
import bootcamp.UD22.ejercicio1.models.Consultas;
import bootcamp.UD22.ejercicio1.models.Validacion;
import bootcamp.UD22.ejercicio1.views.ClienteView;

/**
 * @author Palmira
 *
 */
public class ControllerCliente implements ActionListener {
	private Cliente cliente;
	private Consultas consulta;
	private ClienteView view;
	private Validacion validar;

	public ControllerCliente(Cliente cliente, Consultas consulta, ClienteView view) {
		this.cliente = cliente;
		this.consulta = consulta;
		this.view = view;
		this.view.btnAdd.addActionListener(this);
		this.view.btnBuscar.addActionListener(this);
		this.view.btnClean.addActionListener(this);
		this.view.btnDelete.addActionListener(this);
		this.view.btnUpdate.addActionListener(this);
	}

	public void iniciar() {
		view.setTitle("Gestión Clientes");
		view.textId.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnAdd) {
			if (!"".equals(view.textDni.getText())) {
				try {
					cliente.setNombre(view.textNombre.getText());
					cliente.setApellido(view.textApellido.getText());
					cliente.setDireccion(view.textAdress.getText());
					cliente.setDni(Integer.parseInt(view.textDni.getText()));
					cliente.setFecha(view.textDate.getText());
					if (consulta.registro(cliente)) {
						JOptionPane.showMessageDialog(null, "Registro Añadido");
						limpiar();
					} else {
						JOptionPane.showMessageDialog(null, "Error al Guardar");
						limpiar();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(view, "Introduzca un formato válido");
				} catch (InputMismatchException ex) {
					JOptionPane.showMessageDialog(view, "Introduzca un formato válido");
				}

			} else {
				JOptionPane.showMessageDialog(view, "Debes introducir todos los registros");
			}

		}
		if (e.getSource() == view.btnUpdate) {
			if (!"".equals(view.textDni.getText())) {
				try {
					cliente.setId(Integer.parseInt(view.textId.getText()));
					cliente.setNombre(view.textNombre.getText());
					cliente.setApellido(view.textApellido.getText());
					cliente.setDireccion(view.textAdress.getText());
					cliente.setDni(Integer.parseInt(view.textDni.getText()));
					cliente.setFecha(view.textDate.getText());

					if (consulta.modificar(cliente)) {
						JOptionPane.showMessageDialog(null, "Registro Modificado");
						limpiar();
					} else {
						JOptionPane.showMessageDialog(null, "Error al Modificar");
						limpiar();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(view, "Introduzca un formato válido");
				} catch (InputMismatchException ex) {
					JOptionPane.showMessageDialog(view, "Introduzca un formato válido");
				}
			}
		}
		if (e.getSource() == view.btnDelete) {
			cliente.setId(Integer.parseInt(view.textId.getText()));

			if (consulta.eliminar(cliente)) {
				JOptionPane.showMessageDialog(null, "Registro Eliminado");
				limpiar();
			} else {
				JOptionPane.showMessageDialog(null, "Error al Eliminar");
				limpiar();
			}
		}
		if (e.getSource() == view.btnBuscar) {
			cliente.setNombre(view.textNombre.getText());
			if (consulta.buscar(cliente)) {
				view.textId.setText(String.valueOf(cliente.getId()));
				view.textNombre.setText(cliente.getNombre());
				view.textApellido.setText(cliente.getApellido());
				view.textAdress.setText(cliente.getDireccion());
				view.textDni.setText(String.valueOf(cliente.getDni()));
				view.textDate.setText(cliente.getFecha());
				view.textId.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "No se encontró registro");
				limpiar();
			}
		}
		if (e.getSource() == view.btnClean) {
			limpiar();
		}
	}

	public void limpiar() {
		view.textId.setText(null);
		view.textNombre.setText(null);
		view.textApellido.setText(null);
		view.textAdress.setText(null);
		view.textDni.setText(null);
		view.textDate.setText(null);
	}
}
