package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BtAzuriranje extends JPanel {

	private static final long serialVersionUID = 1269892107889503346L;
	@SuppressWarnings("unused")
	private GridBagLayout gridBagLayout;
	private JButton btnModify;

	public BtAzuriranje() {	
		layoutSet();
		buttonSet();
	}
	
	//set layout
	public void layoutSet() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 129, 0, 0};
		gridBagLayout.rowHeights = new int[]{4, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	
	public void buttonSet() {
		
		btnModify = new JButton("Potvrdi");
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 5, 5);
		gbc_btnModify.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModify.gridx = 1;
		gbc_btnModify.gridy = 1;
		add(btnModify, gbc_btnModify);
		
	}
	
	
	//getters & setters
	public JButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(JButton btnModify) {
		this.btnModify = btnModify;
	}

}
