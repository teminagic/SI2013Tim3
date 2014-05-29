package ba.co.edgewise.jmup.mvc.controllers;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.*;
import ba.co.edgewise.jmup.mvc.views.*;
import ba.co.edgewise.jmup.components.*;
import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaGoriva;
import ba.co.edgewise.jmup.enums.VrstaVozila;


public class SalterskiRadnikControllerIrma {
	
	private WindowAdapter windowControler;
	private SalterskiRadnikView view;
	private SalterskiRadnikModelIrma model;
	private final SalterskiRadnikControllerIrma controler = this;
	
	public SalterskiRadnikControllerIrma(SalterskiRadnikView view, SalterskiRadnikModelIrma model) {
		super();
		this.view = view;
		this.model = model;
	}
	
	public void control() {
			// Listener za pocetnu
			JButton pocetna= this.view.getMeni().getOpcije().getBtnPocetna();
			pocetna.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					prikaziPanelPocetnu();
					};		
			});
			
			// Pretraga
			JButton salterskaPretraga= this.view.getMeni().getOpcije().getBtnPretraga();
			salterskaPretraga.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					prikaziPanelPretraga();
			};
				
			});

		}
	void prikaziPanelPocetnu()
	{
		view.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Po\u010Detna");
	}
	//PRETRAGA
	void prikaziPanelPretraga()
	{
		view.getSadrzaj().getNaslov().postaviNaslov("Pretraga");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Pretraga");
	}

}
