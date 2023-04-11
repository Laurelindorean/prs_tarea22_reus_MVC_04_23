/**
 * 
 */
package bootcamp.UD22.ejercicio1.appMain;

import java.awt.EventQueue;

import bootcamp.UD22.ejercicio1.views.ClienteView;

/**
 * @author Palmira
 *
 */
public class MainApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView frame = new ClienteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
