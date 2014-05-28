package ba.co.edgewise.jmup.components;
//
import javax.swing.*;

import java.awt.*;

import javax.swing.border.*;

public class OpcijaSadrzaj extends JPanel {

	private static final long serialVersionUID = -3434394201582930682L;
	private OpcijaNaslov naslov;
	private JPanel panelSadrzaj;
	private GridBagLayout gridBagLayout;

	public OpcijaSadrzaj(String naslov) {

		// method for setting title
		// calling methods for setting layout
		layoutSet();
		titleSet(naslov);
		panelSet();
	}

	// Getters & Setters
	public OpcijaNaslov getNaslov() {
		return naslov;
	}

	public JPanel getPanelSadrzaj() {
		return panelSadrzaj;
	}

	public void titleSet(String naslov) {
		this.naslov = new OpcijaNaslov(naslov);
		GridBagConstraints gbc_naslov = new GridBagConstraints();
		gbc_naslov.insets = new Insets(0, 0, 5, 0);
		gbc_naslov.gridx = 0;
		gbc_naslov.gridy = 0;
		gbc_naslov.fill = GridBagConstraints.BOTH;
		add(this.naslov, gbc_naslov);
	}

	public void layoutSet() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		setLayout(gridBagLayout);
	}

	public void panelSet() {
		panelSadrzaj = new JPanel();
		panelSadrzaj.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0,
				0, 0)));
		GridBagConstraints gbc_panelSadrzaj = new GridBagConstraints();
		gbc_panelSadrzaj.fill = GridBagConstraints.BOTH;
		gbc_panelSadrzaj.gridx = 0;
		gbc_panelSadrzaj.gridy = 1;
		add(panelSadrzaj, gbc_panelSadrzaj);
		panelSadrzaj.setLayout(new CardLayout(0, 0));
	}
}
