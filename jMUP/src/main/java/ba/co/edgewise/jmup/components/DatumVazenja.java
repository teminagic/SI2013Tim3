
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
//
@SuppressWarnings("rawtypes")
public class DatumVazenja extends JPanel {

	private static final long serialVersionUID = -4488705072610807979L;
	private GridBagLayout gridBagLayout;
	private JLabel lblFrom;
	private JLabel lblTo;
	private JComboBox cbxFrom_1;
	private JComboBox cbxFrom_2;
	private JComboBox cbxFrom_3;
	private JComboBox cbxTo_1;
	private JComboBox cbxTo_2;
	private JComboBox cbxTo_3;
	private BtAzuriranje btAzuriranje;

	public DatumVazenja() {
		
		//set broder and title
		setBorder(new TitledBorder(null, "Datum va\u017Eenja", TitledBorder.LEADING, TitledBorder.TOP, null, null));	
		//calling methods to set layout
		layoutSet();
		labelSet();
		cbxSet();

	}
	
	public void layoutSet(){
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 75, 75, 72, 0};
		gridBagLayout.rowHeights = new int[] {29, 0, 35, 45, 33, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	
	public void labelSet(){
		
		lblFrom = new JLabel("Od:");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.anchor = GridBagConstraints.SOUTH;
		gbc_lblFrom.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.gridx = 1;
		gbc_lblFrom.gridy = 0;
		add(lblFrom, gbc_lblFrom);
		
		lblTo = new JLabel("Do:");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.anchor = GridBagConstraints.SOUTH;
		gbc_lblTo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 1;
		gbc_lblTo.gridy = 2;
		add(lblTo, gbc_lblTo);
		
	}
	
	public void cbxSet(){
		
		cbxFrom_1 = new JComboBox();
		cbxFrom_1.setModel(new DefaultComboBoxModel(new String[] {"Dan"}));
		cbxFrom_1.setToolTipText("Dan");
		GridBagConstraints gbc_cbxFrom_1 = new GridBagConstraints();
		gbc_cbxFrom_1.fill = GridBagConstraints.BOTH;
		gbc_cbxFrom_1.insets = new Insets(0, 0, 5, 5);
		gbc_cbxFrom_1.gridx = 1;
		gbc_cbxFrom_1.gridy = 1;
		add(cbxFrom_1, gbc_cbxFrom_1);
		
		cbxFrom_2 = new JComboBox();
		cbxFrom_2.setModel(new DefaultComboBoxModel(new String[] {"Mjesec"}));
		cbxFrom_2.setToolTipText("Mjesec");
		GridBagConstraints gbc_cbxFrom_2 = new GridBagConstraints();
		gbc_cbxFrom_2.insets = new Insets(0, 0, 5, 5);
		gbc_cbxFrom_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxFrom_2.gridx = 2;
		gbc_cbxFrom_2.gridy = 1;
		add(cbxFrom_2, gbc_cbxFrom_2);
		
		cbxFrom_3 = new JComboBox();
		cbxFrom_3.setModel(new DefaultComboBoxModel(new String[] {"Godina"}));
		cbxFrom_3.setToolTipText("Godina");
		GridBagConstraints gbc_cbxFrom_3 = new GridBagConstraints();
		gbc_cbxFrom_3.insets = new Insets(0, 0, 5, 5);
		gbc_cbxFrom_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxFrom_3.gridx = 3;
		gbc_cbxFrom_3.gridy = 1;
		add(cbxFrom_3, gbc_cbxFrom_3);
		
	
		
		cbxTo_1 = new JComboBox();
		cbxTo_1.setModel(new DefaultComboBoxModel(new String[] {"Dan"}));
		GridBagConstraints gbc_cbxTo_1 = new GridBagConstraints();
		gbc_cbxTo_1.anchor = GridBagConstraints.NORTH;
		gbc_cbxTo_1.insets = new Insets(0, 0, 5, 5);
		gbc_cbxTo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTo_1.gridx = 1;
		gbc_cbxTo_1.gridy = 3;
		add(cbxTo_1, gbc_cbxTo_1);
		
		cbxTo_2 = new JComboBox();
		cbxTo_2.setModel(new DefaultComboBoxModel(new String[] {"Mjesec"}));
		GridBagConstraints gbc_cbxTo_2 = new GridBagConstraints();
		gbc_cbxTo_2.anchor = GridBagConstraints.NORTH;
		gbc_cbxTo_2.insets = new Insets(0, 0, 5, 5);
		gbc_cbxTo_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTo_2.gridx = 2;
		gbc_cbxTo_2.gridy = 3;
		add(cbxTo_2, gbc_cbxTo_2);
		
		cbxTo_3 = new JComboBox();
		cbxTo_3.setModel(new DefaultComboBoxModel(new String[] {"Godina"}));
		GridBagConstraints gbc_cbxTo_3 = new GridBagConstraints();
		gbc_cbxTo_3.anchor = GridBagConstraints.NORTH;
		gbc_cbxTo_3.insets = new Insets(0, 0, 5, 5);
		gbc_cbxTo_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTo_3.gridx = 3;
		gbc_cbxTo_3.gridy = 3;
		add(cbxTo_3, gbc_cbxTo_3);
		
		btAzuriranje = new BtAzuriranje();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) btAzuriranje.getLayout();
		gridBagLayout_1.rowWeights = new double[]{1.0, 0.0, 1.0};
		gridBagLayout_1.rowHeights = new int[]{4, 0, 0};
		gridBagLayout_1.columnWeights = new double[]{1.0, 0.0, 1.0};
		gridBagLayout_1.columnWidths = new int[]{0, 129, 0};
		GridBagConstraints gbc_btAzuriranje = new GridBagConstraints();
		gbc_btAzuriranje.insets = new Insets(0, 0, 5, 5);
		gbc_btAzuriranje.gridwidth = 3;
		gbc_btAzuriranje.fill = GridBagConstraints.BOTH;
		gbc_btAzuriranje.gridx = 1;
		gbc_btAzuriranje.gridy = 4;
		add(btAzuriranje, gbc_btAzuriranje);
		
	}
	
	//getters & setters
	public JComboBox getCbxFrom_1() {
		return cbxFrom_1;
	}

	public void setCbxFrom_1(JComboBox cbxFrom_1) {
		this.cbxFrom_1 = cbxFrom_1;
	}

	public JComboBox getCbxFrom_2() {
		return cbxFrom_2;
	}

	public void setCbxFrom_2(JComboBox cbxFrom_2) {
		this.cbxFrom_2 = cbxFrom_2;
	}

	public JComboBox getCbxFrom_3() {
		return cbxFrom_3;
	}

	public void setCbxFrom_3(JComboBox cbxFrom_3) {
		this.cbxFrom_3 = cbxFrom_3;
	}

	public JComboBox getCbxTo_1() {
		return cbxTo_1;
	}

	public void setCbxTo_1(JComboBox cbxTo_1) {
		this.cbxTo_1 = cbxTo_1;
	}

	public JComboBox getCbxTo_2() {
		return cbxTo_2;
	}

	public void setCbxTo_2(JComboBox cbxTo_2) {
		this.cbxTo_2 = cbxTo_2;
	}

	public JComboBox getCbxTo_3() {
		return cbxTo_3;
	}

	public void setCbxTo_3(JComboBox cbxTo_3) {
		this.cbxTo_3 = cbxTo_3;
	}

}
