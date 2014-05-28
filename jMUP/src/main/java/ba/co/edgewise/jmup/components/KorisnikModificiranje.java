package ba.co.edgewise.jmup.components;
//Promijeniti naziv mozda? - u UposlenikModificiranje
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import ba.co.edgewise.jmup.enums.*;
import ba.co.edgewise.jmup.klase.*;

public class KorisnikModificiranje extends JPanel {

	private static final long serialVersionUID = 6759069118421147031L;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField tfIme;
	private JTextField tfKorisnickoIme;
	private JTextField tfSlika;
	private JTextField tfPrezime;
	private JTextField tfSifra;
	private JButton btnPronadji;
	private JButton btnSpasiuposlenika;
	@SuppressWarnings("rawtypes")
	private JComboBox cbStatusKorisnickogRacuna;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipKorisnickogRacuna;
	private Uposlenik _uposlenik;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public KorisnikModificiranje(Uposlenik uposlenik) {
		
		setBorder(null);
		this._uposlenik = uposlenik;
		
		//methods for layout initialization
		layoutSet();
		panelSet();
		labelSet();
		inputSet();
		comboBoxSet();
		buttonSet();

	}
	
	//methods for layout & control initialization
	public void layoutSet() {
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 370, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0,Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gbl_panel);
	
	}
	
	public void panelSet() {
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o uposleniku", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[]{100, 130, 0, 0};
		gbl_panel1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel1.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel1);
	}
	
	public void labelSet() {
		
		label = new JLabel("Ime:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		label_1 = new JLabel("Prezime:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		label_2 = new JLabel("Slika:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);
		
		label_3 = new JLabel("Korisničko ime:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		panel.add(label_3, gbc_label_3);
		
		label_4 = new JLabel("Šifra:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		panel.add(label_4, gbc_label_4);
		
		label_5 = new JLabel("Tip:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 6;
		panel.add(label_5, gbc_label_5);
		
		label_6 = new JLabel("Status:");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 5;
		panel.add(label_6, gbc_label_6);	
	}
	
	public void inputSet() {
		
		tfKorisnickoIme = new JTextField();
		tfKorisnickoIme.setColumns(10);
		GridBagConstraints gbc_tfKorisnickoIme = new GridBagConstraints();
		gbc_tfKorisnickoIme.gridwidth = 2;
		gbc_tfKorisnickoIme.insets = new Insets(0, 0, 5, 0);
		gbc_tfKorisnickoIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKorisnickoIme.gridx = 1;
		gbc_tfKorisnickoIme.gridy = 3;
		panel.add(tfKorisnickoIme, gbc_tfKorisnickoIme);
		
		tfIme = new JTextField();
		tfIme.setColumns(10);
		GridBagConstraints gbc_tfIme = new GridBagConstraints();
		gbc_tfIme.gridwidth = 2;
		gbc_tfIme.insets = new Insets(0, 0, 5, 0);
		gbc_tfIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIme.gridx = 1;
		gbc_tfIme.gridy = 0;
		panel.add(tfIme, gbc_tfIme);
		
		tfPrezime = new JTextField();
		tfPrezime.setColumns(10);
		GridBagConstraints gbc_tfPrezime = new GridBagConstraints();
		gbc_tfPrezime.gridwidth = 2;
		gbc_tfPrezime.insets = new Insets(0, 0, 5, 0);
		gbc_tfPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrezime.gridx = 1;
		gbc_tfPrezime.gridy = 1;
		panel.add(tfPrezime, gbc_tfPrezime);
		
		tfSlika = new JTextField();
		tfSlika.setEditable(false);
		tfSlika.setColumns(10);
		GridBagConstraints gbc_tfSlika = new GridBagConstraints();
		gbc_tfSlika.insets = new Insets(0, 0, 5, 5);
		gbc_tfSlika.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSlika.gridx = 1;
		gbc_tfSlika.gridy = 2;
		panel.add(tfSlika, gbc_tfSlika);
		
		tfSifra = new JTextField();
		tfSifra.setColumns(10);
		GridBagConstraints gbc_tfSifra = new GridBagConstraints();
		gbc_tfSifra.gridwidth = 2;
		gbc_tfSifra.insets = new Insets(0, 0, 5, 0);
		gbc_tfSifra.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSifra.gridx = 1;
		gbc_tfSifra.gridy = 4;
		panel.add(tfSifra, gbc_tfSifra);
		
	}
	
	public void comboBoxSet() {
		
		cbTipKorisnickogRacuna = new JComboBox(TipUposlenika.values());
		GridBagConstraints gbc_cbTipKorisnickogRacuna = new GridBagConstraints();
		gbc_cbTipKorisnickogRacuna.gridwidth = 2;
		gbc_cbTipKorisnickogRacuna.insets = new Insets(0, 0, 5, 0);
		gbc_cbTipKorisnickogRacuna.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTipKorisnickogRacuna.gridx = 1;
		gbc_cbTipKorisnickogRacuna.gridy = 5;
		panel.add(cbTipKorisnickogRacuna, gbc_cbTipKorisnickogRacuna);
		
		cbStatusKorisnickogRacuna = new JComboBox();
		cbStatusKorisnickogRacuna.setModel(new DefaultComboBoxModel(new String[] {"Aktivan", "Neaktivan"}));
		GridBagConstraints gbc_cbStatusKorisnickogRacuna = new GridBagConstraints();
		gbc_cbStatusKorisnickogRacuna.gridwidth = 2;
		gbc_cbStatusKorisnickogRacuna.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbStatusKorisnickogRacuna.gridx = 1;
		gbc_cbStatusKorisnickogRacuna.gridy = 6;
		panel.add(cbStatusKorisnickogRacuna, gbc_cbStatusKorisnickogRacuna);
	}
	
	public void buttonSet() {
		
		btnPronadji = new JButton("Prona�i");
		GridBagConstraints gbc_btnPronadji = new GridBagConstraints();
		gbc_btnPronadji.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPronadji.insets = new Insets(0, 0, 5, 0);
		gbc_btnPronadji.gridx = 2;
		gbc_btnPronadji.gridy = 2;
		panel.add(btnPronadji, gbc_btnPronadji);
		
		btnSpasiuposlenika = new JButton("Modifikuj uposlenika");
		GridBagConstraints gbc_btnSpasiuposlenika = new GridBagConstraints();
		gbc_btnSpasiuposlenika.anchor = GridBagConstraints.EAST;
		gbc_btnSpasiuposlenika.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpasiuposlenika.gridx = 1;
		gbc_btnSpasiuposlenika.gridy = 2;
		add(btnSpasiuposlenika, gbc_btnSpasiuposlenika);
	}
	
	// methods
	public void PopuniUposlenika () {
		
		this.tfIme.setText(_uposlenik.getIme());
		this.tfPrezime.setText(_uposlenik.getPrezime());
		this.tfKorisnickoIme.setText(_uposlenik.getKorisnickoIme());
		this.tfSifra.setText(_uposlenik.getPassword());
		this.cbStatusKorisnickogRacuna.setSelectedItem(_uposlenik.getStatus());
		this.cbTipKorisnickogRacuna.setSelectedItem(_uposlenik.getTip());
	}
	
	//getters & setters
	public JButton getBtPronadji() {
		return btnPronadji;
	}

	public JButton getBtSpasiuposlenika() {
		return btnSpasiuposlenika;
	}

	public JTextField getTfIme() {
		return tfIme;
	}

	public JTextField getTfPrezime() {
		return tfPrezime;
	}

	public JTextField getTfSlika() {
		return tfSlika;
	}

	public JTextField getTfKorisnickoIme() {
		return tfKorisnickoIme;
	}

	public JTextField getTfSifra() {
		return tfSifra;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getCbTipKorisnickogRacuna() {
		return cbTipKorisnickogRacuna;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getCbStatusKorisnickogRacuna() {
		return cbStatusKorisnickogRacuna;
	}
}