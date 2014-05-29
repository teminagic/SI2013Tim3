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
	
	enum VoziloPretraga { Registarska_oznaka("Registarska oznaka"), Godina_proizvodnje("Godina proizvodnje"), Vrsta_vozila("Vrsta vozila"), Marka_vozila("Marka vozila");
	   private final String stringValue;
	   private VoziloPretraga(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
	}
	enum VozacPretraga { Ime("Ime"), Prezime("Prezime"), JMBG("JMBG"), Broj_licne("Broj lične"); 
	private final String stringValue;
	   private VozacPretraga(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
	}
	public enum VlasnickaPretraga { Broj_potvrde("Broj potvrde"), Registarska_oznaka(""), Ime_prezime("Ime i prezime"), JMBG_vlasnika("JMBG vlasnika") ; 
		private final String stringValue;
	   private VlasnickaPretraga(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
	}
	public enum SaobracajnaPretraga { Broj_potvrde("Broj potvrde"), Registarska_oznaka("Registarska oznaka"), Ime_prezime("Ime i prezime"), JMBG_vozaca("JMBG vozača"); 
		private final String stringValue;
	   private SaobracajnaPretraga(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
	   }
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
			//RBovi
			final JRadioButton rbVozilo = this.view.getStrana6().getRbVozilo();
			rbVozilo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rbVozilo.isSelected()) {
						prikaziPanelPretragaVozila();
					}
				};
			});
			final JRadioButton rbVozac = this.view.getStrana6().getRbVozac();
			rbVozac.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rbVozac.isSelected()) {
						prikaziPanelPretragaVozaca();
					}
				};
			});
			final JRadioButton rbSaobracajna = this.view.getStrana6().getRbSaobracajna();
			rbSaobracajna.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rbSaobracajna.isSelected()) {
						prikaziPanelPretragaSaobracajnih();
					}
				};
			});
			final JRadioButton rbVlasnicka = this.view.getStrana6().getRbVlasnicka();
			rbVlasnicka.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rbVlasnicka.isSelected()) {
						prikaziPanelPretragaVlasnickih();
					}
				};
			});
				
		}
	void prikaziPanelPocetnu()
	{
		view.prikaziPocetnu();
	}
	//PRETRAGA
	void prikaziPanelPretraga()
	{
		// view.prikaziPretragu();
		// ovo smjestiti tamo..
		view.getSadrzaj().getNaslov().postaviNaslov("Pretraga");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Pretraga");
	}
	void prikaziPanelPretragaVozila() {
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(VoziloPretraga.values()));		
		this.view.getStrana6().prikaziPretraguVozila();
	}
	void prikaziPanelPretragaVozaca() {
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(VozacPretraga.values()));		
		this.view.getStrana6().prikaziPretraguVozaca();
	}
	void prikaziPanelPretragaSaobracajnih() {
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(SaobracajnaPretraga.values()));		
		this.view.getStrana6().prikaziPretraguSaobracajne();
	}
	void prikaziPanelPretragaVlasnickih() {
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(VlasnickaPretraga.values()));		
		this.view.getStrana6().prikaziPretraguVlasnicke();
	}
	

}
