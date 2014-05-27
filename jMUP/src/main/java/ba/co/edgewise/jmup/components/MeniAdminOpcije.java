package co.ba.edgewise.components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MeniAdminOpcije extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7313645690322305071L;
	private JButton btnPocetna;
	private JButton btnKreiranjeKorisnika;
	private JButton btnOdjava;
	private JButton btnPretragaKorisnika;
	private JButton btnPregledLogova;
	private JButton btnIzradaBackupa;
	private GridBagLayout gridBagLayoutMeniAdminOpcije;
	
	/**
	 * Create the panel.
	 */
	public MeniAdminOpcije() {
		layoutSet();
		btnSet();
		panelSet();
	}
	public void layoutSet(){
		gridBagLayoutMeniAdminOpcije = new GridBagLayout();
		gridBagLayoutMeniAdminOpcije.columnWidths = new int[]{0, 0};
		gridBagLayoutMeniAdminOpcije.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutMeniAdminOpcije.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayoutMeniAdminOpcije.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutMeniAdminOpcije);
	}
	public void btnSet(){
		btnPocetna = new JButton("Početna");
		GridBagConstraints gbc_btnPocetna = new GridBagConstraints();
		gbc_btnPocetna.insets = new Insets(0, 0, 5, 0);
		gbc_btnPocetna.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPocetna.gridx = 0;
		gbc_btnPocetna.gridy = 0;
		add(btnPocetna, gbc_btnPocetna);
		
		btnKreiranjeKorisnika = new JButton("Kreiraj korisnika");
		GridBagConstraints gbc_btnStrana = new GridBagConstraints();
		gbc_btnStrana.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStrana.insets = new Insets(0, 0, 5, 0);
		gbc_btnStrana.gridx = 0;
		gbc_btnStrana.gridy = 1;
		add(btnKreiranjeKorisnika, gbc_btnStrana);
		
		btnPretragaKorisnika = new JButton("Pretraga korisnika");
		GridBagConstraints gbc_btnPretragaKorisnika = new GridBagConstraints();
		gbc_btnPretragaKorisnika.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPretragaKorisnika.insets = new Insets(0, 0, 5, 0);
		gbc_btnPretragaKorisnika.gridx = 0;
		gbc_btnPretragaKorisnika.gridy = 2;
		add(btnPretragaKorisnika, gbc_btnPretragaKorisnika);
		
		btnPregledLogova = new JButton("Pregled historije promjena");
		GridBagConstraints gbc_btnPregledLogova = new GridBagConstraints();
		gbc_btnPregledLogova.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPregledLogova.insets = new Insets(0, 0, 5, 0);
		gbc_btnPregledLogova.gridx = 0;
		gbc_btnPregledLogova.gridy = 3;
		add(btnPregledLogova, gbc_btnPregledLogova);
		
		btnIzradaBackupa = new JButton("Izrada backup-a");
		GridBagConstraints gbc_btnIzradaBackupa = new GridBagConstraints();
		gbc_btnIzradaBackupa.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIzradaBackupa.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzradaBackupa.gridx = 0;
		gbc_btnIzradaBackupa.gridy = 4;
		add(btnIzradaBackupa, gbc_btnIzradaBackupa);
		
		btnOdjava = new JButton("Odjava");
		GridBagConstraints gbc_btnOdjava = new GridBagConstraints();
		gbc_btnOdjava.insets = new Insets(0, 0, 5, 0);
		gbc_btnOdjava.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOdjava.gridx = 0;
		gbc_btnOdjava.gridy = 6;
		add(btnOdjava, gbc_btnOdjava);
	}
	public void panelSet(){
		JPanel panelEmpty = new JPanel();
		GridBagConstraints gbc_panelEmpty = new GridBagConstraints();
		gbc_panelEmpty.insets = new Insets(0, 0, 5, 0);
		gbc_panelEmpty.fill = GridBagConstraints.BOTH;
		gbc_panelEmpty.gridx = 0;
		gbc_panelEmpty.gridy = 5;
		add(panelEmpty, gbc_panelEmpty);	
	}
	public JButton getBtnPocetna() {
		return btnPocetna;
	}
	public JButton getBtnStrana() {
		return btnKreiranjeKorisnika;
	}
	public JButton getBtnOdjava() {
		return btnOdjava;
	}
	public JButton getBtnPretragaKorisnika() {
		return btnPretragaKorisnika;
	}
	public JButton getBtnPregledLogova() {
		return btnPregledLogova;
	}
	public JButton getBtnIzradaBackupa() {
		return btnIzradaBackupa;
	}
	public GridBagLayout getGridBagLayoutMeniAdminOpcije() {
		return gridBagLayoutMeniAdminOpcije;
	}
}
