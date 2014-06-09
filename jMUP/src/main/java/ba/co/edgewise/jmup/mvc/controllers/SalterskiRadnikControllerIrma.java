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
			// Klik na button Modifikuj
			JButton modifikuj = view.getStrana6().getBtn_modifikuj();
			modifikuj.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					modifikuj();
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
		//Prikaz panela pretraga
		view.prikaziPretragu();
		//Defaultni - Vozila
		prikaziPanelPretragaVozila();
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
		view.getStrana6().getPanel_saobracajna().getModel().clearAll();
		view.getStrana6().getPanel_saobracajna().getModel().addAll(model.dohvatiSveSaobracajne());
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri().setModel(new DefaultComboBoxModel(SaobracajnaPretraga.values()));		
		this.view.getStrana6().prikaziPretraguSaobracajne();
	}
	void prikaziPanelPretragaVlasnickih() {
		view.getStrana6().getPanel_vlasnicka().getModel().clearAll();
		view.getStrana6().getPanel_vlasnicka().getModel().addAll(model.dohvatiSveVlasnicke());
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
		String parametar = view.getStrana6().getTb_unosPretrage().getText();
		VoziloPretraga kriterij = (VoziloPretraga)view.getStrana6().getCb_parametri().getSelectedItem();
		if(parametar.equals("")) {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		} else {
			view.getStrana6().getPanel_vozilo().getModel().addAll(model.pretragaVozilo(parametar,kriterij.toString()));
		}
	}
	void pretraziVozace() {
		view.getStrana6().getPanel_vozac().getModel().clearAll();
		String parametar = view.getStrana6().getTb_unosPretrage().getText();
		VozacPretraga kriterij = (VozacPretraga)view.getStrana6().getCb_parametri().getSelectedItem();
		if(parametar.equals("")) {
			view.getStrana6().getPanel_vozac().getModel().addAll(model.dohvatiSveVozace());
		} else {
			view.getStrana6().getPanel_vozac().getModel().addAll(model.pretragaVozac(parametar,kriterij.toString()));
		}
	}
	void pretraziSaobracajne() {
		view.getStrana6().getPanel_saobracajna().getModel().clearAll();
		String parametar = view.getStrana6().getTb_unosPretrage().getText();
		SaobracajnaPretraga kriterij = (SaobracajnaPretraga)view.getStrana6().getCb_parametri().getSelectedItem();
		if(parametar.equals("")) {
			view.getStrana6().getPanel_saobracajna().getModel().addAll(model.dohvatiSveSaobracajne());
		} else {
			view.getStrana6().getPanel_saobracajna().getModel().addAll(model.pretragaSaobracajna(parametar,kriterij.toString()));
		}
	}
	void pretraziVlasnicke() {
		view.getStrana6().getPanel_vlasnicka().getModel().clearAll();
		String parametar = view.getStrana6().getTb_unosPretrage().getText();
		VlasnickaPretraga kriterij = (VlasnickaPretraga)view.getStrana6().getCb_parametri().getSelectedItem();
		if(parametar.equals("")) {
			view.getStrana6().getPanel_vlasnicka().getModel().addAll(model.dohvatiSveVlasnicke());
		} else {
			view.getStrana6().getPanel_vlasnicka().getModel().addAll(model.pretragaVlasnicka(parametar,kriterij.toString()));
		}
	}
	void modifikuj(){
		final JRadioButton rbVozilo = this.view.getStrana6().getRbVozilo();
		final JRadioButton rbVozac = this.view.getStrana6().getRbVozac();
		final JRadioButton rbSaobracajna = this.view.getStrana6().getRbSaobracajna();
		final JRadioButton rbVlasnicka = this.view.getStrana6().getRbVlasnicka();
		if(rbVozilo.isSelected()) modifikujVozilo();
		else if(rbVozac.isSelected()) modifikujVozaca();
		else if(rbSaobracajna.isSelected()) modifikujSaobracajnu();
		else if(rbVlasnicka.isSelected()) modifikujVlasnicku();
	}
	void modifikujVozilo(){
		int rowSelected = view.getStrana6().getPanel_vozilo().getTable().getSelectedRow();
		Vozilo temp = view.getStrana6().getPanel_vozilo().getModel().getData().get(rowSelected);
		view.getVoziloModifikacija().setVozilo(temp);
		//Ovo treba doraditi...
		/*try {
			updateVozila();
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		view.prikaziModifikacijuVozila();
	}
	void modifikujVozaca(){}
	void modifikujSaobracajnu(){}
	void modifikujVlasnicku(){}
	
	void updateVozila() throws ParseException {
		VrstaVozila vrsta = (VrstaVozila) view.getVoziloDodavanje().getCb_vrstaVozila().getSelectedItem();
		String tip = view.getVoziloDodavanje().getTf_tipVozila().getText(); 
		String modelVozila = view.getVoziloDodavanje().getTf_modelVozila().getText(); 
		String marka = view.getVoziloDodavanje().getTf_markaVozila().getText();
		int godinaProizvodnje = Integer.parseInt(view.getVoziloDodavanje().getTf_godProizvodnje().getText());
		//	REGISTARSKE DODATI U KONSTRUKTOR
		//Neiskoristeno: 
		String registarske = (String)view.getVoziloDodavanje().getTf_regOznaka().getText();
		Double odnosSnageIMase = Double.parseDouble(view.getVoziloDodavanje().getTf_odnos().getText());
		int brojMjestaZaSjedenje = Integer.parseInt(view.getVoziloDodavanje().getTf_sjedenje().getText());
		int brojMjestaZaStajanje =  Integer.parseInt(view.getVoziloDodavanje().getTf_stajanje().getText()); 
		int brojMjestaZaLezanje =  Integer.parseInt(view.getVoziloDodavanje().getTf_lezanje().getText()); 
		EkoKarakteristike ekoKarakteristika =(EkoKarakteristike)view.getVoziloDodavanje().getCb_ekoKarakteristike().getSelectedItem();
		boolean katalizator = view.getVoziloDodavanje().getRb_katalizator_da().isSelected();
		String oblikKaroserije = view.getVoziloDodavanje().getTf_karoserija().getText();
		Date datumPregleda=new SimpleDateFormat("yyyy-MM-dd").parse(view.getVoziloDodavanje().getTf_datumPregleda().getText());
		String brojSasije = view.getVoziloDodavanje().getTf_brojSasije().getText();
		int maxTehnickaDozvoljenaMasa = Integer.parseInt(view.getVoziloDodavanje().getTb_maxMasa().getText());
		int masaVozila = Integer.parseInt(view.getVoziloDodavanje().getTb_masa().getText());
		int dopustenaNosivost = Integer.parseInt(view.getVoziloDodavanje().getTb_nosivost().getText());
		// Motor
		int zapreminaMotora = Integer.parseInt(view.getVoziloDodavanje().getTf_zapremina().getText());
		int maxSnaga = Integer.parseInt(view.getVoziloDodavanje().getTf_maxSnaga().getText());
		String gorivo = (String)view.getVoziloDodavanje().getCb_gorivo().getSelectedItem();
		String brojMotora = view.getVoziloDodavanje().getTf_brojMotora().getText();
		String vrstaMotora =(String)view.getVoziloDodavanje().getCb_vrstaMotora().getSelectedItem();
			
		// Nisu iskoristeni: getTb_bojaVozila(), getCb_nijansa() , getCb_vrstaBoje() 
				
	model.updateujVozilo(registarske, vrsta, marka, tip, modelVozila, brojSasije, oblikKaroserije, godinaProizvodnje, 
			maxTehnickaDozvoljenaMasa, masaVozila, dopustenaNosivost, odnosSnageIMase, brojMjestaZaSjedenje, 
			brojMjestaZaStajanje, brojMjestaZaLezanje, ekoKarakteristika, katalizator, datumPregleda, 
			zapreminaMotora, maxSnaga,gorivo, brojMotora, vrstaMotora);
	}

}
