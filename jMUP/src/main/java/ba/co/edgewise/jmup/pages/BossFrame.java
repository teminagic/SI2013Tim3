package ba.co.edgewise.jmup.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.MeniBoss;
import ba.co.edgewise.jmup.components.NaslovnaMenadzer;
import ba.co.edgewise.jmup.components.NotYetImplemented;
import ba.co.edgewise.jmup.components.OpcijaSadrzaj;
import ba.co.edgewise.jmup.components.SalterskaPretraga;
import ba.co.edgewise.jmup.components.*;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BossFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4904937810899811384L;
	private JPanel contentPane;
	private MeniBoss meni;
	private OpcijaSadrzaj sadrzaj;
	private BossFrame frame = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BossFrame frame = new BossFrame();
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
	public BossFrame() {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		setMinimumSize(new Dimension(900, 600));
		setTitle("Početna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		
		meni = new MeniBoss();
		meni.getOpcije().getBtnOdjava().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login nframe = new Login();
				nframe.setVisible(true);
			}
		});
		meni.getOpcije().getBtnPregledLogova().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Historijat");
				sadrzaj.getNaslov().postaviNaslov("Historijat");
			}
		});
		meni.getOpcije().getBtnIzradaIzvjetaja().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Izvještaji");
				sadrzaj.getNaslov().postaviNaslov("Izvještaji");
			}
		});
		meni.getOpcije().getBtnPretraga().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)sadrzaj.getPanelSadrzaj().getLayout();
				cl.show(sadrzaj.getPanelSadrzaj(), "Pretraga");
				sadrzaj.getNaslov().postaviNaslov("Pretraga");
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
		gbc_meni.insets = new Insets(0, 0, 0, 5);
		gbc_meni.gridx = 0;
		gbc_meni.gridy = 0;
		gbc_meni.fill = GridBagConstraints.BOTH;
		getContentPane().add(meni, gbc_meni);
		
		sadrzaj = new OpcijaSadrzaj("Početna");
		GridBagLayout gridBagLayout_1 = (GridBagLayout) sadrzaj.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0, 1.0};
		gridBagLayout_1.rowHeights = new int[]{0, 0};
		gridBagLayout_1.columnWeights = new double[]{1.0};
		gridBagLayout_1.columnWidths = new int[]{0};
		GridBagLayout gridBagLayout = (GridBagLayout) sadrzaj.getNaslov().getLayout();
		gridBagLayout.rowWeights = new double[]{1.0};
		gridBagLayout.rowHeights = new int[]{50};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.columnWidths = new int[]{10, 0, 0};
		GridBagConstraints gbc_opcijaSadrzaj = new GridBagConstraints();
		gbc_opcijaSadrzaj.fill = GridBagConstraints.BOTH;
		gbc_opcijaSadrzaj.gridx = 1;
		gbc_opcijaSadrzaj.gridy = 0;
		contentPane.add(sadrzaj, gbc_opcijaSadrzaj);
		
		sadrzaj.getPanelSadrzaj().add(new NaslovnaMenadzer(), "Početna");
		sadrzaj.getPanelSadrzaj().add(new NotYetImplemented(), "Historijat");
		sadrzaj.getPanelSadrzaj().add(new SalterskaPretraga(), "Pretraga");
		sadrzaj.getPanelSadrzaj().add(new Izvjestaji(), "Izvještaji");
		
	}

}
