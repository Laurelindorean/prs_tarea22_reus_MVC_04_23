/**
 * 
 */
package bootcamp.UD22.Ejercicio2.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bootcamp.UD22.Ejercicio2.views.ClienteView;
import bootcamp.UD22.Ejercicio2.views.PrincipalView;
import bootcamp.UD22.Ejercicio2.views.VideoView;

/**
 * @author Palmira
 *
 */
public class ControllerMenu implements ActionListener{
	private PrincipalView view = new PrincipalView();

	public ControllerMenu(PrincipalView view) {
		this.view = view;
		view.setVisible(true);
		view.btnClientes.addActionListener(this);
		view.btnVideos.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.btnClientes) {
			view.setVisible(false);
			ClienteView view2 = new ClienteView();
			ControllerCliente ctrl = new ControllerCliente(view2);
		}
		
		if(e.getSource() == view.btnVideos) {
			view.setVisible(false);
			VideoView view2 = new VideoView();
			ControllerVideos ctrl = new ControllerVideos(view2);
			
		}
	}

}
