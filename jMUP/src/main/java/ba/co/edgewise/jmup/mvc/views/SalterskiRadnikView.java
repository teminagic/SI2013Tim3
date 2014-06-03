package ba.co.edgewise.jmup.mvc.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.GodisnjaOvjera;
import ba.co.edgewise.jmup.components.Izvjestaji;
import ba.co.edgewise.jmup.components.MeniSalter;
import ba.co.edgewise.jmup.components.MeniSalterOpcije;
import ba.co.edgewise.jmup.components.NaslovnaSalterski;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.PromjenaVlasnikaVozila;
import ba.co.edgewise.jmup.components.RegistracijaUnos;
import ba.co.edgewise.jmup.components.SalterskaPretraga;
import ba.co.edgewise.jmup.components.VozacDodavanje;
import ba.co.edgewise.jmup.components.VoziloDodavanje;
import ba.co.edgewise.jmup.components.VoziloModifikacija;
import ba.co.edgewise.jmup.mvc.controllers.LoginController;

public class SalterskiRadnikView extends JFrame {

	private JPanel contentPane;
	private MeniSalter meni;
	private NaslovnaSalterski strana1; // bit ce ih vise zavisno od buttona
	private OpcijaSadrzaj sadrzaj;
	
	GridBagConstraints gbc_naslov;
	GridBagConstraints gbc_meni;
	
	private VozacDodavanje strana2;
	private VoziloDodavanje strana3;
	private SalterskaPretraga strana6;
	private RegistracijaUnos strana4Registracija;
	private GodisnjaOvjera strana7;
	private Izvjestaji strana9;
	private PromjenaVlasnikaVozila strana8;
	private VoziloModifikacija strana10;
	
	private final SalterskiRadnikView frejm = this;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SalterskiRadnikView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gridBagLayout);
		this.setVisible(true);
		
		meni =  new MeniSalter();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) meni.getLayout();
		gridBagLayout_1.columnWidths = new int[]{133};
		gbc_meni = new GridBagConstraints();
		gbc_meni.anchor = GridBagConstraints.NORTH;
		gbc_meni.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("Početna");
		gbc_naslov = new GridBagConstraints();
		gbc_naslov.anchor = GridBagConstraints.NORTH;
		gbc_naslov.fill = GridBagConstraints.HORIZONTAL;
		
		//Ovdje dodajmo sve card-ove
		strana1 = new NaslovnaSalterski();
		sadrzaj.getPanelSadrzaj().add(strana1, "Po\u010Detna");
		
		strana2 = new VozacDodavanje();
		sadrzaj.getPanelSadrzaj().add(strana2, "Dodavanje voza\u010Da");
		
		strana3 = new VoziloDodavanje();
		sadrzaj.getPanelSadrzaj().add(strana3, "Dodavanje vozila");
		
		strana6 = new SalterskaPretraga();
		sadrzaj.getPanelSadrzaj().add(strana6, "Pretraga");
		
		strana4Registracija = new RegistracijaUnos();
		sadrzaj.getPanelSadrzaj().add(strana4Registracija,"Unos registracije");
		
		strana6 = new SalterskaPretraga();
		sadrzaj.getPanelSadrzaj().add(strana6, "Pretraga");
		
		strana7 = new GodisnjaOvjera();
		sadrzaj.getPanelSadrzaj().add(strana7, "Godi\u0161nja ovjera registracije");
		
		strana8 = new PromjenaVlasnikaVozila();
		sadrzaj.getPanelSadrzaj().add(strana8, "Promjena vlasnika");
		
		strana9 = new Izvjestaji();
		sadrzaj.getPanelSadrzaj().add(strana9, "Izrada izvje\u0161taja");
		
		strana10 = new VoziloModifikacija();
		sadrzaj.getPanelSadrzaj().add(strana10, "Modifikacija vozila");
		
		contentPane.add(sadrzaj, gbc_naslov);

	}


	public SalterskaPretraga getStrana6() {
		return strana6;
	}	
	public void prikaziPromjenuVlasnika(){
		frejm.getSadrzaj().getNaslov().postaviNaslov("Promjena vlasnika");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Promjena vlasnika");
	}
	public void prikaziPocetnu(){
		frejm.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Po\u010Detna");
	}
	public void prikaziUnosVozila()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Dodavanje vozila");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Dodavanje vozila");
	}
	public void prikaziUnosVozaca()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Dodavanje voza\u010Da");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Dodavanje voza\u010Da");
	}
	
	public void prikaziUnosRegistracije(){
		frejm.getSadrzaj().getNaslov().postaviNaslov("Unos registracije");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Unos registracije");
	}
	
	public void prikaziPretragu() {
		frejm.getSadrzaj().getNaslov().postaviNaslov("Pretraga");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Pretraga");
	}
	public void prikaziOvjeruRegistracije() {
		frejm.getSadrzaj().getNaslov().postaviNaslov("Godi\u0161nja ovjera registracije");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Godi\u0161nja ovjera registracije");
	}
	public void prikaziIzvjestaje() {
		frejm.getSadrzaj().getNaslov().postaviNaslov("Izrada izvje\u0161taja");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Izrada izvje\u0161taja");
	}
	public void prikaziModifikacijuVozila()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Modifikacija vozila");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Modifikacija vozila");
	}
	public JPanel getContentPane() {
		return contentPane;///
	}


	public MeniSalter getMeni() {
		return meni;
	}


	public NaslovnaSalterski getPocetna() {
		return strana1;
	}


	public OpcijaSadrzaj getSadrzaj() {
		return sadrzaj;
	}
	
	public VozacDodavanje getStrana2() {
		return strana2;
	}
	public VoziloDodavanje getVoziloDodavanje() {
		return strana3;
	}
	public VoziloModifikacija getVoziloModifikacija() {
		return strana10;
	}
	//public JButton getVoziloDodavanjePrihvatiButton() {
	//	return voziloDodavanje.getBtn_prihvati();
	//} 
	public GridBagConstraints getGbc_naslov() {
		return gbc_naslov;
	}
	public GridBagConstraints getGbc_meni() {
		return gbc_meni;
	}
	public RegistracijaUnos getRegistracija() {
		return strana4Registracija;
	}


	public GodisnjaOvjera getGodisnjaOvjera() {
		return strana7;
	}


	public Izvjestaji getIzvjestaji() {
		return strana9;
	}


	public PromjenaVlasnikaVozila getPromjenaVlasnika() {
		return strana8;
	}
}
