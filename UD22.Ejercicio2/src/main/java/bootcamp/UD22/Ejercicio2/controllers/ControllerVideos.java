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
import bootcamp.UD22.Ejercicio2.models.ConsultasVideos;
import bootcamp.UD22.Ejercicio2.models.Videos;
import bootcamp.UD22.Ejercicio2.views.PrincipalView;
import bootcamp.UD22.Ejercicio2.views.VideoView;

/**
 * @author Palmira
 *
 */
public class ControllerVideos implements ActionListener {
	private DefaultTableModel modelo = new DefaultTableModel();
	Videos video = new Videos();
	VideoView view = new VideoView();
	ConsultasVideos consulta = new ConsultasVideos();

	public ControllerVideos(VideoView view) {
		this.view = view;
		view.setVisible(true);
		view.btnAdd.addActionListener(this);
		view.btnDelete.addActionListener(this);
		view.btnEdit.addActionListener(this);
		view.btnList.addActionListener(this);
		view.btnOk.addActionListener(this);
		this.view.btnVolver.addActionListener(this);
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
				String titulo = (String) view.tabla.getValueAt(fila, 1);
				String director = (String) view.tabla.getValueAt(fila, 2);
				int cliente_id = Integer.parseInt((String) view.tabla.getValueAt(fila, 3).toString());
				view.textId.setText(String.valueOf(id));
				view.textTitle.setText(titulo);
				view.textDirector.setText(director);
				view.textidCliente.setText(String.valueOf(cliente_id));
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
				int id = Integer.parseInt((String) view.tabla.getValueAt(fila, 0).toString());
				consulta.eliminar(id);
				JOptionPane.showMessageDialog(view, "Video Eliminado");
				limpiar();
				limpiarTabla();
				listar(view.tabla);
			}
		}
		if(e.getSource()==view.btnVolver) {
			PrincipalView vistaMenu = new PrincipalView();
			ControllerMenu ctrlMenu = new ControllerMenu(vistaMenu);
			view.setVisible(false);
			vistaMenu.setVisible(true);
		}

	}

	public void listar(JTable tabla) {
		modelo = (DefaultTableModel) tabla.getModel();
		List<Videos> lista = consulta.listar();
		Object[] object = new Object[4];
		for (int i = 0; i < lista.size(); i++) {
			object[0] = lista.get(i).getId();
			object[1] = lista.get(i).getTitle();
			object[2] = lista.get(i).getDirector();
			object[3] = lista.get(i).getCli_id();
			modelo.addRow(object);
		}
		view.tabla.setModel(modelo);
	}

	public void agregar() {
		String titulo = view.textTitle.getText();
		String director = view.textDirector.getText();
		int id_cliente = Integer.parseInt(view.textidCliente.getText());
		video.setTitle(titulo);
		video.setDirector(director);
		video.setCli_id(id_cliente);

		boolean agregado = consulta.agregar(video);
		if (agregado) {
			JOptionPane.showMessageDialog(view, "Video añadido");
		} else {
			JOptionPane.showMessageDialog(view, "No se ha podido insertar");
		}
		limpiar();
	}

	public void actualizar() {
		int id = Integer.parseInt(view.textId.getText());
		String titulo = view.textTitle.getText();
		String director = view.textDirector.getText();
		int id_cliente = Integer.parseInt(view.textidCliente.getText());
		video.setId(id);
		video.setTitle(titulo);
		video.setDirector(director);
		video.setCli_id(id_cliente);

		boolean actualizado = consulta.actualizar(video);
		if (actualizado) {
			JOptionPane.showMessageDialog(view, "Video actualizado");
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
		view.textTitle.setText(null);
		view.textDirector.setText(null);
		view.textidCliente.setText(null);
	}
}
