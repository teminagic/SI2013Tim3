package ba.co.edgewise.jmup.mvc.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.MeniSalter;
import ba.co.edgewise.jmup.components.NaslovnaSalterski;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.RegistracijaUnos;
import ba.co.edgewise.jmup.components.VozacDodavanje;
import ba.co.edgewise.jmup.components.VoziloDodavanje;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SalterskiRadnikView extends JFrame {

	// Private fields
	private static final long serialVersionUID = -4800877726084719057L;
	private JPanel contentPane;

	private MeniSalter meni;
	private OpcijaSadrzaj sadrzaj;

	private NaslovnaSalterski strana1;
	private VozacDodavanje strana2;
	private VoziloDodavanje strana3;
	private VozacDodavanje strana4;
	private VoziloDodavanje strana5;
	private RegistracijaUnos strana6;

	// Constructors
	public SalterskiRadnikView() {
		initialize();
		setPanels();
	}

	// Private methods
	private void initialize() {
		setTitle("jMUP - \u0160alter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		this.setVisible(true);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0 };
		gbl_contentPane.rowHeights = new int[] { 0 };
		gbl_contentPane.columnWeights = new double[] { 0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
	}

	private void setPanels() {
		meni = new MeniSalter();
		GridBagConstraints gbc_meni = new GridBagConstraints();
		gbc_meni.fill = GridBagConstraints.VERTICAL;
		gbc_meni.insets = new Insets(0, 5, 0, 5);
		contentPane.add(meni, gbc_meni);

		sadrzaj = new OpcijaSadrzaj("Po\u010Detna");
		GridBagConstraints gbc_sadrzaj = new GridBagConstraints();
		gbc_sadrzaj.fill = GridBagConstraints.BOTH;
		gbc_sadrzaj.insets = new Insets(0, 0, 0, 5);
		contentPane.add(sadrzaj, gbc_sadrzaj);

		strana1 = new NaslovnaSalterski();
		sadrzaj.getPanelSadrzaj().add(strana1, "Po\u010Detna");

		strana2 = new VozacDodavanje();
		sadrzaj.getPanelSadrzaj().add(strana2, "Unos voza\u010Da");

		strana3 = new VoziloDodavanje();
		sadrzaj.getPanelSadrzaj().add(strana3, "Unos vozila");
		
		strana4 = new VozacDodavanje();
		sadrzaj.getPanelSadrzaj().add(strana4, "Unos vlasnika - Vlasnička dozvola");
		
		strana5 = new VoziloDodavanje();
		sadrzaj.getPanelSadrzaj().add(strana5, "Unos vozila - Vlasnička dozvola");
		
		strana6 = new RegistracijaUnos();
		sadrzaj.getPanelSadrzaj().add(strana6, "Unos ovjere registracije - Vlasnička dozvola");
	}

	// public methods

	// Getters
	public MeniSalter getMeni() {
		return meni;
	}

	public OpcijaSadrzaj getSadrzaj() {
		return sadrzaj;
	}

	public NaslovnaSalterski getStrana1() {
		return strana1;
	}

	public VozacDodavanje getStrana2() {
		return strana2;
	}

	public VoziloDodavanje getStrana3() {
		return strana3;
	}

	public VozacDodavanje getStrana4() {
		return strana4;
	}
	public VoziloDodavanje getStrana5() {
		return strana5;
	}
	public RegistracijaUnos getStrana6() {
		return strana6;
	}
}