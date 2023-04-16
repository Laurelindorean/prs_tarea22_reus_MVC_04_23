/**
 * 
 */
package bootcamp.UD22.Ejercicio2.appMain;

import bootcamp.UD22.Ejercicio2.controllers.ControllerCliente;
import bootcamp.UD22.Ejercicio2.controllers.ControllerMenu;
import bootcamp.UD22.Ejercicio2.controllers.ControllerVideos;
import bootcamp.UD22.Ejercicio2.models.Cliente;
import bootcamp.UD22.Ejercicio2.models.ConsultasCliente;
import bootcamp.UD22.Ejercicio2.views.ClienteView;
import bootcamp.UD22.Ejercicio2.views.PrincipalView;
import bootcamp.UD22.Ejercicio2.views.VideoView;

/**
 * @author Palmira
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrincipalView view = new PrincipalView();
		ControllerMenu menu = new ControllerMenu(view);

	}

}
