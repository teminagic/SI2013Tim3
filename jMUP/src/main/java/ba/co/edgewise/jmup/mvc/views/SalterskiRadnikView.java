package ba.co.edgewise.jmup.mvc.views;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.components.helpers.ModifikacijaSaobracajne;
import ba.co.edgewise.components.helpers.ModifikacijaVlasnicke;
import ba.co.edgewise.components.helpers.ModifikacijaVozaca;
import ba.co.edgewise.components.helpers.ModifikacijaVozila;
import ba.co.edgewise.components.helpers.TableModelSaobracajna;
import ba.co.edgewise.components.helpers.TableModelVlasnicka;
import ba.co.edgewise.components.helpers.TableModelVozac;
import ba.co.edgewise.components.helpers.TableModelVozilo;
import ba.co.edgewise.jmup.components.GodisnjaOvjera;
import ba.co.edgewise.jmup.components.Izvjestaji;
import ba.co.edgewise.jmup.components.MeniSalter;
import ba.co.edgewise.jmup.components.NaslovnaSalterski;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.PromjenaVlasnikaVozila;
import ba.co.edgewise.jmup.components.RegistracijaUnos;
import ba.co.edgewise.jmup.components.SalterskaPretraga;
import ba.co.edgewise.jmup.components.VozacDodavanje;
import ba.co.edgewise.jmup.components.VozacModifikacija;
import ba.co.edgewise.jmup.components.VoziloDodavanje;
import ba.co.edgewise.jmup.components.VoziloModifikacija;
import ba.co.edgewise.jmup.daldao.daos.BojeVozilaDAO;
import ba.co.edgewise.jmup.klase.BojaVozila;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.klase.Vozilo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalterskiRadnikView extends JFrame {

	
	private static final long serialVersionUID = 5718223478027300911L;
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
	private VozacModifikacija strana11;
	private VoziloModifikacija strana13;
	private VozacModifikacija strana12;
	private VoziloModifikacija strana15;
	private VozacModifikacija strana14;
	
	private final SalterskiRadnikView frejm = this;
	
	private ModifikacijaSaobracajne novaS;
	private ModifikacijaVlasnicke novaV;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SalterskiRadnikView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		
		this.setVisible(true);
		
		meni = new MeniSalter();
		GridBagConstraints gbc_meni = new GridBagConstraints();
		gbc_meni.fill = GridBagConstraints.VERTICAL;
		gbc_meni.insets = new Insets(0, 5, 0, 5);
		contentPane.add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("Početna");
		GridBagConstraints gbc_sadrzaj = new GridBagConstraints();
		gbc_sadrzaj.fill = GridBagConstraints.BOTH;
		gbc_sadrzaj.insets = new Insets(0, 0, 0, 5);
		
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
		
		strana10 = new VoziloModifikacija(null, null);
		strana10.getBtn_modifikuj().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pozoviModifikacijuVozila();
			}
		});
		sadrzaj.getPanelSadrzaj().add(strana10, "Modifikacija vozila");
		
		strana11 = new VozacModifikacija(null);
		strana11.getBtnPrihvati().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pozoviModifikacijuVozaca();
			}
		});
		sadrzaj.getPanelSadrzaj().add(strana11, "Modifikacija voza\u010Da");
		
		strana12 = new VozacModifikacija(null);
		strana12.getBtnPrihvati().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				prikaziModifikacijuVozilaSaobracajna();
			}
		});
		sadrzaj.getPanelSadrzaj().add(strana12, "Modifikacija voza\u010Da saobracajna");
		
		strana13 = new VoziloModifikacija(null, null);
		strana13.getBtn_modifikuj().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pozoviModifikacijuSaobracajne();
			}
		});
		sadrzaj.getPanelSadrzaj().add(strana13, "Modifikacija vozila saobracajna");
		
		strana14 = new VozacModifikacija(null);
		strana14.getBtnPrihvati().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				prikaziModifikacijuVozilaVlasnicka();
			}
		});
		sadrzaj.getPanelSadrzaj().add(strana14, "Modifikacija voza\u010Da vlasnicka");
		
		strana15 = new VoziloModifikacija(null, null);
		strana15.getBtn_modifikuj().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pozoviModifikacijuVlasnicke();
			}
		});
		sadrzaj.getPanelSadrzaj().add(strana15, "Modifikacija vozila vlasnicka");
		
		
		contentPane.add(sadrzaj, gbc_sadrzaj);
		

	}
	
	public void pozoviModifikacijuVlasnicke(){
		novaV.modificirajVlasnicku();
	}
	
	public void pozoviModifikacijuSaobracajne()
	{
		 novaS.modificirajSaobracajnu();
	}
	
	public void pozoviModifikacijuVozila()
	{
		ModifikacijaVozila nova = new ModifikacijaVozila(this);
		nova.modificirajVozilo();
	}
	public void pozoviModifikacijuVozaca()
	{
		ModifikacijaVozaca nova = new ModifikacijaVozaca(this);
		nova.modificirajVozaca();
	}
	
	public void pozoviModifikacijuVozacaSaobraćajna()
	{
		
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
		frejm.getStrana6().getRbVozilo().setSelected(true);
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
		
		int selektovano = this.getStrana6().getPanel_vozilo().getTable().getSelectedRow();
		TableModelVozilo modelTabele = this.getStrana6().getPanel_vozilo().getModel();
		Vozilo v = modelTabele.getData().get(selektovano);
		
		this.strana10.setVozilo(v);
		
		BojaVozila boja = (new BojeVozilaDAO()).get(v.getId());
		this.strana10.setBoja(boja);
		
		strana10.postaviVrijednosti();
		
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Modifikacija vozila");
	}
	
	public void prikaziModifikacijuVozaca()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Modifikacija voza\u010Da");
		
		int selektovano = this.getStrana6().getPanel_vozac().getTable().getSelectedRow();
		TableModelVozac modelTabele = this.getStrana6().getPanel_vozac().getModel();
		Osoba v = modelTabele.getData().get(selektovano);
		
		this.strana11.setVozac(v);;
		
		strana11.postaviVrijednosti();
		
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Modifikacija voza\u010Da");
	}
	
	public void prikaziModifikacijuSaobracajne()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Modifikacija voza\u010Da");
		
		int selektovano = this.getStrana6().getPanel_saobracajna().getTable().getSelectedRow();
		TableModelSaobracajna modelTabele = this.getStrana6().getPanel_saobracajna().getModel();
		Saobracajna s = modelTabele.getData().get(selektovano);
		
		novaS = new ModifikacijaSaobracajne(this);
		novaS.setSaobracajna(s); 
		
		this.strana12.setVozac(s.getKorisnik());
		strana12.postaviVrijednosti();
		strana12.getBtnPrihvati().setText("Dalje");
		
		this.strana13.setVozilo(s.getVozilo());
		BojaVozila boja = (new BojeVozilaDAO()).get(s.getVozilo().getId());
		this.strana13.setBoja(boja);
		strana13.postaviVrijednosti();
		
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Modifikacija voza\u010Da saobracajna");
	}
	
	public void prikaziModifikacijuVozilaSaobracajna()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Modifikacija vozila");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Modifikacija vozila saobracajna");
	}
	
	public void prikaziModifikacijuVlasnicke()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Modifikacija voza\u010Da");
		
		int selektovano = this.getStrana6().getPanel_vlasnicka().getTable().getSelectedRow();
		TableModelVlasnicka modelTabele = this.getStrana6().getPanel_vlasnicka().getModel();
		Vlasnicka v = modelTabele.getData().get(selektovano);
		
		novaV = new ModifikacijaVlasnicke(this);
		novaV.setVlasnicka(v); 
		
		this.strana14.setVozac(v.getVlasnik());
		strana14.postaviVrijednosti();
		strana14.getBtnPrihvati().setText("Dalje");
		
		this.strana15.setVozilo(v.getVozilo());
		BojaVozila boja = (new BojeVozilaDAO()).get(v.getVozilo().getId());
		this.strana15.setBoja(boja);
		strana15.postaviVrijednosti();
		
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Modifikacija voza\u010Da vlasnicka");
	}
	
	public void prikaziModifikacijuVozilaVlasnicka()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Modifikacija vozila");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Modifikacija vozila vlasnicka");
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
	public VozacModifikacija getStrana11() {
		return strana11;
	}
	public VozacModifikacija getStrana12() {
		return strana12;
	}
	public VoziloModifikacija getStrana13() {
		return strana13;
	}
	public VozacModifikacija getStrana14() {
		return strana14;
	}
	public VoziloModifikacija getStrana15() {
		return strana15;
	}
}
