package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MeniSalterOpcije extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7313645690322305071L;
	private JButton btnPocetna;
	private JButton btnUnosVozaca;
	private JButton btnOdjava;
	private JButton btnPretraga;
	private JButton btnUnosVozila;
	private JButton btnUnosSaobracajne;
	private JButton btnUnosVlasnicke;
	
	private GridBagLayout gridBagLayoutMeniSalterOpcije;
	private JPanel panelEmpty;
	

	/**
	 * Create the panel.
	 */
	public MeniSalterOpcije() {
		layoutSet();
		btnSet();
		panelSet();
	}
	
	public void layoutSet(){
		gridBagLayoutMeniSalterOpcije = new GridBagLayout();
		gridBagLayoutMeniSalterOpcije.columnWidths = new int[]{0, 0};
		gridBagLayoutMeniSalterOpcije.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutMeniSalterOpcije.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayoutMeniSalterOpcije.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutMeniSalterOpcije);
	}
	public void btnSet(){
		btnPocetna = new JButton("PoÄ�etna");
		GridBagConstraints gbc_btnPocetna = new GridBagConstraints();
		gbc_btnPocetna.insets = new Insets(0, 0, 5, 0);
		gbc_btnPocetna.fill = GridBagConstraints.BOTH;
		gbc_btnPocetna.gridx = 0;
		gbc_btnPocetna.gridy = 0;
		add(btnPocetna, gbc_btnPocetna);
		
		btnUnosVozaca = new JButton("Unos vozaÄ�a");
		GridBagConstraints gbc_btnUnosVozaca = new GridBagConstraints();
		gbc_btnUnosVozaca.fill = GridBagConstraints.BOTH;
		gbc_btnUnosVozaca.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnosVozaca.gridx = 0;
		gbc_btnUnosVozaca.gridy = 1;
		add(btnUnosVozaca, gbc_btnUnosVozaca);
		
		btnUnosVozila = new JButton("Unos vozila");
		GridBagConstraints gbc_btnUnosVozila = new GridBagConstraints();
		gbc_btnUnosVozila.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUnosVozila.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnosVozila.gridx = 0;
		gbc_btnUnosVozila.gridy = 2;
		add(btnUnosVozila, gbc_btnUnosVozila);
		
		btnUnosVlasnicke = new JButton("Unos vlasniÄ�ke dozvole");
		GridBagConstraints gbc_btnUnosVlasnicke = new GridBagConstraints();
		gbc_btnUnosVlasnicke.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUnosVlasnicke.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnosVlasnicke.gridx = 0;
		gbc_btnUnosVlasnicke.gridy = 3;
		add(btnUnosVlasnicke, gbc_btnUnosVlasnicke);
		
		btnUnosSaobracajne = new JButton("Unos saobraÄ‡ajne dozvole");
		GridBagConstraints gbc_btnUnosSaobracajne = new GridBagConstraints();
		gbc_btnUnosSaobracajne.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUnosSaobracajne.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnosSaobracajne.gridx = 0;
		gbc_btnUnosSaobracajne.gridy = 4;
		add(btnUnosSaobracajne, gbc_btnUnosSaobracajne);
		
		btnPretraga = new JButton("Pretraga");
		GridBagConstraints gbc_btnPretraga = new GridBagConstraints();
		gbc_btnPretraga.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPretraga.insets = new Insets(0, 0, 5, 0);
		gbc_btnPretraga.gridx = 0;
		gbc_btnPretraga.gridy = 5;
		add(btnPretraga, gbc_btnPretraga);
	}
	public void panelSet(){
		
		btnOdjava = new JButton("Odjava");
		GridBagConstraints gbc_btnOdjava = new GridBagConstraints();
		gbc_btnOdjava.insets = new Insets(0, 0, 5, 0);
		gbc_btnOdjava.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOdjava.gridx = 0;
		gbc_btnOdjava.gridy = 6;
		add(btnOdjava, gbc_btnOdjava);
		panelEmpty = new JPanel();
		GridBagConstraints gbc_panelEmpty = new GridBagConstraints();
		gbc_panelEmpty.insets = new Insets(0, 0, 5, 0);
		gbc_panelEmpty.fill = GridBagConstraints.BOTH;
		gbc_panelEmpty.gridx = 0;
		gbc_panelEmpty.gridy = 9;
		add(panelEmpty, gbc_panelEmpty);
	}
	public JButton getBtnPocetna() {
		return btnPocetna;
	}

	public JButton getBtnUnosVozaca() {
		return btnUnosVozaca;
	}
	public JButton getBtnUnosVozila() {
		return btnUnosVozila;
	}
	public JButton getBtnUnosVlasnicke() {
		return btnUnosVlasnicke;
	}
	public JButton getbtnUnosSaobracajne() {
		return btnUnosSaobracajne;
	}
	public JButton getBtnPretraga() {
		return btnPretraga;
	}

	public JButton getBtnOdjava() {
		return btnOdjava;
	}
	public GridBagLayout getGridBagLayoutMeniSalterOpcije() {
		return gridBagLayoutMeniSalterOpcije;
	}

	public JPanel getPanelEmpty() {
		return panelEmpty;
	}
}
