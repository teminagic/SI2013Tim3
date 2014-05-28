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
import ba.co.edgewise.jmup.mvc.models.*;
import ba.co.edgewise.jmup.mvc.views.*;
import ba.co.edgewise.jmup.components.*;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;


public class SalterskiRadnikControllerIrma {
	
	private WindowAdapter windowControler;
	private VoziloDodavanje view;
	private SalterskiRadnikModelIrma model;
	private final SalterskiRadnikControllerIrma controler = this;
	
	public SalterskiRadnikControllerIrma(VoziloDodavanje view, SalterskiRadnikModelIrma model) {
		super();
		this.view = view;
		this.model = model;
	}
	
	public void control() {
		//Dodavanje novog vozila
				JButton dodavanje_vozila = this.view.getBtn_prihvati();
				dodavanje_vozila.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(provjeriPopunjenost()){
							try {
								dodajVozilo();
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
	public boolean provjeriPopunjenost() {
		return true;
	}
	public void dodajVozilo() throws ParseException {	
		//Informacije o vozilu izvucene sa forme
		/*
		 *Integer id, VrstaVozila vrsta, String marka, String tip,
			String model, String brojSasije, String oblikKaroserije,
			int godinaProizvodnje, int maxTehnickaDozvoljenaMasa,
			int masaVozila, int dopustenaNosivost,Double odnosSnageIMase, Integer brojMjestaZaSjedenje,
			Integer brojMjestaZaStajanje, Integer brojMjestaZaLezanje,
			EkoKarakteristike ekoKarakteristika, Boolean katalizator,
			Date datumPregleda,Integer zapreminaMotora, Integer maxSnaga,
			String vrstaGoriva, String brojMotora, String vrstaMotora*/
	
		VrstaVozila vrsta = VrstaVozila.getVrstaVozila((String)view.getCb_vrstaVozila().getSelectedItem());
		String tip = view.getTf_tipVozila().getText(); 
		String modelVozila = view.getTf_modelVozila().getText(); 
		String marka = view.getTf_markaVozila().getText();
		int godinaProizvodnje = Integer.parseInt(view.getTf_godProizvodnje().getText());
		//Registarske dodati
		//Neiskoristeno: String registarske = view.getTf_regOznaka().getText();
		Double odnosSnageIMase = Double.parseDouble(view.getTf_odnos().getText());
		int brojMjestaZaSjedenje = Integer.parseInt(view.getTf_sjedenje().getText());
		int brojMjestaZaStajanje =  Integer.parseInt(view.getTf_stajanje().getText()); 
		int brojMjestaZaLezanje =  Integer.parseInt(view.getTf_lezanje().getText()); 
		EkoKarakteristike ekoKarakteristika = EkoKarakteristike.getEkoKarakteristike((String)view.getCb_ekoKarakteristike().getSelectedItem());
		boolean katalizator = view.getRb_katalizator_da().isSelected();
		String oblikKaroserije = view.getTf_karoserija().getText();
		Date datumPregleda=new SimpleDateFormat("dd-MMM-yy").parse(view.getTf_datumPregleda().getText());
		//String datumPregleda = view.getTf_datumPregleda().getText();
		String brojSasije = view.getTf_brojSasije().getText();
		int maxTehnickaDozvoljenaMasa = Integer.parseInt(view.getTb_maxMasa().getText());
		int masaVozila = Integer.parseInt(view.getTb_masa().getText());
		int dopustenaNosivost = Integer.parseInt(view.getTb_nosivost().getText());
		// Motor
		int zapreminaMotora = Integer.parseInt(view.getTf_zapremina().getText());
		int maxSnaga = Integer.parseInt(view.getTf_maxSnaga().getText());
		String vrstaGoriva = (String)view.getCb_gorivo().getSelectedItem();
		String brojMotora = view.getTf_brojMotora().getText();
		String vrstaMotora = (String)view.getCb_vrstaMotora().getSelectedItem();
		// Nisu iskoristeni: getTb_bojaVozila(), getCb_nijansa() , getCb_vrstaBoje() 
		
	model.dodajVozilo(null, vrsta, marka, tip, modelVozila, brojSasije, oblikKaroserije, godinaProizvodnje, 
			maxTehnickaDozvoljenaMasa, masaVozila, dopustenaNosivost, odnosSnageIMase, brojMjestaZaSjedenje, 
			brojMjestaZaStajanje, brojMjestaZaLezanje, ekoKarakteristika, katalizator, datumPregleda, 
			zapreminaMotora, maxSnaga,vrstaGoriva, brojMotora, vrstaMotora);
	}
}
