package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ba.co.edgewise.jmup.components.KorisnikKreiranje;
import ba.co.edgewise.jmup.enums.Status;
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


	public void control(){
		JButton pocetna = view.getMeni().getOpcije().getBtnPocetna();
		pocetna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextPocetna();
			}
		});
		
		JButton kreiranjeKorisnika = view.getMeni().getOpcije().getBtnKreiranjeKorisnika();
		kreiranjeKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextKreiranje();
			}
		});
	}
	
	private void nextPocetna(){
		view.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Po\u010Detna");
	}
	
	private void nextKreiranje(){
		view.getSadrzaj().getNaslov().postaviNaslov("Kreiranje korisnika");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Dodavanje korisnika");
	}
	
	private void postaviIKreirajKorisnika(){
		KorisnikKreiranje sadrzaj = view.getStrana2();
		Uposlenik tmp = new Uposlenik();
		tmp.setIme(sadrzaj.getTfIme().getText());
		tmp.setPrezime(sadrzaj.getTfPrezime().getText());
		tmp.setKorisnickoIme(sadrzaj.getTfKorisnickoIme().getText());
		tmp.setPassword(new String(sadrzaj.getPwdSifra().getPassword()));
		tmp.setStatus((Status)sadrzaj.getCbStatusKorisnickogRacuna().getSelectedItem());
		tmp.setTip((TipUposlenika)sadrzaj.getCbTipKorisnickogRacuna().getSelectedItem());
		this.model.setUposlenik(tmp);
		if(model.kreiranjeKorisnika()){
			JOptionPane.showOptionDialog(view, "Korisnik uspje\u0161no dodan.",
					"Kreiranje korisnika", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] {"Uredu"}, "default");
		} else {
			JOptionPane.showOptionDialog(view, "Do\u0161lo je do gre\u0161ke u upisivanju u bazu. "
					+ "Molimo vas da pokušate ponovo",
					"Kreiranje korisnika", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE,
					null, new String[] {"Uredu"}, "default");
		};
	}
}
