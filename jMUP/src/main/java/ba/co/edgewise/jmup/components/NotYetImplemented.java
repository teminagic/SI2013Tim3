package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;

public class NotYetImplemented extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1530697042309313527L;

	/**
	 * Create the panel.
	 */
	public NotYetImplemented() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNijeImplementirano = new JLabel("Nije Implementirano");
		lblNijeImplementirano.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNijeImplementirano = new GridBagConstraints();
		gbc_lblNijeImplementirano.fill = GridBagConstraints.VERTICAL;
		gbc_lblNijeImplementirano.gridx = 0;
		gbc_lblNijeImplementirano.gridy = 0;
		add(lblNijeImplementirano, gbc_lblNijeImplementirano);

	}

}
