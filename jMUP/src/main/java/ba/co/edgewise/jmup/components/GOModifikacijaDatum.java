package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;

public class GOModifikacijaDatum extends JPanel {
	
	private static final long serialVersionUID = 775345133972054899L;
	private GridBagLayout gridBagLayout;
	private DatumVazenja registrationDate;
	
	public GOModifikacijaDatum() {
		
		layoutSet(); //
		componentSet();
	
	}
	
	public void layoutSet(){
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{201};
		gridBagLayout.rowHeights = new int[]{0, 243, -22};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0};
		setLayout(gridBagLayout);
	}
	
	public void componentSet(){
		
		registrationDate = new DatumVazenja();
		
		GridBagConstraints gbc_registrationDate = new GridBagConstraints();
		gbc_registrationDate.fill = GridBagConstraints.BOTH;
		gbc_registrationDate.insets = new Insets(5, 5, 5, 0);
		gbc_registrationDate.gridx = 0;
		gbc_registrationDate.gridy = 1;
		add(registrationDate, gbc_registrationDate);
		
		
	}

}
