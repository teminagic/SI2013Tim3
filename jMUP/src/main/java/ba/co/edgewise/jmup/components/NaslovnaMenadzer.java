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

public class NaslovnaMenadzer extends JPanel {

	private static final long serialVersionUID = 5024410961356941371L;
	
	private GridBagLayout gridBagLayout;
	private GridBagLayout gbl_notifikacija1;
	private GridBagLayout gbl_notifikacija2;
	private GridBagLayout gbl_notifikacija3;
	
	private JPanel pnlNotifikacija1;
	private JPanel pnlNotifikacija2;
	private JPanel pnlNotifikacija3;
	private JLabel lblNotifikacija1;
	private JLabel lblNotifikacija2;
	private JLabel lblNotifikacija3;
	private JButton btnPrethodna;
	private JButton btnDetalji1;
	private JLabel lblDobrodoslice;
	private JButton btnDetalji2;
	private JButton btnDetalji3;
	private JButton btnSljedeca;
	
	public NaslovnaMenadzer() {
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
		setBorder(new TitledBorder(null, "Menadžer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 36, 0, 0, 0, 0, 25, 0, 7, 0, 51, 84, 0, 0};
		gridBagLayout.rowHeights = new int[]{77, 0, 70, 70, 70, 15, 20, 16, 0};
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
		pnlNotifikacija1 = new JPanel();
		pnlNotifikacija1.setBorder(new TitledBorder(null, "Notifikacija 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_notifikacija1 = new GridBagConstraints();
		gbc_notifikacija1.insets = new Insets(0, 0, 5, 5);
		gbc_notifikacija1.gridwidth = 11;
		gbc_notifikacija1.fill = GridBagConstraints.BOTH;
		gbc_notifikacija1.gridx = 1;
		gbc_notifikacija1.gridy = 2;
		add(pnlNotifikacija1, gbc_notifikacija1);
		
		pnlNotifikacija2 = new JPanel();
		pnlNotifikacija2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Notifikacija 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_notifikacija2 = new GridBagConstraints();
		gbc_notifikacija2.gridwidth = 11;
		gbc_notifikacija2.insets = new Insets(0, 0, 5, 5);
		gbc_notifikacija2.fill = GridBagConstraints.BOTH;
		gbc_notifikacija2.gridx = 1;
		gbc_notifikacija2.gridy = 3;
		add(pnlNotifikacija2, gbc_notifikacija2);
		
		pnlNotifikacija3 = new JPanel();
		pnlNotifikacija3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Notifikacija 3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_notifikacija3 = new GridBagConstraints();
		gbc_notifikacija3.gridwidth = 11;
		gbc_notifikacija3.insets = new Insets(0, 0, 5, 5);
		gbc_notifikacija3.fill = GridBagConstraints.BOTH;
		gbc_notifikacija3.gridx = 1;
		gbc_notifikacija3.gridy = 4;
		add(pnlNotifikacija3, gbc_notifikacija3);
	}
	public void layoutOstaliSet()
	{
		gbl_notifikacija1 = new GridBagLayout();
		gbl_notifikacija1.columnWidths = new int[]{260, 0, 0, 0, 0, 0, 0, 52, 0};
		gbl_notifikacija1.rowHeights = new int[]{0, 0};
		gbl_notifikacija1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_notifikacija1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlNotifikacija1.setLayout(gbl_notifikacija1);
		
		gbl_notifikacija2 = new GridBagLayout();
		gbl_notifikacija2.columnWidths = new int[]{260, 0, 0, 0, 0, 0, 0, 0};
		gbl_notifikacija2.rowHeights = new int[]{0, 0};
		gbl_notifikacija2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_notifikacija2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlNotifikacija2.setLayout(gbl_notifikacija2);
		
		gbl_notifikacija3 = new GridBagLayout();
		gbl_notifikacija3.columnWidths = new int[]{257, 0, 0, 0, 0, 0, 0, 0};
		gbl_notifikacija3.rowHeights = new int[]{28, 0};
		gbl_notifikacija3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_notifikacija3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlNotifikacija3.setLayout(gbl_notifikacija3);
	}
	
	public void lblSet(){
		
		lblNotifikacija1 = new JLabel("Tekst o notifikaciji 1...");
		GridBagConstraints gbc_lblNotifikacija1 = new GridBagConstraints();
		gbc_lblNotifikacija1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNotifikacija1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNotifikacija1.gridx = 0;
		gbc_lblNotifikacija1.gridy = 0;
		pnlNotifikacija1.add(lblNotifikacija1, gbc_lblNotifikacija1);
		
		btnDetalji1 = new JButton("Detalji");
		GridBagConstraints gbc_btnDetalji1 = new GridBagConstraints();
		gbc_btnDetalji1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDetalji1.gridwidth = 2;
		gbc_btnDetalji1.insets = new Insets(0, 0, 0, 5);
		gbc_btnDetalji1.gridx = 6;
		gbc_btnDetalji1.gridy = 0;
		pnlNotifikacija1.add(btnDetalji1, gbc_btnDetalji1);
		
		lblNotifikacija2 = new JLabel("Tekst o notifikaciji 2...");
		GridBagConstraints gbc_lblNotifikacija2 = new GridBagConstraints();
		gbc_lblNotifikacija2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNotifikacija2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNotifikacija2.gridx = 0;
		gbc_lblNotifikacija2.gridy = 0;
		pnlNotifikacija2.add(lblNotifikacija2, gbc_lblNotifikacija2);
		
		btnDetalji2 = new JButton("Detalji");
		GridBagConstraints gbc_btnDetalji2 = new GridBagConstraints();
		gbc_btnDetalji2.gridwidth = 2;
		gbc_btnDetalji2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDetalji2.gridx = 6;
		gbc_btnDetalji2.gridy = 0;
		pnlNotifikacija2.add(btnDetalji2, gbc_btnDetalji2);
		
		lblNotifikacija3 = new JLabel("Tekst o notifikaciji 3...");
		GridBagConstraints gbc_lblNotifikacija3 = new GridBagConstraints();
		gbc_lblNotifikacija3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNotifikacija3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNotifikacija3.gridx = 0;
		gbc_lblNotifikacija3.gridy = 0;
		pnlNotifikacija3.add(lblNotifikacija3, gbc_lblNotifikacija3);
		
		btnDetalji3 = new JButton("Detalji");
		GridBagConstraints gbc_btnDetalji3 = new GridBagConstraints();
		gbc_btnDetalji3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDetalji3.gridwidth = 2;
		gbc_btnDetalji3.gridx = 6;
		gbc_btnDetalji3.gridy = 0;
		pnlNotifikacija3.add(btnDetalji3, gbc_btnDetalji3);
	}
	
	public void btnSet(){
		
		btnPrethodna = new JButton("<<  Prethodna");
		btnPrethodna.setEnabled(false);
		GridBagConstraints gbc_btnPrethodna = new GridBagConstraints();
		gbc_btnPrethodna.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPrethodna.gridwidth = 3;
		gbc_btnPrethodna.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrethodna.gridx = 4;
		gbc_btnPrethodna.gridy = 6;
		add(btnPrethodna, gbc_btnPrethodna);
		
		btnSljedeca = new JButton("Sljedeća  >>");
		GridBagConstraints gbc_btnSljedeca = new GridBagConstraints();
		gbc_btnSljedeca.anchor = GridBagConstraints.SOUTH;
		gbc_btnSljedeca.insets = new Insets(0, 0, 5, 5);
		gbc_btnSljedeca.gridx = 8;
		gbc_btnSljedeca.gridy = 6;
		add(btnSljedeca, gbc_btnSljedeca);

	}
	
	// Getteri Layoutovi:
	
	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}
	public GridBagLayout getgbl_notifikacija1() {
		return gbl_notifikacija1;
	}
	public GridBagLayout  getgbl_notifikacija2() {
		return gbl_notifikacija1;
	}
	public GridBagLayout  getgbl_notifikacija3() {
		return gbl_notifikacija1;
	}
	
	// Getteri paneli
	public JPanel  getPnlNotifikacija1() {
		return pnlNotifikacija1;
	}
	public JPanel  getPnlNotifikacija2() {
		return pnlNotifikacija3;
	}
	public JPanel  getPnlNotifikacija3() {
		return pnlNotifikacija3;
	}
	// Getteri labele
	public JLabel  getLblDobrodoslice() {
		return lblDobrodoslice;
	}
	public JLabel  getLblNotifikacija1() {
		return lblNotifikacija1;
	}
	public JLabel  getLblNotifikacija2() {
		return lblNotifikacija2;
	}
	public JLabel  getLblNotifikacija3() {
		return lblNotifikacija3;
	}
	
	// Getteri buttoni
	public JButton getBtnDetalji1() {
		return btnDetalji1;
	}
	public JButton getBtnDetalji2() {
		return btnDetalji2;
	}
	public JButton getBtnDetalji3() {
		return btnDetalji3;
	}
	public JButton getBtnPrethodna() {
		return btnPrethodna;
	}
	public JButton getBtnSlejdeca1() {
		return btnSljedeca;
	}

}
