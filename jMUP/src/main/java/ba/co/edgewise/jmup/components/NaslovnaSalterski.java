package ba.co.edgewise.jmup.components;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.UIManager;

//
public class NaslovnaSalterski extends JPanel {

	private static final long serialVersionUID = 5024410961356941371L;
	
	private GridBagLayout gridBagLayout;
	private JLabel lblDobrodoslice;
	
	public NaslovnaSalterski() {
		// Glavni je ovaj okolo, tako sam samo njega stvorio
		layoutGlavniSet();
		// Pa onda panele na njemu stvorim
		panelSet();
		// Pa onda na panelima ostale greedLayoutee 
		layoutOstaliSet();
		// Bio sam sve grupisao, ali onda se nisu vidjeli buttoni za detalje
		lblSet();
		btnSet();		
	}
	public void layoutGlavniSet(){
		setBorder(new TitledBorder(null, "Šalter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{54, 36, 0, 0, 0, 0, 25, 0, 7, 0, 51, 84, 27, 0};
		gridBagLayout.rowHeights = new int[]{77, 0, 70, 70, 70, 15, 20, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
	public void panelSet(){
		
		lblDobrodoslice = new JLabel("Dobrodošao/la!");
		lblDobrodoslice.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblDobrodoslice = new GridBagConstraints();
		gbc_lblDobrodoslice.gridwidth = 6;
		gbc_lblDobrodoslice.insets = new Insets(0, 0, 5, 5);
		gbc_lblDobrodoslice.gridx = 5;
		gbc_lblDobrodoslice.gridy = 0;
		add(lblDobrodoslice, gbc_lblDobrodoslice);
	}
	public void layoutOstaliSet()
	{
	}
	
	public void lblSet(){
	}
	
	public void btnSet(){

	}
	
	// Getteri Layoutovi:
	
	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	
	// Getteri paneli

	// Getteri labele
	public JLabel  getLblDobrodoslice() {
		return lblDobrodoslice;
	}


}
