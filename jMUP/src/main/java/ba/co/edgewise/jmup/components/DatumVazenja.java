package ba.co.edgewise.jmup.components;


import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import java.awt.Insets;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
//
import net.sourceforge.jdatepicker.impl.UtilDateModel;
public class DatumVazenja extends JPanel {

	private static final long serialVersionUID = -4488705072610807979L;
	private GridBagLayout gridBagLayout;
	private JLabel lblFrom;
	private JLabel lblTo;
	
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
		gbc_lblDateOd.gridwidth = 2;
		gbc_lblDateOd.anchor = GridBagConstraints.SOUTH;
		gbc_lblDateOd.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDateOd.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOd.gridx = 2;
		gbc_lblDateOd.gridy = 1;
		add(datePickerOdKad, gbc_lblDateOd);
		

		modelDoKad = new UtilDateModel();
		datePanelDoKad = new JDatePanelImpl(modelDoKad);
		datePickerDoKad = new JDatePickerImpl(datePanelDoKad);
		
		GridBagConstraints gbc_lblDateDo = new GridBagConstraints();
		gbc_lblDateDo.gridwidth = 2;
		gbc_lblDateDo.anchor = GridBagConstraints.SOUTH;
		gbc_lblDateDo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDateDo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDo.gridx = 2;
		gbc_lblDateDo.gridy = 3;
		add(datePickerDoKad, gbc_lblDateDo);
	}
	public void layoutSet(){
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 75, 75, 72, 0};
		gridBagLayout.rowHeights = new int[] {0, 29, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	
	public void labelSet(){
		
		lblFrom = new JLabel("Od:");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.anchor = GridBagConstraints.SOUTH;
		gbc_lblFrom.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.gridx = 1;
		gbc_lblFrom.gridy = 1;
		add(lblFrom, gbc_lblFrom);
		
		
		
		lblTo = new JLabel("Do:");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.anchor = GridBagConstraints.SOUTH;
		gbc_lblTo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 1;
		gbc_lblTo.gridy = 3;
		add(lblTo, gbc_lblTo);
		
	}
	
	public void cbxSet(){	
	}

	public JDatePickerImpl getDatePickerOdKad() {
		return datePickerOdKad;
	}
	public JDatePickerImpl getDatePickerDoKad() {
		return datePickerDoKad;
	}
	

}
