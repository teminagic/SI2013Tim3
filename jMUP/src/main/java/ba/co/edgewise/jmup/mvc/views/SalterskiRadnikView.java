package ba.co.edgewise.jmup.mvc.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.MeniSalter;
import ba.co.edgewise.jmup.components.MeniSalterOpcije;
import ba.co.edgewise.jmup.components.NaslovnaSalterski;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.VozacDodavanje;

public class SalterskiRadnikView extends JFrame {

	private JPanel contentPane;
	private MeniSalter meni;
	private NaslovnaSalterski strana1; // bit ce ih vise zavisno od buttona
	private OpcijaSadrzaj sadrzaj;
	
	GridBagConstraints gbc_naslov;
	GridBagConstraints gbc_meni;
	
	private VozacDodavanje strana2VozacDodavanje;
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
		gridBagLayout_1.columnWidths = new int[]{176};
		gbc_meni = new GridBagConstraints();
		gbc_meni.anchor = GridBagConstraints.NORTH;
		gbc_meni.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("Početna");
		gbc_naslov = new GridBagConstraints();
		gbc_naslov.anchor = GridBagConstraints.NORTH;
		gbc_naslov.fill = GridBagConstraints.HORIZONTAL;
		
		strana1 = new NaslovnaSalterski();
		//
		sadrzaj.getPanelSadrzaj().add(strana1, "Početna");
		
		contentPane.add(sadrzaj, gbc_naslov);
		
		// na pocetku je na null
		strana2VozacDodavanje = null;
		
	}
	public void prikaziVozacDodavanje()
	{
		contentPane.remove(sadrzaj);
		
		sadrzaj = new OpcijaSadrzaj("Unos vozača");
		strana2VozacDodavanje = new VozacDodavanje();
		//
		sadrzaj.getPanelSadrzaj().add(strana2VozacDodavanje, "Unos podataka o vozaču");
		
		contentPane.add(sadrzaj, gbc_naslov);
	}
	public JPanel getContentPane() {
		return contentPane;///
	}


	public MeniSalter getMeni() {
		return meni;
	}


	public NaslovnaSalterski getStrana1() {
		return strana1;
	}


	public OpcijaSadrzaj getSadrzaj() {
		return sadrzaj;
	}
	
	public VozacDodavanje getStrana2VozacDodavanje() {
		return strana2VozacDodavanje;
	}
	
	public GridBagConstraints getGbc_naslov() {
		return gbc_naslov;
	}
	public GridBagConstraints getGbc_meni() {
		return gbc_meni;
	}
}
