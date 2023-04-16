/**
 * 
 */
package bootcamp.UD22.Ejercicio2.appMain;

import bootcamp.UD22.Ejercicio2.controllers.ControllerCliente;
import bootcamp.UD22.Ejercicio2.models.Cliente;
import bootcamp.UD22.Ejercicio2.models.ConsultasCliente;
import bootcamp.UD22.Ejercicio2.views.ClienteView;

/**
 * @author Palmira
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClienteView view = new ClienteView();
		ControllerCliente ctrl = new ControllerCliente(view);
		view.setVisible(true);
		

	}

}
