package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.components.helpers.ShowDialogInput;
import ba.co.edgewise.jmup.components.VoziloDodavanje;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.SaobracajnaPretraga;
import ba.co.edgewise.jmup.enums.VlasnickaPretraga;
import ba.co.edgewise.jmup.enums.VozacPretraga;
import ba.co.edgewise.jmup.enums.VoziloPretraga;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.BossModel;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;
import ba.co.edgewise.jmup.mvc.views.BossView;
import ba.co.edgewise.jmup.mvc.views.Login;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class BossController {

	private BossModel model;
	private BossView view;
	private boolean odjavaBossa;

	public BossController(BossView view, BossModel model) {
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
		
		// Izvjestaji
		JButton izvjestaj= this.view.getMeni().getOpcije().getBtnIzradaIzvjestaja();
		izvjestaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 prikaziPanelPretraga();
				 prikaziPanelIzvjestaji();
				};		
		});
		
		//Listener za odjavu
		JButton odjava = this.view.getMeni().getOpcije().getBtnOdjava();
		odjava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(JOptionPane.showOptionDialog(view, "Eventualne promjene nece biti spaÅ¡ene. "
					 		+ "\u017Delite li se odjaviti?",
							"Potvrda odjave", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, new String[] {"Da", "Ne"}, "default")== JOptionPane.OK_OPTION)
						{
					    	setOdjavaBossa(true);
							odjaviSkroz();
							Login view = new Login();
							LoginModel model = new LoginModel();
							LoginController controler = new LoginController(view, model);
							controler.control();
				        }
				       
				} catch (Exception izuzetak) {
					izuzetak.printStackTrace();//
				}
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
		final JRadioButton rbVozilo = this.view.getStrana2().getRbVozilo();
		rbVozilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbVozilo.isSelected()) {
					prikaziPanelPretragaVozila();
				}
			};
		});
		// Pretraga - Prikaz panela Vozac
		final JRadioButton rbVozac = this.view.getStrana2().getRbVozac();
		rbVozac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbVozac.isSelected()) {
					prikaziPanelPretragaVozaca();
				}
			};
		});
		// Pretraga - Prikaz panela Saobracajna
		final JRadioButton rbSaobracajna = this.view.getStrana2().getRbSaobracajna();
		rbSaobracajna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbSaobracajna.isSelected()) {
					prikaziPanelPretragaSaobracajnih();
				}
			};
		});
		// Pretraga - Prikaz panela Vlasnicka
		final JRadioButton rbVlasnicka = this.view.getStrana2().getRbVlasnicka();
		rbVlasnicka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbVlasnicka.isSelected()) {
					prikaziPanelPretragaVlasnickih();
				}
			};
		});
		
		//Izvjestaj kreiraj
		JButton izvjestajIstekleRegistracije = this.view.getIzvjestaj().getBtnKreiranjeIzvjestaja1();
		izvjestajIstekleRegistracije.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ShowDialogInput dialog = new ShowDialogInput("Unesite lokaciju za spremanje izvještaja:", 1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};
		});
		
		JButton izvjestajDozvole = this.view.getIzvjestaj().getBtnKreiranjeIzvjestaja2();
		izvjestajDozvole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ShowDialogInput dialog = new ShowDialogInput("Unesite lokaciju za spremanje izvještaja:", 2);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};
		});
		
		//Enable - disable buttoni
		JTable table = view.getStrana2().getPanel_vozilo().getTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
				public void valueChanged(ListSelectionEvent e) {
					ListSelectionModel lsm = (ListSelectionModel)e.getSource();
					view.getStrana2().getBtn_modifikuj().setEnabled(!lsm.isSelectionEmpty());
					view.getStrana2().getBtnIzbrisi().setEnabled(!lsm.isSelectionEmpty());
					view.getStrana2().getBtnProfil().setEnabled(!lsm.isSelectionEmpty());
				}
			});
		// Klik na button Pretrazi
		JButton pretrazi = view.getStrana2().getBtnPretrazi();
		pretrazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pretrazi();
			}
		});
		// Klik na button Modifikuj
		JButton modifikuj = view.getStrana2().getBtn_modifikuj();
		modifikuj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modifikuj();
			}
		});
		// Klik na button Izbrisi
		JButton izbrisi = view.getStrana2().getBtnIzbrisi();
		izbrisi.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
				izbrisi();
			}
		});	
	}
	void prikaziPanelPocetnu()
	{
		view.prikaziPocetnu();
	}
	
	void prikaziPanelIzvjestaji()
	{
		view.prikaziIzvjestaje();
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
		view.getStrana2().getPanel_vozilo().getModel().clearAll();
		view.getStrana2().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		//Comboboxi
		this.view.getStrana2().getCb_parametri().removeAllItems();
		this.view.getStrana2().getCb_parametri().setModel(new DefaultComboBoxModel(VoziloPretraga.values()));		
		//Prikaz
		this.view.getStrana2().prikaziPretraguVozila();
	}
	void prikaziPanelPretragaVozaca() {
		//Baza
		view.getStrana2().getPanel_vozac().getModel().clearAll();
		view.getStrana2().getPanel_vozac().getModel().addAll(model.dohvatiSveVozace());
		//Comboxi
		this.view.getStrana2().getCb_parametri().removeAllItems();
		this.view.getStrana2().getCb_parametri().setModel(new DefaultComboBoxModel(VozacPretraga.values()));		
		//Prikaz
		this.view.getStrana2().prikaziPretraguVozaca();
	}
	void prikaziPanelPretragaSaobracajnih() {
		view.getStrana2().getPanel_saobracajna().getModel().clearAll();
		view.getStrana2().getPanel_saobracajna().getModel().addAll(model.dohvatiSveSaobracajne());
		this.view.getStrana2().getCb_parametri().removeAllItems();
		this.view.getStrana2().getCb_parametri().setModel(new DefaultComboBoxModel(SaobracajnaPretraga.values()));		
		this.view.getStrana2().prikaziPretraguSaobracajne();
	}
	void prikaziPanelPretragaVlasnickih() {
		view.getStrana2().getPanel_vlasnicka().getModel().clearAll();
		view.getStrana2().getPanel_vlasnicka().getModel().addAll(model.dohvatiSveVlasnicke());
		this.view.getStrana2().getCb_parametri().removeAllItems();
		this.view.getStrana2().getCb_parametri().setModel(new DefaultComboBoxModel(VlasnickaPretraga.values()));		
		this.view.getStrana2().prikaziPretraguVlasnicke();
	}
	private void pretrazi() {	
		final JRadioButton rbVozilo = this.view.getStrana2().getRbVozilo();
		final JRadioButton rbVozac = this.view.getStrana2().getRbVozac();
		final JRadioButton rbSaobracajna = this.view.getStrana2().getRbSaobracajna();
		final JRadioButton rbVlasnicka = this.view.getStrana2().getRbVlasnicka();
		if(rbVozilo.isSelected()) pretraziVozila();
		else if(rbVozac.isSelected()) pretraziVozace();
		else if(rbSaobracajna.isSelected()) pretraziSaobracajne();
		else if(rbVlasnicka.isSelected()) pretraziVlasnicke();
	}
	void pretraziVozila() {
		view.getStrana2().getPanel_vozilo().getModel().clearAll();
		String parametar = view.getStrana2().getTb_unosPretrage().getText();
		VoziloPretraga kriterij = (VoziloPretraga)view.getStrana2().getCb_parametri().getSelectedItem();
		if(parametar.equals("")) {
			if(model.dohvatiSvaVozila() == null) {
				view.getStrana2().getPanel_vozilo().getModel().clearAll();
				JOptionPane.showOptionDialog(view, "Nije uneseno nijedno vozilo.",
						"Upozorenje.", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
			}
			else view.getStrana2().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		} else {
			if(model.pretragaVozilo(parametar,kriterij.toString()) == null) {
				view.getStrana2().getPanel_vozilo().getModel().clearAll();
				JOptionPane.showOptionDialog(view, "Nije pronaï¿½eno nijedno vozilo s unesenim parametrima.",
						"Upozorenje.", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
			}
			else view.getStrana2().getPanel_vozilo().getModel().addAll(model.pretragaVozilo(parametar,kriterij.toString()));
		}
		view.getStrana2().getTb_unosPretrage().setText("");

	}
	void pretraziVozace() {
		view.getStrana2().getPanel_vozac().getModel().clearAll();
		String parametar = view.getStrana2().getTb_unosPretrage().getText();
		VozacPretraga kriterij = (VozacPretraga)view.getStrana2().getCb_parametri().getSelectedItem();
		if(parametar.equals("")) {
			view.getStrana2().getPanel_vozac().getModel().addAll(model.dohvatiSveVozace());
		} else {
			view.getStrana2().getPanel_vozac().getModel().addAll(model.pretragaVozac(parametar,kriterij.toString()));
		}
		view.getStrana2().getTb_unosPretrage().setText("");
	}
	void pretraziSaobracajne() {
		view.getStrana2().getPanel_saobracajna().getModel().clearAll();
		String parametar = view.getStrana2().getTb_unosPretrage().getText();
		SaobracajnaPretraga kriterij = (SaobracajnaPretraga)view.getStrana2().getCb_parametri().getSelectedItem();
		if(parametar.equals("")) {
			view.getStrana2().getPanel_saobracajna().getModel().addAll(model.dohvatiSveSaobracajne());
		} else {
			view.getStrana2().getPanel_saobracajna().getModel().addAll(model.pretragaSaobracajna(parametar,kriterij.toString()));
		}
		view.getStrana2().getTb_unosPretrage().setText("");
	}
	void pretraziVlasnicke() {
		view.getStrana2().getPanel_vlasnicka().getModel().clearAll();
		String parametar = view.getStrana2().getTb_unosPretrage().getText();
		VlasnickaPretraga kriterij = (VlasnickaPretraga)view.getStrana2().getCb_parametri().getSelectedItem();
		if(parametar.equals("")) {
			view.getStrana2().getPanel_vlasnicka().getModel().addAll(model.dohvatiSveVlasnicke());
		} else {
			view.getStrana2().getPanel_vlasnicka().getModel().addAll(model.pretragaVlasnicka(parametar,kriterij.toString()));
		}
		view.getStrana2().getTb_unosPretrage().setText("");
	}
	void modifikuj(){
		final JRadioButton rbVozilo = this.view.getStrana2().getRbVozilo();
		final JRadioButton rbVozac = this.view.getStrana2().getRbVozac();
		final JRadioButton rbSaobracajna = this.view.getStrana2().getRbSaobracajna();
		final JRadioButton rbVlasnicka = this.view.getStrana2().getRbVlasnicka();
		if(rbVozilo.isSelected()) modifikujVozilo();
		else if(rbVozac.isSelected()) modifikujVozaca();
		else if(rbSaobracajna.isSelected()) modifikujSaobracajnu();
		else if(rbVlasnicka.isSelected()) modifikujVlasnicku();
	}
	void modifikujVozilo(){
		int rowSelected = view.getStrana2().getPanel_vozilo().getTable().getSelectedRow();
		Vozilo temp = view.getStrana2().getPanel_vozilo().getModel().getData().get(rowSelected);
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
	/*	VrstaVozila vrsta = (VrstaVozila) view.getVoziloDodavanje().getCb_vrstaVozila().getSelectedItem();
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
			zapreminaMotora, maxSnaga,gorivo, brojMotora, vrstaMotora);*/
	}
	public void izbrisi() {
		/*
		 	int rowSelected = view.getStrana3().getTable().getSelectedRow();
		Uposlenik temp = view.getStrana3().getModel().getData().get(rowSelected);
		model.setUposlenik(temp);
		if (model.brisanjeKorisnika()) {
			if(JOptionPane.showOptionDialog(view, "Korisnik uspje\u0161no izbrisan.",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default") == JOptionPane.OK_OPTION)
				nextPretraga();
		} else {
			JOptionPane.showOptionDialog(view,
					"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
							+ "Molimo vas da poku\u0161ate ponovo",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
					"default");
		};
		nextPretraga();*/
	}
	public boolean isOdjavaBossa() {
		return odjavaBossa;
	}
	public void setOdjavaBossa(boolean odjavaBossa) {
		this.odjavaBossa = odjavaBossa;
	}
	public void odjaviSkroz()
	{
		if(isOdjavaBossa() == true)
			this.view.dispose();
	}
}