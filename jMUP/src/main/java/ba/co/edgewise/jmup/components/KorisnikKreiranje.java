package ba.co.edgewise.jmup.components;
//
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import ba.co.edgewise.enums.*;

public class KorisnikKreiranje extends JPanel {

	private static final long serialVersionUID = 6759069118421147031L;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblKorisnikoIme;
	private JLabel lblifra;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField tfIme;
	private JTextField tfKorisnickoIme;
	private JTextField tfSlika;
	private JTextField tfPrezime;
	private JTextField tfSifra;
	private JButton btnPronadji;
	private JButton btnSpasiKorisnika;
	@SuppressWarnings("rawtypes")
	private JComboBox cbStatusKorisnickogRacuna;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipKorisnickogRacuna;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	
	public KorisnikKreiranje() {
		
		setBorder(null);
		
		//methods for layout initialization
		layoutSet();
		panelSet();
		labelSet();
		inputSet();
		comboBoxSet();
		buttonSet();
		
	}
		
	public void layoutSet() {
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 370, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gbl_panel);
	}
	
	public void panelSet() {
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o korisniku", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		GridBagConstraints gbc_lblKorisnikoIme = new GridBagConstraints();
		gbc_lblKorisnikoIme.anchor = GridBagConstraints.EAST;
		gbc_lblKorisnikoIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblKorisnikoIme.gridx = 0;
		gbc_lblKorisnikoIme.gridy = 3;
		panel.add(lblKorisnikoIme, gbc_lblKorisnikoIme);
		
		lblifra = new JLabel("\u0160ifra:");
		GridBagConstraints gbc_lblifra = new GridBagConstraints();
		gbc_lblifra.anchor = GridBagConstraints.EAST;
		gbc_lblifra.insets = new Insets(0, 0, 5, 5);
		gbc_lblifra.gridx = 0;
		gbc_lblifra.gridy = 4;
		panel.add(lblifra, gbc_lblifra);
		
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
		
		tfKorisnickoIme = new JTextField();
		tfKorisnickoIme.setColumns(10);
		GridBagConstraints gbc_tfKorisnickoIme = new GridBagConstraints();
		gbc_tfKorisnickoIme.gridwidth = 2;
		gbc_tfKorisnickoIme.insets = new Insets(0, 0, 5, 0);
		gbc_tfKorisnickoIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKorisnickoIme.gridx = 1;
		gbc_tfKorisnickoIme.gridy = 3;
		panel.add(tfKorisnickoIme, gbc_tfKorisnickoIme);
		
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
		
		cbTipKorisnickogRacuna = new JComboBox(TipKorisnika.values());
		GridBagConstraints gbc_cbTipKorisnickogRacuna = new GridBagConstraints();
		gbc_cbTipKorisnickogRacuna.gridwidth = 2;
		gbc_cbTipKorisnickogRacuna.insets = new Insets(0, 0, 5, 0);
		gbc_cbTipKorisnickogRacuna.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTipKorisnickogRacuna.gridx = 1;
		gbc_cbTipKorisnickogRacuna.gridy = 5;
		panel.add(cbTipKorisnickogRacuna, gbc_cbTipKorisnickogRacuna);
		
		cbStatusKorisnickogRacuna = new JComboBox(Status.values());
		GridBagConstraints gbc_cbStatusKorisnickogRacuna = new GridBagConstraints();
		gbc_cbStatusKorisnickogRacuna.gridwidth = 2;
		gbc_cbStatusKorisnickogRacuna.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbStatusKorisnickogRacuna.gridx = 1;
		gbc_cbStatusKorisnickogRacuna.gridy = 6;
		panel.add(cbStatusKorisnickogRacuna, gbc_cbStatusKorisnickogRacuna);
	}
	
	public void buttonSet() {
		
		btnPronadji = new JButton("Prona\u0111i");
		GridBagConstraints gbc_btnPronadji = new GridBagConstraints();
		gbc_btnPronadji.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPronadji.insets = new Insets(0, 0, 5, 0);
		gbc_btnPronadji.gridx = 2;
		gbc_btnPronadji.gridy = 2;
		panel.add(btnPronadji, gbc_btnPronadji);
		
		btnSpasiKorisnika = new JButton("Kreiraj korisnika");
		GridBagConstraints gbc_btnSpasiKorisnika = new GridBagConstraints();
		gbc_btnSpasiKorisnika.anchor = GridBagConstraints.EAST;
		gbc_btnSpasiKorisnika.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpasiKorisnika.gridx = 1;
		gbc_btnSpasiKorisnika.gridy = 2;
		add(btnSpasiKorisnika, gbc_btnSpasiKorisnika);
	}
	
	//getters & setters
	public JButton getBtPronadji() {
		return btnPronadji;
	}

	public JButton getBtSpasiKorisnika() {
		return btnSpasiKorisnika;
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