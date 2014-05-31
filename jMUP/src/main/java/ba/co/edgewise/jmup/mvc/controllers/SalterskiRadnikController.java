package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

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
import ba.co.edgewise.jmup.components.VoziloDodavanje;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.SaobracajnaPretraga;
import ba.co.edgewise.jmup.enums.VlasnickaPretraga;
import ba.co.edgewise.jmup.enums.VozacPretraga;
import ba.co.edgewise.jmup.enums.VoziloPretraga;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;
import ba.co.edgewise.jmup.mvc.views.Login;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;
import java.math.*;

public class SalterskiRadnikController {

	private SalterskiRadnikModel model;
	private SalterskiRadnikView view;
	
	// Moram imati dva pokazatelja o kojoj se dozvoli radi
	// Ako se redno unosi saobracajna, varijabla unosSDozvole je na true
	// tako znam i koju cu DAOmetodu za kreiranje dozvole pozvati
	// Mozam ih razlikovati jer ako je unosSDozvole true pozvat cu metodu za kreiranje saobracajne dozvole
	// ona tamos stvara sve isto kao i vlasnicka, ali dodatno i broj saobracajne dozvole povezuje
	// sa odredjenim vozilom i osobom/vozacem
	private boolean unosSDozvole;
	private boolean unosVDozvole;
	private boolean odjavaSaltera;
	private boolean OKSaobracajnaZaOvjeruRegistracije;
	public SalterskiRadnikController(SalterskiRadnikView view, SalterskiRadnikModel model) {
		super();
		this.view = view;
		this.model = model;
		unosSDozvole = false;
		unosVDozvole = false;
		odjavaSaltera = false;
		OKSaobracajnaZaOvjeruRegistracije = false;
	}
	public void control() {
				
				// Listener za pocetnu
				JButton pocetna= this.view.getMeni().getOpcije().getBtnPocetna();
				pocetna.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						prikaziPanelUnosRegistracije();
						//prikaziPanelPocetnu();
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
									// logika za: unos vlasnicke ili saobracajne posto se ovaj panel pojavljuje :D
									if(isUnosVDozvole() == true)
									{
										prikaziPanelUnosVozila();
									}
									if(isUnosSDozvole() == true)
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
						else{//
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
				
				JButton potvrdaBrojaSaobracajne = this.view.getGodisnjaOvjera().getPretraga().getModifyPanel().getBtnModify();
					potvrdaBrojaSaobracajne.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String brojDozvole = view.getGodisnjaOvjera().getPretraga().getTxtId().getText();
							if(provjeriUneseniBrojSaobracajne(brojDozvole) == true){
								setOKSaobracajnaZaOvjeruRegistracije(true);
								JOptionPane.showOptionDialog(view, "Saobra\u0107ajna postoji.",
										"Godi\u0161nja ovjera registracije", JOptionPane.OK_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null,
										new String[] { "Uredu" }, "default");															
							}
							else{
								view.getGodisnjaOvjera().getPretraga().getTxtId().setText("");
								JOptionPane.showOptionDialog(view, "Saobra\u0107ajna ne postoji, ponovite unos.",
										"Godi\u0161nja ovjera registracije", JOptionPane.OK_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null,
										new String[] { "Uredu" }, "default");	
							}
								
					}
				});
					
				JButton potvrdaOvjereRegistracije= this.view.getGodisnjaOvjera().getDatum().getRegistrationDate().getBtAzuriranje().getBtnModify();
				potvrdaOvjereRegistracije.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String brojDozvole = view.getGodisnjaOvjera().getPretraga().getTxtId().getText();
					if(provjeriUneseniBrojSaobracajne(brojDozvole) == true)
						setOKSaobracajnaZaOvjeruRegistracije(true);
					if(isOKSaobracajnaZaOvjeruRegistracije() == true)
					{
						if(ovjeriRegistraciju(brojDozvole) == true)
						{
							setOKSaobracajnaZaOvjeruRegistracije(false);
							JOptionPane.showOptionDialog(view, "Registracija ovjerena.",
									"Godi\u0161nja Ovjera registracije", JOptionPane.OK_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Uredu" }, "default");															
						
						}
					else{
						view.getGodisnjaOvjera().getPretraga().getTxtId().setText("");
						JOptionPane.showOptionDialog(view, "Gre\u0161ka prilikom upisa u bazu.",
								"Godi\u0161nja ovjera registracije", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");//
					}
					}
					else
					{
						view.getGodisnjaOvjera().getPretraga().getTxtId().setText("");
						JOptionPane.showOptionDialog(view, "Saobra\u0107ajna ne postoji, ponovite unos.",
								"Unos broja saobra\u0107ajne dozvole", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");
					}
							
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
								if(isUnosSDozvole() == true)
									prikaziPanelUnosRegistracije();
								if(isUnosVDozvole() == true)
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
								if(isUnosSDozvole() == true)//
								{
									if (dodajRegistracijuISaobracajnu()) {
										JOptionPane.showOptionDialog(view, "Saobra\u0107ajna dozvola je uspje\u0161no dodana.",
												"Unos saobra\u0107ajne dozvole", JOptionPane.OK_OPTION,
												JOptionPane.INFORMATION_MESSAGE, null,
												new String[] { "Uredu" }, "default");
										
										pocistiPoljaDozvola();
										
										setUnosVDozvole(false);
										setUnosSDozvole(false);
									} else {
										JOptionPane.showOptionDialog(view,
												"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
														+ "Molimo vas da poku\u0161ate ponovo",
												"Unos saobra\u0107ajne dozvole", JOptionPane.OK_OPTION,
												JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
												"default");
									};
								}
								if (isUnosVDozvole() == true)
								{
									if (dodajRegistracijuIVlasnicku()) {
										JOptionPane.showOptionDialog(view, "Vlasni\u010Dke dozvola je uspje\u0161no dodana.",
												"Unos vlasni\u010Dke dozvole", JOptionPane.OK_OPTION,
												JOptionPane.INFORMATION_MESSAGE, null,
												new String[] { "Uredu" }, "default");
										
										pocistiPoljaDozvola();
										
										setUnosSDozvole(false);
										setUnosVDozvole(false);
									} else {
										JOptionPane.showOptionDialog(view,
												"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
														+ "Molimo vas da poku\u0161ate ponovo",
												"Unos vlasni\u010Dke dozvole", JOptionPane.OK_OPTION,
												JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
												"default");
									};
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "Neispravno popunjena polja!");
							};
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				});
				// Listener za ponistavanje unosa registracije
				
				JButton ponistiDodavanjeRegistracije = this.view.getRegistracija().getBtnPoniti();
				ponistiDodavanjeRegistracije.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
							pocistiPoljaRegistracija();
							JOptionPane.showOptionDialog(view, "Unos poni\u0161ten.",
									"Unos registracije", JOptionPane.OK_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Uredu" }, "default");															
					}
				});
				
				//Listener unos vlasnicke
				JButton unosVlasnicke = this.view.getMeni().getOpcije().getBtnUnosVlasnicke();
						unosVlasnicke.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setUnosVDozvole(true);
						prikaziPanelUnosVozaca();
						};			
				});
						
				//Listener unos saobracajne
				JButton unosSaobracajne = this.view.getMeni().getOpcije().getbtnUnosSaobracajne();
						unosSaobracajne.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setUnosSDozvole(true);
						prikaziPanelUnosVozaca();
						};			
				});
						
				//Listener za godisnju ovjeru registracije
				JButton godisnjaRegistracija = this.view.getMeni().getOpcije().getBtnOvjera();
					godisnjaRegistracija.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						prikaziPanelOvjeraRegistracije();
						};			
				});
				//Listener za izvjestaje
				JButton izvjestaji = this.view.getMeni().getOpcije().getBtnIzvjestaji();
				izvjestaji.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						prikaziPanelIzvjestaji();
						};			
				});
				//Listener za odjavu
				JButton odjava = this.view.getMeni().getOpcije().getBtnOdjava();
				odjava.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							if(JOptionPane.showOptionDialog(view, "Eventualne promjene nece biti spa\u0161ene. "
							 		+ "\u017Delite li se odjaviti?",
									"Potvrda odjave", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
									null, new String[] {"Da", "Ne"}, "default")== JOptionPane.OK_OPTION)
								{
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
							view.getStrana6().getBtnIzbrisi().setEnabled(!lsm.isSelectionEmpty());
							view.getStrana6().getBtnProfil().setEnabled(!lsm.isSelectionEmpty());
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
				// Klik na button Izbrisi
				JButton izbrisi = view.getStrana6().getBtnIzbrisi();
				izbrisi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
						izbrisi();
					}
				});	
				
	}
	
	Boolean provjeriUneseniBrojSaobracajne(String brojDozvole)
	{
		return model.provjeriBrojSaobracajne(brojDozvole);
	}
	public void odjaviSkroz()
	{
		if(isOdjavaSaltera() == true)
			this.view.dispose();
	}
	public void pocistiPoljaDozvola()
	{
		view.getRegistracija().getPodaci().getTxtRegistrationString().setText("");
		view.getRegistracija().getPodaci().getTxtId().setText("");
		view.getRegistracija().getPodaci().getTxtConfirmationNumber().setText("");
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
	public void pocistiPoljaRegistracija()
	{
		view.getRegistracija().getPodaci().getTxtRegistrationString().setText("");
		view.getRegistracija().getPodaci().getTxtId().setText("");
		view.getRegistracija().getPodaci().getTxtConfirmationNumber().setText("");
	}
	public Boolean ovjeriRegistraciju(String brojDozvole)
	{
		java.util.Date odKad = (java.util.Date) this.view.getGodisnjaOvjera().getDatum().getRegistrationDate().getDatePickerOdKad().getModel().getValue();
		java.util.Date doKad = (java.util.Date) this.view.getGodisnjaOvjera().getDatum().getRegistrationDate().getDatePickerDoKad().getModel().getValue();
		return model.OvjeriRegistraciju(brojDozvole, odKad, doKad);
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
	public Boolean dodajRegistracijuIVlasnicku() throws ParseException 
	{
		String registracija = view.getRegistracija().getPodaci().getTxtRegistrationString().getText();
		String jmbgKorisnika = view.getRegistracija().getPodaci().getTxtId().getText();
		// nek ga samo uzme
		String brojPotvrde = view.getRegistracija().getPodaci().getTxtConfirmationNumber().getText();
		// dodati date time pickere
//		java.sql.Date selectedDate = (java.sql.Date) datePicker.getModel().getValue();
		java.util.Date oodKad = (java.util.Date) view.getRegistracija().getPodaci().getDatumVazenja().getDatePickerOdKad().getModel().getValue();
		java.util.Date dooKad = (java.util.Date) view.getRegistracija().getPodaci().getDatumVazenja().getDatePickerDoKad().getModel().getValue();
		//Date odKad=new SimpleDateFormat("yyyy-MM-dd").parse("1991-2-1");
		//Date doKad=new SimpleDateFormat("yyyy-MM-dd").parse("1992-2-1");
		
		return model.DodajRegistracijuIVlasnicku(brojPotvrde, registracija, jmbgKorisnika, oodKad, dooKad);
	}
	public Boolean dodajRegistracijuISaobracajnu() throws ParseException 
	{
		String registracija = view.getRegistracija().getPodaci().getTxtRegistrationString().getText();
		String jmbgKorisnika = view.getRegistracija().getPodaci().getTxtId().getText();
		String brojPotvrde = view.getRegistracija().getPodaci().getTxtConfirmationNumber().getText();
		java.util.Date oodKad = (java.util.Date) view.getRegistracija().getPodaci().getDatumVazenja().getDatePickerOdKad().getModel().getValue();
		java.util.Date dooKad = (java.util.Date) view.getRegistracija().getPodaci().getDatumVazenja().getDatePickerDoKad().getModel().getValue();
		
		return model.DodajRegistracijuISaobracajnu(brojPotvrde, registracija, jmbgKorisnika, oodKad, dooKad);
	}
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
			if(model.dohvatiSvaVozila() == null) {
				view.getStrana6().getPanel_vozilo().getModel().clearAll();
				JOptionPane.showOptionDialog(view, "Nije uneseno nijedno vozilo.",
						"Upozorenje.", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
			}
			else view.getStrana6().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
		} else {
			if(model.pretragaVozilo(parametar,kriterij.toString()) == null) {
				view.getStrana6().getPanel_vozilo().getModel().clearAll();
				JOptionPane.showOptionDialog(view, "Nije prona�eno nijedno vozilo s unesenim parametrima.",
						"Upozorenje.", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
			}
			else view.getStrana6().getPanel_vozilo().getModel().addAll(model.pretragaVozilo(parametar,kriterij.toString()));
		}
		view.getStrana6().getTb_unosPretrage().setText("");

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
		view.getStrana6().getTb_unosPretrage().setText("");

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
		view.getStrana6().getTb_unosPretrage().setText("");

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
		view.getStrana6().getTb_unosPretrage().setText("");
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
	public boolean provjeriPopunjenostVozaca() {
		return true;
	}
	void prikaziPanelIzvjestaji()
	{
		view.prikaziIzvjestaje();
	}
	void prikaziPanelOvjeraRegistracije()
	{
		view.prikaziOvjeruRegistracije();
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
		if(!daLiJeBroj(view.getVoziloDodavanje().getTf_sjedenje().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTf_stajanje().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTf_lezanje().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTb_maxMasa().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTb_masa().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTb_nosivost().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTb_maxMasa().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTb_masa().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTb_nosivost().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTf_zapremina().getText())) return false;
		if(!daLiJeBroj(view.getVoziloDodavanje().getTf_maxSnaga().getText())) return false;
		return true;
	}
	public boolean daLiJeBroj(String string) {
		String regex = "\\d+";
		return Pattern.compile(regex).matcher(string).matches();
	}
	public boolean daLiJeDecimalanBroj(String string) {
		String regex= "^\\d+(.\d+){0,1}$";
		return Pattern.compile(regex).matcher(string).matches();
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
		int godinaProizvodnje = view.getVoziloDodavanje().getDatePickerGodina().getModel().getYear();
		
		String registarske = (String)view.getVoziloDodavanje().getTf_regOznaka().getText();
		//
		Double odnosSnageIMase = Double.parseDouble(view.getVoziloDodavanje().getTf_odnos().getText());
		int brojMjestaZaSjedenje = Integer.parseInt(view.getVoziloDodavanje().getTf_sjedenje().getText());
		int brojMjestaZaStajanje =  Integer.parseInt(view.getVoziloDodavanje().getTf_stajanje().getText()); 
		int brojMjestaZaLezanje =  Integer.parseInt(view.getVoziloDodavanje().getTf_lezanje().getText()); 
		
		EkoKarakteristike ekoKarakteristika =(EkoKarakteristike)view.getVoziloDodavanje().getCb_ekoKarakteristike().getSelectedItem();
		boolean katalizator = view.getVoziloDodavanje().getRb_katalizator_da().isSelected();
		String oblikKaroserije = view.getVoziloDodavanje().getTf_karoserija().getText();
		java.util.Date datumPregleda= (Date) view.getVoziloDodavanje().getDatePickerDatumPregleda().getModel().getValue();
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
	
	public boolean isUnosSDozvole() {
		return unosSDozvole;
	}
	public void setUnosSDozvole(boolean dozvola) {
		this.unosSDozvole = dozvola;
	}
	public boolean isUnosVDozvole() {
		return unosVDozvole;
	}
	public void setUnosVDozvole(boolean dozvola) {
		this.unosVDozvole = dozvola;
	}
	public boolean isOdjavaSaltera() {
		return odjavaSaltera;
	}
	public void setOdjavaSaltera(boolean odjavaSaltera) {
		this.odjavaSaltera = odjavaSaltera;
	}
	public boolean isOKSaobracajnaZaOvjeruRegistracije() {
		return OKSaobracajnaZaOvjeruRegistracije;
	}
	public void setOKSaobracajnaZaOvjeruRegistracije(
			boolean oKSaobracajnaZaOvjeruRegistracije) {
		OKSaobracajnaZaOvjeruRegistracije = oKSaobracajnaZaOvjeruRegistracije;
	}
}
