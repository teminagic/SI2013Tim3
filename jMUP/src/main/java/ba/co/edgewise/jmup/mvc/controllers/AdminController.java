package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ba.co.edgewise.jmup.components.KorisnikKreiranje;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.TipPretrageUposlenika;
import ba.co.edgewise.jmup.enums.TipUposlenika;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.mvc.models.AdminModel;
import ba.co.edgewise.jmup.mvc.views.Administrator;

public class AdminController {
	private Administrator view;
	private AdminModel model;

	public AdminController(Administrator view, AdminModel model) {
		super();
		this.view = view;
		this.model = model;
	}

	public void control() {
		meniControl();

		JButton spasiKorisnika = view.getStrana2().getBtSpasiKorisnika();
		spasiKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				postaviIKreirajKorisnika();
			}
		});
		
		JButton pretrazi = view.getStrana3().getBtnPronaiKorisnika();
		pretrazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pretraziKorisnike();
			}
		});
		
		//JButton modifikuj = view.getStrana3().getBtnModifikuj();
		//JButton izbrisi = view.getStrana3().getBtnIzbrisiKorisnika();
		
		JTable table = view.getStrana3().getTable();
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				view.getStrana3().getBtnModifikuj().setEnabled(!lsm.isSelectionEmpty());
				view.getStrana3().getBtnIzbrisiKorisnika().setEnabled(!lsm.isSelectionEmpty());
			}
		});
	}

	private void meniControl() {
		JButton pocetna = view.getMeni().getOpcije().getBtnPocetna();
		pocetna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextPocetna();
			}
		});

		JButton kreiranjeKorisnika = view.getMeni().getOpcije()
				.getBtnKreiranjeKorisnika();
		kreiranjeKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextKreiranje();
			}
		});

		JButton pretragaKorisnika = view.getMeni().getOpcije()
				.getBtnPretragaKorisnika();
		pretragaKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextPretraga();
			}
		});
	}

	private void nextPocetna() {
		view.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Po\u010Detna");
	}

	private void nextKreiranje() {
		view.getSadrzaj().getNaslov().postaviNaslov("Kreiranje korisnika");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Dodavanje korisnika");
	}

	private void nextPretraga() {
		view.getSadrzaj().getNaslov().postaviNaslov("Pretraga korisnika");
		view.getStrana3().getModel().clearAll();
		view.getStrana3().getModel().addAll(model.dohvatiSveUsere());
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Pretraga korisnika");
	}

	private void postaviIKreirajKorisnika() {
		KorisnikKreiranje sadrzaj = view.getStrana2();
		Uposlenik tmp = new Uposlenik();
		tmp.setIme(sadrzaj.getTfIme().getText());
		tmp.setPrezime(sadrzaj.getTfPrezime().getText());
		tmp.setKorisnickoIme(sadrzaj.getTfKorisnickoIme().getText());
		tmp.setPassword(new String(sadrzaj.getPwdSifra().getPassword()));
		tmp.setStatus((Status) sadrzaj.getCbStatusKorisnickogRacuna()
				.getSelectedItem());
		tmp.setTip((TipUposlenika) sadrzaj.getCbTipKorisnickogRacuna()
				.getSelectedItem());
		this.model.setUposlenik(tmp);
		if (model.kreiranjeKorisnika()) {
			JOptionPane.showOptionDialog(view, "Korisnik uspje\u0161no dodan.",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
		} else {
			JOptionPane.showOptionDialog(view,
					"Do\u0161lo je do gre\u0161ke u upisivanju u bazu. "
							+ "Molimo vas da poku�ate ponovo",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
					"default");
		};
	}
	////
	private void pretraziKorisnike() {
		view.getStrana3().getModel().clearAll();
		String kriterij = view.getStrana3().getTfPodaci().getText();
		TipPretrageUposlenika tip = (TipPretrageUposlenika)
				view.getStrana3().getCbPoljePretrage().getSelectedItem();
		if(kriterij.equals("")) {
			view.getStrana3().getModel().addAll(
					model.dohvatiSveUsere());
		} else {
			view.getStrana3().getModel().addAll(
					model.dohvatiUserePretraga(kriterij, tip));
		}
	}
}
