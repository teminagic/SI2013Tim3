package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

public class PodaciRegistracija extends JPanel {

	private static final long serialVersionUID = 5824498274241469343L;
	private GridBagLayout gridBagLayout;
	private DatumVazenja date;
	private JLabel lblConfirmationNumber;
	private JTextField tfBrojDozvole;

	public PodaciRegistracija() {

		// set border and title
		setBorder(new TitledBorder(null, "Podaci o registraciji",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		// calling methods for seting layout
		layoutSet();
		labelSet();
		inputSet();
		componentSet();

	}

	// method definitions
	public void layoutSet() {

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 109, 305, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 34, 151, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
	}

	public void labelSet() {

		lblConfirmationNumber = new JLabel("Broj dozvole");
		GridBagConstraints gbc_lblConfirmationNumber = new GridBagConstraints();
		gbc_lblConfirmationNumber.insets = new Insets(0, 5, 5, 5);
		gbc_lblConfirmationNumber.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmationNumber.gridx = 1;
		gbc_lblConfirmationNumber.gridy = 1;
		add(lblConfirmationNumber, gbc_lblConfirmationNumber);

	}

	public void inputSet() {

	}

	public void componentSet() {
		
		tfBrojDozvole = new JTextField();
		GridBagConstraints gbc_tfBrojDozvole = new GridBagConstraints();
		gbc_tfBrojDozvole.insets = new Insets(0, 0, 5, 5);
		gbc_tfBrojDozvole.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBrojDozvole.gridx = 2;
		gbc_tfBrojDozvole.gridy = 1;
		add(tfBrojDozvole, gbc_tfBrojDozvole);
		tfBrojDozvole.setColumns(10);

		date = new DatumVazenja();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) date.getLayout();
		gridBagLayout_1.columnWidths = new int[] { 0 };
		gridBagLayout_1.rowHeights = new int[] { 0 };
		GridBagConstraints gbc_date = new GridBagConstraints();
		gbc_date.fill = GridBagConstraints.BOTH;
		gbc_date.gridwidth = 2;
		gbc_date.insets = new Insets(17, 5, 5, 5);
		gbc_date.gridx = 1;
		gbc_date.gridy = 2;
		add(date, gbc_date);

	}

	// Getters & Setters

	

	public DatumVazenja getDatumVazenja() {
		return date;
	}
	public JTextField getTfBrojDozvole() {
		return tfBrojDozvole;
	}
}
