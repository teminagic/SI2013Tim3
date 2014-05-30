package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class MeniBoss extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4799042386808914156L;
	
	private MeniNaslov naslov;
	private MeniBossOpcije opcije;
	private GridBagLayout gridBagLayoutMeniBoss;
	/**
	 * Create the panel.
	 */
	public MeniBoss() {
		layoutSet();
		naslovSet();
		opcijeSet();
	}
	public void layoutSet(){
		setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		gridBagLayoutMeniBoss = new GridBagLayout();
		gridBagLayoutMeniBoss.columnWidths = new int[]{0};
		gridBagLayoutMeniBoss.rowHeights = new int[]{0, 0};
		gridBagLayoutMeniBoss.columnWeights = new double[]{1.0};
		gridBagLayoutMeniBoss.rowWeights = new double[]{0.0, 1.0};
		setLayout(gridBagLayoutMeniBoss);
	}
	public void naslovSet(){
		naslov = new MeniNaslov();
		GridBagConstraints gbc_naslov = new GridBagConstraints();
		gbc_naslov.anchor = GridBagConstraints.SOUTH;
		gbc_naslov.fill = GridBagConstraints.HORIZONTAL;
		gbc_naslov.insets = new Insets(0, 0, 5, 0);
		gbc_naslov.gridx = 0;
		gbc_naslov.gridy = 0;
		add(naslov, gbc_naslov);
	}
	public void opcijeSet(){
		opcije = new MeniBossOpcije();
		opcije.getBtnIzradaIzvjetaja().setText("Izrada izvještaja");
		opcije.getBtnPocetna().setText("Početna");
		GridBagConstraints gbc_opcije = new GridBagConstraints();
		gbc_opcije.anchor = GridBagConstraints.NORTH;
		gbc_opcije.fill = GridBagConstraints.HORIZONTAL;
		gbc_opcije.gridx = 0;
		gbc_opcije.gridy = 1;
		add(opcije, gbc_opcije);
	}
	public MeniBossOpcije getOpcije() {
		return opcije;
	}
	public GridBagLayout getGridBagLayoutMeniBoss(){
		return gridBagLayoutMeniBoss;
	}
}
