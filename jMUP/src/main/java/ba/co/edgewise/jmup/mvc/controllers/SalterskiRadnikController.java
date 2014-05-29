package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.VoziloDodavanje;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;
import ba.co.edgewise.jmup.mvc.views.Login;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class SalterskiRadnikController {

	private SalterskiRadnikModel model;
	private SalterskiRadnikView view;

	public SalterskiRadnikController(SalterskiRadnikView view, SalterskiRadnikModel model) {
		super();
		this.view = view;
		this.model = model;
	}
	public void control() {
				// Buttoni meni-a:
		
				// Listener za unos vozaca
				JButton unosVozaca = this.view.getMeni().getOpcije().getBtnUnosVozaca();
				unosVozaca.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						prikaziPanelUnosVozaca();
						};
					
				});

				// Listener za pocetnu
				JButton pocetna= this.view.getMeni().getOpcije().getBtnPocetna();
				pocetna.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						prikaziPanelPocetnu();
						};
					
				});
				
				
				// Ostali buttoni:
				/*JButton dodavanjeVozaca = this.view.getStrana2VozacDodavanje().getBtnPrihvati();
				dodavanjeVozaca.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(provjeriPopunjenostVozaca()){
							try {
								dodajVozaca();
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else{
							JOptionPane.showMessageDialog(null, "Neispravno popunjena polja!");
						};
					}
				});*/
				JButton dodavanjeVozaca = this.view.getStrana2().getBtnPrihvati();
				dodavanjeVozaca.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(provjeriPopunjenostVozaca()){							
								dodajVozaca();
						} 
						else{
							JOptionPane.showMessageDialog(null, "Neispravno popunjena polja!");
						};
					}
				});
	}
	
	public void dodajVozaca()
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
		
		model.DodajVozaca(ime, prezime, adresa, mjesto, opcina, pravno, jmbg, idBroj);
	}
	public boolean provjeriPopunjenostVozaca() {
		return true;
	}
	
	// Prikazi za buttone iz menija:
	void prikaziPanelUnosVozaca()
	{
		view.getSadrzaj().getNaslov().postaviNaslov("Dodavanje voza\u010Da");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Dodavanje voza\u010Da");
	}
	void prikaziPanelPocetnu()
	{
		view.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Po\u010Detna");
	}
	
}
