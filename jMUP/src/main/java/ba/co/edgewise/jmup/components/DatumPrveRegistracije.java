package ba.co.edgewise.jmup.components;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("rawtypes")
public class DatumPrveRegistracije extends JPanel {

	private static final long serialVersionUID = 1292113200689224124L;
	private GridBagLayout gridBagLayout;
	private JComboBox cbxFirstRegistration_1;
	private JComboBox cbxFirstRegistration_2;
	private JComboBox cbxFirstRegistration_3;
	
	public DatumPrveRegistracije() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum prve registracije", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		layoutSet();
		inputSet();
	
	}
	
	public void layoutSet(){
	
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 75, 75, 75, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	
	public void inputSet(){
		
		cbxFirstRegistration_1 = new JComboBox();
		cbxFirstRegistration_1.setModel(new DefaultComboBoxModel(new String[] {"Dan"}));
		cbxFirstRegistration_1.setToolTipText("Dan");
		GridBagConstraints gbc_cbxFirstRegistration_1 = new GridBagConstraints();
		gbc_cbxFirstRegistration_1.insets = new Insets(15, 0, 5, 5);
		gbc_cbxFirstRegistration_1.fill = GridBagConstraints.BOTH;
		gbc_cbxFirstRegistration_1.gridx = 1;
		gbc_cbxFirstRegistration_1.gridy = 0;
		add(cbxFirstRegistration_1, gbc_cbxFirstRegistration_1);
		
		cbxFirstRegistration_2 = new JComboBox();
		cbxFirstRegistration_2.setModel(new DefaultComboBoxModel(new String[] {"Mjesec"}));
		cbxFirstRegistration_2.setToolTipText("Mjesec");
		GridBagConstraints gbc_cbxFirstRegistration_2 = new GridBagConstraints();
		gbc_cbxFirstRegistration_2.insets = new Insets(15, 0, 5, 5);
		gbc_cbxFirstRegistration_2.fill = GridBagConstraints.BOTH;
		gbc_cbxFirstRegistration_2.gridx = 2;
		gbc_cbxFirstRegistration_2.gridy = 0;
		add(cbxFirstRegistration_2, gbc_cbxFirstRegistration_2);
		cbxFirstRegistration_3 = new JComboBox();
		cbxFirstRegistration_3.setModel(new DefaultComboBoxModel(new String[] {"Godina"}));
		cbxFirstRegistration_3.setToolTipText("Godina");
		GridBagConstraints gbc_cbxFirstRegistration_3 = new GridBagConstraints();
		gbc_cbxFirstRegistration_3.insets = new Insets(15, 0, 5, 5);
		gbc_cbxFirstRegistration_3.fill = GridBagConstraints.BOTH;
		gbc_cbxFirstRegistration_3.gridx = 3;
		gbc_cbxFirstRegistration_3.gridy = 0;
		add(cbxFirstRegistration_3, gbc_cbxFirstRegistration_3);
		
	}

	//getters & setters
	public JComboBox getCbxFirstRegistration_1() {
		return cbxFirstRegistration_1;
	}

	public void setCbxFirstRegistration_1(JComboBox cbxFirstRegistration_1) {
		this.cbxFirstRegistration_1 = cbxFirstRegistration_1;
	}

	public JComboBox getCbxFirstRegistration_2() {
		return cbxFirstRegistration_2;
	}

	public void setCbxFirstRegistration_2(JComboBox cbxFirstRegistration_2) {
		this.cbxFirstRegistration_2 = cbxFirstRegistration_2;
	}

	public JComboBox getCbxFirstRegistration_3() {
		return cbxFirstRegistration_3;
	}

	public void setCbxFirstRegistration_3(JComboBox cbxFirstRegistration_3) {
		this.cbxFirstRegistration_3 = cbxFirstRegistration_3;
	}
}
