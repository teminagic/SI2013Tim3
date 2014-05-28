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
	private DatumPrveRegistracije prva;
	private JLabel lblRegistrationString;
	private JLabel lblId;
	private JLabel lblConfirmationNumber;
	private JTextField txtRegistrationString;
	private JTextField txtId;
	private JTextField txtConfirmationNumber;

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
		gridBagLayout.rowHeights = new int[] { 34, 34, 34, 182, 77, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
	}

	public void labelSet() {

		lblRegistrationString = new JLabel("Registarska oznaka");
		GridBagConstraints gbc_lblRegistrationString = new GridBagConstraints();
		gbc_lblRegistrationString.anchor = GridBagConstraints.EAST;
		gbc_lblRegistrationString.insets = new Insets(15, 5, 5, 5);
		gbc_lblRegistrationString.gridx = 1;
		gbc_lblRegistrationString.gridy = 0;
		add(lblRegistrationString, gbc_lblRegistrationString);

		lblId = new JLabel("JMBG/ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(3, 5, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);

		lblConfirmationNumber = new JLabel("Broj potvrde");
		GridBagConstraints gbc_lblConfirmationNumber = new GridBagConstraints();
		gbc_lblConfirmationNumber.insets = new Insets(0, 5, 5, 5);
		gbc_lblConfirmationNumber.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmationNumber.gridx = 1;
		gbc_lblConfirmationNumber.gridy = 2;
		add(lblConfirmationNumber, gbc_lblConfirmationNumber);

	}

	public void inputSet() {

		txtRegistrationString = new JTextField();
		GridBagConstraints gbc_txtRegistrationString = new GridBagConstraints();
		gbc_txtRegistrationString.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRegistrationString.insets = new Insets(15, 0, 5, 5);
		gbc_txtRegistrationString.gridx = 2;
		gbc_txtRegistrationString.gridy = 0;
		add(txtRegistrationString, gbc_txtRegistrationString);
		txtRegistrationString.setColumns(10);

		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(5, 0, 5, 5);
		gbc_txtId.gridx = 2;
		gbc_txtId.gridy = 1;
		add(txtId, gbc_txtId);
		txtId.setColumns(10);

		txtConfirmationNumber = new JTextField();
		txtConfirmationNumber.setText("");
		GridBagConstraints gbc_txtConfirmationNumber = new GridBagConstraints();
		gbc_txtConfirmationNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConfirmationNumber.insets = new Insets(0, 0, 5, 5);
		gbc_txtConfirmationNumber.gridx = 2;
		gbc_txtConfirmationNumber.gridy = 2;
		add(txtConfirmationNumber, gbc_txtConfirmationNumber);
		txtConfirmationNumber.setColumns(10);

	}

	public void componentSet() {

		date = new DatumVazenja();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) date.getLayout();
		gridBagLayout_1.columnWidths = new int[] { 0 };
		gridBagLayout_1.rowHeights = new int[] { 0 };
		GridBagConstraints gbc_date = new GridBagConstraints();
		gbc_date.fill = GridBagConstraints.BOTH;
		gbc_date.gridwidth = 2;
		gbc_date.insets = new Insets(17, 5, 5, 5);
		gbc_date.gridx = 1;
		gbc_date.gridy = 3;
		add(date, gbc_date);

		prva = new DatumPrveRegistracije();
		GridBagConstraints gbc_prva = new GridBagConstraints();
		gbc_prva.fill = GridBagConstraints.HORIZONTAL;
		gbc_prva.insets = new Insets(0, 0, 0, 5);
		gbc_prva.gridwidth = 2;
		gbc_prva.gridx = 1;
		gbc_prva.gridy = 4;
		add(prva, gbc_prva);

	}

	// Getters & Setters
	public JTextField getTxtRegistrationString() {
		return txtRegistrationString;
	}

	public void setTxtRegistrationString(JTextField txtRegistrationString) {
		this.txtRegistrationString = txtRegistrationString;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtConfirmationNumber() {
		return txtConfirmationNumber;
	}

	public void setTxtConfirmationNumber(JTextField txtConfirmationNumber) {
		this.txtConfirmationNumber = txtConfirmationNumber;
	}

	public DatumVazenja getDatumVazenja() {
		return date;
	}
}
