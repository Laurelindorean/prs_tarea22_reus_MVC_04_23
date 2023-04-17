/**
 * 
 */
package bootcamp.UD22.Ejercicio3.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bootcamp.UD22.Ejercicio3.models.Asignado;
import bootcamp.UD22.Ejercicio3.models.ConsultaAsignado;
import bootcamp.UD22.Ejercicio3.views.AsignadoView;
import bootcamp.UD22.Ejercicio3.views.PrincipalView;

/**
 * @author Palmira
 *
 */
public class ControllerAsignado implements ActionListener {
	private Asignado asignado = new Asignado();
	private AsignadoView view = new AsignadoView();
	private ConsultaAsignado consulta = new ConsultaAsignado();
	private DefaultTableModel modelo = new DefaultTableModel();

	public ControllerAsignado(AsignadoView view) {
		this.view = view;
		view.setVisible(true);
		this.view.btnList.addActionListener(this);
		this.view.btnAdd.addActionListener(this);
		this.view.btnEdit.addActionListener(this);
		this.view.btnOk.addActionListener(this);
		this.view.btnDelete.addActionListener(this);
		this.view.btnVolver.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnList) {
			limpiarTabla();
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
				String dni = (String) view.tabla.getValueAt(fila, 0);
				String id = (String) view.tabla.getValueAt(fila, 1);
				view.textDni.setText(dni);
				view.textProyecto.setText(id);
			}
		}
		if (e.getSource() == view.btnOk) {
			actualizar();
			limpiarTabla();
			listar(view.tabla);
		}
		if (e.getSource() == view.btnDelete) {
			int fila = view.tabla.getSelectedRow();

			if (fila == -1) {
				JOptionPane.showMessageDialog(view, "Debes seleccionar una fila");
			} else {
				String dni = (String) view.tabla.getValueAt(fila, 0);
				String id = (String) view.tabla.getValueAt(fila, 1);
				consulta.eliminar(dni, id);
				JOptionPane.showMessageDialog(view, "Cientifico y Proyecto Eliminado");
				limpiar();
				limpiarTabla();
				listar(view.tabla);
			}
		}
		if (e.getSource() == view.btnVolver) {
			PrincipalView vistaMenu = new PrincipalView();
			ControllerMenu ctrlMenu = new ControllerMenu(vistaMenu);
			view.setVisible(false);
			vistaMenu.setVisible(true);
		}

	}

	public void listar(JTable tabla) {
		modelo = (DefaultTableModel) tabla.getModel();
		List<Asignado> lista = consulta.listar();
		Object[] object = new Object[2];
		for (int i = 0; i < lista.size(); i++) {
			object[0] = lista.get(i).getCientifico();
			object[1] = lista.get(i).getProyecto();
			modelo.addRow(object);
		}
		view.tabla.setModel(modelo);
	}

	public void agregar() {
		String dni = view.textDni.getText();
		String id = view.textProyecto.getText();
		asignado.setCientifico(dni);
		asignado.setProyecto(id);
		boolean agregado = consulta.agregar(asignado);
		if (agregado) {
			JOptionPane.showMessageDialog(view, "Asignación añadida");
		} else {
			JOptionPane.showMessageDialog(view, "No se ha podido insertar");
		}
		limpiar();
	}

	public void actualizar() {
		String dni = view.textDni.getText();
		String id = view.textProyecto.getText();
		asignado.setCientifico(dni);
		asignado.setProyecto(id);
		boolean actualizado = consulta.actualizar(asignado);
		if (actualizado) {
			JOptionPane.showMessageDialog(view, "Asignación actualizada");
		} else {
			JOptionPane.showMessageDialog(view, "No se ha podido actualizar");
		}
		limpiar();
	}

	// Metodo para limpiar los registros de la tabla
	public void limpiarTabla() {
		for (int i = 0; i < view.tabla.getRowCount(); i++) {
			modelo.removeRow(i);
			i -= 1;
		}
	}

	// Metodo para limpiar los textFields
	public void limpiar() {
		view.textDni.setText(null);
		view.textProyecto.setText(null);

	}

	

}
