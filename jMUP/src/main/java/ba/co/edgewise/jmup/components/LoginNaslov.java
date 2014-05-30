package ba.co.edgewise.jmup.components;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class LoginNaslov extends JPanel {

	private static final long serialVersionUID = 4639842669739229489L;
	private JPanel panel;
	private JLabel lblNaslov;
	private JLabel lblPodNaslov;
	// nesto
	public LoginNaslov() {
		
		setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		panelSet();
		labelSet();
	}

	public void panelSet() {
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 20, 50, 24, 20, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
	}
	
	public void labelSet() {
		
		lblNaslov = new JLabel("jMUP");
		lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 50));
		GridBagConstraints gbc_lblNaslov = new GridBagConstraints();
		gbc_lblNaslov.anchor = GridBagConstraints.SOUTH;
		gbc_lblNaslov.insets = new Insets(0, 0, 5, 0);
		gbc_lblNaslov.gridx = 0;
		gbc_lblNaslov.gridy = 1;
		panel.add(lblNaslov, gbc_lblNaslov);
		
		lblPodNaslov = new JLabel(
				"Sistem za evidenciju saobra\u0107ajnih i vlasni\u010Dkih dozvola");
		lblPodNaslov.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPodNaslov = new GridBagConstraints();
		gbc_lblPodNaslov.insets = new Insets(0, 0, 5, 0);
		gbc_lblPodNaslov.anchor = GridBagConstraints.NORTH;
		gbc_lblPodNaslov.gridx = 0;
		gbc_lblPodNaslov.gridy = 2;
		panel.add(lblPodNaslov, gbc_lblPodNaslov);
	}
	
}
