package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.RegistracijaDAO;
import ba.co.edgewise.jmup.daldao.daos.SaobracajnaDAO;
import ba.co.edgewise.jmup.daldao.daos.VlasnickaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.SaobracajnaPretraga;
import ba.co.edgewise.jmup.enums.VlasnickaPretraga;
import ba.co.edgewise.jmup.enums.VozacPretraga;
import ba.co.edgewise.jmup.enums.VoziloPretraga;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Registracija;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;
import ba.co.edgewise.jmup.mvc.views.Login;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class SalterskiRadnikController {

	private SalterskiRadnikModel model;
	private SalterskiRadnikView view;

	// Moram imati dva pokazatelja o kojoj se dozvoli radi
	// Ako se redno unosi saobracajna, varijabla unosSDozvole je na true
	// tako znam i koju cu DAOmetodu za kreiranje dozvole pozvati
	// Mozam ih razlikovati jer ako je unosSDozvole true pozvat cu metodu za
	// kreiranje saobracajne dozvole
	// ona tamos stvara sve isto kao i vlasnicka, ali dodatno i broj saobracajne
	// dozvole povezuje
	// sa odredjenim vozilom i osobom/vozacem
	private boolean unosSDozvole;
	private boolean unosVDozvole;
	private boolean odjavaSaltera;
	private boolean OKSaobracajnaZaOvjeruRegistracije;
	// Kada se redno unosi saobracajna ili vlascnicka, moraju se pamtiti vrijednosti ID_jmbg-eva
	private String idOsobaSaobracajnaUnos;
	private String idOsobaVlasnickaUnos;
	
	private int idVoziloSaobracajnaUnos;
	private int idVoziloVlasnickaUnos;
	public SalterskiRadnikController(SalterskiRadnikView view,
			SalterskiRadnikModel model) {
		super();
		this.view = view;
		this.model = model;
		unosSDozvole = false;
		unosVDozvole = false;
		odjavaSaltera = false;
		OKSaobracajnaZaOvjeruRegistracije = false;
		
		// Ako nisu settovani bit ce na -1
		idOsobaSaobracajnaUnos = "-1";
		idOsobaVlasnickaUnos = "-1";
		idVoziloSaobracajnaUnos = -1;
		idVoziloVlasnickaUnos = -1;
	}

	public void control() {

		// Listener za pocetnu
		JButton pocetna = this.view.getMeni().getOpcije().getBtnPocetna();
		pocetna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prikaziPanelPocetnu();
				setIdOsobaVlasnickaUnos("-1");
				setIdOsobaSaobracajnaUnos("-1");
				setIdVoziloVlasnickaUnos(-1);
				setIdVoziloSaobracajnaUnos(-1);
			};

		});
		// Listener za unos vozaca
		JButton unosVozaca = this.view.getMeni().getOpcije().getBtnUnosVozaca();
		unosVozaca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pocistiPoljaVozac();
				prikaziPanelUnosVozaca();
				
			};

		});
		
		// Listener za provjeru postojanja vozaca
		JButton provjeraPostojanjaVozaca = this.view.getStrana2().getBtnProvjeri();
		provjeraPostojanjaVozaca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				provjeriVozacaUBazi();
			};

		});
		// Listener za provjeru postojanja vozaca
				JButton provjeraPostojanjaVozila= this.view.getVoziloDodavanje().getBtnProvjeriPostojanje();
				provjeraPostojanjaVozila.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						provjeriVozilaUBazi();
					};

				});
		
		// Listener za dodavanjeVozaca
		JButton dodavanjeVozaca = this.view.getStrana2().getBtnPrihvati();
		dodavanjeVozaca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (provjeriPopunjenostVozaca()) {
					if(getIdOsobaSaobracajnaUnos() != "-1" || getIdOsobaVlasnickaUnos() != "-1"){
						JOptionPane.showOptionDialog(view,
								"Voza\u010D uspje\u0161no prihva\u0107en.",
								"Unos voza\u010Da", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");
						pocistiPoljaVozac();
						if (isUnosVDozvole() == true) {
							prikaziPanelUnosVozila();
						}
						if (isUnosSDozvole() == true) {
							prikaziPanelUnosVozila();
						}
					}
					else {
						OsobaDAO oDAO = new OsobaDAO();
						if(view.getStrana2().getFizicko().isSelected()){
								if(oDAO.getByJMBG(view.getStrana2().getTfJMBG().getText()) != null) {
								JOptionPane.showOptionDialog(view,
									"Osoba postoji u bazi podataka.",
									"Unos voza\u010D", JOptionPane.OK_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Uredu" }, "default");
									return;
						}
						else{
							if(oDAO.getByJMBG(view.getStrana2().getTfIdBroj().getText()) != null){
								JOptionPane.showOptionDialog(view,
										"Osoba postoji u bazi podataka.",
										"Unos voza\u010D", JOptionPane.OK_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null,
										new String[] { "Uredu" }, "default");
									return;
							}
						}
															
						}
						if(dodajVozaca()){
								JOptionPane.showOptionDialog(view,
										"Voza\u010D uspje\u0161no dodan.",
										"Unos voza\u010Da", JOptionPane.OK_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null,
										new String[] { "Uredu" }, "default");
								
								// logika za: unos vlasnicke ili saobracajne posto se
								// ovaj panel pojavljuje :D
								if (isUnosVDozvole() == true) {
									if (view.getStrana2().getPravno().isSelected() == true) {
										String idBroj = view.getStrana2().getTfIdBroj().getText();
										setIdOsobaVlasnickaUnos(idBroj);
									} else {
										String jmbg = view.getStrana2().getTfJMBG().getText();
										setIdOsobaVlasnickaUnos(jmbg);
									}
									prikaziPanelUnosVozila();
								}
								if (isUnosSDozvole() == true) {
									prikaziPanelUnosVozila();
								}
								pocistiPoljaVozac();
							} else {
								JOptionPane.showOptionDialog(view,
										"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
												+ "Molimo vas da poku\u0161ate ponovo",
										"Unos voza\u010Da", JOptionPane.OK_OPTION,
										JOptionPane.ERROR_MESSAGE, null,
										new String[] { "Uredu" }, "default");
							}
					}
			}}});

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
		JButton ponistiDodavanjeVozila = this.view.getVoziloDodavanje().getBtn_ponisti();
		ponistiDodavanjeVozila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pocistiPoljaVozilo();
				JOptionPane.showOptionDialog(view, "Unos poni\u0161ten.",
						"Unos voza\u010Da", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
			}
		});
		JButton potvrdaBrojaSaobracajne = this.view.getGodisnjaOvjera()
				.getPretraga().getModifyPanel().getBtnModify();
		potvrdaBrojaSaobracajne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String brojDozvole = view.getGodisnjaOvjera().getPretraga()
						.getTxtId().getText();
				if (provjeriUneseniBrojSaobracajne(brojDozvole) == true) {
					setOKSaobracajnaZaOvjeruRegistracije(true);
					JOptionPane.showOptionDialog(view,
							"Saobra\u0107ajna postoji.",
							"Godi\u0161nja ovjera registracije",
							JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "Uredu" }, "default");
				} else {
					view.getGodisnjaOvjera().getPretraga().getTxtId()
							.setText("");
					JOptionPane.showOptionDialog(view,
							"Saobra\u0107ajna ne postoji, ponovite unos.",
							"Godi\u0161nja ovjera registracije",
							JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "Uredu" }, "default");
				}

			}
		});

		JButton potvrdaOvjereRegistracije = this.view.getGodisnjaOvjera()
				.getDatum().getRegistrationDate().getBtAzuriranje()
				.getBtnModify();
		potvrdaOvjereRegistracije.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String brojDozvole = view.getGodisnjaOvjera().getPretraga()
						.getTxtId().getText();
				if (provjeriUneseniBrojSaobracajne(brojDozvole) == true)
					setOKSaobracajnaZaOvjeruRegistracije(true);
				if (isOKSaobracajnaZaOvjeruRegistracije() == true
						&& provjeriPopunjenostDatumaZaOvjeruRegistracije() == true) {
					if (ovjeriRegistraciju(brojDozvole) == true) {
						setOKSaobracajnaZaOvjeruRegistracije(false);
						JOptionPane.showOptionDialog(view,
								"Registracija ovjerena.",
								"Godi\u0161nja Ovjera registracije",
								JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");

					} else {
						view.getGodisnjaOvjera().getPretraga().getTxtId()
								.setText("");
						JOptionPane.showOptionDialog(view,
								"Gre\u0161ka prilikom upisa u bazu.",
								"Godi\u0161nja ovjera registracije",
								JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");//
					}
				} else {
					view.getGodisnjaOvjera().getPretraga().getTxtId()
							.setText("");
					JOptionPane.showOptionDialog(view,
							"Saobra\u0107ajna ne postoji, ponovite unos.",
							"Unos broja saobra\u0107ajne dozvole",
							JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "Uredu" }, "default");
				}

			}
		});

		// Promjena vlasnika
		JButton promVlasnika = this.view.getMeni().getOpcije()
				.getBtnPromjenaVlasnika();
		promVlasnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				view.prikaziPromjenuVlasnika();
			};
		});

		// Azuriranje podataka o promjeni vlasnika
		JButton azurirajVlasnika = this.view.getPromjenaVlasnika()
				.getBtnAzurirajPodatke();
		azurirajVlasnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (provjeriPopunjenostZaPromjenuVlasnika()) {

					if (promijeniVlasnika()) {
						JOptionPane.showOptionDialog(view,
								"Vlasnik uspje\u0161no promijenjen.",
								"Promjena vlasnika", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");
						pocistiPoljaZaPromjenuVlasnika();

					} else {
						JOptionPane.showOptionDialog(view,
								"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
										+ "Molimo vas da poku\u0161ate ponovo",
								"Promjena vlasnika", JOptionPane.OK_OPTION,
								JOptionPane.ERROR_MESSAGE, null,
								new String[] { "Uredu" }, "default");
					}
					;

				} else {//
					JOptionPane.showMessageDialog(null,
							"Neispravno popunjena polja!");
				}
				;
			}
		});

		JButton ponistiPromjenuVlasnika = this.view.getPromjenaVlasnika()
				.getBtnPonisti();
		ponistiPromjenuVlasnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pocistiPoljaZaPromjenuVlasnika();
				JOptionPane.showOptionDialog(view, "Unos poni\u0161ten.",
						"Promjena vlasnika", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
			}
		});

		// UNOS VOZILA
		JButton unosVozila = this.view.getMeni().getOpcije().getBtnUnosVozila();
		unosVozila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prikaziPanelUnosVozila();
			};
		});

		JButton dodavanje_vozila = this.view.getVoziloDodavanje()
				.getBtn_prihvati();
		dodavanje_vozila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(getIdVoziloVlasnickaUnos()!=-1 || getIdVoziloSaobracajnaUnos()!=-1)
					{
						if (isUnosVDozvole() == true){
							if(provjeriPostojanjeVlasnicke()==false){
								JOptionPane.showOptionDialog(view,
										"Vozilo je uspje\u0161no prihva\u0107eno.",
										"Unos vozila", JOptionPane.OK_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null,
										new String[] { "Uredu" }, "default");
									
								prikaziPanelUnosRegistracije();
							}
						}
						else if (isUnosSDozvole() == true){
							if(provjeriPostojanjeSaobracajne()==false){
								JOptionPane.showOptionDialog(view,
										"Vozilo je uspje\u0161no prihva\u0107eno.",
										"Unos vozila", JOptionPane.OK_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null,
										new String[] { "Uredu" }, "default");
									prikaziPanelUnosRegistracije();
							}
						}
					}
					else if (provjeriPopunjenostUnosVozila()) {
						if (dodajVozilo()) {
							JOptionPane.showOptionDialog(view,
									"Vozilo uspje\u0161no dodano.",
									"Unos voza\u010Da", JOptionPane.OK_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Uredu" }, "default");

							if (isUnosSDozvole() == true){
								String reg= view.getVoziloDodavanje().getTf_regOznaka().getText();
								VoziloDAO vDAO = new VoziloDAO();
								Vozilo v = vDAO.getByReg(reg);
								setIdVoziloSaobracajnaUnos(v.getId());
								prikaziPanelUnosRegistracije();
							}
							else if (isUnosVDozvole() == true){
								String reg= view.getVoziloDodavanje().getTf_regOznaka().getText();
								VoziloDAO vDAO = new VoziloDAO();
								Vozilo v = vDAO.getByReg(reg);
								setIdVoziloVlasnickaUnos(v.getId());
								prikaziPanelUnosRegistracije();
							}
						} 
						else {
							JOptionPane.showOptionDialog(view,
									"Gre\u0161ka prilikom upisa u bazu.",
									"Godi\u0161nja ovjera registracije",
									JOptionPane.OK_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Uredu" }, "default");//
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// Ptvrda datuma o registraciji
		JButton potvrdiDatumReg = this.view.getRegistracija().getPodaci()
				.getDatumVazenja().getBtAzuriranje().getBtnModify();
		// dodavanje registracije
		potvrdiDatumReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				provjeriPopunjenostDatumaZaUnosRegistracije();

			}
		});
		JButton dodavanjeRegistracije = this.view.getRegistracija()
				.getBtnPrihvati();
		dodavanjeRegistracije.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (provjeriPopunjenostRegistracije()) {
						if (isUnosSDozvole() == true)//
						{
							if (dodajRegistracijuISaobracajnu()) {
								JOptionPane
										.showOptionDialog(
												view,
												"Saobra\u0107ajna dozvola je uspje\u0161no dodana.",
												"Unos saobra\u0107ajne dozvole",
												JOptionPane.OK_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null, new String[] { "Uredu" },
												"default");

								pocistiPoljaDozvola();

								setUnosVDozvole(false);
								setUnosSDozvole(false);
							} else {
								JOptionPane
										.showOptionDialog(
												view,
												"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
														+ "Molimo vas da poku\u0161ate ponovo",
												"Unos saobra\u0107ajne dozvole",
												JOptionPane.OK_OPTION,
												JOptionPane.ERROR_MESSAGE,
												null, new String[] { "Uredu" },
												"default");
							}
							;
						}
						if (isUnosVDozvole() == true) {
							if (dodajRegistracijuIVlasnicku()) {
								JOptionPane
										.showOptionDialog(
												view,
												"Vlasni\u0107ka dozvola je uspje\u0161no dodana.",
												"Unos vlasni\u0107ke dozvole",
												JOptionPane.OK_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null, new String[] { "Uredu" },
												"default");
								pocistiPoljaDozvola();

								setUnosSDozvole(false);
								setUnosVDozvole(false);
							} else {
								JOptionPane
										.showOptionDialog(
												view,
												"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
														+ "Molimo vas da poku\u0161ate ponovo",
												"Unos vlasni\u010Dke dozvole",
												JOptionPane.OK_OPTION,
												JOptionPane.ERROR_MESSAGE,
												null, new String[] { "Uredu" },
												"default");
							}
							;
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Neispravno popunjena polja!");
					}
					;
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		// Listener za ponistavanje unosa registracije

		JButton ponistiDodavanjeRegistracije = this.view.getRegistracija()
				.getBtnPoniti();
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

		// Listener unos vlasnicke
		JButton unosVlasnicke = this.view.getMeni().getOpcije()
				.getBtnUnosVlasnicke();
		unosVlasnicke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setUnosVDozvole(true);
				prikaziPanelUnosVozaca();
			};
		});

		// Listener unos saobracajne
		JButton unosSaobracajne = this.view.getMeni().getOpcije()
				.getbtnUnosSaobracajne();
		unosSaobracajne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setUnosSDozvole(true);
				prikaziPanelUnosVozaca();
			};
		});

		// Listener za godisnju ovjeru registracije
		JButton godisnjaRegistracija = this.view.getMeni().getOpcije()
				.getBtnOvjera();
		godisnjaRegistracija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prikaziPanelOvjeraRegistracije();
			};
		});
		// Listener za izvjestaje
		JButton izvjestaji = this.view.getMeni().getOpcije().getBtnIzvjestaji();
		izvjestaji.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prikaziPanelIzvjestaji();
			};
		});
		// Listener za odjavu
		JButton odjava = this.view.getMeni().getOpcije().getBtnOdjava();
		odjava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (JOptionPane.showOptionDialog(view,
							"Eventualne promjene ne\u0107e biti spa\u0161ene. "
									+ "\u017Delite li se odjaviti?",
							"Potvrda odjave", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, new String[] {
									"Da", "Ne" }, "default") == JOptionPane.OK_OPTION) {

						setOdjavaSaltera(true);
						odjaviSkroz();
						Login view = new Login();
						LoginModel model = new LoginModel();
						LoginController controler = new LoginController(view,
								model);
						controler.control();
					}

				} catch (Exception izuzetak) {
					izuzetak.printStackTrace();
				}
			};
		});
		// PRETRAGA
		// Pretraga - Prikaz osnovnog panela
		JButton salterskaPretraga = this.view.getMeni().getOpcije()
				.getBtnPretraga();
		salterskaPretraga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prikaziPanelPretraga();
				view.getStrana6().getBtn_modifikuj().setEnabled(false);
			};

		});
		// Pretraga - Prikaz panela Vozilo
		final JRadioButton rbVozilo = this.view.getStrana6().getRbVozilo();
		rbVozilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbVozilo.isSelected()) {
					prikaziPanelPretragaVozila();
					view.getStrana6().getBtn_modifikuj().setEnabled(false);
				}
			};
		});
		// Pretraga - Prikaz panela Vozac
		final JRadioButton rbVozac = this.view.getStrana6().getRbVozac();
		rbVozac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbVozac.isSelected()) {
					prikaziPanelPretragaVozaca();
					view.getStrana6().getBtn_modifikuj().setEnabled(false);
				}
			};
		});
		// Pretraga - Prikaz panela Saobracajna
		final JRadioButton rbSaobracajna = this.view.getStrana6()
				.getRbSaobracajna();
		rbSaobracajna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbSaobracajna.isSelected()) {
					prikaziPanelPretragaSaobracajnih();
					view.getStrana6().getBtn_modifikuj().setEnabled(false);
				}
			};
		});
		// Pretraga - Prikaz panela Vlasnicka
		final JRadioButton rbVlasnicka = this.view.getStrana6()
				.getRbVlasnicka();
		rbVlasnicka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbVlasnicka.isSelected()) {
					prikaziPanelPretragaVlasnickih();
				}
			};
		});
		// Pretraga - Tabela Vozilo - omogucavanje buttona Modifikacija
		JTable tableVozilo = view.getStrana6().getPanel_vozilo().getTable();
		tableVozilo.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						ListSelectionModel lsm = (ListSelectionModel) e
								.getSource();
						view.getStrana6().getBtn_modifikuj()
								.setEnabled(!lsm.isSelectionEmpty());
						// view.getStrana6().getBtnIzbrisiKorisnika().setEnabled(!lsm.isSelectionEmpty());
					}
				});

		// Pretraga - Tabela Vozac - omogucavanje buttona Modifikacija
		JTable tableVozac = view.getStrana6().getPanel_vozac().getTable();
		tableVozac.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						ListSelectionModel lsm = (ListSelectionModel) e
								.getSource();
						view.getStrana6().getBtn_modifikuj()
								.setEnabled(!lsm.isSelectionEmpty());
						// view.getStrana6().getBtnIzbrisiKorisnika().setEnabled(!lsm.isSelectionEmpty());
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
		// Klik na radio button pravno
		view.getStrana2().getPravno().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getStrana2().getTfJMBG().setEnabled(false);
				view.getStrana2().getTfJMBG().setEditable(false);
				view.getStrana2().getTfIdBroj().setEnabled(true);
				view.getStrana2().getTfIdBroj().setEditable(true);
			}
		});
		// Klik na radio button fizicko
		view.getStrana2().getFizicko().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getStrana2().getTfJMBG().setEnabled(true);
				view.getStrana2().getTfJMBG().setEditable(true);
				view.getStrana2().getTfIdBroj().setEnabled(false);
				view.getStrana2().getTfIdBroj().setEditable(false);

			}
		});

		// Klik na radio button pravno - Modifikacija
		view.getStrana11().getPravno().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getStrana11().getTfJMBG().setEnabled(false);
				view.getStrana11().getTfJMBG().setEditable(false);
				view.getStrana11().getTfIdBroj().setEnabled(true);
				view.getStrana11().getTfIdBroj().setEditable(true);
			}
		});
		// Klik na radio button fizicko - Modifikacija
		view.getStrana11().getFizicko().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getStrana11().getTfJMBG().setEnabled(true);
				view.getStrana11().getTfJMBG().setEditable(true);
				view.getStrana11().getTfIdBroj().setEnabled(false);
				view.getStrana11().getTfIdBroj().setEditable(false);

			}
		});

	}
		Boolean promijeniVlasnika() {
		return model.PromijeniVlasnika(view.getPromjenaVlasnika()
				.getTfBrojVlasnickeDozvole().getText(), view
				.getPromjenaVlasnika().getTfJMBGNovogVlasnika().getText());
	}

	void pocistiPoljaZaPromjenuVlasnika() {
		view.getPromjenaVlasnika().getTfBrojVlasnickeDozvole().setText("");
		view.getPromjenaVlasnika().getTfJMBGNovogVlasnika().setText("");
	}

	Boolean provjeriPopunjenostZaPromjenuVlasnika() {
		OsobaDAO oDAO = new OsobaDAO();
		Osoba o = oDAO.getByJMBG(view.getPromjenaVlasnika()
				.getTfJMBGNovogVlasnika().getText());
		if (o.getJmbg_Id() != view.getPromjenaVlasnika()
				.getTfJMBGNovogVlasnika().getText()) {

			JOptionPane.showOptionDialog(view,
					"Uneseni JMBG ne postoji u bazi podataka.",
					"Promjena vlasnika", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			pocistiPoljaZaPromjenuVlasnika();
			return false;
		}

		VlasnickaDAO vlDAO = new VlasnickaDAO();
		Vlasnicka v = vlDAO.get(view.getPromjenaVlasnika()
				.getTfBrojVlasnickeDozvole().getText());
		if (v.getBrojDozvole() != view.getPromjenaVlasnika()
				.getTfBrojVlasnickeDozvole().getText()) {
			JOptionPane.showOptionDialog(view,
					"Uneseni broj dozvole ne postoji u bazi podataka.",
					"Promjena vlasnika", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			pocistiPoljaZaPromjenuVlasnika();
			return false;
		}
		return true;
	}

	Boolean provjeriUneseniBrojSaobracajne(String brojDozvole) {
		return model.provjeriBrojSaobracajne(brojDozvole);
	}

	public void odjaviSkroz() {
		if (isOdjavaSaltera() == true)
			this.view.dispose();
	}

	public void pocistiPoljaDozvola() {
		view.getRegistracija().getPodaci().getTxtRegistrationString()
				.setText("");
		view.getRegistracija().getPodaci().getTxtId().setText("");
		view.getRegistracija().getPodaci().getTxtConfirmationNumber()
				.setText("");
	}

	public void pocistiPoljaVozac() {
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
	public void postaviPoljaVozac(Osoba osoba){
		view.getStrana2().getTfIme().setText(osoba.getIme());
		view.getStrana2().getTfPrezime().setText(osoba.getPrezime());
		view.getStrana2().getTfAdresa().setText(osoba.getPrebivaliste());
		view.getStrana2().getTfMjesto().setText(osoba.getPrebivaliste());
		view.getStrana2().getTfOpcina().setText(osoba.getPrebivaliste());
		if(view.getStrana2().getFizicko().isSelected())
			view.getStrana2().getTfJMBG().setText(osoba.getJmbg_Id());
		else
			view.getStrana2().getTfIdBroj().setText(osoba.getJmbg_Id());
		view.getStrana2().getPravno().setSelected(false);
		view.getStrana2().getFizicko().setSelected(false);
	}
	public void pocistiPoljaRegistracija() {
		view.getRegistracija().getPodaci().getTxtRegistrationString()
				.setText("");
		view.getRegistracija().getPodaci().getTxtId().setText("");
		view.getRegistracija().getPodaci().getTxtConfirmationNumber()
				.setText("");
	}

	public Boolean ovjeriRegistraciju(String brojDozvole) {
		java.util.Date odKad = (java.util.Date) this.view.getGodisnjaOvjera()
				.getDatum().getRegistrationDate().getDatePickerOdKad()
				.getModel().getValue();
		java.util.Date doKad = (java.util.Date) this.view.getGodisnjaOvjera()
				.getDatum().getRegistrationDate().getDatePickerDoKad()
				.getModel().getValue();
		return model.OvjeriRegistraciju(brojDozvole, odKad, doKad);
	}

	public Boolean dodajVozaca() {
		// Pokupimo sve iz popunjenih polja, pozovemo metodu iz modela kojoj
		// proslijedimo podatke
		// da ih smjesti u bazu.
		boolean pravno;
		String ime = view.getStrana2().getTfIme().getText();
		String prezime = view.getStrana2().getTfPrezime().getText();
		String adresa = view.getStrana2().getTfAdresa().getText();
		String mjesto = view.getStrana2().getTfMjesto().getText();
		String opcina = view.getStrana2().getTfOpcina().getText();
		if (view.getStrana2().getPravno().isSelected() == true) {
			pravno = true;
			String idBroj = view.getStrana2().getTfIdBroj().getText();
			return model.DodajVozaca(ime, prezime, adresa, mjesto, opcina,
					pravno, idBroj);
		} else {
			pravno = false;
			String jmbg = view.getStrana2().getTfJMBG().getText();
			return model.DodajVozaca(ime, prezime, adresa, mjesto, opcina,
					pravno, jmbg);
		}
	}

	public Boolean dodajRegistracijuIVlasnicku() throws ParseException {
		String registracija = view.getRegistracija().getPodaci()
				.getTxtRegistrationString().getText();
		String jmbgKorisnika = view.getRegistracija().getPodaci().getTxtId()
				.getText();
		// nek ga samo uzme
		String brojPotvrde = view.getRegistracija().getPodaci()
				.getTxtConfirmationNumber().getText();
		// dodati date time pickere
		// java.sql.Date selectedDate = (java.sql.Date)
		// datePicker.getModel().getValue();
		java.util.Date oodKad = (java.util.Date) view.getRegistracija()
				.getPodaci().getDatumVazenja().getDatePickerOdKad().getModel()
				.getValue();
		java.util.Date dooKad = (java.util.Date) view.getRegistracija()
				.getPodaci().getDatumVazenja().getDatePickerDoKad().getModel()
				.getValue();
		// Date odKad=new SimpleDateFormat("yyyy-MM-dd").parse("1991-2-1");
		// Date doKad=new SimpleDateFormat("yyyy-MM-dd").parse("1992-2-1");

		OsobaDAO oDAO = new OsobaDAO();
		Osoba o = oDAO.getByJMBG(jmbgKorisnika);
		VoziloDAO vDAO = new VoziloDAO();
		Vozilo v = vDAO.getByReg(registracija);
		VlasnickaDAO sDAO = new VlasnickaDAO();
		RegistracijaDAO rDAO = new RegistracijaDAO();

		if (o.getJmbg_Id() == null) {
			JOptionPane.showOptionDialog(view,
					"Uneseni JMBG ne postoji u bazi podataka.",
					"Dodavanje registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			pocistiPoljaZaPromjenuVlasnika();
			return false;
		}

		else if (v.getId() == null) {
			JOptionPane.showOptionDialog(view,
					"Unesena registracija ne postoji u bazi podataka.",
					"Dodavanje registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			pocistiPoljaZaPromjenuVlasnika();
			return false;
		} else {
			
			// za da postoji jedna vlasnicka
						ArrayList<Vlasnicka> vlasnicke = sDAO.getAll();
						for (Vlasnicka s : vlasnicke) {
							if (s.getVozilo().getRegOznaka().equals(registracija)) {
								JOptionPane
										.showOptionDialog(
												view,
												"Unesena vlasnicka dozvola za ovo vozilo vec postoji u bazi podataka.",
												"Dodavanje vlasnicke",
												JOptionPane.OK_OPTION,
												JOptionPane.INFORMATION_MESSAGE, null,
												new String[] { "Uredu" }, "default");
								pocistiPoljaZaPromjenuVlasnika();
								return false;
							}
						}
						
			ArrayList<Registracija> registracije = rDAO.getAll();
			for (Registracija r : registracije) {
				if (r.getOsoba().getJmbg_Id().equals(jmbgKorisnika)
						&& r.getRegistarskaOznaka().equals(registracija)) {
					/*
					 * JOptionPane.showOptionDialog(view,
					 * "Unesena registracija vec postoji u bazi podataka.",
					 * "Dodavanje registracije", JOptionPane.OK_OPTION,
					 * JOptionPane.INFORMATION_MESSAGE, null, new String[] {
					 * "Uredu" }, "default");
					 */
					pocistiPoljaZaPromjenuVlasnika();
					return model.DodajVlasnicku(brojPotvrde, registracija,
							jmbgKorisnika);
				}
			}

			
			return model.DodajRegistracijuIVlasnicku(brojPotvrde, registracija,
					jmbgKorisnika, oodKad, dooKad);
		}
	}

	public Boolean dodajRegistracijuISaobracajnu() throws ParseException {
		String registracija = view.getRegistracija().getPodaci()
				.getTxtRegistrationString().getText();
		String jmbgKorisnika = view.getRegistracija().getPodaci().getTxtId()
				.getText();
		String brojPotvrde = view.getRegistracija().getPodaci()
				.getTxtConfirmationNumber().getText();
		java.util.Date oodKad = (java.util.Date) view.getRegistracija()
				.getPodaci().getDatumVazenja().getDatePickerOdKad().getModel()
				.getValue();
		java.util.Date dooKad = (java.util.Date) view.getRegistracija()
				.getPodaci().getDatumVazenja().getDatePickerDoKad().getModel()
				.getValue();
		OsobaDAO oDAO = new OsobaDAO();
		Osoba o = oDAO.getByJMBG(view.getRegistracija().getPodaci().getTxtId()
				.getText());
		VoziloDAO vDAO = new VoziloDAO();
		Vozilo v = vDAO.getByReg(registracija);
		RegistracijaDAO rDAO = new RegistracijaDAO();
		SaobracajnaDAO sDAO = new SaobracajnaDAO();

		if (o.getJmbg_Id() == null) {
			JOptionPane.showOptionDialog(view,
					"Uneseni JMBG ne postoji u bazi podataka.",
					"Dodavanje registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			pocistiPoljaZaPromjenuVlasnika();
			return false;
		}

		else if (v.getId() == null) {
			JOptionPane.showOptionDialog(view,
					"Unesena registracija ne postoji u bazi podataka.",
					"Dodavanje registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			pocistiPoljaZaPromjenuVlasnika();
			return false;
		} else {
			
			// za da postoji jedna saobracajna
						ArrayList<Saobracajna> saobracajne = sDAO.getAll();
						for (Saobracajna s : saobracajne) {
							if (s.getVozilo().getRegOznaka().equals(registracija)) {
								JOptionPane
										.showOptionDialog(
												view,
												"Saobracajna za ovo vozilo vec postoji u bazi podataka.",
												"Dodavanje vlasnicke",
												JOptionPane.OK_OPTION,
												JOptionPane.INFORMATION_MESSAGE, null,
												new String[] { "Uredu" }, "default");
								pocistiPoljaZaPromjenuVlasnika();
								return false;
							}
						}
			
			ArrayList<Registracija> registracije = rDAO.getAll();
			for (Registracija r : registracije) {
				if (r.getOsoba().getJmbg_Id().equals(jmbgKorisnika)
						&& r.getRegistarskaOznaka().equals(registracija)) {
					/*
					 * JOptionPane.showOptionDialog(view,
					 * "Unesena registracija vec postoji u bazi podataka.",
					 * "Dodavanje registracije", JOptionPane.OK_OPTION,
					 * JOptionPane.INFORMATION_MESSAGE, null, new String[] {
					 * "Uredu" }, "default");
					 */
					pocistiPoljaZaPromjenuVlasnika();
					return model.DodajSaobracajnu(brojPotvrde, registracija,
							jmbgKorisnika);
				}
			}

			return model.DodajRegistracijuISaobracajnu(brojPotvrde,
					registracija, jmbgKorisnika, oodKad, dooKad);
		}
	}

	

	void prikaziPanelIzvjestaji() {
		view.prikaziIzvjestaje();
	}

	void prikaziPanelOvjeraRegistracije() {
		view.prikaziOvjeruRegistracije();
	}

	// Prikazi za buttone iz menija:
	void prikaziPanelUnosRegistracije() {
		view.prikaziUnosRegistracije();
	}

	void prikaziPanelUnosVozaca() {
		view.prikaziUnosVozaca();
	}

	void prikaziPanelPocetnu() {
		view.prikaziPocetnu();
	}

	// VOZILO
	void prikaziPanelUnosVozila() {
		view.prikaziUnosVozila();
	}

	@SuppressWarnings("deprecation")
	public boolean provjeriPopunjenostUnosVozila() {
		String ip = "^[A-z]+$";
		String no = "^\\d+$";

		if (!view.getVoziloDodavanje().getTf_tipVozila().getText().matches(ip)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli tip vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_modelVozila().getText()
				.matches(ip)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli model vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_markaVozila().getText()
				.matches(ip)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli marku vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_godProizvodnje().getText()
				.matches("^(\\d{4})$")) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli godinu proizvodnje vozila.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_odnos().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli odnos snage i mase vozila.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_sjedenje().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj mjesta za sjedenje.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_stajanje().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj mjesta za stajanje.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_lezanje().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj mjesta za lezanje.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_karoserija().getText()
				.matches(ip)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli karoseriju za vozilo.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_brojSasije().getText()
				.matches("^[a-zA-Z0-9]+$")) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj  \u0161asije vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_zapremina().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre \u0161no ste unijeli zapreminu motora.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_maxSnaga().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli max snagu motora.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTf_brojMotora().getText()
				.matches("^[a-zA-Z0-9]+$")) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj motora.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTb_bojaVozila().getText()
				.matches(ip)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli boju vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTb_maxMasa().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli max dozvoljenu masu vozila.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTb_masa().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli masu vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getVoziloDodavanje().getTb_nosivost().getText()
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli dopustivu nosivost za vozilo.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}

		Date d = new Date();
		if (Integer.parseInt(view.getVoziloDodavanje().getTf_godProizvodnje()
				.getText()) <= 1900
				&& Integer.parseInt(view.getVoziloDodavanje()
						.getTf_godProizvodnje().getText()) > d.getYear()) {
			JOptionPane.showOptionDialog(view,
					"Morate unijeti validnu godinu.", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		}
		java.util.Date pregled = (java.util.Date) this.view
				.getVoziloDodavanje().getDatePickerDatumPregleda().getModel()
				.getValue();

		if (pregled.after(d)) {
			JOptionPane.showOptionDialog(view,
					"Morate unijeti validan datum pregleda.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if (!view.getVoziloDodavanje().getTf_regOznaka().getText()
				.matches("^\\d{3}[-]{1}[AEJKMTO]{1}[-]{1}\\d{3}$")
				&& !view.getVoziloDodavanje()
						.getTf_regOznaka()
						.getText()
						.matches(
								"^[AEJKMTO]{1}\\d{2}[-]{1}[AEJKMTO]{1}[-]{1}\\d{3}$")) {
			JOptionPane.showOptionDialog(view,
					"Morate unijeti validnu registraciju.", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		}
		return true;
	}

	public boolean provjeriPopunjenostDatumaZaOvjeruRegistracije() {
		java.util.Date odKad = (java.util.Date) this.view.getGodisnjaOvjera()
				.getDatum().getRegistrationDate().getDatePickerOdKad()
				.getModel().getValue();
		java.util.Date doKad = (java.util.Date) this.view.getGodisnjaOvjera()
				.getDatum().getRegistrationDate().getDatePickerDoKad()
				.getModel().getValue();
		int razlika = (int) ((doKad.getTime() - odKad.getTime()) / (1000 * 60 * 60 * 24));
		if (odKad.after(doKad)) {
			JOptionPane.showOptionDialog(view, "Neispravan datum.",
					"Godi\u0161nja Ovjera registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (razlika < 365) {
			JOptionPane.showOptionDialog(view,
					"Razmak izme\u0111u datuma mora biti minimalno godina dana.",
					"Godi\u0161nja Ovjera registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else {
			return true;
		}
	}

	public boolean provjeriPopunjenostDatumaZaUnosRegistracije() {
		java.util.Date oodKad = (java.util.Date) view.getRegistracija()
				.getPodaci().getDatumVazenja().getDatePickerOdKad().getModel()
				.getValue();
		java.util.Date dooKad = (java.util.Date) view.getRegistracija()
				.getPodaci().getDatumVazenja().getDatePickerDoKad().getModel()
				.getValue();
		int razlika = (int) ((dooKad.getTime() - oodKad.getTime()) / (1000 * 60 * 60 * 24));
		if (oodKad.after(dooKad)) {
			JOptionPane.showOptionDialog(view, "Neispravan datum.",
					"Godi\u0161nja Ovjera registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (razlika < 365) {
			JOptionPane.showOptionDialog(view,
					"Razmak izme\u0111u datuma mora biti minimalno godina dana.",
					"Godi\u0161nja Ovjera registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else {
			JOptionPane.showOptionDialog(view, "Ispravan.",
					"Godi\u0161nja Ovjera registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return true;
		}

	}

	// Amra
	public boolean provjeriPopunjenostRegistracije() {
		if (!view.getRegistracija().getPodaci().getTxtId().getText()
				.matches("^\\d+$")) {
			JOptionPane.showOptionDialog(view,
					"JMBG/ID se mora sastojati od cifara", "Unos registracije",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getRegistracija().getPodaci()
				.getTxtRegistrationString().getText()
				.matches("^\\d{3}[-]{1}[AEJKMTO]{1}[-]{1}\\d{3}$")
				&& !view.getRegistracija()
						.getPodaci()
						.getTxtRegistrationString()
						.getText()
						.matches(
								"^[AEJKMTO]{1}\\d{2}[-]{1}[AEJKMTO]{1}[-]{1}\\d{3}$")) {
			JOptionPane.showOptionDialog(view,
					"Morate unijeti validnu registraciju.",
					"Unos registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!view.getRegistracija().getPodaci()
				.getTxtConfirmationNumber().getText().matches("^\\d+$")) {
			JOptionPane.showOptionDialog(view,
					"Broj potvrde se mora sastojati od cifara",
					"Unos registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else
			return true;
	}
	public boolean provjeriPopunjenostVozaca() {
		String ip = "^[A-z]+$";
		if (!view.getStrana2().getTfIme().getText().matches(ip)){
			JOptionPane.showOptionDialog(view,
					"Ime se mora sastojati samo od slova.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if(!view.getStrana2().getTfPrezime().getText().matches(ip)){
			JOptionPane.showOptionDialog(view,
					"Prezime se mora sastojati samo od slova.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if(!view.getStrana2().getTfOpcina().getText().matches(ip)){
			JOptionPane.showOptionDialog(view,
					"Općina se mora sastojati samo od slova.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if(!view.getStrana2().getTfMjesto().getText().matches(ip)) {
			JOptionPane.showOptionDialog(view,
					"Mjesto se mora sastojati samo od slova.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if(!view.getStrana2().getTfAdresa().getText()
				.matches("^[a-zA-Z0-9]+\\s?[a-zA-Z0-9]+$")){
			JOptionPane.showOptionDialog(view,
					"Neispravna adresa. Primjer unosa: \"Adresa 54\".",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if (view.getStrana2().getFizicko().isSelected() == true
				&& !view.getStrana2().getTfJMBG().getText()
						.matches("^(\\d{13})$")) {
			JOptionPane.showOptionDialog(view,
					"JMBG se mora sastojati od 13 cifara", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		}
		if (view.getStrana2().getPravno().isSelected() == true
				&& !view.getStrana2().getTfIdBroj().getText().matches("^\\d+$")) {
			JOptionPane.showOptionDialog(view,
					"ID se mora sastojati od cifara", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else
			return true;

	}
	Boolean provjeriVozacaUBazi(){
		if (view.getStrana2().getPravno().isSelected() == true){
			if(view.getStrana2().getTfIdBroj().getText().isEmpty()){
				JOptionPane.showOptionDialog(view,
						"Morate unijeti ID.",
						"Unos voza\u010Da", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return false;
			}
			else if(!view.getStrana2().getTfIdBroj().getText().matches("^\\d+$")) {
				JOptionPane.showOptionDialog(view,
						"ID se mora sastojati od cifara", "Unos voza\u010Da",
						JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
						null, new String[] { "Uredu" }, "default");
					view.getStrana2().getTfIdBroj().setText("");
				return false;
			}
			else
			{
				OsobaDAO oDAO = new OsobaDAO();
				// Isti ID je kao i onaj u bazi
				if(oDAO.getByJMBG(view.getStrana2().getTfIdBroj().getText())==null){
					JOptionPane.showOptionDialog(view,
							"Pravno lice sa unesenim podacima ne postoji u bazi podataka.", "Unos voza\u010Da",
							JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, new String[] { "Uredu" }, "default");
					return false;
				}
				else if(oDAO.getByJMBG(view.getStrana2().getTfIdBroj().getText()).isPravnoLice()==false){
					JOptionPane.showOptionDialog(view,
							"Pravno lice sa unesenim ID-om ne postoji u bazi podataka.", "Unos voza\u010Da",
							JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, new String[] { "Uredu" }, "default");
					return false;
				}
				else{
					Osoba osoba = oDAO.getByJMBG(view.getStrana2().getTfIdBroj().getText());
					if (JOptionPane.showOptionDialog(view,
							"Osoba ve\u0107 postoji u bazi. "
									+ "\nDa - Tu osobu tražim. \nNe - Želim unijeti novu osobu.",
							"Potvrda odjave", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, new String[] {
									"Da", "Ne" }, "default") == JOptionPane.OK_OPTION){
						if(isUnosVDozvole() == true){
							setIdOsobaVlasnickaUnos(osoba.getJmbg_Id());
						}
						if(isUnosSDozvole() == true)
							setIdOsobaSaobracajnaUnos(osoba.getJmbg_Id());
						postaviPoljaVozac(osoba);
						return true;
					}

				}
				
			}
		}
		else if (view.getStrana2().getFizicko().isSelected() == true){
			if(view.getStrana2().getTfJMBG().getText().isEmpty()){
				JOptionPane.showOptionDialog(view,
						"Morate unijeti JMBG.",
						"Unos voza\u010Da", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return false;
			}
			else if (view.getStrana2().getFizicko().isSelected() == true
					&& !view.getStrana2().getTfJMBG().getText()
								.matches("^(\\d{13})$")) {
					JOptionPane.showOptionDialog(view,
							"JMBG se mora sastojati od 13 cifara", "Unos voza\u010Da",
							JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, new String[] { "Uredu" }, "default");
					return false;
			}
			else
			{
				OsobaDAO oDAO = new OsobaDAO();
				// Isti ID je kao i onaj u bazi
				if(oDAO.getByJMBG(view.getStrana2().getTfJMBG().getText())==null){
					JOptionPane.showOptionDialog(view,
							"Osoba sa unesenim podacima ne postoji u bazi podataka.", "Unos voza\u010Da",
							JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, new String[] { "Uredu" }, "default");
					return false;
				}
				else if(oDAO.getByJMBG(view.getStrana2().getTfJMBG().getText()).isPravnoLice()==true){
					JOptionPane.showOptionDialog(view,
							"Osoba sa unesenim JMBG-om ne postoji u bazi podataka.", "Unos voza\u010Da",
							JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, new String[] { "Uredu" }, "default");
					return false;				}
				else
				{
					Osoba osoba = oDAO.getByJMBG(view.getStrana2().getTfJMBG().getText());
					if (JOptionPane.showOptionDialog(view,
							"Osoba ve\u0107 postoji u bazi. "
									+ "\nDa - Tu osobu tražim. \nNe - Želim unijeti novu osobu.",
							"Potvrda odjave", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, new String[] {
									"Da", "Ne" }, "default") == JOptionPane.OK_OPTION){
						if(isUnosVDozvole() == true){
							setIdOsobaVlasnickaUnos(osoba.getJmbg_Id());
						}
						if(isUnosSDozvole() == true)
							setIdOsobaSaobracajnaUnos(osoba.getJmbg_Id());
						postaviPoljaVozac(osoba);
						return true;
					}
				}
			}	
		}
		return false;
	}

	
	public Boolean provjeriVozilaUBazi(){
		String brojSasije = view.getVoziloDodavanje().getTf_brojSasije().getText();
		VoziloDAO vDAO = new VoziloDAO();
		if(brojSasije.isEmpty()){
			JOptionPane.showOptionDialog(view,
					"Niste unijeli broj \u0161asije.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		else if(vDAO.getBySasija(brojSasije)==null){
			JOptionPane.showOptionDialog(view,
					"Uneseno vozilo ne postoji u bazi. ",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			pocistiPoljaVozilo();
			return false;
		}
		else{
			Vozilo v = vDAO.getBySasija(brojSasije);
			if(JOptionPane.showOptionDialog(view,
					"Vozilo ve\u0107 postoji u bazi. "
							+ "\nDa - To vozilo tražim. \nNe - Želim unijeti novo vozilo.",
					"Unos vozila", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new String[] {
							"Da", "Ne" }, "default") == JOptionPane.OK_OPTION){
				
				if(isUnosVDozvole() == true){
					setIdVoziloVlasnickaUnos(v.getId());
				}
				if(isUnosSDozvole() == true)
					setIdVoziloSaobracajnaUnos(v.getId());
				postaviPoljaVozilo(v);
				return true;
			}
		}
		/*ArrayList<Vozilo> vozila = vDAO.getAll();
		for (Vozilo v : vozila) {
				if (v.getBrojSasije().equals(brojSasije)) {
					if(JOptionPane.showOptionDialog(view,
							"Vozilo ve\u0107 postoji u bazi. "
									+ "\nDa - To vozilo tražim. \nNe - Želim unijeti novo vozilo.",
							"Unos vozila", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, new String[] {
									"Da", "Ne" }, "default") == JOptionPane.OK_OPTION){
						
						OsobaDAO osobaDAO = new OsobaDAO();
						if(isUnosVDozvole() == true){
							VlasnickaDAO vlasnickaDAO = new VlasnickaDAO();
							OsobaDAO oDAO = new OsobaDAO();						
							Osoba vlasnik = oDAO.getByJMBG(getIdOsobaVlasnickaUnos());
							
							Vlasnicka vlasnicka = vlasnickaDAO.getByVlasnik(vlasnik.getId());						
							
							Vozilo vozilo = vlasnicka.getVozilo();
							if(vozilo.getBrojSasije()==null){
								JOptionPane.showOptionDialog(view,
										"Uneseno vozilo ne postoji u bazi. ",
										"Unos vozila", JOptionPane.OK_OPTION,
										JOptionPane.ERROR_MESSAGE, null,
										new String[] { "Uredu" }, "default");
								return false;
							}
							else if(vozilo.getBrojSasije().equals(brojSasije))
							{
								JOptionPane.showOptionDialog(view,
										"Uneseno vozilo ve\u0107 ima vlasnika. "
												+ "Molimo vas da poku\u0161ate ponovo",
										"Unos vozila", JOptionPane.OK_OPTION,
										JOptionPane.ERROR_MESSAGE, null,
										new String[] { "Uredu" }, "default");
								return false;
							}
						}
						else if(isUnosSDozvole() == true){
							SaobracajnaDAO saobracajnaDAO = new SaobracajnaDAO();
							OsobaDAO oDAO = new OsobaDAO();						
							Osoba vlasnik = oDAO.getByJMBG(getIdOsobaVlasnickaUnos());
							Saobracajna saobracajna = saobracajnaDAO.getByVozac(vlasnik.getId());						
							Vozilo vozilo = saobracajna.getVozilo();
							
							if(vozilo.getBrojSasije()==null){
								JOptionPane.showOptionDialog(view,
										"Uneseno vozilo ne postoji u bazi. ",
										"Unos vozila", JOptionPane.OK_OPTION,
										JOptionPane.ERROR_MESSAGE, null,
										new String[] { "Uredu" }, "default");
								return false;
							}
							else if(vozilo.getBrojSasije() == brojSasije)
							{
								JOptionPane.showOptionDialog(view,
										"Uneseno vozilo je ve\u0107 evidentirano u drugoj saobra\u107ajnoj dozvoli. "
												+ "Molimo vas da poku\u0161ate ponovo",
										"Unos vozila", JOptionPane.OK_OPTION,
										JOptionPane.ERROR_MESSAGE, null,
										new String[] { "Uredu" }, "default");
								return false;
							}
						}
						if(isUnosVDozvole() == true){
							setIdVoziloVlasnickaUnos(v.getId());
						}
						if(isUnosSDozvole() == true)
							setIdVoziloSaobracajnaUnos(v.getId());
						postaviPoljaVozilo(v);
						return true;
					}
			}
		}*/
		return false;
		
	}
	public Boolean provjeriPostojanjeVlasnicke(){
		String brojSasije = view.getVoziloDodavanje().getTf_brojSasije().getText();
		VlasnickaDAO vlasnickaDAO = new VlasnickaDAO();
		
		ArrayList<Vlasnicka> vlasnicke = vlasnickaDAO.getAll();
		for (Vlasnicka vlasnicka : vlasnicke) {
			if((vlasnicka.getVozilo()).getBrojSasije() == brojSasije){
				JOptionPane.showOptionDialog(view,
						"Uneseno vozilo ima vlasnika.",
						"Unos vozila", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return true;
			}
			if((vlasnicka.getVlasnik()).getJmbg_Id()== getIdOsobaVlasnickaUnos()){
				JOptionPane.showOptionDialog(view,
						"Prethodno unesena osoba je vlasnik ovog vozila.",
						"Unos vozila", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return true;
			}			
		}
		return false;
	}
	public Boolean provjeriPostojanjeSaobracajne(){
		String brojSasije = view.getVoziloDodavanje().getTf_brojSasije().getText();
		SaobracajnaDAO saobracajnaDAO = new SaobracajnaDAO();
		OsobaDAO oDAO = new OsobaDAO();		
		
		ArrayList<Saobracajna> saobracajne = saobracajnaDAO.getAll();
		for (Saobracajna saobracajna : saobracajne) {
			if(saobracajna.getKorisnik().getJmbg_Id()== getIdOsobaSaobracajnaUnos()){
				JOptionPane.showOptionDialog(view,
						"Prethodno unesena osoba je evidentirana u saobra\u0107ajnoj dozvoli kao korisnik ovog vozila.",
						"Unos vozila", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return true;
			}
			if(saobracajna.getVozilo().getBrojSasije() == brojSasije){
				JOptionPane.showOptionDialog(view,
						"Uneseno vozilo je evidentirano u drugoj saobra\u0107ajnoj dozvoli.",
						"Unos vozila", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return true;
			}
		}
		return false;
	}
	public void postaviPoljaVozilo(Vozilo v){
		view.getVoziloDodavanje().getCb_vrstaVozila().setSelectedItem(v.getVrsta());
		view.getVoziloDodavanje().getTf_tipVozila().setText(v.getTip());
		view.getVoziloDodavanje().getTf_modelVozila().setText(v.getModel());
		view.getVoziloDodavanje().getTf_markaVozila().setText(v.getMarka());
		view.getVoziloDodavanje().getTf_godProizvodnje().setText( String.valueOf(v.getGodinaProizvodnje()));
		
	    view.getVoziloDodavanje().getTf_regOznaka().setText(v.getRegOznaka());
		view.getVoziloDodavanje().getTf_odnos().setText(String.valueOf(v.getOdnosSnageIMase()));
		view.getVoziloDodavanje().getTf_sjedenje().setText(String.valueOf(v.getBrojMjestaZaSjedenje()));
		view.getVoziloDodavanje().getTf_stajanje().setText(String.valueOf(v.getBrojMjestaZaStajanje()));
		view.getVoziloDodavanje().getTf_lezanje().setText(String.valueOf(v.getBrojMjestaZaLezanje()));
		view.getVoziloDodavanje().getCb_ekoKarakteristike().setSelectedItem(String.valueOf(v.getEkoKarakteristika()));
		view.getVoziloDodavanje().getRb_katalizator_da().setSelected(v.getKatalizator());
		view.getVoziloDodavanje().getTf_karoserija().setText(String.valueOf(v.getOblikKaroserije()));
		view.getVoziloDodavanje().getTb_bojaVozila().setText("Zelena");
		view.getVoziloDodavanje().getDatePickerDatumPregleda().getModel().setDate(v.getDatumPregleda().getYear(), 
				v.getDatumPregleda().getMonth(), v.getDatumPregleda().getDay());
		view.getVoziloDodavanje().getTf_brojSasije().setText(v.getBrojSasije());
		view.getVoziloDodavanje().getTb_maxMasa().setText(String.valueOf(v.getMaxTehnickaDozvoljenaMasa()));
		view.getVoziloDodavanje().getTb_masa().setText(String.valueOf(v.getMasaVozila()));
		view.getVoziloDodavanje().getTb_nosivost().setText(String.valueOf(v.getDopustenaNosivost()));
		// Motor
		view.getVoziloDodavanje().getTf_zapremina().setText(String.valueOf(v.getMotor().getZapreminaMotora())); 
		view.getVoziloDodavanje().getTf_maxSnaga().setText(String.valueOf(v.getMotor().getMaxSnaga())); 
		view.getVoziloDodavanje().getCb_gorivo().setSelectedItem(v.getMotor().getVrstaGoriva());
		view.getVoziloDodavanje().getTf_brojMotora().setText(v.getMotor().getBrojMotora());
		view.getVoziloDodavanje().getCb_vrstaMotora().setSelectedItem(v.getMotor().getVrstaMotora());
	}
	public void pocistiPoljaVozilo(){
		view.getVoziloDodavanje().getCb_vrstaVozila().setSelectedItem("");
		view.getVoziloDodavanje().getTf_tipVozila().setText("");
		view.getVoziloDodavanje().getTf_modelVozila().setText("");
		view.getVoziloDodavanje().getTf_markaVozila().setText("");
		view.getVoziloDodavanje().getTf_godProizvodnje().setText( "");
		
	    view.getVoziloDodavanje().getTf_regOznaka().setText("");
		view.getVoziloDodavanje().getTf_odnos().setText("");
		view.getVoziloDodavanje().getTf_sjedenje().setText("");
		view.getVoziloDodavanje().getTf_stajanje().setText("");
		view.getVoziloDodavanje().getTf_lezanje().setText("");
		view.getVoziloDodavanje().getCb_ekoKarakteristike().setSelectedItem("");
		view.getVoziloDodavanje().getRb_katalizator_da().setSelected(false);
		view.getVoziloDodavanje().getTf_karoserija().setText("");
		view.getVoziloDodavanje().getTb_bojaVozila().setText("");
		
		view.getVoziloDodavanje().getTf_brojSasije().setText("");
		view.getVoziloDodavanje().getTb_maxMasa().setText("");
		view.getVoziloDodavanje().getTb_masa().setText("");
		view.getVoziloDodavanje().getTb_nosivost().setText("");
		// Motor
		view.getVoziloDodavanje().getTf_zapremina().setText(""); 
		view.getVoziloDodavanje().getTf_maxSnaga().setText(""); 
		view.getVoziloDodavanje().getCb_gorivo().setSelectedItem("");
		view.getVoziloDodavanje().getTf_brojMotora().setText("");
		view.getVoziloDodavanje().getCb_vrstaMotora().setSelectedItem("");
	}
	public boolean dodajVozilo() throws ParseException {
		VrstaVozila vrsta = (VrstaVozila) view.getVoziloDodavanje()
				.getCb_vrstaVozila().getSelectedItem();
		String tip = view.getVoziloDodavanje().getTf_tipVozila().getText();
		String modelVozila = view.getVoziloDodavanje().getTf_modelVozila()
				.getText();
		String marka = view.getVoziloDodavanje().getTf_markaVozila().getText();
		int godinaProizvodnje = Integer.parseInt(view.getVoziloDodavanje()
				.getTf_godProizvodnje().getText());
		// REGISTARSKE DODATI U KONSTRUKTOR
		// Neiskoristeno:
		String registarske = (String) view.getVoziloDodavanje()
				.getTf_regOznaka().getText();
		Double odnosSnageIMase = Double.parseDouble(view.getVoziloDodavanje()
				.getTf_odnos().getText());
		int brojMjestaZaSjedenje = Integer.parseInt(view.getVoziloDodavanje()
				.getTf_sjedenje().getText());
		int brojMjestaZaStajanje = Integer.parseInt(view.getVoziloDodavanje()
				.getTf_stajanje().getText());
		int brojMjestaZaLezanje = Integer.parseInt(view.getVoziloDodavanje()
				.getTf_lezanje().getText());
		EkoKarakteristike ekoKarakteristika = (EkoKarakteristike) view
				.getVoziloDodavanje().getCb_ekoKarakteristike()
				.getSelectedItem();
		boolean katalizator = view.getVoziloDodavanje().getRb_katalizator_da()
				.isSelected();
		String oblikKaroserije = view.getVoziloDodavanje().getTf_karoserija()
				.getText();

		java.util.Date datumPregleda = (java.util.Date) view
				.getVoziloDodavanje().getDatePickerDatumPregleda().getModel()
				.getValue();
		String brojSasije = view.getVoziloDodavanje().getTf_brojSasije()
				.getText();
		int maxTehnickaDozvoljenaMasa = Integer.parseInt(view
				.getVoziloDodavanje().getTb_maxMasa().getText());
		int masaVozila = Integer.parseInt(view.getVoziloDodavanje()
				.getTb_masa().getText());
		int dopustenaNosivost = Integer.parseInt(view.getVoziloDodavanje()
				.getTb_nosivost().getText());
		// Motor
		int zapreminaMotora = Integer.parseInt(view.getVoziloDodavanje()
				.getTf_zapremina().getText());
		int maxSnaga = Integer.parseInt(view.getVoziloDodavanje()
				.getTf_maxSnaga().getText());
		String gorivo = (String) view.getVoziloDodavanje().getCb_gorivo()
				.getSelectedItem();
		String brojMotora = view.getVoziloDodavanje().getTf_brojMotora()
				.getText();
		String vrstaMotora = (String) view.getVoziloDodavanje()
				.getCb_vrstaMotora().getSelectedItem();

		// Nisu iskoristeni: getTb_bojaVozila(), getCb_nijansa() ,
		// getCb_vrstaBoje()
		VoziloDAO vDAO = new VoziloDAO();
		if (vDAO.getByReg(registarske) != null) {
			JOptionPane.showOptionDialog(view,
					"Registracija postoji u bazi podataka.",
					"Unos registracije", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		// jedino mozda u DAO kreirati getByBrojSasije i getByBrojMotora da radi
		// malo brze..jer ih ovako sve provjerava
		ArrayList<Vozilo> vozila = vDAO.getAll();
		for (Vozilo v : vozila) {
			if (v.getBrojSasije().equals(brojSasije)) {
				JOptionPane.showOptionDialog(view,
						"Broj \u0161asije postoji u bazi podataka.",
						"Unos registracije", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return false;
			} else if (v.getMotor().getBrojMotora().equals(brojMotora)) {
				JOptionPane.showOptionDialog(view,
						"Broj motora postoji u bazi podataka.",
						"Unos registracije", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return false;
			}
		}
		return model.dodajVozilo(registarske, vrsta, marka, tip, modelVozila,
				brojSasije, oblikKaroserije, godinaProizvodnje,
				maxTehnickaDozvoljenaMasa, masaVozila, dopustenaNosivost,
				odnosSnageIMase, brojMjestaZaSjedenje, brojMjestaZaStajanje,
				brojMjestaZaLezanje, ekoKarakteristika, katalizator,
				datumPregleda, zapreminaMotora, maxSnaga, gorivo, brojMotora,
				vrstaMotora);

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

	// PRETRAGA
	void prikaziPanelPretraga() {
		// Prikaz panela pretraga
		view.prikaziPretragu();
		// Defaultni - Vozila
		prikaziPanelPretragaVozila();
	}

	void prikaziPanelPretragaVozila() {
		// Baza
		view.getStrana6().getPanel_vozilo().getModel().clearAll();
		view.getStrana6().getPanel_vozilo().getModel()
				.addAll(model.dohvatiSvaVozila());
		// Comboboxi
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri()
				.setModel(new DefaultComboBoxModel(VoziloPretraga.values()));
		// Prikaz
		this.view.getStrana6().prikaziPretraguVozila();
	}

	void prikaziPanelPretragaVozaca() {
		// Baza
		view.getStrana6().getPanel_vozac().getModel().clearAll();
		view.getStrana6().getPanel_vozac().getModel()
				.addAll(model.dohvatiSveVozace());
		// Comboxi
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri()
				.setModel(new DefaultComboBoxModel(VozacPretraga.values()));
		// Prikaz
		this.view.getStrana6().prikaziPretraguVozaca();
	}

	void prikaziPanelPretragaSaobracajnih() {
		view.getStrana6().getPanel_saobracajna().getModel().clearAll();
		view.getStrana6().getPanel_saobracajna().getModel()
				.addAll(model.dohvatiSveSaobracajne());
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view
				.getStrana6()
				.getCb_parametri()
				.setModel(
						new DefaultComboBoxModel(SaobracajnaPretraga.values()));
		this.view.getStrana6().prikaziPretraguSaobracajne();
	}

	void prikaziPanelPretragaVlasnickih() {
		view.getStrana6().getPanel_vlasnicka().getModel().clearAll();
		view.getStrana6().getPanel_vlasnicka().getModel()
				.addAll(model.dohvatiSveVlasnicke());
		this.view.getStrana6().getCb_parametri().removeAllItems();
		this.view.getStrana6().getCb_parametri()
				.setModel(new DefaultComboBoxModel(VlasnickaPretraga.values()));
		this.view.getStrana6().prikaziPretraguVlasnicke();
	}

	private void pretrazi() {
		final JRadioButton rbVozilo = this.view.getStrana6().getRbVozilo();
		final JRadioButton rbVozac = this.view.getStrana6().getRbVozac();
		final JRadioButton rbSaobracajna = this.view.getStrana6()
				.getRbSaobracajna();
		final JRadioButton rbVlasnicka = this.view.getStrana6()
				.getRbVlasnicka();
		if (rbVozilo.isSelected())
			pretraziVozila();
		else if (rbVozac.isSelected())
			pretraziVozace();
		else if (rbSaobracajna.isSelected())
			pretraziSaobracajne();
		else if (rbVlasnicka.isSelected())
			pretraziVlasnicke();
	}

	void pretraziVozila() {
		view.getStrana6().getPanel_vozilo().getModel().clearAll();
		String parametar = view.getStrana6().getTb_unosPretrage().getText();
		VoziloPretraga kriterij = (VoziloPretraga) view.getStrana6()
				.getCb_parametri().getSelectedItem();
		if (parametar.equals("")) {
			view.getStrana6().getPanel_vozilo().getModel()
					.addAll(model.dohvatiSvaVozila());
		} else {
			view.getStrana6()
					.getPanel_vozilo()
					.getModel()
					.addAll(model.pretragaVozilo(parametar, kriterij.toString()));
		}
	}

	void pretraziVozace() {
		view.getStrana6().getPanel_vozac().getModel().clearAll();
		String parametar = view.getStrana6().getTb_unosPretrage().getText();
		VozacPretraga kriterij = (VozacPretraga) view.getStrana6()
				.getCb_parametri().getSelectedItem();
		if (parametar.equals("")) {
			view.getStrana6().getPanel_vozac().getModel()
					.addAll(model.dohvatiSveVozace());
		} else {
			view.getStrana6()
					.getPanel_vozac()
					.getModel()
					.addAll(model.pretragaVozac(parametar, kriterij.toString()));
		}
	}

	void pretraziSaobracajne() {
		view.getStrana6().getPanel_saobracajna().getModel().clearAll();
		String parametar = view.getStrana6().getTb_unosPretrage().getText();
		SaobracajnaPretraga kriterij = (SaobracajnaPretraga) view.getStrana6()
				.getCb_parametri().getSelectedItem();
		if (parametar.equals("")) {
			view.getStrana6().getPanel_saobracajna().getModel()
					.addAll(model.dohvatiSveSaobracajne());
		} else {
			view.getStrana6()
					.getPanel_saobracajna()
					.getModel()
					.addAll(model.pretragaSaobracajna(parametar,
							kriterij.toString()));
		}
	}

	void pretraziVlasnicke() {
		view.getStrana6().getPanel_vlasnicka().getModel().clearAll();
		String parametar = view.getStrana6().getTb_unosPretrage().getText();
		VlasnickaPretraga kriterij = (VlasnickaPretraga) view.getStrana6()
				.getCb_parametri().getSelectedItem();
		if (parametar.equals("")) {
			view.getStrana6().getPanel_vlasnicka().getModel()
					.addAll(model.dohvatiSveVlasnicke());
		} else {
			view.getStrana6()
					.getPanel_vlasnicka()
					.getModel()
					.addAll(model.pretragaVlasnicka(parametar,
							kriterij.toString()));
		}
	}

	void modifikuj() {
		final JRadioButton rbVozilo = this.view.getStrana6().getRbVozilo();
		final JRadioButton rbVozac = this.view.getStrana6().getRbVozac();
		final JRadioButton rbSaobracajna = this.view.getStrana6()
				.getRbSaobracajna();
		final JRadioButton rbVlasnicka = this.view.getStrana6()
				.getRbVlasnicka();
		if (rbVozilo.isSelected())
			modifikujVozilo();
		else if (rbVozac.isSelected())
			modifikujVozaca();
		else if (rbSaobracajna.isSelected())
			modifikujSaobracajnu();
		else if (rbVlasnicka.isSelected())
			modifikujVlasnicku();
	}

	void modifikujVozilo() {
		view.prikaziModifikacijuVozila();
	}

	void modifikujVozaca() {
		view.prikaziModifikacijuVozaca();
	}

	void modifikujSaobracajnu() {
	}

	void modifikujVlasnicku() {
	}

	void updateVozila() throws ParseException {
		/*
		 * VrstaVozila vrsta = (VrstaVozila)
		 * view.getVoziloDodavanje().getCb_vrstaVozila().getSelectedItem();
		 * String tip = view.getVoziloDodavanje().getTf_tipVozila().getText();
		 * String modelVozila =
		 * view.getVoziloDodavanje().getTf_modelVozila().getText(); String marka
		 * = view.getVoziloDodavanje().getTf_markaVozila().getText(); int
		 * godinaProizvodnje =
		 * Integer.parseInt(view.getVoziloDodavanje().getTf_godProizvodnje
		 * ().getText()); // REGISTARSKE DODATI U KONSTRUKTOR //Neiskoristeno:
		 * String registarske =
		 * (String)view.getVoziloDodavanje().getTf_regOznaka().getText(); Double
		 * odnosSnageIMase =
		 * Double.parseDouble(view.getVoziloDodavanje().getTf_odnos
		 * ().getText()); int brojMjestaZaSjedenje =
		 * Integer.parseInt(view.getVoziloDodavanje
		 * ().getTf_sjedenje().getText()); int brojMjestaZaStajanje =
		 * Integer.parseInt
		 * (view.getVoziloDodavanje().getTf_stajanje().getText()); int
		 * brojMjestaZaLezanje =
		 * Integer.parseInt(view.getVoziloDodavanje().getTf_lezanje
		 * ().getText()); EkoKarakteristike ekoKarakteristika
		 * =(EkoKarakteristike
		 * )view.getVoziloDodavanje().getCb_ekoKarakteristike(
		 * ).getSelectedItem(); boolean katalizator =
		 * view.getVoziloDodavanje().getRb_katalizator_da().isSelected(); String
		 * oblikKaroserije =
		 * view.getVoziloDodavanje().getTf_karoserija().getText(); Date
		 * datumPregleda=new
		 * SimpleDateFormat("yyyy-MM-dd").parse(view.getVoziloDodavanje
		 * ().getTf_datumPregleda().getText()); String brojSasije =
		 * view.getVoziloDodavanje().getTf_brojSasije().getText(); int
		 * maxTehnickaDozvoljenaMasa =
		 * Integer.parseInt(view.getVoziloDodavanje()
		 * .getTb_maxMasa().getText()); int masaVozila =
		 * Integer.parseInt(view.getVoziloDodavanje().getTb_masa().getText());
		 * int dopustenaNosivost =
		 * Integer.parseInt(view.getVoziloDodavanje().getTb_nosivost
		 * ().getText()); // Motor int zapreminaMotora =
		 * Integer.parseInt(view.getVoziloDodavanje
		 * ().getTf_zapremina().getText()); int maxSnaga =
		 * Integer.parseInt(view.
		 * getVoziloDodavanje().getTf_maxSnaga().getText()); String gorivo =
		 * (String)view.getVoziloDodavanje().getCb_gorivo().getSelectedItem();
		 * String brojMotora =
		 * view.getVoziloDodavanje().getTf_brojMotora().getText(); String
		 * vrstaMotora
		 * =(String)view.getVoziloDodavanje().getCb_vrstaMotora().getSelectedItem
		 * ();
		 * 
		 * // Nisu iskoristeni: getTb_bojaVozila(), getCb_nijansa() ,
		 * getCb_vrstaBoje()
		 * 
		 * model.updateujVozilo(registarske, vrsta, marka, tip, modelVozila,
		 * brojSasije, oblikKaroserije, godinaProizvodnje,
		 * maxTehnickaDozvoljenaMasa, masaVozila, dopustenaNosivost,
		 * odnosSnageIMase, brojMjestaZaSjedenje, brojMjestaZaStajanje,
		 * brojMjestaZaLezanje, ekoKarakteristika, katalizator, datumPregleda,
		 * zapreminaMotora, maxSnaga,gorivo, brojMotora, vrstaMotora);
		 */}

	public String getIdOsobaSaobracajnaUnos() {
		return idOsobaSaobracajnaUnos;
	}

	public void setIdOsobaSaobracajnaUnos(String idOsobaSaobracajnaUnos) {
		this.idOsobaSaobracajnaUnos = idOsobaSaobracajnaUnos;
	}

	public String getIdOsobaVlasnickaUnos() {
		return idOsobaVlasnickaUnos;
	}

	public void setIdOsobaVlasnickaUnos(String idOsobaVlasnickaUnos) {
		this.idOsobaVlasnickaUnos = idOsobaVlasnickaUnos;
	}

	public int getIdVoziloSaobracajnaUnos() {
		return idVoziloSaobracajnaUnos;
	}

	public void setIdVoziloSaobracajnaUnos(int idVoziloSaobracajnaUnos) {
		this.idVoziloSaobracajnaUnos = idVoziloSaobracajnaUnos;
	}

	public int getIdVoziloVlasnickaUnos() {
		return idVoziloVlasnickaUnos;
	}

	public void setIdVoziloVlasnickaUnos(int idVoziloVlasnickaUnos) {
		this.idVoziloVlasnickaUnos = idVoziloVlasnickaUnos;
	}

}
