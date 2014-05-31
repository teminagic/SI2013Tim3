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
		
		
		//Meni kontrole
		public void meniControl(){
			JButton pocetna = view.getMeni().getOpcije().getBtnPocetna();
			pocetna.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					nextStrana1();
				}
			});
		
			JButton unosVozaca = view.getMeni().getOpcije().getBtnUnosVozaca();
			unosVozaca.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					nextStrana2();
				}
			});
			
			JButton unosVozila = view.getMeni().getOpcije().getBtnUnosVozila();
			unosVozila.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					nextStrana3();
				}
			});
		}
		
		//Button kontrole
		public void buttonControl(){
			
			JButton spasiVozaca = view.getStrana2().getBtnPrihvati();
			spasiVozaca.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dodajVozaca();
				}
			});
			
			JButton ponistiStrana2 = view.getStrana2().getBtnPonisti();
			ponistiStrana2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ocistiStranu2();
				}
			});
			
			JRadioButton pravno = view.getStrana2().getPravno();
			pravno.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					dohvatiStatusPravno();
				}
			});
			
			JButton spasiVozilo = view.getStrana3().getBtn_prihvati();
			spasiVozilo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dodajVozilo();
				}
			});
			
		}
		
		//navigacija
		private void nextStrana1() {
			view.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Po\u010Detna");
		}
		
		private void nextStrana2() {
			view.getSadrzaj().getNaslov().postaviNaslov("Unos voza\u010Da");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Unos voza\u010Da");
		}
		
		private void nextStrana3() {
			view.getSadrzaj().getNaslov().postaviNaslov("Unos vozila");
			JPanel cards = view.getSadrzaj().getPanelSadrzaj();
			CardLayout tmp = (CardLayout) cards.getLayout();
			tmp.show(cards, "Unos vozila");
		}
		
		/**
		 * Dodavanje
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
		private void dohvatiStatusPravno(){
			Boolean pravno = view.getStrana2().getPravno().isSelected();
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
		
}
