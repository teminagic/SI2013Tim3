package co.ba.edgewise.components;
//
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VoziloDodavanje extends JPanel {

	private static final long serialVersionUID = 2259547713349336656L;
	private JTextField tf_tipVozila;
	private JTextField tf_modelVozila;
	private JTextField tf_markaVozila;
	private JTextField tf_godProizvodnje;
	private JTextField tf_regOznaka;
	private JTextField tf_brojSasije;
	private JTextField tf_zapremina;
	private JTextField tf_maxSnaga;
	private JTextField tf_brojMotora;
	private JTextField tf_odnos;
	private JTextField tf_sjedenje;
	private JTextField tf_stajanje;
	private JTextField tf_lezanje;
	private JTextField tf_karoserija;
	private JTextField tf_datumPregleda;
	private JTextField tb_maxMasa;
	private JTextField tb_masa;
	private JTextField tb_nosivost;
	private JTextField tb_bojaVozila;
	private JButton btn_prihvati;
	private JButton btn_ponisti;
	private GridBagLayout gridBagLayout;
	private JPanel okvirPanel;
	private JPanel osnovniPodaci;
	private JPanel motorPodaci;
	private JPanel detaljniPodaci;
	private JPanel bojaMasaVozila;
	private JPanel buttonPanel;
	private JLabel lbl_vrsta;
	private JLabel lbl_tip;
	private JLabel lbl_model;
	private JLabel lbl_marka;
	private JLabel lbl_godProizvodnje;
	private JLabel lbl_regOznaka;
	private JLabel lbl_sasija;
	private JLabel lbl_zapremina;
	private JLabel lbl_maxSnaga;
	private JLabel lbl_gorivo;
	private JLabel lbl_brojMotora;
	private JLabel lbl_vrstaMotora;
	private JLabel lbl_odnos;
	private JLabel lbl_mjestaZaSjedenje;
	private JLabel lbl_mjestaZaStajanje;
	private JLabel lbl_mjestaZaLezanje;
	private JLabel lbl_ekoKarakteristika;
	private JLabel lbl_katalizator;
	private JLabel lbl_oblikKaroserije;
	private JLabel lbl_datumPregleda;
	private JLabel lbl_brojVozila;
	private JLabel lbl_nijansaBoje;
	private JLabel lbl_vrstaBoje;
	private JLabel lbl_maxMasa;
	private JLabel lbl_masa;
	private JLabel lbl_nosivost;
	private JComboBox cb_vrstaVozila;
	private JComboBox cb_gorivo;
	private JComboBox cb_vrstaMotora;
	private JComboBox cb_ekoKarakteristike;
	private JComboBox cb_nijansa;
	private JComboBox cb_vrstaBoje;
	private JRadioButton rb_katalizator_da;
	private JRadioButton rb_katalizator_ne;

	// enums
	enum VrstaVozilaVrijednosti {
		Putnicki_automobil("Putnički automobil"), Moped("Moped"), Motocikl(
				"Motocikl"), Motorni_tricikl("Motorni tricikl"), Cetverocikl(
				"Četverocikl"), Autobus("Autobus"), Teretno_vozilo(
				"Teretno vozilo"), Prikljucno_vozilo("Priklju�no vozilo"), Traktor(
				"Traktor"), Traktor_sa_gusjenicama("Traktor sa gusjenicama"), Radna_masina(
				"Radna ma�ina");

		private final String stringValue;

		private VrstaVozilaVrijednosti(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	enum VrstaGorivaVrijednosti {
		Benzin("Benzin"), Benzin_LPG("Benzin/LPG"), Benzin_CNG("Benzin/CPG"), Benzin_elektricni(
				"Benzin/elektri�ni"), Dizel("Dizel"), Dizel_CNG("Dizel/CNG"), Dizel_elektricni(
				"Dizel/elektri�ni"), Elektricni_pogon("Elektri�ni pogon"), Biodizel(
				"Biodizel"), Etanol("Etanol"), Metanol("Metanol"), Hidrogen(
				"Hidrogen(vodonik)"), LPG("LPG"), CNG("CNG");

		private final String stringValue;

		private VrstaGorivaVrijednosti(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	enum VrstaMotoraVrijednosti {
		OTTO("OTTO"), DIESEL("DIESEL"), WANKEL("WANKEL"), ELEKTROMOTOR(
				"Elektromotor"), KOMBINOVANI_POGON("Kombinovani pogon");

		private final String stringValue;

		private VrstaMotoraVrijednosti(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	enum EkoKarakteristikeVrijednosti {
		Konvencionalno("Konvencionalno"), Euro_1("Euro 1"), Euro_2("Euro 2"), Euro_3(
				"Euro 3"), Euro_4("Euro 4"), Euro_5("Euro 5");

		private final String stringValue;

		private EkoKarakteristikeVrijednosti(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	enum VrstaBojeVrijednosti {
		obicna("Obična"), metalik("Metalik");

		private final String stringValue;

		private VrstaBojeVrijednosti(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	enum NijansaBojeVrijednosti {
		Standardna, Svjetlija, Tamnija;
	}

	public VoziloDodavanje() {
		// calling methods for seting layout
		layoutSet();
		framePanelSet();
		dataPanelSet();
		labelSet();
		inputSet();
		componentSet();
	}

	public void layoutSet() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
	}

	public void framePanelSet() {
		okvirPanel = new JPanel();
		okvirPanel.setBorder(new TitledBorder(null, "Podaci",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_okvirPanel = new GridBagConstraints();
		gbc_okvirPanel.insets = new Insets(0, 0, 5, 5);
		gbc_okvirPanel.fill = GridBagConstraints.BOTH;
		gbc_okvirPanel.gridx = 1;
		gbc_okvirPanel.gridy = 1;
		add(okvirPanel, gbc_okvirPanel);

		GridBagLayout gbl_okvirPanel = new GridBagLayout();
		gbl_okvirPanel.columnWidths = new int[] { 300, 300, 0 };
		gbl_okvirPanel.rowHeights = new int[] { 164, 144, -18, 0 };
		gbl_okvirPanel.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_okvirPanel.rowWeights = new double[] { 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		okvirPanel.setLayout(gbl_okvirPanel);
	}

	public void dataPanelSet() {
		osnovniPodaci = new JPanel();
		osnovniPodaci.setBorder(new TitledBorder(null, "Osnovni podaci",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_osnovniPodaci = new GridBagConstraints();
		gbc_osnovniPodaci.fill = GridBagConstraints.HORIZONTAL;
		gbc_osnovniPodaci.anchor = GridBagConstraints.NORTH;
		gbc_osnovniPodaci.insets = new Insets(0, 0, 5, 5);
		gbc_osnovniPodaci.gridx = 0;
		gbc_osnovniPodaci.gridy = 0;
		okvirPanel.add(osnovniPodaci, gbc_osnovniPodaci);

		GridBagLayout gbl_osnovniPodaci = new GridBagLayout();
		gbl_osnovniPodaci.columnWidths = new int[] { 120, 0, 0 };
		gbl_osnovniPodaci.rowHeights = new int[] { 0, 0, 0, 0, 0, 4, 0 };
		gbl_osnovniPodaci.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_osnovniPodaci.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		osnovniPodaci.setLayout(gbl_osnovniPodaci);

		motorPodaci = new JPanel();
		motorPodaci.setBorder(new TitledBorder(null, "Podaci o motoru",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_motorPodaci = new GridBagConstraints();
		gbc_motorPodaci.fill = GridBagConstraints.BOTH;
		gbc_motorPodaci.insets = new Insets(0, 0, 5, 0);
		gbc_motorPodaci.gridx = 1;
		gbc_motorPodaci.gridy = 0;
		okvirPanel.add(motorPodaci, gbc_motorPodaci);
		GridBagLayout gbl_motorPodaci = new GridBagLayout();
		gbl_motorPodaci.columnWidths = new int[] { 120, 0, 0 };
		gbl_motorPodaci.rowHeights = new int[] { 0, 0, 0, 0, 0, -7, 0 };
		gbl_motorPodaci.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_motorPodaci.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		motorPodaci.setLayout(gbl_motorPodaci);

		detaljniPodaci = new JPanel();
		detaljniPodaci.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Detaljni podaci",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_detaljniPodaci = new GridBagConstraints();
		gbc_detaljniPodaci.fill = GridBagConstraints.BOTH;
		gbc_detaljniPodaci.gridheight = 2;
		gbc_detaljniPodaci.insets = new Insets(0, 0, 0, 5);
		gbc_detaljniPodaci.gridx = 0;
		gbc_detaljniPodaci.gridy = 1;
		okvirPanel.add(detaljniPodaci, gbc_detaljniPodaci);
		GridBagLayout gbl_detaljniPodaci = new GridBagLayout();
		gbl_detaljniPodaci.columnWidths = new int[] { 120, 81, 0, 0 };
		gbl_detaljniPodaci.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_detaljniPodaci.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_detaljniPodaci.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		detaljniPodaci.setLayout(gbl_detaljniPodaci);

		bojaMasaVozila = new JPanel();
		bojaMasaVozila.setBorder(new TitledBorder(null,
				"Podaci o boji i masi vozila", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_bojaMasaVozila = new GridBagConstraints();
		gbc_bojaMasaVozila.fill = GridBagConstraints.BOTH;
		gbc_bojaMasaVozila.insets = new Insets(0, 0, 5, 0);
		gbc_bojaMasaVozila.gridx = 1;
		gbc_bojaMasaVozila.gridy = 1;
		okvirPanel.add(bojaMasaVozila, gbc_bojaMasaVozila);
		GridBagLayout gbl_bojaMasaVozila = new GridBagLayout();
		gbl_bojaMasaVozila.columnWidths = new int[] { 120, 0, 0 };
		gbl_bojaMasaVozila.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_bojaMasaVozila.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_bojaMasaVozila.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		bojaMasaVozila.setLayout(gbl_bojaMasaVozila);

		buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonPanel.anchor = GridBagConstraints.SOUTH;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 2;
		okvirPanel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 0, 0, 0, 0, 69, 0, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 0, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				1.0, Double.MIN_VALUE };
		gbl_buttonPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);

	}

	public void labelSet() {
		lbl_vrsta = new JLabel("Vrsta");
		lbl_vrsta.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbl_vrsta = new GridBagConstraints();
		gbc_lbl_vrsta.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lbl_vrsta.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_vrsta.gridx = 0;
		gbc_lbl_vrsta.gridy = 0;
		osnovniPodaci.add(lbl_vrsta, gbc_lbl_vrsta);

		lbl_tip = new JLabel("Tip");
		lbl_tip.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbl_tip = new GridBagConstraints();
		gbc_lbl_tip.anchor = GridBagConstraints.EAST;
		gbc_lbl_tip.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_tip.gridx = 0;
		gbc_lbl_tip.gridy = 1;
		osnovniPodaci.add(lbl_tip, gbc_lbl_tip);

		lbl_model = new JLabel("Model");
		GridBagConstraints gbc_lbl_model = new GridBagConstraints();
		gbc_lbl_model.anchor = GridBagConstraints.EAST;
		gbc_lbl_model.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_model.gridx = 0;
		gbc_lbl_model.gridy = 2;
		osnovniPodaci.add(lbl_model, gbc_lbl_model);

		lbl_marka = new JLabel("Marka");
		GridBagConstraints gbc_lbl_marka = new GridBagConstraints();
		gbc_lbl_marka.anchor = GridBagConstraints.EAST;
		gbc_lbl_marka.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_marka.gridx = 0;
		gbc_lbl_marka.gridy = 3;
		osnovniPodaci.add(lbl_marka, gbc_lbl_marka);

		lbl_godProizvodnje = new JLabel("Godina proizvodnje");
		GridBagConstraints gbc_lbl_godProizvodnje = new GridBagConstraints();
		gbc_lbl_godProizvodnje.anchor = GridBagConstraints.EAST;
		gbc_lbl_godProizvodnje.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_godProizvodnje.gridx = 0;
		gbc_lbl_godProizvodnje.gridy = 4;
		osnovniPodaci.add(lbl_godProizvodnje, gbc_lbl_godProizvodnje);

		lbl_regOznaka = new JLabel("Registarska oznaka");
		GridBagConstraints gbc_lbl_regOznaka = new GridBagConstraints();
		gbc_lbl_regOznaka.anchor = GridBagConstraints.EAST;
		gbc_lbl_regOznaka.fill = GridBagConstraints.VERTICAL;
		gbc_lbl_regOznaka.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_regOznaka.gridx = 0;
		gbc_lbl_regOznaka.gridy = 5;
		osnovniPodaci.add(lbl_regOznaka, gbc_lbl_regOznaka);

		lbl_sasija = new JLabel("Broj \u0161asije");
		GridBagConstraints gbc_lbl_sasija = new GridBagConstraints();
		gbc_lbl_sasija.anchor = GridBagConstraints.EAST;
		gbc_lbl_sasija.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_sasija.gridx = 0;
		gbc_lbl_sasija.gridy = 0;
		motorPodaci.add(lbl_sasija, gbc_lbl_sasija);

		lbl_zapremina = new JLabel("Zapremina motora");
		GridBagConstraints gbc_lbl_zapremina = new GridBagConstraints();
		gbc_lbl_zapremina.anchor = GridBagConstraints.EAST;
		gbc_lbl_zapremina.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_zapremina.gridx = 0;
		gbc_lbl_zapremina.gridy = 1;
		motorPodaci.add(lbl_zapremina, gbc_lbl_zapremina);

		lbl_maxSnaga = new JLabel("Max. snaga");
		GridBagConstraints gbc_lbl_maxSnaga = new GridBagConstraints();
		gbc_lbl_maxSnaga.anchor = GridBagConstraints.EAST;
		gbc_lbl_maxSnaga.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_maxSnaga.gridx = 0;
		gbc_lbl_maxSnaga.gridy = 2;
		motorPodaci.add(lbl_maxSnaga, gbc_lbl_maxSnaga);

		lbl_gorivo = new JLabel("Vrsta goriva");
		GridBagConstraints gbc_lbl_gorivo = new GridBagConstraints();
		gbc_lbl_gorivo.anchor = GridBagConstraints.EAST;
		gbc_lbl_gorivo.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_gorivo.gridx = 0;
		gbc_lbl_gorivo.gridy = 3;
		motorPodaci.add(lbl_gorivo, gbc_lbl_gorivo);

		lbl_brojMotora = new JLabel("Broj motora");
		GridBagConstraints gbc_lbl_brojMotora = new GridBagConstraints();
		gbc_lbl_brojMotora.anchor = GridBagConstraints.EAST;
		gbc_lbl_brojMotora.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_brojMotora.gridx = 0;
		gbc_lbl_brojMotora.gridy = 4;
		motorPodaci.add(lbl_brojMotora, gbc_lbl_brojMotora);

		lbl_vrstaMotora = new JLabel("Vrsta motora");
		GridBagConstraints gbc_lbl_vrstaMotora = new GridBagConstraints();
		gbc_lbl_vrstaMotora.anchor = GridBagConstraints.EAST;
		gbc_lbl_vrstaMotora.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_vrstaMotora.gridx = 0;
		gbc_lbl_vrstaMotora.gridy = 5;
		motorPodaci.add(lbl_vrstaMotora, gbc_lbl_vrstaMotora);

		lbl_odnos = new JLabel("Odnos snage i mase");
		GridBagConstraints gbc_lbl_odnos = new GridBagConstraints();
		gbc_lbl_odnos.anchor = GridBagConstraints.EAST;
		gbc_lbl_odnos.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_odnos.gridx = 0;
		gbc_lbl_odnos.gridy = 0;
		detaljniPodaci.add(lbl_odnos, gbc_lbl_odnos);

		lbl_mjestaZaSjedenje = new JLabel("Broj mjesta za sjedenje");
		GridBagConstraints gbc_lbl_mjestaZaSjedenje = new GridBagConstraints();
		gbc_lbl_mjestaZaSjedenje.anchor = GridBagConstraints.EAST;
		gbc_lbl_mjestaZaSjedenje.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_mjestaZaSjedenje.gridx = 0;
		gbc_lbl_mjestaZaSjedenje.gridy = 1;
		detaljniPodaci.add(lbl_mjestaZaSjedenje, gbc_lbl_mjestaZaSjedenje);

		lbl_mjestaZaStajanje = new JLabel("Broj mjesta za stajanje");
		GridBagConstraints gbc_lbl_mjestaZaStajanje = new GridBagConstraints();
		gbc_lbl_mjestaZaStajanje.anchor = GridBagConstraints.EAST;
		gbc_lbl_mjestaZaStajanje.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_mjestaZaStajanje.gridx = 0;
		gbc_lbl_mjestaZaStajanje.gridy = 2;
		detaljniPodaci.add(lbl_mjestaZaStajanje, gbc_lbl_mjestaZaStajanje);

		lbl_mjestaZaLezanje = new JLabel("Broj mjesta za le\u017Eanje");
		GridBagConstraints gbc_lbl_mjestaZaLezanje = new GridBagConstraints();
		gbc_lbl_mjestaZaLezanje.anchor = GridBagConstraints.EAST;
		gbc_lbl_mjestaZaLezanje.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_mjestaZaLezanje.gridx = 0;
		gbc_lbl_mjestaZaLezanje.gridy = 3;
		detaljniPodaci.add(lbl_mjestaZaLezanje, gbc_lbl_mjestaZaLezanje);

		lbl_ekoKarakteristika = new JLabel("Eko karakteristika");
		GridBagConstraints gbc_lbl_ekoKarakteristika = new GridBagConstraints();
		gbc_lbl_ekoKarakteristika.anchor = GridBagConstraints.EAST;
		gbc_lbl_ekoKarakteristika.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_ekoKarakteristika.gridx = 0;
		gbc_lbl_ekoKarakteristika.gridy = 4;
		detaljniPodaci.add(lbl_ekoKarakteristika, gbc_lbl_ekoKarakteristika);

		lbl_katalizator = new JLabel("Katalizator");
		GridBagConstraints gbc_lbl_katalizator = new GridBagConstraints();
		gbc_lbl_katalizator.anchor = GridBagConstraints.EAST;
		gbc_lbl_katalizator.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_katalizator.gridx = 0;
		gbc_lbl_katalizator.gridy = 5;
		detaljniPodaci.add(lbl_katalizator, gbc_lbl_katalizator);

		lbl_oblikKaroserije = new JLabel("Oblik karoserije");
		GridBagConstraints gbc_lbl_oblikKaroserije = new GridBagConstraints();
		gbc_lbl_oblikKaroserije.anchor = GridBagConstraints.EAST;
		gbc_lbl_oblikKaroserije.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_oblikKaroserije.gridx = 0;
		gbc_lbl_oblikKaroserije.gridy = 6;
		detaljniPodaci.add(lbl_oblikKaroserije, gbc_lbl_oblikKaroserije);

		lbl_datumPregleda = new JLabel("Datum pregleda");
		GridBagConstraints gbc_lbl_datumPregleda = new GridBagConstraints();
		gbc_lbl_datumPregleda.anchor = GridBagConstraints.EAST;
		gbc_lbl_datumPregleda.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_datumPregleda.gridx = 0;
		gbc_lbl_datumPregleda.gridy = 7;
		detaljniPodaci.add(lbl_datumPregleda, gbc_lbl_datumPregleda);

		lbl_brojVozila = new JLabel("Boja vozila");
		GridBagConstraints gbc_lbl_brojVozila = new GridBagConstraints();
		gbc_lbl_brojVozila.anchor = GridBagConstraints.EAST;
		gbc_lbl_brojVozila.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_brojVozila.gridx = 0;
		gbc_lbl_brojVozila.gridy = 0;
		bojaMasaVozila.add(lbl_brojVozila, gbc_lbl_brojVozila);

		lbl_nijansaBoje = new JLabel("Nijansa boje");
		GridBagConstraints gbc_lbl_nijansaBoje = new GridBagConstraints();
		gbc_lbl_nijansaBoje.anchor = GridBagConstraints.EAST;
		gbc_lbl_nijansaBoje.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_nijansaBoje.gridx = 0;
		gbc_lbl_nijansaBoje.gridy = 1;
		bojaMasaVozila.add(lbl_nijansaBoje, gbc_lbl_nijansaBoje);

		lbl_vrstaBoje = new JLabel("Vrsta boje");
		GridBagConstraints gbc_lbl_vrstaBoje = new GridBagConstraints();
		gbc_lbl_vrstaBoje.anchor = GridBagConstraints.EAST;
		gbc_lbl_vrstaBoje.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_vrstaBoje.gridx = 0;
		gbc_lbl_vrstaBoje.gridy = 2;
		bojaMasaVozila.add(lbl_vrstaBoje, gbc_lbl_vrstaBoje);

		lbl_maxMasa = new JLabel("Max. dozvoljena masa");
		GridBagConstraints gbc_lbl_maxMasa3 = new GridBagConstraints();
		gbc_lbl_maxMasa3.anchor = GridBagConstraints.EAST;
		gbc_lbl_maxMasa3.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_maxMasa3.gridx = 0;
		gbc_lbl_maxMasa3.gridy = 3;
		bojaMasaVozila.add(lbl_maxMasa, gbc_lbl_maxMasa3);

		lbl_masa = new JLabel("Masa");
		GridBagConstraints gbc_lbl_masa = new GridBagConstraints();
		gbc_lbl_masa.anchor = GridBagConstraints.EAST;
		gbc_lbl_masa.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_masa.gridx = 0;
		gbc_lbl_masa.gridy = 4;
		bojaMasaVozila.add(lbl_masa, gbc_lbl_masa);

		lbl_nosivost = new JLabel("Dopustiva nosivost");
		GridBagConstraints gbc_lbl_nosivost = new GridBagConstraints();
		gbc_lbl_nosivost.anchor = GridBagConstraints.EAST;
		gbc_lbl_nosivost.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_nosivost.gridx = 0;
		gbc_lbl_nosivost.gridy = 5;
		bojaMasaVozila.add(lbl_nosivost, gbc_lbl_nosivost);
	}

	public void inputSet() {
		tf_tipVozila = new JTextField();
		tf_tipVozila.setColumns(10);
		GridBagConstraints gbc_tf_tipVozila = new GridBagConstraints();
		gbc_tf_tipVozila.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_tipVozila.insets = new Insets(0, 0, 5, 0);
		gbc_tf_tipVozila.gridx = 1;
		gbc_tf_tipVozila.gridy = 1;
		osnovniPodaci.add(tf_tipVozila, gbc_tf_tipVozila);

		tf_modelVozila = new JTextField();
		tf_modelVozila.setColumns(10);
		GridBagConstraints gbc_tf_modelVozila = new GridBagConstraints();
		gbc_tf_modelVozila.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_modelVozila.insets = new Insets(0, 0, 5, 0);
		gbc_tf_modelVozila.gridx = 1;
		gbc_tf_modelVozila.gridy = 2;
		osnovniPodaci.add(tf_modelVozila, gbc_tf_modelVozila);

		tf_markaVozila = new JTextField();
		tf_markaVozila.setColumns(10);
		GridBagConstraints gbc_tf_markaVozila = new GridBagConstraints();
		gbc_tf_markaVozila.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_markaVozila.insets = new Insets(0, 0, 5, 0);
		gbc_tf_markaVozila.gridx = 1;
		gbc_tf_markaVozila.gridy = 3;
		osnovniPodaci.add(tf_markaVozila, gbc_tf_markaVozila);

		tf_godProizvodnje = new JTextField();
		tf_godProizvodnje.setColumns(10);
		GridBagConstraints gbc_tf_godProizvodnje = new GridBagConstraints();
		gbc_tf_godProizvodnje.anchor = GridBagConstraints.NORTH;
		gbc_tf_godProizvodnje.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_godProizvodnje.insets = new Insets(0, 0, 5, 0);
		gbc_tf_godProizvodnje.gridx = 1;
		gbc_tf_godProizvodnje.gridy = 4;
		osnovniPodaci.add(tf_godProizvodnje, gbc_tf_godProizvodnje);

		tf_regOznaka = new JTextField();
		tf_regOznaka.setColumns(10);
		GridBagConstraints gbc_tf_regOznaka = new GridBagConstraints();
		gbc_tf_regOznaka.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_regOznaka.gridx = 1;
		gbc_tf_regOznaka.gridy = 5;
		osnovniPodaci.add(tf_regOznaka, gbc_tf_regOznaka);

		tf_brojSasije = new JTextField();
		tf_brojSasije.setColumns(10);
		GridBagConstraints gbc_tf_brojSasije = new GridBagConstraints();
		gbc_tf_brojSasije.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_brojSasije.insets = new Insets(0, 0, 5, 0);
		gbc_tf_brojSasije.gridx = 1;
		gbc_tf_brojSasije.gridy = 0;
		motorPodaci.add(tf_brojSasije, gbc_tf_brojSasije);

		tf_zapremina = new JTextField();
		tf_zapremina.setColumns(10);
		GridBagConstraints gbc_tf_zapremina = new GridBagConstraints();
		gbc_tf_zapremina.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_zapremina.insets = new Insets(0, 0, 5, 0);
		gbc_tf_zapremina.gridx = 1;
		gbc_tf_zapremina.gridy = 1;
		motorPodaci.add(tf_zapremina, gbc_tf_zapremina);

		tf_maxSnaga = new JTextField();
		tf_maxSnaga.setColumns(10);
		GridBagConstraints gbc_tf_maxSnaga = new GridBagConstraints();
		gbc_tf_maxSnaga.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_maxSnaga.insets = new Insets(0, 0, 5, 0);
		gbc_tf_maxSnaga.gridx = 1;
		gbc_tf_maxSnaga.gridy = 2;
		motorPodaci.add(tf_maxSnaga, gbc_tf_maxSnaga);

		tf_brojMotora = new JTextField();
		tf_brojMotora.setColumns(10);
		GridBagConstraints gbc_tf_brojMotora = new GridBagConstraints();
		gbc_tf_brojMotora.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_brojMotora.insets = new Insets(0, 0, 5, 0);
		gbc_tf_brojMotora.gridx = 1;
		gbc_tf_brojMotora.gridy = 4;
		motorPodaci.add(tf_brojMotora, gbc_tf_brojMotora);

		tf_odnos = new JTextField();
		tf_odnos.setColumns(10);
		GridBagConstraints gbc_tf_odnos = new GridBagConstraints();
		gbc_tf_odnos.gridwidth = 2;
		gbc_tf_odnos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_odnos.insets = new Insets(0, 0, 5, 0);
		gbc_tf_odnos.gridx = 1;
		gbc_tf_odnos.gridy = 0;
		detaljniPodaci.add(tf_odnos, gbc_tf_odnos);

		tf_sjedenje = new JTextField();
		tf_sjedenje.setColumns(10);
		GridBagConstraints gbc_tf_sjedenje = new GridBagConstraints();
		gbc_tf_sjedenje.gridwidth = 2;
		gbc_tf_sjedenje.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_sjedenje.insets = new Insets(0, 0, 5, 0);
		gbc_tf_sjedenje.gridx = 1;
		gbc_tf_sjedenje.gridy = 1;
		detaljniPodaci.add(tf_sjedenje, gbc_tf_sjedenje);

		tf_stajanje = new JTextField();
		tf_stajanje.setColumns(10);
		GridBagConstraints gbc_tf_stajanje = new GridBagConstraints();
		gbc_tf_stajanje.gridwidth = 2;
		gbc_tf_stajanje.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_stajanje.insets = new Insets(0, 0, 5, 0);
		gbc_tf_stajanje.gridx = 1;
		gbc_tf_stajanje.gridy = 2;
		detaljniPodaci.add(tf_stajanje, gbc_tf_stajanje);

		tf_lezanje = new JTextField();
		tf_lezanje.setColumns(10);
		GridBagConstraints gbc_tf_lezanje = new GridBagConstraints();
		gbc_tf_lezanje.gridwidth = 2;
		gbc_tf_lezanje.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_lezanje.insets = new Insets(0, 0, 5, 0);
		gbc_tf_lezanje.gridx = 1;
		gbc_tf_lezanje.gridy = 3;
		detaljniPodaci.add(tf_lezanje, gbc_tf_lezanje);

		tf_karoserija = new JTextField();
		tf_karoserija.setColumns(10);
		GridBagConstraints gbc_tf_karoserija = new GridBagConstraints();
		gbc_tf_karoserija.gridwidth = 2;
		gbc_tf_karoserija.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_karoserija.insets = new Insets(0, 0, 5, 0);
		gbc_tf_karoserija.gridx = 1;
		gbc_tf_karoserija.gridy = 6;
		detaljniPodaci.add(tf_karoserija, gbc_tf_karoserija);

		tf_datumPregleda = new JTextField();
		tf_datumPregleda.setColumns(10);
		GridBagConstraints gbc_tf_datumPregleda = new GridBagConstraints();
		gbc_tf_datumPregleda.gridwidth = 2;
		gbc_tf_datumPregleda.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_datumPregleda.gridx = 1;
		gbc_tf_datumPregleda.gridy = 7;
		detaljniPodaci.add(tf_datumPregleda, gbc_tf_datumPregleda);

		tb_bojaVozila = new JTextField();
		GridBagConstraints gbc_tb_bojaVozila = new GridBagConstraints();
		gbc_tb_bojaVozila.insets = new Insets(0, 0, 5, 0);
		gbc_tb_bojaVozila.fill = GridBagConstraints.HORIZONTAL;
		gbc_tb_bojaVozila.gridx = 1;
		gbc_tb_bojaVozila.gridy = 0;
		bojaMasaVozila.add(tb_bojaVozila, gbc_tb_bojaVozila);
		tb_bojaVozila.setColumns(10);

		tb_maxMasa = new JTextField();
		tb_maxMasa.setColumns(10);
		GridBagConstraints gbc_tb_maxMasa = new GridBagConstraints();
		gbc_tb_maxMasa.fill = GridBagConstraints.HORIZONTAL;
		gbc_tb_maxMasa.insets = new Insets(0, 0, 5, 0);
		gbc_tb_maxMasa.gridx = 1;
		gbc_tb_maxMasa.gridy = 3;
		bojaMasaVozila.add(tb_maxMasa, gbc_tb_maxMasa);

		tb_masa = new JTextField();
		tb_masa.setColumns(10);
		GridBagConstraints gbc_tb_masa = new GridBagConstraints();
		gbc_tb_masa.fill = GridBagConstraints.HORIZONTAL;
		gbc_tb_masa.insets = new Insets(0, 0, 5, 0);
		gbc_tb_masa.gridx = 1;
		gbc_tb_masa.gridy = 4;
		bojaMasaVozila.add(tb_masa, gbc_tb_masa);

		tb_nosivost = new JTextField();
		tb_nosivost.setColumns(10);
		GridBagConstraints gbc_tb_nosivost = new GridBagConstraints();
		gbc_tb_nosivost.fill = GridBagConstraints.HORIZONTAL;
		gbc_tb_nosivost.gridx = 1;
		gbc_tb_nosivost.gridy = 5;
		bojaMasaVozila.add(tb_nosivost, gbc_tb_nosivost);
	}

	public void componentSet() {
		cb_vrstaVozila = new JComboBox();
		cb_vrstaVozila.setModel(new DefaultComboBoxModel(VrstaVozilaVrijednosti
				.values()));
		GridBagConstraints gbc_cb_vrstaVozila = new GridBagConstraints();
		gbc_cb_vrstaVozila.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_vrstaVozila.insets = new Insets(0, 0, 5, 0);
		gbc_cb_vrstaVozila.gridx = 1;
		gbc_cb_vrstaVozila.gridy = 0;
		osnovniPodaci.add(cb_vrstaVozila, gbc_cb_vrstaVozila);

		cb_gorivo = new JComboBox();
		cb_gorivo.setModel(new DefaultComboBoxModel(VrstaGorivaVrijednosti
				.values()));
		GridBagConstraints gbc_cb_gorivo = new GridBagConstraints();
		gbc_cb_gorivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_gorivo.insets = new Insets(0, 0, 5, 0);
		gbc_cb_gorivo.gridx = 1;
		gbc_cb_gorivo.gridy = 3;
		motorPodaci.add(cb_gorivo, gbc_cb_gorivo);

		cb_vrstaMotora = new JComboBox();
		cb_vrstaMotora.setModel(new DefaultComboBoxModel(VrstaMotoraVrijednosti
				.values()));
		GridBagConstraints gbc_cb_vrstaMotora = new GridBagConstraints();
		gbc_cb_vrstaMotora.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_vrstaMotora.gridx = 1;
		gbc_cb_vrstaMotora.gridy = 5;
		motorPodaci.add(cb_vrstaMotora, gbc_cb_vrstaMotora);

		cb_ekoKarakteristike = new JComboBox();
		cb_ekoKarakteristike.setModel(new DefaultComboBoxModel(
				EkoKarakteristikeVrijednosti.values()));
		GridBagConstraints gbc_cb_ekoKarakteristike = new GridBagConstraints();
		gbc_cb_ekoKarakteristike.gridwidth = 2;
		gbc_cb_ekoKarakteristike.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_ekoKarakteristike.insets = new Insets(0, 0, 5, 0);
		gbc_cb_ekoKarakteristike.gridx = 1;
		gbc_cb_ekoKarakteristike.gridy = 4;
		detaljniPodaci.add(cb_ekoKarakteristike, gbc_cb_ekoKarakteristike);

		cb_nijansa = new JComboBox();
		cb_nijansa.setModel(new DefaultComboBoxModel(NijansaBojeVrijednosti
				.values()));
		GridBagConstraints gbc_cb_nijansa = new GridBagConstraints();
		gbc_cb_nijansa.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_nijansa.insets = new Insets(0, 0, 5, 0);
		gbc_cb_nijansa.gridx = 1;
		gbc_cb_nijansa.gridy = 1;
		bojaMasaVozila.add(cb_nijansa, gbc_cb_nijansa);

		cb_vrstaBoje = new JComboBox();
		cb_vrstaBoje.setModel(new DefaultComboBoxModel(VrstaBojeVrijednosti
				.values()));
		GridBagConstraints gbc_cb_vrstaBoje = new GridBagConstraints();
		gbc_cb_vrstaBoje.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_vrstaBoje.insets = new Insets(0, 0, 5, 0);
		gbc_cb_vrstaBoje.gridx = 1;
		gbc_cb_vrstaBoje.gridy = 2;
		bojaMasaVozila.add(cb_vrstaBoje, gbc_cb_vrstaBoje);

		rb_katalizator_da = new JRadioButton("Da");
		rb_katalizator_da.setSelected(true);
		GridBagConstraints gbc_rb_katalizator_da = new GridBagConstraints();
		gbc_rb_katalizator_da.insets = new Insets(0, 0, 5, 5);
		gbc_rb_katalizator_da.gridx = 1;
		gbc_rb_katalizator_da.gridy = 5;
		detaljniPodaci.add(rb_katalizator_da, gbc_rb_katalizator_da);

		rb_katalizator_ne = new JRadioButton("Ne");
		GridBagConstraints gbc_rb_katalizator_ne = new GridBagConstraints();
		gbc_rb_katalizator_ne.insets = new Insets(0, 0, 5, 0);
		gbc_rb_katalizator_ne.gridx = 2;
		gbc_rb_katalizator_ne.gridy = 5;
		detaljniPodaci.add(rb_katalizator_ne, gbc_rb_katalizator_ne);

		// Grupisanje radiobuttona - da bi mogao samo jedan biti true
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rb_katalizator_da);
		radioGroup.add(rb_katalizator_ne);

		btn_prihvati = new JButton("Prihvati");
		GridBagConstraints gbc_btn_prihvati = new GridBagConstraints();
		gbc_btn_prihvati.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_prihvati.insets = new Insets(0, 0, 0, 5);
		gbc_btn_prihvati.gridx = 4;
		gbc_btn_prihvati.gridy = 0;
		buttonPanel.add(btn_prihvati, gbc_btn_prihvati);

		btn_ponisti = new JButton("Poni\u0161ti");
		GridBagConstraints gbc_btn_ponisti = new GridBagConstraints();
		gbc_btn_ponisti.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_ponisti.gridx = 5;
		gbc_btn_ponisti.gridy = 0;
		buttonPanel.add(btn_ponisti, gbc_btn_ponisti);

	}

	public JButton getBtn_prihvati() {
		return btn_prihvati;
	}
}
