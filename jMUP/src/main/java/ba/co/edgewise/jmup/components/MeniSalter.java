package co.ba.edgewise.components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class MeniSalter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4799042386808914156L;
	
	private MeniNaslov naslov;
	private MeniSalterOpcije opcije;
	private GridBagLayout gridBagLayoutMeniSalter;
	
	/**
	 * Create the panel.
	 */
	public MeniSalter() {
		layoutSet();
		naslovSet();
		meniSet();
	}
	public void meniSet(){
		opcije = new MeniSalterOpcije();
		GridBagConstraints gbc_opcije = new GridBagConstraints();
		gbc_opcije.anchor = GridBagConstraints.NORTH;
		gbc_opcije.fill = GridBagConstraints.HORIZONTAL;
		gbc_opcije.gridx = 0;
		gbc_opcije.gridy = 1;
		add(opcije, gbc_opcije);

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
	public void layoutSet(){
		setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		gridBagLayoutMeniSalter = new GridBagLayout();
		gridBagLayoutMeniSalter.columnWidths = new int[]{0};
		gridBagLayoutMeniSalter.rowHeights = new int[]{0, 0};
		gridBagLayoutMeniSalter.columnWeights = new double[]{1.0};
		gridBagLayoutMeniSalter.rowWeights = new double[]{0.0, 1.0};
		setLayout(gridBagLayoutMeniSalter);
	}
	public MeniSalterOpcije getOpcije() {
		return opcije;
	}
	public GridBagLayout getGridBagLayoutMeniSalter() {
		return gridBagLayoutMeniSalter;
	}
}
