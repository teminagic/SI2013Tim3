package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.VoziloDodavanje;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;
import ba.co.edgewise.jmup.mvc.views.Login;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class SalterskiRadnikController {

	private SalterskiRadnikModel model;
	private SalterskiRadnikView view;
	
	private boolean unosDozvole;
	private boolean odjavaSaltera;
	public SalterskiRadnikController(SalterskiRadnikView view, SalterskiRadnikModel model) {
		super();
		this.view = view;
		this.model = model;
		unosDozvole = false;
		odjavaSaltera = false;
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
				// Listener za unos vozaca
				JButton unosVozaca = this.view.getMeni().getOpcije().getBtnUnosVozaca();
				unosVozaca.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						prikaziPanelUnosVozaca();
						};
					
				});
				
				// Listener za dodavanjeVozaca
				JButton dodavanjeVozaca = this.view.getStrana2().getBtnPrihvati();
				dodavanjeVozaca.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(provjeriPopunjenostVozaca()){							
								
								if (dodajVozaca()) {
									JOptionPane.showOptionDialog(view, "Voza\u010D uspje\u0161no dodan.",
											"Unos voza\u010Da", JOptionPane.OK_OPTION,
											JOptionPane.INFORMATION_MESSAGE, null,
											new String[] { "Uredu" }, "default");
									pocistiPoljaVozac();
									// logika za: unos vlasnicke posto se ovaj panel pojavljuje :D
									if(isUnosDozvole() == true)
									{
										prikaziPanelUnosVozila();
									}
								} else {
									JOptionPane.showOptionDialog(view,
											"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
													+ "Molimo vas da poku\u0161ate ponovo",
											"Unos voza\u010Da", JOptionPane.OK_OPTION,
											JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
											"default");
								};
								
						} 
						else{
							JOptionPane.showMessageDialog(null, "Neispravno popunjena polja!");
						};
					}
				});
				
				JButton ponistiDodavanjeVozaca = this.view.getStrana2().getBtnPonisti();
				ponistiDodavanjeVozaca.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
							pocistiPoljaVozac();
							JOptionPane.showOptionDialog(view, "Unos poni\u0161ten.",
									"Unos voza\u010Da", JOptionPane.OK_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Uredu" }, "default");															
					}
				});
				
				//UNOS VOZILA
				JButton unosVozila = this.view.getMeni().getOpcije().getBtnUnosVozila();
				unosVozila.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						prikaziPanelUnosVozila();
						};			
				});
							
				JButton dodavanje_vozila = this.view.getVoziloDodavanje().getBtn_prihvati();
				dodavanje_vozila.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							if(provjeriPopunjenostUnosVozila()) 
							{
								dodajVozilo();
								if(isUnosDozvole() == true)
									prikaziPanelUnosRegistracije();
								
							}							
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				});
				
				// dodavanje registracije
				
				JButton dodavanjeRegistracije = this.view.getRegistracija().getBtnPrihvati();
				dodavanjeRegistracije.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							if(provjeriPopunjenostRegistracije()) 
							{
								dodajRegistraciju();
								setUnosDozvole(false);
							}
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				});
				
				//Listener unos vlasnicke
				JButton unosVlasnicke = this.view.getMeni().getOpcije().getBtnUnosVlasnicke();
						unosVlasnicke.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setUnosDozvole(true);
						prikaziPanelUnosVozaca();
						};			
				});
						
				//Listener unos saobracajne
				JButton unosSaobracajne = this.view.getMeni().getOpcije().getbtnUnosSaobracajne();
						unosSaobracajne.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setUnosDozvole(true);
						prikaziPanelUnosVozaca();
						};			
				});
				
				//Listener za odjavu
				JButton odjava = this.view.getMeni().getOpcije().getBtnOdjava();
				odjava.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							 int reply = JOptionPane.showConfirmDialog(view, "Eventualne promjene nece biti spa\u0161ene. "
							 		+ "\u017Delite li se odjaviti?", "Odjava", JOptionPane.YES_NO_OPTION);
						        if (reply == JOptionPane.YES_OPTION) {
						        	setOdjavaSaltera(true);
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
				
	}
	public void odjaviSkroz()
	{
		if(isOdjavaSaltera() == true)
			this.view.dispose();
	}
	
	public void pocistiPoljaVozac()
	{
		view.getStrana2().getTfIme().setText("");
		view.getStrana2().getTfPrezime().setText("");
		view.getStrana2().getTfAdresa().setText("");
		view.getStrana2().getTfMjesto().setText("");
		view.getStrana2().getTfOpcina().setText("");
		view.getStrana2().getTfJMBG().setText("");
		view.getStrana2().getTfIdBroj().setText("");
		view.getStrana2().getPravno().setSelected(false);
		view.getStrana2().getFizicko().setSelected(false);
	}
	public Boolean dodajVozaca()
	{
		// Pokupimo sve iz popunjenih polja, pozovemo metodu iz modela kojoj proslijedimo podatke
		// da ih smjesti u bazu.
		boolean pravno;
		String ime = view.getStrana2().getTfIme().getText();
		String prezime = view.getStrana2().getTfPrezime().getText();
		String adresa = view.getStrana2().getTfAdresa().getText();
		String mjesto = view.getStrana2().getTfMjesto().getText();
		String opcina = view.getStrana2().getTfOpcina().getText();
		if(view.getStrana2().getPravno().isSelected())
			pravno = true;
		else
			pravno = false;
			
		String jmbg = view.getStrana2().getTfJMBG().getText();
		// Nek unese nizasta ne sluzi :D
		String idBroj = view.getStrana2().getTfIdBroj().getText();
		
		return model.DodajVozaca(ime, prezime, adresa, mjesto, opcina, pravno, jmbg, idBroj);
	}
	public void dodajRegistraciju() throws ParseException 
	{
	}
	public boolean provjeriPopunjenostVozaca() {
		return true;
	}
	
	// Prikazi za buttone iz menija:
	void prikaziPanelUnosRegistracije()
	{
		view.prikaziUnosRegistracije();
	}
	void prikaziPanelUnosVozaca()
	{
		view.prikaziUnosVozaca();
	}
	void prikaziPanelPocetnu()
	{
		view.prikaziPocetnu();
	}
	//VOZILO
	void prikaziPanelUnosVozila()
	{
		view.prikaziUnosVozila();
	}

	public boolean provjeriPopunjenostUnosVozila() {
		return true;
	}
	public boolean provjeriPopunjenostRegistracije() {
		return true;
	}
	public void dodajVozilo() throws ParseException 
	{	
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
				
	model.dodajVozilo(registarske, vrsta, marka, tip, modelVozila, brojSasije, oblikKaroserije, godinaProizvodnje, 
			maxTehnickaDozvoljenaMasa, masaVozila, dopustenaNosivost, odnosSnageIMase, brojMjestaZaSjedenje, 
			brojMjestaZaStajanje, brojMjestaZaLezanje, ekoKarakteristika, katalizator, datumPregleda, 
			zapreminaMotora, maxSnaga,gorivo, brojMotora, vrstaMotora);
	
	}
	public boolean isUnosDozvole() {
		return unosDozvole;
	}
	public void setUnosDozvole(boolean unosVlasnicke) {
		this.unosDozvole = unosVlasnicke;
	}
	public boolean isOdjavaSaltera() {
		return odjavaSaltera;
	}
	public void setOdjavaSaltera(boolean odjavaSaltera) {
		this.odjavaSaltera = odjavaSaltera;
	}
}
