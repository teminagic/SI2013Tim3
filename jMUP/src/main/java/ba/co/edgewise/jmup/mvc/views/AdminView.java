package ba.co.edgewise.jmup.mvc.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.KorisnikKreiranje;
import ba.co.edgewise.jmup.components.KorisnikModificiranje;
import ba.co.edgewise.jmup.components.KorisnikPretraga;
import ba.co.edgewise.jmup.components.MeniAdmin;
import ba.co.edgewise.jmup.components.NaslovnaAdministrator;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.PregledLogova;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AdminView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5872926787361619013L;
	private JPanel contentPane;
	private MeniAdmin meni;
	private OpcijaSadrzaj sadrzaj;
	private NaslovnaAdministrator strana1;
	private KorisnikKreiranje strana2;
	private KorisnikPretraga strana3;
	private KorisnikModificiranje strana4;
	private PregledLogova strana5;

	public AdminView() {
		initialize();
		
		meni =  new MeniAdmin();
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
		
		strana1 = new NaslovnaAdministrator();
		sadrzaj.getPanelSadrzaj().add(strana1, "Po\u010Detna");
		
		strana2 = new KorisnikKreiranje();
		sadrzaj.getPanelSadrzaj().add(strana2, "Dodavanje korisnika");
		
		strana3 = new KorisnikPretraga();
		sadrzaj.getPanelSadrzaj().add(strana3, "Pretraga korisnika");
		
		strana4 = new KorisnikModificiranje();
		sadrzaj.getPanelSadrzaj().add(strana4, "Modificiranje korisnika");
		
		strana5 = new PregledLogova();
		sadrzaj.getPanelSadrzaj().add(strana5, "Pregled historije promjena");
		
		contentPane.add(sadrzaj, gbc_sadrzaj);	
	}
	
	public void initialize(){
		setTitle("jMUP - Administrator");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
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

	public NaslovnaAdministrator getStrana1() {
		return strana1;
	}
	public KorisnikKreiranje getStrana2() {
		return this.strana2;
	}
	public MeniAdmin getMeni() {
		return meni;
	}
	public OpcijaSadrzaj getSadrzaj() {
		return sadrzaj;
	}
	public KorisnikPretraga getStrana3() {
		return strana3;
	}
	public KorisnikModificiranje getStrana4() {
		return strana4;
	}
	public PregledLogova getStrana5() {
		return strana5;
	}
}
