package co.ba.edgewise.components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
//

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SalterskaPretraga extends JPanel {

	private static final long serialVersionUID = 3730281444612333050L;
	private JTextField tb_unosPretrage;
	private JRadioButton rbVozac;
	private JRadioButton rbSaobracajna;
	private JRadioButton rbVlasnicka;
	private JRadioButton rbVozilo;
	private JButton btn_modifikuj;
	private JButton btnPregled;
	private JComboBox cb_parametri;
	private GridBagLayout gridBagLayout;
	private JLabel lblPodaci;

	JPanel okvirPanel;
	static String voziloString = "Vozilo";
	static String VozacString = "Vozac";
	static String vlasnickaString = "Vlasnicka";
	static String saobracajnaString = "Saobracajna";
	String trenutni = "Vozilo";

	// Enumi za combobox
	enum VoziloPretraga {
		Registarska_oznaka("Registarska oznaka"), Godina_proizvodnje(
				"Godina proizvodnje"), Vrsta_vozila("Vrsta vozila"), Marka_vozila(
				"Marka vozila");
		private final String stringValue;

		private VoziloPretraga(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	enum VozacPretraga {
		Ime("Ime"), Prezime("Prezime"), JMBG("JMBG"), Broj_licne("Broj lične");
		private final String stringValue;

		private VozacPretraga(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	public enum VlasnickaPretraga {
		Broj_potvrde("Broj potvrde"), Registarska_oznaka("Registarska oznaka"), Ime_prezime(
				"Ime i prezime"), JMBG_vlasnika("JMBG vlasnika");
		private final String stringValue;

		private VlasnickaPretraga(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	public enum SaobracajnaPretraga {
		Broj_potvrde("Broj potvrde"), Registarska_oznaka("Registarska oznaka"), Ime_prezime(
				"Ime i prezime"), JMBG_vozaca("JMBG voza�a");
		private final String stringValue;

		private SaobracajnaPretraga(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}

	// Moguci paneli
	static JPanel panel_vozilo = new SalterskaPretragaVozilo();
	static JPanel panel_vozac = new SalterskaPretragaVozac();
	static JPanel panel_saobracajna = new SalterskaPretragaSaobracajna();
	static JPanel panel_vlasnicka = new SalterskaPretragaVlasnicka();

	public SalterskaPretraga() {
		setLayout();
		setPanel();
		setLabel();
		setInput();
		setComponents();
	}

	public void setLayout() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 629, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 374, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// JPanel panel = new JPanel();
		// Default je postavljeno da bude Vozilo.

		final GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 8;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		okvirPanel.add(panel_vozilo, gbc_panel);
	}

	public void setPanel() {
		okvirPanel = new JPanel();
		okvirPanel.setBorder(new TitledBorder(null, "Pretraga",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_okvirPanel = new GridBagConstraints();
		gbc_okvirPanel.insets = new Insets(0, 0, 5, 5);
		gbc_okvirPanel.fill = GridBagConstraints.BOTH;
		gbc_okvirPanel.gridx = 1;
		gbc_okvirPanel.gridy = 1;
		add(okvirPanel, gbc_okvirPanel);
		GridBagLayout gbl_okvirPanel = new GridBagLayout();
		gbl_okvirPanel.columnWidths = new int[] { 24, 23, 38, 46, 43, 113, 100,
				102, 66, 39, 0 };
		gbl_okvirPanel.rowHeights = new int[] { 26, 0, 261, 38, 0 };
		gbl_okvirPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_okvirPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		okvirPanel.setLayout(gbl_okvirPanel);
	}

	public void setLabel() {
		lblPodaci = new JLabel("Podaci:");
		GridBagConstraints gbc_lblPodaci = new GridBagConstraints();
		gbc_lblPodaci.anchor = GridBagConstraints.EAST;
		gbc_lblPodaci.insets = new Insets(0, 0, 5, 5);
		gbc_lblPodaci.gridx = 2;
		gbc_lblPodaci.gridy = 0;
		okvirPanel.add(lblPodaci, gbc_lblPodaci);
	}

	public void setInput() {
		tb_unosPretrage = new JTextField();
		GridBagConstraints gbc_tb_unosPretrage = new GridBagConstraints();
		gbc_tb_unosPretrage.gridwidth = 4;
		gbc_tb_unosPretrage.insets = new Insets(0, 0, 5, 5);
		gbc_tb_unosPretrage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tb_unosPretrage.gridx = 3;
		gbc_tb_unosPretrage.gridy = 0;
		okvirPanel.add(tb_unosPretrage, gbc_tb_unosPretrage);
		tb_unosPretrage.setColumns(10);
	}

	public void setComponents() {
		cb_parametri = new JComboBox();
		cb_parametri
				.setModel(new DefaultComboBoxModel(VoziloPretraga.values()));
		GridBagConstraints gbc_cb_parametri = new GridBagConstraints();
		gbc_cb_parametri.gridwidth = 2;
		gbc_cb_parametri.insets = new Insets(0, 0, 5, 5);
		gbc_cb_parametri.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_parametri.gridx = 7;
		gbc_cb_parametri.gridy = 0;
		okvirPanel.add(cb_parametri, gbc_cb_parametri);

		rbVozilo = new JRadioButton("Vozilo");
		rbVozilo.setActionCommand(voziloString);
		rbVozilo.setSelected(true);
		GridBagConstraints gbc_rbVozilo = new GridBagConstraints();
		gbc_rbVozilo.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbVozilo.insets = new Insets(0, 0, 5, 5);
		gbc_rbVozilo.gridx = 3;
		gbc_rbVozilo.gridy = 1;
		okvirPanel.add(rbVozilo, gbc_rbVozilo);

		rbVozac = new JRadioButton("Voza\u010D");
		rbVozac.setActionCommand(VozacString);
		GridBagConstraints gbc_rbVozac = new GridBagConstraints();
		gbc_rbVozac.insets = new Insets(0, 0, 5, 5);
		gbc_rbVozac.gridx = 4;
		gbc_rbVozac.gridy = 1;
		okvirPanel.add(rbVozac, gbc_rbVozac);

		rbSaobracajna = new JRadioButton("Saobra\u0107ajna dozvola");
		rbSaobracajna.setActionCommand(saobracajnaString);
		GridBagConstraints gbc_rbSaobracajna = new GridBagConstraints();
		gbc_rbSaobracajna.anchor = GridBagConstraints.EAST;
		gbc_rbSaobracajna.insets = new Insets(0, 0, 5, 5);
		gbc_rbSaobracajna.gridx = 5;
		gbc_rbSaobracajna.gridy = 1;
		okvirPanel.add(rbSaobracajna, gbc_rbSaobracajna);

		rbVlasnicka = new JRadioButton("Vlasni\u010Dka dozvola");
		rbVlasnicka.setActionCommand(vlasnickaString);
		GridBagConstraints gbc_rbVlasnicka = new GridBagConstraints();
		gbc_rbVlasnicka.insets = new Insets(0, 0, 5, 5);
		gbc_rbVlasnicka.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbVlasnicka.gridx = 6;
		gbc_rbVlasnicka.gridy = 1;
		okvirPanel.add(rbVlasnicka, gbc_rbVlasnicka);

		// Grupisanje radiobuttona - da bi mogao samo jedan biti true
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rbVozilo);
		radioGroup.add(rbVozac);
		radioGroup.add(rbSaobracajna);
		radioGroup.add(rbVlasnicka);

		btnPregled = new JButton("Pregled");
		GridBagConstraints gbc_btnPregled = new GridBagConstraints();
		gbc_btnPregled.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPregled.insets = new Insets(0, 0, 0, 5);
		gbc_btnPregled.gridx = 7;
		gbc_btnPregled.gridy = 3;
		okvirPanel.add(btnPregled, gbc_btnPregled);

		btn_modifikuj = new JButton("Modifikuj");
		GridBagConstraints gbc_btn_modifikuj = new GridBagConstraints();
		gbc_btn_modifikuj.insets = new Insets(0, 0, 0, 5);
		gbc_btn_modifikuj.gridx = 8;
		gbc_btn_modifikuj.gridy = 3;
		okvirPanel.add(btn_modifikuj, gbc_btn_modifikuj);

	}

	public JRadioButton getRbVozac() {
		return rbVozac;
	}

	public void setRbVozac(JRadioButton rbVozac) {
		this.rbVozac = rbVozac;
	}

	public JRadioButton getRbSaobracajna() {
		return rbSaobracajna;
	}

	public void setRbSaobracajna(JRadioButton rbSaobracajna) {
		this.rbSaobracajna = rbSaobracajna;
	}

	public JRadioButton getRbVlasnicka() {
		return rbVlasnicka;
	}

	public void setRbVlasnicka(JRadioButton rbVlasnicka) {
		this.rbVlasnicka = rbVlasnicka;
	}

	public JRadioButton getRbVozilo() {
		return rbVozilo;
	}

	public void setRbVozilo(JRadioButton rbVozilo) {
		this.rbVozilo = rbVozilo;
	}

	public JButton getBtnProfil() {
		return btnPregled;
	}

	public JButton getBtn_modifikuj() {
		return btn_modifikuj;
	}
}
