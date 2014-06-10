	package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("rawtypes")
public class DatumPrveRegistracije extends JPanel {

	private static final long serialVersionUID = 1292113200689224124L;
	private GridBagLayout gridBagLayout;
	private UtilDateModel modelPrva;
	private JDatePanelImpl datePanelPrva;
	private JDatePickerImpl datePickerPrva;
	
	public DatumPrveRegistracije() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum prve registracije", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		layoutSet();
		inputSet();
		dateSet();
	}
	public void dateSet()
	{
		modelPrva = new UtilDateModel();
		datePanelPrva= new JDatePanelImpl(modelPrva);
		datePickerPrva = new JDatePickerImpl(datePanelPrva);
		
		GridBagConstraints gbc_lblDatePrva = new GridBagConstraints();
		gbc_lblDatePrva.anchor = GridBagConstraints.SOUTH;
		gbc_lblDatePrva.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDatePrva.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatePrva.gridx = 1;
		gbc_lblDatePrva.gridy = 1;
		add(datePickerPrva, gbc_lblDatePrva);
	}
	public void layoutSet(){
	
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	}
	
	public void inputSet(){
		
	}

	
}
