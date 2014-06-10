package ba.co.edgewise.jmup.components;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import ba.co.edgewise.jmup.enums.*;

public class KorisnikKreiranje extends JPanel {

	private static final long serialVersionUID = 6759069118421147031L;
	
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblKorisnikoIme;
	private JLabel lblifra;
	private JLabel lblStatus;
	private JLabel lblTip;
	private JTextField tfIme;
	private JTextField tfKorisnickoIme;
	private JTextField tfPrezime;
	private JPasswordField pwdSifra;
	private JButton btnSpasiKorisnika;
	@SuppressWarnings("rawtypes")
	private JComboBox cbStatusKorisnickogRacuna;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipKorisnickogRacuna;
	
	
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
		gbl_panel.columnWidths = new int[] { 10, 370, 10, 0 };
		gbl_panel.rowHeights = new int[] { 10, 0, 37, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
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
		
		lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		GridBagConstraints gbc_lblKorisnikoIme = new GridBagConstraints();
		gbc_lblKorisnikoIme.anchor = GridBagConstraints.EAST;
		gbc_lblKorisnikoIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblKorisnikoIme.gridx = 1;
		gbc_lblKorisnikoIme.gridy = 3;
		panel.add(lblKorisnikoIme, gbc_lblKorisnikoIme);
		
		lblifra = new JLabel("\u0160ifra:");
		GridBagConstraints gbc_lblifra = new GridBagConstraints();
		gbc_lblifra.anchor = GridBagConstraints.EAST;
		gbc_lblifra.insets = new Insets(0, 0, 5, 5);
		gbc_lblifra.gridx = 1;
		gbc_lblifra.gridy = 4;
		panel.add(lblifra, gbc_lblifra);
		
		lblStatus = new JLabel("Status:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 1;
		gbc_lblStatus.gridy = 6;
		panel.add(lblStatus, gbc_lblStatus);
		
		lblTip = new JLabel("Tip:");
		GridBagConstraints gbc_lblTip = new GridBagConstraints();
		gbc_lblTip.anchor = GridBagConstraints.EAST;
		gbc_lblTip.insets = new Insets(0, 0, 5, 5);
		gbc_lblTip.gridx = 1;
		gbc_lblTip.gridy = 5;
		panel.add(lblTip, gbc_lblTip);	
	}
	
	public void inputSet() {
		
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
		
		tfKorisnickoIme = new JTextField();
		tfKorisnickoIme.setColumns(10);
		GridBagConstraints gbc_tfKorisnickoIme = new GridBagConstraints();
		gbc_tfKorisnickoIme.gridwidth = 2;
		gbc_tfKorisnickoIme.insets = new Insets(0, 0, 5, 5);
		gbc_tfKorisnickoIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKorisnickoIme.gridx = 2;
		gbc_tfKorisnickoIme.gridy = 3;
		panel.add(tfKorisnickoIme, gbc_tfKorisnickoIme);
		
		pwdSifra = new JPasswordField();
		pwdSifra.setColumns(10);
		GridBagConstraints gbc_pwdSifra = new GridBagConstraints();
		gbc_pwdSifra.gridwidth = 2;
		gbc_pwdSifra.insets = new Insets(0, 0, 5, 5);
		gbc_pwdSifra.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdSifra.gridx = 2;
		gbc_pwdSifra.gridy = 4;
		panel.add(pwdSifra, gbc_pwdSifra);
		
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
		
		btnSpasiKorisnika = new JButton("Kreiraj korisnika");
		GridBagConstraints gbc_btnSpasiKorisnika = new GridBagConstraints();
		gbc_btnSpasiKorisnika.anchor = GridBagConstraints.EAST;
		gbc_btnSpasiKorisnika.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpasiKorisnika.gridx = 1;
		gbc_btnSpasiKorisnika.gridy = 2;
		add(btnSpasiKorisnika, gbc_btnSpasiKorisnika);
	}
	
	//getters & setters

	public JButton getBtSpasiKorisnika() {
		return btnSpasiKorisnika;
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
	
	@SuppressWarnings("rawtypes")
	public JComboBox getCbTipKorisnickogRacuna() {
		return cbTipKorisnickogRacuna;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getCbStatusKorisnickogRacuna() {
		return cbStatusKorisnickogRacuna;
	}
	public JPasswordField getPwdSifra() {
		return pwdSifra;
	}
}