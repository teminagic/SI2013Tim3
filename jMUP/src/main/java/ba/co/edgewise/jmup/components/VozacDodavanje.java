package ba.co.edgewise.jmup.components;
//s
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

public class VozacDodavanje extends JPanel {

	private static final long serialVersionUID = -6732800841205500794L;
	private JTextField tfIme;
	private JTextField tfPrezime;
	private JTextField tfAdresa;
	private JTextField tfMjesto;
	private JTextField tfOpcina;
	private ButtonGroup tipLica;
	private JTextField tfJMBG;
	private JTextField tfIdBroj;
	private JButton btnPrihvati;
	private GridBagLayout gridBagLayout;
	private JPanel panelPodaci;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblAdresa;
	private JLabel lblMjesto;
	private JLabel lblOpcina;
	private JLabel lblJmbg;
	private JLabel lblIdBroj;
	private JPanel panelPrebivaliste;
	private JRadioButton pravno;
	private JRadioButton fizicko;
	private JButton btnPonisti;


	public VozacDodavanje() {
		// methods for setting layout
		setLayout();
		setPanel();
		setDataPanel();
		setLabel();
		setInput();
		setComponents();
	}

	public void setLayout() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 266, 75, 75, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
	}

	public void setPanel() {
		panelPodaci = new JPanel();
		panelPodaci.setBorder(new TitledBorder(null, "Podaci o voza\u010Du",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelPodaci = new GridBagConstraints();
		gbc_panelPodaci.gridwidth = 3;
		gbc_panelPodaci.insets = new Insets(0, 0, 5, 5);
		gbc_panelPodaci.fill = GridBagConstraints.BOTH;
		gbc_panelPodaci.gridx = 1;
		gbc_panelPodaci.gridy = 1;
		add(panelPodaci, gbc_panelPodaci);
		GridBagLayout gbl_panelPodaci = new GridBagLayout();
		gbl_panelPodaci.columnWidths = new int[] { 120, 0, 0, 0 };
		gbl_panelPodaci.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelPodaci.columnWeights = new double[] { 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panelPodaci.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panelPodaci.setLayout(gbl_panelPodaci);
	}

	public void setDataPanel() {
		panelPrebivaliste = new JPanel();
		panelPrebivaliste.setBorder(new TitledBorder(null, "Prebivali\u0161te",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelPrebivaliste = new GridBagConstraints();
		gbc_panelPrebivaliste.insets = new Insets(0, 0, 5, 0);
		gbc_panelPrebivaliste.gridwidth = 3;
		gbc_panelPrebivaliste.fill = GridBagConstraints.BOTH;
		gbc_panelPrebivaliste.gridx = 0;
		gbc_panelPrebivaliste.gridy = 2;
		panelPodaci.add(panelPrebivaliste, gbc_panelPrebivaliste);
		GridBagLayout gbl_panelPrebivaliste = new GridBagLayout();
		gbl_panelPrebivaliste.columnWidths = new int[] { 113, 0, 0 };
		gbl_panelPrebivaliste.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelPrebivaliste.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panelPrebivaliste.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelPrebivaliste.setLayout(gbl_panelPrebivaliste);
	}

	public void setLabel() {
		lblIme = new JLabel("Ime");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.anchor = GridBagConstraints.EAST;
		gbc_lblIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblIme.gridx = 0;
		gbc_lblIme.gridy = 0;
		panelPodaci.add(lblIme, gbc_lblIme);

		lblPrezime = new JLabel("Prezime");
		GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
		gbc_lblPrezime.anchor = GridBagConstraints.EAST;
		gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezime.gridx = 0;
		gbc_lblPrezime.gridy = 1;
		panelPodaci.add(lblPrezime, gbc_lblPrezime);

		lblAdresa = new JLabel("Adresa");
		GridBagConstraints gbc_lblAdresa = new GridBagConstraints();
		gbc_lblAdresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresa.anchor = GridBagConstraints.EAST;
		gbc_lblAdresa.gridx = 0;
		gbc_lblAdresa.gridy = 0;
		panelPrebivaliste.add(lblAdresa, gbc_lblAdresa);

		lblMjesto = new JLabel("Mjesto");
		GridBagConstraints gbc_lblMjesto = new GridBagConstraints();
		gbc_lblMjesto.anchor = GridBagConstraints.EAST;
		gbc_lblMjesto.insets = new Insets(0, 0, 5, 5);
		gbc_lblMjesto.gridx = 0;
		gbc_lblMjesto.gridy = 1;
		panelPrebivaliste.add(lblMjesto, gbc_lblMjesto);

		lblOpcina = new JLabel("Općina");
		GridBagConstraints gbc_lblOpcina = new GridBagConstraints();
		gbc_lblOpcina.anchor = GridBagConstraints.EAST;
		gbc_lblOpcina.insets = new Insets(0, 0, 0, 5);
		gbc_lblOpcina.gridx = 0;
		gbc_lblOpcina.gridy = 2;
		panelPrebivaliste.add(lblOpcina, gbc_lblOpcina);

		lblJmbg = new JLabel("JMBG");
		GridBagConstraints gbc_lblJmbg = new GridBagConstraints();
		gbc_lblJmbg.anchor = GridBagConstraints.EAST;
		gbc_lblJmbg.insets = new Insets(0, 0, 5, 5);
		gbc_lblJmbg.gridx = 0;
		gbc_lblJmbg.gridy = 4;
		panelPodaci.add(lblJmbg, gbc_lblJmbg);

		lblIdBroj = new JLabel("ID broj");
		GridBagConstraints gbc_lblIdBroj = new GridBagConstraints();
		gbc_lblIdBroj.anchor = GridBagConstraints.EAST;
		gbc_lblIdBroj.insets = new Insets(0, 0, 0, 5);
		gbc_lblIdBroj.gridx = 0;
		gbc_lblIdBroj.gridy = 5;
		panelPodaci.add(lblIdBroj, gbc_lblIdBroj);
	}

	public void setInput() {
		tfIme = new JTextField();
		GridBagConstraints gbc_tfIme = new GridBagConstraints();
		gbc_tfIme.gridwidth = 2;
		gbc_tfIme.insets = new Insets(0, 0, 5, 5);
		gbc_tfIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIme.gridx = 1;
		gbc_tfIme.gridy = 0;
		panelPodaci.add(tfIme, gbc_tfIme);
		tfIme.setColumns(10);

		tfPrezime = new JTextField();
		GridBagConstraints gbc_tfPrezime = new GridBagConstraints();
		gbc_tfPrezime.gridwidth = 2;
		gbc_tfPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_tfPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrezime.gridx = 1;
		gbc_tfPrezime.gridy = 1;
		panelPodaci.add(tfPrezime, gbc_tfPrezime);
		tfPrezime.setColumns(10);

		tfAdresa = new JTextField();
		GridBagConstraints gbc_tfAdresa = new GridBagConstraints();
		gbc_tfAdresa.insets = new Insets(0, 0, 5, 0);
		gbc_tfAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAdresa.gridx = 1;
		gbc_tfAdresa.gridy = 0;
		panelPrebivaliste.add(tfAdresa, gbc_tfAdresa);
		tfAdresa.setColumns(10);

		tfMjesto = new JTextField();
		GridBagConstraints gbc_tfMjesto = new GridBagConstraints();
		gbc_tfMjesto.insets = new Insets(0, 0, 5, 0);
		gbc_tfMjesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMjesto.gridx = 1;
		gbc_tfMjesto.gridy = 1;
		panelPrebivaliste.add(tfMjesto, gbc_tfMjesto);
		tfMjesto.setColumns(10);

		tfOpcina = new JTextField();
		GridBagConstraints gbc_tfOpcina = new GridBagConstraints();
		gbc_tfOpcina.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfOpcina.gridx = 1;
		gbc_tfOpcina.gridy = 2;
		panelPrebivaliste.add(tfOpcina, gbc_tfOpcina);
		tfOpcina.setColumns(10);

		tfJMBG = new JTextField();
		GridBagConstraints gbc_tfJMBG = new GridBagConstraints();
		gbc_tfJMBG.gridwidth = 2;
		gbc_tfJMBG.insets = new Insets(0, 0, 5, 5);
		gbc_tfJMBG.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfJMBG.gridx = 1;
		gbc_tfJMBG.gridy = 4;
		panelPodaci.add(tfJMBG, gbc_tfJMBG);
		tfJMBG.setColumns(10);

		tfIdBroj = new JTextField();
		GridBagConstraints gbc_tfIdBroj = new GridBagConstraints();
		gbc_tfIdBroj.gridwidth = 2;
		gbc_tfIdBroj.insets = new Insets(0, 0, 5, 5);
		gbc_tfIdBroj.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIdBroj.gridx = 1;
		gbc_tfIdBroj.gridy = 5;
		panelPodaci.add(tfIdBroj, gbc_tfIdBroj);
		tfIdBroj.setEditable(false);
		tfIdBroj.setColumns(10);

	}

	

	public void setComponents() {
		tipLica = new ButtonGroup();

		pravno = new JRadioButton("pravno");
		GridBagConstraints gbc_pravno = new GridBagConstraints();
		gbc_pravno.insets = new Insets(0, 0, 5, 5);
		gbc_pravno.gridx = 1;
		gbc_pravno.gridy = 3;
		panelPodaci.add(pravno, gbc_pravno);
		tipLica.add(pravno);

		fizicko = new JRadioButton("fizičko");
		GridBagConstraints gbc_fizicko = new GridBagConstraints();
		gbc_fizicko.insets = new Insets(0, 0, 5, 5);
		gbc_fizicko.gridx = 2;
		gbc_fizicko.gridy = 3;
		panelPodaci.add(fizicko, gbc_fizicko);
		fizicko.setSelected(true);
		tipLica.add(fizicko);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(pravno);
		radioGroup.add(fizicko);

		btnPrihvati = new JButton("Prihvati");
		GridBagConstraints gbc_btnPrihvati = new GridBagConstraints();
		gbc_btnPrihvati.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPrihvati.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrihvati.gridx = 2;
		gbc_btnPrihvati.gridy = 2;
		add(btnPrihvati, gbc_btnPrihvati);

		btnPonisti = new JButton("Poništi");
		GridBagConstraints gbc_btnPonisti = new GridBagConstraints();
		gbc_btnPonisti.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPonisti.insets = new Insets(0, 0, 5, 5);
		gbc_btnPonisti.gridx = 3;
		gbc_btnPonisti.gridy = 2;
		add(btnPonisti, gbc_btnPonisti);
	}

	public JButton getBtnPrihvati() {
		return btnPrihvati;
	}

	public JButton getBtnPonisti() {
		return btnPonisti;
	}
	public JTextField getTfIme() {
		return tfIme;
	}

	public JTextField getTfPrezime() {
		return tfPrezime;
	}

	public JTextField getTfAdresa() {
		return tfAdresa;
	}

	public JTextField getTfMjesto() {
		return tfMjesto;
	}

	public JTextField getTfOpcina() {
		return tfOpcina;
	}

	public ButtonGroup getTipLica() {
		return tipLica;
	}

	public JTextField getTfJMBG() {
		return tfJMBG;
	}

	public JTextField getTfIdBroj() {
		return tfIdBroj;
	}

	public JRadioButton getPravno() {
		return pravno;
	}

	public JRadioButton getFizicko() {
		return fizicko;
	}
	public JPanel getPanelPodaci() {
		return panelPodaci;
	}
}
