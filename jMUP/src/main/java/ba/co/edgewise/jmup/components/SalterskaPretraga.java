package ba.co.edgewise.jmup.components;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
//import ba.co.edgewise.jmup.components.SalterskaPretraga.VoziloPretraga;
import java.awt.CardLayout;
import ba.co.edgewise.jmup.enums.VrstaVozila;



public class SalterskaPretraga extends JPanel{


	private JTextField tb_unosPretrage;
	JRadioButton rbVozac; 
	JRadioButton rbSaobracajna;
	JRadioButton rbVlasnicka; 
	JRadioButton rbVozilo;
	private JButton btn_modifikuj;
	
	private final SalterskaPretraga frejm = this;
	
	// Moguci paneli 
	JPanel panel_pretraga;//=new SalterskaPretragaVozilo();
	SalterskaPretragaVozilo panel_vozilo;//=new SalterskaPretragaVozac();
	SalterskaPretragaVozac panel_vozac;
	SalterskaPretragaSaobracajna panel_saobracajna;
	SalterskaPretragaVlasnicka panel_vlasnicka;
	private JComboBox cb_parametri;
	private JButton btnPretrazi;
	
	//Enumi za combobox
	/*enum VoziloPretraga { Registarska_oznaka("Registarska oznaka"), Godina_proizvodnje("Godina proizvodnje"), Vrsta_vozila("Vrsta vozila"), Marka_vozila("Marka vozila");
	   private final String stringValue;
	   private VoziloPretraga(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
	}
	enum VozacPretraga { Ime("Ime"), Prezime("Prezime"), JMBG("JMBG"), Broj_licne("Broj lične"); 
	private final String stringValue;
	   private VozacPretraga(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
	}
	public enum VlasnickaPretraga { Broj_potvrde("Broj potvrde"), Registarska_oznaka(""), Ime_prezime("Ime i prezime"), JMBG_vlasnika("JMBG vlasnika") ; 
		private final String stringValue;
	   private VlasnickaPretraga(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
	}
	public enum SaobracajnaPretraga { Broj_potvrde("Broj potvrde"), Registarska_oznaka("Registarska oznaka"), Ime_prezime("Ime i prezime"), JMBG_vozaca("JMBG vozača"); 
		private final String stringValue;
	   private SaobracajnaPretraga(final String s) { stringValue = s; }
	   public String toString() { return stringValue; }
	   }*/


