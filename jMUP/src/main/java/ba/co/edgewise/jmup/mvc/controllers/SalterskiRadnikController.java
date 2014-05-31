package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import ba.co.edgewise.jmup.components.DatumVazenja;
import ba.co.edgewise.jmup.components.PodaciRegistracija;
import ba.co.edgewise.jmup.components.RegistracijaUnos;
import ba.co.edgewise.jmup.components.VozacDodavanje;
import ba.co.edgewise.jmup.components.VoziloDodavanje;
import ba.co.edgewise.jmup.enums.Boja;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.NijansaBoje;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.VrstaBoje;
import ba.co.edgewise.jmup.enums.VrstaGoriva;
import ba.co.edgewise.jmup.enums.VrstaMotora;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class SalterskiRadnikController {

	//Fields
		private SalterskiRadnikModel model;
		private SalterskiRadnikView view;
		
		//Constructor
		public SalterskiRadnikController(SalterskiRadnikView view,
				SalterskiRadnikModel model) {
			super();
			this.model = model;
			this.view = view;
		}
		
		public void control(){
			meniControl();
			buttonControl();
		}
		
		
		/**
		 * Meni kontrola
		 */
		public void meniControl(){
			
			/**
			 * Početna strana
			 */
			JButton pocetna = view.getMeni().getOpcije().getBtnPocetna();
			pocetna.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					nextStrana1();
				}
			});
			
			/**
			 * Unos vozaca
			 */
			JButton unosVozaca = view.getMeni().getOpcije().getBtnUnosVozaca();
			unosVozaca.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					nextStrana2();
				}
			});
			
			/**
			 * Unos vozila
			 */
			JButton unosVozila = view.getMeni().getOpcije().getBtnUnosVozila();
			unosVozila.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					nextStrana3();
				}
			});
			
			/**
			 * Unos vlasničke dozvole
			 */
			JButton unosVlasnicke = view.getMeni().getOpcije().getBtnUnosVlasnicke();
			unosVlasnicke.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					nextStrana4();
				}
			});
			
		}
		
		//Button kontrole
		public void buttonControl(){
			
			/**
			 * Spašavanje vozača
			 */
			JButton spasiVozaca = view.getStrana2().getBtnPrihvati();
			spasiVozaca.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dodajVozaca();
				}
			});
			
			/**
			 * Poništavanje popunjenih stvari vozača
			 */
			JButton ponistiStrana2 = view.getStrana2().getBtnPonisti();
			ponistiStrana2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ocistiStranu2();
				}
			});
			
			/**
			 * Upravljanje radio buttonom za Pravno/FIzicko lice unos vozača
			 */
			JRadioButton pravno = view.getStrana2().getPravno();
			pravno.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					dohvatiStatusPravno(view.getStrana2());
				}
			});
			
			/**
			 * Unos vozila
			 */
			JButton spasiVozilo = view.getStrana3().getBtn_prihvati();
			spasiVozilo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dodajVozilo();
				}
			});
			
			/**
			 * Unos vlasničke - spašavanje vlasnika
			 */
			JButton spasiVlasnika = view.getStrana4().getBtnPrihvati();
			spasiVlasnika.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dodajVlasnikaUVlasničku();
					nextStrana5();
				}
			});
			
			/**
			 * Upravljanje radio buttonom za Pravno/FIzicko lice unos vlasnika Vlasničke
			 */
			JRadioButton pravnoVlasnicka = view.getStrana4().getPravno();
			pravnoVlasnicka.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					dohvatiStatusPravno(view.getStrana4());
				}
			});
			
			/**
			 * Unos vlasničke - spašavanje vlasnika
			 */
			JButton spasiVlasnickaVozilo = view.getStrana5().getBtn_prihvati();
			spasiVlasnickaVozilo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dodajVoziloUVlasničku();
					nextStrana6();
				}
			});
			
			/**
			 * Unos vlasničke - dodavanje registracije
			 */
			JButton spasiRegistracijuVlasnicka = view.getStrana6().getBtnPrihvati();
			spasiRegistracijuVlasnicka.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dodajRegistracijuUVlasničku();
				}
			});
			
			
		}
		
		/**
		 * Navigacija strana 1
		 */
		private void nextStrana1() {
			view.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Po\u010Detna");
		}
		
		/**
		 * Navigacija strana 2
		 */
		private void nextStrana2() {
			view.getSadrzaj().getNaslov().postaviNaslov("Unos voza\u010Da");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Unos voza\u010Da");
		}
		
		/**
		 * Navigacija strana 3
		 */
		private void nextStrana3() {
			view.getSadrzaj().getNaslov().postaviNaslov("Unos vozila");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Unos vozila");
		}
		
		/**
		 * Navigacija strana 4
		 */
		private void nextStrana4() {
			view.getSadrzaj().getNaslov().postaviNaslov("Unos vlasnika - Vlasnička dozvola(1/3)");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Unos vlasnika - Vlasnička dozvola");
		}
		
		/**
		 * Navigacija strana 5
		 */
		private void nextStrana5() {
			view.getSadrzaj().getNaslov().postaviNaslov("Unos vozila - Vlasnička dozvola(2/3)");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Unos vozila - Vlasnička dozvola");
		}
		
		/**
		 * Navigacija strana 6
		 */
		private void nextStrana6() {
			view.getSadrzaj().getNaslov().postaviNaslov("Unos vozila - Ovjera registracije(3/3)");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Unos ovjere registracije - Vlasnička dozvola");
		}
		
		/**
		 * Dodavanje vozača
		 */
		private void dodajVozaca() {
			dohvatiPodatkeVlasnika(view.getStrana2());
			if (model.dodajVozaca()) {
				JOptionPane.showOptionDialog(view, "Voza\u010D uspje\u0161no dodan.",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				ocistiStranu2();
			} else {
				JOptionPane.showOptionDialog(view,
						"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
								+ "Molimo vas da poku\u0161ate ponovo",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
						"default");
			};
		}
		
		/**
		 * Dodavanje vozila
		 */
		private void dodajVozilo() {
			dohvatiPodatkeVozila(view.getStrana3());
			if (model.dodajVozilo()) {
				JOptionPane.showOptionDialog(view, "Vozilo uspje\u0161no dodano.",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
			} else {
				JOptionPane.showOptionDialog(view,
						"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
								+ "Molimo vas da poku\u0161ate ponovo",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
						"default");
			}
		}
		
		/**
		 * Dodavanje vozača u vlasničku
		 */
		private void dodajVlasnikaUVlasničku() {
			dohvatiPodatkeVlasnika(view.getStrana4());
			model.getVlasnicka().setVlasnik(model.getVozac());
			model.getRegistracija().setOsoba(model.getVozac().getId());
			if (model.dodajVozaca()) {
				JOptionPane.showOptionDialog(view, "Voza\u010D uspje\u0161no dodan.",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				ocistiStranu2();
			} else {
				JOptionPane.showOptionDialog(view,
						"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
								+ "Molimo vas da poku\u0161ate ponovo",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
						"default");
			};
		}
		
		/**
		 * Dodavanje vozila u vlasničku
		 */
		private void dodajVoziloUVlasničku() {
			dohvatiPodatkeVozila(view.getStrana5());
			model.getVlasnicka().setVozilo(model.getVozilo());
			model.getRegistracija().setVozilo(model.getVozilo().getId());
			if (model.dodajVozilo()) {
				JOptionPane.showOptionDialog(view, "Vozilo uspje\u0161no dodan.",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				ocistiStranu2();
			} else {
				JOptionPane.showOptionDialog(view,
						"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
								+ "Molimo vas da poku\u0161ate ponovo",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
						"default");
			};
		}
		
		/**
		 * Dodavanje registracije u vlasničku
		 */
		private void dodajRegistracijuUVlasničku() {
			dohvatiPodatkeRegistracije(view.getStrana6());
			if (model.dodajVlasnicku()) {
				JOptionPane.showOptionDialog(view, "Vlasnička uspje\u0161no dodana.",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				ocistiStranu2();
			} else {
				JOptionPane.showOptionDialog(view,
						"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
								+ "Molimo vas da poku\u0161ate ponovo",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
						"default");
			};
		}
		
		
		
		
		/**
		 * Utilities
		 */
		
		/**
		 * Vadi podatke vlasnika iz forme
		 */
		private void dohvatiPodatkeVlasnika(VozacDodavanje forma) {
			
			Osoba vozac = model.getVozac();
			
			vozac.setIme(forma.getTfIme().getText());
			vozac.setPrezime(forma.getTfPrezime().getText());
			
			String jmbg_id = (forma.getPravno().isSelected()) ?
					forma.getTfIdBroj().getText()
					: forma.getTfJMBG().getText();
			vozac.setJmbg_Id(jmbg_id);
			
			String prebivaliste = forma.getTfMjesto().getText() + ", "
					+ forma.getTfOpcina().getText() + ", "
					+ forma.getTfAdresa().getText();
			vozac.setPrebivaliste(prebivaliste);
			
			vozac.setPravnoLice(!forma.getFizicko().isSelected());
		}
		
		/**
		 * Cisti dodavanje vozaca formu
		 */
		private void ocistiStranu2() {
			VozacDodavanje forma = view.getStrana2();
			
			forma.getTfIme().setText("");
			forma.getTfPrezime().setText("");
			forma.getTfJMBG().setText("");
			forma.getTfMjesto().setText("");
			forma.getTfOpcina().setText("");
			forma.getTfAdresa().setText("");
			forma.getTfIdBroj().setText("");
			
			forma.getFizicko().setSelected(true);
			forma.getPravno().setSelected(false);
		}
		
		/**
		 * Swicha izmedju pravno i fizicko lice
		 */
		private void dohvatiStatusPravno(VozacDodavanje frame){
			Boolean pravno = frame.getPravno().isSelected();
			view.getStrana2().getTfJMBG().setEditable(!pravno);
			view.getStrana2().getTfIdBroj().setEditable(pravno);
		}
		
		/**
		 * Dohvaca podatke iz forme za unos vozila
		 */
		
		@SuppressWarnings("deprecation")
		private void dohvatiPodatkeVozila(VoziloDodavanje frame){
			Vozilo vozilo = model.getVozilo();
			
			vozilo.getMotor().setBrojMotora(frame.getTf_brojMotora().getText());
			vozilo.getMotor().setMaxSnaga(Integer.parseInt
					(frame.getTf_maxSnaga().getText()));
			vozilo.getMotor().setZapreminaMotora(Integer.parseInt
					(frame.getTf_zapremina().getText()));
			vozilo.getMotor().setVrstaGoriva((VrstaGoriva)
					frame.getCb_gorivo().getSelectedItem());
			vozilo.getMotor().setVrstaMotora((VrstaMotora)
					frame.getCb_vrstaMotora().getSelectedItem());
			
			vozilo.setRegistarskaOznaka(frame.getTf_regOznaka().getText());
			vozilo.setVrsta((VrstaVozila)
					frame.getCb_vrstaVozila().getSelectedItem());
			vozilo.setMarka(frame.getTf_markaVozila().getText());
			vozilo.setTip(frame.getTf_tipVozila().getText());
			vozilo.setModel(frame.getTf_modelVozila().getText());
			vozilo.setModel(frame.getTf_modelVozila().getText());
			vozilo.setBrojSasije(frame.getTf_brojSasije().getText());
			vozilo.setOblikKaroserije(frame.getTf_karoserija().getText());
			vozilo.setGodinaProizvodnje(Integer.parseInt
					(frame.getTf_godProizvodnje().getText()));
			vozilo.setMaxTehnickaDozvoljenaMasa(Integer.parseInt(
					frame.getTb_maxMasa().getText()));
			vozilo.setMasaVozila(Integer.parseInt(
					frame.getTb_masa().getText()));
			vozilo.setDopustenaNosivost(Integer.parseInt(
					frame.getTb_nosivost().getText()));
			vozilo.setOdnosSnageIMase(Double.parseDouble(
					frame.getTf_odnos().getText()));
			vozilo.setBrojMjestaZaSjedenje(Integer.parseInt(
					frame.getTf_sjedenje().getText()));
			vozilo.setBrojMjestaZaStajanje(Integer.parseInt(
					frame.getTf_stajanje().getText()));
			vozilo.setBrojMjestaZaLezanje(Integer.parseInt(
					frame.getTf_lezanje().getText()));
			vozilo.setEkoKarakteristika((EkoKarakteristike)
					frame.getCb_ekoKarakteristike().getSelectedItem());
			vozilo.setKatalizator(frame.getRb_katalizator_da().isSelected());
			vozilo.setStatusVozila(Status.AKTIVAN);
			
			int year = frame.getDpDatumPregleda().getModel().getYear();
			int month = frame.getDpDatumPregleda().getModel().getMonth();
			int day = frame.getDpDatumPregleda().getModel().getDay();
			vozilo.setDatumPregleda(new Date(year, month, day));
			
			Boja novaBoja = (Boja)frame.getCbBoja().getSelectedItem();
			vozilo.getBojaVozila().setBoja(novaBoja);
			vozilo.getBojaVozila().setNijansa((NijansaBoje)
					frame.getCb_nijansa().getSelectedItem());
			vozilo.getBojaVozila().setVrsta((VrstaBoje)
					frame.getCb_vrstaBoje().getSelectedItem());
			vozilo.getBojaVozila().setTip("Osnovna");
			
		}
		
		private void dohvatiPodatkeRegistracije(RegistracijaUnos frame) {
			String brojDozvole = frame.getPodaci().getTfBrojDozvole().getText().toString();
			model.getVlasnicka().setBrojDozvole(brojDozvole);
		}
		
}
