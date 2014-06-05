package ba.co.edgewise.jmup.components;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PregledVozaca extends JPanel {
	
	private JLabel lbl_ime;
	private JLabel lbl_prezime;
	private JLabel lbl_jmbg;
	private JLabel lbl_adresa;
	private JLabel lbl_mjesto;
	private JLabel lbl_opcina;
	private JLabel lbl_lice;
	private JButton btnOdjavaVozaca;
	private JButton buttonRegistracijaVozila;
	private JButton btnDeaktivacijaSaobraajne; 
	private JButton btnModifikacija;
	private JButton btnIzlaz;
	
	public PregledVozaca() {
		
		setLayout();
		setLabel();
		setComponents();
	}

	public void setLayout(){
		TitledBorder naslov;
		naslov = BorderFactory.createTitledBorder("Podaci o vozaču");
		this.setBorder(naslov);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{18, 66, 138, 0, 59, 0};
		gridBagLayout.rowHeights = new int[]{0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
	public void setLabel(){
		JLabel lblIme = new JLabel("Ime");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.anchor = GridBagConstraints.EAST;
		gbc_lblIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblIme.gridx = 1;
		gbc_lblIme.gridy = 1;
		add(lblIme, gbc_lblIme);
		
		lbl_ime = new JLabel("New label");
		GridBagConstraints gbc_lbl_ime = new GridBagConstraints();
		gbc_lbl_ime.anchor = GridBagConstraints.EAST;
		gbc_lbl_ime.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_ime.gridx = 2;
		gbc_lbl_ime.gridy = 1;
		add(lbl_ime, gbc_lbl_ime);
		
		JLabel lblPrezime = new JLabel("Prezime");
		GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
		gbc_lblPrezime.anchor = GridBagConstraints.EAST;
		gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezime.gridx = 1;
		gbc_lblPrezime.gridy = 2;
		add(lblPrezime, gbc_lblPrezime);
		
		lbl_prezime = new JLabel("New label");
		GridBagConstraints gbc_lbl_prezime = new GridBagConstraints();
		gbc_lbl_prezime.anchor = GridBagConstraints.EAST;
		gbc_lbl_prezime.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_prezime.gridx = 2;
		gbc_lbl_prezime.gridy = 2;
		add(lbl_prezime, gbc_lbl_prezime);
		
		JLabel lblJmbg = new JLabel("JMBG");
		GridBagConstraints gbc_lblJmbg = new GridBagConstraints();
		gbc_lblJmbg.anchor = GridBagConstraints.EAST;
		gbc_lblJmbg.insets = new Insets(0, 0, 5, 5);
		gbc_lblJmbg.gridx = 1;
		gbc_lblJmbg.gridy = 3;
		add(lblJmbg, gbc_lblJmbg);
		
		lbl_jmbg= new JLabel("jmbg/id ako je pravno lice");
		GridBagConstraints gbc_lbl_jmbg = new GridBagConstraints();
		gbc_lbl_jmbg.anchor = GridBagConstraints.EAST;
		gbc_lbl_jmbg.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_jmbg.gridx = 2;
		gbc_lbl_jmbg.gridy = 3;
		add(lbl_jmbg, gbc_lbl_jmbg);
		
		JLabel lblAdresa = new JLabel("Adresa");
		GridBagConstraints gbc_lblAdresa = new GridBagConstraints();
		gbc_lblAdresa.anchor = GridBagConstraints.EAST;
		gbc_lblAdresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresa.gridx = 1;
		gbc_lblAdresa.gridy = 4;
		add(lblAdresa, gbc_lblAdresa);
		
		lbl_adresa= new JLabel("New label");
		GridBagConstraints gbc_lbl_adresa = new GridBagConstraints();
		gbc_lbl_adresa.anchor = GridBagConstraints.EAST;
		gbc_lbl_adresa.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_adresa.gridx = 2;
		gbc_lbl_adresa.gridy = 4;
		add(lbl_adresa, gbc_lbl_adresa);
		
		JLabel lblMjesto = new JLabel("Mjesto");
		GridBagConstraints gbc_lblMjesto = new GridBagConstraints();
		gbc_lblMjesto.anchor = GridBagConstraints.EAST;
		gbc_lblMjesto.insets = new Insets(0, 0, 5, 5);
		gbc_lblMjesto.gridx = 1;
		gbc_lblMjesto.gridy = 5;
		add(lblMjesto, gbc_lblMjesto);
		
		lbl_mjesto= new JLabel("New label");
		GridBagConstraints gbc_lbl_mjesto = new GridBagConstraints();
		gbc_lbl_mjesto.anchor = GridBagConstraints.EAST;
		gbc_lbl_mjesto.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_mjesto.gridx = 2;
		gbc_lbl_mjesto.gridy = 5;
		add(lbl_mjesto, gbc_lbl_mjesto);
		
		JLabel lblOpcina = new JLabel("Op\u0107ina");
		GridBagConstraints gbc_lblOpcina = new GridBagConstraints();
		gbc_lblOpcina.anchor = GridBagConstraints.EAST;
		gbc_lblOpcina.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpcina.gridx = 1;
		gbc_lblOpcina.gridy = 6;
		add(lblOpcina, gbc_lblOpcina);
		
		lbl_opcina= new JLabel("New label");
		GridBagConstraints gbc_lbl_opcina = new GridBagConstraints();
		gbc_lbl_opcina.anchor = GridBagConstraints.EAST;
		gbc_lbl_opcina.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_opcina.gridx = 2;
		gbc_lbl_opcina.gridy = 6;
		add(lbl_opcina, gbc_lbl_opcina);
		
		JLabel lblLice = new JLabel("Lice");
		GridBagConstraints gbc_lblLice = new GridBagConstraints();
		gbc_lblLice.anchor = GridBagConstraints.EAST;
		gbc_lblLice.insets = new Insets(0, 0, 5, 5);
		gbc_lblLice.gridx = 1;
		gbc_lblLice.gridy = 7;
		add(lblLice, gbc_lblLice);
		
		lbl_lice= new JLabel("New label");
		GridBagConstraints gbc_lbl_lice = new GridBagConstraints();
		gbc_lbl_lice.anchor = GridBagConstraints.EAST;
		gbc_lbl_lice.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_lice.gridx = 2;
		gbc_lbl_lice.gridy = 7;
		add(lbl_lice, gbc_lbl_lice);
	}
	public void setComponents(){
		btnOdjavaVozaca = new JButton("Odjava voza\u010Da");
		GridBagConstraints gbc_btnOdjavaVozaca = new GridBagConstraints();
		gbc_btnOdjavaVozaca.anchor = GridBagConstraints.EAST;
		gbc_btnOdjavaVozaca.gridwidth = 2;
		gbc_btnOdjavaVozaca.insets = new Insets(0, 0, 5, 0);
		gbc_btnOdjavaVozaca.gridx = 3;
		gbc_btnOdjavaVozaca.gridy = 0;
		add(btnOdjavaVozaca, gbc_btnOdjavaVozaca);
		
		buttonRegistracijaVozila= new JButton("Registracija vozila");
		GridBagConstraints gbc_buttonRegistracijaVozila = new GridBagConstraints();
		gbc_buttonRegistracijaVozila.anchor = GridBagConstraints.EAST;
		gbc_buttonRegistracijaVozila.gridwidth = 2;
		gbc_buttonRegistracijaVozila.insets = new Insets(0, 0, 5, 5);
		gbc_buttonRegistracijaVozila.gridx = 1;
		gbc_buttonRegistracijaVozila.gridy = 8;
		add(buttonRegistracijaVozila, gbc_buttonRegistracijaVozila);
	
		btnDeaktivacijaSaobraajne= new JButton("Deaktivacija saobra\u0107ajne");
		GridBagConstraints gbc_btnDeaktivacijaSaobraajne = new GridBagConstraints();
		gbc_btnDeaktivacijaSaobraajne.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeaktivacijaSaobraajne.gridwidth = 2;
		gbc_btnDeaktivacijaSaobraajne.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeaktivacijaSaobraajne.gridx = 1;
		gbc_btnDeaktivacijaSaobraajne.gridy = 10;
		add(btnDeaktivacijaSaobraajne, gbc_btnDeaktivacijaSaobraajne);
		
		btnModifikacija= new JButton("Modifikacija");
		btnModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new AddOwner();
			}
		});
		GridBagConstraints gbc_btnModifikacija = new GridBagConstraints();
		gbc_btnModifikacija.anchor = GridBagConstraints.EAST;
		gbc_btnModifikacija.insets = new Insets(0, 0, 0, 5);
		gbc_btnModifikacija.gridx = 3;
		gbc_btnModifikacija.gridy = 10;
		add(btnModifikacija, gbc_btnModifikacija);
		
		btnIzlaz= new JButton("Izlaz");
		GridBagConstraints gbc_btnIzlaz = new GridBagConstraints();
		gbc_btnIzlaz.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIzlaz.gridx = 4;
		gbc_btnIzlaz.gridy = 10;
		add(btnIzlaz, gbc_btnIzlaz);
	}
	//getters and setters
	public JLabel getLbl_ime() {
		return lbl_ime;
	}

	public void setLbl_ime(JLabel lbl_ime) {
		this.lbl_ime = lbl_ime;
	}

	public JLabel getLbl_prezime() {
		return lbl_prezime;
	}

	public void setLbl_prezime(JLabel lbl_prezime) {
		this.lbl_prezime = lbl_prezime;
	}

	public JLabel getLbl_jmbg() {
		return lbl_jmbg;
	}

	public void setLbl_jmbg(JLabel lbl_jmbg) {
		this.lbl_jmbg = lbl_jmbg;
	}

	public JLabel getLbl_adresa() {
		return lbl_adresa;
	}

	public void setLbl_adresa(JLabel lbl_adresa) {
		this.lbl_adresa = lbl_adresa;
	}

	public JLabel getLbl_mjesto() {
		return lbl_mjesto;
	}

	public void setLbl_mjesto(JLabel lbl_mjesto) {
		this.lbl_mjesto = lbl_mjesto;
	}

	public JLabel getLbl_opcina() {
		return lbl_opcina;
	}

	public void setLbl_opcina(JLabel lbl_opcina) {
		this.lbl_opcina = lbl_opcina;
	}

	public JLabel getLbl_lice() {
		return lbl_lice;
	}

	public void setLbl_lice(JLabel lbl_lice) {
		this.lbl_lice = lbl_lice;
	}

	public JButton getBtnOdjavaVozaca() {
		return btnOdjavaVozaca;
	}

	public JButton getButtonRegistracijaVozila() {
		return buttonRegistracijaVozila;
	}

	public JButton getBtnDeaktivacijaSaobraajne() {
		return btnDeaktivacijaSaobraajne;
	}

	public JButton getBtnModifikacija() {
		return btnModifikacija;
	}

	public JButton getBtnIzlaz() {
		return btnIzlaz;
	}
}