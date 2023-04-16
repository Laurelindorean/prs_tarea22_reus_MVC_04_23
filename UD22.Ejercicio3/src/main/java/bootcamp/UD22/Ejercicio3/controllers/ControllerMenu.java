/**
 * 
 */
package bootcamp.UD22.Ejercicio3.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bootcamp.UD22.Ejercicio3.views.AsignadoView;
import bootcamp.UD22.Ejercicio3.views.CientificosView;
import bootcamp.UD22.Ejercicio3.views.PrincipalView;
import bootcamp.UD22.Ejercicio3.views.ProyectoView;


/**
 * @author Palmira
 *
 */
public class ControllerMenu implements ActionListener{
	private PrincipalView view = new PrincipalView();

	public ControllerMenu(PrincipalView view) {
		this.view = view;
		view.setVisible(true);
		view.btnCientificos.addActionListener(this);
		view.btnProyecto.addActionListener(this);
		view.btnAsignado.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.btnCientificos) {
			view.setVisible(false);
			CientificosView vista = new CientificosView();
			ControllerCientificos ctrl = new ControllerCientificos(vista);
		}
		
		if(e.getSource() == view.btnProyecto) {
			view.setVisible(false);
			ProyectoView vista = new ProyectoView();
			ControllerProyecto ctrl = new ControllerProyecto(vista);
			
		}
		if(e.getSource()==view.btnAsignado) {
			view.setVisible(false);
			AsignadoView vista = new AsignadoView();
			ControllerAsignado ctrl = new ControllerAsignado(vista);
		}
	}
}
