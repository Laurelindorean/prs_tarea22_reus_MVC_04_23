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

import bootcamp.UD22.Ejercicio3.models.Cientificos;
import bootcamp.UD22.Ejercicio3.models.ConsultasCientificos;
import bootcamp.UD22.Ejercicio3.views.CientificosView;
import bootcamp.UD22.Ejercicio3.views.PrincipalView;

/**
 * @author Palmira
 *
 */
public class ControllerCientificos implements ActionListener {
	private Cientificos cientifico = new Cientificos();
	private ConsultasCientificos consulta = new ConsultasCientificos();
	private CientificosView view = new CientificosView();
	private DefaultTableModel modelo = new DefaultTableModel();

	public ControllerCientificos(CientificosView view) {
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
				String nomApels = (String) view.tabla.getValueAt(fila, 1);
				view.textDni.setText(dni);
				view.textNomA.setText(nomApels);
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
				consulta.eliminar(dni);
				JOptionPane.showMessageDialog(view, "Cientifico Eliminado");
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
		List<Cientificos> lista = consulta.listar();
		Object[] object = new Object[2];
		for (int i = 0; i < lista.size(); i++) {
			object[0] = lista.get(i).getDni();
			object[1] = lista.get(i).getNomApels();
			modelo.addRow(object);
		}
		view.tabla.setModel(modelo);
	}

	public void agregar() {
		String dni = view.textDni.getText();
		String NomComp = view.textNomA.getText();
		cientifico.setDni(dni);
		cientifico.setNomApels(NomComp);
		boolean agregado = consulta.agregar(cientifico);
		if (agregado) {
			JOptionPane.showMessageDialog(view, "Cientifico añadido");
		} else {
			JOptionPane.showMessageDialog(view, "No se ha podido insertar");
		}
		limpiar();
	}

	public void actualizar() {
		String dni = view.textDni.getText();
		String nomApels = view.textNomA.getText();
		cientifico.setDni(dni);
		cientifico.setNomApels(nomApels);
		boolean actualizado = consulta.actualizar(cientifico);
		if (actualizado) {
			JOptionPane.showMessageDialog(view, "Cientifico actualizado");
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
		view.textNomA.setText(null);

	}

}
