package ba.co.edgewise.jmup.mvc.views;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.*;

public class BossView extends JFrame {

	private JPanel contentPane;
	private MeniBoss meni;
	private OpcijaSadrzaj sadrzaj;
	private Izvjestaji izvjestaji;
	private NaslovnaMenadzer strana1;
	private SalterskaPretraga strana2;
	private Izvjestaji strana3;
	private PregledLogova strana5;
	
	GridBagConstraints gbc_naslov;
	GridBagConstraints gbc_meni;
	
	
	private final BossView frejm = this;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public BossView() {
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
		
		meni =  new MeniBoss();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) meni.getLayout();
		gridBagLayout_1.columnWidths = new int[]{107};
		gbc_meni = new GridBagConstraints();
		gbc_meni.anchor = GridBagConstraints.NORTH;
		gbc_meni.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("PoÄ�etna");
		gbc_naslov = new GridBagConstraints();
		gbc_naslov.anchor = GridBagConstraints.NORTH;
		gbc_naslov.fill = GridBagConstraints.HORIZONTAL;
		
		strana1 = new NaslovnaMenadzer();
		sadrzaj.getPanelSadrzaj().add(strana1, "PoÄ�etna");
		
		strana2 = new SalterskaPretraga();
		sadrzaj.getPanelSadrzaj().add(strana2, "Pretraga");
		
		strana3 = new Izvjestaji();
		sadrzaj.getPanelSadrzaj().add(strana3, "IzvjeÅ¡taji");
		
		strana5 = new PregledLogova();
		sadrzaj.getPanelSadrzaj().add(strana5, "Pregled historije promjena");
		
		izvjestaji = new Izvjestaji();
		sadrzaj.getPanelSadrzaj().add(izvjestaji, "Izrada izvještaja");
		
		contentPane.add(sadrzaj, gbc_naslov);

	}

	public void prikaziPocetnu(){
		frejm.getSadrzaj().getNaslov().postaviNaslov("PoÄ�etna");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "PoÄ�etna");
	}
	public void prikaziPretragu() {
		frejm.getSadrzaj().getNaslov().postaviNaslov("Pretraga");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Pretraga");
	}
	
	public void prikaziIzvjestaje(){
		frejm.getSadrzaj().getNaslov().postaviNaslov("IzvjeÅ¡taji");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "IzvjeÅ¡taji");
	}
	
	public JPanel getContentPane() {
		return contentPane;///
	}


	public MeniBoss getMeni() {
		return meni;
	}


	public NaslovnaMenadzer getPocetna() {
		return strana1;
	}
	
	public Izvjestaji getStrana3() {
		return strana3;
	}
	public OpcijaSadrzaj getSadrzaj() {
		return sadrzaj;
	}
	
	public PregledLogova getStrana5() {
		return strana5;
	}
	
	public GridBagConstraints getGbc_naslov() {
		return gbc_naslov;
	}
	public GridBagConstraints getGbc_meni() {
		return gbc_meni;
	}

	public SalterskaPretraga getStrana2() {
		return strana2;
	}
	
	public Izvjestaji getIzvjestaj() {
		 		return izvjestaji;
		 	}

	public Object getVoziloModifikacija() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
