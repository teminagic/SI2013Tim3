package ba.co.edgewise.jmup.mvc.views;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		this.setVisible(true);
		
		meni =  new MeniBoss();
		GridBagConstraints gbc_meni = new GridBagConstraints();
		gbc_meni.fill = GridBagConstraints.VERTICAL;
		gbc_meni.insets = new Insets(0, 5, 0, 5);
		contentPane.add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("Početna");
		gbc_naslov = new GridBagConstraints();
		gbc_naslov.anchor = GridBagConstraints.NORTH;
		gbc_naslov.fill = GridBagConstraints.HORIZONTAL;
		
		strana1 = new NaslovnaMenadzer();
		strana1.getLblDobrodoslice().setText("Dobrodo\u0161ao/la!");
		sadrzaj.getPanelSadrzaj().add(strana1, "Po\u010Detna");
		
		strana2 = new SalterskaPretraga();
		sadrzaj.getPanelSadrzaj().add(strana2, "Pretraga");
		
		strana3 = new Izvjestaji();
		sadrzaj.getPanelSadrzaj().add(strana3, "Izvje\u0161taji");
		
		strana5 = new PregledLogova();
		sadrzaj.getPanelSadrzaj().add(strana5, "Pregled historije promjena");
		
		izvjestaji = new Izvjestaji();
		sadrzaj.getPanelSadrzaj().add(izvjestaji, "Izrada izvje\u0161taja");
		
		contentPane.add(sadrzaj, gbc_naslov);

	}

	public void prikaziPocetnu(){
		frejm.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Početna");
	}
	public void prikaziPretragu() {
		frejm.getSadrzaj().getNaslov().postaviNaslov("Pretraga");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Pretraga");
	}
	
	public void prikaziIzvjestaje(){
		frejm.getSadrzaj().getNaslov().postaviNaslov("Izvje\u0161taji");
		JPanel cards = frejm.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout)cards.getLayout();
		tmp.show(cards, "Izvještaji");
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
