package ba.co.edgewise.jmup.components;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;


public class PregledVozila extends JPanel {

	public PregledVozila() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 508, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 354, 36, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel okvirPanel = new JPanel();
		okvirPanel.setBorder(new TitledBorder(null, "Podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_okvirPanel = new GridBagConstraints();
		gbc_okvirPanel.insets = new Insets(0, 0, 5, 5);
		gbc_okvirPanel.fill = GridBagConstraints.BOTH;
		gbc_okvirPanel.gridx = 1;
		gbc_okvirPanel.gridy = 1;
		add(okvirPanel, gbc_okvirPanel);
		GridBagLayout gbl_okvirPanel = new GridBagLayout();
		gbl_okvirPanel.columnWidths = new int[]{300, 300, 0};
		gbl_okvirPanel.rowHeights = new int[]{0, 0, 31, 0};
		gbl_okvirPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_okvirPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		okvirPanel.setLayout(gbl_okvirPanel);
		
		JPanel osnovniPodaci = new JPanel();
		osnovniPodaci.setBorder(new TitledBorder(null, "Osnovni podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_osnovniPodaci = new GridBagConstraints();
		gbc_osnovniPodaci.fill = GridBagConstraints.BOTH;
		gbc_osnovniPodaci.insets = new Insets(0, 0, 5, 5);
		gbc_osnovniPodaci.gridx = 0;
		gbc_osnovniPodaci.gridy = 0;
		okvirPanel.add(osnovniPodaci, gbc_osnovniPodaci);
		GridBagLayout gbl_osnovniPodaci = new GridBagLayout();
		gbl_osnovniPodaci.columnWidths = new int[]{120, 0, 0};
		gbl_osnovniPodaci.rowHeights = new int[]{0, 0, 0, 0, 0, 4, 0};
		gbl_osnovniPodaci.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_osnovniPodaci.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		osnovniPodaci.setLayout(gbl_osnovniPodaci);
		
		JLabel label = new JLabel("Vrsta");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		osnovniPodaci.add(label, gbc_label);
		
		JLabel lblVrsta = new JLabel("Vrsta");
		GridBagConstraints gbc_lblVrsta = new GridBagConstraints();
		gbc_lblVrsta.insets = new Insets(0, 0, 5, 0);
		gbc_lblVrsta.gridx = 1;
		gbc_lblVrsta.gridy = 0;
		osnovniPodaci.add(lblVrsta, gbc_lblVrsta);
		
		JLabel label_1 = new JLabel("Tip");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		osnovniPodaci.add(label_1, gbc_label_1);
		
		JLabel lblTip = new JLabel("Tip");
		GridBagConstraints gbc_lblTip = new GridBagConstraints();
		gbc_lblTip.insets = new Insets(0, 0, 5, 0);
		gbc_lblTip.gridx = 1;
		gbc_lblTip.gridy = 1;
		osnovniPodaci.add(lblTip, gbc_lblTip);
		
		JLabel label_2 = new JLabel("Model");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		osnovniPodaci.add(label_2, gbc_label_2);
		
		JLabel lblModel = new JLabel("Model");
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.insets = new Insets(0, 0, 5, 0);
		gbc_lblModel.gridx = 1;
		gbc_lblModel.gridy = 2;
		osnovniPodaci.add(lblModel, gbc_lblModel);
		
		JLabel label_3 = new JLabel("Marka");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		osnovniPodaci.add(label_3, gbc_label_3);
		
		JLabel lblMarka = new JLabel("Marka");
		GridBagConstraints gbc_lblMarka = new GridBagConstraints();
		gbc_lblMarka.insets = new Insets(0, 0, 5, 0);
		gbc_lblMarka.gridx = 1;
		gbc_lblMarka.gridy = 3;
		osnovniPodaci.add(lblMarka, gbc_lblMarka);
		
		JLabel label_4 = new JLabel("Godina proizvodnje");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		osnovniPodaci.add(label_4, gbc_label_4);
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje");
		GridBagConstraints gbc_lblGodinaProizvodnje = new GridBagConstraints();
		gbc_lblGodinaProizvodnje.insets = new Insets(0, 0, 5, 0);
		gbc_lblGodinaProizvodnje.gridx = 1;
		gbc_lblGodinaProizvodnje.gridy = 4;
		osnovniPodaci.add(lblGodinaProizvodnje, gbc_lblGodinaProizvodnje);
		
		JLabel label_5 = new JLabel("Registarska oznaka");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.VERTICAL;
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 5;
		osnovniPodaci.add(label_5, gbc_label_5);
		
		JLabel lblRegistarskaOznaka = new JLabel("Registarska oznaka");
		GridBagConstraints gbc_lblRegistarskaOznaka = new GridBagConstraints();
		gbc_lblRegistarskaOznaka.gridx = 1;
		gbc_lblRegistarskaOznaka.gridy = 5;
		osnovniPodaci.add(lblRegistarskaOznaka, gbc_lblRegistarskaOznaka);
		
		JPanel motorPodaci = new JPanel();
		motorPodaci.setBorder(new TitledBorder(null, "Podaci o motoru", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_motorPodaci = new GridBagConstraints();
		gbc_motorPodaci.fill = GridBagConstraints.BOTH;
		gbc_motorPodaci.insets = new Insets(0, 0, 5, 0);
		gbc_motorPodaci.gridx = 1;
		gbc_motorPodaci.gridy = 0;
		okvirPanel.add(motorPodaci, gbc_motorPodaci);
		GridBagLayout gbl_motorPodaci = new GridBagLayout();
		gbl_motorPodaci.columnWidths = new int[]{120, 0, 0};
		gbl_motorPodaci.rowHeights = new int[]{0, 0, 0, 0, 0, -7, 0};
		gbl_motorPodaci.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_motorPodaci.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		motorPodaci.setLayout(gbl_motorPodaci);
		
		JLabel label_6 = new JLabel("Broj \u0161asije");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 0;
		motorPodaci.add(label_6, gbc_label_6);
		
		JLabel lblBrojasije = new JLabel("Broj \u0161asije");
		GridBagConstraints gbc_lblBrojasije = new GridBagConstraints();
		gbc_lblBrojasije.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrojasije.gridx = 1;
		gbc_lblBrojasije.gridy = 0;
		motorPodaci.add(lblBrojasije, gbc_lblBrojasije);
		
		JLabel label_7 = new JLabel("Zapremina motora");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 1;
		motorPodaci.add(label_7, gbc_label_7);
		
		JLabel lblZapreminaMotora = new JLabel("Zapremina motora");
		GridBagConstraints gbc_lblZapreminaMotora = new GridBagConstraints();
		gbc_lblZapreminaMotora.insets = new Insets(0, 0, 5, 0);
		gbc_lblZapreminaMotora.gridx = 1;
		gbc_lblZapreminaMotora.gridy = 1;
		motorPodaci.add(lblZapreminaMotora, gbc_lblZapreminaMotora);
		
		JLabel label_8 = new JLabel("Max. snaga");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 2;
		motorPodaci.add(label_8, gbc_label_8);
		
		JLabel lblMaxSnaga = new JLabel("Max. snaga");
		GridBagConstraints gbc_lblMaxSnaga = new GridBagConstraints();
		gbc_lblMaxSnaga.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaxSnaga.gridx = 1;
		gbc_lblMaxSnaga.gridy = 2;
		motorPodaci.add(lblMaxSnaga, gbc_lblMaxSnaga);
		
		JLabel label_9 = new JLabel("Vrsta goriva");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 3;
		motorPodaci.add(label_9, gbc_label_9);
		
		JLabel lblVrstaGoriva = new JLabel("Vrsta goriva");
		GridBagConstraints gbc_lblVrstaGoriva = new GridBagConstraints();
		gbc_lblVrstaGoriva.insets = new Insets(0, 0, 5, 0);
		gbc_lblVrstaGoriva.gridx = 1;
		gbc_lblVrstaGoriva.gridy = 3;
		motorPodaci.add(lblVrstaGoriva, gbc_lblVrstaGoriva);
		
		JLabel label_10 = new JLabel("Broj motora");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 4;
		motorPodaci.add(label_10, gbc_label_10);
		
		JLabel lblBrojMotora = new JLabel("Broj motora");
		GridBagConstraints gbc_lblBrojMotora = new GridBagConstraints();
		gbc_lblBrojMotora.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrojMotora.gridx = 1;
		gbc_lblBrojMotora.gridy = 4;
		motorPodaci.add(lblBrojMotora, gbc_lblBrojMotora);
		
		JLabel label_11 = new JLabel("Vrsta motora");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.insets = new Insets(0, 0, 0, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 5;
		motorPodaci.add(label_11, gbc_label_11);
		
		JLabel lblVrstaMotora = new JLabel("Vrsta motora");
		GridBagConstraints gbc_lblVrstaMotora = new GridBagConstraints();
		gbc_lblVrstaMotora.gridx = 1;
		gbc_lblVrstaMotora.gridy = 5;
		motorPodaci.add(lblVrstaMotora, gbc_lblVrstaMotora);
		
		JPanel detaljniPodaci = new JPanel();
		detaljniPodaci.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detaljni podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_detaljniPodaci = new GridBagConstraints();
		gbc_detaljniPodaci.fill = GridBagConstraints.BOTH;
		gbc_detaljniPodaci.gridheight = 2;
		gbc_detaljniPodaci.insets = new Insets(0, 0, 0, 5);
		gbc_detaljniPodaci.gridx = 0;
		gbc_detaljniPodaci.gridy = 1;
		okvirPanel.add(detaljniPodaci, gbc_detaljniPodaci);
		GridBagLayout gbl_detaljniPodaci = new GridBagLayout();
		gbl_detaljniPodaci.columnWidths = new int[]{120, 0, 0};
		gbl_detaljniPodaci.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_detaljniPodaci.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_detaljniPodaci.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		detaljniPodaci.setLayout(gbl_detaljniPodaci);
		
		JLabel label_12 = new JLabel("Odnos snage i mase");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.anchor = GridBagConstraints.EAST;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 0;
		detaljniPodaci.add(label_12, gbc_label_12);
		
		JLabel lblOdnos = new JLabel("Odnos snage i mase");
		GridBagConstraints gbc_lblOdnos = new GridBagConstraints();
		gbc_lblOdnos.insets = new Insets(0, 0, 5, 0);
		gbc_lblOdnos.gridx = 1;
		gbc_lblOdnos.gridy = 0;
		detaljniPodaci.add(lblOdnos, gbc_lblOdnos);
		
		JLabel label_13 = new JLabel("Broj mjesta za sjedenje");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.anchor = GridBagConstraints.EAST;
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 1;
		detaljniPodaci.add(label_13, gbc_label_13);
		
		JLabel lblBrojMjestaZa = new JLabel("Broj mjesta za sjedenje");
		GridBagConstraints gbc_lblBrojMjestaZa = new GridBagConstraints();
		gbc_lblBrojMjestaZa.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrojMjestaZa.gridx = 1;
		gbc_lblBrojMjestaZa.gridy = 1;
		detaljniPodaci.add(lblBrojMjestaZa, gbc_lblBrojMjestaZa);
		
		JLabel label_14 = new JLabel("Broj mjesta za stajanje");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.anchor = GridBagConstraints.EAST;
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 0;
		gbc_label_14.gridy = 2;
		detaljniPodaci.add(label_14, gbc_label_14);
		
		JLabel lblBrojMjestaZa_1 = new JLabel("Broj mjesta za stajanje");
		GridBagConstraints gbc_lblBrojMjestaZa_1 = new GridBagConstraints();
		gbc_lblBrojMjestaZa_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrojMjestaZa_1.gridx = 1;
		gbc_lblBrojMjestaZa_1.gridy = 2;
		detaljniPodaci.add(lblBrojMjestaZa_1, gbc_lblBrojMjestaZa_1);
		
		JLabel label_15 = new JLabel("Broj mjesta za le\u017Eanje");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.anchor = GridBagConstraints.EAST;
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 0;
		gbc_label_15.gridy = 3;
		detaljniPodaci.add(label_15, gbc_label_15);
		
		JLabel lblBrojMjestaZa_2 = new JLabel("Broj mjesta za le\u017Eanje");
		GridBagConstraints gbc_lblBrojMjestaZa_2 = new GridBagConstraints();
		gbc_lblBrojMjestaZa_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrojMjestaZa_2.gridx = 1;
		gbc_lblBrojMjestaZa_2.gridy = 3;
		detaljniPodaci.add(lblBrojMjestaZa_2, gbc_lblBrojMjestaZa_2);
		
		JLabel label_16 = new JLabel("Eko karakteristika");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.anchor = GridBagConstraints.EAST;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 0;
		gbc_label_16.gridy = 4;
		detaljniPodaci.add(label_16, gbc_label_16);
		
		JLabel lblEkoKarakteristike = new JLabel("Eko karakteristike");
		GridBagConstraints gbc_lblEkoKarakteristike = new GridBagConstraints();
		gbc_lblEkoKarakteristike.insets = new Insets(0, 0, 5, 0);
		gbc_lblEkoKarakteristike.gridx = 1;
		gbc_lblEkoKarakteristike.gridy = 4;
		detaljniPodaci.add(lblEkoKarakteristike, gbc_lblEkoKarakteristike);
		
		JLabel label_17 = new JLabel("Katalizator");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.anchor = GridBagConstraints.EAST;
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 0;
		gbc_label_17.gridy = 5;
		detaljniPodaci.add(label_17, gbc_label_17);
		
		JLabel lblKatalizator = new JLabel("Katalizator");
		GridBagConstraints gbc_lblKatalizator = new GridBagConstraints();
		gbc_lblKatalizator.insets = new Insets(0, 0, 5, 0);
		gbc_lblKatalizator.gridx = 1;
		gbc_lblKatalizator.gridy = 5;
		detaljniPodaci.add(lblKatalizator, gbc_lblKatalizator);
		
		JLabel label_18 = new JLabel("Oblik karoserije");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.anchor = GridBagConstraints.EAST;
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 0;
		gbc_label_18.gridy = 6;
		detaljniPodaci.add(label_18, gbc_label_18);
		
		JLabel lblOblikKaroserije = new JLabel("Oblik karoserije");
		GridBagConstraints gbc_lblOblikKaroserije = new GridBagConstraints();
		gbc_lblOblikKaroserije.insets = new Insets(0, 0, 5, 0);
		gbc_lblOblikKaroserije.gridx = 1;
		gbc_lblOblikKaroserije.gridy = 6;
		detaljniPodaci.add(lblOblikKaroserije, gbc_lblOblikKaroserije);
		
		JLabel label_19 = new JLabel("Datum pregleda");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.anchor = GridBagConstraints.EAST;
		gbc_label_19.insets = new Insets(0, 0, 0, 5);
		gbc_label_19.gridx = 0;
		gbc_label_19.gridy = 7;
		detaljniPodaci.add(label_19, gbc_label_19);
		
		JLabel lblDatumPregleda = new JLabel("Datum pregleda");
		GridBagConstraints gbc_lblDatumPregleda = new GridBagConstraints();
		gbc_lblDatumPregleda.gridx = 1;
		gbc_lblDatumPregleda.gridy = 7;
		detaljniPodaci.add(lblDatumPregleda, gbc_lblDatumPregleda);
		
		JPanel bojaMasaPodaci = new JPanel();
		bojaMasaPodaci.setBorder(new TitledBorder(null, "Podaci o boji i masi vozila", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_bojaMasaPodaci = new GridBagConstraints();
		gbc_bojaMasaPodaci.fill = GridBagConstraints.BOTH;
		gbc_bojaMasaPodaci.insets = new Insets(0, 0, 5, 0);
		gbc_bojaMasaPodaci.gridx = 1;
		gbc_bojaMasaPodaci.gridy = 1;
		okvirPanel.add(bojaMasaPodaci, gbc_bojaMasaPodaci);
		GridBagLayout gbl_bojaMasaPodaci = new GridBagLayout();
		gbl_bojaMasaPodaci.columnWidths = new int[]{120, 0, 0};
		gbl_bojaMasaPodaci.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_bojaMasaPodaci.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_bojaMasaPodaci.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		bojaMasaPodaci.setLayout(gbl_bojaMasaPodaci);
		
		JLabel label_20 = new JLabel("Boja vozila");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.anchor = GridBagConstraints.EAST;
		gbc_label_20.insets = new Insets(0, 0, 5, 5);
		gbc_label_20.gridx = 0;
		gbc_label_20.gridy = 0;
		bojaMasaPodaci.add(label_20, gbc_label_20);
		
		JLabel lblBojaVozila = new JLabel("Boja vozila");
		GridBagConstraints gbc_lblBojaVozila = new GridBagConstraints();
		gbc_lblBojaVozila.insets = new Insets(0, 0, 5, 0);
		gbc_lblBojaVozila.gridx = 1;
		gbc_lblBojaVozila.gridy = 0;
		bojaMasaPodaci.add(lblBojaVozila, gbc_lblBojaVozila);
		
		JLabel label_21 = new JLabel("Nijansa boje");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.anchor = GridBagConstraints.EAST;
		gbc_label_21.insets = new Insets(0, 0, 5, 5);
		gbc_label_21.gridx = 0;
		gbc_label_21.gridy = 1;
		bojaMasaPodaci.add(label_21, gbc_label_21);
		
		JLabel lblNijansaBoje = new JLabel("Nijansa boje");
		GridBagConstraints gbc_lblNijansaBoje = new GridBagConstraints();
		gbc_lblNijansaBoje.insets = new Insets(0, 0, 5, 0);
		gbc_lblNijansaBoje.gridx = 1;
		gbc_lblNijansaBoje.gridy = 1;
		bojaMasaPodaci.add(lblNijansaBoje, gbc_lblNijansaBoje);
		
		JLabel label_22 = new JLabel("Vrsta boje");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.anchor = GridBagConstraints.EAST;
		gbc_label_22.insets = new Insets(0, 0, 5, 5);
		gbc_label_22.gridx = 0;
		gbc_label_22.gridy = 2;
		bojaMasaPodaci.add(label_22, gbc_label_22);
		
		JLabel lblVrstaBoje = new JLabel("Vrsta boje");
		GridBagConstraints gbc_lblVrstaBoje = new GridBagConstraints();
		gbc_lblVrstaBoje.insets = new Insets(0, 0, 5, 0);
		gbc_lblVrstaBoje.gridx = 1;
		gbc_lblVrstaBoje.gridy = 2;
		bojaMasaPodaci.add(lblVrstaBoje, gbc_lblVrstaBoje);
		
		JLabel label_23 = new JLabel("Max. dozvoljena masa");
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.anchor = GridBagConstraints.EAST;
		gbc_label_23.insets = new Insets(0, 0, 5, 5);
		gbc_label_23.gridx = 0;
		gbc_label_23.gridy = 3;
		bojaMasaPodaci.add(label_23, gbc_label_23);
		
		JLabel lblMaxDozvoljenaMasa = new JLabel("Max. dozvoljena masa");
		GridBagConstraints gbc_lblMaxDozvoljenaMasa = new GridBagConstraints();
		gbc_lblMaxDozvoljenaMasa.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaxDozvoljenaMasa.gridx = 1;
		gbc_lblMaxDozvoljenaMasa.gridy = 3;
		bojaMasaPodaci.add(lblMaxDozvoljenaMasa, gbc_lblMaxDozvoljenaMasa);
		
		JLabel label_24 = new JLabel("Masa");
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.anchor = GridBagConstraints.EAST;
		gbc_label_24.insets = new Insets(0, 0, 5, 5);
		gbc_label_24.gridx = 0;
		gbc_label_24.gridy = 4;
		bojaMasaPodaci.add(label_24, gbc_label_24);
		
		JLabel lblMasa = new JLabel("Masa");
		GridBagConstraints gbc_lblMasa = new GridBagConstraints();
		gbc_lblMasa.insets = new Insets(0, 0, 5, 0);
		gbc_lblMasa.gridx = 1;
		gbc_lblMasa.gridy = 4;
		bojaMasaPodaci.add(lblMasa, gbc_lblMasa);
		
		JLabel label_25 = new JLabel("Dopustiva nosivost");
		GridBagConstraints gbc_label_25 = new GridBagConstraints();
		gbc_label_25.anchor = GridBagConstraints.EAST;
		gbc_label_25.insets = new Insets(0, 0, 0, 5);
		gbc_label_25.gridx = 0;
		gbc_label_25.gridy = 5;
		bojaMasaPodaci.add(label_25, gbc_label_25);
		
		JLabel lblDopustivaNosivost = new JLabel("Dopustiva nosivost");
		GridBagConstraints gbc_lblDopustivaNosivost = new GridBagConstraints();
		gbc_lblDopustivaNosivost.gridx = 1;
		gbc_lblDopustivaNosivost.gridy = 5;
		bojaMasaPodaci.add(lblDopustivaNosivost, gbc_lblDopustivaNosivost);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 2;
		okvirPanel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 0, 83, 0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0, 0};
		gbl_buttonPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btn_modifikuj = new JButton("Modifikacija");
		GridBagConstraints gbc_btn_modifikuj = new GridBagConstraints();
		gbc_btn_modifikuj.insets = new Insets(0, 0, 5, 5);
		gbc_btn_modifikuj.gridx = 0;
		gbc_btn_modifikuj.gridy = 0;
		buttonPanel.add(btn_modifikuj, gbc_btn_modifikuj);
		
		JButton btn_promjenaVlasnika = new JButton("Promjena vlasnika");
		GridBagConstraints gbc_btn_promjenaVlasnika = new GridBagConstraints();
		gbc_btn_promjenaVlasnika.insets = new Insets(0, 0, 5, 5);
		gbc_btn_promjenaVlasnika.gridx = 1;
		gbc_btn_promjenaVlasnika.gridy = 0;
		buttonPanel.add(btn_promjenaVlasnika, gbc_btn_promjenaVlasnika);
		
		JButton btn_promjenaVlasnicke = new JButton("Promjena vlasni\u010Dke");
		GridBagConstraints gbc_btn_promjenaVlasnicke = new GridBagConstraints();
		gbc_btn_promjenaVlasnicke.insets = new Insets(0, 0, 5, 0);
		gbc_btn_promjenaVlasnicke.gridx = 2;
		gbc_btn_promjenaVlasnicke.gridy = 0;
		buttonPanel.add(btn_promjenaVlasnicke, gbc_btn_promjenaVlasnicke);
		
		JButton btn_odjava = new JButton("Odjava vozila");
		GridBagConstraints gbc_btn_odjava = new GridBagConstraints();
		gbc_btn_odjava.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_odjava.gridwidth = 2;
		gbc_btn_odjava.insets = new Insets(0, 0, 0, 5);
		gbc_btn_odjava.gridx = 0;
		gbc_btn_odjava.gridy = 1;
		buttonPanel.add(btn_odjava, gbc_btn_odjava);
		
		JButton btn_izlaz = new JButton("Izlaz");
		GridBagConstraints gbc_btn_izlaz = new GridBagConstraints();
		gbc_btn_izlaz.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_izlaz.gridx = 2;
		gbc_btn_izlaz.gridy = 1;
		buttonPanel.add(btn_izlaz, gbc_btn_izlaz);
	}

}
