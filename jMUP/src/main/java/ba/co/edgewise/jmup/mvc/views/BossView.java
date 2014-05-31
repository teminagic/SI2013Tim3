package ba.co.edgewise.jmup.mvc.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.KorisnikKreiranje;
import ba.co.edgewise.jmup.components.KorisnikModificiranje;
import ba.co.edgewise.jmup.components.KorisnikPretraga;
import ba.co.edgewise.jmup.components.MeniAdmin;
import ba.co.edgewise.jmup.components.MeniBoss;
import ba.co.edgewise.jmup.components.NaslovnaMenadzer;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.SalterskaPretraga;
import ba.co.edgewise.jmup.components.VoziloModifikacija;
import ba.co.edgewise.jmup.components.Izvjestaji;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BossView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5872926787361619013L;
	private JPanel contentPane;
	private MeniBoss meni;
	private OpcijaSadrzaj sadrzaj;
	private NaslovnaMenadzer strana1;
	private SalterskaPretraga strana2;
	private VoziloModifikacija strana21;
	private Izvjestaji izvjestaji;

	private final BossView frejm = this;

	public BossView() {
		initialize();
		
		meni =  new MeniBoss();
		GridBagConstraints gbc_meni = new GridBagConstraints();
		gbc_meni.fill = GridBagConstraints.BOTH;
		gbc_meni.insets = new Insets(0, 5, 0, 5);
		contentPane.add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("Po\u010Detna");
		GridBagLayout gridBagLayout = (GridBagLayout) sadrzaj.getLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowHeights = new int[]{66, 0};
		GridBagConstraints gbc_sadrzaj = new GridBagConstraints();
		gbc_sadrzaj.fill = GridBagConstraints.BOTH;
		gbc_sadrzaj.insets = new Insets(0, 0, 0, 5);
		
		strana1 = new NaslovnaMenadzer();
		sadrzaj.getPanelSadrzaj().add(strana1, "Po\u010Detna");
		
		strana2 = new SalterskaPretraga();
		sadrzaj.getPanelSadrzaj().add(strana2, "Pretraga");
		
		izvjestaji = new Izvjestaji();
		sadrzaj.getPanelSadrzaj().add(izvjestaji, "Izrada izvještaja");
				
		contentPane.add(sadrzaj, gbc_sadrzaj);	
	}
	//
	public void initialize(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{0.0,1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		contentPane.setLayout(gridBagLayout);
		this.setVisible(true);
	}
	public void prikaziPocetnu(){
		frejm.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Po\u010Detna");
	}
	public void prikaziPretragu() {
		frejm.getSadrzaj().getNaslov().postaviNaslov("Pretraga");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Pretraga");
	}
	
	
	
	public void prikaziModifikacijuVozila()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Modifikacija vozila");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Modifikacija vozila");
	}
	
	public void prikaziIzvjestaje()
	{
		frejm.getSadrzaj().getNaslov().postaviNaslov("Izrada izvještaja");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Izrada izvještaja");
	}
	public NaslovnaMenadzer getStrana1() {
		return strana1;
	}
	public SalterskaPretraga getStrana2() {
		return this.strana2;
	}
	public VoziloModifikacija getVoziloModifikacija() {
		return strana21;
	}
	public MeniBoss getMeni() {
		return meni;
	}
	public OpcijaSadrzaj getSadrzaj() {
		return sadrzaj;
	}
	
	public Izvjestaji getIzvjestaj() {
		return izvjestaji;
	}

}
