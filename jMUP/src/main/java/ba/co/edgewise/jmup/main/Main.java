package ba.co.edgewise.jmup.main;

import java.awt.EventQueue;

import ba.co.edgewise.jmup.mvc.controllers.LoginController;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.views.Login;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login view = new Login();
					LoginModel model = new LoginModel();
					LoginController controler = new LoginController(view, model);
					controler.control();
				} catch (Exception e) {
					e.printStackTrace();//
				}
			}
		});
	}
}
