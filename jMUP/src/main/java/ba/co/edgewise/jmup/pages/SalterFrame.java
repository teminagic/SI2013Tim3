package ba.co.edgewise.jmup.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.MeniSalter;
import ba.co.edgewise.jmup.components.NaslovnaSalterski;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.PromjenaVlasnikaVozila;
import ba.co.edgewise.jmup.components.RegistracijaUnos;
import ba.co.edgewise.jmup.components.SalterskaPretraga;
import ba.co.edgewise.jmup.components.VozacDodavanje;
import ba.co.edgewise.jmup.components.VoziloDodavanje;
import ba.co.edgewise.jmup.components.*;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalterFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 50592714165411871L;
	private JPanel contentPane;
	private MeniSalter meni;
	private OpcijaSadrzaj sadrzaj;
	SalterFrame frame = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalterFrame frame = new SalterFrame();
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
	public SalterFrame() {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		setMinimumSize(new Dimension(900, 600));
		setTitle("Početna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{192, 449, 0};
		gbl_contentPane.rowHeights = new int[]{489, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		meni = new MeniSalter();
		meni.getOpcije().getBtnOdjava().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login nframe = new Login();
				nframe.setVisible(true);
			}
		});
		meni.getOpcije().getBtnIzvjestaji().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Izvještaji");
				sadrzaj.getNaslov().postaviNaslov("Izrada izvještaja");
			}
		});
		meni.getOpcije().getBtnPromjenaVlasnika().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Promjena");
				sadrzaj.getNaslov().postaviNaslov("Promjena");
			}
		});
		meni.getOpcije().getBtnOvjera().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Ovjera");
				sadrzaj.getNaslov().postaviNaslov("Godišnja ovjera registracije");
			}
		});
		meni.getOpcije().getBtnPretraga().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Pretraga");
				sadrzaj.getNaslov().postaviNaslov("Pretraga");
			}
		});
		meni.getOpcije().getbtnUnosSaobracajne().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Saobraćajna dodavanje vozača");
				sadrzaj.getNaslov().postaviNaslov("Unos saobraćajne dozvole - dodavanje vozača");
			}
		});
		meni.getOpcije().getBtnUnosVlasnicke().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Vlasnička dodavanje vozača");
				sadrzaj.getNaslov().postaviNaslov("Unos vlasničke dozvole - dodavanje vozača");
			}
		});
		meni.getOpcije().getBtnUnosVozila().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Dodavanje vozila");
				sadrzaj.getNaslov().postaviNaslov("Dodavanje vozila");
			}
		});
		meni.getOpcije().getBtnUnosVozaca().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Dodavanje vozača");
				sadrzaj.getNaslov().postaviNaslov("Dodavanje vozača");
			}
		});
		meni.getOpcije().getBtnPocetna().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Početna");
				sadrzaj.getNaslov().postaviNaslov("Početna");
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
		gridBagLayout.columnWeights = new double[]{1.0};
		GridBagConstraints gbc_sadrzaj = new GridBagConstraints();
		gbc_sadrzaj.fill = GridBagConstraints.BOTH;
		gbc_sadrzaj.gridx = 1;
		gbc_sadrzaj.gridy = 0;
		contentPane.add(sadrzaj, gbc_sadrzaj);
		
		sadrzaj.getPanelSadrzaj().add(new NaslovnaSalterski(), "Početna");
		sadrzaj.getPanelSadrzaj().add(new VozacDodavanje(), "Dodavanje vozača");
		sadrzaj.getPanelSadrzaj().add(new VoziloDodavanje(), "Dodavanje vozila");
		
		VozacDodavanje unosVlasnickeVozac = new VozacDodavanje();
		unosVlasnickeVozac.getBtnPrihvati().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Vlasnička dodavanje vozila");
				sadrzaj.getNaslov().postaviNaslov("Unos vlasničke dozvole - dodavanje vozila");
			}
		});
		sadrzaj.getPanelSadrzaj().add(unosVlasnickeVozac, "Vlasnička dodavanje vozača");
		
		VoziloDodavanje unosVlasnickeVozilo = new VoziloDodavanje();
		unosVlasnickeVozilo.getBtn_prihvati().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Vlasnička upis registracije");
				sadrzaj.getNaslov().postaviNaslov("Unos vlasničke dozvole - upis registracije");
			}
		});
		sadrzaj.getPanelSadrzaj().add(unosVlasnickeVozilo, "Vlasnička dodavanje vozila");
		
		sadrzaj.getPanelSadrzaj().add(new RegistracijaUnos(), "Vlasnička upis registracije");
		
		VozacDodavanje unosSaobracajneVozac = new VozacDodavanje();
		unosSaobracajneVozac.getBtnPrihvati().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Saobraćajna dodavanje vozila");
				sadrzaj.getNaslov().postaviNaslov("Unos saobraćajne dozvole - dodavanje vozila");
			}
		});
		sadrzaj.getPanelSadrzaj().add(unosSaobracajneVozac, "Saobraćajna dodavanje vozača");
		
		VoziloDodavanje unosSaobracajneVozilo = new VoziloDodavanje();
		unosSaobracajneVozilo.getBtn_prihvati().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Saobraćajna upis registracije");
				sadrzaj.getNaslov().postaviNaslov("Unos saobraćajne dozvole - upis registracije");
			}
		});
		sadrzaj.getPanelSadrzaj().add(unosSaobracajneVozilo, "Saobraćajna dodavanje vozila");
		
		sadrzaj.getPanelSadrzaj().add(new RegistracijaUnos(), "Saobraćajna upis registracije");
		
		sadrzaj.getPanelSadrzaj().add(new RegistracijaUnos(), "Saobraćajna upis registracije");
		
		sadrzaj.getPanelSadrzaj().add(new SalterskaPretraga(), "Pretraga");
		
		sadrzaj.getPanelSadrzaj().add(new GodisnjaOvjera(), "Ovjera");
		
		sadrzaj.getPanelSadrzaj().add(new PromjenaVlasnikaVozila(), "Promjena");
		
		sadrzaj.getPanelSadrzaj().add(new Izvjestaji(), "Izvještaji");
	}

}
