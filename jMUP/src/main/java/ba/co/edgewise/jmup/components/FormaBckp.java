package ba.co.edgewise.jmup.components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class FormaBckp extends JPanel {
	private static final long serialVersionUID = 1845055252320341895L;
	
	
	private JButton btnIzradaBackupa;
	private JButton btnRestoreBackupa;

	/**
	 * Create the panel.
	 */
	public FormaBckp() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 20, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblZaKreiranjeNovog = new JLabel("Za kreiranje novog backupa pritisnite dugme ispod:");
		GridBagConstraints gbc_lblZaKreiranjeNovog = new GridBagConstraints();
		gbc_lblZaKreiranjeNovog.insets = new Insets(0, 0, 5, 5);
		gbc_lblZaKreiranjeNovog.gridx = 1;
		gbc_lblZaKreiranjeNovog.gridy = 1;
		add(lblZaKreiranjeNovog, gbc_lblZaKreiranjeNovog);
		
		btnIzradaBackupa = new JButton("Izrada backupa");
		GridBagConstraints gbc_btnIzradaBackupa = new GridBagConstraints();
		gbc_btnIzradaBackupa.fill = GridBagConstraints.BOTH;
		gbc_btnIzradaBackupa.insets = new Insets(0, 0, 5, 5);
		gbc_btnIzradaBackupa.gridx = 1;
		gbc_btnIzradaBackupa.gridy = 2;
		add(btnIzradaBackupa, gbc_btnIzradaBackupa);
		
		JLabel lblDaBiSte = new JLabel("Da bi ste vratili na neko od predhodnih stanja pritisnite dugme ispod:");
		GridBagConstraints gbc_lblDaBiSte = new GridBagConstraints();
		gbc_lblDaBiSte.insets = new Insets(0, 0, 5, 5);
		gbc_lblDaBiSte.gridx = 1;
		gbc_lblDaBiSte.gridy = 4;
		add(lblDaBiSte, gbc_lblDaBiSte);
		
		btnRestoreBackupa = new JButton("Povratak na predhodno stanje");
		GridBagConstraints gbc_btnRestoreBackupa = new GridBagConstraints();
		gbc_btnRestoreBackupa.fill = GridBagConstraints.BOTH;
		gbc_btnRestoreBackupa.insets = new Insets(0, 0, 5, 5);
		gbc_btnRestoreBackupa.gridx = 1;
		gbc_btnRestoreBackupa.gridy = 5;
		add(btnRestoreBackupa, gbc_btnRestoreBackupa);
		
		JLabel lblNapomena = new JLabel("<html><center>Napomena: Da bi ste mogli vratiti na neko od predhodnih stanja, <br/>"
				+ "prvo morate izraditi backup</center></html>");
		GridBagConstraints gbc_lblNapomenaDaBi = new GridBagConstraints();
		gbc_lblNapomenaDaBi.insets = new Insets(0, 0, 5, 5);
		gbc_lblNapomenaDaBi.gridx = 1;
		gbc_lblNapomenaDaBi.gridy = 7;
		add(lblNapomena, gbc_lblNapomenaDaBi);

	}

	public JButton getBtnIzradaBackupa() {
		return btnIzradaBackupa;
	}
	public JButton getBtnRestoreBackupa() {
		return btnRestoreBackupa;
	}
}
