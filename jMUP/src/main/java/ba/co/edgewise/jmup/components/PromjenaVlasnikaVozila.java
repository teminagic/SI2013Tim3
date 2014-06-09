package ba.co.edgewise.jmup.components;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JLabel;
//

public class PromjenaVlasnikaVozila extends JPanel {

	private static final long serialVersionUID = -9177244936706682314L;
	private JTextField tfBrojVlasnickeDozvole;
	private GridBagLayout gridBagLayout;
	private JPanel panel;
	private JButton btnAzurirajPodatke;
	private JButton btnPonisti;
	private ButtonGroup radioGroup;
	private JLabel lblBrojVlasnike;
	private JTextField tfJMBGNovogVlasnika;
	private JLabel lblJmbgNovogVlasnika;

	public PromjenaVlasnikaVozila() {
	
		setLayout();
		setPanel();
		setInput();
		setComponents();
	}
	public void setLayout(){
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 480, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 160, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
	public void setPanel(){
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Promjena vlasnika vozila", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setPreferredSize(new Dimension(410, 160));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 46, 0, 170, 0, 64, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
	}
	public void setInput(){
		
		lblBrojVlasnike = new JLabel("Broj vlasni\u010Dke dozvole:");
		GridBagConstraints gbc_lblBrojVlasnike = new GridBagConstraints();
		gbc_lblBrojVlasnike.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrojVlasnike.anchor = GridBagConstraints.EAST;
		gbc_lblBrojVlasnike.gridx = 3;
		gbc_lblBrojVlasnike.gridy = 1;
		panel.add(lblBrojVlasnike, gbc_lblBrojVlasnike);
		tfBrojVlasnickeDozvole = new JTextField();
		GridBagConstraints gbc_tfBrojVlasnickeDozvole = new GridBagConstraints();
		gbc_tfBrojVlasnickeDozvole.gridwidth = 2;
		gbc_tfBrojVlasnickeDozvole.insets = new Insets(0, 0, 5, 0);
		gbc_tfBrojVlasnickeDozvole.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBrojVlasnickeDozvole.gridx = 4;
		gbc_tfBrojVlasnickeDozvole.gridy = 1;
		panel.add(tfBrojVlasnickeDozvole, gbc_tfBrojVlasnickeDozvole);
		tfBrojVlasnickeDozvole.setColumns(10);
	}
	public void setComponents(){
		
		ButtonGroup radioGroup = new ButtonGroup();
				
				lblJmbgNovogVlasnika = new JLabel("JMBG novog vlasnika:");
				GridBagConstraints gbc_lblJmbgNovogVlasnika = new GridBagConstraints();
				gbc_lblJmbgNovogVlasnika.insets = new Insets(0, 0, 5, 5);
				gbc_lblJmbgNovogVlasnika.anchor = GridBagConstraints.EAST;
				gbc_lblJmbgNovogVlasnika.gridx = 3;
				gbc_lblJmbgNovogVlasnika.gridy = 2;
				panel.add(lblJmbgNovogVlasnika, gbc_lblJmbgNovogVlasnika);
				
				tfJMBGNovogVlasnika = new JTextField();
				GridBagConstraints gbc_tfJMBGNovogVlasnika = new GridBagConstraints();
				gbc_tfJMBGNovogVlasnika.gridwidth = 2;
				gbc_tfJMBGNovogVlasnika.insets = new Insets(0, 0, 5, 0);
				gbc_tfJMBGNovogVlasnika.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfJMBGNovogVlasnika.gridx = 4;
				gbc_tfJMBGNovogVlasnika.gridy = 2;
				panel.add(tfJMBGNovogVlasnika, gbc_tfJMBGNovogVlasnika);
				tfJMBGNovogVlasnika.setColumns(10);
		
				
				btnAzurirajPodatke = new JButton("A\u017Euriraj podatke");
				GridBagConstraints gbc_btnAzurirajPodatke = new GridBagConstraints();
				gbc_btnAzurirajPodatke.gridwidth = 2;
				gbc_btnAzurirajPodatke.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnAzurirajPodatke.insets = new Insets(0, 0, 0, 5);
				gbc_btnAzurirajPodatke.gridx = 3;
				gbc_btnAzurirajPodatke.gridy = 4;
				panel.add(btnAzurirajPodatke, gbc_btnAzurirajPodatke);
		
		btnPonisti = new JButton("Poni\u0161ti");
		GridBagConstraints gbc_btnPonisti = new GridBagConstraints();
		gbc_btnPonisti.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPonisti.gridx = 5;
		gbc_btnPonisti.gridy = 4;
		panel.add(btnPonisti, gbc_btnPonisti);
	}
	public JTextField getTfBrojVlasnickeDozvole() {
		return tfBrojVlasnickeDozvole;
	}
	public JButton getBtnAzurirajPodatke() {
		return btnAzurirajPodatke;
	}
	public JTextField getTfJMBGNovogVlasnika() {
		return tfJMBGNovogVlasnika;
	}
	public JButton getBtnPonisti() {
		return btnPonisti;
	}
}
