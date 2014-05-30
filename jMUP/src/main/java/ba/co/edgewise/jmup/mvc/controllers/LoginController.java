package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ba.co.edgewise.jmup.mvc.models.AdminModel;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModelAmra;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModelIrma;
import ba.co.edgewise.jmup.mvc.views.Administrator;
import ba.co.edgewise.jmup.mvc.views.Login;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class LoginController {
	
	private WindowAdapter windowControler;
	private Login view;
	private LoginModel model;
	private final LoginController controler = this;
	
	public LoginController(Login view, LoginModel model) {
		super();
		this.view = view;
		this.model = model;
	}

	public void control(){
		//Dialog za izlaz
		windowControler = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showOptionDialog(view, "Da li \u017Eelite iza\u0107i iz aplikacije?",
						"Potvrda izlaza", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, new String[] {"Da", "Ne"}, "default") 
						== JOptionPane.OK_OPTION){
					view.setVisible(false);
					view.dispose();
				}
			}
		};
		this.view.addWindowListener(windowControler);
		
		//Listener za prijavu
		JButton prijava = this.view.getUnos().getBtnPrijava();
		prijava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(provjeriCredentials()){
					getNext();
				} else{
					JOptionPane.showMessageDialog(null, "Progrešan Username/Password!");
				};
			}
		});
	}
	
	private Boolean provjeriCredentials(){
		String username = this.view.getUnos().getTfKorisnickoIme().getText();
		char[] password = this.view.getUnos().getPwfSifra().getPassword();
		return model.provjeriPodatke(username, new String(password));
	}
	
	private void getNext()
	{
		switch(model.getUposlenik().getTip()){
		case ADMINISTRATOR:
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Administrator noviView = new Administrator();
						AdminModel noviModel = new AdminModel();
						AdminController noviController = new AdminController(noviView,noviModel);
						noviController.control();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			this.view.dispose();
			break;
		case MENADZER:
			break;
		case SALTERSKI_RADNIK:
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SalterskiRadnikView noviView = new SalterskiRadnikView();
						//SalterskiRadnikModel noviModel = new SalterskiRadnikModel();
						//SalterskiRadnikController noviController = new SalterskiRadnikController(noviView,noviModel);						
						SalterskiRadnikModelIrma noviModel = new SalterskiRadnikModelIrma();
						SalterskiRadnikControllerIrma noviController = new SalterskiRadnikControllerIrma(noviView,noviModel);						
					
	//					SalterskiRadnikModelAmra noviModel = new SalterskiRadnikModelAmra();
		//				SalterskiRadnikControllerAmra noviController = new SalterskiRadnikControllerAmra(noviView,noviModel);						
					
						noviController.control();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			this.view.dispose();
			break;
		default:
			break;
			
		}
	}
}
