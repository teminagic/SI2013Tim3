package ba.co.edgewise.jmup.components;
//
import javax.swing.*;
import java.awt.*;

public class MeniNaslov extends JPanel {

	private static final long serialVersionUID = 8333914907953449725L;
	private GridBagLayout gridBagLayoutMeniNaslov;
	private JLabel lblNaslov;
	private  JLabel lblPodnaslov;

	public MeniNaslov() {
		layoutSet();
		lblSet();
	}
	public void lblSet(){
		JLabel lblNaslov = new JLabel("jMUP");
		lblNaslov.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_lblNaslov = new GridBagConstraints();
		gbc_lblNaslov.anchor = GridBagConstraints.SOUTH;
		gbc_lblNaslov.insets = new Insets(0, 0, 5, 0);
		gbc_lblNaslov.gridx = 0;
		gbc_lblNaslov.gridy = 1;
		add(lblNaslov, gbc_lblNaslov);
		
		JLabel lblPodnaslov = new JLabel("<html><center>Sistem za evidenciju <br>saobra\u0107ajnih i<br>vlasni\u010Dkih dozvola</center></html>");
		GridBagConstraints gbc_lblPodnaslov = new GridBagConstraints();
		gbc_lblPodnaslov.anchor = GridBagConstraints.NORTH;
		gbc_lblPodnaslov.insets = new Insets(0, 0, 5, 0);
		gbc_lblPodnaslov.gridx = 0;
		gbc_lblPodnaslov.gridy = 2;
		add(lblPodnaslov, gbc_lblPodnaslov);
	}
	public void layoutSet(){
		gridBagLayoutMeniNaslov = new GridBagLayout();
		gridBagLayoutMeniNaslov.columnWidths = new int[]{0, 0};
		gridBagLayoutMeniNaslov.rowHeights = new int[]{10, 0, 0, 10, 0};
		gridBagLayoutMeniNaslov.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayoutMeniNaslov.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutMeniNaslov);
	}
	public GridBagLayout getGridBagLayoutMeniNaslov() {
		return gridBagLayoutMeniNaslov;
	}
	public JLabel getLblNaslov() {
		return lblNaslov;
	}
	public JLabel getLblPodnaslov() {
		return lblPodnaslov;
	}

}
