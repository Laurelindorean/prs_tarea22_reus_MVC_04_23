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


import bootcamp.UD22.Ejercicio3.models.ConsultasProyecto;
import bootcamp.UD22.Ejercicio3.models.Proyecto;
import bootcamp.UD22.Ejercicio3.views.PrincipalView;
import bootcamp.UD22.Ejercicio3.views.ProyectoView;

/**
 * @author Palmira
 *
 */
public class ControllerProyecto implements ActionListener{
	private Proyecto proyecto = new Proyecto();
	private ProyectoView view = new ProyectoView();
	private ConsultasProyecto consulta = new ConsultasProyecto();
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public ControllerProyecto(ProyectoView view) {
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
				String id = (String) view.tabla.getValueAt(fila, 0);
				String nombre = (String) view.tabla.getValueAt(fila, 1);
				int horas = (int) view.tabla.getValueAt(fila, 2);
				view.textId.setText(id);
				view.textNombre.setText(nombre);
				view.textHoras.setText(String.valueOf(horas));
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
				String id = (String) view.tabla.getValueAt(fila, 0);
				consulta.eliminar(id);
				JOptionPane.showMessageDialog(view, "Proyecto Eliminado");
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
		List<Proyecto> lista = consulta.listar();
		Object[] object = new Object[3];
		for (int i = 0; i < lista.size(); i++) {
			object[0] = lista.get(i).getId();
			object[1] = lista.get(i).getNombre();
			object[2] = lista.get(i).getHoras();
			modelo.addRow(object);
		}
		view.tabla.setModel(modelo);
	}

	public void agregar() {
		String id = view.textId.getText();
		String nombre = view.textNombre.getText();
		int horas = Integer.parseInt(view.textHoras.getText());
		proyecto.setId(id);
		proyecto.setNombre(nombre);
		proyecto.setHoras(horas);
		boolean agregado = consulta.agregar(proyecto);
		if (agregado) {
			JOptionPane.showMessageDialog(view, "Proyecto añadido");
		} else {
			JOptionPane.showMessageDialog(view, "No se ha podido insertar");
		}
		limpiar();
	}

	public void actualizar() {
		String id = view.textId.getText();
		String nombre = view.textNombre.getText();
		int horas = Integer.parseInt(view.textHoras.getText());
		proyecto.setId(id);
		proyecto.setNombre(nombre);
		proyecto.setHoras(horas);
		boolean actualizado = consulta.actualizar(proyecto);
		if (actualizado) {
			JOptionPane.showMessageDialog(view, "Proyecto actualizado");
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
		view.textId.setText(null);
		view.textNombre.setText(null);
		view.textHoras.setText(null);

	}
		
	
	

}
