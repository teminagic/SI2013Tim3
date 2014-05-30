package ba.co.edgewise.jmup.components;


import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
//
import net.sourceforge.jdatepicker.impl.UtilDateModel;
@SuppressWarnings("rawtypes")
public class DatumVazenja extends JPanel {

	private static final long serialVersionUID = -4488705072610807979L;
	private GridBagLayout gridBagLayout;
	private JLabel lblFrom;
	private JLabel lblTo;
	private BtAzuriranje btAzuriranje;
	
	private UtilDateModel modelOdKad;
	private JDatePanelImpl datePanelOdKad;
	private JDatePickerImpl datePickerOdKad;
	
	private UtilDateModel modelDoKad;
	private JDatePanelImpl datePanelDoKad;
	private JDatePickerImpl datePickerDoKad;
	 
	//frame.add(datePicker);
	public DatumVazenja() {
		
		//set broder and title
		setBorder(new TitledBorder(null, "Datum va\u017Eenja", TitledBorder.LEADING, TitledBorder.TOP, null, null));	
		//calling methods to set layout
	
		layoutSet();
		labelSet();
		cbxSet();
		dateSet();
	}
	public void dateSet()
	{
		modelOdKad = new UtilDateModel();
		datePanelOdKad = new JDatePanelImpl(modelOdKad);
		datePickerOdKad = new JDatePickerImpl(datePanelOdKad);
		
		GridBagConstraints gbc_lblDateOd = new GridBagConstraints();
		gbc_lblDateOd.anchor = GridBagConstraints.SOUTH;
		gbc_lblDateOd.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDateOd.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOd.gridx = 2;
		gbc_lblDateOd.gridy = 0;
		add(datePickerOdKad, gbc_lblDateOd);
		

		modelDoKad = new UtilDateModel();
		datePanelDoKad = new JDatePanelImpl(modelDoKad);
		datePickerDoKad = new JDatePickerImpl(datePanelDoKad);
		
		GridBagConstraints gbc_lblDateDo = new GridBagConstraints();
		gbc_lblDateDo.anchor = GridBagConstraints.SOUTH;
		gbc_lblDateDo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDateDo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDo.gridx = 2;
		gbc_lblDateDo.gridy = 2;
		add(datePickerDoKad, gbc_lblDateDo);
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

	public BtAzuriranje getBtAzuriranje() {
		return btAzuriranje;
	}

	public JDatePickerImpl getDatePickerOdKad() {
		return datePickerOdKad;
	}
	public JDatePickerImpl getDatePickerDoKad() {
		return datePickerDoKad;
	}
	

}
