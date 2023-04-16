/**
 * 
 */
package bootcamp.UD22.Ejercicio3.mainApp;

import bootcamp.UD22.Ejercicio3.controllers.ControllerMenu;
import bootcamp.UD22.Ejercicio3.views.PrincipalView;

/**
 * @author Palmira
 *
 */
public class MainApp {


	public static void main(String[] args) {
		PrincipalView view = new PrincipalView();
		ControllerMenu menu = new ControllerMenu(view);

	}

}
