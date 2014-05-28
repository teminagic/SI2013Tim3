package ba.co.edgewise.jmup.components;
//
import javax.swing.*;

import java.awt.*;

import javax.swing.border.*;

public class OpcijaNaslov extends JPanel {

	private static final long serialVersionUID = 5899393425634055396L;
	private JLabel lblNaslov;
	private GridBagLayout gridBagLayoutOpcijaNaslov;

	public OpcijaNaslov(String naslov) {	
		setLayout();
		setLabel(naslov);		
	}

	public void setLayout(){
		setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		gridBagLayoutOpcijaNaslov = new GridBagLayout();
		gridBagLayoutOpcijaNaslov.columnWidths = new int[]{10, 0, 0, 0};
		gridBagLayoutOpcijaNaslov.rowHeights = new int[]{50, 0};
		gridBagLayoutOpcijaNaslov.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutOpcijaNaslov.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutOpcijaNaslov);
	}
	public void setLabel(String naslov){
		lblNaslov = new JLabel(naslov);
		lblNaslov.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNaslov = new GridBagConstraints();
		gbc_lblNaslov.insets = new Insets(0, 0, 0, 5);
		gbc_lblNaslov.gridx = 1;
		gbc_lblNaslov.gridy = 0;
		add(lblNaslov, gbc_lblNaslov);
	}
	public void postaviNaslov(String naslov) {
		lblNaslov.setText(naslov);
	}
	public GridBagLayout getGridBagLayoutOpcijaNaslov() {
		return gridBagLayoutOpcijaNaslov;
	}
}
