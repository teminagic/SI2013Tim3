package ba.co.edgewise.jmup.mvc.controllers;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.*;
import ba.co.edgewise.jmup.mvc.views.*;
import ba.co.edgewise.jmup.components.*;
import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.enums.*;



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
			
			// Pretraga - Prikaz osnovnog panela
			JButton salterskaPretraga= this.view.getMeni().getOpcije().getBtnPretraga();
			salterskaPretraga.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					prikaziPanelPretraga();
				};
				
			});
			// Pretraga - Prikaz panela Vozilo
			final JRadioButton rbVozilo = this.view.getStrana6().getRbVozilo();
			rbVozilo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rbVozilo.isSelected()) {
						prikaziPanelPretragaVozila();
					}
				};
			});
			// Pretraga - Prikaz panela Vozac
			final JRadioButton rbVozac = this.view.getStrana6().getRbVozac();
			rbVozac.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rbVozac.isSelected()) {
						prikaziPanelPretragaVozaca();
					}
				};
			});
			// Pretraga - Prikaz panela Saobracajna
			final JRadioButton rbSaobracajna = this.view.getStrana6().getRbSaobracajna();
			rbSaobracajna.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rbSaobracajna.isSelected()) {
						prikaziPanelPretragaSaobracajnih();
					}
				};
			});
			// Pretraga - Prikaz panela Vlasnicka
			final JRadioButton rbVlasnicka = this.view.getStrana6().getRbVlasnicka();
			rbVlasnicka.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rbVlasnicka.isSelected()) {
						prikaziPanelPretragaVlasnickih();
					}
				};
			});
			//??
			JTable table = view.getStrana6().getPanel_vozilo().getTable();
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				@Override
					public void valueChanged(ListSelectionEvent e) {
						ListSelectionModel lsm = (ListSelectionModel)e.getSource();
						view.getStrana6().getBtn_modifikuj().setEnabled(!lsm.isSelectionEmpty());
					//	view.getStrana6().getBtnIzbrisiKorisnika().setEnabled(!lsm.isSelectionEmpty());
					}
				});
			// Klik na button Pretrazi
			JButton pretrazi = view.getStrana6().getBtnPretrazi();
			pretrazi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					pretrazi();
				}
			});
				
		}
	void prikaziPanelPocetnu()
	{
		view.prikaziPocetnu();
	}
	//PRETRAGA
	void prikaziPanelPretraga()
	{
		//Podaci iz baze
		view.getStrana6().getPanel_vozilo().getModel().clearAll();
		view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());		
		//Podaci u comboboxu
		this.view.getStrana6().getCb_parametri().removeAllItems();		
		//Prikaz panela pretraga
		view.prikaziPretragu();
		//Defaultni prikaz - vozila
		view.getStrana6().prikaziPretraguVozila();
	}
	void prikaziPanelPretragaVozila() {
		//Baza
		view.getStrana6().getPanel_vozilo().getModel().clearAll();
		view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		//Comboboxi
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(VoziloPretraga.values()));		
		//Prikaz
		this.view.getStrana6().prikaziPretraguVozila();
	}
	void prikaziPanelPretragaVozaca() {
		//Baza
		view.getStrana6().getPanel_vozac().getModel().clearAll();
		view.getStrana6().getPanel_vozac().getModel().addAll(model.dohvatiSveVozace());
		//Comboxi
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(VozacPretraga.values()));		
		//Prikaz
		this.view.getStrana6().prikaziPretraguVozaca();
	}
	void prikaziPanelPretragaSaobracajnih() {
		//	view.getStrana6().getPanel_vozilo().getModel().clearAll();
		//	view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(SaobracajnaPretraga.values()));		
		this.view.getStrana6().prikaziPretraguSaobracajne();
	}
	void prikaziPanelPretragaVlasnickih() {
		//	view.getStrana6().getPanel_vozilo().getModel().clearAll();
		//	view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(VlasnickaPretraga.values()));		
		this.view.getStrana6().prikaziPretraguVlasnicke();
	}
	private void pretrazi() {	
		final JRadioButton rbVozilo = this.view.getStrana6().getRbVozilo();
		final JRadioButton rbVozac = this.view.getStrana6().getRbVozac();
		final JRadioButton rbSaobracajna = this.view.getStrana6().getRbSaobracajna();
		final JRadioButton rbVlasnicka = this.view.getStrana6().getRbVlasnicka();
		if(rbVozilo.isSelected()) pretraziVozila();
		else if(rbVozac.isSelected()) pretraziVozace();
		else if(rbSaobracajna.isSelected()) pretraziSaobracajne();
		else if(rbVlasnicka.isSelected()) pretraziVlasnicke();
	}
	void pretraziVozila() {
		view.getStrana6().getPanel_vozilo().getModel().clearAll();
		String kriterij = view.getStrana6().getTb_unosPretrage().getText();
		VoziloPretraga tip = (VoziloPretraga)view.getStrana6().getCb_parametri().getSelectedItem();
		if(kriterij.equals("")) {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		} else {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.pretragaVozilo(tip.toString(),kriterij));
		}
	}
	void pretraziVozace() {
		view.getStrana6().getPanel_vozilo().getModel().clearAll();
		String kriterij = view.getStrana6().getTb_unosPretrage().getText();
		VozacPretraga tip = (VozacPretraga)view.getStrana6().getCb_parametri().getSelectedItem();
		if(kriterij.equals("")) {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		} else {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.pretragaVozilo(tip.toString(),kriterij));
		}
	}
	void pretraziSaobracajne() {
		view.getStrana6().getPanel_vozilo().getModel().clearAll();
		String kriterij = view.getStrana6().getTb_unosPretrage().getText();
		SaobracajnaPretraga tip = (SaobracajnaPretraga)view.getStrana6().getCb_parametri().getSelectedItem();
		if(kriterij.equals("")) {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		} else {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.pretragaVozilo(tip.toString(),kriterij));
		}
	}
	void pretraziVlasnicke() {
		view.getStrana6().getPanel_vozilo().getModel().clearAll();
		String kriterij = view.getStrana6().getTb_unosPretrage().getText();
		VlasnickaPretraga tip = (VlasnickaPretraga)view.getStrana6().getCb_parametri().getSelectedItem();
		if(kriterij.equals("")) {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		} else {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.pretragaVozilo(tip.toString(),kriterij));
		}
	}

	

}
