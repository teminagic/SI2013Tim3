package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;


public class GodisnjaOvjeraPretraga extends JPanel {
	
	private static final long serialVersionUID = 5406308448672393852L;
	private GridBagLayout gridBagLayout;
	private JTextField txtId;
	private JLabel lblId;
	private BtAzuriranje btnModify;
	
	public GodisnjaOvjeraPretraga() {		
		//set title
		setBorder(new TitledBorder(null, "Pretraga", TitledBorder.LEADING, TitledBorder.TOP, null, null));	
		//layout initialization call
		layoutSet();
		labelSet();
		uiControlSet();
		
	}
	
	//methods for layout
	public void layoutSet(){
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{25, 186, 0, 0};
		gridBagLayout.rowHeights = new int[]{24, 39, 39};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
	} 
	
	public void labelSet(){
		lblId = new JLabel("Identifikacijski broj saobra\u0107ajne dozvole:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
	}
	
	public void uiControlSet(){
		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 1;
		add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		btnModify = new BtAzuriranje();
		GridBagConstraints gbc_btg = new GridBagConstraints();
		gbc_btg.anchor = GridBagConstraints.NORTH;
		gbc_btg.insets = new Insets(5, 5, 0, 5);
		gbc_btg.gridx = 1;
		gbc_btg.gridy = 2;
		add(btnModify, gbc_btg);
	}
	
	//getters & setters
	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}
	public BtAzuriranje getModifyPanel(){
		return btnModify;
	}

}
