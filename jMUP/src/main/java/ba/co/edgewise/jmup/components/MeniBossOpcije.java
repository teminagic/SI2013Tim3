package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MeniBossOpcije extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7313645690322305071L;
	private JButton btnPocetna;
	private JButton btnOdjava;
	private JButton btnPregledLogova;
	private JButton btnPretraga;
	private JButton btnIzradaIzvjetaja;
	private GridBagLayout gridBagLayoutMeniBossOpcije;
	/**
	 * Create the panel.
	 */
	public MeniBossOpcije() {
		layoutSet();
		btnSet();
		panelSet();
	}
	public void layoutSet(){
		gridBagLayoutMeniBossOpcije = new GridBagLayout();
		gridBagLayoutMeniBossOpcije.columnWidths = new int[]{0, 0};
		gridBagLayoutMeniBossOpcije.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutMeniBossOpcije.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayoutMeniBossOpcije.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutMeniBossOpcije);
	}
	public void btnSet(){
		btnPocetna = new JButton("Početna");
		GridBagConstraints gbc_btnPocetna = new GridBagConstraints();
		gbc_btnPocetna.insets = new Insets(0, 0, 5, 0);
		gbc_btnPocetna.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPocetna.gridx = 0;
		gbc_btnPocetna.gridy = 0;
		add(btnPocetna, gbc_btnPocetna);
		
		btnPretraga = new JButton("Pretraga");
		GridBagConstraints gbc_btnPretraga = new GridBagConstraints();
		gbc_btnPretraga.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPretraga.insets = new Insets(0, 0, 5, 0);
		gbc_btnPretraga.gridx = 0;
		gbc_btnPretraga.gridy = 1;
		add(btnPretraga, gbc_btnPretraga);
		
		btnIzradaIzvjetaja = new JButton("Izrada izvještaja");
		GridBagConstraints gbc_btnIzradaIzvjetaja = new GridBagConstraints();
		gbc_btnIzradaIzvjetaja.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIzradaIzvjetaja.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzradaIzvjetaja.gridx = 0;
		gbc_btnIzradaIzvjetaja.gridy = 2;
		add(btnIzradaIzvjetaja, gbc_btnIzradaIzvjetaja);
		
		btnPregledLogova = new JButton("Pregled historije promjena");
		GridBagConstraints gbc_btnPregledLogova = new GridBagConstraints();
		gbc_btnPregledLogova.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPregledLogova.insets = new Insets(0, 0, 5, 0);
		gbc_btnPregledLogova.gridx = 0;
		gbc_btnPregledLogova.gridy = 3;
		add(btnPregledLogova, gbc_btnPregledLogova);
		btnOdjava = new JButton("Odjava");
		GridBagConstraints gbc_btnOdjava = new GridBagConstraints();
		gbc_btnOdjava.insets = new Insets(0, 0, 5, 0);
		gbc_btnOdjava.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOdjava.gridx = 0;
		gbc_btnOdjava.gridy = 5;
		add(btnOdjava, gbc_btnOdjava);
	}
	public void panelSet(){
		JPanel panelEmpty = new JPanel();
		GridBagConstraints gbc_panelEmpty = new GridBagConstraints();
		gbc_panelEmpty.insets = new Insets(0, 0, 5, 0);
		gbc_panelEmpty.fill = GridBagConstraints.BOTH;
		gbc_panelEmpty.gridx = 0;
		gbc_panelEmpty.gridy = 4;
		add(panelEmpty, gbc_panelEmpty);
	}
	public JButton getBtnPocetna() {
		return btnPocetna;
	}
	public JButton getBtnOdjava() {
		return btnOdjava;
	}
	public JButton getBtnPregledLogova() {
		return btnPregledLogova;
	}
	public JButton getBtnIzradaIzvjetaja() {
		return btnIzradaIzvjetaja;
	}
	public JButton getBtnPretraga() {
		return btnPretraga;
	}
	public GridBagLayout gridBagLayoutMeniBossOpcije(){
		return gridBagLayoutMeniBossOpcije;
	}
}
