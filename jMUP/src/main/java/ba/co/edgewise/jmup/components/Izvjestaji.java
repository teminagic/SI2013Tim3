package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

//import ba.co.edgewise.jmup.components.SalterskaPretraga;


import ba.co.edgewise.components.helpers.ShowDialogInput;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class Izvjestaji extends JPanel {

	private static final long serialVersionUID = 6215975225870721504L;
	private GridBagLayout gridBagLayout;
	private JPanel panel_1;
	private JLabel label;
	private JLabel label_1;
	private JButton btnKreiranjeIzvjestaja1;
	private JButton btnKreiranjeIzvjestaja2;

	public Izvjestaji() {
		layoutSet();
		panelSet();
		labelSet();
		buttonSet();
		componenteSet();
	}

	public void layoutSet() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 639, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 85, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}

	public void labelSet() {
		label_1 = new JLabel("Kreiranje izvje\u0161taja o broju i tipu izdatih dozvola:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 2;
		panel_1.add(label_1, gbc_label_1);

		label = new JLabel("Kreiranje izvje\u0161taja o isteklim registracijama:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		panel_1.add(label, gbc_label);	
	}

	public void buttonSet() {

		btnKreiranjeIzvjestaja1 = new JButton("Kreiraj izvještaj");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		panel_1.add(btnKreiranjeIzvjestaja1, gbc_button);

		btnKreiranjeIzvjestaja2 = new JButton("Kreiraj izvještaj");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.anchor = GridBagConstraints.NORTH;
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 2;
		panel_1.add(btnKreiranjeIzvjestaja2, gbc_button_1);

		//action listeners
		btnKreiranjeIzvjestaja1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ShowDialogInput dialog = new ShowDialogInput("Unesite lokaciju za spremanje izvje\u0161taja:", 1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnKreiranjeIzvjestaja2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ShowDialogInput dialog = new ShowDialogInput("Unesite lokaciju za spremanje izvje\u0161taja:", 2);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public void componenteSet() {
	}


	public void panelSet() {

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Izrada izvje\u0161taja", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));

		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);

		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{56, 252, 42, 161, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 23, 23, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

	}

	public JButton getBtnKreiranjeIzvjestaja1() {
		return btnKreiranjeIzvjestaja1;
	}

	public JButton getBtnKreiranjeIzvjestaja2() {
		return btnKreiranjeIzvjestaja2;
	}


}
