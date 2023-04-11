/**
 * 
 */
package bootcamp.UD22.ejercicio1.appMain;

import bootcamp.UD22.ejercicio1.controllers.ControllerCliente;
import bootcamp.UD22.ejercicio1.models.Cliente;
import bootcamp.UD22.ejercicio1.models.Consultas;
import bootcamp.UD22.ejercicio1.views.ClienteView;

/**
 * @author Palmira
 *
 */
public class MainApp {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		Consultas consulta = new Consultas();
		ClienteView view = new ClienteView();
		ControllerCliente ctrl = new ControllerCliente(cliente, consulta, view);
		ctrl.iniciar();
		view.setVisible(true);
		}
}