	public SalterskaPretraga() {
		initialize();
	}

	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 629, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 374, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		final JPanel okvirPanel = new JPanel();
		okvirPanel.setBorder(new TitledBorder(null, "Pretraga", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_okvirPanel = new GridBagConstraints();
		gbc_okvirPanel.insets = new Insets(0, 0, 5, 5);
		gbc_okvirPanel.fill = GridBagConstraints.BOTH;
		gbc_okvirPanel.gridx = 1;
		gbc_okvirPanel.gridy = 1;
		add(okvirPanel, gbc_okvirPanel);
		GridBagLayout gbl_okvirPanel = new GridBagLayout();
		gbl_okvirPanel.columnWidths = new int[]{24, 63, 46, 43, 113, 97, 28, 66, 39, 0};
		gbl_okvirPanel.rowHeights = new int[]{0, 26, 0, 261, 38, 0, 0};
		gbl_okvirPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_okvirPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		okvirPanel.setLayout(gbl_okvirPanel);
		
		JLabel lblPodaci = new JLabel("Podaci:");
		GridBagConstraints gbc_lblPodaci = new GridBagConstraints();
		gbc_lblPodaci.anchor = GridBagConstraints.WEST;
		gbc_lblPodaci.insets = new Insets(0, 0, 5, 5);
		gbc_lblPodaci.gridx = 1;
		gbc_lblPodaci.gridy = 1;
		okvirPanel.add(lblPodaci, gbc_lblPodaci);
		
		tb_unosPretrage = new JTextField();
		GridBagConstraints gbc_tb_unosPretrage = new GridBagConstraints();
		gbc_tb_unosPretrage.gridwidth = 3;
		gbc_tb_unosPretrage.insets = new Insets(0, 0, 5, 5);
		gbc_tb_unosPretrage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tb_unosPretrage.gridx = 2;
		gbc_tb_unosPretrage.gridy = 1;
		okvirPanel.add(tb_unosPretrage, gbc_tb_unosPretrage);
		tb_unosPretrage.setColumns(10);
		
		cb_parametri = new JComboBox();
		//cb_parametri.setModel(new DefaultComboBoxModel(VoziloPretraga.values()));
		GridBagConstraints gbc_cb_parametri = new GridBagConstraints();
		gbc_cb_parametri.insets = new Insets(0, 0, 5, 5);
		gbc_cb_parametri.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_parametri.gridx = 5;
		gbc_cb_parametri.gridy = 1;
		okvirPanel.add(cb_parametri, gbc_cb_parametri);
		
		btnPretrazi = new JButton("Pretra\u017Ei");
		GridBagConstraints gbc_btnPretrazi = new GridBagConstraints();
		gbc_btnPretrazi.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPretrazi.insets = new Insets(0, 0, 5, 5);
		gbc_btnPretrazi.gridx = 7;
		gbc_btnPretrazi.gridy = 1;
		okvirPanel.add(btnPretrazi, gbc_btnPretrazi);
		
		rbVozilo = new JRadioButton("Vozilo");
		rbVozilo.setSelected(true);
		GridBagConstraints gbc_rbVozilo = new GridBagConstraints();
		gbc_rbVozilo.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbVozilo.insets = new Insets(0, 0, 5, 5);
		gbc_rbVozilo.gridx = 2;
		gbc_rbVozilo.gridy = 2;
		okvirPanel.add(rbVozilo, gbc_rbVozilo);
		
		
		rbVozac = new JRadioButton("Voza\u010D");
		GridBagConstraints gbc_rbVozac = new GridBagConstraints();
		gbc_rbVozac.insets = new Insets(0, 0, 5, 5);
		gbc_rbVozac.gridx = 3;
		gbc_rbVozac.gridy = 2;
		okvirPanel.add(rbVozac, gbc_rbVozac);
	
		rbSaobracajna = new JRadioButton("Saobra\u0107ajna dozvola");
		GridBagConstraints gbc_rbSaobracajna = new GridBagConstraints();
		gbc_rbSaobracajna.anchor = GridBagConstraints.EAST;
		gbc_rbSaobracajna.insets = new Insets(0, 0, 5, 5);
		gbc_rbSaobracajna.gridx = 4;
		gbc_rbSaobracajna.gridy = 2;
		okvirPanel.add(rbSaobracajna, gbc_rbSaobracajna);
		
		rbVlasnicka= new JRadioButton("Vlasni\u010Dka dozvola");
		GridBagConstraints gbc_rbVlasnicka = new GridBagConstraints();
		gbc_rbVlasnicka.insets = new Insets(0, 0, 5, 5);
		gbc_rbVlasnicka.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbVlasnicka.gridx = 5;
		gbc_rbVlasnicka.gridy = 2;
		okvirPanel.add(rbVlasnicka, gbc_rbVlasnicka);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rbVozilo);
		radioGroup.add(rbVozac);
		radioGroup.add(rbSaobracajna);
		radioGroup.add(rbVlasnicka);

		panel_pretraga = new JPanel();
		final GridBagConstraints gbc_panel_pretraga = new GridBagConstraints();
		gbc_panel_pretraga.insets = new Insets(0, 0, 5, 5);
		gbc_panel_pretraga.gridwidth = 7;
		gbc_panel_pretraga.fill = GridBagConstraints.VERTICAL;
		gbc_panel_pretraga.gridx = 1;
		gbc_panel_pretraga.gridy = 3;
		okvirPanel.add(panel_pretraga, gbc_panel_pretraga);
		panel_pretraga.setLayout(new CardLayout(0, 0));
		
		btn_modifikuj = new JButton("Modifikuj");
		btn_modifikuj.setEnabled(false);
		GridBagConstraints gbc_btn_modifikuj = new GridBagConstraints();
		gbc_btn_modifikuj.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_modifikuj.insets = new Insets(0, 0, 5, 5);
		gbc_btn_modifikuj.gridx = 7;
		gbc_btn_modifikuj.gridy = 4;
		okvirPanel.add(btn_modifikuj, gbc_btn_modifikuj);
		
		panel_vozilo = new SalterskaPretragaVozilo();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) panel_vozilo.getLayout();
		gridBagLayout_1.rowWeights = new double[]{1.0};
		gridBagLayout_1.columnWeights = new double[]{1.0};
		panel_vozac = new SalterskaPretragaVozac();
		panel_saobracajna = new SalterskaPretragaSaobracajna();
		panel_vlasnicka = new SalterskaPretragaVlasnicka();
			
		panel_pretraga.add(panel_vozilo, "Vozilo");
		panel_pretraga.add(panel_vozac, "Vozac");
		panel_pretraga.add(panel_saobracajna, "Saobracajna");
		panel_pretraga.add(panel_vlasnicka, "Vlasnicka");

	}

	public void prikaziPretraguVozila()
	{
		JPanel cards = frejm.getPanel_pretraga();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Vozilo");
	}
	public void prikaziPretraguVozaca()
	{
		JPanel cards = frejm.getPanel_pretraga();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Vozac");
	}
	public void prikaziPretraguVlasnicke()
	{
		JPanel cards = frejm.getPanel_pretraga();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Vlasnicka");
	}
	public void prikaziPretraguSaobracajne()
	{
		JPanel cards = frejm.getPanel_pretraga();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Saobracajna");
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


	public JButton getBtn_modifikuj() {
		return btn_modifikuj;
	}


	public JComboBox getCb_parametri() {
		return cb_parametri;
	}
	public JTextField getTb_unosPretrage() {
		return tb_unosPretrage;
	}
	public JPanel getPanel_pretraga() {
		return panel_pretraga;
	}
	public SalterskaPretragaVozilo getPanel_vozilo() {
		return panel_vozilo;
	}
	public SalterskaPretragaVozac getPanel_vozac() {
		return panel_vozac;
	}
	public SalterskaPretragaSaobracajna getPanel_saobracajna() {
		return panel_saobracajna;
	}
	public SalterskaPretragaVlasnicka getPanel_vlasnicka() {
		return panel_vlasnicka;
	}
	public JButton getBtnPretrazi() {
		return btnPretrazi;
	}

}
