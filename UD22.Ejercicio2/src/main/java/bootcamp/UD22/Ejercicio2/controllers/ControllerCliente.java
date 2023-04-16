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
		this.view.btnEdit.addActionListener(this);
		this.view.btnOk.addActionListener(this);
		this.view.btnDelete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnList) {
			listar(view.tabla);
		}
		if (e.getSource() == view.btnAdd) {
			agregar();
			limpiarTabla();
			listar(view.tabla);
		}
		if (e.getSource() == view.btnEdit) {
			int fila = view.tabla.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(view, "Debes seleccionar una fila");
			} else {
				int id = Integer.parseInt((String) view.tabla.getValueAt(fila, 0).toString());
				String nombre = (String) view.tabla.getValueAt(fila, 1);
				String apellido = (String) view.tabla.getValueAt(fila, 2);
				String direccion = (String) view.tabla.getValueAt(fila, 3);
				int dni = Integer.parseInt((String) view.tabla.getValueAt(fila, 4).toString());
				String fecha = (String) view.tabla.getValueAt(fila, 5);
				view.textId.setText(String.valueOf(id));
				view.textNombre.setText(nombre);
				view.textApellido.setText(apellido);
				view.textAdress.setText(direccion);
				view.textDni.setText(String.valueOf(dni));
				view.textDate.setText(fecha);
			}
		}
		if(e.getSource()==view.btnOk) {
			actualizar();
			limpiarTabla();
			listar(view.tabla);
		}
		if(e.getSource()==view.btnDelete) {
			int fila= view.tabla.getSelectedRow();
			
			if (fila == -1) {
				JOptionPane.showMessageDialog(view, "Debes seleccionar una fila");
			} else {
				int id = Integer.parseInt((String)view.tabla.getValueAt(fila, 0).toString());
				consulta.eliminar(id);
				JOptionPane.showMessageDialog(view, "Cliente Eliminado");
				limpiar();
				limpiarTabla();
				listar(view.tabla);
			}
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
			JOptionPane.showMessageDialog(view, "No se ha podido insertar");
		}
		limpiar();
	}
	public void actualizar() {
		int id = Integer.parseInt(view.textId.getText());
		String nombre = view.textNombre.getText();
		String apellido = view.textApellido.getText();
		String direccion = view.textAdress.getText();
		int dni = Integer.parseInt(view.textDni.getText());
		String fecha = view.textDate.getText();
		cliente.setId(id);
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setDireccion(direccion);
		cliente.setDni(dni);
		cliente.setFecha(fecha);
		boolean actualizado = consulta.actualizar(cliente);
		if(actualizado) {
			JOptionPane.showMessageDialog(view, "Cliente actualizado");
		}else {
			JOptionPane.showMessageDialog(view, "No se ha podido actualizar");
		}
		limpiar();
	}

	//Metodo para limpiar los registros de la tabla
	public void limpiarTabla() {
		for(int i=0; i<view.tabla.getRowCount();i++) {
			modelo.removeRow(i);
			i-=1;
		}
	}
	//Metodo para limpiar los textFields
	public void limpiar() {
		view.textId.setText(null);
		view.textNombre.setText(null);
		view.textApellido.setText(null);
		view.textAdress.setText(null);
		view.textDni.setText(null);
		view.textDate.setText(null);
	}
}
