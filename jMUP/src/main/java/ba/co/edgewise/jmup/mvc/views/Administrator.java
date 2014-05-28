package ba.co.edgewise.jmup.mvc.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.MeniAdminOpcije;
import ba.co.edgewise.jmup.components.NaslovnaAdministrator;
import ba.co.edgewise.jmup.components.OpcijaNaslov;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Administrator extends JFrame {

	private JPanel contentPane;
	private MeniAdminOpcije meni;
	private OpcijaSadrzaj sadrzaj;
	private NaslovnaAdministrator strana1;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Administrator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{0.0,1.0};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gridBagLayout);
		this.setVisible(true);
		
		meni =  new MeniAdminOpcije();
		GridBagConstraints gbc_meni = new GridBagConstraints();
		gbc_meni.anchor = GridBagConstraints.NORTH;
		gbc_meni.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("Poćetna");
		GridBagConstraints gbc_naslov = new GridBagConstraints();
		gbc_naslov.anchor = GridBagConstraints.NORTH;
		gbc_naslov.fill = GridBagConstraints.HORIZONTAL;
		
		strana1 = new NaslovnaAdministrator();
		//
		sadrzaj.getPanelSadrzaj().add(strana1, "Početna");
		
		contentPane.add(sadrzaj, gbc_naslov);
		
		
	}

	public NaslovnaAdministrator getStrana1() {
		return strana1;
	}
}
