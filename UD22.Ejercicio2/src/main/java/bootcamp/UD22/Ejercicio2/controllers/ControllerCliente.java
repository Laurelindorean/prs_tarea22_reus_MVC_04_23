/**
 * 
 */
package bootcamp.UD22.Ejercicio2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bootcamp.UD22.Ejercicio2.models.Cliente;
import bootcamp.UD22.Ejercicio2.models.ConsultasCliente;
import bootcamp.UD22.Ejercicio2.views.ClienteView;

/**
 * @author Palmira
 *
 */
public class ControllerCliente implements ActionListener {
	Cliente cliente = new Cliente();
	ConsultasCliente consulta = new ConsultasCliente();
	ClienteView view = new ClienteView();
	DefaultTableModel modelo = new DefaultTableModel();

	public ControllerCliente(ClienteView view) {
		this.view = view;
		this.view.btnList.addActionListener(this);
		this.view.btnAdd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnList) {
			listar(view.tabla);
		}
		if (e.getSource() == view.btnAdd) {
			agregar();
		}

	}

	public void listar(JTable tabla) {
		modelo = (DefaultTableModel) tabla.getModel();
		List<Cliente> lista = consulta.listar();
		Object[] object = new Object[6];
		for (int i = 0; i < lista.size(); i++) {
			object[0] = lista.get(i).getId();
			object[1] = lista.get(i).getNombre();
			object[2] = lista.get(i).getApellido();
			object[3] = lista.get(i).getDireccion();
			object[4] = lista.get(i).getDni();
			object[5] = lista.get(i).getFecha();
			modelo.addRow(object);
		}
		view.tabla.setModel(modelo);
	}

	public void agregar() {
		String nombre = view.textNombre.getText();
		String apellido = view.textApellido.getText();
		String direccion = view.textAdress.getText();
		int dni = Integer.parseInt(view.textDni.getText());
		String fecha = view.textDate.getText();
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setDireccion(direccion);
		cliente.setDni(dni);
		cliente.setFecha(fecha);
		boolean agregado = consulta.agregar(cliente);
		if (agregado) {
			JOptionPane.showMessageDialog(view, "Cliente añadido");
		} else {
			JOptionPane.showMessageDialog(view, "No se ha podido insertar el cliente");
		}
		limpiar();
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
