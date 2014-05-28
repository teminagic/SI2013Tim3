package ba.co.edgewise.jmup.mvc.controllers;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.*;
import ba.co.edgewise.jmup.mvc.views.*;
import ba.co.edgewise.jmup.components.*;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
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
		// Listener za unos vozila
			JButton unosVozila = this.view.getMeni().getOpcije().getBtnUnosVozila();
			unosVozila.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					prikaziPanelUnosVozila();
					};			
			});
			
			// Listener za pocetnu
			JButton pocetna= this.view.getMeni().getOpcije().getBtnPocetna();
			pocetna.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					prikaziPanelPocetnu();
					};		
			});
			
			JButton dodavanje_vozila = this.view.getVoziloDodavanje().getBtn_prihvati();
			dodavanje_vozila.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(provjeriPopunjenost()){
						try {
							dodajVozilo();
							JOptionPane.showConfirmDialog(view, "Uspješno ste dodali vozilo.","Dodano vozilo", JOptionPane.OK_CANCEL_OPTION);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else{
						JOptionPane.showMessageDialog(null, "Neispravno popunjena polja!");
					};
				}
			});
			
		}
///
		public void prikaziPanelUnosVozila()
		{
			view.prikaziVoziloDodavanje();
		}
		public void prikaziPanelPocetnu()
		{
			view.prikaziPocetnu();
		}
		
		//Dodavanje novog vozila
			
	public boolean provjeriPopunjenost() {
		return true;
	}
	public void dodajVozilo() throws ParseException {	
	
		VrstaVozila vrsta = VrstaVozila.getVrstaVozila((String)view.getVoziloDodavanje().getCb_vrstaVozila().getSelectedItem());
		String tip = view.getVoziloDodavanje().getTf_tipVozila().getText(); 
		String modelVozila = view.getVoziloDodavanje().getTf_modelVozila().getText(); 
		String marka = view.getVoziloDodavanje().getTf_markaVozila().getText();
		int godinaProizvodnje = Integer.parseInt(view.getVoziloDodavanje().getTf_godProizvodnje().getText());
		//Registarske dodati
		//Neiskoristeno: String registarske = view.getVoziloDodavanje().getTf_regOznaka().getText();
		Double odnosSnageIMase = Double.parseDouble(view.getVoziloDodavanje().getTf_odnos().getText());
		int brojMjestaZaSjedenje = Integer.parseInt(view.getVoziloDodavanje().getTf_sjedenje().getText());
		int brojMjestaZaStajanje =  Integer.parseInt(view.getVoziloDodavanje().getTf_stajanje().getText()); 
		int brojMjestaZaLezanje =  Integer.parseInt(view.getVoziloDodavanje().getTf_lezanje().getText()); 
		EkoKarakteristike ekoKarakteristika = EkoKarakteristike.getEkoKarakteristike((String)view.getVoziloDodavanje().getCb_ekoKarakteristike().getSelectedItem());
		boolean katalizator = view.getVoziloDodavanje().getRb_katalizator_da().isSelected();
		String oblikKaroserije = view.getVoziloDodavanje().getTf_karoserija().getText();
		Date datumPregleda=new SimpleDateFormat("dd-MMM-yy").parse(view.getVoziloDodavanje().getTf_datumPregleda().getText());
		//String datumPregleda = view.getVoziloDodavanje().getTf_datumPregleda().getText();
		String brojSasije = view.getVoziloDodavanje().getTf_brojSasije().getText();
		int maxTehnickaDozvoljenaMasa = Integer.parseInt(view.getVoziloDodavanje().getTb_maxMasa().getText());
		int masaVozila = Integer.parseInt(view.getVoziloDodavanje().getTb_masa().getText());
		int dopustenaNosivost = Integer.parseInt(view.getVoziloDodavanje().getTb_nosivost().getText());
		// Motor
		int zapreminaMotora = Integer.parseInt(view.getVoziloDodavanje().getTf_zapremina().getText());
		int maxSnaga = Integer.parseInt(view.getVoziloDodavanje().getTf_maxSnaga().getText());
		String vrstaGoriva = (String)view.getVoziloDodavanje().getCb_gorivo().getSelectedItem();
		String brojMotora = view.getVoziloDodavanje().getTf_brojMotora().getText();
		String vrstaMotora = (String)view.getVoziloDodavanje().getCb_vrstaMotora().getSelectedItem();
		// Nisu iskoristeni: getTb_bojaVozila(), getCb_nijansa() , getCb_vrstaBoje() 
		
/*	model.dodajVozilo(null, vrsta, marka, tip, modelVozila, brojSasije, oblikKaroserije, godinaProizvodnje, 
			maxTehnickaDozvoljenaMasa, masaVozila, dopustenaNosivost, odnosSnageIMase, brojMjestaZaSjedenje, 
			brojMjestaZaStajanje, brojMjestaZaLezanje, ekoKarakteristika, katalizator, datumPregleda, 
			zapreminaMotora, maxSnaga,vrstaGoriva, brojMotora, vrstaMotora);*/
	// novi = new Motor(0, 650, 200,
	// "LPG", "la", "la");
	// d.create(novi);
model.dodajVozilo(0, VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A1", "aaa54", "oblikkaroserije", 2013, 4500,3000, 1500, 5.1, 5, 0, 0, EkoKarakteristike.EURO2, true, new Date(),0, 650, "LPG", "la", "la");	
	}
}
