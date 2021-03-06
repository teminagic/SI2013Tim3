package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;

public class RegistracijaUnos extends JPanel {


	private static final long serialVersionUID = 6117393292522385475L;
	private PodaciRegistracija podaci;
	private GridBagLayout gridBagLayout;
	private JPanel panel;
	private JButton btnPrihvati;
	private JButton btnPoniti;

	public RegistracijaUnos() {
		setLayout();
		setPanel();
		setComponents();
	}
	public void setLayout(){
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 219, 132, 108, 0, 0};
		gridBagLayout.rowHeights = new int[]{40, 440, 29, 68, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
	public void setPanel(){
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
	}
	public void setComponents(){
		podaci = new PodaciRegistracija();
		GridBagLayout gridBagLayout_2 = (GridBagLayout) podaci.getDatumVazenja().getLayout();
		gridBagLayout_2.columnWeights = new double[]{0.0, 0.0, 1.0};
		GridBagLayout gridBagLayout_1 = (GridBagLayout) podaci.getLayout();
		gridBagLayout_1.columnWidths = new int[]{0, 0, 267, 0, 0};
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0};
		gridBagLayout_1.rowHeights = new int[]{0, 0, 0, 0, 226};
		gridBagLayout_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		GridBagConstraints gbc_podaci = new GridBagConstraints();
		gbc_podaci.gridwidth = 3;
		gbc_podaci.fill = GridBagConstraints.HORIZONTAL;
		gbc_podaci.insets = new Insets(0, 0, 5, 5);
		gbc_podaci.gridx = 1;
		gbc_podaci.gridy = 1;
		add(podaci, gbc_podaci);
		
		btnPrihvati = new JButton("Prihvati");
		GridBagConstraints gbc_btnPrihvati = new GridBagConstraints();
		gbc_btnPrihvati.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPrihvati.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrihvati.gridx = 2;
		gbc_btnPrihvati.gridy = 2;
		add(btnPrihvati, gbc_btnPrihvati);
		
		btnPoniti = new JButton("Poništi");
		GridBagConstraints gbc_btnPoniti = new GridBagConstraints();
		gbc_btnPoniti.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPoniti.insets = new Insets(0, 0, 5, 5);
		gbc_btnPoniti.gridx = 3;
		gbc_btnPoniti.gridy = 2;
		add(btnPoniti, gbc_btnPoniti);

	}
	public JButton getBtnPrihvati() {
		return btnPrihvati;
	}
	public JButton getBtnPoniti() {
		return btnPoniti;
	}
	public PodaciRegistracija getPodaci() {
		return podaci;
	}
	public JPanel getPanel() {
		return panel;
	}

}
