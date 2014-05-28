package ba.co.edgewise.jmup.pages;

import javax.swing.*;

import java.awt.*;

import javax.swing.border.*;

import ba.co.edgewise.jmup.components.MeniAdmin;
import ba.co.edgewise.jmup.components.NaslovnaAdministrator;
import ba.co.edgewise.jmup.components.NotYetImplemented;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4351674167930828182L;
	
	private JPanel contentPane;
	private MeniAdmin meni;
	private OpcijaSadrzaj sadrzaj;
	private AdminFrame frame = this;
	KorisnikModificiranje modifikacija; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		setMinimumSize(new Dimension(900, 600));
		setTitle("Početna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		
		meni = new MeniAdmin();
		meni.getOpcije().getBtnOdjava().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login nframe = new Login();
				nframe.setVisible(true);
			}
		});
		meni.getOpcije().getBtnIzradaBackupa().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Backup");
				sadrzaj.getNaslov().postaviNaslov("Backup");
			}
		});
		meni.getOpcije().getBtnPregledLogova().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Historijat");
				sadrzaj.getNaslov().postaviNaslov("Historijat");
			}
		});
		meni.getOpcije().getBtnPretragaKorisnika().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Pretraga korisnika");
				sadrzaj.getNaslov().postaviNaslov("Pretraga korisnika");
			}
		});
		meni.getOpcije().getBtnPocetna().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Pocetna");
				sadrzaj.getNaslov().postaviNaslov("Početna");
			}
		});
		meni.getOpcije().getBtnStrana().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Kreiranje korisnika");
				sadrzaj.getNaslov().postaviNaslov("Kreiranje korisnika");
			}
		});
		GridBagConstraints gbc_meni = new GridBagConstraints();
		gbc_meni.fill = GridBagConstraints.BOTH;
		gbc_meni.insets = new Insets(0, 0, 0, 5);
		gbc_meni.gridx = 0;
		gbc_meni.gridy = 0;
		contentPane.add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("Početna");
		GridBagLayout gridBagLayout = (GridBagLayout) sadrzaj.getLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.columnWidths = new int[]{0};
		GridBagConstraints gbc_opcijaSadrzaj = new GridBagConstraints();
		gbc_opcijaSadrzaj.fill = GridBagConstraints.BOTH;
		gbc_opcijaSadrzaj.gridx = 1;
		gbc_opcijaSadrzaj.gridy = 0;
		sadrzaj.getPanelSadrzaj().add(new NaslovnaAdministrator(), "Pocetna");
		sadrzaj.getPanelSadrzaj().add(new KorisnikKreiranje(), "Kreiranje korisnika");
		KorisnikPretraga pretraga = new KorisnikPretraga();
		pretraga.setParrent(this);
		sadrzaj.getPanelSadrzaj().add(pretraga, "Pretraga korisnika");
		sadrzaj.getPanelSadrzaj().add(new NotYetImplemented(), "Historijat");
		sadrzaj.getPanelSadrzaj().add(new NotYetImplemented(), "Backup");
		contentPane.add(sadrzaj, gbc_opcijaSadrzaj);
		
	}

	public KorisnikModificiranje getModifikacija() {
		return modifikacija;
	}

	public void setModifikacija(KorisnikModificiranje modifikacija) {
		this.modifikacija = modifikacija;
	}

	public OpcijaSadrzaj getSadrzaj() {
		return sadrzaj;
	}
}
