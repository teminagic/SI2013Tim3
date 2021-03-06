package ba.co.edgewise.jmup.components;
//Promijeniti naziv mozda? - u UposlenikModificiranje
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import ba.co.edgewise.jmup.enums.*;
import ba.co.edgewise.jmup.klase.Uposlenik;

public class KorisnikModificiranje extends JPanel {

	private static final long serialVersionUID = 6759069118421147031L;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField tfIme;
	private JTextField tfKorisnickoIme;
	private JTextField tfPrezime;
	private JPasswordField tfSifra;
	private JButton btnSpasiuposlenika;
	@SuppressWarnings("rawtypes")
	private JComboBox cbStatusKorisnickogRacuna;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipKorisnickogRacuna;
	private Uposlenik uposlenik;

	public KorisnikModificiranje() {
		
		this.setUposlenik(new Uposlenik());
		
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
		gbl_panel.columnWidths = new int[] { 10, 370, 10, 0 };
		gbl_panel.rowHeights = new int[] { 10, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0,Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
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
		gbl_panel1.columnWidths = new int[]{10, 100, 130, 0, 10, 0};
		gbl_panel1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel1);
	}
	
	public void labelSet() {
		
		label = new JLabel("Ime:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		label_1 = new JLabel("Prezime:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 2;
		panel.add(label_1, gbc_label_1);
		
		label_3 = new JLabel("Korisničko ime:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 3;
		panel.add(label_3, gbc_label_3);
		
		label_4 = new JLabel("Šifra:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 4;
		panel.add(label_4, gbc_label_4);
		
		label_5 = new JLabel("Tip:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 6;
		panel.add(label_5, gbc_label_5);
		
		label_6 = new JLabel("Status:");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 5;
		panel.add(label_6, gbc_label_6);	
	}
	
	public void inputSet() {
		
		tfKorisnickoIme = new JTextField();
		tfKorisnickoIme.setColumns(10);
		GridBagConstraints gbc_tfKorisnickoIme = new GridBagConstraints();
		gbc_tfKorisnickoIme.gridwidth = 2;
		gbc_tfKorisnickoIme.insets = new Insets(0, 0, 5, 5);
		gbc_tfKorisnickoIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKorisnickoIme.gridx = 2;
		gbc_tfKorisnickoIme.gridy = 3;
		panel.add(tfKorisnickoIme, gbc_tfKorisnickoIme);
		
		tfIme = new JTextField();
		tfIme.setColumns(10);
		GridBagConstraints gbc_tfIme = new GridBagConstraints();
		gbc_tfIme.gridwidth = 2;
		gbc_tfIme.insets = new Insets(0, 0, 5, 5);
		gbc_tfIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIme.gridx = 2;
		gbc_tfIme.gridy = 1;
		panel.add(tfIme, gbc_tfIme);
		
		tfPrezime = new JTextField();
		tfPrezime.setColumns(10);
		GridBagConstraints gbc_tfPrezime = new GridBagConstraints();
		gbc_tfPrezime.gridwidth = 2;
		gbc_tfPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_tfPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrezime.gridx = 2;
		gbc_tfPrezime.gridy = 2;
		panel.add(tfPrezime, gbc_tfPrezime);
		
		tfSifra = new JPasswordField();
		tfSifra.setColumns(10);
		GridBagConstraints gbc_tfSifra = new GridBagConstraints();
		gbc_tfSifra.gridwidth = 2;
		gbc_tfSifra.insets = new Insets(0, 0, 5, 5);
		gbc_tfSifra.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSifra.gridx = 2;
		gbc_tfSifra.gridy = 4;
		panel.add(tfSifra, gbc_tfSifra);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void comboBoxSet() {
		
		cbTipKorisnickogRacuna = new JComboBox(TipUposlenika.values());
		GridBagConstraints gbc_cbTipKorisnickogRacuna = new GridBagConstraints();
		gbc_cbTipKorisnickogRacuna.gridwidth = 2;
		gbc_cbTipKorisnickogRacuna.insets = new Insets(0, 0, 5, 5);
		gbc_cbTipKorisnickogRacuna.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTipKorisnickogRacuna.gridx = 2;
		gbc_cbTipKorisnickogRacuna.gridy = 5;
		panel.add(cbTipKorisnickogRacuna, gbc_cbTipKorisnickogRacuna);
		
		cbStatusKorisnickogRacuna = new JComboBox(Status.values());
		GridBagConstraints gbc_cbStatusKorisnickogRacuna = new GridBagConstraints();
		gbc_cbStatusKorisnickogRacuna.insets = new Insets(0, 0, 5, 5);
		gbc_cbStatusKorisnickogRacuna.gridwidth = 2;
		gbc_cbStatusKorisnickogRacuna.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbStatusKorisnickogRacuna.gridx = 2;
		gbc_cbStatusKorisnickogRacuna.gridy = 6;
		panel.add(cbStatusKorisnickogRacuna, gbc_cbStatusKorisnickogRacuna);
	}
	
	public void buttonSet() {
		
		btnSpasiuposlenika = new JButton("Modifikuj uposlenika");
		GridBagConstraints gbc_btnSpasiuposlenika = new GridBagConstraints();
		gbc_btnSpasiuposlenika.anchor = GridBagConstraints.EAST;
		gbc_btnSpasiuposlenika.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpasiuposlenika.gridx = 1;
		gbc_btnSpasiuposlenika.gridy = 2;
		add(btnSpasiuposlenika, gbc_btnSpasiuposlenika);
	}
	
	// methods
	public void postaviVrijednosti()
	{
		this.tfIme.setText(this.getUposlenik().getIme());
		this.tfPrezime.setText(this.getUposlenik().getPrezime());
		this.tfKorisnickoIme.setText(this.getUposlenik().getKorisnickoIme());
		this.tfSifra.setText(new String(this.getUposlenik().getPassword()));
		this.cbTipKorisnickogRacuna.setSelectedItem(this.getUposlenik().getTip());
		this.cbStatusKorisnickogRacuna.setSelectedItem(this.getUposlenik().getStatus());
	}
	
	@SuppressWarnings("deprecation")
	public void postaviKorisnika () {
		this.getUposlenik().setIme(this.tfIme.getText());
		this.getUposlenik().setPrezime(this.tfPrezime.getText());
		this.getUposlenik().setKorisnickoIme(this.tfKorisnickoIme.getText());
		this.getUposlenik().setPassword(this.tfSifra.getText());
		this.getUposlenik().setStatus((Status)this.cbStatusKorisnickogRacuna.getSelectedItem());
		this.getUposlenik().setTip((TipUposlenika)this.cbTipKorisnickogRacuna.getSelectedItem());
	}

	
	//getters & setters

	public JButton getBtSpasiuposlenika() {
		return btnSpasiuposlenika;
	}

	public JTextField getTfIme() {
		return tfIme;
	}

	public JTextField getTfPrezime() {
		return tfPrezime;
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

	public Uposlenik getUposlenik() {
		return uposlenik;
	}

	public void setUposlenik(Uposlenik uposlenik) {
		this.uposlenik = uposlenik;
	}
}