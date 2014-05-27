package co.ba.edgewise.components;
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


public class PromjenaVlasnikaVozila extends JPanel {

	private static final long serialVersionUID = -9177244936706682314L;
	private JTextField tfIdentifikacijskiBrojVlasnickeDozvole;
	private JTextField tfJMBGIDTrenutnogVlasnika;
	private JTextField tfRegistarskaOznakaVozila;
	private GridBagLayout gridBagLayout;
	private JPanel panel;
	private JRadioButton rdbtnIdentifikacijskiBrojVlasnike;
	private JRadioButton rdbtnJmbgidTrenutnogVlasnika;
	private JRadioButton rdbtnRegistarskaOznakaVozila;
	private JButton btnAzurirajPodatke;
	private JButton btnIzlaz;
	private ButtonGroup radioGroup;

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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u017Euriranje podataka na osnovu pretrage", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setPreferredSize(new Dimension(410, 160));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 64, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
	}
	public void setInput(){
		tfIdentifikacijskiBrojVlasnickeDozvole = new JTextField();
		GridBagConstraints gbc_tfIdentifikacijskiBrojVlasnickeDozvole = new GridBagConstraints();
		gbc_tfIdentifikacijskiBrojVlasnickeDozvole.gridwidth = 3;
		gbc_tfIdentifikacijskiBrojVlasnickeDozvole.insets = new Insets(0, 0, 5, 5);
		gbc_tfIdentifikacijskiBrojVlasnickeDozvole.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIdentifikacijskiBrojVlasnickeDozvole.gridx = 1;
		gbc_tfIdentifikacijskiBrojVlasnickeDozvole.gridy = 1;
		panel.add(tfIdentifikacijskiBrojVlasnickeDozvole, gbc_tfIdentifikacijskiBrojVlasnickeDozvole);
		tfIdentifikacijskiBrojVlasnickeDozvole.setColumns(10);
		
		tfJMBGIDTrenutnogVlasnika = new JTextField();
		tfJMBGIDTrenutnogVlasnika.setEditable(false);
		GridBagConstraints gbc_tfJMBGIDTrenutnogVlasnika = new GridBagConstraints();
		gbc_tfJMBGIDTrenutnogVlasnika.gridwidth = 3;
		gbc_tfJMBGIDTrenutnogVlasnika.insets = new Insets(0, 0, 5, 5);
		gbc_tfJMBGIDTrenutnogVlasnika.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfJMBGIDTrenutnogVlasnika.gridx = 1;
		gbc_tfJMBGIDTrenutnogVlasnika.gridy = 2;
		panel.add(tfJMBGIDTrenutnogVlasnika, gbc_tfJMBGIDTrenutnogVlasnika);
		tfJMBGIDTrenutnogVlasnika.setColumns(10);
		
		tfRegistarskaOznakaVozila = new JTextField();
		tfRegistarskaOznakaVozila.setEditable(false);
		GridBagConstraints gbc_tfRegistarskaOznakaVozila = new GridBagConstraints();
		gbc_tfRegistarskaOznakaVozila.gridwidth = 3;
		gbc_tfRegistarskaOznakaVozila.insets = new Insets(0, 0, 5, 5);
		gbc_tfRegistarskaOznakaVozila.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRegistarskaOznakaVozila.gridx = 1;
		gbc_tfRegistarskaOznakaVozila.gridy = 3;
		panel.add(tfRegistarskaOznakaVozila, gbc_tfRegistarskaOznakaVozila);
		tfRegistarskaOznakaVozila.setColumns(10);
	}
	public void setComponents(){
		rdbtnIdentifikacijskiBrojVlasnike = new JRadioButton("Identifikacijski broj vlasni\u010Dke dozvole:");
		rdbtnIdentifikacijskiBrojVlasnike.setSelected(true);
		GridBagConstraints gbc_rdbtnIdentifikacijskiBrojVlasnike = new GridBagConstraints();
		gbc_rdbtnIdentifikacijskiBrojVlasnike.anchor = GridBagConstraints.WEST;
		gbc_rdbtnIdentifikacijskiBrojVlasnike.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnIdentifikacijskiBrojVlasnike.gridx = 0;
		gbc_rdbtnIdentifikacijskiBrojVlasnike.gridy = 1;
		panel.add(rdbtnIdentifikacijskiBrojVlasnike, gbc_rdbtnIdentifikacijskiBrojVlasnike);
		
		rdbtnJmbgidTrenutnogVlasnika = new JRadioButton("JMBG/ID trenutnog vlasnika:");
		GridBagConstraints gbc_rdbtnJmbgidTrenutnogVlasnika = new GridBagConstraints();
		gbc_rdbtnJmbgidTrenutnogVlasnika.anchor = GridBagConstraints.WEST;
		gbc_rdbtnJmbgidTrenutnogVlasnika.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnJmbgidTrenutnogVlasnika.gridx = 0;
		gbc_rdbtnJmbgidTrenutnogVlasnika.gridy = 2;
		panel.add(rdbtnJmbgidTrenutnogVlasnika, gbc_rdbtnJmbgidTrenutnogVlasnika);
		
		rdbtnRegistarskaOznakaVozila = new JRadioButton("Registarska oznaka vozila:");
		GridBagConstraints gbc_rdbtnRegistarskaOznakaVozila = new GridBagConstraints();
		gbc_rdbtnRegistarskaOznakaVozila.anchor = GridBagConstraints.WEST;
		gbc_rdbtnRegistarskaOznakaVozila.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRegistarskaOznakaVozila.gridx = 0;
		gbc_rdbtnRegistarskaOznakaVozila.gridy = 3;
		panel.add(rdbtnRegistarskaOznakaVozila, gbc_rdbtnRegistarskaOznakaVozila);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnIdentifikacijskiBrojVlasnike);
		radioGroup.add(rdbtnJmbgidTrenutnogVlasnika);
		radioGroup.add(rdbtnRegistarskaOznakaVozila);

		
		btnAzurirajPodatke = new JButton("A\u017Euriraj podatke");
		GridBagConstraints gbc_btnAzurirajPodatke = new GridBagConstraints();
		gbc_btnAzurirajPodatke.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAzurirajPodatke.insets = new Insets(0, 0, 0, 5);
		gbc_btnAzurirajPodatke.gridx = 1;
		gbc_btnAzurirajPodatke.gridy = 4;
		panel.add(btnAzurirajPodatke, gbc_btnAzurirajPodatke);
		
		btnIzlaz = new JButton("Izlaz");
		GridBagConstraints gbc_btnIzlaz = new GridBagConstraints();
		gbc_btnIzlaz.gridwidth = 2;
		gbc_btnIzlaz.insets = new Insets(0, 0, 0, 5);
		gbc_btnIzlaz.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIzlaz.gridx = 2;
		gbc_btnIzlaz.gridy = 4;
		panel.add(btnIzlaz, gbc_btnIzlaz);
	}
}
