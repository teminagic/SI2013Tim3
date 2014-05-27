package ba.co.edgewise.jmup.components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GodisnjaOvjera extends JPanel {

	private static final long serialVersionUID = -3885653631539013531L;
	private GridBagLayout gridBagLayout;
	private GodisnjaOvjeraPretraga pretraga;
	private GOModifikacijaDatum datum;

	public GodisnjaOvjera() {
		
		layoutSet();
		componentSet();
		
	}
	
	public void layoutSet(){
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 278, 0};
		gridBagLayout.rowHeights = new int[]{0, 147, 29, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
	}
	
	public void componentSet(){
		
		pretraga = new GodisnjaOvjeraPretraga();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) pretraga.getLayout();
		gridBagLayout_1.columnWidths = new int[]{0, 270, 0};
		gridBagLayout_1.columnWeights = new double[]{0.0};
		GridBagConstraints gbc_pretraga = new GridBagConstraints();
		gbc_pretraga.insets = new Insets(0, 0, 5, 5);
		gbc_pretraga.gridx = 1;
		gbc_pretraga.gridy = 1;
		gbc_pretraga.fill = GridBagConstraints.BOTH;
		add(pretraga, gbc_pretraga);
		
		datum = new GOModifikacijaDatum();
		GridBagConstraints gbc_datum = new GridBagConstraints();
		gbc_datum.fill = GridBagConstraints.BOTH;
		gbc_datum.insets = new Insets(0, 0, 5, 5);
		gbc_datum.gridx = 1;
		gbc_datum.gridy = 3;
		add(datum, gbc_datum);
		
	}

}
