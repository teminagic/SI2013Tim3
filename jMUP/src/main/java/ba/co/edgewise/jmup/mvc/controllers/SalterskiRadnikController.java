package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;
import ba.co.edgewise.jmup.mvc.views.Login;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class SalterskiRadnikController {

	private SalterskiRadnikModel model;
	private SalterskiRadnikView view;

	public SalterskiRadnikController(SalterskiRadnikView view, SalterskiRadnikModel model) {
		super();
		this.view = view;
		this.model = model;
	}
	public void control() {
		//Listener za prijavu
				JButton unosVozaca = this.view.getMeni().getOpcije().getBtnUnosVozaca();
				unosVozaca.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						prikaziPanelUnosVozaca();
						};
					
				});
	}
	//
	void prikaziPanelUnosVozaca()
	{
		view.prikaziVozacDodavanje();
	}
	
}
